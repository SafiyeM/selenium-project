package com.cydeo.tests.day04_findElements_checkboxes_radio;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class T3_checkBoxes_radioButtons {

    public static void main(String[] args) {


        //TC#3: Checkboxes
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //1. Go to https://practice.cydeo.com/checkboxes
        driver.get("https://practice.cydeo.com/checkboxes");

        //2. Confirm checkbox #1 is NOT selected by default
        WebElement checkbox1 = driver.findElement(By.xpath("//input[@name ='checkbox1']"));
        System.out.println("checkbox1 is selected (expecting false) = " + checkbox1.isSelected());

        //3. Confirm checkbox #2 is SELECTED by default.
        WebElement checkbox2 = driver.findElement(By.xpath("//input[@name ='checkbox2']"));
        System.out.println("checkbox2 is selected (expecting true)= " + checkbox2.isSelected());

        //4. Click checkbox #1 to select it.
        checkbox1.click();

        //5. Click checkbox #2 to deselect it.
        checkbox2.click();

        //6. Confirm checkbox #1 is SELECTED.
        System.out.println("checkbox1 is selected (expecting true) = " + checkbox1.isSelected());

        //7. Confirm checkbox #2 is NOT selected
        System.out.println("checkbox2 is selected (expecting false)= " + checkbox2.isSelected());

        driver.quit();
    }
}
