package ru.drmteamdev.step_definition;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.drmteamdev.utility.Driver;

import java.time.Duration;

public class Hooks {
    @Before("@smoke")
    public void setupDriver() {
    Driver.getDriver().manage().window().maximize();
   //  Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofMillis(3000));

    }
    @After("@smoke")
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Attached img");
        }

        Driver.closeBrowser();
        Driver.closeBrowser();

    }


}
