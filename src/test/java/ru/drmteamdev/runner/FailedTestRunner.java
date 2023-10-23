package ru.drmteamdev.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions( glue = "ru/drmteamdev/step_definition"
                 ,features = "@target/rerun.txt" )

public class FailedTestRunner {

}
