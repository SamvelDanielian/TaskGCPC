package com.project.hardcore.framework.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.Locale;

public class DriverSingleton {

    private static WebDriver driver;

    private DriverSingleton(){}

    public static WebDriver getDriver(){
        if(null == driver){
            String browser = System.getProperty("browser");
            if(browser!=null) {
                switch (browser.toLowerCase()) {
                    case "firefox": {
                        WebDriverManager.firefoxdriver().setup();
                        driver = new FirefoxDriver();
                        break;
                    }
                    default: {
                        WebDriverManager.chromedriver().setup();
                        driver = new ChromeDriver();
                        break;
                    }
                }
            } else {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void closeDriver(){
        if(driver!=null) {
            driver.quit();
            driver = null;
        }
    }
}