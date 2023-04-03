package com.example.MySelenium;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Stepdefinition {

    @Given ("SVT Play is available")
    public void svt_play_is_available() {}

    @When ("User visits SVT Play")
    public void user_visits_svt_play () {}

    @Then ("The title should be {string}")
    public void the_title_should_be(String string) {}
}
