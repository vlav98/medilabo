package com.oc.medilabosolutions.model;

import com.oc.medilabosolutions.model.enums.Gender;
import com.oc.medilabosolutions.validators.BirthDate;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "patientId")
    private BigInteger patientId;
    @NotBlank
    @Column(name = "firstName")
    private String firstName;
    @NotBlank
    @Column(name = "lastName")
    private String lastName;
    @NotNull
    @BirthDate
    @Column(name = "birthDate")
    private LocalDate birthDate;
    @NotNull
    @Column(name = "gender")
    private Gender gender;
    // both properties below are optional
    @Column(name = "postalAddress")
    private String postalAddress;
    @Column(name = "phoneNumber")
    private String phoneNumber;

    public Patient() {
    }

    public Patient(String firstName, String lastName, LocalDate birthDate, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.gender = gender;
    }
}
