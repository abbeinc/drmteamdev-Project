package ru.drmteamdev.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.drmteamdev.utility.Driver;

public class LoginPage {
@FindBy(xpath = "//div[.='Вспомнить пароль']")
public WebElement textVspomnitParol;
@FindBy(xpath = "//input[@placeholder='E-mail']")
        public WebElement emailBox;
@FindBy(xpath = "//input[@type='password']")
        public WebElement passwordBox;

@FindBy(xpath = "//form//button[@class='button submit-button'][.='Войти']")
        public WebElement buttonEnter;

@FindBy(xpath = "//div[@class='toast-message']")
public WebElement warningMsg;

@FindBy(xpath = "//div[@class='input-password']/div")
public WebElement passwordWarning;

@FindBy(xpath = "//div[.='Repass successfully started, check your email'][@class='message-text']")
public WebElement restorePasswordMsg;
@FindBy(xpath = "//a[.='Вспомнить пароль']")
public WebElement restorePasswordLink;
@FindBy(xpath = "//input[@name='email']")
public WebElement restorePasswordInput;
@FindBy(xpath = "//div[@class='toast']")
public WebElement restoreNotValidEmailMsg;
    @FindBy(xpath = "//button[.='Вспомнить']")
    public WebElement restorePasswordButton;


public void goToLoginPage(){
    Driver.getDriver().get("https://drmteamdev.ru/login");
}
    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }





}
