package hu.dd.varianddbackend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class StatusReport {
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    private Patient patient;

    private String image;
    @ElementCollection
    private List<String> symptomAreas;
    @ElementCollection
    private List<String> lifestyleAreas;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private Date date;
    private Priority priority;
}
