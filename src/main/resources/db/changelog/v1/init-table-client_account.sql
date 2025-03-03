--liquibase formatted sql logicalFilePath:db/changelog/v1
-- changeset author:NWMXask-3

INSERT INTO client_account(first_name, last_name, email, password, phone_number, date_of_birth, account_balance, active, created_at, updated_at, account_rating, account_type)
VALUES ('John', 'Doe', 'john.doe@example.com', 'password123', '+1234567890', '1980-01-01', 1000.00, true, NOW(), NOW(), 4.5, 'BASE'),
       ('Jane', 'Doe', 'jane.doe@example.com', 'password123', '+1234567891', '1985-02-02', 2000.00, true, NOW(), NOW(), 4.0, 'PREMIUM'),
       ('Jim', 'Beam', 'jim.beam@example.com', 'password123', '+1234567892', '1990-03-03', 1500.00, true, NOW(), NOW(), 3.5, 'BASE'),
       ('Jack', 'Daniels', 'jack.daniels@example.com', 'password123', '+1234567893', '1995-04-04', 2500.00, true, NOW(), NOW(), 4.8, 'PREMIUM'),
       ('Johnny', 'Walker', 'johnny.walker@example.com', 'password123', '+1234567894', '1988-05-05', 3000.00, true, NOW(), NOW(), 4.2, 'BASE'),
       ('Jameson', 'Irish', 'jameson.irish@example.com', 'password123', '+1234567895', '1992-06-06', 3500.00, true, NOW(), NOW(), 4.7, 'PREMIUM'),
       ('Jose', 'Cuervo', 'jose.cuervo@example.com', 'password123', '+1234567896', '1983-07-07', 4000.00, true, NOW(), NOW(), 4.1, 'BASE'),
       ('Jackie', 'Chan', 'jackie.chan@example.com', 'password123', '+1234567897', '1979-08-08', 4500.00, true, NOW(), NOW(), 4.6, 'PREMIUM'),
       ('Bruce', 'Lee', 'bruce.lee@example.com', 'password123', '+1234567898', '1981-09-09', 5000.00, true, NOW(), NOW(), 4.9, 'BASE'),
       ('Chuck', 'Norris', 'chuck.norris@example.com', 'password123', '+1234567899', '1984-10-10', 5500.00, true, NOW(), NOW(), 5.0, 'PREMIUM');