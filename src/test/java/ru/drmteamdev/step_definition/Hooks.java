package ru.drmteamdev.step_definition;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.drmteamdev.utility.Driver;

import java.time.Duration;

public class Hooks {
    @Before("@bla")
    public void setupDriver() {
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
        Driver.getDriver().manage().window().maximize();
    }
    @After("@bla")
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Attached img");
        }

        Driver.closeBrowser();

    }


}
