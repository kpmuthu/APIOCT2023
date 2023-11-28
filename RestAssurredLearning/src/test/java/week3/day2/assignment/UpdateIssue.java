package week3.day2.assignment;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateIssue extends Baseclass{
	
	@Test(dependsOnMethods = "week3.day2.assignment.CreateIssue.create")
	public void update()
	{
RequestSpecification input = RestAssured.given().contentType("application/json").body("{\r\n"
		+ "    \"fields\": {\r\n"
		+ "\r\n"
		+ "        \"description\": \"Bug updation Using REST API for testing project\"\r\n"
		+ "    }\r\n"
		+ "}\r\n"
		+ "");
		
		Response resp = input.put("rest/api/2/issue/"+projkey);		
			
		resp.then().assertThat().statusCode(Matchers.equalTo(204));
		
	}

}
