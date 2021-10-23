package hu.dd.varianddbackend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TreatmentType {
    RADIATION_THERAPY("radiation therapy"),
    CHEMOTHERAPY("chemotherapy"),
    SURGICAL("surgical");

    String treatmentType;
}
