package com.ait.stepDefinitions;

import static org.junit.Assert.assertEquals;
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

public class MenuTest {

	private WebDriver driver;
	private WebDriverWait wait;
	

	@Given("^A user is on the landing page$") 
	public void a_user_is_on_the_landing_page() throws Throwable {
  
		ChromeOptions chromeOptions = new ChromeOptions() ;
		chromeOptions.addArguments("--start-maximized", "--no-sandbox");
  
		WebDriverManager.chromedriver().version("79.0.3945.36").setup();
		
		driver = new ChromeDriver(chromeOptions); 
		wait = new WebDriverWait(driver, 5);
		
		driver.get("http://localhost:8080/Rest_FastFood/index.html");
		
	}
	
	@When("^a user opens the website \"([^\"]*)\"$")
	public void a_user_opens_the_website(String title) throws Throwable {
		
		assertEquals(title, driver.getTitle()); 
	}

	@Then("^the menu can be visible \"([^\"]*)\"$")
	public void the_menu_can_be_visible(String menu) throws Throwable {

		WebElement menuFromWeb = driver.findElement(By.className("centered"));
		wait.until(ExpectedConditions.visibilityOf(menuFromWeb));
		
		assertEquals(menu, menuFromWeb.getText());
		driver.close();

	}


}
