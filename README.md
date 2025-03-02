# Настройка Grafana

### Reference Documentation

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