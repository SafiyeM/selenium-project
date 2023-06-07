package com.cydeo.tests.hwp_tasks.day03;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HWP4_Link_XPATH_CSS {

    public static void main(String[] args) {

        //HWP #4: Practice Cydeo – xpath locator practice
        //1- Open a Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2- Go to: https://practice.cydeo.com/inputs
        driver.get("https://practice.cydeo.com/inputs");

        //3- Locating the "Home" link web element
        // by using 'linkText'
        //WebElement homeLink = driver.findElement(By.linkText("Home")); // Both two locator works fine -> linkText & className

        //Locating the "Home" link web element using by using 'XPATH'
        //WebElement homeLink = driver.findElement(By.xpath("a[@class= 'nav-link']"));
        //WebElement homeLink = driver.findElement(By.xpath("//a[text()='Home']"));

        // //Locating the "Home" link web element using by using 'cssSelector'
        //WebElement homeLink = driver.findElement(By.cssSelector("a[class='nav-link']"));
        WebElement homeLink = driver.findElement(By.cssSelector("a.nav-link"));


        //3- Click to “Home” link
        homeLink.click();

        //4- Verify title is as expected:
        //Expected: Practice
        String expectedTitle = "Practice";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Title verification PASSED!");
        } else {
            System.out.println("Title verification FAILED!");

        }

        //PS: Locate “Home” link using “xpath” locator

    }
}
