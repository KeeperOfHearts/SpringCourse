package com.love2code.springcoredemo.rest;

import com.love2code.util.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach myCoach;
    private Coach anotherCoach;

    @Autowired
    public  DemoController(@Qualifier("cricketCoach") Coach coach,
                            @Qualifier("cricketCoach") Coach anothCoach)
    {
        myCoach = coach;
        anotherCoach= anothCoach;
    }

    //    public void setCoach(Coach coach) {
//        myCoach = coach;
//    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String check() {
        return "Comparing beans: myCoach == anotherCoach: " + (myCoach == anotherCoach);
    }
}
