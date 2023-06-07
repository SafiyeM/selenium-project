package com.cydeo.tests.hwp_tasks.day03;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HWP2_ZeroBank_XPATH_CSS {


    public static void main(String[] args) {


        //HWP #2: Zero Bank header verification
        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2. Go to http://zero.webappsecurity.com/login.html
        driver.get("http://zero.webappsecurity.com/login.html");


        //3. Verify header text
        // locate header Text web element
        WebElement headerText = driver.findElement(By.xpath("//h3"));

        //Expected: “Log in to ZeroBank”
        String expectedHeaderText = "Log in to ZeroBank";
        String actualHeaderText = headerText.getText();

        if (actualHeaderText.equals(expectedHeaderText)) {
            System.out.println("Header text verification Passed!");
        } else {
            System.out.println("Header text verification Failed!");
        }


        driver.close();
    }
}
