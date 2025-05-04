package com.example.TestTwo.rest;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoldenRestController {

    @GetMapping("/")
    public String nothingThere() {
        return "Goodbye";
    }
}
