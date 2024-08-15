DROP TABLE patients CASCADE;

CREATE TABLE patients (
   patientId int PRIMARY KEY NOT NULL AUTO_INCREMENT,
   firstName varchar(255) NOT NULL,
   lastName varchar(255) NOT NULL,
   birthDate DATE NOT NULL,
   gender varchar(1) NOT NULL,
   postalAddress varchar(255),
   phoneNumber varchar(20)
);
