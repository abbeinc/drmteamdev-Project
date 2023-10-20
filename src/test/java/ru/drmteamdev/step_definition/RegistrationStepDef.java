package ru.drmteamdev.step_definition;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.drmteamdev.pages.FirstPage;
import ru.drmteamdev.pages.RegistrationPage;
import ru.drmteamdev.pages.UserCreatedPage;
import ru.drmteamdev.utility.ConfigReader;
import ru.drmteamdev.utility.Driver;

import java.time.Duration;

public class RegistrationStepDef {
    RegistrationPage registrationPage = new RegistrationPage();
    FirstPage firstPage = new FirstPage();
    Faker faker = new Faker();
    String password;
    String fakerEmail;
    Actions actions = new Actions(Driver.getDriver());



    @Given("user at the {string} page")
    public void user_at_the_page(String string) {
        FirstPage.goToFirstPage();
        Assert.assertEquals("Title does not match", string, Driver.getDriver().getTitle());
            }
    @When("user click {string}")
    public void user_click(String string) {
       FirstPage firstPage = new FirstPage();
       firstPage.geristrationLink.click();

    }
    @Then("user should see page with a title {string}")
    public void user_should_see_page_with_a_title(String title) {
        Assert.assertEquals(title, Driver.getDriver().getTitle());
    }

    @Given("user at the {string} page2")
    public void user_at_the_page2(String string) {
       FirstPage.goToFirstPage();
       FirstPage firstPage = new FirstPage();
       firstPage.geristrationLink.click();
        Assert.assertEquals(string, Driver.getDriver().getTitle());

    }

    @When("user enters e-mail")
    public void user_enters_e_mail() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofMillis(5000));

        wait.until(ExpectedConditions.visibilityOf(registrationPage.emailField));

        fakerEmail = faker.name().firstName()+"@yandex.ru";
        registrationPage.emailField.click();
        registrationPage.emailField.sendKeys(fakerEmail);


    }

    @When("password and repeat password")
    public void password_and_repeat_password() {
        password = faker.number().digits(5);
        registrationPage.passwordField.sendKeys(password);
        registrationPage.passwordFieldConfirmation.sendKeys(password);


        }
    @When("click {string}")
    public void click(String string) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),Duration.ofMillis(2000));
        wait.until(ExpectedConditions.visibilityOf(registrationPage.registerButton));
        registrationPage.registerButton.submit();

        actions.moveToElement(registrationPage.registerButton).click().perform();
        actions.pause(3000).perform();
    }
    @Then("user should see {string}")
    public void user_should_see(String string) throws InterruptedException {
        Thread.sleep(5000);
        UserCreatedPage userCreatedPage = new UserCreatedPage();

        Assert.assertEquals(string, userCreatedPage.UserCreatedMessage.getText());


    }
    @When("user click registration button without email and password")
    public void user_click_registration_button_without_email_and_password() {
        registrationPage.registerButton.click();
    }
    @Then("user should see warning {string}")
    public void user_should_see_warning(String string) {
        Assert.assertEquals(string, registrationPage.errorMsg.getText());


    }


    @Given("user at the {string} page2 trying to create with the same credentials")
    public void user_at_the_page2_trying_to_create_with_the_same_credentials(String string) {
        FirstPage.goToFirstPage();
        FirstPage firstPage = new FirstPage();
        firstPage.geristrationLink.click();
        Assert.assertEquals(string, Driver.getDriver().getTitle());

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofMillis(5000));

        wait.until(ExpectedConditions.visibilityOf(registrationPage.emailField));

        fakerEmail = faker.name().firstName()+"@yandex.ru";
        registrationPage.emailField.click();
        registrationPage.emailField.sendKeys(fakerEmail);

        password = faker.number().digits(5);
        registrationPage.passwordField.sendKeys(password);
        registrationPage.passwordFieldConfirmation.sendKeys(password);
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(registrationPage.registerButton).click().perform();
        WebDriverWait wait1 = new WebDriverWait(Driver.getDriver(), Duration.ofMillis(5000));

        wait.until(ExpectedConditions.visibilityOf(registrationPage.emailField));

        UserCreatedPage userCreatedPage = new UserCreatedPage();
        WebDriverWait wait2 = new WebDriverWait(Driver.getDriver(), Duration.ofMillis(5000));

        wait.until(ExpectedConditions.visibilityOf(userCreatedPage.UserCreatedMessage));
        String msg = "User has been successfully created, check your email";
        Assert.assertEquals(msg, userCreatedPage.UserCreatedMessage.getText());

    }

    @When("user enters existing e-mail and password")
    public void user_enters_existing_e_mail_and_password() throws InterruptedException {
        Thread.sleep(2000);
        Driver.getDriver().get(ConfigReader.read("drmteandev_url"));
        FirstPage firstPage = new FirstPage();
        firstPage.geristrationLink.click();


        registrationPage.emailField.sendKeys(fakerEmail);
        registrationPage.passwordField.sendKeys(password);
        registrationPage.passwordFieldConfirmation.sendKeys(password);

        registrationPage.registerButton.submit();
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(registrationPage.registerButton).click().perform();
    }


    @Then("user should see alert {string} message")
    public void user_should_see_alert_message(String string) {
       Assert.assertEquals(string, registrationPage.UserExistMsg.getText());



    }

    @Given("user at the Регистрация page")
    public void userAtTheРегистрацияPage() {
        FirstPage.goToFirstPage();
    }
    @When("user enters {string} and {string}")
    public void userEntersAnd(String arg0, String arg1) {
       Actions actions = new Actions(Driver.getDriver());
       actions.moveToElement(firstPage.geristrationLink).click().perform();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofMillis(2000));
        wait.until(ExpectedConditions.visibilityOf(registrationPage.emailField));
        registrationPage.emailField.sendKeys(arg0);
        registrationPage.passwordField.sendKeys(arg1);
        registrationPage.passwordFieldConfirmation.sendKeys(arg1);


    }

    @Then("user should see warning")
    public void userShouldSeeWarning() {
        Assert.assertEquals("Введён некорректный email", registrationPage.IncorrectEmailSgn.getText());

    }


    @And("{int} char. password and repeat password")
    public void charPasswordAndRepeatPassword(int num) {
      password = faker.number().digits(num)+faker.chuckNorris().fact();
      registrationPage.passwordField.sendKeys(password);
      registrationPage.passwordFieldConfirmation.sendKeys(password);

    }



    @Then("user should see registration page")
    public void userShouldSeeRegistrationPage() {
        actions.pause(2000).perform();
    Assert.assertTrue(registrationPage.signRegistration.isDisplayed());
    }
}
