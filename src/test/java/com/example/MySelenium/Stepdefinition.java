package com.example.MySelenium;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.assertEquals;

public class Stepdefinition {

    @Given ("SVT Play is available")
    public void svt_play_is_available() {

        System.setProperty("webdriver.chrome.driver", "C:/MySelenium/chromedriver.exe/");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.svtplay.se/");
    }
    @When ("User visits SVT Play")
    public void user_visits_svt_play () {


    }

    @Then ("The title should be {string}")
    public void the_title_should_be(String string) {}
}
