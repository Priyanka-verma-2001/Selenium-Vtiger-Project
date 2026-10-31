package POM_extra;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import generic_utility.FileUtility;

public class CreateTroubleTickets {
	public static void main(String[] args) throws InterruptedException, IOException, ParseException {

		// How to Read Data from a Properties File in Java?
//		FileInputStream fis = new FileInputStream("./src/test/resources/cd.properties");
//		Properties pObj = new Properties();
//		pObj.load(fis);
//		
//		String url = pObj.getProperty("url");
//		String username = pObj.getProperty("username");
//		String password = pObj.getProperty("password");
//		
//		fis.close();

//		How to Read JSON File in Java?
//		JSONParser parser = new JSONParser();
//		FileReader reader = new FileReader("./src/test/resources/cd.json");
//		Object obj = parser.parse(reader);
//		JSONObject jsonObject = (JSONObject) obj;
//		String url = (String) jsonObject.get("url");
//		String username = (String) jsonObject.get("username");
//		String password = (String) jsonObject.get("password");

		// get the data from Excel file
//		FileInputStream fis = new FileInputStream("/Users/priyankaverma/Downloads/AdvanceselniumTestCase-2.xlsx");
//		Workbook wb = WorkbookFactory.create(fis);
//		Sheet sh = wb.getSheet("Product");
//		Row row = sh.getRow(1);
//		Cell cell = row.getCell(0);
//		String value = cell.getStringCellValue();
//		System.out.println(value);
//		wb.close();

		// Get the data from json file -- Generic utiltiy
		String browser = FileUtility.getDataFromJsonFile("browser");
		String url = FileUtility.getDataFromJsonFile("url");
		String username = FileUtility.getDataFromJsonFile("username");
		String password = FileUtility.getDataFromJsonFile("password");

		// Get the data from Excel file
		String ticketsName = FileUtility.getDataFromExcelFile("TroubleTickets", 1, 2);
		System.out.println(ticketsName);

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		// Open the browser
		driver.get(url);

		// Login Vtiger Crm
		driver.findElement(By.xpath("//input[@name=\"user_name\"]")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name=\"user_password\"]")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id=\"submitButton\"]")).click();
		System.out.println("Successfully login");

		// Create Trouble Tickets
		driver.findElement(By.linkText("Trouble Tickets")).click();
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
		System.out.println("Successfully Create the Trouble Tickets");

		String TName = "Indigo Flight";
		String Hours = "24";
		String Days = "30";
		String Desc = "........!Welcome to Trouble tickets !!!!!.........";
		// fill the details
		driver.findElement(By.name("ticket_title")).sendKeys(TName);
		driver.findElement(By.id("hours")).sendKeys(Hours);
		driver.findElement(By.id("days")).sendKeys(Days);
		driver.findElement(By.name("description")).sendKeys(Desc);

		// Save the details
		driver.findElement(By.xpath("(//input[@title=\"Save [Alt+S]\"])[1]")).click();
		System.out.println("Successfully saved the Trouble Tickets details");

		// Verification
		String actTName = driver.findElement(By.xpath("//span[@id=\"dtlview_Title\"]")).getText();
		String actHours = driver.findElement(By.xpath("//span[@id=\"dtlview_Hours\"]")).getText();
		String actDays = driver.findElement(By.xpath("//span[@id=\"dtlview_Days\"]")).getText();
		String actDesc = driver.findElement(By.xpath("//span[@id=\"dtlview_Description\"]")).getText();

		if (actTName.equals(TName) && actHours.equals(Hours) && actDays.equals(Days) && actDesc.equals(Desc)) {
			System.out.println("Trouble Tickets created successfully !!!");
		} else {
			System.out.println("Failed!!!....");
		}

		// logout
		WebElement profile = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
		Actions act = new Actions(driver);
		act.moveToElement(profile).build().perform();

		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("Successfully Sign Out the vtiger");

		Thread.sleep(2000);
		driver.quit();

	}

}
