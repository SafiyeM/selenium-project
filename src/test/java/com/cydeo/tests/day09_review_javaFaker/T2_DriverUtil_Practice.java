package com.cydeo.tests.day09_review_javaFaker;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class T2_DriverUtil_Practice {

/*
    //TC #1: Bing search

    WebDriver driver;
    @BeforeMethod
    public void setupMethod(){
        //1- Open a Chrome browser
        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

 */


    @Test
    public void bing_search_test() {

        //3- Write “apple” in search box
        //Driver.getDriver() ---> will return me the "driver"
        //instead of writing "driver" from now on, we will write Driver.getDriver();
        Driver.getDriver().get(ConfigurationReader.getProperty("bingURL"));

        BrowserUtils.sleep(3);
        //locate the search box
        WebElement searchBox = Driver.getDriver().findElement(By.xpath("//textarea[@id='sb_form_q']"));
        // to accept the cookies pop-up
        Driver.getDriver().findElement(By.xpath("//button[@id='bnp_btn_accept']")).click();

        //searchBox.sendKeys("apple" + Keys.ENTER); -> hard coded version
        searchBox.sendKeys(ConfigurationReader.getProperty("searchValue") + Keys.ENTER);

        //4- Verify title:
        //Expected: apple - Search

        // This is how we verified the Title before we created our verifyTitle() utility method in BrowserUtils class
        // String expectedTitle = "apple - Search";
        // String actualTitle = driver.getTitle();
        //Assert.assertEquals(actualTitle, expectedTitle);

        BrowserUtils.sleep(2);
        //We are using verifyTitle() utility method to verify Title
        //We are just making the expectedTitle dynamic based on the text we are searching.
        BrowserUtils.verifyTitle(Driver.getDriver(), ConfigurationReader.getProperty("searchValue")+ " - Search");





        //Use `configuration.properties` for the following:
        //1. The browser type
        //2. The URL
        //3. The search keyword
        //4. Make title verification dynamic. If search value changes, title
        //assertion should not fail.

    }


    @Test
    public void bing_search_test2() {

        //3- Write “apple” in search box
        //Driver.getDriver() ---> will return me the "driver"
        //instead of writing "driver" from now on, we will write Driver.getDriver();
        Driver.getDriver().get(ConfigurationReader.getProperty("bingURL"));

        BrowserUtils.sleep(3);
        //locate the search box
        WebElement searchBox = Driver.getDriver().findElement(By.xpath("//textarea[@id='sb_form_q']"));
        // to accept the cookies pop-up
        Driver.getDriver().findElement(By.xpath("//button[@id='bnp_btn_accept']")).click();

        //searchBox.sendKeys("apple" + Keys.ENTER); -> hard coded version
        searchBox.sendKeys(ConfigurationReader.getProperty("searchValue") + Keys.ENTER);

        //4- Verify title:
        //Expected: apple - Search

        // This is how we verified the Title before we created our verifyTitle() utility method in BrowserUtils class
        // String expectedTitle = "apple - Search";
        // String actualTitle = driver.getTitle();
        //Assert.assertEquals(actualTitle, expectedTitle);

        BrowserUtils.sleep(2);
        //We are using verifyTitle() utility method to verify Title
        //We are just making the expectedTitle dynamic based on the text we are searching.
        BrowserUtils.verifyTitle(Driver.getDriver(), ConfigurationReader.getProperty("searchValue")+ " - Search");





        //Use `configuration.properties` for the following:
        //1. The browser type
        //2. The URL
        //3. The search keyword
        //4. Make title verification dynamic. If search value changes, title
        //assertion should not fail.

    }


    @AfterMethod
    public void tearDown() {

          /*
        We won't be using the selenium's quit method directly anymore.

        Driver.getDriver().quit(); --> no more using this method

        We will use Driver.closeDriver();
         */

        Driver.closeDriver();
    }


}
