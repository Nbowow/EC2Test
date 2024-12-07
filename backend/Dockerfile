# 1. Java 17 기반 이미지 사용
FROM openjdk:17-jdk-slim

# 2. 작업 디렉토리 설정
WORKDIR /app

# 3. 소스 코드 복사
COPY . .
COPY application.yml src/main/resources/application.yml

# 4. Gradle 빌드 실행
RUN gradle clean build --no-daemon --stacktrace

# 5. 빌드 결과 JAR 파일을 실행하도록 설정
ENTRYPOINT ["java", "-jar", "build/libs/app.jar"]
