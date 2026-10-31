package POM_extra;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;

import Object_repository_vtiger.ContactPage;
import Object_repository_vtiger.HomePage;
import Object_repository_vtiger.LoginPage;
import Object_repository_vtiger.VerifyContactPage;
import generic_utility.FileUtility;

public class CreateContactPOMTest {
	public static void main(String[] args) throws InterruptedException, IOException, ParseException {

		// get the data from json file
		String browser = FileUtility.getDataFromJsonFile("browser");
		String url = FileUtility.getDataFromJsonFile("url");
		String username = FileUtility.getDataFromJsonFile("username");
		String password = FileUtility.getDataFromJsonFile("password");

		// get the data from excel file
		String contactName = FileUtility.getDataFromExcelFile("contact", 1, 3);
		System.out.println(contactName);

		// browser launch
		WebDriver driver;

		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		} else if (browser.equals("safari")) {
			driver = new SafariDriver();
		} else {
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		// Login
		try {
			// open the application
			driver.get(url);

			// 1. Login Page Object

			LoginPage lp = new LoginPage(driver);
			lp.getUsernameField().sendKeys(username);
			lp.getPasswordField().sendKeys(password);
			lp.getLoginButton().click();

			// 2. Home Page Object

			HomePage hp = new HomePage(driver);
			hp.getContactsLinks().click();

			// 3. Contact page Object
			ContactPage cp = new ContactPage(driver);
			cp.getCreateContactLookupImg().click();

			// Test Data
			String firstName = "Priyanka";
			String lastName = "Verma";
			String officePhone = "Personal Number";
			String mobile = "9548863185";
			String homePhone = "1234567890";

			// fill contact form
			cp.getFirstnameEdt().sendKeys(firstName);
			cp.getLastnameEdt().sendKeys(lastName);
			cp.getPhoneNo().sendKeys(officePhone);
			cp.getMobileNo().sendKeys(mobile);
			cp.getHomephoneno().sendKeys(homePhone);

			cp.getSaveButton().click();
			System.out.println("Contact details saved");

			// 4.Verify Contact Page
			VerifyContactPage vcp = new VerifyContactPage(driver);
			String actLastName = vcp.getVerifyContactLastName().getText();
			String actFirstName = vcp.getVerifyContactFirstName().getText();
			String actOfficePhone = vcp.getVerifyContactOfficePhone().getText();
			String actMobile = vcp.getVerifyContactMobileNo().getText();
			String actHomePhone = vcp.getVerifyHomePhoneNo().getText();
			// Verification
			if (actLastName.equals(lastName) && actFirstName.equals(firstName) && actOfficePhone.equals(officePhone)
					&& actMobile.equals(mobile) && actHomePhone.equals(homePhone)) {

				System.out.println("Contact successfully created and verified!");
			} else {
				System.out.println("Contact verification failed!");
			}
			// Logout
			Actions act = new Actions(driver);
			act.moveToElement(hp.getProfileIcon()).perform();

			hp.getSignoutLink().click();
			System.out.println("Successfully signed out");

		} finally {
			driver.quit();
		}
	}
}