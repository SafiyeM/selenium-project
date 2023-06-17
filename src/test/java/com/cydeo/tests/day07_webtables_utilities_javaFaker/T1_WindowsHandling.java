package com.cydeo.tests.day07_webtables_utilities_javaFaker;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class T1_WindowsHandling {

    WebDriver driver;


    @BeforeMethod
    public void setup() {

        //1. Create new test and make set up
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //2. Go to : https://www.amazon.com
        driver.get("https://www.amazon.com");


    }

    @Test
    public void window_handling_test() {

        //TC #1: Window Handle practice

        //3. Copy and paste the lines from below into your class
        //These lines will simply open new tabs using something called JavascriptExecutor
        //and get those pages. We will learn JavascriptExecutor later as well.
        //Lines to be pasted:
        ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");

        //4. Create a logic to switch to the tab where Etsy.com is open

        //Return and store all window handles in a Set
        Set<String> allWindowHandles = driver.getWindowHandles();

        for (String each : allWindowHandles) {

            driver.switchTo().window(each);
            // System.out.println("Current URL: " + driver.getCurrentUrl());


            if (driver.getCurrentUrl().contains("etsy")) {
                break;
            }
        }
        //5. Assert: Title contains “Etsy”

        // String actualTitle = driver.getTitle();
        //        String expectedInTitle = "Etsy";
        //
        //        Assert.assertTrue(actualTitle.contains(expectedInTitle));

        BrowserUtils.verifyTitleContains(driver, "Etsy");
    }

    @Test
    public void window_handling_test_2() {

        //TC #1: Window Handle practice

        //3. Copy and paste the lines from below into your class
        //These lines will simply open new tabs using something called JavascriptExecutor
        //and get those pages. We will learn JavascriptExecutor later as well.
        //Lines to be pasted:
        ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");

        //4. Create a logic to switch to the tab where Etsy.com is open

        BrowserUtils.switchWindowAndVerify(driver, "etsy", "Etsy");
    }


    @AfterMethod
    public void tearDown() {

        driver.quit();
    }
}
