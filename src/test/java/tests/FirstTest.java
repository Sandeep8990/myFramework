package tests;

import java.io.IOException;

import org.testng.annotations.Test;
import page_objects.WelcomePage;
import utilities.UtilFunctions;

public class FirstTest extends BaseTest{
 // private static final Class<WelcomePage> WelcomePage = null;
	WelcomePage newP;

@Test
  public void f() throws IOException {
	  
	  newP =  new WelcomePage(driver);
	  newP.login();
	  UtilFunctions.screenshot("login values");
  }
}
