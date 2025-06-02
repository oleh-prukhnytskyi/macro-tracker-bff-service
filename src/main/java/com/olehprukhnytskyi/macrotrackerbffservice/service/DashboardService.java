package com.olehprukhnytskyi.macrotrackerbffservice.service;

import com.olehprukhnytskyi.macrotrackerbffservice.client.IntakeClient;
import com.olehprukhnytskyi.macrotrackerbffservice.client.UserClient;
import com.olehprukhnytskyi.macrotrackerbffservice.dto.DashboardDto;
import com.olehprukhnytskyi.macrotrackerbffservice.dto.IntakeDto;
import com.olehprukhnytskyi.macrotrackerbffservice.dto.PagedResponse;
import com.olehprukhnytskyi.macrotrackerbffservice.dto.UserGoalDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DashboardService {
    private final IntakeClient intakeClient;
    private final UserClient userClient;

    public DashboardDto getDashboard(Long userId) {
        UserGoalDto userGoal = userClient.getUserGoal(userId);
        PagedResponse<IntakeDto> intakes = intakeClient.getIntakes(userId);
        return DashboardDto.builder()
                .goal(userGoal)
                .intakes(intakes)
                .build();
    }
}
