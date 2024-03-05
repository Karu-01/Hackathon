package pageobject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import utilities.ExcelUtils;

public class DropdownDetails extends BasePage {

	public DropdownDetails(WebDriver driver) {
		super(driver);
	}

	// XPath for SelectLiving
	@FindBy(how = How.XPATH, using = "(//span[@class='topnav_itemname'])[3]")
	public WebElement SelectLiving;

	// XPath for Under living details
	@FindBy(how = How.XPATH, using = "(//*[@id='topnav_wrapper']/ul/li[3]/div/div/ul/li[3]/ul/li/a/span)")
	public List<WebElement> UnderLivingStorage;

	// XPath for Seating details
	@FindBy(how = How.XPATH, using = "(//*[@id='topnav_wrapper']/ul/li[3]/div/div/ul/li[1]/ul/li/a/span)")
	public List<WebElement> SeatingStorage;

	ExcelUtils eu = new ExcelUtils();
	List<String> LivingList = new ArrayList<String>();
	List<String> SeatingList = new ArrayList<String>();

	// Methods
	public boolean checkLiving() {
		Wait(SelectLiving, 50);
		boolean status = SelectLiving.isDisplayed();
		return status;
	}

	// Method to check if "Living" is displayed with comment
	public void selectLiving() {
		// Click on "Living" to expand

		if (SelectLiving != null) {
			SelectLiving.click();
		}

	}

	// Method to select "Living" with comment
	public void printLivingDetails() {
		// Print details of each sub-element
		System.out.println("---LivingStorage---");
		for (WebElement element : UnderLivingStorage) {
			LivingList.add(element.getText());
			System.out.println(element.getText());
		}
		System.out.println("---Seating&Chairs---");
		for (WebElement element : SeatingStorage) {
			SeatingList.add(element.getText());
			System.out.println(element.getText());
		}

	}

	public void excelDetails() throws IOException {
		eu.writeExcelsDetails("TestData", LivingList, SeatingList);
	}

}
