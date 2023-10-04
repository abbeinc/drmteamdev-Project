package ru.drmteamdev.step_definition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import ru.drmteamdev.utility.ConfigReader;
import ru.drmteamdev.utility.Driver;

public class FirstPageStepDef {
    String url;
    @Given("correct url")
    public void correct_url() {
       url = ConfigReader.read("drmteandev_url");
    }
    @When("user pass the correct url")
    public void user_pass_the_correct_url() {
        Driver.getDriver().get(url);
    }

    @Then("the title will be {string}")
    public void the_title_will_be(String string) {
        Assert.assertEquals("Tile dose not match ", Driver.getDriver().getTitle(), string);
    }
    @Then("the url will match the url he entered")
    public void the_url_will_match_the_url_he_entered() {
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), url);
    }



}
