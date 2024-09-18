package com.oc.medilabo.controller;

import com.oc.medilabo.bean.Note;
import com.oc.medilabo.bean.Patient;
import com.oc.medilabo.bean.enums.RiskLevel;
import com.oc.medilabo.proxy.NoteProxy;
import com.oc.medilabo.proxy.PatientProxy;
import com.oc.medilabo.proxy.RiskReportProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.math.BigInteger;
import java.util.List;

@Controller
public class PatientController {
    @Autowired
    public PatientProxy patientProxy;
    @Autowired
    public NoteProxy noteProxy;
    @Autowired
    public RiskReportProxy riskReportProxy;

    @GetMapping("/patients")
    public String getAllPatients(Model model) {
        List<Patient> patients = patientProxy.getAllPatients();
        model.addAttribute("patients", patients);
        return "patients/index";
    }

    @GetMapping("/patients/{id}")
    public String getPatientInformation(Model model, @PathVariable("id") BigInteger id){
        Patient patient = patientProxy.getPatientById(id);
        List<Note> notes = noteProxy.getNotesByPatientId(id);
        RiskLevel patientRiskLevel = riskReportProxy.getPatientRiskLevel(id);
        model.addAttribute("patient", patient);
        model.addAttribute("notes", notes);
        model.addAttribute("patientRiskLevel", patientRiskLevel);
        Note newNote = new Note();
        newNote.setPatientId(id);
        newNote.setPatient(patient.getLastName());
        model.addAttribute("newNote", newNote);

        return "patients/patient";
    }

    @GetMapping("/patients/add")
    public String showAddPatientForm(Model model){
        model.addAttribute("patient", new Patient());
        return "patients/add";
    }

    @PostMapping("/patients/add")
    public String addNewPatient(Patient patient){
        patientProxy.createNewPatient(patient);
        return "redirect:/patients";
    }

    @GetMapping("/patients/update/{id}")
    public String showUpdatePatientForm(Model model,@PathVariable("id") BigInteger id){
        Patient patient = patientProxy.getPatientById(id);
        model.addAttribute("patient", patient);
        return "patients/update";
    }

    @PostMapping("/patients/update/{id}")
    public String updatePatient(Patient patient,
                                BindingResult result, @PathVariable("id") BigInteger id){
        if (result.hasErrors()) {
            return "patients/update";
        }
        patientProxy.updatePatient(id, patient);

        return "redirect:/patients";
    }
}
