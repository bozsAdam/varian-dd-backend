package hu.dd.varianddbackend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Priority {
    LOW("low"),
    MEDIUM("medium"),
    HIGH("high");

    String priority;
}
