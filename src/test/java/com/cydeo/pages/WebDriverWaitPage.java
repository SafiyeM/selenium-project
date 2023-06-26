package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebDriverWaitPage {


    public WebDriverWaitPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[.='Start']")
    public WebElement startButton;

    @FindBy(id = "loading")
    public WebElement loadingBar;

    @FindBy(xpath = "//input[@placeholder='Enter username']")
    public WebElement username;

    @FindBy(id = "pwd")
    public WebElement password;

    @FindBy(xpath = "//button[.='Submit']")
    public WebElement submitButton;

    @FindBy(id= "flash")
    public WebElement errorMessage;



}
