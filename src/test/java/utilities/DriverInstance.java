package utilities;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;

import tests.BaseTest;

public class DriverInstance {

	private WebDriver driver;
	static Logger logger;
	private static DriverInstance driverInstatance =null;
	private DriverInstance() {
		
	}
	
	/*
	  
	 * */
	
	public static DriverInstance getInstance ()
	{
		if(driverInstatance ==null) 
			driverInstatance = new DriverInstance();
		return driverInstatance;
	}	
	
	public WebDriver getDriver() {
	 
		 DesiredCapabilities capabilities;
		 String user_dir;
		 String browser;
		user_dir = System.getProperty("user.dir");
		browser= Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
				.getParameter("browser");
		String osName = BaseTest.osName;
		if(osName.contains("win")) {
		if(browser.equals("Chrome")||browser.equals("chrome")||browser.equals("CHROME")) {
		logger.info("========< Browser set to "+browser+" >========");
		System.setProperty("webdriver.chrome.driver",user_dir+"\\Drivers\\chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("disable-infobars");
		chromeOptions.addArguments("--disable-notifications");
		chromeOptions.addArguments("start-maximized");
		driver = new ChromeDriver(chromeOptions);
		
		
		}
		else if(browser.equalsIgnoreCase("firefox") ||browser.equalsIgnoreCase("mozilla") ){
			FirefoxProfile profile = new FirefoxProfile();
			profile.setAcceptUntrustedCertificates(true);
			profile.setPreference("security.enable_java", true);
			profile.setPreference("plugin.state.java", 2);
			System.setProperty("webdriver.gecko.driver",user_dir+"\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
					
		}
		else if(browser.equalsIgnoreCase("ie") || browser.equalsIgnoreCase("internet explorer") ||  browser.equalsIgnoreCase("internetexplorer")) {
			logger.info("========< Browser set to "+browser+" >========");
			System.setProperty("webdriver.ie.driver", user_dir+"\\Drivers\\IEDriverServer.exe");	
			capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			capabilities.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
			capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
			InternetExplorerOptions options = new InternetExplorerOptions(capabilities);
			driver = new InternetExplorerDriver(options);
		}	
		}
		else if(osName.contains("linux")) {
			
			if (browser.equals("Chrome") || browser.equals("chrome") || browser.equals("CHROME")) {
				logger.info("========< Browser set to " + browser + " >========");
				System.setProperty("webdriver.chrome.driver", user_dir + "//Drivers//Linux//chromedriver");
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("disable-infobars");
				chromeOptions.addArguments("--disable-notifications");
				chromeOptions.addArguments("start-maximized");
				driver = new ChromeDriver(chromeOptions);
			} else if (browser.equalsIgnoreCase("firefox") || browser.equalsIgnoreCase("mozilla")) {
				FirefoxProfile profile = new FirefoxProfile();
				profile.setAcceptUntrustedCertificates(true);
				profile.setPreference("security.enable_java", true);
				profile.setPreference("plugin.state.java", 2);
				System.setProperty("webdriver.gecko.driver", user_dir + "//Drivers//Linux//geckodriver");
				driver = new FirefoxDriver();
			}
		}
		driver.manage().window().maximize();
		return driver;
		
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
}
