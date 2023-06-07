package com.cydeo.tests.hwp_tasks.day03;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HWP1_Etsy_Xpath_CSS {

    public static void main(String[] args) {


        //HWP #1: Etsy Title Verification
        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2. Go to https://www.etsy.com
        driver.get("https://www.etsy.com");

        //Click the "accept" cookies policy button
        // driver.findElement(By.cssSelector("button[class='wt-btn wt-btn--filled wt-mb-xs-0']")).click();
        driver.findElement(By.xpath("//button[@class='wt-btn wt-btn--filled wt-mb-xs-0']")).click();

        //3. Search for “wooden spoon”
        //Locate search box on the page

        //XPATH LOCATOR EXAMPLES
        //tag[@attribute='value']
        //WebElement searchBox = driver.findElement(By.xpath("//input[@type='text']"));
        //WebElement searchBox = driver.findElement(By.xpath("//input[@data-id='search-query']"));
        //WebElement searchBox = driver.findElement(By.xpath("//input[@id='global-enhancements-search-query']"));
        //WebElement searchBox = driver.findElement(By.xpath("//input[@name='search_query']"));
        //WebElement searchBox = driver.findElement(By.xpath("//input[@placeholder='Search for anything']"));

        //input[@type='text']
        //*[@type='text']

        //cssSelector locator
        //syntax #1 : tagName[attribute='value']
        //syntax #2 : for id: --> tag#idValue, for class: tag.classValue
        //WebElement searchBox = driver.findElement(By.cssSelector("input[id='global-enhancements-search-query']"));
        WebElement searchBox = driver.findElement(By.cssSelector("input#global-enhancements-search-query"));

        searchBox.sendKeys("wooden spoon" + Keys.ENTER);

        //4. Verify title:
        //Expected: “Wooden spoon - Etsy”
        String expectedTitle = "Wooden spoon - Etsy DE";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Etsy title verification PASSED!");
        } else {
            System.out.println("Etsy title verification FAILED!");
        }


        driver.close();
    }
}
