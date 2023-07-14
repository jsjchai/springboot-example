package com.github.jsjchai.springboot.demo.controller;


import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.DistributionSummary;
import io.micrometer.core.instrument.MeterRegistry;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Tag(name="UserStatController",description="消息编码")
@RequestMapping("/user/stat")
public class UserStatController {

    @Autowired
    private MeterRegistry registry;

    @GetMapping(value = "/get")
    @Operation( summary = "获取用户信息")
    public String get() {
        Counter count = registry.counter("test_request_count", "test", "1");
        DistributionSummary summary = registry.summary("test_amount_sum", "test", "300");
        return "test";
    }



}
