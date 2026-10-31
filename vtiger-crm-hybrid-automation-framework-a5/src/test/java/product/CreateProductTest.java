package product;

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

import generic_utility.FileUtility;

public class CreateProductTest {
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

		// How to Read JSON File in Java?
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
		String ProductName = FileUtility.getDataFromExcelFile("Product", 1, 3);
		System.out.println(ProductName);

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

		// Create Product
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
		System.out.println("Successfully Create the Product");

		String PName = "Lloyd";
		String PCode = "L201";
		String PSheet = "L1";
		String Web = "Vtiger.com";
		String SNo = "001";
		String MPNo = "@#";
		String VPNo = "908";

		// fill the details
		driver.findElement(By.name("productname")).sendKeys(PName);
		driver.findElement(By.id("productcode")).sendKeys(PCode);
		driver.findElement(By.id("productsheet")).sendKeys(PSheet);
		driver.findElement(By.name("website")).sendKeys(Web);
		driver.findElement(By.id("serial_no")).sendKeys(SNo);
		driver.findElement(By.id("mfr_part_no")).sendKeys(MPNo);
		driver.findElement(By.id("vendor_part_no")).sendKeys(VPNo);
		System.out.println("Succesfully added details");

		// Save the details
		driver.findElement(By.xpath("(//input[@title=\"Save [Alt+S]\"])[1]")).click();
		System.out.println("Successfully saved the Products details");

		// Verification
		String actPName = driver.findElement(By.xpath("//span[@id=\"dtlview_Product Name\"]")).getText();
		String actPCode = driver.findElement(By.xpath("//span[@id=\"dtlview_Part Number\"]")).getText();
		String actPSheet = driver.findElement(By.xpath("//span[@id=\"dtlview_Product Sheet\"]")).getText();
//		String actWeb = driver.findElement(By.xpath("//span[@]")).getText();
		String actSNo = driver.findElement(By.xpath("//span[@id=\"dtlview_Serial No\"]")).getText();
		String actMPNo = driver.findElement(By.xpath("//span[@id=\"dtlview_Mfr Part No\"]")).getText();
		String actVPNo = driver.findElement(By.xpath("//span[@id=\"dtlview_Vendor Part No\"]")).getText();

		if (actPName.equals(PName) && actPCode.equals(PCode) && actPSheet.equals(PSheet) && actSNo.equals(SNo)
				&& actMPNo.equals(MPNo) && actVPNo.equals(VPNo)) {
			System.out.println("Products created successfully !!!");
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
