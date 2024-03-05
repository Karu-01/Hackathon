package testbase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import pageobject.HomePage;

public class BaseClass {
	protected static WebDriver driver;
	public static Logger logger;
	public HomePage hp;
	static Properties property;
	
	@BeforeTest(groups = { "smoke","regression" })
	@Parameters({"br"})
	public void setup(String br) throws IOException {
		logger=LogManager.getLogger(this.getClass());
		logger.info("Setting up the driver");
		
		if (getProperties().getProperty("execution_env").equalsIgnoreCase("remote")) {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			// browser
			switch (br.toLowerCase()) {
			case "chrome":
				capabilities.setBrowserName("chrome");
				break;
			case "edge":
				capabilities.setBrowserName("MicrosoftEdge");
				break;
			default:
				System.out.println("No matching browser");
			}
 
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
 
		} else if (getProperties().getProperty("execution_env").equalsIgnoreCase("local")) {
			switch (br.toLowerCase()) {
			case "chrome":
				driver = new ChromeDriver();
				break;
			case "edge":
				driver = new EdgeDriver();
				break;
			default:
				System.out.println("No matching browser");
			}
		}
		driver.get(property.getProperty("baseurl"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        logger.info("Browser launched and navigated to the URL");
	}
	@AfterTest(groups = { "smoke","regression" })
	public void teardown() {
		
		driver.quit();
	}
	public String captureScreen(String filename) {
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\ScreenShot\\"+filename + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
		return targetFilePath;
	}
	public static Properties getProperties() throws IOException {
		String propertyFile = System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties";
		try (FileReader file = new FileReader(propertyFile)) {
			property = new Properties();
			property.load(file);
		}
		return property;
	}
}
