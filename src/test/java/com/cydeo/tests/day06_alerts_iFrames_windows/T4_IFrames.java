package com.cydeo.tests.day06_alerts_iFrames_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T4_IFrames {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {

        //1. Create a new class called: T4_Iframes
        //2. Create new test and make setup
        //3. Go to: https://practice.cydeo.com/iframe

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2. Go to website: http://practice.cydeo.com/iframe
        driver.get("http://practice.cydeo.com/iframe");
    }


    @Test
    public void iframe_test() {

        //TC #4: Iframe practice
        // we have to switch to iframe to be able to locate the web element in there.

        // option#1- switch "id" attribute value
        // driver.switchTo().frame("mce_0_ifr");

        // option#2- switch using "index" number
        // driver.switchTo().frame(0);

        // option#3- switch using WebElement
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']")));

        // locate paragraph text web element
        WebElement paragraphText = driver.findElement(By.xpath("//p[.='Your content goes here.']"));

        //4. Assert: “Your content goes here.” Text is displayed.
        Assert.assertTrue(paragraphText.isDisplayed(), "Paragraph text is NOT DISPLAYED");

        //5. Assert: “An iFrame containing the TinyMCE WYSIWYG Editor
        driver.switchTo().parentFrame();
        //driver.switchTo().defaultContent();
        WebElement headerText = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(headerText.isDisplayed());

    }

    @AfterMethod
    public void tearDownMethod() {
        driver.quit();
    }


}
