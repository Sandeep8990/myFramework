package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import utilities.UtilFunctions;

public class MainForFramework extends BaseTest{

	@Test
	public void myFrameworkTest() throws InterruptedException, IOException{
		
        String actualTitle = driver.getTitle();
        System.out.println("==== Title : "+actualTitle);
        UtilFunctions.screenshot("HomePage");
	}

}
