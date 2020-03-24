package com.ait.stepDefinitions;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

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

public class OrderTest {
	
	private WebDriver driver;
	private WebDriverWait wait;
	private int beforeDelete;
	
	
	@Given("^A user is logged in$")
	public void a_user_is_logged_in() throws Throwable {
		
		ChromeOptions chromeOptions = new ChromeOptions() ;
		chromeOptions.addArguments("--start-maximized", "--no-sandbox");
  
		WebDriverManager.chromedriver().version("79.0.3945.36").setup();
		
		driver = new ChromeDriver(chromeOptions); 
		wait = new WebDriverWait(driver, 5);
		
		driver.get("http://localhost:8080/Rest_FastFood/index.html");
		
		
		WebElement loginButton = driver.findElement(By.id("login"));
		wait.until(ExpectedConditions.visibilityOf(loginButton));

		loginButton.click();
		Thread.sleep(1000);
		WebElement userInput = driver.findElement(By.id("username"));
		wait.until(ExpectedConditions.visibilityOf(userInput));
		userInput.sendKeys("customer");
		WebElement passwordInput = driver.findElement(By.id("password"));
		passwordInput.sendKeys("password");
		WebElement modalLogin = driver.findElement(By.id("loginButton"));
		modalLogin.click();
		
	}

	
	@When("^a user clicks on the pay now button$")
	public void a_user_clicks_on_the_pay_now_button() throws Throwable {
		WebElement payNow = driver.findElement(By.id("payNow"));
		wait.until(ExpectedConditions.visibilityOf(payNow));

		payNow.click();
		driver.switchTo().alert().accept();
	}

	@Then("^the user order is submitted \"([^\"]*)\"$")
	public void the_user_order_is_submitted(String arg1) throws Throwable {
		WebElement myOrders = driver.findElement(By.id("myOrders"));
		myOrders.click();

		assertEquals(arg1, findCell(1));

		driver.close();

	}
	 
	
	@When("^a user clicks on the pay later button$")
	public void a_user_clicks_on_the_pay_later_button() throws Throwable {
		WebElement payLater = driver.findElement(By.id("confirmButton"));
		wait.until(ExpectedConditions.visibilityOf(payLater));
		
		payLater.click();
		driver.switchTo().alert().accept();
		
		WebElement myOrders = driver.findElement(By.id("myOrders"));
		myOrders.click();
	}

	@When("^then clicks on the change button$")
	public void then_clicks_on_the_change_button() throws Throwable {
	
		String orderID= findCell(0);
		WebElement changeButton = driver.findElement(By.id(orderID));
		changeButton.click();
	}

	@When("^updates the order \"([^\"]*)\"$")
	public void updates_the_order(String arg1) throws Throwable {
	
		String orderID= findCell(0);
		WebElement noteInput = driver.findElement(By.id("textArea"+orderID));
		
		noteInput.sendKeys(arg1);
		Thread.sleep(1000);
	}

	@When("^clicks on the save button$")
	public void clicks_on_the_save_button() throws Throwable {
	
		String orderID= findCell(0);
		WebElement changeButton = driver.findElement(By.id(orderID));
		
		changeButton.click();
		driver.switchTo().alert().accept();
		
	}

	@Then("^the user order is updated \"([^\"]*)\"$")
	public void the_user_order_is_updated(String arg1) throws Throwable {
	
		String orderID= findCell(0);
		
		WebElement noteInput = driver.findElement(By.id("textArea"+orderID));
		
		assertEquals(arg1, noteInput.getText());
		driver.close();
	}
	
	@When("^the customer clicks on the button cancel$")
	public void the_customer_clicks_on_the_button_cancel() throws Throwable {

		beforeDelete = numberOfOrders();
		String orderID= findCell(0);
		WebElement cancelButton = driver.findElement(By.id("cancel"+orderID));
		cancelButton.click();
	}

	@Then("^the customer should see a \"([^\"]*)\" message$")
	public void the_customer_should_see_a_message(String arg1) throws Throwable {
		
		Alert alert = driver.switchTo().alert();
		
		assertEquals(arg1, alert.getText());
		alert.accept();
	}

	@Then("^approving the message the order is removed$")
	public void approving_the_message_the_order_is_removed() throws Throwable {
		assertEquals(beforeDelete -1, numberOfOrders());
		driver.close();
	}
	@When("^then clicks on the pay button$")
	public void then_clicks_on_the_pay_button() throws Throwable {
		String orderID= findCell(0);
		WebElement payButton = driver.findElement(By.id("pay"+orderID));
		
		payButton.click();
	}

	@Then("^approving the message the payment is processed$")
	public void approving_the_message_the_payment_is_processed() throws Throwable {
		String orderID= findCell(0);
		WebElement payButton = driver.findElement(By.id("pay"+orderID));
		
		assertEquals("", payButton.getText());
		driver.close();
	}
	private int numberOfOrders() {
		
		WebElement orderTable = driver.findElement(By.id("customerOrders"));
		WebElement tableBody = orderTable.findElement(By.tagName("tbody"));
		List<WebElement> rows = tableBody.findElements(By.tagName("tr"));
		List<WebElement> td = new ArrayList<>();
		
		for (WebElement row : rows) {
			td.add(row);
		}
				
		return td.size();
	}
	private String findCell(int position) {
		
		WebElement orderTable = driver.findElement(By.id("customerOrders"));
		WebElement tableBody = orderTable.findElement(By.tagName("tbody"));
		List<WebElement> rows = tableBody.findElements(By.tagName("tr"));
		List<WebElement> td = rows.get(rows.size()-1).findElements(By.tagName("td"));
		
		return td.get(position).getText();
	}

}
