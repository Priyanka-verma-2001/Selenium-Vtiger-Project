package POM_extra;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;

import Object_repository_vtiger.HomePage;
import Object_repository_vtiger.LoginPage;
import Object_repository_vtiger.ProductPage;
import Object_repository_vtiger.VerifyProductPage;
import generic_utility.FileUtility;

public class CreateProductPOMTest {
	public static void main(String[] args) throws InterruptedException, IOException, ParseException {

		// Get the data from json file -- Generic utiltiy
		String browser = FileUtility.getDataFromJsonFile("browser");
		String url = FileUtility.getDataFromJsonFile("url");
		String username = FileUtility.getDataFromJsonFile("username");
		String password = FileUtility.getDataFromJsonFile("password");

		// Get the data from Excel file
		String ProductName = FileUtility.getDataFromExcelFile("Product", 1, 3);
		System.out.println(ProductName);

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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// open the application
		driver.get(url);

		// 1. Login Page Object

		LoginPage lp = new LoginPage(driver);
		lp.getUsernameField().sendKeys(username);
		lp.getPasswordField().sendKeys(password);
		lp.getLoginButton().click();

		// 2. Home Page Object

		HomePage hp = new HomePage(driver);
		hp.getProductsLinks().click();

		// 3. Product page Object
		ProductPage pp = new ProductPage(driver);
		pp.getCreateProductLookImg().click();

		// Test Data
		String PName = "Lloyd";
		String PCode = "L201";
		String PSheet = "L1";
		String Web = "Vtiger.com";
		String SNo = "001";
		String MPNo = "@#";
		String VPNo = "908";

		pp.getProductName().sendKeys(PName);
		pp.getProductCode().sendKeys(PCode);
		pp.getProductSheet().sendKeys(PSheet);
		pp.getWebsite().sendKeys(Web);
		pp.getSerialNo().sendKeys(SNo);
		pp.getPartNo().sendKeys(MPNo);
		pp.getVendorPartNo().sendKeys(VPNo);

		pp.getSaveButton().click();
		System.out.println("Product Detailed Saved Successfully");

		// 4.Verify Contact Page
		VerifyProductPage vpp = new VerifyProductPage(driver);
		String actProductName = vpp.getProductName().getText();
		String actProductCode = vpp.getPartNumber().getText();
		String actProductSheet = vpp.getProductSheet().getText();
		String actSerialNo = vpp.getSerialNo().getText();
		String actMfPNO = vpp.getPartNo().getText();
		String actVendorPNO = vpp.getVendorPartNo().getText();

		// Verification
		if(actProductName.equals(PName) && actProductCode.equals(PCode) 
				&& actProductSheet.equals(PSheet) && actSerialNo.equals(SNo)
				)
		{
			System.out.println("Product successfully verified");
		}
		else
		{
			System.out.println("Product are not successfully verified");
			
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
