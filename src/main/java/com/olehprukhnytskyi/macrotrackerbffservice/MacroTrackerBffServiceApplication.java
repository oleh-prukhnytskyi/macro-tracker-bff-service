package com.olehprukhnytskyi.macrotrackerbffservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
        info = @Info(
                title = "Macro Tracker API",
                version = "1.0",
                description = "This BFF (Backend for Frontend) service"
                        + " provides aggregated data from multiple microservices"
        )
)
@SpringBootApplication
public class MacroTrackerBffServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MacroTrackerBffServiceApplication.class, args);
    }

}
