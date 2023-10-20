package ru.drmteamdev.step_definition;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.drmteamdev.pages.FirstPage;
import ru.drmteamdev.pages.LoginPage;
import ru.drmteamdev.pages.TaskPage;
import ru.drmteamdev.utility.ConfigReader;
import ru.drmteamdev.utility.Driver;

import java.time.Duration;

public class LoginStepDef {
    FirstPage firstPage = new FirstPage();
    LoginPage login = new LoginPage();
    Faker faker = new Faker();
    Actions actions = new Actions(Driver.getDriver());
    TaskPage taskPage = new TaskPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),Duration.ofMillis(5000));

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

        actions.clickAndHold(login.buttonEnter).release().perform();

    }
    @Then("user should not be able to login")
    public void user_should_not_be_able_to_login() {

        wait.until(ExpectedConditions.visibilityOfAllElements(login.warningMsg));
        Assert.assertEquals("This user is not registered yet", login.warningMsg.getText());
    }


    @When("user enters just unregistered email")
    public void user_enters_just_unregistered_email() {
        firstPage.loginRightTop.click();
        Assert.assertEquals("Вход", Driver.getDriver().getTitle());
        login.emailBox.sendKeys(faker.name().firstName()+"@yandex.ru");
        login.buttonEnter.submit();
    }


    @Then("user will see {string}")
    public void userWillSee(String str) {
        Assert.assertEquals(str, login.passwordWarning.getText());
    }

    @Given("user on the login page")
    public void user_on_the_login_page() {
       login.goToLoginPage();
    }
    @When("user enters confirmed email and valid password")
    public void user_enters_confirmed_email_and_valid_password() {
       login.emailBox.sendKeys(ConfigReader.read("volunteerEmail"));
        login.passwordBox.sendKeys(ConfigReader.read("volunteerEmailPassword"));
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofMillis(3000));
        wait.until(ExpectedConditions.elementToBeClickable(login.buttonEnter));
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(login.buttonEnter).click().perform();
    }
    @Then("user should see Task Page")
    public void user_should_see_task_page() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofMillis(3000));
        wait.until(ExpectedConditions.elementToBeClickable(taskPage.taskPageSgn));

        Assert.assertEquals("Задачи", Driver.getDriver().getTitle());


    }
    @Given("user on the task page")
    public void user_on_the_task_page() {
        login.goToLoginPage();
        login.emailBox.sendKeys(ConfigReader.read("volunteerEmail"));
        login.passwordBox.sendKeys(ConfigReader.read("volunteerEmailPassword"));
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofMillis(3000));
        wait.until(ExpectedConditions.elementToBeClickable(login.buttonEnter));
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(login.buttonEnter).click().perform();
        WebDriverWait wait1 = new WebDriverWait(Driver.getDriver(), Duration.ofMillis(3000));
        wait.until(ExpectedConditions.elementToBeClickable(taskPage.taskPageSgn));

        Assert.assertEquals("Задачи", Driver.getDriver().getTitle());

    }
    @When("if user click {string}")
    public void ifUserClick(String arg0) {
        wait.until(ExpectedConditions.elementToBeClickable(taskPage.exitButton));
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(taskPage.exitButton).click().perform();

    }
    @Then("user should see login page")
    public void user_should_see_login_page() {
     wait.until(ExpectedConditions.visibilityOf(login.emailBox));
       Assert.assertEquals("Вход", Driver.getDriver().getTitle());
    }




    @When("user as an admin enters confirmed email and valid password")
    public void userAsAnAdminEntersConfirmedEmailAndValidPassword() {
        login.goToLoginPage();
        login.emailBox.sendKeys(ConfigReader.read("adminEmail"));
        login.passwordBox.sendKeys(ConfigReader.read("adminEmailPassword"));
        wait.until(ExpectedConditions.elementToBeClickable(login.buttonEnter));
        actions.moveToElement(login.buttonEnter).click().perform();
        wait.until(ExpectedConditions.elementToBeClickable(taskPage.taskPageSgn));

        Assert.assertEquals("Задачи", Driver.getDriver().getTitle());
    }


    @When("user as an admin enters confirmed email and invalid {string}")
    public void userAsAnAdminEntersConfirmedEmailAndInvalid(String password) {

        login.emailBox.sendKeys(ConfigReader.read("adminEmail"));
        login.passwordBox.sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(login.buttonEnter));
        actions.moveToElement(login.buttonEnter).click().perform();

    }
    @Then("user should see warning sign Password not correct")
    public void userShouldSeeWarningSignPasswordNotCorrect() {

        Assert.assertTrue(login.passwordWarning.isDisplayed()||login.warningMsg.isDisplayed());

    }

    @When("user as a volunteer enters confirmed email and invalid {string}")
    public void userAsAVolunteerEntersConfirmedEmailAndInvalid(String password) {

        login.emailBox.sendKeys(ConfigReader.read("volunteerEmail"));
        login.passwordBox.sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(login.buttonEnter));
        actions.moveToElement(login.buttonEnter).click().perform();


    }
}
