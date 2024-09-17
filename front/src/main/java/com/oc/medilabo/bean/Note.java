package com.oc.medilabo.bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
@NoArgsConstructor
public class Note {
    private String noteId;
    private BigInteger patientId;
    private String patient;
    private String content;
    private String createdAt;
}
