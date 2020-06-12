package tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page_objects.WelcomePage;
import utilities.UtilFunctions;

public class TestNGTEst{
 
	@BeforeClass
	  public void f5() throws IOException {  
		  System.out.println(" Before Class");
	  }
	
	@AfterClass
	  public void f6() throws IOException {  
		  System.out.println(" After class");
	  }

	@BeforeTest
	  public void f3() throws IOException {  
		  System.out.println(" Before test");
	  }
	
	@AfterTest
	  public void f4() throws IOException {  
		  System.out.println(" After test");
	  }
	
	@BeforeMethod
	  public void f7() throws IOException {  
		  System.out.println(" Before method");
	  }
	
	@AfterMethod
	  public void f8() throws IOException {  
		  System.out.println(" After method");
	  }
	
@Test
  public void f1() throws IOException {  
	  System.out.println("First test");
	  testFunMethod();
  }

@Test
public void f() throws IOException {  
	  System.out.println("Second test");
}

 public  void testFunMethod() {
	 System.out.println("Method without annotations");
 }
}
