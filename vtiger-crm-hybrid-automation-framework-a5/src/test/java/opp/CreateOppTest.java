package opp;

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
import org.openqa.selenium.support.ui.Select;

public class CreateOppTest {
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
		JSONParser parser = new JSONParser();
		FileReader reader = new FileReader("./src/test/resources/cd.json");
		Object obj = parser.parse(reader);
		JSONObject jsonObject = (JSONObject) obj;
		String url = (String) jsonObject.get("url");
		String username = (String) jsonObject.get("username");
		String password = (String) jsonObject.get("password");

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

		// Create opportunities
		driver.findElement(By.linkText("Opportunities")).click();
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();

		String Opportunity = "Testing";
		String NextStep = "Playwright";
		String LeadSource = "Employee";
		String SalesStage = "Needs Analysis";
		String RelatedTo = "Accenture";
		String Description = "Successfully saved the details";

		// fill the details
		driver.findElement(By.xpath("//input[@name=\"potentialname\"]")).sendKeys(Opportunity);
		driver.findElement(By.xpath("//input[@name=\"nextstep\"]")).sendKeys(NextStep);
		Select select = new Select(driver.findElement(By.xpath("//select[@name=\"leadsource\"]")));
		select.selectByValue(LeadSource);
		Select select1 = new Select(driver.findElement(By.xpath("//select[@name=\"sales_stage\"]")));
		select1.selectByValue(SalesStage);
		driver.findElement(By.xpath("//input[@value=\"U\"]")).click();
		Select se = new Select(driver.findElement(By.xpath("//select[@name=\"assigned_user_id\"]")));

		driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[1]")).click();
		Thread.sleep(5000);

		String orgName = "automationwithpiyush";

//		handle window
		String PID = driver.getWindowHandle();
//		driver.

//		pass orgName in linkText only while clicking on automationwithpiyush link

		// save the deatils
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		System.out.println("Successfully saved the Opportunities details");

//		verification
		String actOrgName = driver.findElement(By.cssSelector("[title='Organizations']")).getText();
		if (actOrgName.equals(orgName)) {
			System.out.println("related to handled successfully !!!!");
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
