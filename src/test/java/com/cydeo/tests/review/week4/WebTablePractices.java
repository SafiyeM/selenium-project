package com.cydeo.tests.review.week4;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class WebTablePractices extends BaseTest {




    @Test
    public void web_table_test(){


        // TC : Web table practice
        // 1. Open Chrome browser
        // 2. Go to https://practice.cydeo.com/tables -> all these steps handled in BaseTest


        // 3. Print table data as a single String, not so common, but useful sometimes
        WebElement table1 = Driver.getDriver().findElement(By.xpath("//table[@id='table1']"));
        System.out.println("table1.getText() = " + table1.getText());

        // 4. verify tconway@earthlink.net is anywhere in the table
        Assert.assertTrue(table1.getText().contains("tconway@earthlink.net"));

        // 5. print all column names in single line
        WebElement allColumnNames =Driver.getDriver().findElement(By.xpath("//table[@id='table1']/thead/tr"));
        System.out.println("allColumnNames.getText() = " + allColumnNames.getText());

        // 6. print each column name in separate lines using a loop and findElements method
        List<WebElement> columnNamesList = Driver.getDriver().findElements(By.xpath("//table[@id='table1']/thead/tr/th"));

        for (WebElement eachColumnName : columnNamesList) {
            System.out.println("eachColumnName.getText() = " + eachColumnName.getText());
        }

        // Locate John's due money
        //table[@id='table1']//td[.='jsmith@gmail.com']//following-sibling::td[1]

    }
}
