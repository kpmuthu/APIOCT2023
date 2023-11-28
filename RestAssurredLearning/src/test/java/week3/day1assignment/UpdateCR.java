package week3.day1assignment;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateCR extends Baseclass{
	
	@Test
	public void createChangeCR()
	{
	
	RestAssured.baseURI="https://dev90367.service-now.com/api/now/table/";
	
	RestAssured.authentication=RestAssured.basic("admin", "NQvluT54==pQ");	
	
	
	RequestSpecification input = RestAssured.given().contentType("application/json").when().body("{\r\n"
			+ "    \"description\": \"IPAD Service\",\r\n"
			+ "    \"short_description\": \"IPAD\"\r\n"
			+ "}");
	
	Response resp = input.put("change_request/"+sysid);
	
	resp.prettyPrint();
	
	int statusCode = resp.getStatusCode();
	System.out.println(statusCode);
	
	sysid = resp.jsonPath().get("result.sys_id");
	System.out.println(sysid);
	}

}
