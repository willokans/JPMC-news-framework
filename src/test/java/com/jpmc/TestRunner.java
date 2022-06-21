package com.jpmc;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"com.jpmc.steps"},
        monochrome = false,
        plugin = {"pretty",
                "html:target/cucumber-html-report",
                "json:target/cucumber-reports/cucumber.json",
                "junit:tartget/cucumber-reports/cucumber.xml",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}

)
public class TestRunner {

}
