package ru.drmteamdev.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features =    "src/test/resources/features" //
                ,glue = "ru/drmteamdev/step_definition"
                ,publish = true//
                ,plugin = {"pretty",  "html:target/cucumber.html" //
                            , "rerun:target/rerun.txt"//
                            }
                            ,dryRun = false



            //    ,tags="@single"
            ,tags="@bla"
              //,tags="@smoke"  //


            )

public class TestRunner {

}
