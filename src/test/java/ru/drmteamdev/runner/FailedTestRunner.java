package ru.drmteamdev.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

//Now it is connected
@RunWith(Cucumber.class)
@CucumberOptions( glue = "ru/drmteamdev/step_definition"
                 ,features = "@target/rerun.txt" )
// if we don't put @ before target @FailedTestRunner will think that this is a feature file

public class FailedTestRunner {

}
