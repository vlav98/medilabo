package com.oc.medilabo.proxy;

import com.oc.medilabo.bean.enums.RiskLevel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigInteger;

@FeignClient(name = "medilabo-risk-report", url = "${gateway.url}" + "/risk-report")
public interface RiskReportProxy {
    @GetMapping("/{id}")
    RiskLevel getPatientRiskLevel(@PathVariable BigInteger id);
}
