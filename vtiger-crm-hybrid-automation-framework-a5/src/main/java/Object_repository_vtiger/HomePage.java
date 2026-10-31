package Object_repository_vtiger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Contacts")
	private WebElement contactsLinks;

	public WebElement getContactsLinks() {
		return contactsLinks;
	}

	@FindBy(linkText = "Leads")
	private WebElement leadLinks;

	public WebElement getLeadLinks() {
		return leadLinks;
	}

	@FindBy(linkText = "Opportunities")
	private WebElement oppLinks;

	public WebElement getOppLinks() {
		return oppLinks;
	}

	@FindBy(linkText = "Organizations")
	private WebElement orgLinks;

	public WebElement getOrgLinks() {
		return orgLinks;
	}

	@FindBy(linkText = "Products")
	private WebElement productsLinks;

	public WebElement getProductsLinks() {
		return productsLinks;
	}

	@FindBy(linkText = "Trouble Tickets")
	private WebElement TroubleTickets;

	public WebElement getTroubleTickets() {
		return TroubleTickets;
	}
	
	// Logout elements
	@FindBy(css="[src='themes/softed/images/user.PNG']")
	private WebElement ProfileIcon;
	
	public WebElement getProfileIcon() {
		return ProfileIcon;
	}
	
	@FindBy(linkText ="Sign Out")
	private WebElement SignoutLink;

	public WebElement getSignoutLink() {
		return SignoutLink;
	}
}
