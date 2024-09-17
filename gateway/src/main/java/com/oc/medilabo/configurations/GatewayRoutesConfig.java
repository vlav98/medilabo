package com.oc.medilabo.configurations;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayRoutesConfig {
    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("patients", route -> route.path("/patients/**")
                        .uri("lb://patients"))
                .route("notes", route -> route.path("/notes/**")
                        .uri("lb://notes"))
                .route("risk-report", route -> route.path("/risk-report/**")
                        .uri("lb://risk-report"))
                .build();
    }
}
