package com.jpmc.steps.hook;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hook {

    //can implement a logger instead of system.out.println

    @Before
    public void setup(Scenario scenario){
        System.out.println("Test Execution starting for :"+ scenario.getName().toUpperCase());
    }

    @After
    public void tearDown(Scenario scenario){
        System.out.println("Test Execution ending for :"+ scenario.getName().toUpperCase());
    }
}
