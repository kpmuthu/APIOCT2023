package week3.day2.assignment;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetIssue extends Baseclass{
	
	@Test(dependsOnMethods = "week3.day2.assignment.UpdateIssue.update")
	public void get()
	{
		Response resp = RestAssured.get("rest/api/2/issue/"+issueid);

		resp.prettyPrint();

		resp.then().assertThat().statusCode(Matchers.equalTo(200));
		//resp.then().assertThat().body("description", Matchers.hasItem("Bug updation Using REST API for testing project"));
		//resp.then().assertThat().body("result.number",Matchers.anything("CHG"));
		
	}

}
