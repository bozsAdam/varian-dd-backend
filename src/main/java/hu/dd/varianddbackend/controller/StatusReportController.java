package hu.dd.varianddbackend.controller;

import hu.dd.varianddbackend.model.StatusReport;
import hu.dd.varianddbackend.repository.StatusReportRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;

@RestController
@Slf4j
public class StatusReportController {
    @Autowired
    private StatusReportRepository statusRepository;

    @GetMapping("/statusreport/list")
    public List<StatusReport> getAllStatusReports()
    {
        log.info("Listing all status reports");
        return statusRepository.findAll();
    }

    @GetMapping("/statusreport/{id}")
    public StatusReport getStatusReport(@PathVariable("id") Long id)
    {
        log.info(String.format("Showing statusreport with id: %s", id));
        return statusRepository.findById(id).orElseThrow(()-> {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Patient with this id does not exist"
            );
        });
    }

    @PostMapping("/statusreport/add")
    public void addStatusReport(@RequestBody StatusReport statusReport)
    {
        log.info("saving statusreport");
        log.debug(statusReport.toString());
        statusReport.setDate(new Date(System.currentTimeMillis()));
        statusRepository.save(statusReport);
    }
}
