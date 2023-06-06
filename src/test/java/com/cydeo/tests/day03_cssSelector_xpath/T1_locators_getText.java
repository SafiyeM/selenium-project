package com.cydeo.tests.day03_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T1_locators_getText {

    public static void main(String[] args) {

        //TC #1: NextBaseCRM, locators and getText() practice
        //1- Open a Chrome browser
        // WebDriverManager.chromedriver().setup();
        // WebDriver driver = new ChromeDriver();

        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();

        //2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

        //3- Enter incorrect username: “incorrect”
        // - locate web element by class attribute
        WebElement usernameInput = driver.findElement(By.className("login-inp"));
        usernameInput.sendKeys("incorrectUsername");

        //4- Enter incorrect password: “incorrect”
        // - locate web element by name attribute
        WebElement passwordInput = driver.findElement(By.name("USER_PASSWORD"));
        passwordInput.sendKeys("incorrectPassword");

        //5- Click to "Log in" button.
        WebElement loginButton = driver.findElement(By.className("login-btn"));
        loginButton.click();

        //6- Verify error message text is as expected:
        //Expected: Incorrect login or password
        String expectedErrorMessage = "Incorrect login or password";
        String actualErrorMessage = driver.findElement(By.className("errortext")).getText();

        if (actualErrorMessage.equals(expectedErrorMessage)) {
            System.out.println("Error message text verification PASSED!");
        } else {
            System.out.println("Error message text verification FAILED!");
        }

        //PS: Inspect and decide which locator you should be using to locate web
        //elements

        driver.close();

    }
}
