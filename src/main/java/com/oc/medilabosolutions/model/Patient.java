package com.oc.medilabosolutions.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.oc.medilabosolutions.model.enums.Gender;
import com.oc.medilabosolutions.validators.BirthDate;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

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
    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Note> notes;

    public Patient(String firstName, String lastName, LocalDate birthDate, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    public Patient() {

    }
}
