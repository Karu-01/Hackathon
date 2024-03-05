package pageobject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utilities.ExcelUtils;

public class HomePage extends BasePage {
	ExcelUtils eu = new ExcelUtils();

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='search']")
	WebElement searchBox;

	@FindBy(how = How.XPATH, using = "//div[@class='tt-suggestion tt-selectable']/strong[contains(text(),'bookshelves')]")
	List<WebElement> select;

	@FindBy(how = How.XPATH, using = "//*[@id='urban-ladder-search']/form/div/span/div/div/div[1]")
	WebElement bookShelfSelect;

	@FindBy(how = How.XPATH, using = "//li[@data-group='price'  and @class='item']")
	WebElement priceFilter;

	@FindBy(how = How.XPATH, using = "//div[@class='noUi-handle noUi-handle-upper']")
	WebElement dragVisible;

	@FindBy(how = How.XPATH, using = "//a[@class='close-reveal-modal hide-mobile']")
	WebElement popupClose;

	@FindBy(how = How.XPATH, using = "//li[@data-group='category']")
	WebElement category;

	@FindBy(how = How.XPATH, using = "//input[@type='checkbox'  and @value='Kids Bookshelves']")
	WebElement categoryOption;

	@FindBy(how = How.XPATH, using = "//input[@value='In Stock Only']")
	WebElement checkbox;

	@FindBy(how = How.XPATH, using = "//div[@data-group='sorting' and @class='item']")
	WebElement sortDropDown;

	@FindBy(how = How.XPATH, using = "//li[@class='option' and @data-key='price_desc']")
	WebElement highToLow;

	@FindBy(how = How.XPATH, using = "//span[@itemprop='name']")
	List<WebElement> bookShelvesNameDetail;

	@FindBy(how = How.XPATH, using = "//div[@class='price-number']/span")
	List<WebElement> bookShelvesPriceDetail;

	String productName;
	String productPrice;
	List<String> productNameList = new ArrayList<String>();
	List<String> productPriceList = new ArrayList<String>();
	Actions action = new Actions(driver);
	JavascriptExecutor js = (JavascriptExecutor) driver;

	public boolean searchBookShelves() {
		boolean status=searchBox.isEnabled();
		return status;

	}

	public void clickBookShelves() {
		searchBox.sendKeys("BookShelves");
		bookShelfSelect.click();
	}

	public boolean popupvisible() {
		Wait(popupClose, 60);
		boolean status = popupClose.isDisplayed();
		return status;
	}

	public void closePopUp() {
		Wait(popupClose, 30);
		try {
			hoverOverElement(popupClose);
			popupClose.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean priceFiltervisible() {
		Wait(priceFilter, 60);
		boolean status = priceFilter.isDisplayed();
		return status;
	}

	public void priceFilter() {
		hoverOverElement(priceFilter);
		Wait(dragVisible, 50);
		action.moveToElement(dragVisible).dragAndDropBy(dragVisible, -211, 0).build().perform();
	}

	public boolean categoryvisible() {
		scroll(category);
		Wait(category, 60);
		boolean status = category.isDisplayed();
		return status;
	}

	public void category() {
		scroll(category);
		hoverOverElement(category);
		categoryOption.click();
	}

	public boolean Checkboxvisible() {

		Wait(checkbox, 60);
		boolean status = checkbox.isDisplayed();
		return status;
	}

	public void outOfStockCheckbox() {
		Wait(checkbox, 50);
		js.executeScript("arguments[0].click()", checkbox);
	}
	
	public boolean sortvisible() {

		Wait(sortDropDown, 60);
		boolean status = sortDropDown.isDisplayed();
		return status;
	}
	

	public void sortBy() {
		hoverOverElement(sortDropDown);
		Wait(highToLow, 50);
		highToLow.click();
	}

	public void getBookshelvesDetails() throws IOException {

		for (int i = 0; i < bookShelvesNameDetail.size(); i++) {
			productName = bookShelvesNameDetail.get(i).getText();
			productNameList.add(productName);
			productPrice = bookShelvesPriceDetail.get(i).getText();
			productPriceList.add(productPrice);

			if (i < 3) {
				System.out.println("Product " + (i + 1) + ": " + productName);
				System.out.println("Price Of " + (i + 1) + ":" + productPrice);
			}
		}
	}

	public void writeExcel() throws IOException {
		try {
			eu.writeExcel("TestData", productNameList, productPriceList);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
