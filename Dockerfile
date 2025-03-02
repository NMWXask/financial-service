# Используем официальный образ OpenJDK в качестве базового образа
FROM openjdk:17-jdk-slim

# Устанавливаем рабочую директорию внутри контейнера
WORKDIR /app

# Копируем файл jar вашего приложения в контейнер
COPY target/financial-service-0.0.1-SNAPSHOT.jar app.jar

# Устанавливаем переменную окружения для указания порта
ENV SERVER_PORT=8061

# Открываем порт
EXPOSE 8061

# Команда для запуска вашего приложения
ENTRYPOINT ["java", "-jar", "app.jar"]