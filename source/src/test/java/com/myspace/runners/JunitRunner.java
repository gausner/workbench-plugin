package com.myspace.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        format = {"pretty", "html:target/cucumber/html/", "json:target/cucumber.json"},
        glue = "com.myspace.glue",
        features = "src/test/resources/features"
)
public class JunitRunner {
}
