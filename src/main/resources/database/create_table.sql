DROP TABLE patients CASCADE;
DROP TABLE notes CASCADE;

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

CREATE TABLE notes
(
    note_id     BIGINT                NOT NULL AUTO_INCREMENT PRIMARY KEY,
    content     VARCHAR(255)          NOT NULL,
    added_at    date                  NOT NULL,
    patient_id  BIGINT                NOT NULL
);

ALTER TABLE notes
    ADD CONSTRAINT FK_NOTES_ON_PATIENT FOREIGN KEY (patient_id) REFERENCES patients (patient_id);
