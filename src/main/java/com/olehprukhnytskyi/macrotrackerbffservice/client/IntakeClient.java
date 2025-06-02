package com.olehprukhnytskyi.macrotrackerbffservice.client;

import com.olehprukhnytskyi.macrotrackerbffservice.dto.IntakeDto;
import com.olehprukhnytskyi.macrotrackerbffservice.dto.PagedResponse;
import com.olehprukhnytskyi.macrotrackerbffservice.util.CustomHeaders;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "intake-service", url = "${feign.intake-service:http://localhost:8081}")
public interface IntakeClient {
    @GetMapping("/api/intake")
    PagedResponse<IntakeDto> getIntakes(
            @RequestHeader(CustomHeaders.X_USER_ID) Long userId
    );
}
