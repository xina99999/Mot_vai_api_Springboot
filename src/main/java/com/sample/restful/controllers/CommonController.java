package com.sample.restful.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/v1/commons")
public class CommonController {
    @GetMapping("/v1/status")
    String status() {
        return "13092023";
    }

}
