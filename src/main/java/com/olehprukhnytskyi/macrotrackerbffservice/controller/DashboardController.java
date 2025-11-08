package com.olehprukhnytskyi.macrotrackerbffservice.controller;

import com.olehprukhnytskyi.macrotrackerbffservice.dto.DashboardDto;
import com.olehprukhnytskyi.macrotrackerbffservice.service.DashboardService;
import com.olehprukhnytskyi.macrotrackerbffservice.util.CustomHeaders;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/dashboard")
@Tag(
        name = "Dashboard API",
        description = "API for aggregating and retrieving user nutrition dashboard data"
)
public class DashboardController {
    private final DashboardService dashboardService;

    @Operation(
            summary = "Aggregate dashboard data",
            description = "Combines user goals (calories, proteins, fats, carbs) "
                    + "with list of daily nutrition intakes")
    @GetMapping
    public Mono<ResponseEntity<DashboardDto>> getDashboard(
            @RequestHeader(CustomHeaders.X_USER_ID) Long userId) {
        return dashboardService.getDashboard(userId)
                .map(ResponseEntity::ok);
    }
}
