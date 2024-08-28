package com.oc.medilabosolutions.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigInteger;
import java.time.LocalDate;

@Getter
@Setter
@Document(collection = "notes")
public class Note {
    @Id
    @Indexed(unique = true)
    private BigInteger noteId;
    @Field("patientId")
    @Indexed(unique = true)
    private BigInteger patientId;
    private String patient;
    private String content;
    private LocalDate createdAt;
}
