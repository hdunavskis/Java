package com.ait.stepDefinitions;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	@Given("^the user is on the login page$")
	public void the_user_is_on_the_login_page() throws Throwable {
		ChromeOptions chromeOptions = new ChromeOptions() ;
		chromeOptions.addArguments("--start-maximized", "--no-sandbox");
  
		WebDriverManager.chromedriver().version("79.0.3945.36").setup();
		
		driver = new ChromeDriver(chromeOptions); 
		wait = new WebDriverWait(driver, 5);
		
		driver.get("http://localhost:8080/Rest_FastFood/index.html");
	}

	@When("^a user enters \"([^\"]*)\" and \"([^\"]*)\"$")
	public void a_user_enters_and(String arg1, String arg2) throws Throwable {
	    WebElement loginButton = driver.findElement(By.id("login"));
	    wait.until(ExpectedConditions.visibilityOf(loginButton));
	    
	    loginButton.click();
	    
	    WebElement userInput = driver.findElement(By.id("username"));
	    wait.until(ExpectedConditions.visibilityOf(userInput));
	    Thread.sleep(500);
	    userInput.sendKeys(arg1);
	    WebElement passwordInput = driver.findElement(By.id("password"));
	    passwordInput.sendKeys(arg2);
	}

	@When("^clicks on the login button$")
	public void clicks_on_the_login_button() throws Throwable {
		
		 WebElement modalLogin = driver.findElement(By.id("loginButton"));
		 modalLogin.click();
	}

	@Then("^the user should be logged in \"([^\"]*)\"$")
	public void the_user_should_be_logged_in(String arg1) throws Throwable {
		Thread.sleep(500);
		WebElement myOrders = driver.findElement(By.id("myOrders"));
		wait.until(ExpectedConditions.visibilityOf(myOrders));
	    assertEquals(arg1, driver.getTitle());
	    driver.close();
	}

	@Then("^the user should get  \"([^\"]*)\" authentication failed$")
	public void the_user_should_get_authentication_failed(String arg1) throws Throwable {
		Thread.sleep(500);
		Alert alert = driver.switchTo().alert();
		
		assertEquals(arg1, alert.getText());
	    alert.accept();
	    driver.close();
	}
}
