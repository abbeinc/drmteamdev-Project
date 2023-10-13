package ru.drmteamdev.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.drmteamdev.utility.ConfigReader;
import ru.drmteamdev.utility.Driver;

public class FirstPage {
@FindBy(xpath = "//a[text()='Зарегистрироваться']")
public WebElement geristrationLink;

@FindBy(xpath = "//a[@class='light-link header-login-link'][.='Войти']")
public WebElement loginRightTop;

    @FindBy(xpath = "//a[@class='dark-link links-blocks-item'][.='Войти']")
    public WebElement loginCenter;





static public void goToFirstPage(){
    Driver.getDriver().get(ConfigReader.read("drmteandev_url"));
}
public FirstPage(){
    PageFactory.initElements(Driver.getDriver(), this);}


}
