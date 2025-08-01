package com.luv2code.springboot.demo_security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
    @GetMapping("/")
    public String showHome() {
        return "home";
    }

    @GetMapping("/leaders")
    public String showLeadersMeeting() {
        return "leaders";
    }

    @GetMapping("/admins")
    public String showAdminsMeeting() {
        return "admins";
    }
}
