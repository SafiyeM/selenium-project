package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicControlsPage {


    public DynamicControlsPage(){

        //#1: Create constructor and initialize the 'driver' instance and 'object' of the class.
        PageFactory.initElements(Driver.getDriver(), this);

    }


    //#: Instead of using .findElement()
    @FindBy(xpath = "//button[text()='Remove']")
    public WebElement removeButton;

    @FindBy(id = "loading")
    public WebElement loadingBar;

    @FindBy(css ="input[type='checkbox']")
    public WebElement checkbox;

    @FindBy(xpath = "//p[@id='message']")
    public WebElement message;

    @FindBy(xpath = "//input[@type='text']")
    public WebElement inputBox;

    @FindBy(xpath = "//button[.='Enable']")
    public WebElement enableButton;












}
