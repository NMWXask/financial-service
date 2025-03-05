--liquibase formatted sql
--changeset nwmxask:1.0.0-create-table-client_account failOnError:true

CREATE TABLE IF NOT EXISTS client_account (
                                id SERIAL PRIMARY KEY,
                                first_name VARCHAR(50) NOT NULL,
                                last_name VARCHAR(50) NOT NULL,
                                email VARCHAR(255) NOT NULL UNIQUE,
                                password VARCHAR(100) NOT NULL,
                                phone_number VARCHAR(20),
                                date_of_birth DATE,
                                account_balance NUMERIC(12, 2),
                                active BOOLEAN,
                                created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                updated_at TIMESTAMP,
                                account_rating DOUBLE PRECISION CHECK (account_rating >= 0 AND account_rating <= 5),
                                account_type VARCHAR(50) NOT NULL
);

-- Добавление ограничений для проверки формата данных
ALTER TABLE client_account
    ADD CONSTRAINT chk_phone_number CHECK (phone_number ~ '^\\+?[0-9\\-\\s()]*$'),
    ADD CONSTRAINT chk_date_of_birth CHECK (date_of_birth < CURRENT_DATE);