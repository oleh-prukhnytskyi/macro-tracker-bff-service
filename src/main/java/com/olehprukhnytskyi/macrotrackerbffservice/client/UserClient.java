package com.olehprukhnytskyi.macrotrackerbffservice.client;

import com.olehprukhnytskyi.macrotrackerbffservice.dto.UserGoalDto;
import com.olehprukhnytskyi.macrotrackerbffservice.util.CustomHeaders;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "user-service", url = "${feign.user-service:http://localhost:8081}")
public interface UserClient {
    @GetMapping("/api/profile/goal")
    UserGoalDto getUserGoal(@RequestHeader(CustomHeaders.X_USER_ID) Long userId);
}
