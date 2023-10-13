package ru.drmteamdev.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.drmteamdev.utility.Driver;

public class LoginPage {

@FindBy(xpath = "//input[@placeholder='E-mail']")
        public WebElement emailBox;
@FindBy(xpath = "//input[@type='password']")
        public WebElement passwordBox;

@FindBy(xpath = "//form//button[@class='button submit-button'][.='Войти']")
        public WebElement buttonEnter;

@FindBy(xpath = "//div[@class='toast-message']")
public WebElement warningMsg;

@FindBy(xpath = "//div[@class='input-error-message'][.='Пароль не может быть пустым']")
public WebElement PasswordWarning;

public void goToLoginPage(){
    Driver.getDriver().get("https://drmteamdev.ru/login");
}
    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }





}
