package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.HomePage;

import java.io.IOException;
import testbase.BaseClass;

public class BookshelvesCheck extends BaseClass {

	HomePage hp;

	@Test(priority = 1, groups = { "smoke" })
	public void verifyBookShelves() throws InterruptedException {
		logger.info("Type Book Shelves on search Box"); // Log message
		hp = new HomePage(driver);
		Assert.assertEquals(hp.searchBookShelves(), true, "SearchBox is not Displayed");
	}

	@Test(priority = 2, groups = { "smoke", "regression" })
	public void clickBookShelves() throws InterruptedException {
		logger.info("Select Book Shelves"); // Log message
		hp.clickBookShelves();
	}

	@Test(priority = 3, groups = { "smoke" })
	public void checkpopup() {
		logger.info("Check the Pop-up is visible or not"); // Log message
		Assert.assertEquals(hp.popupvisible(), true, "Pop-up is not Displayed");
	}

	@Test(priority = 4, groups = { "smoke", "regression" })
	public void popupClose() {
		logger.info("Closing Pop-up"); // Log message
		hp.closePopUp();
	}

	@Test(priority = 5, groups = { "smoke" })
	public void checkpriceFilter() {
		logger.info("Check the PriceFilter is visible or not"); // Log message
		Assert.assertEquals(hp.priceFiltervisible(), true, "PriceFilter is not Displayed");
	}

	@Test(priority = 6, groups = { "regression" })
	public void setPriceFilter() {
		logger.info("Setting Price Filter"); // Log message
		hp.priceFilter();
	}

	@Test(priority = 7, groups = { "smoke" })
	public void checksort() {
		logger.info("Check the sort is visible or not"); // Log message
		Assert.assertEquals(hp.sortvisible(), true, "Sort is not Displayed");
	}

	@Test(priority = 8, groups = { "regression" })
	public void sortByPriceHighToLow() {
		logger.info("Sorting by Price High to Low"); // Log message
		hp.sortBy();
	}

	@Test(priority = 9, groups = { "smoke" })
	public void checkcategory() {
		logger.info("Check the category is visible or not"); // Log message
		Assert.assertEquals(hp.categoryvisible(), true, "category is not Displayed");
	}

	@Test(priority = 10, groups = { "regression" })
	public void chooseCategory() {
		logger.info("Choosing Category"); // Log message
		hp.category();
	}

	@Test(priority = 11, groups = { "smoke" })
	public void checkCheckbox() {
		logger.info("Check the Checkbox is visible or not"); // Log message
		Assert.assertEquals(hp.Checkboxvisible(), true, "Checkbox is not Displayed");
	}

	@Test(priority = 12, groups = { "regression" })
	public void outOfStockCheckbox() {
		logger.info("Click Out of Stock Checkbox"); // Log message
		hp.outOfStockCheckbox();
	}

	@Test(priority = 13, groups = { "regression" })
	public void getBookDetails() throws InterruptedException, IOException {
		logger.info("Getting Book Details"); // Log message
		System.out.println("----Product and Price----");
		hp.getBookshelvesDetails();
	}

	@Test(priority = 14, groups = { "regression" })
	public void writeExcel() throws IOException {
		logger.info("Writing Excel"); // Log message
		hp.writeExcel();
	}
}
