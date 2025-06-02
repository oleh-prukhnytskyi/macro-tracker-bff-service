package com.olehprukhnytskyi.macrotrackerbffservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MacroTrackerBffServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MacroTrackerBffServiceApplication.class, args);
    }

}
