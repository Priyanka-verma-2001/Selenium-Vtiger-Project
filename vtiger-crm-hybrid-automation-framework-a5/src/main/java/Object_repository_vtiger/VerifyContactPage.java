package Object_repository_vtiger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerifyContactPage {
	public VerifyContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id= "dtlview_Last Name")
	private WebElement VerifyContactLastName;
	
	public WebElement getVerifyContactLastName() {
		return VerifyContactLastName;
	}
	
	@FindBy(id="dtlview_First Name")
	private WebElement VerifyContactFirstName;
	
	public WebElement getVerifyContactFirstName() {
		return VerifyContactFirstName;
	}
	
	@FindBy(id="dtlview_Office Phone")
	private WebElement VerifyContactOfficePhone;
	
	public WebElement getVerifyContactOfficePhone() {
		return VerifyContactOfficePhone;
	}
	
	@FindBy(id="dtlview_Mobile")
	private WebElement VerifyContactMobileNo;
	
	public WebElement getVerifyContactMobileNo() {
		return VerifyContactMobileNo;
	}
	
	@FindBy(id="dtlview_Home Phone")
    private WebElement VerifyHomePhoneNo;

	public WebElement getVerifyHomePhoneNo() {
		return VerifyHomePhoneNo;
	}
		
}
