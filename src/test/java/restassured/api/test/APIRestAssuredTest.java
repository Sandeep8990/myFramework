package restassured.api.test;

import org.testng.annotations.Test;
import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;

public class APIRestAssuredTest {
  @Test
  public void f() {
	  
	  getResponseBody();
	  
  }

	public static void getResponseBody() {
		
		get("http://demo.guru99.com/V4/sinkministatement.php").given().queryParam("CUSTOMER_ID","68195").when().
		then().log().body();
	}
}
