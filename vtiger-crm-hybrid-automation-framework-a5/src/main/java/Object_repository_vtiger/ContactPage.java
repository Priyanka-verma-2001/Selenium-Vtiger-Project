package Object_repository_vtiger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {

	// INITIALIZATION
	public ContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// DECLARATION (@FindBy)
	@FindBy(css = "[title='Create Contact...']")
	private WebElement createContactLookupImg;

	public WebElement getCreateContactLookupImg() {
		return createContactLookupImg;
	}
	
	@FindBy(name = "firstname")
	private WebElement firstnameEdt;

	public WebElement getFirstnameEdt() {
		return firstnameEdt;
	}

	@FindBy(name = "lastname")
	private WebElement lastnameEdt;

	public WebElement getLastnameEdt() {
		return lastnameEdt;
	}

	@FindBy(id = "phone")
	private WebElement phoneNo;

	public WebElement getPhoneNo() {
		return phoneNo;
	}

	@FindBy(id = "mobile")
	private WebElement mobileNo;

	public WebElement getMobileNo() {
		return mobileNo;
	}

	@FindBy(id = "homephone")
	private WebElement homephoneno;

	public WebElement getHomephoneno() {
		return homephoneno;
	}
	
	@FindBy(className = "save")
	private WebElement saveButton;

	public WebElement getSaveButton() {
		return saveButton;
	}
	
}
