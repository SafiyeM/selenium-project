package com.cydeo.tests.review.week2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigations_GetMethods {


    // TC#1: Navigations and Get methods Practice

    // 1. Open a Chrome browser
    // 2. Go to: https://www.etsy.com
    // 3. Navigate to https://www.amazon.com/
    // 4. Navigate back, forward and refresh
    // 5. Write “selenium” in search box
    // 6. Press search button to search
    // 7. Verify title is "Amazon.com : selenium"
    // 8. Verify url contains "selenium"

    public static void main(String[] args) {



        // setting up driver browser with WebDriver manager was used in selenium 3 version
        // selenium 4 version doesn't need anymore
        WebDriverManager.chromedriver().setup();

        // 1. Open a Chrome browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 2. Go to: https://www.etsy.com
        driver.get("https://www.etsy.com");

        // 3. Navigate to https://www.amazon.com/
        driver.navigate().to("https://www.amazon.com/");

        // 4. Navigate back, forward and refresh
        driver.navigate().back(); // it will take us to the previous page which is etsy

        driver.navigate().forward(); // it will take us to the forward page which is amazon

        driver.navigate().refresh(); // it will refresh the page

        // 5. Write “selenium” in search box
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("selenium");

        // if test step was saying just search for "selenium" you can use Keys.Enter
       // searchBox.sendKeys("selenium" + Keys.ENTER);

        // 6. Press search button to search
        WebElement searchButton = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
        searchButton.click();

        // 7. Verify title is "Amazon.com : selenium"
        String actualTitle = driver.getTitle();
        String expectedTitle = "Amazon.com : selenium";

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Title verification PASSED!");
        }else {
            System.out.println("Title verification FAILED!");
        }

        // 8. Verify url contains "selenium"
        String  actualUrl = driver.getCurrentUrl();
        String expectedUrl = "selenium";

        if (actualUrl.contains(expectedUrl)){
            System.out.println("Url verification PASSED!");
        }else{
            System.out.println("Url verification FAILED!");
        }

        // if we have more than 1 tab/windows, it will only close currently open tab
        // we can still use driver instance in other tabs/windows
        driver.close();

        //if you have multiple tab/windows open, it will close everything
        // it will kill driver session, and we will not be able to
        driver.quit();




    }
}
