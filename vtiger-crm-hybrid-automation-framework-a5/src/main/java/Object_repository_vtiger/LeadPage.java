package Object_repository_vtiger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LeadPage {
	public LeadPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement addbutton;

	public WebElement getAddbutton() {
		return addbutton;
	}

	@FindBy(xpath = "//select[@name='salutationtype']")
	private WebElement salutationDropdown;

	public WebElement getSalutationDropdown() {
		return salutationDropdown;
	}

	@FindBy(name = "firstname")
	private WebElement firstName;

	public WebElement getFirstName() {
		return firstName;
	}

	@FindBy(name = "lastname")
	private WebElement lastName;

	public WebElement getlastName() {
		return lastName;
	}

	@FindBy(name = "company")
	private WebElement companyName;

	public WebElement getCompanyName() {
		return companyName;
	}

	@FindBy(id = "phone")
	private WebElement phone;

	public WebElement getPhone() {
		return phone;
	}

	@FindBy(id = "mobile")
	private WebElement mobile;

	public WebElement getMobile() {
		return mobile;
	}

	@FindBy(id = "email")
	private WebElement email;

	public WebElement getEmail() {
		return email;
	}

	@FindBy(name = "website")
	private WebElement websites;

	public WebElement getWebsites() {
		return websites;
	}

	@FindBy(id = "noofemployees")
	private WebElement noOfEmp;

	public WebElement getNoOfEmp() {
		return noOfEmp;
	}

	@FindBy(id = "designation")
	private WebElement designation;

	public WebElement getDesignation() {
		return designation;
	}

	@FindBy(className = "save")
	private WebElement saveButton;

	public WebElement getSaveButton() {
		return saveButton;
	}
}
