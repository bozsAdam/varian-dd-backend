package hu.dd.varianddbackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Patient {
    @Id
    @GeneratedValue
    private long id;

    private String doctor;
    private String name;
    private String phoneNumber;
    private String email;
    private String cancerType;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private Date diagnosisYear;
    private Integer stage;
    private TreatmentType treatmentType;

    @OneToMany(mappedBy = "patient")
    @JsonBackReference
    private List<StatusReport> statusReports;
}
