package com.oc.medilabosolutions.model;

import com.oc.medilabosolutions.model.enums.Gender;
import com.oc.medilabosolutions.validators.BirthDate;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;

@Getter
@Setter
@Document(collection = "patients")
public class Patient {
    @Id
    @Indexed(unique = true)
    private BigInteger patient_id;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotNull
    @BirthDate
    private String birthDate;
    @NotNull
    private Gender gender;
    // both properties below are optional
    private String postalAddress;
    private String phoneNumber;

    public Patient(String firstName, String lastName, String birthDate, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.gender = gender;
    }
}
