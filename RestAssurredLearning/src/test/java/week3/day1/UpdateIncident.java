package week3.day1;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateIncident {
	
	@Test
	public void update ()
	{
		RestAssured.baseURI = "https://dev90367.service-now.com/api/now/table/";
		RestAssured.authentication = RestAssured.basic("admin", "NQvluT54==pQ");
		
		RequestSpecification input = RestAssured.given().contentType("application/json").when().body("{\r\n"
				+ "    \"description\": \"Monile Service\",\r\n"
				+ "    \"short_description\": \"Mobile\"\r\n"
				+ "}");
		
		Response resp=input.put("incident/");
		
		resp.prettyPrint();

		int statusCode = resp.getStatusCode();
		System.out.println("The status code is ---" + statusCode);

		String statusLine = resp.getStatusLine();
		System.out.println("The ststus line is ---" + statusLine);

		//String sysid = resp.jsonPath().get("result.sys_id");
		//System.out.println("The generated sysId is --- " + sysid);
	}
	

}
