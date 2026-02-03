package com.member.exception;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(NotFoundException e) {
        log.error("[ERROR] {}", e.getMessage(), e); // 스택트레이스 포함
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse("NOT_FOUND", e.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleAny(Exception e, HttpServletRequest request) {

        // Actuator 요청은 GlobalExceptionHandler에서 잡지 않도록 제외
        String uri = request.getRequestURI();
        if (uri != null && uri.startsWith("/actuator")) {
            throw new RuntimeException(e); // 예외를 다시 던져서 Actuator가 원래 방식대로 처리하게 함
        }

        log.error("[ERROR] unexpected", e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorResponse("INTERNAL_ERROR", "unexpected error"));
    }

    public static class ErrorResponse {
        public final String code;
        public final String message;

        public ErrorResponse(String code, String message) {
            this.code = code;
            this.message = message;
        }
    }
}