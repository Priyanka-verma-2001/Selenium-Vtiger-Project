package lead;

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

import generic_utility.FileUtility;

public class CreateLeadTest {
	public static void main(String[] args) throws InterruptedException, IOException, ParseException {

		// How to Read Data from a Properties File in Java?
//		FileInputStream fis = new FileInputStream("./src/test/resources/cd.properties");
//		Properties pObj = new Properties();
//		pObj.load(fis);
//		String url = pObj.getProperty("url");
//		String username = pObj.getProperty("username");
//		String password = pObj.getProperty("password");
//		fis.close();

		// How to Read JSON File in Java?
//		JSONParser parser = new JSONParser();
//		FileReader reader = new FileReader("./src/test/resources/cd.json");
//		Object obj = parser.parse(reader);
//		JSONObject jsonObject = (JSONObject) obj;
//		String browser = (String) jsonObject.get("broswer");
//		String url = (String) jsonObject.get("url");
//		String username = (String) jsonObject.get("username");
//		String password =(String) jsonObject.get("password");

		String browser = FileUtility.getDataFromJsonFile("browser");
		String url = FileUtility.getDataFromJsonFile("url");
		String username = FileUtility.getDataFromJsonFile("username");
		String password = FileUtility.getDataFromJsonFile("password");

		// Get the data from excel file
		String leadName = FileUtility.getDataFromExcelFile("lead", 1, 2);
		System.out.println(leadName);

		// Open the browser
//		WebDriver driver = new ChromeDriver();

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

		driver.findElement(By.xpath("//input[@name=\"user_name\"]")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name=\"user_password\"]")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id=\"submitButton\"]")).click();
		System.out.println("Successfully login");

		// Create Leads
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
		Thread.sleep(2000);
		System.out.println("Successfully Create the Leads");

		String Title = FileUtility.getDataFromExcelFile("lead", 1, 0);
		String FName = FileUtility.getDataFromExcelFile("lead", 1, 1);
		String LName = FileUtility.getDataFromExcelFile("lead", 1, 2);
		String Com = FileUtility.getDataFromExcelFile("lead", 1, 3);
		String PNo = FileUtility.getDataFromExcelFile("lead", 1, 4);
		String MNo = FileUtility.getDataFromExcelFile("lead", 1, 5);
		String Email = FileUtility.getDataFromExcelFile("lead", 1, 6);
		String Web = FileUtility.getDataFromExcelFile("lead", 1, 7);
		String NoEmp = FileUtility.getDataFromExcelFile("lead", 1, 8);
		String Des = FileUtility.getDataFromExcelFile("lead", 1, 9);

		// fill the Details
		Select sel = new Select(driver.findElement(By.xpath("//select[@name=\"salutationtype\"]")));
		sel.selectByValue(Title);
		driver.findElement(By.name("firstname")).sendKeys(FName);
		driver.findElement(By.name("lastname")).sendKeys(LName);
		driver.findElement(By.name("company")).sendKeys(Com);
		driver.findElement(By.id("phone")).sendKeys(PNo);
		driver.findElement(By.id("mobile")).sendKeys(MNo);
		driver.findElement(By.id("email")).sendKeys(Email);
		driver.findElement(By.name("website")).sendKeys(Web);
		driver.findElement(By.id("noofemployees")).sendKeys(NoEmp);
		driver.findElement(By.id("designation")).sendKeys(Des);
		Thread.sleep(2000);
		System.out.println("Succesfully added details");

		// Save the details
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		System.out.println("Successfully saved the Leads details");

		// Verification
//		String actTitle = driver.findElement(By.xpath("//span[@id='dtlview_Title']")).getText();
		String actFName = driver.findElement(By.xpath("//span[@id='dtlview_First Name']")).getText();
		String actLName = driver.findElement(By.xpath("//span[@id='dtlview_Last Name']")).getText();
		String actCom = driver.findElement(By.xpath("//span[@id='dtlview_Company']")).getText();
		String actPNo = driver.findElement(By.xpath("//span[@id='dtlview_Phone']")).getText();
		String actMNo = driver.findElement(By.xpath("//span[@id='dtlview_Mobile']")).getText();
		String actEmail = driver.findElement(By.xpath("//span[@id='dtlview_Email']")).getText();
		String actWeb = driver.findElement(By.xpath("//span[@id='dtlview_Website']")).getText();
		String actNoEmp = driver.findElement(By.xpath("//span[@id='dtlview_No Of Employees']")).getText();
		String actDes = driver.findElement(By.xpath("//span[@id=\"dtlview_Title\"]")).getText();

		if (actFName.equals(FName) && actLName.equals(LName) && actCom.equals(Com) && actPNo.equals(PNo)
				&& actMNo.equals(MNo) && actNoEmp.equals(NoEmp) && actDes.equals(Des)) {
			System.out.println("Leads created successfully !!!");
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
