package com.cydeo.tests.review.week3;

import com.cydeo.tests.base.TestBase;
import com.cydeo.utilities.CRM_Utilities;
import com.cydeo.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IFramePractice extends TestBase {

    // TC : Iframe practice
    // 1. Users are already login and on the homepage of CRM app
    // 2. Users click the MESSAGE tab
    // 3. Users write test message
    // 4. Users click the SEND button
    // 5. Verify the message is displayed on the feed

    @Test
    public void sending_message_iframe_test(){


        // 1. Users are already login and on the homepage of CRM app
        driver.get(ConfigurationReader.getProperty("env"));

        CRM_Utilities.login_crm3(driver,ConfigurationReader.getProperty("username"),ConfigurationReader.getProperty("password"));

        // 2. Users click the MESSAGE tab
        driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-message']")).click();

        // 3. Users write test message
        //  driver.switchTo().frame(0);
        driver.switchTo().frame(driver.findElement(By.cssSelector(".bx-editor-iframe")));

        // this is an iframe body, we have switched the driver's attention to the iframe
        WebElement msgFrame = driver.findElement(By.tagName("body"));
        msgFrame.sendKeys("Hello");


        // 4. Users click the SEND button

        // now we need to switch the driver to parent HTML to click button
        // because the button is outside the iframe and inside the main HTML, otherwise we get NoSuchElementException
        //driver.switchTo().parentFrame(); // it will take to the parent iframe if there is a parent
        driver.switchTo().defaultContent(); // it will take to the main HTML
                                         // id # for cssSelector
        driver.findElement(By.cssSelector("#blog-submit-button-save")).click();


        // 5. Verify the message is displayed on the feed
        WebElement feedMsg = driver.findElement(By.xpath("//div[contains(@id,'blog_post_body')]"));
        String actualMsg = feedMsg.getText();
        String expectedMsg = "Hello";

        Assert.assertEquals(actualMsg,expectedMsg);



    }




}
