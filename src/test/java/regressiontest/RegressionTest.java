package regressiontest;

import java.io.IOException;

import org.testng.annotations.Test;

import pageobject.DropdownDetails;
import pageobject.GiftCardDetails;
import pageobject.HomePage;
import testbase.BaseClass;
import utilities.JsonData;

public class RegressionTest extends BaseClass{
	@Test(priority = 1)
	public void bookshelf() throws IOException {
		HomePage hp=new HomePage(driver);
		hp.searchBookShelves();
		hp.clickBookShelves();
		hp.closePopUp();
		hp.priceFilter();
		hp.sortBy();
		hp.category();
		hp.outOfStockCheckbox();
		hp.getBookshelvesDetails();
		hp.writeExcel();
	}
	@Test(priority = 2)
	public void DropDown() throws IOException {
		 DropdownDetails DD = new DropdownDetails(driver);
		 DD.selectLiving();
		 DD.printLivingDetails();
		 DD.excelDetails();
	}
	@Test(priority = 3)
	public void GiftCard() throws IOException {
		GiftCardDetails GD = new GiftCardDetails(driver);
		GD.ClickGiftcards();
		GD.ClickBirthday();
		GD.getcustomization();
		GD.fillInvaliddetails();
		GD.fillValiddetails();
		GD.getdetails();
		GD.writeDetailsToJson();
		//JsonData.CompareData();
		
	}

}
