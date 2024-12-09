# 1. Gradle 빌드 환경을 위한 베이스 이미지
FROM gradle:7.5.1-jdk-alpine AS build
WORKDIR /app

# 2. Gradle 관련 파일 복사 (의존성 캐싱을 위해)
COPY build.gradle settings.gradle /app/

# 3. Gradle 의존성 다운로드
RUN gradle dependencies --no-daemon || true

# 4. 전체 소스 코드 복사
COPY . .

# 5. Gradle 빌드 실행 (테스트 생략)
RUN chmod +x ./gradlew && ./gradlew clean build -x test

# 6. 최종 이미지를 위한 OpenJDK 이미지
FROM openjdk:17-jdk-slim
WORKDIR /app

# 7. 빌드된 JAR 파일 복사 (명확하게 이름 지정)
COPY build/libs/backend-0.0.1-SNAPSHOT.jar app.jar

# 8. 환경 설정 파일 복사
COPY application.yml /config/application.yml

# 9. Spring Boot 애플리케이션 실행
ENTRYPOINT ["java", "-jar", "/app.jar", "--spring.config.additional-location=/config/application.yml"]
