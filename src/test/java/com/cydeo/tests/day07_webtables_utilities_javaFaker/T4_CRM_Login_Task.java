package com.cydeo.tests.day07_webtables_utilities_javaFaker;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T4_CRM_Login_Task {


    WebDriver driver;

    @BeforeMethod

    public void setup(){
        //1. make set up
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2. Go to: http://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

    }

    @Test
    public void test1_crm_login(){

        //TC #4: Login scenario

        //3. Enter valid username
        WebElement loginInput = driver.findElement(By.xpath("//input[@name = 'USER_LOGIN']"));
        loginInput.sendKeys("hr1@cybertekschool.com");

        //4. Enter valid password
        WebElement passwordInput = driver.findElement(By.xpath("//input[@type='password']"));
        passwordInput.sendKeys("UserUser");

        //5. Click to `Log In` button
        WebElement loginLink = driver.findElement(By.xpath("//input[@value='Log In']"));
        loginLink.click();

        //6. Verify title is as expected:
        //Expected: Portal
        BrowserUtils.verifyTitle(driver, "(1) Portal");

        //USERNAME PASSWORD
        //helpdesk1@cybertekschool.com UserUser
        //helpdesk2@cybertekschool.com UserUser

    }



    @AfterMethod
    public void tearDown(){
        driver.quit();
    }




}
