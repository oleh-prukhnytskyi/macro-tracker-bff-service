package com.olehprukhnytskyi.macrotrackerbffservice.service;

import com.olehprukhnytskyi.macrotrackerbffservice.dto.DashboardDto;
import com.olehprukhnytskyi.macrotrackerbffservice.dto.IntakeDto;
import com.olehprukhnytskyi.macrotrackerbffservice.dto.PagedResponse;
import com.olehprukhnytskyi.macrotrackerbffservice.dto.UserGoalDto;
import com.olehprukhnytskyi.macrotrackerbffservice.util.CustomHeaders;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class DashboardService {
    private final WebClient userWebClient;
    private final WebClient intakeWebClient;

    public Mono<DashboardDto> getDashboard(Long userId) {
        Mono<UserGoalDto> userGoalMono = userWebClient.get()
                .uri("/api/profile/goal")
                .header(CustomHeaders.X_USER_ID, userId.toString())
                .retrieve()
                .bodyToMono(UserGoalDto.class);
        Mono<PagedResponse<IntakeDto>> intakesMono = intakeWebClient.get()
                .uri("/api/intake")
                .header(CustomHeaders.X_USER_ID, userId.toString())
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<>() {});
        return Mono.zip(
                Objects.requireNonNull(userGoalMono),
                Objects.requireNonNull(intakesMono)
        ).map(tuple -> DashboardDto.builder()
                .goal(tuple.getT1())
                .intakes(tuple.getT2())
                .build());
    }
}
