package stepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

public class Steps extends BaseClass {
	
	@Before
	public void setup() throws IOException {
		
		logger =Logger.getLogger("nopCommerce");
		PropertyConfigurator.configure("Log4j.properties");
		
		// Reading properties
		configProp = new Properties();
		FileInputStream configProfile = new FileInputStream("config.properties");
		configProp.load(configProfile);
		
		
		
		String br = configProp.getProperty("browser");
		
		if(br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", configProp.getProperty("chromepath"));
			driver = new ChromeDriver();
		}
		else if(br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", configProp.getProperty("firefoxpath"));
			driver = new FirefoxDriver();
		}
		else if(br.equals("ie")) {
			System.setProperty("webdriver.ie.driver", configProp.getProperty("iepath"));
			driver = new InternetExplorerDriver();
		}
		logger.info("*****Launching Browser*****");
	}
	
	
	@Given("User Launch Chrome Browser")
	public void User_Launch_Chrome_Browser() {

		lp = new LoginPage(driver);
	}
	
	@When("User Opens URL {string}")
	public void User_Opens_URL(String url) {
		logger.info("********Opening URL*********");
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@And("User Enters Email As {string} And Password {string}" )
	public void User_Enters_As_and_password(String email, String password) {
		logger.info("********Providing Login Details*******");
		lp.setUserName(email);
		lp.setPassword(password);
	}
	
	@And("Click On Login")
	public void Click_On_Login() {
		logger.info("*******Started Login*******");
		lp.clickLogin();
	}
	
	@Then("Page Title On Should Be {string}")
	public void Page_Tittle_On_Should_Be(String title) throws InterruptedException {
		
		if(driver.getPageSource().contains("Login was Unsuccessful.")) {
			driver.close();
			logger.info("**********Logging Passed********");
			Assert.assertTrue(false);
		} else {
			logger.info("********Logging Failed*********");
			Assert.assertEquals(title, driver.getTitle());
		}
		Thread.sleep(3000);
		
	}
	
	@When("Click On Logout Link")
	public void Click_On_Logout_Link() throws InterruptedException {
		logger.info("*******Click On Logout Link*******");
		lp.clickLogin();
		Thread.sleep(3000);
	}
	
	
	@And("Close Browser")
	public void Close_Browser() {
		logger.info("**********Close Browser**********");
		driver.close();
	}
	
	
	//Adding Customer......................
	
	 
	@Then("User Can View Dashboad")
	public void user_can_view_dashboard() {
		addCust = new AddCustomerPage(driver);
		Assert.assertEquals("Dashborad / nopCommerce administration", addCust.getTitle());
	}
	
	@When("User Click On Customers Menu")
	public void user_click_on_customers_menu() {
		addCust.clickOnCustomersMenu();
	}
	@And("Click on Customer Menu Item")
	public void click_on_customer_menu_item() {
		addCust.clickOnCustomerMenuItem();
	}
	@And("Click On Add New button")
	public void click_on_Add_new_button() {
		addCust.clickOnAddNew();
	}
	@Then("User Can View Add New Customers")
	public void user_can_view_new_customer() {
		Assert.assertEquals("Add a new customer / nopCommerce administration", addCust.getTitle());
	}
	@When("User Enter Customer Info")
	public void user_enter_customer_info() throws InterruptedException{
		
		logger.info("*********Adding New Customer********");
		logger.info("*********Providing Customer Details********");
		String email = randomString() + "gmail.com";
		addCust.setEmail(email);
		addCust.setPassword("test123");
		// Registered - default
		// The customer cannot be in both 'Guests' and 'Registered'
		// Add the customer to 'Guests' or 'Registered' customer
		addCust.setCustomerRoles("Guests");
		Thread.sleep(3000);
		
		addCust.setManagerOfVendor("Vendor 2");
		addCust.setGender("Male");
		addCust.firstName("abc");
		addCust.lastName("xyz");
		addCust.setDob("03/04/1994");
		addCust.setCompanyName("busyQA");
		addCust.setAdminContent("This is for testing........");
	}
	
	@And("Click On Save button")
	public void click_on_save_button() throws InterruptedException {
		logger.info("********Saving Customer Data********");
		addCust.clickOnSave();
		Thread.sleep(3000);
	}
	
	@Then("User Can View Confirmation Message")
	public void user_can_view_confirmation_message() {
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText()
				.contains("The new customer has been added successfully"));
	}
	@And("Close Browser")
	public void close_browser() {
		
	}
	
	
	// Steps for searching customer using email id................
	
	@And("Enter customer Email")
	public void enter_customer_email() {
		
		logger.info("********Searching A Customer by Email ID*******");
		searchCust = new SearchCustomerPage(driver);
		searchCust.setEmail("abc@gmail.com");
	}
	
	@When("Click On Search button")
	public void click_on_search_button() throws InterruptedException {
		searchCust.clickSearch();
		Thread.sleep(3000);
	}
	
	@Then("User should found email in the Search Table")
	public void user_should_found_email_in_the_search_table() {
		boolean status = searchCust.searchCustomerByEmail("abc@gmail.com");
		Assert.assertEquals(true, status);
	}
	
	
	// Steps for Searching a Customer by using First Name and Last Name
	
	@And("Enter Customer First Name")
	public void enter_customer_first_name() {
		
		logger.info("*******Searching customer By Name");
		searchCust = new SearchCustomerPage(driver);
		searchCust.setFirstName("Victoria");
	}
	
	@And("Enter Customer Last Name")
	public void enter_customer_last_name() {
		
		searchCust.setLastName("Treces");
	}
	
	@Then("User should found name in the Search Table")
	public void user_should_found_name_in_the_search_table() {
		boolean status = searchCust.searchCustomerByName("Victoria Terces");
		Assert.assertEquals(true, status);
	}
}
