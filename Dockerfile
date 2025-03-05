FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/financial-service-0.0.1-SNAPSHOT.jar app.jar

# Добавляем очистку кэша apt
RUN apt-get update && \
    apt-get install -y --no-install-recommends && \
    rm -rf /var/lib/apt/lists/*

# Отдельная инструкция для ENTRYPOINT
ENTRYPOINT ["java", "-jar", "app.jar"]

EXPOSE 8061