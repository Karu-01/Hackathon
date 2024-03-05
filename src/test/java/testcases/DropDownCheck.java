package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import pageobject.*;
import testbase.BaseClass;

public class DropDownCheck extends BaseClass {

	DropdownDetails DD;

	@Test(priority = 1, groups = { "smoke" })
	public void CheckLiving() {
		logger.info("Check the Living Details");
		DD = new DropdownDetails(driver);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
		Assert.assertEquals(DD.checkLiving(), true, "Living is not Displayed");
	}

	@Test(priority = 2, groups = { "smoke" })
	public void SelectLiving() {
		logger.info("Selecting the Living Details");
		DD.selectLiving();
	}

	@Test(priority = 3, groups = { "regression" })
	public void getLivingDetails() throws IOException {
		logger.info("Getting Living Details");
		DD.printLivingDetails();

	}

	@Test(priority = 4, groups = { "regression" })
	public void collectingDetails() throws IOException {
		logger.info("Getting Living Details on Excel");
		DD.excelDetails();
	}

}
