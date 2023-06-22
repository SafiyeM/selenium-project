package com.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T3_Actions_Hover {


    @Test
    public void hovering_test(){

        //TC #3: Hover Test
        //1. Go to https://practice.cydeo.com/hovers

        Driver.getDriver().get("https://practice.cydeo.com/hovers");

        //locate all the images here (by locating with index number use parentheses, regardless they are siblings or not)
        WebElement image1 = Driver.getDriver().findElement(By.xpath("(//img)[1]"));
        WebElement image2 = Driver.getDriver().findElement(By.xpath("(//img)[2]"));
        WebElement image3 = Driver.getDriver().findElement(By.xpath("(//img)[3]"));

        //locate all the user headers
        WebElement user1 =Driver.getDriver().findElement(By.xpath("//h5[.='name: user1']")); // or //h5[1]
        WebElement user2 =Driver.getDriver().findElement(By.xpath("//h5[.='name: user2']")); // or //h5[2]
        WebElement user3 =Driver.getDriver().findElement(By.xpath("//h5[.='name: user3']")); // or //h5[3]

        // To be able to hover on images, we need to create Actions class object,
        // and pass 'driver' in the constructor
        Actions actions = new Actions(Driver.getDriver());

        //2. Hover over to first image
        actions.moveToElement(image1).perform();

        //3. Assert:
        //a. “name: user1” is displayed
        Assert.assertTrue(user1.isDisplayed());

        //4. Hover over to second image
        actions.moveToElement(image2).perform();

        //5. Assert:
        //a. “name: user2” is displayed
        Assert.assertTrue(user2.isDisplayed());

        //6. Hover over to third image
        actions.moveToElement(image3).perform();

        //7. Assert:
        //a. “name: user3” is displayed
        Assert.assertTrue(user3.isDisplayed());

        // close browser
        Driver.closeDriver();

    }





}
