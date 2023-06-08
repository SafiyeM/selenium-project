package com.cydeo.tests.day05_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class T2_radioButtons {

    public static void main(String[] args) throws InterruptedException {

        //TC #2: Radiobutton handling
        //1. Open Chrome browser
        //2. Go to https://practice.cydeo.com/radio_buttons
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://practice.cydeo.com/radio_buttons");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //3. Click to “Hockey” radio button
        WebElement hockeyButton = driver.findElement(By.xpath("//input[@id='hockey']"));
        Thread.sleep(2000);
        hockeyButton.click();

        //4. Verify “Hockey” radio button is selected after clicking.
       // System.out.println("hockeyButton.isSelected(), expecting true = " + hockeyButton.isSelected());
        if (hockeyButton.isSelected()){
            System.out.println("Button is selected. Verification PASSED!");
        }else{
            System.out.println("Button is not selected. Verification FAILED!");
        }


        //USE XPATH LOCATOR FOR ALL WEB-ELEMENT LOCATORS

        driver.quit();

    }
}
