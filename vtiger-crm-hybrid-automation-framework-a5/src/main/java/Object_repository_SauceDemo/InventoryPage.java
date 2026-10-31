package Object_repository_SauceDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage {
	
	// initialization
	public InventoryPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	// declaration : Add To Cart
	@FindBy(id = "add-to-cart-sauce-labs-backpack")
	private WebElement addToCart;
	
	public WebElement getAddToCart() {
		return addToCart;
	}

	// declaration : Back Products
	@FindBy(id = "back-to-products")
	private WebElement BackProducts;
	
	public WebElement getBackProducts() {
		return BackProducts;
	}

	public void setBackProducts(WebElement backProducts) {
		BackProducts = backProducts;
	}

	// declaration : BurgerIcon
	@FindBy(id = "react-burger-menu-btn")
	private WebElement burgerIcon;
	
	public WebElement getBurgerIcon() {
		return burgerIcon;
	}

	public void setBurgerIcon(WebElement burgerIcon) {
		this.burgerIcon = burgerIcon;
	}

	// declaration : logout
	@FindBy(id = "logout_sidebar_link")
	private WebElement logoutField;

	public WebElement getLogoutField() {
		return logoutField;
	}

}
