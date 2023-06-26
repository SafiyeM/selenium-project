package com.cydeo.tests.base;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;


// This class is the parent of all Test classes
// You will update this class based on what you are keep writing in your most test classes
// instead writing in all test classes, you can just write in this class,
// and you can extend this class from any class
// This class is abstract because we don't want to create any object with using this class
public abstract class TestBase {

    protected WebDriver driver;

    @BeforeMethod
    public void setup(){
        // 1. Open Chrome browser
        // driver = WebDriverFactory.getDriver("chrome"); This is hard coding, instead we use our 'key' in configuration.properties file
        // to read this file, we use ConfigurationReader and call getProperty() method and pass our String key "browser",
        // and it will read the value (in this case: chrome)

        //Driver class will handle driver setting up line of codes
        //Since we are using Driver class, we will not need to use setting up browser drivers codes
        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // After we implement Driver class singleton design pattern in our project,
        // we will not need above codes instead we will determine common line of codes
        // from most test methods to implement in this class

        //we can use this cass for navigating to the page
        //driver.get("URL of app")

    }

    @AfterMethod
    public void tearDownMethod(){

        driver.quit();

        //Driver.closeDriver();

        //Taking screenshot codes here to get screenshot of failing Test after they done
    }
}