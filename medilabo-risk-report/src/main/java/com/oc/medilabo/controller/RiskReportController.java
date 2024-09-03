package com.oc.medilabo.controller;

import com.oc.medilabo.model.RiskLevel;
import com.oc.medilabo.service.RiskReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@RestController
@RequestMapping("/risk-report")
public class RiskReportController {
    @Autowired
    RiskReportService riskReportService;

    @GetMapping("/{id}")
    public RiskLevel getRiskReport(@PathVariable("id") BigInteger id) {
        return riskReportService.getRiskLevel(id);
    }
}
