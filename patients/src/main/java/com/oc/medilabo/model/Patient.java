package com.oc.medilabo.model;

import com.oc.medilabo.model.enums.Gender;
import com.oc.medilabo.validators.BirthDate;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private BigInteger patientId;
    @NotBlank
    @Column(name = "first_name")
    private String firstName;
    @NotBlank
    @Column(name = "last_name")
    private String lastName;
    @NotNull
    @BirthDate
    @Column(name = "birth_date")
    private LocalDate birthDate;
    @NotNull
    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;
    // both properties below are optional
    @Column(name = "postal_address")
    private String postalAddress;
    @Column(name = "phone_number")
    private String phoneNumber;
    
    public Patient() {

    }
}
