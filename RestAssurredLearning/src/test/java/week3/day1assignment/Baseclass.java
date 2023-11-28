package week3.day1assignment;

import io.restassured.RestAssured;

public class Baseclass {
	
	public static String sysid;

	public void baseclass() {
		RestAssured.baseURI = "https://dev90367.service-now.com/api/now/table/";

		RestAssured.authentication = RestAssured.basic("admin", "NQvluT54==pQ");
	}

}
