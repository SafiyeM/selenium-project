package com.cydeo.tests.day11_pom_explicit_waits;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
                                              //after we import Assert class as static explicitly,
                                              // I do not need to call first the Class name while I am using assertTrue() method

public class T2_to_T6_Actions_Practices {

    @BeforeMethod
    public void setup(){

        //1. Go to https://practice.cydeo.com/drag_and_drop_circles
        Driver.getDriver().get("https://practice.cydeo.com/drag_and_drop_circles");
    }

    @AfterMethod
    public void tearDown(){

        Driver.closeDriver();
    }

    @Test
    public void test2_big_circle_default_value_verification() {

        //TC2 #: Drag and drop default value verification

        //Locate the big circle text
        WebElement bigCircleText = Driver.getDriver().findElement(By.xpath("//div[@id='droptarget']"));

        //2. Verify big circle default text is as below.
        // Assert:
        //-Text in big circle changed to: “Drag the small circle here.”
        String expectedText = "Drag the small circle here.";
        String actualText = bigCircleText.getText();

        // Assert.assertEquals(actualText, expectedText);
        // Assert.assertTrue(bigCircleText.getText().equals("Drag the small circle here.")); -> we can also write our Assertion in one line code
        assertTrue(actualText.equals(expectedText));
    }


    @Test
    public void test3_drop_into_the_big_circle(){


        //TC3 #: Drag and drop into the big circle

        //Locate the big circle text
        WebElement bigCircleText = Driver.getDriver().findElement(By.xpath("//div[@id='droptarget']"));
        //Locate the small circle
        WebElement smallCircleText = Driver.getDriver().findElement(By.xpath("//div[@id='draggable']"));

        // Creating the Actions object to do our actions
        Actions actions =new Actions(Driver.getDriver());

        //2. Drag and drop the small circle to bigger circle.
       // actions.dragAndDrop(smallCircleText, bigCircleText).perform();
        actions.clickAndHold(smallCircleText)
                .pause(1000)
                .moveToElement(bigCircleText)
                .pause(1000)
                .release()
                .perform();


        //3. Assert:
        //-Text in big circle changed to: “You did great!”
        String actualText =bigCircleText.getText();
        String expectedText = "You did great!";

        assertTrue(actualText.equals(expectedText));
    }


    @Test
    public void test4_click_hold_small_circle(){


        // TC4 #: Click and hold

        //Locate the big circle text
        WebElement bigCircle = Driver.getDriver().findElement(By.xpath("//div[@id='droptarget']"));
        //Locate the small circle
        WebElement smallCircle = Driver.getDriver().findElement(By.xpath("//div[@id='draggable']"));


        // Creating the Actions object to do our actions
        Actions actions =new Actions(Driver.getDriver());

        //locate link to pass to moveToElement() method
        WebElement cydeoLink = Driver.getDriver().findElement(By.linkText("CYDEO"));

        //2. Click and hold the small circle.
        actions.clickAndHold(smallCircle)
                .pause(1000)
                .moveToElement(cydeoLink)
                .pause(1000)
                .perform();


        //3. Assert:
        //-Text in big circle changed to: “Drop here.”
        String actualText =bigCircle.getText();
        String expectedText = "Drop here.";

        assertTrue(actualText.equals(expectedText));
    }


    @Test
    public void test5_drop_outside_of_big_circle(){
        //TC5 #: drop_outside_of_big_circle

        //Locating the circle web elements
        WebElement bigCircle = Driver.getDriver().findElement(By.id("droptarget"));
        WebElement smallCircle = Driver.getDriver().findElement(By.id("draggable"));

        //Creating the Actions object to do our actions
        Actions actions = new Actions(Driver.getDriver());

        //2. Drag and drop the small circle to bigger circle.
        //actions.dragAndDrop(smallCircle, bigCircle).perform();
        WebElement cydeoLink = Driver.getDriver().findElement(By.linkText("CYDEO"));

        actions.clickAndHold(smallCircle)
                .pause(1000)
                .moveToElement(cydeoLink)
                .pause(1000)
                .release()
                .perform();


        //3. Assert:
        //-Text in big circle changed to: “Try again!”
        String expectedText = "Try again!";
        String actualBigCircleText = bigCircle.getText();

        assertTrue(actualBigCircleText.equals(expectedText));
    }



    @Test
    public void test_6_big_circle_hovering_test_verify(){

        //TC6 #: Drag and hover

        //Locating the circle web elements
        WebElement bigCircle = Driver.getDriver().findElement(By.id("droptarget"));
        WebElement smallCircle = Driver.getDriver().findElement(By.id("draggable"));

        //Creating the Actions object to do our actions
        Actions actions = new Actions(Driver.getDriver());

        //2. Drag and drop the small circle to bigger circle.
        actions.clickAndHold(smallCircle)
                .pause(1000)
                .moveToElement(bigCircle)
                .pause(1000)
                .perform();

        //2. Drag the small circle on top of the big circle, hold it, and verify.
        //3. Assert:
        //-Text in big circle changed to: “Now drop...”
        String expectedText = "Now drop...";
        String actualBigCircleText = bigCircle.getText();

        assertTrue(actualBigCircleText.equals(expectedText));

    }


}
