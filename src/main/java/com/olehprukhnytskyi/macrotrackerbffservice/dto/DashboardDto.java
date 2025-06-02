package com.olehprukhnytskyi.macrotrackerbffservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DashboardDto {
    private UserGoalDto goal;
    private PagedResponse<IntakeDto> intakes;
}
