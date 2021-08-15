package com.github.jsjchai.springboot.demo.controller;


import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.DistributionSummary;
import io.micrometer.core.instrument.MeterRegistry;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@Api(tags = {"用户"})
@RequestMapping("/user/stat")
public class UserStatController {

    @Autowired
    private MeterRegistry registry;

    @GetMapping(value = "/get")
    @ApiOperation(value = "获取用户信息", notes = "获取用户信息")
    public String get() {
        Counter count = registry.counter("test_request_count", "test", "1");
        DistributionSummary summary = registry.summary("test_amount_sum", "test", "300");
        return "test";
    }



}
