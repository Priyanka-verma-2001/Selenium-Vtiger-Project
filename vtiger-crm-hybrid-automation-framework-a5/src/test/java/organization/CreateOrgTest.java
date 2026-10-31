package organization;

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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import generic_utility.FileUtility;

public class CreateOrgTest {
	public static void main(String[] args) throws InterruptedException, IOException, ParseException {

		// How to Read Data from a Properties File in Java?
		// step: 1 Create a java representation object of the physical file
//		FileInputStream fis = new FileInputStream("./src/test/resources/cd.properties");

		// Step:2 load all the keys by using load(fis)
//		Properties pObj = new Properties();
//		pObj.load(fis);

		// Step:3 get the value by passing key in get Property(key)
//		String browser = pObj.getProperty("bro");
//		String url = pObj.getProperty("url");
//		String username = pObj.getProperty("username");
//		String password = pObj.getProperty("password");

//		fis.close();

		// How to Read JSON File in Java?
//		JSONParser parser = new JSONParser();
//		FileReader reader = new FileReader("./src/test/resources/cd.json");
//		Object obj = parser.parse(reader);
//		JSONObject jsonObject = (JSONObject) obj;
//		String url = (String) jsonObject.get("url");
//		String username = (String) jsonObject.get("username");
//		String password = (String) jsonObject.get("password");

//		 Get the data from excel file
//		FileInputStream fis = new FileInputStream("/Users/priyankaverma/Downloads/AdvanceselniumTestCase-2.xlsx");
//		Workbook wb = WorkbookFactory.create(fis);
//		Sheet sh = wb.getSheet("org");
//		Row rw =sh.getRow(1);
//		Cell cl =rw.getCell(3);
//		String value = cl.getStringCellValue();
//		System.out.println(value);
//		wb.close();

		// Get the data from json file -- Generic utiltiy
		String browser = FileUtility.getDataFromJsonFile("browser");
		String url = FileUtility.getDataFromJsonFile("url");
		String username = FileUtility.getDataFromJsonFile("username");
		String password = FileUtility.getDataFromJsonFile("password");

		// Get the data from Excel file
		String orgName = FileUtility.getDataFromExcelFile("org", 1, 3);
		System.out.println(orgName);

		// Open the browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		// Login Vtiger Crm
		driver.get(url);

		driver.findElement(By.xpath("//input[@name=\"user_name\"]")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name=\"user_password\"]")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id=\"submitButton\"]")).click();

		System.out.println("Successfully login");

		// Create Organization
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
		Thread.sleep(2000);
		System.out.println("Successfully Create the Organizations");

		int random = (int) (Math.random() * 999);

		String OrgName = "google_" + random;
		String Web = "Vtiger";
		String TicSymb = "!@#$%^";
		String Emplo = "200";
		String OtherMail = "pv11234@gmail.com";
		String Phone = "9054886318";
		String Fax = "XYZ";
		String OtherPhone = "1232456789";
		String Email1 = "priyanka1234@gmail.com";
		String Ownership = "4";
		String Industry = "Chemicals";

		// filling Forms
		driver.findElement(By.xpath("//input[@name=\"accountname\"]")).sendKeys(OrgName);
		driver.findElement(By.xpath("//input[@name=\"website\"]")).sendKeys(Web);
		driver.findElement(By.xpath("//input[@name=\"tickersymbol\"]")).sendKeys(TicSymb);
		driver.findElement(By.xpath("//input[@name=\"employees\"]")).sendKeys(Emplo);
		driver.findElement(By.xpath("//input[@id=\"email2\"]")).sendKeys(OtherMail);
		driver.findElement(By.xpath("//input[@id=\"phone\"]")).sendKeys(Phone);
		driver.findElement(By.xpath("//input[@id=\"fax\"]")).sendKeys(Fax);
		driver.findElement(By.xpath("//input[@id=\"otherphone\"]")).sendKeys(OtherPhone);
		driver.findElement(By.xpath("//input[@id=\"email1\"]")).sendKeys(Email1);
		driver.findElement(By.xpath("//input[@id=\"ownership\"]")).sendKeys(Ownership);
		Select select = new Select(driver.findElement(By.xpath("//select[@name=\"industry\"]")));
		select.selectByValue(Industry);
		Thread.sleep(2000);
		System.out.println("Succesfully added details");

		// Save the details
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		System.out.println("Successfully saved the Organization details");

		// Verification
		String actOrgName = driver.findElement(By.xpath("//span[@id=\"dtlview_Organization Name\"]")).getText();
		String actWeb = driver.findElement(By.xpath("//span[@id=\"dtlview_Website\"]")).getText();
		String actTicSymb = driver.findElement(By.xpath("//span[@id=\"dtlview_Ticker Symbol\"]")).getText();
		String actEmplo = driver.findElement(By.xpath("//span[@id=\"dtlview_Employees\"]")).getText();
		String actOtherMail = driver.findElement(By.xpath("//span[@id=\"dtlview_Other Email\"]")).getText();
		String actPhone = driver.findElement(By.xpath("//span[@id=\"dtlview_Phone\"]")).getText();
		String actFax = driver.findElement(By.xpath("//span[@id=\"dtlview_Fax\"]")).getText();
		String actOtherPhone = driver.findElement(By.xpath("//span[@id=\"dtlview_Other Phone\"]")).getText();
		String actEmail1 = driver.findElement(By.xpath("//span[@id=\"dtlview_Email\"]")).getText();
		String actOwnership = driver.findElement(By.xpath("//span[@id=\"dtlview_Ownership\"]")).getText();
		String actIndustry = driver.findElement(By.xpath("//span[@id=\"dtlview_Industry\"]")).getText();

		if (actOrgName.equals(OrgName) && actWeb.equals(Web) && actOwnership.equals(Ownership)
				&& actTicSymb.equals(TicSymb) && actEmplo.equals(Emplo) && actOtherMail.equals(OtherMail)) {
			System.out.println("Org created successfully !!!");
		} else {
			System.out.println("Failed!!!....");
		}

		// logout
		WebElement profile = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
		Actions act = new Actions(driver);
		act.moveToElement(profile).build().perform();

		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("Successfully Sign Out the vtiger");

		Thread.sleep(10000);
		driver.quit();
	}

}
