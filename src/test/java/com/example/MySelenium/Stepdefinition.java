package com.example.MySelenium;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class Stepdefinition {

    static WebDriver driver;
    static WebDriverWait wait;

    static JavascriptExecutor js;

    @Given("SVT Play is available")
    public void svt_play_is_available() {

        System.setProperty("webdriver.chrome.driver", "C:/MySelenium/chromedriver.exe/");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.get("https://www.svtplay.se/");


    }

    @When("User visits SVT Play")
    public void user_visits_svt_play() {
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("#__next > div.sc-4f221cd2-1.fHHyBJ > div > div.sc-4f221cd2-8.bRFLbH > button.sc-5b00349a-2.fuGbXH.sc-4f221cd2-9.hEiUxP")).click();
    }

    @Then("The title should be {string}")
    public void the_title_should_be(String expectedTitle) {

        String actualTitle = driver.getTitle();

        assertEquals(expectedTitle, actualTitle);
    }


    @Then("The website logo is visible")
    public void theWebsiteLogoIsVisible() {


        WebElement websiteLogo = driver.findElement(By.cssSelector("#__next > div > div.play_root-container > div > header > div.sc-5a076cf9-1.kyZyc > div > div > nav > a > svg"));

        String websiteLogoText = websiteLogo.getText();

        Assertions.assertEquals("SVT Play logotyp", websiteLogoText, "Logan är inte synlig..");

    }

    @Then("test the MainLink {string}")
    public void testTheMainLink(String arg0) {

        WebElement Start = driver.findElement(By.cssSelector("#__next > div > div.play_root-container > div > header > div.sc-5a076cf9-1.kyZyc > div > div > nav > ul > li:nth-child(1) > a"));

        driver.findElement(By.cssSelector("#__next > div.sc-4f221cd2-1.fHHyBJ > div > div.sc-4f221cd2-8.bRFLbH > button.sc-5b00349a-2.fuGbXH.sc-4f221cd2-9.hEiUxP")).click();

        String StartText = Start.getText();

        Assertions.assertEquals("START", StartText, "");
    }


    @Then("test the second MainLink {string}")
    public void testTheSecondMainLink(String arg0) {
        WebElement Kanaler = driver.findElement(By.cssSelector("#__next > div > div.play_root-container > div > header > div.sc-5a076cf9-1.kyZyc > div > div > nav > ul > li:nth-child(3) > a"));

        driver.findElement(By.cssSelector("#__next > div.sc-4f221cd2-1.fHHyBJ > div > div.sc-4f221cd2-8.bRFLbH > button.sc-5b00349a-2.fuGbXH.sc-4f221cd2-9.hEiUxP")).click();

        String KanalerText = Kanaler.getText();

        Assertions.assertEquals("KANALER", KanalerText, "");
    }

    @Then("test the third MainLink {string}")
    public void testTheThirdMainLink(String arg0) {

        WebElement Program = driver.findElement(By.cssSelector("#__next > div > div.play_root-container > div > header > div.sc-5a076cf9-1.kyZyc > div > div > nav > ul > li:nth-child(2) > a"));

        driver.findElement(By.cssSelector("#__next > div.sc-4f221cd2-1.fHHyBJ > div > div.sc-4f221cd2-8.bRFLbH > button.sc-5b00349a-2.fuGbXH.sc-4f221cd2-9.hEiUxP")).click();

        String ProgramText = Program.getText();

        Assertions.assertEquals("PROGRAM", ProgramText, "");
    }

    @Then("test the Acessability")
    public void testTheAcessability() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".sc-87f10045-7:nth-child(2) > .sc-87f10045-8:nth-child(1) .sc-343fed33-3")));
        WebElement acessabilityLink = driver.findElement(By.cssSelector(".sc-87f10045-7:nth-child(2) > .sc-87f10045-8:nth-child(1) .sc-343fed33-3"));
        String actual = acessabilityLink.getText();
        String expected = "Tillgänglighet i SVT Play";

        Assertions.assertEquals(expected, actual);
    }

    @Then("test the AcessabilityMainHeading")
    public void testTheAcessabilityMainHeading() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".sc-87f10045-7:nth-child(2) > .sc-87f10045-8:nth-child(1) .sc-343fed33-3")));
        WebElement acessabilityLink = driver.findElement(By.cssSelector(".sc-87f10045-7:nth-child(2) > .sc-87f10045-8:nth-child(1) .sc-343fed33-3"));

        driver.get("https://www.svt.se/kontakt/sa-arbetar-svt-med-tillganglighet");

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#__next > div.flex.flex-col.min-h-screen > main > div > div > div.container.max-w-screen-md > h1")));
        WebElement heading = driver.findElement(By.cssSelector("#__next > div.flex.flex-col.min-h-screen > main > div > div > div.container.max-w-screen-md > h1"));
        String actual = heading.getText();
        String expected = "Så arbetar SVT med tillgänglighet";

        Assertions.assertEquals(expected, actual);
    }


    @Then("countTheGenre")
    public void countthegenre() {

        waitClick(By.cssSelector("[class='sc-5b00349a-2 fuGbXH sc-4f221cd2-9 hEiUxP']"));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("[class='sc-4f221cd2-1 fHHyBJ']")));
        waitClick(By.cssSelector("a[href=\"/program\"]"));

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("article[data-rt*=\"promo\"]")));
        int actual = driver.findElements(By.cssSelector("article[data-rt*=\"promo\"]")).size();
        int expected = 17;

        Assertions.assertEquals(expected, actual);
    }


    @Then("test the Acessability for Kids")
    public void testTheAcessabilityForKids() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#__next > div > div.play_root-container > div > footer > div > div.sc-76b8604e-1.sc-a3880b6b-0.jwyMzV.ljtXjI > nav > div:nth-child(1) > div:nth-child(4) > p > a")));
        WebElement acessabilityLink = driver.findElement(By.cssSelector("a[href=\"/kategori/barn\"]"));
        String actual = acessabilityLink.getText();
        String expected = "Barn";

        Assertions.assertEquals(expected, actual);
    }


    @Then("testContact")
    public void testcontact() {


        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#__next > div > div.play_root-container > div > footer > div > div.sc-87f10045-3.cXLFlW > a:nth-child(2) > span.sc-5b00349a-5.eDHhDP")));
        WebElement acessabilityLink = driver.findElement(By.cssSelector("#__next > div > div.play_root-container > div > footer > div > div.sc-87f10045-3.cXLFlW > a:nth-child(2) > span.sc-5b00349a-5.eDHhDP"));
        String actual = acessabilityLink.getText();
        String expected = "KONTAKT";

        Assertions.assertEquals(expected, actual);
    }


    @Then("test NewsLetter")
    public void testNewsLetter() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#__next > div > div.play_root-container > div > footer > div > div.sc-87f10045-3.cXLFlW > a:nth-child(2) > span.sc-5b00349a-5.eDHhDP")));
        WebElement acessabilityLink = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/footer/div/div[5]/div[1]/p[2]/a/span[2]"));
        String actual = acessabilityLink.getText();
        String expected = "Nyhetsbrev";

        Assertions.assertEquals(expected, actual);
    }


    @Then("test the Settings")
    public void testTheSettings() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#__next > div > div.play_root-container > div > footer > div > div.sc-87f10045-3.cXLFlW > a:nth-child(2) > span.sc-5b00349a-5.eDHhDP")));
        WebElement acessabilityLink = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/footer/div/div[3]/a[1]/span[2]"));
        String actual = acessabilityLink.getText();
        String expected = "INSTÄLLNINGAR";

        Assertions.assertEquals(expected, actual);
    }


    @Then("test Series")
    public void testSeries() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#__next > div > div.play_root-container > div > footer > div > div.sc-87f10045-3.cXLFlW > a:nth-child(2) > span.sc-5b00349a-5.eDHhDP")));
        WebElement acessabilityLink = driver.findElement(By.className("kDxOJT"));
        String actual = acessabilityLink.getText();
        String expected = "Serier";

        Assertions.assertEquals(expected, actual);
    }

    @AfterEach
    public void tearDown() {
        driver.close();
        driver.quit();
    }

    private void waitClick(By by) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
        element.click();
    }

    private void scrollBy(String input) {
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, " + input + ")");
    }

    private String waitForText(By by) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
        return element.getText();
    }

    private void sendKeys(By by, String text) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated((by)));
        element.sendKeys(text);
    }

}









