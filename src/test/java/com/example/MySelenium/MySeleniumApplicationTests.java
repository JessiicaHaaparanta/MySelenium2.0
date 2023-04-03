package com.example.MySelenium;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MySeleniumApplicationTests {

	private WebDriver driver;
	private WebDriverWait wait;
	private JavascriptExecutor js;

	@BeforeEach
	public void setUp(){
		System.setProperty("webdriver.chrome.driver", "C:/WebDrivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://www.svtplay.se/");
		driver.manage().window().maximize();

	}



	@Test
	void testWebsiteTitle() {
		System.setProperty("webdriver.chrome.driver", "C:/MySelenium/chromedriver.exe/");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		WebDriver driver = new ChromeDriver(options);

		driver.get("https://www.svtplay.se/");
		driver.manage().window().maximize();

		String actual = driver.getTitle();
		String expected = "SVT Play";

		assertEquals(expected, actual);

		driver.quit();

	}

	@Test
	void testWebsiteLogo() {

		System.setProperty("webdriver.chrome.driver", "C:/MySelenium/chromedriver.exe/");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		WebDriver driver = new ChromeDriver(options);

		driver.get("https://www.svtplay.se/");

		WebElement websiteLogo = driver.findElement(By.cssSelector("#__next > div > div.play_root-container > div > header > div.sc-5a076cf9-1.kyZyc > div > div > nav > a > svg"));

		String websiteLogoText = websiteLogo.getText();

		assertEquals("SVT Play logotyp", websiteLogoText, "Logan är inte synlig..");

		driver.quit();
	}

	@Test
	void testWebsiteMainLinkStart () {

		System.setProperty("webdriver.chrome.driver", "C:/MySelenium/chromedriver.exe/");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		WebDriver driver = new ChromeDriver(options);

		driver.get("https://www.svtplay.se/");

		WebElement Start = driver.findElement(By.cssSelector("#__next > div > div.play_root-container > div > header > div.sc-5a076cf9-1.kyZyc > div > div > nav > ul > li:nth-child(1) > a"));

				driver.findElement(By.cssSelector("#__next > div.sc-4f221cd2-1.fHHyBJ > div > div.sc-4f221cd2-8.bRFLbH > button.sc-5b00349a-2.fuGbXH.sc-4f221cd2-9.hEiUxP")).click();

				String StartText = Start.getText();

				assertEquals("START", StartText, "");

		driver.close();
		driver.quit();

	}

	@Test
	void testWebMainLinkProgram () {
		System.setProperty("webdriver.chrome.driver", "C:/MySelenium/chromedriver.exe/");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		WebDriver driver = new ChromeDriver(options);

		driver.get("https://www.svtplay.se/");

		WebElement Program = driver.findElement(By.cssSelector("#__next > div > div.play_root-container > div > header > div.sc-5a076cf9-1.kyZyc > div > div > nav > ul > li:nth-child(2) > a"));

		driver.findElement(By.cssSelector("#__next > div.sc-4f221cd2-1.fHHyBJ > div > div.sc-4f221cd2-8.bRFLbH > button.sc-5b00349a-2.fuGbXH.sc-4f221cd2-9.hEiUxP")).click();

		String ProgramText = Program.getText();

		assertEquals("PROGRAM", ProgramText, "");

		driver.close();
		driver.quit();

	}

	@Test
	void testWebsiteLinkKanaler() {
		System.setProperty("webdriver.chrome.driver", "C:/MySelenium/chromedriver.exe/");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		WebDriver driver = new ChromeDriver(options);

		driver.get("https://www.svtplay.se/");

		WebElement Kanaler = driver.findElement(By.cssSelector("#__next > div > div.play_root-container > div > header > div.sc-5a076cf9-1.kyZyc > div > div > nav > ul > li:nth-child(3) > a"));

		driver.findElement(By.cssSelector("#__next > div.sc-4f221cd2-1.fHHyBJ > div > div.sc-4f221cd2-8.bRFLbH > button.sc-5b00349a-2.fuGbXH.sc-4f221cd2-9.hEiUxP")).click();

		String KanalerText = Kanaler.getText();

		assertEquals("KANALER", KanalerText, "");

		driver.close();
		driver.quit();

	}

	@Test
	void testAcessability () {

		System.setProperty("webdriver.chrome.driver", "C:/MySelenium/chromedriver.exe/");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		WebDriver driver = new ChromeDriver(options);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		driver.get("https://www.svtplay.se/");

		driver.manage().window().maximize();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("[class='sc-5b00349a-2 fuGbXH sc-4f221cd2-9 hEiUxP']")));
		driver.findElement(By.cssSelector("[class='sc-5b00349a-2 fuGbXH sc-4f221cd2-9 hEiUxP']")).click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".sc-87f10045-7:nth-child(2) > .sc-87f10045-8:nth-child(1) .sc-343fed33-3")));
		WebElement acessabilityLink = driver.findElement(By.cssSelector(".sc-87f10045-7:nth-child(2) > .sc-87f10045-8:nth-child(1) .sc-343fed33-3"));
		String actual = acessabilityLink.getText();
		String expected = "Tillgänglighet i SVT Play";

		assertEquals(expected,actual);

		driver.close();
		driver.quit();

	}

	@Test
	void testAcessabilityMainheading () {

		System.setProperty("webdriver.chrome.driver", "C:/MySelenium/chromedriver.exe/");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		WebDriver driver = new ChromeDriver(options);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		driver.get("https://www.svtplay.se/");

		driver.manage().window().maximize();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("[class='sc-5b00349a-2 fuGbXH sc-4f221cd2-9 hEiUxP']")));
		driver.findElement(By.cssSelector("[class='sc-5b00349a-2 fuGbXH sc-4f221cd2-9 hEiUxP']")).click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".sc-87f10045-7:nth-child(2) > .sc-87f10045-8:nth-child(1) .sc-343fed33-3")));
		WebElement acessabilityLink = driver.findElement(By.cssSelector(".sc-87f10045-7:nth-child(2) > .sc-87f10045-8:nth-child(1) .sc-343fed33-3"));

		driver.get("https://www.svt.se/kontakt/sa-arbetar-svt-med-tillganglighet");

		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#__next > div.flex.flex-col.min-h-screen > main > div > div > div.container.max-w-screen-md > h1")));
		WebElement heading = driver.findElement(By.cssSelector("#__next > div.flex.flex-col.min-h-screen > main > div > div > div.container.max-w-screen-md > h1"));
		 String actual = heading.getText();
		 String expected = "Så arbetar SVT med tillgänglighet";

		 assertEquals(expected,actual);

		 driver.close();
		 driver.quit();


	}

	@Test
	void countTheGenres () throws InterruptedException {

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		waitClick(By.cssSelector("[class='sc-5b00349a-2 fuGbXH sc-4f221cd2-9 hEiUxP']"));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("[class='sc-4f221cd2-1 fHHyBJ']")));
		waitClick(By.cssSelector("a[href=\"/program\"]"));

		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("article[data-rt*=\"promo\"]")));
		int actual = driver.findElements(By.cssSelector("article[data-rt*=\"promo\"]")).size();
		int expected = 17;

		assertEquals(expected,actual);
	}
	@AfterEach
	public void tearDown(){
		driver.close();
		driver.quit();
	}
	private void waitClick(By by){
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
		element.click();
	}
	private void scrollBy(String input){
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, " + input +")");
	}
	private String waitForText(By by){
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
		return element.getText();
	}
	private void sendKeys(By by,String text){
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated((by)));
		element.sendKeys(text);
	}


	@Test
	void testAcessabillityKids() {

		System.setProperty("webdriver.chrome.driver", "C:/MySelenium/chromedriver.exe/");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		WebDriver driver = new ChromeDriver(options);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		driver.get("https://www.svtplay.se/");

		driver.manage().window().maximize();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("[class='sc-5b00349a-2 fuGbXH sc-4f221cd2-9 hEiUxP']")));
		driver.findElement(By.cssSelector("[class='sc-5b00349a-2 fuGbXH sc-4f221cd2-9 hEiUxP']")).click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#__next > div > div.play_root-container > div > footer > div > div.sc-76b8604e-1.sc-a3880b6b-0.jwyMzV.ljtXjI > nav > div:nth-child(1) > div:nth-child(4) > p > a")));
		WebElement acessabilityLink = driver.findElement(By.cssSelector("#__next > div > div.play_root-container > div > footer > div > div.sc-76b8604e-1.sc-a3880b6b-0.jwyMzV.ljtXjI > nav > div:nth-child(1) > div:nth-child(4) > p > a"));
		String actual = acessabilityLink.getText();
		String expected = "Barn";

		assertEquals(expected,actual);

		driver.close();
		driver.quit();

	}

	@Test
	void testContact(){

		System.setProperty("webdriver.chrome.driver", "C:/MySelenium/chromedriver.exe/");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		WebDriver driver = new ChromeDriver(options);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		driver.get("https://www.svtplay.se/");

		driver.manage().window().maximize();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("[class='sc-5b00349a-2 fuGbXH sc-4f221cd2-9 hEiUxP']")));
		driver.findElement(By.cssSelector("[class='sc-5b00349a-2 fuGbXH sc-4f221cd2-9 hEiUxP']")).click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#__next > div > div.play_root-container > div > footer > div > div.sc-87f10045-3.cXLFlW > a:nth-child(2) > span.sc-5b00349a-5.eDHhDP")));
		WebElement acessabilityLink = driver.findElement(By.cssSelector("#__next > div > div.play_root-container > div > footer > div > div.sc-87f10045-3.cXLFlW > a:nth-child(2) > span.sc-5b00349a-5.eDHhDP"));
		String actual = acessabilityLink.getText();
		String expected = "KONTAKT";

		assertEquals(expected,actual);


	}

	@Test
	void testNewsLetter() {
		System.setProperty("webdriver.chrome.driver", "C:/MySelenium/chromedriver.exe/");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		WebDriver driver = new ChromeDriver(options);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		driver.get("https://www.svtplay.se/");

		driver.manage().window().maximize();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("[class='sc-5b00349a-2 fuGbXH sc-4f221cd2-9 hEiUxP']")));
		driver.findElement(By.cssSelector("[class='sc-5b00349a-2 fuGbXH sc-4f221cd2-9 hEiUxP']")).click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#__next > div > div.play_root-container > div > footer > div > div.sc-87f10045-3.cXLFlW > a:nth-child(2) > span.sc-5b00349a-5.eDHhDP")));
		WebElement acessabilityLink = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/footer/div/div[5]/div[1]/p[2]/a/span[2]"));
		String actual = acessabilityLink.getText();
		String expected = "Nyhetsbrev";

		assertEquals(expected,actual);

		driver.close();
		driver.quit();
	}

	@Test
	void TestSettings () {

		System.setProperty("webdriver.chrome.driver", "C:/MySelenium/chromedriver.exe/");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		WebDriver driver = new ChromeDriver(options);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		driver.get("https://www.svtplay.se/");

		driver.manage().window().maximize();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("[class='sc-5b00349a-2 fuGbXH sc-4f221cd2-9 hEiUxP']")));
		driver.findElement(By.cssSelector("[class='sc-5b00349a-2 fuGbXH sc-4f221cd2-9 hEiUxP']")).click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#__next > div > div.play_root-container > div > footer > div > div.sc-87f10045-3.cXLFlW > a:nth-child(2) > span.sc-5b00349a-5.eDHhDP")));
		WebElement acessabilityLink = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/footer/div/div[3]/a[1]/span[2]"));
		String actual = acessabilityLink.getText();
		String expected = "INSTÄLLNINGAR";

		assertEquals(expected,actual);

		driver.close();
		driver.quit();

	}

	@Test
	void testSeries() {
		System.setProperty("webdriver.chrome.driver", "C:/MySelenium/chromedriver.exe/");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		WebDriver driver = new ChromeDriver(options);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		driver.get("https://www.svtplay.se/");

		driver.manage().window().maximize();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("[class='sc-5b00349a-2 fuGbXH sc-4f221cd2-9 hEiUxP']")));
		driver.findElement(By.cssSelector("[class='sc-5b00349a-2 fuGbXH sc-4f221cd2-9 hEiUxP']")).click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#__next > div > div.play_root-container > div > footer > div > div.sc-87f10045-3.cXLFlW > a:nth-child(2) > span.sc-5b00349a-5.eDHhDP")));
		WebElement acessabilityLink = driver.findElement(By.className("kDxOJT"));
		String actual = acessabilityLink.getText();
		String expected = "Serier";

		assertEquals(expected,actual);

		driver.close();
		driver.quit();






	}





	}


