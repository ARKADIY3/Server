package com.practicheskaya.server8.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class SaveController {

    @GetMapping(value = "/index")
    public String index() {
        return "index";
    }
}
