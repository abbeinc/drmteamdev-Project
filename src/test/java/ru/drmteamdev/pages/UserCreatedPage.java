package ru.drmteamdev.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.drmteamdev.utility.Driver;

public class UserCreatedPage {

    @FindBy(xpath = "//div[@class='message-text']")
    public WebElement UserCreatedMessage;

public UserCreatedPage(){
    PageFactory.initElements(Driver.getDriver(), this);

}

}
