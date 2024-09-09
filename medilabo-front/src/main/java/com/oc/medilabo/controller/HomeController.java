package com.oc.medilabo.controller;

import com.oc.medilabo.bean.Patient;
import com.oc.medilabo.proxy.PatientProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    public PatientProxy patientProxy;

    @GetMapping("/")
    public String getHomePage(Model model) {
        List<Patient> patients = patientProxy.getAllPatients();
        model.addAttribute("patients", patients);
        return "redirect:/patients";
    }

}
