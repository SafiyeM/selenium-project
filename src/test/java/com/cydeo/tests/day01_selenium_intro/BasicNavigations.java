package com.cydeo.tests.day01_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigations {

    public static void main(String[] args) throws InterruptedException {

        // Setup browser driver
        WebDriverManager.chromedriver().setup();

        // Create instance of Chrome browser
        WebDriver driver = new ChromeDriver();

        // maximizes the current window
        driver.manage().window().maximize();
       // driver.manage().window().fullscreen(); -> for mac

        // Go to tesla.com
        driver.get("https://www.tesla.com");

        // Use .getCurrentUrl() method to print out current URL
        System.out.println(driver.getCurrentUrl());

        // get title of the page
        //System.out.println("driver.getTitle() = " + driver.getTitle());
        String currentTitle = driver.getTitle();
        System.out.println("currentTitle = " + currentTitle); // currentTitle = Electric Cars, Solar & Clean Energy | Tesla

        // Use navigate back() to go back
        driver.navigate().back();

        // Stop execution for 3 seconds
        Thread.sleep(3000);

        // Use navigate forward() to go forward
        driver.navigate().forward();

        // Stop execution for 3 seconds
        Thread.sleep(3000);

        // User refreshes the page using navigate.refresh();
        driver.navigate().refresh();

        // Stop execution for 3 seconds
        Thread.sleep(3000);

        // Navigate to google.com using navigate().to();
        driver.navigate().to("https://www.google.com");

        // Use .getCurrentUrl() method to print out current URL
        System.out.println(driver.getCurrentUrl());

        // get title of the page
        //System.out.println("driver.getTitle() = " + driver.getTitle());
        currentTitle = driver.getTitle();
        System.out.println("currentTitle = " + currentTitle); // currentTitle = Google

        // closes only the currently focused window/tab
        driver.close();

        // closes all the opened browser
        driver.quit();

        /*
        driver.quit();
        This basically kills the whole session.
        That means:
           we start a new session with this code : WebDriver driver = new ChromeDriver();
           our browser driver is assigning some randomly generated value to our session itself.
           ex. session ID for driver : 98249756093ß90878665
           so this session ID is being passed all the upcoming driver. callings
           until we use driver.quit where we are explicitly killing the session,
           and it will generate new session for the next time

   What is a session?
	- A new session is created every time we run our selenium code.
	- We can end the session using driver.quit() method, or it will naturally end when the code execution is done.

	4435741da99f778a4f20f537ed796993
	3bd91c488ca90d19c1b6b7f9c234562a
         */





    }


}
