package application.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ReadPropFile;

public class WebDriverClass {

	// This class will have all the methods related top browser

	private static WebDriver driver;

	// This method will be used to launch browser window
	@Before
	public void setupBrowser() {
		String browser = ReadPropFile.readData("Config.properties").getProperty("browser");
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	// This method will be used to close browser window
	@After
	public void teardownBrowser() {
		driver.quit();
	}
	
	// Method to share driver details with other classes
	public static WebDriver getDriver() {
		return driver;
	}
	

}
