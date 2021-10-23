package hu.dd.varianddbackend.repository;

import hu.dd.varianddbackend.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
