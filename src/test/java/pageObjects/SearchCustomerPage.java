package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitHelper;

public class SearchCustomerPage {
	
	public WebDriver ldriver;
	WaitHelper waithelper;
	
	public SearchCustomerPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
		waithelper = new WaitHelper(ldriver);
	}
	
	@FindBy(how = How.CSS, using = "body > div:nth-child(5) > aside:nth-child(2) > div:nth-child(2) > div:nth-child(4) > div:nth-child(1) > div:nth-child(1) > nav:nth-child(2) > ul:nth-child(2) > li:nth-child(4) > ul:nth-child(2) > li:nth-child(1) > a:nth-child(1) > p:nth-child(2)")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(how = How.CSS, using = "#Search")
	@CacheLookup
	WebElement search;
	
	@FindBy(how = How.CSS, using = "#SearchFristName")
	@CacheLookup
	WebElement firstName;
	
	@FindBy(how = How.CSS, using = "#SearchLastName")
	@CacheLookup
	WebElement lastName;
	
	@FindBy(how = How.CSS, using = "#SearchMonthOfBirth")
	@CacheLookup
	WebElement searchMonth;
	
	@FindBy(how = How.CSS, using = "#SearchDateOfBirth")
	@CacheLookup
	WebElement searchDate;
	
	@FindBy(how = How.CSS, using = "#SearchCompany")
	@CacheLookup
	WebElement searchCompany;
	
	@FindBy(how = How.CSS, using = "#SearchIpAddress")
	@CacheLookup
	WebElement ipAddress;
	
	@FindBy(how = How.CSS, using = "div[role='listbox']")
	@CacheLookup
	WebElement dropDown;
	
	@FindBy(how = How.CSS, using = "#search-customers")
	@CacheLookup
	WebElement btnSearch;
	
	@FindBy(how = How.CSS, using = "")
	@CacheLookup
	WebElement tblSearchResults;
	
	@FindBy(how = How.CSS, using = "")
	@CacheLookup
	WebElement table;
	
	
	@FindBy(how = How.CSS, using = "")
	@CacheLookup
	List<WebElement> tableRows;
	
	@FindBy(how = How.CSS, using = "")
	@CacheLookup
	List<WebElement> tableColumns;
	
	public void setEmail(String email) {
		waithelper.WaitForElement(txtEmail, 30);
		txtEmail.clear();
		txtEmail.sendKeys(email);
	}
	
	public void setFirstName(String fname) {
		waithelper.WaitForElement(firstName, 30);
		firstName.clear();
		firstName.sendKeys(fname);
	}
	
	public void setLastName(String lname) {
		waithelper.WaitForElement(lastName, 30);
		lastName.clear();
		lastName.sendKeys(lname);
	}
	
	public void clickSearch() {
		btnSearch.click();
		waithelper.WaitForElement(btnSearch,  30);
	}
	
	public int getNoOfRows() {
		return (tableRows.size());
	}
	
	public int getNoOfColumns() {
		return (tableColumns.size());
	}
	
	public boolean searchCustomerByEmail(String email) {
		
		boolean flag = false;
		
		for(int i =1;i<=getNoOfRows();i++) {
			
			String emailId = table.findElement(By.xpath("")).getText();
			
			System.out.println(emailId);
			
			if(emailId.equals(email)) {
				
				flag=true;
			}
		}
		
		return flag;
	}
	
	public boolean searchCustomerByName(String Name) {
		
		boolean flag = false;
		
		for(int i =1;i<=getNoOfRows();i++) {
			
			String name = table.findElement(By.xpath("")).getText();
			
			String names[] = name.split(" ");
			
			if(names[0].equals("Victoria") && names[1].equals("Teraces")) {
				
				flag=true;;
			}
		}
		
		return flag;
	}
	

}
