package com.olehprukhnytskyi.macrotrackerbffservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDate;
import lombok.Data;

@Data
@Schema(description = "Food intake record")
public class IntakeDto {
    @Schema(description = "Intake record ID", example = "1")
    private Long id;

    @Schema(description = "Name of consumed food", example = "Chicken Breast")
    private String foodName;

    @Schema(description = "Amount consumed in grams", example = "200")
    private int amount;

    @Schema(description = "Date of consumption", example = "2024-01-15")
    private LocalDate date;

    @Schema(description = "Nutritional values")
    private NutrimentsDto nutriments = new NutrimentsDto();
}
