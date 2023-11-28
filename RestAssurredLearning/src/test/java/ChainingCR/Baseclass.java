package ChainingCR;

import org.testng.annotations.BeforeMethod;

import io.restassured.RestAssured;

public class Baseclass {

	public static String sysid;
	

	@BeforeMethod
	public void baseclass() {
		RestAssured.baseURI = "https://dev90367.service-now.com/api/now/table/";

		RestAssured.authentication = RestAssured.basic("admin", "NQvluT54==pQ");
	}

}
