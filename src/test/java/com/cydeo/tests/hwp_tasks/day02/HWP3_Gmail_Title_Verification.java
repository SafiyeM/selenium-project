package com.cydeo.tests.hwp_tasks.day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HWP3_Gmail_Title_Verification {

    public static void main(String[] args) {


        //TC #3: Back and forth navigation
        //1- Open a Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2- Go to: https://google.com
        driver.get("https://google.com");

        //3- Click "I agree" or "Accept" button that appears when Google displays its terms of service or privacy policy
        driver.findElement(By.id("L2AGLb")).click();

        //3- Locate to Gmail from top right using linkText locator
        WebElement gmailLink = driver.findElement(By.linkText("Gmail"));

        // Click to the Gmail link
        gmailLink.click();

        //4- Verify title contains:
        //Expected: Gmail
        String expectedGmailTitle = "Gmail";
        String actualGmailTitle = driver.getTitle();

        if (actualGmailTitle.contains(expectedGmailTitle)) {
            System.out.println("Gmail title verification PASSED!");
        } else {
            System.out.println("Gmail title verification PASSED!");
        }

        //5- Go back to Google by using the .back();
        driver.navigate().back();

        //6- Verify title equals:
        //Expected: Google
        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();

        if (actualGmailTitle.equals(expectedTitle)) {
            System.out.println("Google title Verification PASSED");
        } else {
            System.out.println("Google title Verification PASSED");
        }


        driver.close();

    }
}
