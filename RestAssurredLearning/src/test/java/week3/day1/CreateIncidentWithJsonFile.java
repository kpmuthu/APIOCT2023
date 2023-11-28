package week3.day1;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateIncidentWithJsonFile {
	
	@Test
	public void createincidentwithJson()
	{
		RestAssured.baseURI="https://dev90367.service-now.com/api/now/table/";
		RestAssured.authentication=RestAssured.basic("admin", "NQvluT54==pQ");
		
		File file=new File("./src/test/resources/CreateIncident.json");
		
		
		RequestSpecification input = RestAssured.given().contentType("application/json").when().body(file);
		
		Response resp = input.post("incident");
		
		resp.prettyPrint();

		int statusCode = resp.getStatusCode();
		System.out.println("The status code is ---" + statusCode);

		String statusLine = resp.getStatusLine();
		System.out.println("The ststus line is ---" + statusLine);
		
		
		
		
	}

}
