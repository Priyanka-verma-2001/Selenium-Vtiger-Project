package contact;

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
import org.testng.Reporter;
import org.testng.annotations.Test;

import generic_utility.FileUtility;

public class CreateContactTest {
//	public static void main(String[] args) throws InterruptedException, IOException, ParseException {
	
	@Test()
	public void CreateContactTest() throws InterruptedException, IOException, ParseException{

		// How to Read Data from a Properties File in Java?
//		FileInputStream fis = new FileInputStream("./src/test/resources/cd.properties");
//		Properties pObj = new Properties();
//		pObj.load(fis);
//		String browser = pObj.getProperty("browser");
//		String url = pObj.getProperty("url");
//		String username = pObj.getProperty("username");
//		String password = pObj.getProperty("password");
//		fis.close();

		// How to Read JSON File in Java?
//		JSONParser parser = new JSONParser();
//		FileReader fr = new FileReader("./src/test/resources/cd.json");
//		Object obj = parser.parse(fr);
//		JSONObject jsonObject = (JSONObject) obj;
//		String url = (String) jsonObject.get("url");
//		String username = (String) jsonObject.get("username");
//		String password = (String) jsonObject.get("password");
//		
//		 Get the data from excel file
//		FileInputStream fis2 = new FileInputStream("/Users/priyankaverma/Downloads/AdvanceselniumTestCase-2.xlsx");
//		Workbook wb = WorkbookFactory.create(fis2);
//		Sheet sh = wb.getSheet("contact");
//		Row rw  = sh.getRow(1);
//		Cell cl = rw.getCell(0);
//		String value = cl.getStringCellValue();
//		System.out.println(value);
//		wb.close();

		// get the data from json file
		String browser = FileUtility.getDataFromJsonFile("browser");
		String url = FileUtility.getDataFromJsonFile("url");
		String username = FileUtility.getDataFromJsonFile("username");
		String password = FileUtility.getDataFromJsonFile("password");

		// get the data from excel file
		String contactName = FileUtility.getDataFromExcelFile("contact", 1, 3);
		System.out.println(contactName);

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

		// Login
		driver.get(url);

		driver.findElement(By.xpath("//input[@name=\"user_name\"]")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name=\"user_password\"]")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id=\"submitButton\"]")).click();
//		System.out.println("Successfully login");
		Reporter.log("Successsfully login");

		// Create Contact
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@alt=\"Create Contact...\"]")).click();

		String firstName = "Priyanka";
		String lastName = "Verma";
		String officePhone = "Personal Number";
		String mobile = "9548863185";
		String homePhone = "1234567890";

		// fill the form
		driver.findElement(By.xpath("//input[@name=\"firstname\"]")).sendKeys(firstName);
		driver.findElement(By.xpath("//input[@name=\"lastname\"]")).sendKeys(lastName);
		driver.findElement(By.xpath("//input[@id=\"phone\"]")).sendKeys(officePhone);
		driver.findElement(By.xpath("//input[@id=\"mobile\"]")).sendKeys(mobile);
		driver.findElement(By.xpath("//input[@id=\"homephone\"]")).sendKeys(homePhone);

		// Save
		driver.findElement(By.xpath("//input[@class=\"crmButton small save\"]")).click();
		Reporter.log("Successfully saved the contacts details");

		// Verification
		String actLastName = driver.findElement(By.xpath("//span[@id=\"dtlview_Last Name\"]")).getText();
		String actFirstName = driver.findElement(By.xpath("//span[@id=\"dtlview_First Name\"]")).getText();
		String actOfficePhone = driver.findElement(By.xpath("//span[@id=\"dtlview_Office Phone\"]")).getText();
		String actMobile = driver.findElement(By.xpath("//span[@id=\"dtlview_Mobile\"]")).getText();
		String actPhoneNumber = driver.findElement(By.xpath("//span[@id=\"dtlview_Home Phone\"]")).getText();

		if (actLastName.equals(lastName) && actFirstName.equals(firstName) && actOfficePhone.equals(officePhone)
				&& actMobile.equals(mobile) && actPhoneNumber.equals(homePhone)) {
			System.out.println("Contact Successfully created!!!...");
		} else {
			System.out.println("Failed!!!....");
		}
		Thread.sleep(2000);
		Reporter.log("Successfully Verification all the details");

		// logout
		WebElement profile = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
		Actions act = new Actions(driver);
		act.moveToElement(profile).build().perform();

		driver.findElement(By.linkText("Sign Out")).click();
		Reporter.log("Successfully Sign Out the vtiger");

		Thread.sleep(10000);
		driver.quit();
	}
}
