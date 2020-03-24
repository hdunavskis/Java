package com.ait.stepDefinitions;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
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

public class StaffTest {

	private WebDriver driver;
	private WebDriverWait wait;
	private int ordersBefore;
	

	@Given("^A kitchen staff is logged in and there are orders$")
	public void a_kitchen_staff_is_logged_in_and_there_are_orders() throws Throwable {
		
		setUp();
		login("customer");
		processOrder();
		login("staff");
	}

	@Then("^the kitchen staff should see all orders$")
	public void the_kitchen_staff_should_see_all_orders() throws Throwable {
	    assertTrue(numberOfIrders() > 0);
	    driver.close();
	}

	@When("^orders are ready the kitchen staff selects the ready button$")
	public void orders_are_ready_the_kitchen_staff_selects_the_ready_button() throws Throwable {
		ordersBefore = numberOfIrders();
		String orderID = findCell(0);
		
	    WebElement redyButton = driver.findElement(By.id(orderID));
	    redyButton.click();
	    
	    driver.switchTo().alert().accept();
	    assertEquals(ordersBefore -1, numberOfIrders());
	}

	@Then("^order is removed from the list and the user should receive a notification$")
	public void order_is_removed_from_the_list_and_the_user_should_receive_a_notification() throws Throwable {
		WebElement logout = driver.findElement(By.id("logoutButton"));
		logout.click();
		Thread.sleep(500);
		
		login("customer");
		
		WebElement myOrders = driver.findElement(By.id("myOrders"));
		wait.until(ExpectedConditions.visibilityOf(myOrders));
		myOrders.click();
		
		Thread.sleep(11000);
		driver.switchTo().alert().accept();
		driver.close();
		
	}

	private int numberOfIrders() {
		
		WebElement orderTable = driver.findElement(By.id("dataTable"));
		WebElement tableBody = orderTable.findElement(By.tagName("tbody"));
		List<WebElement> rows = tableBody.findElements(By.tagName("tr"));
		List<WebElement> td = new ArrayList<>();
		
		for (WebElement row : rows) {
			td.add(row);
		}
				
		return td.size();
	}
	private String findCell(int position) {
		
		WebElement orderTable = driver.findElement(By.id("dataTable"));
		WebElement tableBody = orderTable.findElement(By.tagName("tbody"));
		List<WebElement> rows = tableBody.findElements(By.tagName("tr"));
		List<WebElement> td = rows.get(rows.size()-1).findElements(By.tagName("td"));
		
		return td.get(position).getText();
	}
	private void setUp() {

		ChromeOptions chromeOptions = new ChromeOptions() ;
		chromeOptions.addArguments("--start-maximized", "--no-sandbox");
  
		WebDriverManager.chromedriver().version("79.0.3945.36").setup();
		
		driver = new ChromeDriver(chromeOptions); 
		wait = new WebDriverWait(driver, 5);
		
		driver.get("http://localhost:8080/Rest_FastFood/index.html");
		
	}
	private void login(String username) throws InterruptedException {
		WebElement loginButton = driver.findElement(By.id("login"));
		wait.until(ExpectedConditions.visibilityOf(loginButton));

		loginButton.click();
		Thread.sleep(1000);
		WebElement userInput = driver.findElement(By.id("username"));
		wait.until(ExpectedConditions.visibilityOf(userInput));
		userInput.sendKeys(username);
		WebElement passwordInput = driver.findElement(By.id("password"));
		passwordInput.sendKeys("password");
		WebElement modalLogin = driver.findElement(By.id("loginButton"));
		modalLogin.click();
	}
	private void processOrder() throws InterruptedException {
		WebElement payNow = driver.findElement(By.id("payNow"));
		wait.until(ExpectedConditions.visibilityOf(payNow));

		payNow.click();
		driver.switchTo().alert().accept();
		WebElement logout = driver.findElement(By.id("logoutButton"));
		logout.click();
	}
}
