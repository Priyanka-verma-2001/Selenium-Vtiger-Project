package Object_repository_vtiger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	public ProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "img[src='themes/softed/images/btnL3Add.gif']")
	private WebElement CreateProductLookImg;
	
	public WebElement getCreateProductLookImg()
	{
		return CreateProductLookImg;
	}
	@FindBy(name = "productname")
	private WebElement productName;

	public WebElement getProductName() {
		return productName;
	}

	@FindBy(id = "productcode")
	private WebElement productCode;

	public WebElement getProductCode() {
		return productCode;
	}

	@FindBy(id = "productsheet")
	private WebElement productSheet;

	public WebElement getProductSheet() {
		return productSheet;
	}

	@FindBy(name = "website")
	private WebElement website;

	public WebElement getWebsite() {
		return website;
	}

	@FindBy(id = "serial_no")
	private WebElement serialNo;

	public WebElement getSerialNo() {
		return serialNo;
	}

	@FindBy(id = "mfr_part_no")
	private WebElement partNo;

	public WebElement getPartNo() {
		return partNo;
	}

	@FindBy(id = "vendor_part_no")
	private WebElement vendorPartNo;

	public WebElement getVendorPartNo() {
		return vendorPartNo;
	}

	@FindBy(className = "save")
	private WebElement saveButton;

	public WebElement getSaveButton() {
		return saveButton;
	}
}
