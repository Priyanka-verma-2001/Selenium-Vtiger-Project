package POM_extra;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import Object_repository_SauceDemo.InventoryPage;
import Object_repository_SauceDemo.LoginPage;

public class SauceDemoTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		// open the browser
		driver.get("https://www.saucedemo.com/");

		// login SauceDemo Page
//		driver.findElement(By.id("user-name")).sendKeys("standard_user");
//		driver.findElement(By.id("password")).sendKeys("secret_sauce");
//		driver.findElement(By.id("login-button")).click();

		LoginPage lp = new LoginPage(driver);

		WebElement usernameField = lp.getUsernameField();
		WebElement passwordField = lp.getPasswordField();
		WebElement loginButton = lp.getLoginButton();
		usernameField.sendKeys("standard_user");
		passwordField.sendKeys("secret_sauce");
		loginButton.click();
		Thread.sleep(2000);
		System.out.println(".......successfully the login page!!!.......");

		// Verify the home page
		String currentUrl = driver.getCurrentUrl();
		if (currentUrl.contains("inventory.html")) {
			System.out.println("successfully verify the homepage");
		} else {
			System.out.println("Login failed");
		}

//		// Add Sauce Labs Backpack to Cart
////		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		InventoryPage ip = new InventoryPage(driver);
//		WebElement addToCart = ip.getAddToCart();
//		addToCart.click();
//
//		driver.findElement(By.cssSelector("[class='shopping_cart_link']")).click();
//		System.out.println("..........successfully the Cart page!!!......");
//
//		// Your Cart
//		driver.findElement(By.id("checkout")).click();
//		System.out.println("..........successfully the My Cart page!!!......");
//		Thread.sleep(3000);
//
//		// Checkout: Your Information
//		driver.findElement(By.id("first-name")).sendKeys("Priyanka");
//		driver.findElement(By.id("last-name")).sendKeys("Verma");
//		driver.findElement(By.id("postal-code")).sendKeys("201204");
//		driver.findElement(By.id("continue")).click();
//		System.out.println("..........Load the Information Page!!!......");
//		Thread.sleep(3000);
//
//		// Checkout: Overview
//		driver.findElement(By.id("finish")).click();
//		System.out.println("..........successfully the checkout page!!!......");
//		Thread.sleep(3000);
//		// Checkout: Complete!
////		driver.findElement(By.id("back-to-products")).click();
//		WebElement completeField = ip.getBackProducts();
//		completeField.click();
//
//		System.out.println("..........successfully the complete checkout page!!!......");
//		Thread.sleep(3000);

		// BurgerIcon
//		driver.findElement(By.id("react-burger-menu-btn")).click();

		WebElement burgerIconField = ip.getBurgerIcon();
		burgerIconField.click();

		System.out.println("..........successfully the Proflie page!!!......");
		Thread.sleep(3000);

		// About
		driver.findElement(By.id("about_sidebar_link")).click();
		driver.navigate().back();

		// Logout
//		driver.findElement(By.id("logout_sidebar_link")).click();
		burgerIconField.click();

		WebElement logoutField = ip.getLogoutField();
		logoutField.click();
		System.out.println("..........successfully logout sauce demo page!!!......");
		Thread.sleep(3000);

		Thread.sleep(3000);
		driver.quit();

	}
}
