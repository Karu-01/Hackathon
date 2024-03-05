package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import pageobject.*;
import testbase.BaseClass;
import utilities.JsonRead;

public class GiftCardCheck extends BaseClass {

	GiftCardDetails GD;

	@Test(priority = 1, groups = { "smoke" })
	public void CheckGiftCards() {
		logger.info("Check Gift Cards"); // Log message
		GD = new GiftCardDetails(driver);
		Assert.assertEquals(GD.GiftCardsvisible(), true, "GiftCard is not Displayed");

	}

	@Test(priority = 2, groups = { "smoke" })
	public void GetGiftCards() {
		logger.info("Getting Gift Cards");
		GD.ClickGiftcards();

	}

	@Test(priority = 3, groups = { "smoke" })
	public void CheckBirthday() {
		logger.info("Check Birthday or Annivesary visible"); // Log message
		Assert.assertEquals(GD.Birthdayvisible(), true, "Birthday or Annivesary is not Displayed");
	}

	@Test(priority = 4, groups = { "smoke" })
	public void SelectBirthday() {
		logger.info("Select Birthday or Annivesary ");
		GD.ClickBirthday();

	}

	@Test(priority = 5, groups = { "smoke" })
	public void Checkcustomizationvisible() {
		logger.info("Check customization visible"); // Log message
		Assert.assertEquals(GD.customizationvisible(), true, "customization is not Displayed");
	}

	@Test(priority = 6, groups = { "regression" })
	public void Customizing() {
		logger.info("Customizing Gift Card"); // Log message
		GD.getcustomization();
	}

	@Test(priority = 7, groups = { "smoke" })
	public void filldetailsvisible() {
		logger.info("Check filldetails visible"); // Log message

		Assert.assertEquals(GD.customizationvisible(), true, "filldetails is not Displayed");
	}

	@Test(priority = 8, groups = { "regression" })
	public void invalidDetailsFilling() throws IOException {
		logger.info("Filling Invalid Details"); // Log message
		GD.fillInvaliddetails();
	}

	@Test(priority = 9, groups = { "regression" })
	public void captureAndDisplayErrorMessage() {
		logger.info("Capturing and Displaying Error Message"); // Log message
		captureScreen("InvalidDeails");
		GD.getInvalidMsg();
	}

	@Test(priority = 10, groups = { "regression" })
	public void validateDetails() {
		logger.info("Validating Gift Card Details"); // Log message
		GD.fillValiddetails();
	}

	@Test(priority = 11, groups = { "regression" })
	public void validateAllDetails() throws IOException {
		logger.info("Validating All Details in Confirm Details section"); // Log message
		GD.getdetails();
	}

	@Test(priority = 12, groups = { "regression" })
	public void writeDetailsToJson() throws IOException {
		logger.info("Writing Gift Card Details to JSON"); // Log message
		GD.writeDetailsToJson();
	}

	@Test(priority = 13, groups = { "regression" })
	public void compareDetails() {
		logger.info("Writing Gift Card Details to JSON");
		System.out.println("----Check all the details are equals or not----");
		JsonRead.CompareData();
	}

}
