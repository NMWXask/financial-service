#### Предварительные требования
Убедитесь, что у вас установлены следующие инструменты:
- [Docker](https://www.docker.com/get-started)
- [Docker Compose](https://docs.docker.com/compose/install/)

### Локальный запуск в Docker
docker-compose up --build

### Проверьте, что все сервисы запущены:

Приложение: http://localhost:8061
Prometheus: http://localhost:9090
Grafana: http://localhost:4000

# Настройка Grafana

#### Откройте Grafana:

1. Перейдите в браузере по адресу [http://localhost:4000](http://localhost:4000).
2. Войдите в систему с именем пользователя `admin` и паролем `admin`.

#### Добавьте источник данных Prometheus:

1. Перейдите в "Configuration" -> "Data Sources".
2. Нажмите "Add data source".
3. Выберите "Prometheus".
4. В поле URL введите `http://prometheus:9090`.
5. Нажмите "Save & Test".

#### Создайте дашборд:

1. Перейдите в "Create" -> "Dashboard".
2. Нажмите "Add new panel".
3. В поле "Metrics" введите `client_account_requests_total`.
4. Настройте график по вашему усмотрению.
5. Сохраните дашборд.

#### Пример конфигурации дашборда:

1. Добавление панели:
    - В поле "Query" введите `client_account_requests_total`.
    - Настройте визуализацию (например, график или счетчик).
2. Сохранение дашборда:
    - Нажмите "Save dashboard".
    - Дайте имя вашему дашборду и нажмите "Save".

### Reference Documentation

- Коллекция запросов Postman [postman/financial.postman_collection.json](postman/financial.postman_collection.json).
- Файл с запросами в корне проекта из IDE  [requests.http]