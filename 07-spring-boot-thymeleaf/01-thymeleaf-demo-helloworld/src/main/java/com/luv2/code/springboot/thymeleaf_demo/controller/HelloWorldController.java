package com.luv2.code.springboot.thymeleaf_demo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    @RequestMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    @GetMapping("/processForm")
    public String processForm() {
        return "hello";
    }

    @GetMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest request, Model model) {

        String name = request.getParameter("studentname");

        name = name.toUpperCase();

        String result = "Yo! " + name;

        model.addAttribute("message", result);

        return "helloworld";
    }

    @GetMapping("/processFormVersionThree")
    public String processFormVersionThree(@RequestParam("studentname") String name, Model model) {

        name = name.toUpperCase();

        String result = "Hey my friend from v3 " + name;

        model.addAttribute("message", result);

        return "helloworld";
    }
}
