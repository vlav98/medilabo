package com.oc.medilabo.controller;

import com.oc.medilabo.bean.Patient;
import com.oc.medilabo.proxy.PatientProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PatientController {
    @Autowired
    public PatientProxy patientProxy;

    @GetMapping("/patients")
    public String getAllPatients(Model model) {
        List<Patient> patients = patientProxy.getAllPatients();
        model.addAttribute("patients", patients);
        return "patients/index";
    }

    @GetMapping("/patients/{id}")
    public String getPatientInformation(Model model, @PathVariable("id") int id){
        Patient patient = patientProxy.getPatientById(id);
        model.addAttribute("patient", patient);

        return "patients/patient";
    }

    @GetMapping("/patients/add")
    public String showAddPatientForm(Model model){
        model.addAttribute("patient", new Patient());
        return "patients/add";
    }

    @PostMapping("/patients/add")
    public String addNewPatient(Model model, Patient patient){
        patientProxy.createNewPatient(patient);
        return "patients/index";
    }

    @GetMapping("/patients/update/{id}")
    public String showUpdatePatientForm(Model model,@PathVariable("id") int id){
        Patient patient = patientProxy.getPatientById(id);
        model.addAttribute("patient", patient);
        return "patients/update";
    }

    @PostMapping("/patients/update/{id}")
    public String updatePatient(Model model, Patient patient,
                                BindingResult result, @PathVariable("id") int id){
        if (result.hasErrors()) {
            return "patients/update";
        }
        patientProxy.updatePatient(id, patient);

        return "patients/index";
    }
}
