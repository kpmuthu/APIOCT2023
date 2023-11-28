package week3.day1assignment;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateCRJSONfile {
	
	@Test
	public void createChangeCR()
	{
		RestAssured.baseURI="https://dev90367.service-now.com/api/now/table/";
		
		RestAssured.authentication=RestAssured.basic("admin", "NQvluT54==pQ");
		
		File file=new File("./src/test/resources/CreateIncident.json");
		
		RequestSpecification input = RestAssured.given().contentType("application/json").when().body(file);
		
		Response resp = input.post("change_request");
		
		resp.prettyPrint();
		
		int statusCode = resp.getStatusCode();
		System.out.println(statusCode);
		
		String sysid = resp.jsonPath().get("result.sys_id");
		System.out.println(sysid);
		
		
	}
}