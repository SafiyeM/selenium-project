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

public class T5_WindowsPractice {


    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        //1. Create a new class called: T5_WindowsPractice
        //2. Create new test and make setups
        //3. Go to : https://practice.cydeo.com/windows
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2. Go to website: http://practice.cydeo.com/windows
        driver.get("http://practice.cydeo.com/windows");
    }


    @Test
    public void multiple_windows_test(){

        // TC #5: Window Handle practice

        //4. Assert: Title is “Windows”
        String expectedTitle = "Windows";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);

        String mainHandle = driver.getWindowHandle();
        System.out.println("mainHandle = " + mainHandle);


        System.out.println("Title before click: " + driver.getTitle());
        //5. Click to: “Click Here” link
        WebElement clickHereLink = driver.findElement(By.linkText("Click Here"));
        clickHereLink.click();

        System.out.println("Title after click: " + driver.getTitle());

        //6. Switch to new Window. We need to use driver.getWindowHandle(); method
        //driver.getWindowHandle();
        //1- windowHandle : mainHandle
        //2- windowHandle : 2nd window

        for (String each : driver.getWindowHandles()){
            driver.switchTo().window(each);
            System.out.println("current title while switching windows : " + driver.getTitle());
            /*Output:
            current title while switching windows : Windows
            current title while switching windows : New Window
             */
        }

        //7. Assert: Title is “New Window”
        String expectedTitleAfterClick = "New Window";
        String actualCurrentTitle = driver.getTitle();

        Assert.assertEquals(actualCurrentTitle, expectedTitleAfterClick);

        //If we have to go back to main page to continue our test case,
        //we can use mainHandle to switch.

        driver.switchTo().window(mainHandle);
        //continue...
        //code

    }
    @AfterMethod
    public void tearDownMethod() {
        driver.quit();
    }


}
