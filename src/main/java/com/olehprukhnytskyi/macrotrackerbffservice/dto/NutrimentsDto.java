package com.olehprukhnytskyi.macrotrackerbffservice.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.olehprukhnytskyi.macrotrackerbffservice.util.BigDecimalJsonSerializer;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import lombok.Data;

@Data
@Schema(description = "Nutritional values for food intake")
public class NutrimentsDto {
    @Schema(
            description = "Calories content",
            example = "165.5",
            type = "number",
            format = "decimal"
    )
    @JsonSerialize(using = BigDecimalJsonSerializer.class)
    private BigDecimal calories = BigDecimal.ZERO;

    @Schema(
            description = "Fat content in grams",
            example = "3.2",
            type = "number",
            format = "decimal"
    )
    @JsonSerialize(using = BigDecimalJsonSerializer.class)
    private BigDecimal fat = BigDecimal.ZERO;

    @Schema(
            description = "Protein content in grams",
            example = "31.0",
            type = "number",
            format = "decimal"
    )
    @JsonSerialize(using = BigDecimalJsonSerializer.class)
    private BigDecimal protein = BigDecimal.ZERO;

    @Schema(
            description = "Carbohydrates content in grams",
            example = "0.0",
            type = "number",
            format = "decimal"
    )
    @JsonSerialize(using = BigDecimalJsonSerializer.class)
    private BigDecimal carbohydrates = BigDecimal.ZERO;
}
