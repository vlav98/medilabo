package com.oc.medilabo.bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class Note {
    private BigInteger noteId;
    private BigInteger patientId;
    private String patient;
    private String content;
    private LocalDate createdAt;
}
