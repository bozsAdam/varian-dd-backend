package hu.dd.varianddbackend.repository;

import hu.dd.varianddbackend.model.StatusReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusReportRepository extends JpaRepository<StatusReport, Long> {
}
