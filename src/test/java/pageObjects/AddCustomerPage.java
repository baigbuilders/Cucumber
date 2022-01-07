package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {

	public WebDriver ldriver;

	public AddCustomerPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
	}

	By customers = By.cssSelector(
			"body.sidebar-mini.layout-fixed.control-sidebar-slide-open.sidebar-closed.sidebar-collapse:nth-child(2) div.wrapper:nth-child(5) aside.main-sidebar.sidebar-dark-primary.elevation-4:nth-child(2) div.sidebar.os-host.os-theme-light.os-host-overflow.os-host-overflow-y.os-host-resize-disabled.os-host-scrollbar-horizontal-hidden.os-host-transition div.os-padding:nth-child(4) div.os-viewport.os-viewport-native-scrollbars-invisible div.os-content nav.mt-2 ul.nav.nav-pills.nav-sidebar.flex-column.nav-legacy:nth-child(2) li.nav-item.has-treeview.menu-open:nth-child(4) a.nav-link.active > p:nth-child(2)");
	By custMenu = By.cssSelector(
			"body.sidebar-mini.layout-fixed.control-sidebar-slide-open.sidebar-closed.sidebar-collapse:nth-child(2) div.wrapper:nth-child(5) aside.main-sidebar.sidebar-dark-primary.elevation-4:nth-child(2) div.sidebar.os-host.os-theme-light.os-host-overflow.os-host-overflow-y.os-host-resize-disabled.os-host-scrollbar-horizontal-hidden.os-host-transition div.os-padding:nth-child(4) div.os-viewport.os-viewport-native-scrollbars-invisible div.os-content nav.mt-2 ul.nav.nav-pills.nav-sidebar.flex-column.nav-legacy:nth-child(2) li.nav-item.has-treeview.menu-open:nth-child(4) > a.nav-link.active");

	By addCustomer = By.cssSelector("a[class='btn btn-primary']");
	By addEmail = By.cssSelector("#Email");
	By password = By.cssSelector("#Password");
	By firstName = By.cssSelector("#FirstName");
	By lastName = By.cssSelector("#LastName");
	By male = By.cssSelector("#Gender_Male");
	By female = By.cssSelector("#Gender_Female");
	By dateOfBirth = By.cssSelector("#DateOfBirth");
	By companyName = By.cssSelector("#Company");
	By tax = By.cssSelector("#IsTaxExempt");
	By newsLetter = By.cssSelector("div[class='input-group-append'] div[role='listbox']");
	By customerRoles = By.cssSelector("div[class='input-group-append input-group-required'] div[role='listbox']");

	By itemAdmin = By.cssSelector("div[id='SelectedCustomerRoleIds-list'] li:nth-child(1)");
	By itemForum = By.cssSelector("//*[@id=\"div[id='SelectedCustomerRoleIds-list'] li:nth-child(2)\"]/li[1]");
	By itemGuests = By.cssSelector("//*[@id=\"div[id='SelectedCustomerRoleIds-list'] li:nth-child(2)\"]/li[1]");
	By itemRegistered = By.cssSelector("//*[@id=\"div[id='SelectedCustomerRoleIds-list'] li:nth-child(2)\"]/li[1]");
	By itemVendors = By.cssSelector("//*[@id=\"div[class='k-animation-container'] li:nth-child(5)\"]/li[1]");

	By managerOfVendor = By.cssSelector("#VendorId");
	By active = By.cssSelector("#Active");
	By comments = By.cssSelector("#AdminComment");
	By save = By.cssSelector("button[name='save']");
	By yourStoreName = By.cssSelector("//*[@id=\"div[class='k-animation-container'] li:nth-child(1)\"]/li[1]");
	By testStore2 = By.xpath("//*[@id=\"SelectedNewsletterSubscriptionStoreIds_listbox\"]/li[2]");
	By saveContinue = By.cssSelector("button[name='save-continue']");

	// Action Methods

	public String getTitle() {
		return ldriver.getTitle();
	}

	public void clickOnCustomersMenu() {
		ldriver.findElement(customers).click();
	}

	public void clickOnCustomerMenuItem() {
		ldriver.findElement(custMenu).click();
	}

	public void clickOnAddNew() {
		ldriver.findElement(addCustomer).click();
	}

	public void setEmail(String email) {
		ldriver.findElement(addEmail).sendKeys(email);
	}

	public void setPassword(String pass) {
		ldriver.findElement(password).sendKeys(pass);
	}

	public void setCustomerRoles(String role) throws InterruptedException {

		if (!role.equals("Vendors")) {
			ldriver.findElement(By.cssSelector(""));
		}

		ldriver.findElement(customerRoles).click();

		WebElement listItem;

		Thread.sleep(3000);

		if (role.equals("Administrators")) {
			listItem = ldriver.findElement(itemAdmin);
		} else if (role.equals("Forum Moderators")) {
			listItem = ldriver.findElement(itemForum);
		} else if (role.equals("Guests")) {
			listItem = ldriver.findElement(itemGuests);
		} else if (role.equals("Registred")) {
			listItem = ldriver.findElement(itemRegistered);
		} else if (role.equals("Vendors")) {
			listItem = ldriver.findElement(itemVendors);
		} else {
			listItem = ldriver.findElement(itemGuests);
		}
		listItem.click();

		JavascriptExecutor js = (JavascriptExecutor) ldriver;
		js.executeScript("arguments[0].click();", listItem);
	}

	public void firstName(String fname) {
		ldriver.findElement(firstName).sendKeys(fname);
	}

	public void lastName(String lname) {
		ldriver.findElement(lastName).sendKeys(lname);
	}

	public void setManagerOfVendor(String value) {
		Select drp = new Select(ldriver.findElement(managerOfVendor));
		drp.selectByVisibleText(value);
	}

	public void setGender(String gender) {

		if (gender.equals("Male")) {
			ldriver.findElement(male).click();
		} else if (gender.equals("Female")) {
			ldriver.findElement(female).click();
		} else {
			ldriver.findElement(male).click();
		}
	}

	public void setDob(String dob) {
		ldriver.findElement(dateOfBirth).sendKeys(dob);
	}

	public void setCompanyName(String company) {
		ldriver.findElement(companyName).sendKeys(company);
	}

	public void tax() {
		ldriver.findElement(tax).click();
	}

	public void newsLetter(String store) {

		if (store.equals("Your store name")) {
			ldriver.findElement(yourStoreName).click();
		} else if (store.equals("Test store 2")) {
			ldriver.findElement(testStore2).click();
		}

	}

	public void clickOnSave() {

	}

	public void setAdminContent(String admin) {

	}
}
