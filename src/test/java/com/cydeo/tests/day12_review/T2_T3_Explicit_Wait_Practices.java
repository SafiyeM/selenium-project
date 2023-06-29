package com.cydeo.tests.day12_review;

import com.cydeo.pages.DynamicControlsPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class T2_T3_Explicit_Wait_Practices {

    //NOTE: FOLLOW POM

    // declare the object in the class level
    DynamicControlsPage dynamicControlsPage;


    @BeforeMethod
    public void setup(){

        //1- Open a Chrome browser
        //2- Go to: https://practice.cydeo.com/dynamic_controls
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_controls");

        dynamicControlsPage= new DynamicControlsPage();
        // we instantiate this object in before method level,
        // because we will be using this object in each test in this class
        // before method applies it in each test with new object and session

    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }


    @Test
    public void t2_remove_checkbox_test(){

        //TC #2: Explicit wait practice

        //3- Click to “Remove” button
        dynamicControlsPage.removeButton.click();


        //4- Wait until “loading bar disappears”
        //Create the object of 'WebDriverWait' class, and set up the constructor args
        //WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        //use the 'wait' object with the proper syntax to create explicit wait conditions.
        //wait.until(ExpectedConditions.invisibilityOf(dynamicControlsPage.loadingBar));

        //Using the custom utility method 'waitForInvisibilityOf' to wait loadingBar disappears
        BrowserUtils.waitForInvisibilityOf(dynamicControlsPage.loadingBar);

        //5- Verify:
        //a. Checkbox is not displayed
        //dynamicControlsPage.checkbox.isDisplayed(); -> if displayed, returns true.
        // But we want to verify, if not displayed


       // Assert.assertTrue(!dynamicControlsPage.checkbox.isDisplayed());


       try {
           //assertFalse method is expecting a "false" boolean value to PASS the test.
           Assert.assertFalse(dynamicControlsPage.checkbox.isDisplayed());

       }catch (NoSuchElementException e){
          // e.printStackTrace();
           System.out.println("NoSuchElementException is thrown. It means that the Checkbox is not on the page.");
           Assert.assertTrue(true); // it will always pass this test
       }


        //b. “It’s gone!” message is displayed
        Assert.assertTrue(dynamicControlsPage.message.isDisplayed());


    }



    @Test
    public void t3_input_box_test(){

        //TC #3: Explicit wait practice

        //3- Click to “Enable” button
        dynamicControlsPage.enableButton.click();

        //WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        //use the 'wait' object with the proper syntax to create explicit wait conditions.
        //wait.until(ExpectedConditions.invisibilityOf(dynamicControlsPage.loadingBar));

        //4- Wait until “loading bar disappears”
        //Using the custom utility method 'waitForInvisibilityOf' to wait loadingBar disappears
        BrowserUtils.waitForInvisibilityOf(dynamicControlsPage.loadingBar);

        //5- Verify:
        //a. Input box is enabled.
        Assert.assertTrue(dynamicControlsPage.inputBox.isEnabled());

        //b. “It’s enabled!” message is displayed.
        Assert.assertTrue(dynamicControlsPage.message.isDisplayed());

        Assert.assertTrue(dynamicControlsPage.message.getText().equals("It's enabled!"));

    }






}
