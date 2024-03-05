package smoketest;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobject.DropdownDetails;
import pageobject.GiftCardDetails;
import pageobject.HomePage;
import testbase.BaseClass;

public class SmokeTestclass extends BaseClass {
	@Test(priority = 1)
	public void bookshelf() {
		HomePage hp=new HomePage(driver);
		hp.searchBookShelves();
		hp.clickBookShelves();
		Assert.assertEquals(hp.popupvisible(), true, "Pop-up is not Displayed");
		hp.closePopUp();
		Assert.assertEquals(hp.priceFiltervisible(), true, "PriceFilter is not Displayed");
		Assert.assertEquals(hp.sortvisible(), true, "Sort is not Displayed");
		Assert.assertEquals(hp.categoryvisible(), true, "category is not Displayed");
		Assert.assertEquals(hp.Checkboxvisible(), true, "Checkbox is not Displayed");
	}
	@Test(priority=2)
	public void dropdown() {
		DropdownDetails DD = new DropdownDetails(driver);
		Assert.assertEquals(DD.checkLiving(), true, "Living is not Displayed");
		DD.selectLiving();
	}
	
	@Test(priority=3)
	public void giftcard() {
		GiftCardDetails GD = new GiftCardDetails(driver);
        Assert.assertEquals(GD.GiftCardsvisible(), true, "GiftCard is not Displayed");
        GD.ClickGiftcards();
        Assert.assertEquals(GD.Birthdayvisible(), true, "Birthday or Annivesary is not Displayed");
        GD.ClickBirthday();
        Assert.assertEquals(GD.customizationvisible(), true, "customization is not Displayed");
        Assert.assertEquals(GD.customizationvisible(), true, "filldetails is not Displayed");


	}
	
	

}
