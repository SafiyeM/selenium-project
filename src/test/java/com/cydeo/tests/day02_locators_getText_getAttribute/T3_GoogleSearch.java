package com.cydeo.tests.day02_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T3_GoogleSearch {


    public static void main(String[] args) throws InterruptedException {


        // TC#3: Google search
        //1- Open a Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2- Go to: https://google.com
        driver.get("https:www.google.com");
        Thread.sleep(3000);

        driver.findElement(By.cssSelector("[id='L2AGLb']")).click();// this simulates in google page to click "I agree" or "Accept" button
                                                                    //  to proceed with further automation tasks.

        //3- Write “apple” in search box.
        // a. Locate search box
        WebElement googleSearchBox = driver.findElement(By.name("q"));
        Thread.sleep(3000);

        // b. Enter "apple" key, and press ENTER
        googleSearchBox.sendKeys("apple" + Keys.ENTER);

        //4- Press ENTER to search
        // googleSearchBox.sendKeys(Keys.ENTER);


        //5- Verify title:
        //Expected: Title should start with “apple” word

        String expectedInBeginningOfTitle = "apple";
        String actualTitle = driver.getTitle();

        if (actualTitle.startsWith(expectedInBeginningOfTitle)){
            System.out.println("Title verification PASSED!");
        }else {
            System.out.println("Title verification FAILED!");
        }

        driver.close();

    }
}

