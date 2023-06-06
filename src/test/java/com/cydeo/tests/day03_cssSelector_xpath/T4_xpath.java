package com.cydeo.tests.day03_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T4_xpath {

    public static void main(String[] args) {

        //TC #3: NextBaseCRM, locators, getText(), getAttribute() practice
        //1- Open a Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();

        //2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

        //3- Verify “Log in” button text is as expected:
        //Expected: Log In
        String expectedLoginText = "Log In";


        //===>>> Examples for locating the same web element(login button) using XPATH with different attributes <<<===\\

        // Syntax for XPATH ->                                //tagName[@attribute='value']

        //ex#1- locating loginButton using xpath using type attribute's value
        // WebElement loginButton = driver.findElement(By.xpath("//input[@type = 'submit']"));

        //ex#2- locating loginButton using xpath using value attribute's value
        //WebElement loginButton = driver.findElement(By.xpath("//input[@value = 'Log In']"));

        //ex#3- locating loginButton using xpath using class attribute's value
        WebElement loginButton = driver.findElement(By.xpath("//input[@class = 'login-btn']"));


        String actualLoginText = loginButton.getAttribute("value");

        if (actualLoginText.equals(expectedLoginText)) {
            System.out.println("Login button text verification PASSED!");
        } else {
            System.out.println("Login button text verification FAILED!");
        }


        //PS: Inspect and decide which locator you should be using to locate web
        //elements.
        //PS2: Pay attention to where to get the text of this button from


        driver.close();
    }
}
