package com.olehprukhnytskyi.macrotrackerbffservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@OpenAPIDefinition(
        info = @Info(
                title = "BFF Service API",
                version = "1.0",
                description = "This BFF (Backend for Frontend) microservice"
                        + " provides aggregated data from multiple microservices"
        )
)
@SpringBootApplication
@ConfigurationPropertiesScan
public class MacroTrackerBffServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MacroTrackerBffServiceApplication.class, args);
    }

}
