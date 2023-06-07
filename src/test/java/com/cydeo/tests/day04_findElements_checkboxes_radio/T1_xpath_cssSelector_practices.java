package com.cydeo.tests.day04_findElements_checkboxes_radio;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T1_xpath_cssSelector_practices {

    public static void main(String[] args) throws InterruptedException {


        //XPATH and CSS Selector PRACTICES
        //DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
        //TC #1: XPATH and cssSelector Practices
        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2. Go to https://practice.cydeo.com/forgot_password
        driver.get("https://practice.cydeo.com/forgot_password");

        //3. Locate all the WebElements on the page using XPATH and/or CSS
        // locator only (total of 6)

        //a. “Home” link
        //                                    ----cssSelector----
        // Locate "Home" link, using cssSelector, syntax #1-> class attribute value -> tagName[attributeName='value']
        WebElement homeLink_ex1 = driver.findElement(By.cssSelector("a[class='nav-link']"));

        // Locate "Home" link, using cssSelector, syntax #2-> class attribute value -> (tagName.ClassValue)
         WebElement homeLink_ex2 = driver.findElement(By.cssSelector("a.nav-link"));

        // Locate "Home" link, using cssSelector, syntax #3-> href attribute value
        WebElement homeLink_ex3 = driver.findElement(By.cssSelector("a[href='/']"));

        //                                    ----xpath----
        // Locate "Home" link, using xpath, syntax #1-> //tagName[@attributeName='value']
         WebElement homeLink_ex4 = driver.findElement(By.xpath("//a[@class='nav-link']"));

        // Locate "Home" link, using xpath, syntax #2-> //tagName[text()='value'] -> //tagName[.='value']
         WebElement homeLink_ex5 = driver.findElement(By.xpath("//a[text()='Home']"));

         //_________________________________________________________________________________________________
        //b. “Forgot password” header

        //Locate header, using xpath, using text of h2
        WebElement header_ex1 = driver.findElement(By.xpath("//h2[text()='Forgot Password']"));
        WebElement header_ex2 = driver.findElement(By.xpath("//h2[.='Forgot Password']"));

        //Locate header, using cssSelector, syntax#1 locate parent element and move down to h2
        WebElement header_ex3 = driver.findElement(By.cssSelector("div[class= 'example'] > h2"));
        //Locate header, using cssSelector, syntax#2 locate parent element and move down to h2
        WebElement header_ex4 = driver.findElement(By.cssSelector("div.example > h2"));


        //_________________________________________________________________________________________________

        //c. “E-mail” text
        //Locate the 'email' label using xpath
        WebElement emailLabel_ex1 = driver.findElement(By.xpath("//label[@for= 'email']"));
        WebElement emailLabel_ex2 = driver.findElement(By.xpath("//label[.='E-mail']"));

        //d. E-mail input box
        //Locate 'email' input box using xpath
        WebElement emailInput_ex1 = driver.findElement(By.xpath("//input[@name='email']"));

        //Locate 'email' input box using xpath with contains methods -> //tagName[contains(@attribute, 'value')]
        WebElement emailInput_ex2 = driver.findElement(By.xpath("//input[contains(@pattern, '[a-z0-9')]"));

        //e. “Retrieve password” button
        // Locate it using xpath
        WebElement passwordButton = driver.findElement(By.xpath("//button[@id='form_submit']"));
        // this also work if there is only one button in the page -> //button[@id]

        //f. “Powered by Cydeo text
        WebElement powerdByCydeoText = driver.findElement(By.xpath("//div[@style='text-align: center;']"));

        //4. Verify all web elements are displayed.
        System.out.println("homeLink_ex1.isDisplayed() = " + homeLink_ex1.isDisplayed());
        System.out.println("header_ex1.isDisplayed() = " + header_ex1.isDisplayed());
        System.out.println("emailInput_ex1.isDisplayed() = " + emailInput_ex1.isDisplayed());
        System.out.println("passwordButton.isDisplayed() = " + passwordButton.isDisplayed());
        System.out.println("powerdByCydeoText.isDisplayed() = " + powerdByCydeoText.isDisplayed());

        //First solve the task with using cssSelector only. Try to create 2 different
        //cssSelector if possible
        //Then solve the task using XPATH only. Try to create 2 different
        //XPATH locator if possible

        // wait 2 seconds before closing the browser
        Thread.sleep(2000);
        driver.close();
    }
}
