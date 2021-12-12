# BUILD CONTEXT NEEDS TO BE SET TO THE PROJECT ROOT
FROM gradle:jdk11 as builder
USER root
WORKDIR /builder
COPY  ./build.gradle.kts /builder
COPY  ./settings.gradle.kts /builder
COPY  ./auth-service /builder/auth-service
RUN gradle :auth-service:build --stacktrace --no-daemon

FROM openjdk:11-jre-slim
WORKDIR /app
EXPOSE 8761
COPY --from=builder /builder/auth-service/build/libs/auth-service-0.0.1.jar .
CMD ["java", "-jar", "auth-service-0.0.1.jar"]
