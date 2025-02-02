package com.bukakasir.tes.hazna.jenkins.steps;

import net.thucydides.core.annotations.Steps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import com.bukakasir.tes.hazna.jenkins.steps.serenity.EndUserSteps;

public class DefinitionSteps {

    @Steps
    EndUserSteps anna;

    @Given("the user is on the Wikionary home page")
    public void givenTheUserIsOnTheWikionaryHomePage() {
        anna.is_the_home_page();
    }

    @When("the user looks up the definition of the word '(.*)'")
    public void whenTheUserLooksUpTheDefinitionOf(String word) {
        anna.looks_for(word);
    }

    @Then("they should see the definition '(.*)'")
    public void thenTheyShouldSeeADefinitionContainingTheWords(String definition) {
        anna.should_see_definition(definition);
    }

    @Given("^user go to gmail$")
    public void userGoToGmail() {
        anna.is_the_home_page();
    }

    @When("^user type in google$")
    public void userTypeInGoogle() {
        anna.type_username();
    }

    @When("^user type password$")
    public void userTypePassword() {
        anna.type_password();
    }
}
