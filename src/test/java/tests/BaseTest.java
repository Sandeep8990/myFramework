package tests;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;



public class BaseTest {
	
	static WebDriver driver;
	static String baseUrlParam;
	String browser;
	String user_dir;
	Logger logger;
	
	@Parameters({ "browser","baseUrl" })
	@BeforeTest
	public void initialSetup(@Optional("chrome") String browser,@Optional("https://www.google.com") String baseUrlParameter) throws InterruptedException {	
		
	loggerFunc();
	baseUrlParam =baseUrlParameter;
	logger.info("========< Base URL  set to "+baseUrlParam+" >========");
	user_dir = System.getProperty("user.dir");
	if(browser.equals("Chrome")||browser.equals("chrome")||browser.equals("CHROME")) {
	logger.info("========< Browser set to "+browser+" >========");
	System.setProperty("webdriver.chrome.driver",user_dir+"\\Drivers\\chromedriver.exe");
	driver = new ChromeDriver()	;
	driver.manage().window().maximize();
	logger.info("========< window maximized >========");
	driver.get(baseUrlParam);
	logger.info("========< Navigated set to "+baseUrlParam+" >========");
	Thread.sleep(3000);
	}

}
	
	@AfterTest
	public void tearDownActions() {
		driver.quit();
}
	
	public void screenshot(String fileName) throws IOException {
		
		TakesScreenshot scrShot= (TakesScreenshot)driver;
		File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File destFile = new File(user_dir+"\\Screenshots\\"+fileName);
		FileUtils.copyFile(srcFile,destFile);
		logger.info("========< Screenshot attached :  "+fileName+" >========");
	}
	
	public void loggerFunc()
	{
		logger = Logger.getLogger("MyFramework");
		DOMConfigurator.configure("log4j.xml");	
	}
	
}
