package com.olehprukhnytskyi.macrotrackerbffservice.service;

import com.olehprukhnytskyi.macrotrackerbffservice.dto.DashboardDto;
import com.olehprukhnytskyi.macrotrackerbffservice.dto.IntakeDto;
import com.olehprukhnytskyi.macrotrackerbffservice.dto.PagedResponse;
import com.olehprukhnytskyi.macrotrackerbffservice.dto.UserGoalDto;
import com.olehprukhnytskyi.macrotrackerbffservice.util.CustomHeaders;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class DashboardService {
    private final WebClient userWebClient;
    private final WebClient intakeWebClient;

    public Mono<DashboardDto> getDashboard(Long userId) {
        log.debug("Fetching dashboard data for userId={}", userId);
        Mono<UserGoalDto> userGoalMono = userWebClient.get()
                .uri("/api/profile/goal")
                .header(CustomHeaders.X_USER_ID, userId.toString())
                .retrieve()
                .bodyToMono(UserGoalDto.class)
                .doOnError(e -> log.error("Failed to fetch user goals for userId={}", userId, e));
        Mono<PagedResponse<IntakeDto>> intakesMono = intakeWebClient.get()
                .uri("/api/intake")
                .header(CustomHeaders.X_USER_ID, userId.toString())
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<PagedResponse<IntakeDto>>() {})
                .doOnError(e -> log.error("Failed to fetch intakes for userId={}", userId, e));
        return Mono.zip(userGoalMono, intakesMono)
                .map(tuple -> {
                    DashboardDto dto = DashboardDto.builder()
                            .goal(tuple.getT1())
                            .intakes(tuple.getT2())
                            .build();
                    log.debug("Successfully built dashboard DTO for userId={}", userId);
                    return dto;
                })
                .doOnError(e -> log
                        .error("Error combining dashboard data for userId={}", userId, e));
    }
}
