package com.olehprukhnytskyi.macrotrackerbffservice.controller;

import com.olehprukhnytskyi.macrotrackerbffservice.dto.DashboardDto;
import com.olehprukhnytskyi.macrotrackerbffservice.service.DashboardService;
import com.olehprukhnytskyi.macrotrackerbffservice.util.CustomHeaders;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/dashboard")
public class DashboardController {
    private final DashboardService dashboardService;

    @GetMapping
    public ResponseEntity<DashboardDto> getDashboard(
            @RequestHeader(CustomHeaders.X_USER_ID) Long userId) {
        DashboardDto dashboard = dashboardService.getDashboard(userId);
        return ResponseEntity.ok().body(dashboard);
    }
}
