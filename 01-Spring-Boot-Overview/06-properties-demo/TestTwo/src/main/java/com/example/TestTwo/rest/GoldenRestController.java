package com.example.TestTwo.rest;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoldenRestController {

    // inject properties values

    @Value("${nothingThere.class}")
    private String nothingThereLevel;

    @Value("${coolApp.name}")
    private String myAppName;


    @GetMapping("/")
    public String nothingThere() {
        return "Goodbye";
    }

    @GetMapping("/getInfo")
    public String getInfo() {
        return "Nothing There Level :" + nothingThereLevel + "\n My App Name :" + myAppName;
    }
}
