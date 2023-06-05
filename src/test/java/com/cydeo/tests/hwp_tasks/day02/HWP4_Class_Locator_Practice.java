package com.cydeo.tests.hwp_tasks.day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HWP4_Class_Locator_Practice {

    public static void main(String[] args) throws InterruptedException {


        //TC #4: Practice Cydeo – Class locator practice
        //1- Open a Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2- Go to: https://practice.cydeo.com/inputs
        driver.get("https://practice.cydeo.com/inputs");

        //3- Locating the "Home" link web element
        //WebElement homeLink = driver.findElement(By.linkText("Home")); // Both two locator works fine -> linkText & className
        WebElement homeLink = driver.findElement(By.className("nav-link"));

        //3´4- Click to “Home” link
        Thread.sleep(3000);
        homeLink.click();


        //5- Verify title is as expected:
        //Expected: Practice
        String expectedTitle = "Practice";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Title verification PASSED!");
        } else {
            System.out.println("Title verification FAILED!");

        }


        //PS: Locate “Home” link using “className” locator

        driver.close();

    }
}
