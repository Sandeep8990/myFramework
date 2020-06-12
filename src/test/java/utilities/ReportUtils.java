package utilities;

import java.io.IOException;

import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportUtils {
	
	private static ReportUtils reporterInstatance = null;
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extentReports;
	public ExtentTest extentTest;

	private ReportUtils() {

	}

	public static ReportUtils getReporterInstance() {
		if (reporterInstatance == null)
			reporterInstatance = new ReportUtils();
		return reporterInstatance;
	}
		
	public void setUpExtend() {
		String user_home = System.getProperty("user.dir");
		htmlReporter = new ExtentHtmlReporter(user_home+"test-output/myReport.html");
		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName("Funtional Report");
		htmlReporter.config().setTheme(Theme.DARK);		
		extentReports = new ExtentReports();
		extentReports.attachReporter(htmlReporter);
		extentReports.setSystemInfo("HostName", "localhost");
		
	}
	
	public void getResult(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) {
			extentTest.log(Status.FAIL, result.getThrowable());
		}
	}
	public void createReportForTest(String testName) {
		extentTest = extentReports.createTest(testName);
	}
	
	public void endReport() {
		extentReports.flush();
	}
	
	/*
	 
	 */
	public void attachScreenshotToReport(String screenshotPath) throws IOException {
		extentTest.addScreenCaptureFromPath(screenshotPath);
	}
	
}
