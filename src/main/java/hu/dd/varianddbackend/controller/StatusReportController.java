package hu.dd.varianddbackend.controller;

import hu.dd.varianddbackend.model.StatusReport;
import hu.dd.varianddbackend.repository.PatientRepository;
import hu.dd.varianddbackend.repository.StatusReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StatusReportController {
    @Autowired
    private StatusReportRepository statusRepository;

    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/statusreport/list")
    public List<StatusReport> getAllStatusReports()
    {
        return statusRepository.findAll();
    }

    @PostMapping("/statusreport/add")
    public void addStatusReport(StatusReport statusReport)
    {
        statusRepository.save(statusReport);
    }
}
