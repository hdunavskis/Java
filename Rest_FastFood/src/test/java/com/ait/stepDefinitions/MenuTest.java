/*
 * package com.ait.stepDefinitions;
 * 
 * import static org.junit.Assert.assertEquals; import org.openqa.selenium.By;
 * import org.openqa.selenium.WebDriver; import
 * org.openqa.selenium.chrome.ChromeDriver; import
 * org.openqa.selenium.chrome.ChromeOptions; import
 * org.openqa.selenium.support.ui.WebDriverWait; import
 * cucumber.api.java.en.Given; import cucumber.api.java.en.Then; import
 * cucumber.api.java.en.When; import io.github.bonigarcia.wdm.WebDriverManager;
 * 
 * public class MenuTest {
 * 
 * private WebDriver driver; private WebDriverWait wait; private String navBar =
 * "#menu"; private String menuPage = "Menu"; private String ceaserWrap =
 * "Ceasar salad wrap"; private String findFoodByClass = "card-title";
 * 
 * @Given("^A user is on the landing page$") public void
 * a_user_is_on_the_landing_page() throws Throwable {
 * 
 * ChromeOptions chromeOptions = new ChromeOptions() ;
 * chromeOptions.addArguments("--start-maximized", "--no-sandbox");
 * 
 * WebDriverManager.chromedriver().version("79.0.3945.36").setup();
 * 
 * driver = new ChromeDriver(chromeOptions); //wait = new WebDriverWait(driver,
 * 2); driver.get("http://localhost:8080/Rest_FastFood/index.html");
 * Thread.sleep(2000); String indexTitle = driver.getTitle();
 * assertEquals("Rest_FastFood", indexTitle); }
 * 
 * 
 * 
 * @When("^a user selects the menu option on the nav bar$") public void
 * a_user_selects_the_menu_option_on_the_nav_bar() throws Throwable {
 * driver.findElement(By.id(navBar)).click(); }
 * 
 * 
 * @Then("^the menu page is displayed$") public void
 * the_menu_page_is_displayed() throws Throwable { Thread.sleep(1000); String
 * menuTitle = driver.getTitle(); assertEquals(menuTitle, menuPage); }
 * 
 * @Then("^all available food$") public void all_available_food() throws
 * Throwable { Thread.sleep(1000); String food =
 * driver.findElement(By.className(findFoodByClass)).getText();
 * 
 * assertEquals(ceaserWrap, food); driver.close(); }
 * 
 * 
 * }
 */