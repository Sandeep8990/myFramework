package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;
import tests.BaseTest;

public class UtilFunctions extends BaseTest {
	
	protected static ReportUtils reporter = ReportUtils.getReporterInstance();

	public static String getXMLPropertyValue(String key) {

		String value = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter(key);
		return value;

	}

	public static String screenshot(String fileName) throws IOException {

		String screenshotPath = user_dir + "\\Screenshots\\" + fileName;
		if (osName.toLowerCase().contains("linux")) {
			screenshotPath = user_dir + "//Screenshots//" + fileName;
		}
		TakesScreenshot scrShot = (TakesScreenshot) driver;
		File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File destFile = new File(screenshotPath);
		FileUtils.copyFile(srcFile, destFile);
		logger.info("========< Screenshot attached :  " + fileName + " >========");
		String destinationPath = destFile.getAbsolutePath().toString();
		reporter.attachScreenshotToReport(destinationPath);
		return destinationPath;
	}

}
