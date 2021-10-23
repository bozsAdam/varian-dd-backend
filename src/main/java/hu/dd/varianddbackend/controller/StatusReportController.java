package hu.dd.varianddbackend.controller;

import hu.dd.varianddbackend.model.StatusReport;
import hu.dd.varianddbackend.repository.StatusReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;

@RestController
public class StatusReportController {
    @Autowired
    private StatusReportRepository statusRepository;

    @GetMapping("/statusreport/list")
    public List<StatusReport> getAllStatusReports()
    {
        return statusRepository.findAll();
    }

    @GetMapping("/statusreport/{id}")
    public StatusReport getStatusReport(@PathVariable("id") Long id)
    {
        return statusRepository.findById(id).orElseThrow(()-> {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Patient with this id does not exist"
            );
        });
    }

    @PostMapping("/statusreport/add")
    public void addStatusReport(@RequestBody StatusReport statusReport)
    {
        statusReport.setDate(new Date(System.currentTimeMillis()));
        statusRepository.save(statusReport);
    }
}
