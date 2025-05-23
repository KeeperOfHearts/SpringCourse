package com.love2code.util;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

    public CricketCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    // init methid
    @PostConstruct
    public void doMyStuff() {
        System.out.println("Nah this methods is too lazy to do somenting");
    }

    // destroy method
    @PreDestroy
    public void doBeforeDeath() {
        System.out.println("Nyoooooooo i wanna lvv more");
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes";
    }
}
