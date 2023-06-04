package com.cydeo.tests.day01_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

    public static void main(String[] args) {

        // 1- Setting up the web driver manager
        WebDriverManager.chromedriver().setup();

        // 2- Create the instance of Chrome browser driver
        WebDriver driver = new ChromeDriver();

        // 3- Test if driver and browser are working as expected
        driver.get("https://www.google.com");

        /*    How Selenium WebDriver works?
        #1 step : We are writing Java Selenium;
                   In Selenium WebDriver we write our automation code

        #2 step : Browser driver as a Translator;
                   When we initialize the WebDriver, such as the ChromeDriver for Google Chrome,
                   it starts a separate process that acts as a "translator" between our Java Selenium commands
                   and the browser's native language and creating http request

         #3 step : Translating Java Selenium to Browser Actions;
                     The WebDriver translates our Java Selenium commands into http requests.
                     It sends these requests to the browser to execute the desired actions.
         */



    }

}
