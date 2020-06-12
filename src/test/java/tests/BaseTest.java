package tests;

import static utilities.UtilFunctions.getXMLPropertyValue;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import utilities.DriverInstance;
import utilities.ReportUtils;

public class BaseTest {

	protected static WebDriver driver;
	static String baseUrlParam;
	public static String osName;
	public static String browser;
	public static String user_dir;
	protected static Logger logger;
	DesiredCapabilities capabilities;
	protected static ReportUtils reporter ;

	@BeforeSuite
	public void beforeSuiteSetUp()
	{
		reporter = ReportUtils.getReporterInstance();
		reporter.setUpExtend();
		//reporter.getResult(result);
	}	
	@AfterSuite
	public void afterSuiteTearDown()
	{
		reporter.endReport();
	}
	@Parameters({ "baseUrl" })
	@BeforeTest
	public void initialSetup(@Optional("https://www.google.com") String baseUrlParameter) throws InterruptedException {
		
		reporter.createReportForTest("TestReport");
		osName = System.getProperty("os.name").toLowerCase();
		browser = getXMLPropertyValue("browser");
		loggerFunc();
		baseUrlParam = baseUrlParameter;
		logger.info("========< Base URL  set to " + baseUrlParam + " >========");
		user_dir = System.getProperty("user.dir");

		DriverInstance instance = DriverInstance.getInstance();
		driver = instance.getDriver();

		logger.info("========< window maximized >========");
		driver.get(baseUrlParam);
		logger.info("========< Navigated set to " + baseUrlParam + " >========");
		Thread.sleep(3000);
	}

	@AfterTest
	public void tearDownActions() {
		driver.quit();
	}

	public void loggerFunc() {
		logger = Logger.getLogger("MyFramework");
		DOMConfigurator.configure("log4j.xml");
	}
	
	

}
