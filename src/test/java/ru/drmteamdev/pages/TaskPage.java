package ru.drmteamdev.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.drmteamdev.utility.Driver;

public class TaskPage {
    public TaskPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//h1[.='Tasks Page']")
    public WebElement taskPageSgn;

    @FindBy(xpath = "//span[@class='light-link header-logout-link']")
    public WebElement exitButton;
}
