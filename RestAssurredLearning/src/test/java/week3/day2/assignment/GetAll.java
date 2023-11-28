package week3.day2.assignment;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAll extends Baseclass {
	
	@Test(dependsOnMethods = "week3.day2.assignment.DeleteIssue.delete")
	public void getall()	
	
	{
		Response resp = RestAssured.given().queryParam("jql", "project=\"RestApi2023\"")
				.get("rest/api/2/search");
		//Response resp = RestAssured.get("rest/api/2/issue/"+issueid);

		resp.prettyPrint();

		resp.then().assertThat().statusCode(Matchers.equalTo(200));
		
		resp.then().assertThat().body("id", Matchers.not(issueid));
	}

}
