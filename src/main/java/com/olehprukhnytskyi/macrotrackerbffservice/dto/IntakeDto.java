package com.olehprukhnytskyi.macrotrackerbffservice.dto;

import java.time.LocalDate;
import lombok.Data;

@Data
public class IntakeDto {
    private Long id;
    private String foodName;
    private int amount;
    private LocalDate date;
    private NutrimentsDto nutriments = new NutrimentsDto();
}
