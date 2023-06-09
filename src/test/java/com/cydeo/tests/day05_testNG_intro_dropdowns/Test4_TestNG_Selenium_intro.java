package com.cydeo.tests.day05_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Test4_TestNG_Selenium_intro {

    WebDriver driver; // declaration of webdriver in class level

    @BeforeMethod
    public void setupMethod(){


        //TC #4: Cydeo Title Verification
        //1. Open Chrome browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2. Go to https://practice.cydeo.com
        driver.get("https://practice.cydeo.com");

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


    @Test
   public void test1_cydeo_title_verification(){

       //3. Verify title:
       //Expected: Practice

       String actualTitle = driver.getTitle();
       String expectedTitle = "Practice";
       Assert.assertEquals(actualTitle, expectedTitle);

   }
}
