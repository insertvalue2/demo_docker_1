# demo_docker_1

도커 강의 2편(Dockerfile) 4부 실습용 Spring Boot 프로젝트입니다. Java 21, H2 메모리 DB, SMS 키를 환경 변수로 받는 SmsApiClient가 들어 있습니다.

이 저장소는 실습 시작 상태입니다. Dockerfile과 .dockerignore는 교안 12페이지 3·4번에서 직접 만듭니다.

## 키 파일 준비

.env는 Git에 올리지 않습니다. .env.example을 복사해 연습용 값을 채웁니다.

```powershell
Copy-Item .env.example .env
```

```text
SMS_API_KEY=12345
SMS_API_SECRET=abc12345
```

## 실습 순서 (교안 12페이지)

```powershell
./gradlew clean build -x test
New-Item Dockerfile        # 세 줄 작성
New-Item .dockerignore     # .env 한 줄 작성
docker build -t demo-docker-1 .
docker run -d -p 8080:8080 --name blog demo-docker-1                  # 키가 없어 Exited (1)
docker rm -f blog
docker run -d -p 8080:8080 --env-file .env --name blog demo-docker-1  # 정상 실행
```
