package pageobject;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utilities.JsonData;

public class GiftCardDetails extends BasePage {

	public GiftCardDetails(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub

	}
	// locators And WebElements

	// XPath for Select Gift Cards
	@FindBy(how = How.XPATH, using = "(//*[ contains (text(), 'Gift Cards' )])[1]")
	public WebElement GiftCards;

	// XPath for birthday Anniversary
	@FindBy(how = How.XPATH, using = "//h3[contains(text(),'Birthday')]")
	WebElement Birthday;

	// XPath to check Customization
	@FindBy(how = How.XPATH, using = "//section[@class='HfdNS'][2]")
	WebElement customization;

	// XPath for giving the amount
	@FindBy(how = How.XPATH, using = "//input[@placeholder='Amount']")
	WebElement Amount;

	// XPath for giving Date
	@FindBy(how = How.XPATH, using = "//select[@class='Upz18 _1hLiD UJU2v'][1]")
	WebElement Month;

	// XPath for giving Date
	@FindBy(how = How.XPATH, using = "//select[@class='Upz18 _1hLiD UJU2v'][2]")
	WebElement Date;

	// XPath for select month
	@FindBy(how = How.XPATH, using = "//option[@value='4/2024']")
	WebElement MonthSelect;

	// XPath for select date
	@FindBy(how = How.XPATH, using = "//option[@value='24']")
	WebElement DateSelect;

	// XPath for Next
	@FindBy(how = How.XPATH, using = "//button[text()='Next']")
	WebElement Next;

	// XPath for filldetails
	@FindBy(how = How.XPATH, using = "//section[@class='_14QEd _2X0VN']")
	WebElement filldetails;

	// XPath Recipient Name
	@FindBy(how = How.NAME, using = "recipient_name")
	WebElement RecipientName;

	// XPath Recipient Email
	@FindBy(how = How.NAME, using = "recipient_email")
	WebElement RecipientEmail;

	// XPath for Recipient Mobile
	@FindBy(how = How.NAME, using = "recipient_mobile_number")
	WebElement RecipientMobile;

	// XPath for CustomerName
	@FindBy(how = How.NAME, using = "customer_name")
	WebElement CustomerName;

	// XPath for CustomerEmail
	@FindBy(how = How.NAME, using = "customer_email")
	WebElement CustomerEmail;

	// XPath for CustomerMobileNumber
	@FindBy(how = How.NAME, using = "customer_mobile_number")
	WebElement CustomerMobileNumber;

	// XPath for CustomerAddress
	@FindBy(how = How.NAME, using = "customer_address")
	WebElement CustomerAddress;

	// XPath for PinCode
	@FindBy(how = How.NAME, using = "zip")
	WebElement PinCode;

	// XPath for CustomerCity
	@FindBy(how = How.XPATH, using = "//*[@id=\"ip_1554905400\"]")
	WebElement CustomerCity;

	// XPath for Message
	@FindBy(how = How.XPATH, using = "//*[@id=\"ip_582840596\"]")
	WebElement Message;

	// XPath for click
	@FindBy(how = How.XPATH, using = "//button[text()='Confirm']")
	WebElement Confirm;

	@FindBy(how = How.XPATH, using = "//*[@id='app-container']/div/main/section/section[4]/div[2]")
	WebElement Receipt;

	@FindBy(how = How.XPATH, using = "//div[@class='BCLqs']")
	WebElement ReceiptAmount;

	@FindBy(how = How.XPATH, using = "//div[@class='dL47V']/div")
	List<WebElement> ReceiptList;

	@FindBy(how = How.XPATH, using = "//div[@class='_2O3hg']/div[@class='dL47V']")
	WebElement ReceiptMessage;

	public String amount, recipientName, recipientEmail, recipientMobile, customerName, customerEmail, customerMobile,
			customerAddress, pin, message;

	JavascriptExecutor js = (JavascriptExecutor) driver;

	// Check if GiftCards is visible
	public boolean GiftCardsvisible() {
		driver.navigate().refresh();
		scroll(GiftCards);
		Wait(GiftCards, 60);
		boolean status = GiftCards.isDisplayed();
		return status;
	}
	// Click on GiftCards
	public void ClickGiftcards() {
		driver.navigate().refresh();
		GiftCards.click();

	}
	
	// Check if Birthday is visible
	public boolean Birthdayvisible() {
		Wait(Birthday, 60);
		boolean status = Birthday.isDisplayed();
		return status;
	}
	
	// Click on Birthday
	public void ClickBirthday() {
		Birthday.click();
	}
	
	// Check if customization is visible
	public boolean customizationvisible() {
		Wait(customization, 60);
		boolean status = customization.isDisplayed();
		return status;
	}
	
	// Perform customization based on JSON data
	public void getcustomization() {
		JsonData.readJSONFile();
		Amount.sendKeys(JsonData.amount);
		Month.click();
		MonthSelect.click();
		Date.click();
		DateSelect.click();
	}
	
	// Check if filldetails is visible
	public boolean filldetailsvisible() {
		Wait(filldetails, 60);
		boolean status = filldetails.isDisplayed();
		return status;
	}
	
	// Fill in invalid details based on JSON data
	public void fillInvaliddetails() {
		RecipientName.sendKeys(JsonData.recipientName);
		RecipientEmail.sendKeys(JsonData.recipientEmail);
		RecipientMobile.sendKeys(JsonData.recipientMobile);
		CustomerName.sendKeys(JsonData.customerName);
		CustomerEmail.sendKeys(JsonData.customerWrongEmail);
		CustomerMobileNumber.sendKeys(JsonData.customerMobile);
		CustomerAddress.sendKeys(JsonData.customerAddress);
		PinCode.sendKeys(JsonData.Pin);
		Message.sendKeys(JsonData.message);
		Confirm.click();
	}
	
	// Get the validation message for invalid email
	public void getInvalidMsg() {
		String tooltipText = CustomerEmail.getAttribute("validationMessage");
		System.out.println("****Error Message***");
		System.out.println(tooltipText);
	}
	
	// Fill in valid details for customer email and click confirm
	public void fillValiddetails() {
		CustomerEmail.clear();
		CustomerEmail.sendKeys(JsonData.customerEmail);
		Confirm.click();
	}
	
	// Get the details from the receipt section
	public void getdetails() throws IOException {
		amount = ReceiptAmount.getText();
		recipientName = ReceiptList.get(0).getText();
		recipientEmail = ReceiptList.get(1).getText();
		recipientMobile = ReceiptList.get(2).getText();
		customerName = ReceiptList.get(3).getText(); 
		customerEmail = ReceiptList.get(4).getText();
		customerMobile = ReceiptList.get(5).getText();
		customerAddress = ReceiptList.get(6).getText();
		pin = ReceiptList.get(7).getText().split(",")[0].trim();
		message = ReceiptMessage.getText();
	}
	
	// Write the details to a JSON file
	public void writeDetailsToJson() throws IOException {
		JsonData.writeToJson(amount, recipientName, recipientEmail, recipientMobile, customerName, customerEmail,
				customerMobile, customerAddress, pin, message);
	}
	
	public void compareData() throws IOException {
		JsonData.CompareData(amount, recipientName, recipientEmail, recipientMobile, customerName, customerEmail,
				customerMobile, customerAddress, pin, message);
	}
	
}