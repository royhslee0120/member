# LV 0 - 요금 폭탄 방지 AWS Budget 설정
<img width="2558" height="1232" alt="image" src="https://github.com/user-attachments/assets/a7e31594-7e73-4349-b8f3-5fe9c49196da" />

# LV 1 - 네트워크 구축 및 핵심 기능 배포

## 1) 기능
- 팀원 정보 저장 API
  - `POST /api/members`
- 팀원 정보 조회 API
  - `GET /api/members/{id}`
- Actuator Health Check
  - `GET /actuator/health`

## 2) 실행 환경
- Local Profile: H2
- Prod Profile: MySQL(MariaDB)

## 3) 배포 정보 (EC2)
- EC2 Public IP: **3.36.58.154**
- Health Check URL: **http://3.36.58.154:8080/actuator/health**
- Expected Response:
  ```json
  {"status":"UP"}
