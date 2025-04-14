package com.cropdeal.api_gateway_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GatewayController {

    @GetMapping("/")
    public String home() {
        return "API Gateway is up and running!";
    }
}
