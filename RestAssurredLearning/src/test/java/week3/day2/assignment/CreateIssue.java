package week3.day2.assignment;

import java.io.File;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateIssue extends Baseclass{
	
	@Test
	public void create()
	{
		
		File file=new File("./src/test/resources/JiraCreateIssue.json");
		
		RequestSpecification input = RestAssured.given().contentType("application/json").body(file);
		
		Response resp = input.post("rest/api/2/issue/");
		
		resp.prettyPrint();
		
		int statusCode = resp.getStatusCode();
		
		 issueid = resp.jsonPath().get("id");
		System.out.println(issueid);
		
		 projkey = resp.jsonPath().get("key");
		System.out.println(projkey);
		
		
		resp.then().assertThat().statusCode(Matchers.equalTo(201));
		resp.then().assertThat().body("key", Matchers.containsString("RES"));
		
		
		
		
	}

}
