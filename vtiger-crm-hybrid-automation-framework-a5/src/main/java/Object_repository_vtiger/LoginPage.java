package Object_repository_vtiger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "user_name")
	private WebElement usernameField;

	public WebElement getUsernameField() {
		return usernameField;
	}

	@FindBy(name = "user_password")
	private WebElement passwordField;

	public WebElement getPasswordField() {
		return passwordField;
	}

	@FindBy(id = "submitButton")
	private WebElement loginButton;

	public WebElement getLoginButton() {
		return loginButton;
	}
}
