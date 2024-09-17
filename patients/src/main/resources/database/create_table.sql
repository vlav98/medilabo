DROP TABLE patients CASCADE;

CREATE TABLE patients
(
    patient_id     BIGINT       NOT NULL PRIMARY KEY AUTO_INCREMENT,
    first_name     VARCHAR(255) NOT NULL,
    last_name      VARCHAR(255) NOT NULL,
    birth_date     date         NOT NULL,
    gender         VARCHAR(255) NOT NULL,
    postal_address VARCHAR(255) NULL,
    phone_number   VARCHAR(255) NULL
);
