package com.cydeo.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CRM_Utilities {

         /*
         This class will store the method related to CRM project.
         */

    public static void login_crm1(WebDriver driver){
          /*
    This method will log in using below credentials.
    @Username: helpdesk1@cybertekschool.com
    @Password: UserUser
     */

        //3. Enter valid username
        WebElement inputUsername = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        inputUsername.sendKeys("helpdesk1@cybertekschool.com");

        //4. Enter valid password
        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        inputPassword.sendKeys("UserUser");

        //5. Click to`LogIn`button
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();

        //6. Verify title is as expected:
        //Expected: Portal
        BrowserUtils.verifyTitle(driver, "Portal");


    }

    public static void login_crm2(WebDriver driver){

        //Logging in using the utility method we created in CRM_Utilities class
         CRM_Utilities.login_crm1(driver);

        //6. Verify title is as expected:
        //Expected: Portal
        BrowserUtils.verifyTitle(driver, "Portal");


    }

    public static void login_crm3(WebDriver driver, String username, String password){


        //3. Enter valid username
        WebElement loginInput = driver.findElement(By.xpath("//input[@name = 'USER_LOGIN']"));
        loginInput.sendKeys(username);

        //4. Enter valid password
        WebElement passwordInput = driver.findElement(By.xpath("//input[@type='password']"));
        passwordInput.sendKeys(password);

        //5. Click to `Log In` button
        WebElement loginLink = driver.findElement(By.xpath("//input[@value='Log In']"));
        loginLink.click();

        //6. Verify title is as expected:
        //Expected: Portal
        BrowserUtils.verifyTitle(driver, "Portal");


    }

    //TC #5: Create utility method
    //1. Create a new method for login
    //2. Create a method to make Task3 logic re-usable
    //3. When method is called, it should simply log in
    //This method should have at least 2 overloaded versions.

    //Method #1 info:
    //• Name: login_crm()
    //• Return type: void
    //• Arg1: WebDriver
    //Method #2 info:
    //• Name: login_crm()
    //• Return type: void
    //• Arg1: WebDriver
    //• Arg2: String username
    //• Arg3: String password


}
