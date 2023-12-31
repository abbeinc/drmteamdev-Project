package ru.drmteamdev.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.drmteamdev.utility.Driver;

public class RegistrationPage {

  @FindBy(xpath = "//div[contains(.,'Регистрация')][@class='register-form-title']")
    public WebElement signRegistration;
@FindBy(xpath = "//div[@class='input-email']/input")
public WebElement emailField;

@FindBy(xpath = "//div[@class='input-password']/input[@placeholder='Придумайте пароль']")
public WebElement passwordField;

@FindBy(xpath = "//div[@class='input-password']/input[@placeholder='Повторите пароль']")
public WebElement passwordFieldConfirmation;

@FindBy(xpath = "//button[@class='button submit-button']")
public WebElement registerButton;

@FindBy(xpath ="//div[.='Email не может быть пустым'][@class = 'input-error-message']")
public WebElement errorMsg;

@FindBy(xpath = "//div[@class = 'toast']/div[@class='toast-message']")
public WebElement userExistMsg;

@FindBy(xpath = "//div[@class=\"input-error-message\"] [.='Введён некорректный email']")
public WebElement incorrectEmailSgn;

    @FindBy(xpath = "//div[@class='message-text']")
    public WebElement userCreatedMessage;

    @FindBy(xpath = "//form//input[@placeholder=\"Придумайте пароль\"]")
    public WebElement incorrectPasswordMsg;
    public RegistrationPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
