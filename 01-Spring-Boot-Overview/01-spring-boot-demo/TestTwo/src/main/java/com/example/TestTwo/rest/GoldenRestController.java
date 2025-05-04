package com.example.TestTwo.rest;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoldenRestController {

    @GetMapping("/")
    public String nothingThere() {
        return "Goodbye";
    }

    // expose a new endpoints for blueStar

    @GetMapping("/blue-star")
    public String blueStar() {
        return "Blue.\n" +
                "\n" +
                "It’s blue.\n" +
                "\n" +
                "We’re blue.\n" +
                "\n" +
                "I’m blue too.\n" +
                "\n" +
                "DEEPYETFAINTGLOOMYYETMERRYFRIGIDYET\n" +
                "WARMSHARPYETSOFTCOOLYETSWELTERING";
    }

    // expose a new endpoints for the silent orchestra

    @GetMapping("/the-silent-orchestra")
    public String theSilentOrchestra() {
        return "From the break of a ruin, the most beautiful performance shall begin!";
    }
}
