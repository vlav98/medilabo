package com.oc.medilabosolutions.model;

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
@Table(name = "notes")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "note_id")
    private BigInteger noteId;
    @NotBlank
    @Column(name = "content")
    private String content;
    @NotNull
    @Column(name = "added_at")
    private LocalDate addedAt;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
}
