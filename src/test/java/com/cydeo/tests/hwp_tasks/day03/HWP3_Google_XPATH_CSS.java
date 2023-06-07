package com.cydeo.tests.hwp_tasks.day03;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HWP3_Google_XPATH_CSS {

    public static void main(String[] args) {


        //TC #3: Back and forth navigation
        //1- Open a Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //2- Go to: https://google.com
        driver.get("https://google.com");

        //3- click on the 'accept' button on the privacy policy pop-up page
        driver.findElement(By.cssSelector("[id='L2AGLb']")).click();

        //4- Locating the Gmail Link using "xpath" locator
        // Xpath Syntax#1 : //tagName[@attribute='value']
        // WebElement gmailLink = driver.findElement(By.xpath("//a[@data-pid ='23']"));

        // Using the text of the web element with XPATH locator
        // Xpath Syntax#2 :tagName[text()='value'] -> or //tagName[.='textValue']
        //WebElement gmailLink = driver.findElement(By.xpath("//a[. ='Gmail']"));
        //WebElement gmailLink = driver.findElement(By.xpath("//a[text() ='Gmail']"));

        // locating the Gmail link using "cssSelector" locator
        // cssSelector Syntax: tagName[attribute='value']
        WebElement gmailLink = driver.findElement(By.cssSelector("a[href='https://mail.google.com/mail/&ogbl']"));

        //4- Click to Gmail from top right
        gmailLink.click();

        //5- Verify title contains:
        //Expected: Gmail
        String expectedTitle = "Gmail";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitle)) {
            System.out.println("Title contains Gmail verification passed!");
        } else {
            System.out.println("Title contains Gmail verification passed!");
        }


        //6- Go back to Google by using the .back();
        //7- Verify title equals:
        //Expected: Google

        driver.close();
    }
}
