FROM gradle:jdk21-jammy as builder

WORKDIR /app

COPY . .

RUN gradle build --no-daemon -x test

FROM amazoncorretto:21-alpine3.18

COPY --from=builder /app/build/libs/*.jar /app/app.jar

CMD ["java", "-jar", "/app/app.jar"]
