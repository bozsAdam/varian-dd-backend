package hu.dd.varianddbackend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

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
    private Date diagnosisYear;
    private Integer stage;
    private TreatmentType treatmentType;
}
