package ru.drmteamdev.step_definition;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.drmteamdev.pages.FirstPage;
import ru.drmteamdev.pages.LoginPage;
import ru.drmteamdev.utility.Driver;

import java.time.Duration;

public class Login {
    FirstPage firstPage = new FirstPage();
    LoginPage login = new LoginPage();
    Faker faker = new Faker();
    @Given("user on the main page")
    public void user_on_the_main_page() {
        FirstPage.goToFirstPage();
        Assert.assertEquals("https://drmteamdev.ru/", Driver.getDriver().getCurrentUrl());
    }
    @When("user enters not registered email")
    public void user_enters_not_registered_email() {
        firstPage.loginRightTop.click();
        Assert.assertEquals("Вход", Driver.getDriver().getTitle());
        login.emailBox.sendKeys(faker.name().firstName()+"@yandex.ru");
        login.passwordBox.sendKeys(faker.number().digits(10));
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofMillis(3000));
        wait.until(ExpectedConditions.elementToBeClickable(login.buttonEnter));
        Actions actions = new Actions(Driver.getDriver());
        actions.clickAndHold(login.buttonEnter).release().perform();

    }
    @Then("user should not be able to login")
    public void user_should_not_be_able_to_login() {
        Assert.assertEquals("This user is not registered yet", login.WarningMsg.getText());
    }

}
