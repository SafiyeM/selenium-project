package com.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_RegistrationForm {


    //TC#1: Registration form confirmation
    //1. Open browser

    @Test
    public void registration_form_test(){

        //2. Go to website: https://practice.cydeo.com/registration_form
        Driver.getDriver().get(ConfigurationReader.getProperty("registration.form.url"));

        Faker faker = new Faker();
        //3. Enter first name
        WebElement firstNameInput = Driver.getDriver().findElement(By.name("firstname"));
        firstNameInput.sendKeys(faker.name().firstName());

        //4. Enter last name
        WebElement lastNameInput = Driver.getDriver().findElement(By.name("lastname"));
        lastNameInput.sendKeys(faker.name().lastName());

        //5. Enter username
        WebElement userNameInput =Driver.getDriver().findElement(By.xpath("//input[@name='username']"));
        userNameInput.sendKeys("janeDoe58");

        //6. Enter email address
        WebElement emailAddressInput = Driver.getDriver().findElement(By.xpath("//input[@name='email']"));
        emailAddressInput.sendKeys(faker.internet().emailAddress());

        //7. Enter password
        WebElement passwordInput = Driver.getDriver().findElement(By.name("password"));
        passwordInput.sendKeys(faker.internet().password());

        //8. Enter phone number
        WebElement phoneNumberInput = Driver.getDriver().findElement(By.name("phone"));
        phoneNumberInput.sendKeys(faker.numerify("###-###-####"));

        //9. Select a gender from radio buttons
        WebElement radioButtonFemale = Driver.getDriver().findElement(By.xpath("//input[@value='female']"));
        radioButtonFemale.click();


        //10. Enter date of birth
        WebElement birthdayInput =Driver.getDriver().findElement(By.name("birthday"));
        birthdayInput.sendKeys("05/26/1982");

        //11. Select Department/Office
        Select departmentDropdown = new Select(Driver.getDriver().findElement(By.name("department")));
        departmentDropdown.selectByVisibleText("Department of Engineering");

        //12. Select Job Title
        Select jobTitleDropdown = new Select(Driver.getDriver().findElement(By.name("job_title")));
        jobTitleDropdown.selectByVisibleText("SDET");

        //13. Select programming language from checkboxes
        WebElement javaCheckBox = Driver.getDriver().findElement(By.xpath("//input[@value='java']"));
        javaCheckBox.click();

        //14. Click to sign up button
        WebElement signUpButton = Driver.getDriver().findElement(By.id("wooden_spoon"));
        signUpButton.click();

        //15. Verify success message “You’ve successfully completed registration.” is
        //displayed
        WebElement successMessage = Driver.getDriver().findElement(By.xpath("//div[@role='alert']"));
        Assert.assertTrue(successMessage.isDisplayed());




        //driver.quit();
        //Driver.getDriver().quit(); --> we don't use this method anymore. Because we want to assign the value back to null
        // So if we have another test, our code can continue executing.
        Driver.closeDriver(); // in this method, after terminating the program with quit() method,
        // we assign the value of driver back to "null" so that our "singleton" can create a newer one if needed.

    }

}
