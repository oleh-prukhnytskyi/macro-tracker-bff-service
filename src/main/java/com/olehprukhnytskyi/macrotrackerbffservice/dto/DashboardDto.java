package com.olehprukhnytskyi.macrotrackerbffservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Schema(description = "User nutrition goals and paginated intake history")
public class DashboardDto {
    @Schema(description = "User daily nutrition targets")
    private UserGoalDto goal;

    @Schema(description = "Paginated list of food intake records")
    private PagedResponse<IntakeDto> intakes;
}
