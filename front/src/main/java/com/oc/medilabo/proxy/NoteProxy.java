package com.oc.medilabo.proxy;

import com.oc.medilabo.bean.Note;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.math.BigInteger;
import java.util.List;

@FeignClient(name = "notes", url = "${gateway.url}" + "/notes")
public interface NoteProxy {
    @GetMapping("/all")
    List<Note> getAllNotes();

    @GetMapping("/{patientId}")
    List<Note> getNotesByPatientId(@PathVariable BigInteger patientId);

    @PostMapping()
    Note createNewNote(Note note);
}
