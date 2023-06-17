package com.cydeo.tests.day09_review_javaFaker;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T1_Bing_Search {

    //TC #1: Bing search

    WebDriver driver;

    @BeforeMethod
    public void setup() {

        //1- Open a Chrome browser
        //driver = WebDriverFactory.getDriver("chrome"); -> hard coded version
        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2- Go to: https://bing.com
        //driver.get("https://bing.com");
        driver.get(ConfigurationReader.getProperty("bingURL"));

    }

    @Test
    public void bing_search_test() {

        //3- Write “apple” in search box

        //locate the search box
        WebElement searchBox = driver.findElement(By.xpath("//textarea[@id='sb_form_q']"));
        // to accept the cookies pop-up
        driver.findElement(By.xpath("//button[@id='bnp_btn_accept']")).click();

        //searchBox.sendKeys("apple" + Keys.ENTER); -> hard coded version
        searchBox.sendKeys(ConfigurationReader.getProperty("searchValue") + Keys.ENTER);

        //4- Verify title:
        //Expected: apple - Search

        // This is how we verified the Title before we created our verifyTitle() utility method in BrowserUtils class
        // String expectedTitle = "apple - Search";
        // String actualTitle = driver.getTitle();
        //Assert.assertEquals(actualTitle, expectedTitle);

        //We are using verifyTitle() utility method to verify Title
        //We are just making the expectedTitle dynamic based on the text we are searching.
        BrowserUtils.verifyTitle(driver, ConfigurationReader.getProperty("searchValue")+ " - Search");


        //Use `configuration.properties` for the following:
        //1. The browser type
        //2. The URL
        //3. The search keyword
        //4. Make title verification dynamic. If search value changes, title
        //assertion should not fail.

    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
