package Object_repository_vtiger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerifyProductPage {
	public VerifyProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="dtlview_Product Name")
	private WebElement productName;
	
	public WebElement getProductName() {
		return productName;
	}
	
	@FindBy(id="dtlview_Part Number")
	private WebElement partNumber;
	
	public WebElement getPartNumber() {
		return partNumber;
	}
	
	@FindBy(id="dtlview_Product Sheet")
	private WebElement productSheet;
	
	public WebElement getProductSheet() {
		return productSheet;
	}
	
	@FindBy(id="dtlview_Serial No")
	private WebElement serialNo;
	
	public WebElement getSerialNo() {
		return serialNo;
	}
	
	@FindBy(id="dtlview_Mfr Part No")
	private WebElement partNo;
	
	public WebElement getPartNo() {
		return partNo;
	}
	
	@FindBy(id="dtlview_Vendor Part No")
	private WebElement vendorPartNo;

	public WebElement getVendorPartNo() {
		return vendorPartNo;
	}
	
}
