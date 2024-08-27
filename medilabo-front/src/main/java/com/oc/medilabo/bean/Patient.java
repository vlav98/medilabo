package com.oc.medilabo.bean;

import com.oc.medilabo.bean.enums.Gender;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class Patient {
    private BigInteger patientId;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private Gender gender;
    // both properties below are optional
    private String postalAddress;
    private String phoneNumber;
}
