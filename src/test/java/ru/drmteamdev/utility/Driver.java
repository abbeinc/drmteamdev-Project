package ru.drmteamdev.utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
    /**
     * We want to have a class with that only return Single object
     * no matter how many times you ask for object
     * so we are creating this class with technic we learned form Singleton pattern
     */

    private Driver(){
    }

    private static WebDriver driver;

    /**
     * Return obj with only one WebDriver instance
     * @return same WebDriver if exists, new one if null
     */
    public static WebDriver getDriver(){

        String browserName = ConfigReader.read("browser");
        if (driver==null){
                switch (browserName.toLowerCase()){

                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver();
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    driver.manage().window().maximize();
                    break;

                case "edge":
                   WebDriverManager.edgedriver().setup();
                   driver = new EdgeDriver();
                   driver.manage().window().maximize();
                    break;
                default:
                    driver=null;
                    System.out.println("Unknown browser type! "+browserName);

            }
            //  System.out.println("one and only object created");
            return driver;
            }else {
            //  System.out.println("You have it just use existing one");
            return driver;

            }
            // you not really need else statement it just made for better understanding
            }


    /**
     * Quitting the browser and setting the value of WebDriver
     * instance to null because you can re-use already quited driver
     */
    public static void closeBrowser(){
        // check if we have webDriver instance or not
        // basically checking if obj is null or not
        //if not null
        // quit the browser
        // make it null, because once quit it can not be used
        if(driver!=null){
            driver.quit();
            // so when we ask for it again, it gives us not quited fresh driver
            driver=null;
        }




    }





}
