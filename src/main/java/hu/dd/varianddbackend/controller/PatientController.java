package hu.dd.varianddbackend.controller;

import hu.dd.varianddbackend.model.Patient;
import hu.dd.varianddbackend.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class PatientController {
    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/patient/list")
    public List<Patient> getAllPatients()
    {
        return patientRepository.findAll();
    }

    @GetMapping("/patient/{id}")
    public Patient getPatientById(@PathVariable("id") Long id)
    {
        return patientRepository.findById(id).orElseThrow(()-> {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Patient with this id does not exist"
            );
        });
    }
}
