package Object_repository_vtiger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerifyLeadPage {
	public VerifyLeadPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

//	@FindBy(id="dtlview_Title")
//	private WebElement VerifyTitle;
//	
//	public WebElement getVerifyTitle() {
//		return VerifyTitle;
//	}
	
	@FindBy(id="dtlview_First Name")
	private WebElement VerifyFirstName;
	
	public WebElement getVerifyFirstName() {
		return VerifyFirstName;
	}
	
	@FindBy(id="dtlview_Last Name")
	private WebElement VerifyLastName;
	
	public WebElement getVerifyLastName() {
		return VerifyLastName;
	}
	
	@FindBy(id="dtlview_Company")
	private WebElement VerifyCompany;
	
	public WebElement getVerifyCompany() {
		return VerifyCompany;
	}
	
	@FindBy(id="dtlview_Phone")
	private WebElement VerifyPhone;
	
	public WebElement getVerifyPhone() {
		return VerifyPhone;
	}
	
	@FindBy(id="dtlview_Mobile")
	private WebElement VerifyMobile;
	
	public WebElement getVerifyMobile() {
		return VerifyMobile;
	}
	
	@FindBy(id="dtlview_Email")
	private WebElement VerifyEmail;
	
	public WebElement getVerifyEmail() {
		return VerifyEmail;
	}
	
	@FindBy(id="dtlview_Website")
	private WebElement VerifyWebsite;
	
	public WebElement getVerifyWebsite() {
		return VerifyWebsite;
	}
	
	@FindBy(id="dtlview_No Of Employees")
	private WebElement VerifyEmpl;
	
	public WebElement getVerifyEmpl() {
		return VerifyEmpl;
	}
	
	@FindBy(id = "dtlview_Title")
	private WebElement VerifyDes;

	public WebElement getVerifyDes() {
		return VerifyDes;
	}
	
}
