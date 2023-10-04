package ru.drmteamdev.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

//this class has only one purpose
// instructing how and what feature we want to run
//features = "src/test/resources/features",



// where are the step definitions
//  glue = "com/cydeo/step_definition")


// do we want to just generate missing step definitions
//@CucumberOptions(dryRun = true)     will run the test without running all scenario
//or missing steps, so you can copy all the missing steps if there is any
// if it is (true) it's like a quick scan of all your feature steps definition
// if it is false it's actually will run the whole test

// do we want to get json, html report
//do we want to filter the test run according to certain tags
@RunWith(Cucumber.class)
@CucumberOptions(features =    "src/test/resources/features" //"classpath:features"
                ,glue = "ru/drmteamdev/step_definition"
                ,publish = true// it will give you public link of your local html report (free)
                ,plugin = {"pretty",  "html:target/cucumber.html" // html page report
                            , "rerun:target/rerun.txt"// store the failed scenario into rerun.txt
                            }
                            ,dryRun = false

                //,tags="@non_ui"
            ,tags="@bla"
              //,tags="@salad and @smoke"  //don't forget add next to each other this tags
                // ,tags="@salad or @smoke"
               // ,tags = "@calculator" // will run everything what is not @ui
            )

public class TestRunner {

}
