package endtoend;

import java.io.IOException;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageobject.DropdownDetails;
import pageobject.GiftCardDetails;
import pageobject.HomePage;
import testbase.BaseClass;
import utilities.JsonRead;

public class EndtoEnd extends BaseClass{
	HomePage hp;
	DropdownDetails DD;
	GiftCardDetails GD;
	

	@Test(priority = 1)
	public void verifyBookShelves() throws InterruptedException {
		logger.info("Type Book Shelves on search Box"); // Log message
		hp = new HomePage(driver);
		hp.searchBookShelves();
	}

	@Test(priority = 2)
	public void clickBookShelves() throws InterruptedException {
		logger.info("Select Book Shelves"); // Log message
		hp.clickBookShelves();
	}

	@Test(priority = 3)
	public void checkpopup() {
		logger.info("Check the Pop-up is visible or not"); // Log message
		Assert.assertEquals(hp.popupvisible(), true, "Pop-up is not Displayed");
	}

	@Test(priority = 4)
	public void popupClose() {
		logger.info("Closing Pop-up"); // Log message
		hp.closePopUp();
	}

	@Test(priority = 5)
	public void checkpriceFilter() {
		logger.info("Check the PriceFilter is visible or not"); // Log message
		Assert.assertEquals(hp.priceFiltervisible(), true, "PriceFilter is not Displayed");
	}

	@Test(priority = 6)
	public void setPriceFilter() {
		logger.info("Setting Price Filter"); // Log message
		hp.priceFilter();
	}

	@Test(priority = 7)
	public void checksort() {
		logger.info("Check the sort is visible or not"); // Log message
		Assert.assertEquals(hp.sortvisible(), true, "Sort is not Displayed");
	}

	@Test(priority = 8)
	public void sortByPriceHighToLow() {
		logger.info("Sorting by Price High to Low"); // Log message
		hp.sortBy();
	}

	@Test(priority = 9)
	public void checkcategory() {
		logger.info("Check the category is visible or not"); // Log message
		Assert.assertEquals(hp.categoryvisible(), true, "category is not Displayed");
	}

	@Test(priority = 10)
	public void chooseCategory() {
		logger.info("Choosing Category"); // Log message
		hp.category();
	}

	@Test(priority = 11)
	public void checkCheckbox() {
		logger.info("Check the Checkbox is visible or not"); // Log message
		Assert.assertEquals(hp.Checkboxvisible(), true, "Checkbox is not Displayed");
	}

	@Test(priority = 12)
	public void outOfStockCheckbox() {
		logger.info("Click Out of Stock Checkbox"); // Log message
		hp.outOfStockCheckbox();
	}

	@Test(priority = 13)
	public void getBookDetails() throws InterruptedException, IOException {
		logger.info("Getting Book Details"); // Log message
		System.out.println("----Product and Price----");
		hp.getBookshelvesDetails();
	}

	@Test(priority = 14)
	public void writeExcel() throws IOException {
		logger.info("Writing Excel"); // Log message
		hp.writeExcel();
	}

	@Test(priority = 15)
	public void CheckLiving() {
		logger.info("Check the Living Details");
		DD = new DropdownDetails(driver);
		Assert.assertEquals(DD.checkLiving(), true, "Living is not Displayed");
	}

	@Test(priority = 16)
	public void SelectLiving() {
		logger.info("Selecting the Living Details");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
		DD.selectLiving();
	}

	@Test(priority = 17)
	public void getLivingDetails() throws IOException {
		logger.info("Getting Living Details");
		DD.printLivingDetails();

	}

	@Test(priority = 18)
	public void collectingDetails() throws IOException {
		logger.info("Getting Living Details on Excel");
		DD.excelDetails();
	}
	@Test(priority = 19)
    public void CheckGiftCards() {
        logger.info("Check Gift Cards"); // Log message
        GD = new GiftCardDetails(driver);
        Assert.assertEquals(GD.GiftCardsvisible(), true, "GiftCard is not Displayed");
        
    }
	@Test(priority = 20)
	 public void GetGiftCards() {
	        logger.info("Getting Gift Cards");
	        GD.ClickGiftcards();
	        
	}
	
	@Test(priority = 21)
    public void CheckBirthday() {
        logger.info("Check Birthday or Annivesary visible"); // Log message
        Assert.assertEquals(GD.Birthdayvisible(), true, "Birthday or Annivesary is not Displayed");
    }
	@Test(priority = 22)
	 public void SelectBirthday() {
	        logger.info("Select Birthday or Annivesary ");
	        GD.ClickBirthday();
	        
	}
	@Test(priority = 23)
    public void Checkcustomizationvisible() {
        logger.info("Check customization visible"); // Log message
        Assert.assertEquals(GD.customizationvisible(), true, "customization is not Displayed");
    }
	
    @Test(priority = 24)
    public void Customizing() {
        logger.info("Customizing Gift Card"); // Log message
        GD.getcustomization();
    }
    @Test(priority = 25)
    public void filldetailsvisible() {
        logger.info("Check filldetails visible"); // Log message
        
        Assert.assertEquals(GD.customizationvisible(), true, "filldetails is not Displayed");
    }

    @Test(priority = 26)
    public void invalidDetailsFilling() throws IOException {
        logger.info("Filling Invalid Details"); // Log message
        GD.fillInvaliddetails();
    }
    
    @Test(priority = 27)
    public void captureAndDisplayErrorMessage() {
        logger.info("Capturing and Displaying Error Message"); // Log message
        captureScreen("InvalidDeails");
    }


    @Test(priority = 28)
    public void validateDetails() {
        logger.info("Validating Gift Card Details"); // Log message
        GD.fillValiddetails();
    }


    @Test(priority = 29)
    public void validateAllDetails() throws IOException {
        logger.info("Validating All Details in Confirm Details section"); // Log message
        GD.getdetails();
    }
    
    @Test(priority = 30)
    public void writeDetailsToJson() throws IOException {
        logger.info("Writing Gift Card Details to JSON"); // Log message
        GD.writeDetailsToJson();
    }
    
    @Test(priority=31)
    public void compareDetails() {
    	logger.info("Writing Gift Card Details to JSON");
    	System.out.println("----Check all the details are equals or not----");
    	JsonRead.CompareData();
    }

}
