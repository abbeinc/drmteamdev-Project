package ru.drmteamdev.step_definition;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
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
import ru.drmteamdev.pages.TaskPage;
import ru.drmteamdev.utility.ConfigReader;
import ru.drmteamdev.utility.Driver;

import java.time.Duration;

public class ForgotPasswordStepDef {
    FirstPage firstPage = new FirstPage();
    LoginPage login = new LoginPage();
    Faker faker = new Faker();
    Actions actions = new Actions(Driver.getDriver());
    TaskPage taskPage = new TaskPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofMillis(5000));

    @Given("user at the login page")
    public void user_at_the_login_page() {
        FirstPage.goToFirstPage();
        firstPage.loginCenter.click();
    }

    @When("user click Вспомнить пароль")
    public void user_click_вспомнить_пароль() {
        login.restorePasswordLink.click();
    }

    @And("enters his valid {string} and click Вспомнить")
    public void entersHisValidAndClickВспомнить(String email) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(login.restorePasswordInput));
        actions.sendKeys(login.restorePasswordInput, email).perform();
        actions.sendKeys(Keys.ESCAPE).perform();
        actions.moveToElement(login.restorePasswordButton).pause(1000).click().perform();

    }

    @Then("user should see the message Repass successfully started")
    public void user_should_see_the_message_repass_successfully_started() {
        wait.until(ExpectedConditions.visibilityOf(login.restorePasswordMsg));
        Assert.assertTrue(login.restorePasswordMsg.isDisplayed());
    }


    @And("enters his valid  not registered email and click Вспомнить")
    public void entersHisValidNotRegisteredEmailAndClickВспомнить() {
        wait.until(ExpectedConditions.visibilityOf(login.restorePasswordInput));
        actions.sendKeys(login.restorePasswordInput, faker.name().firstName() + "@yandex.ru").perform();
        actions.sendKeys(Keys.ESCAPE).perform();
        actions.moveToElement(login.restorePasswordButton).pause(1000).click().perform();
    }

    @Then("user should see warning message")
    public void userShouldSeeWarningMessage() {
        wait.until(ExpectedConditions.visibilityOf(login.restoreNotValidEmailMsg));
        Assert.assertTrue(login.restoreNotValidEmailMsg.isDisplayed());

    }
}
