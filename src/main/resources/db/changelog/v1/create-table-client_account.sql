--liquibase formatted sql
-- changeset author:NWMXask-1

CREATE TABLE client_account (
                                id BIGSERIAL PRIMARY KEY,
                                first_name VARCHAR(50) NOT NULL,
                                last_name VARCHAR(50) NOT NULL,
                                email VARCHAR(255) UNIQUE NOT NULL,
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

-- changeset author:NWMXask-2
CREATE INDEX idx_client_account_email ON client_account(email);