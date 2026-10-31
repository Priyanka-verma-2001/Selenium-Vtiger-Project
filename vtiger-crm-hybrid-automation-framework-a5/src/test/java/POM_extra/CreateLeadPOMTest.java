package POM_extra;

import java.io.IOException;
import java.time.Duration;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;

import Object_repository_vtiger.HomePage;
import Object_repository_vtiger.LeadPage;
import Object_repository_vtiger.LoginPage;
import Object_repository_vtiger.VerifyLeadPage;
import generic_utility.FileUtility;

public class CreateLeadPOMTest {
	public static void main(String[] args) throws InterruptedException, IOException, ParseException {

		String browser = FileUtility.getDataFromJsonFile("browser");
		String url = FileUtility.getDataFromJsonFile("url");
		String username = FileUtility.getDataFromJsonFile("username");
		String password = FileUtility.getDataFromJsonFile("password");

		// Get the data from excel file
		String leadName = FileUtility.getDataFromExcelFile("lead", 1, 2);
		System.out.println(leadName);

		// Open the browser
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

		// Login Vtiger Crm
		driver.get(url);

		LoginPage lp = new LoginPage(driver);
		lp.getUsernameField().sendKeys(username);
		lp.getPasswordField().sendKeys(password);
		lp.getLoginButton().click();

		HomePage hp = new HomePage(driver);
		hp.getLeadLinks().click();

		LeadPage ld = new LeadPage(driver);
		ld.getAddbutton().click();

		String firstName = "Priyanka";
		String lastName = "Verma";
		String companyName = "Infosys";
		String phone = "9876543210";
		String mobile = "38448034803";
		String email = "pv122@gmail.com";
		String websites = "https://www.automationwithpiyush.com";
		String noOfEmp = "10";
		String designation = "Software Testing";

		String salutationDropdown = "Ms.";
		Select sel = new Select(ld.getSalutationDropdown());
		sel.selectByValue(salutationDropdown);

		ld.getFirstName().sendKeys(firstName);
		ld.getlastName().sendKeys(lastName);
		ld.getCompanyName().sendKeys(companyName);
		ld.getPhone().sendKeys(phone);
		ld.getMobile().sendKeys(mobile);
		ld.getEmail().sendKeys(email);
		ld.getWebsites().sendKeys(websites);
		ld.getNoOfEmp().sendKeys(noOfEmp);
		ld.getDesignation().sendKeys(designation);

		ld.getSaveButton().click();
		System.out.println("Lead details saved");

		VerifyLeadPage vlp = new VerifyLeadPage(driver);
		String actfirstName = vlp.getVerifyFirstName().getText();
		String actlastName = vlp.getVerifyLastName().getText();
		String actcompanyName = vlp.getVerifyCompany().getText();
		String actphone = vlp.getVerifyPhone().getText();
		String actmobile = vlp.getVerifyMobile().getText();
		String actemail = vlp.getVerifyEmail().getText();
		String actwebsites = vlp.getVerifyWebsite().getText();
		String actnoOfEmp = vlp.getVerifyEmpl().getText();
		String actDesignation = vlp.getVerifyDes().getText();

		if (actfirstName.equals(firstName) && actlastName.equals(lastName) && actcompanyName.equals(companyName)
				&& actphone.equals(phone) && actmobile.equals(mobile) && actemail.equals(email)
				&& actwebsites.equals(websites) && actnoOfEmp.equals(noOfEmp) && actDesignation.equals(designation)) {
			System.out.println("Leads created successfully !!!");
		} else {
			System.out.println("Failed!!!....");
		}
		// Logout
		Actions act = new Actions(driver);
		act.moveToElement(hp.getProfileIcon()).perform();

		hp.getSignoutLink().click();
		System.out.println("Successfully signed out");

		Thread.sleep(2000);
		driver.quit();
	}

}
