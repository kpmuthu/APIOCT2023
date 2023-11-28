package week3.day2.assignment;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteIssue extends Baseclass{
	
	@Test(dependsOnMethods = "week3.day2.assignment.GetIssue.get")
	public void delete()
	{
		Response resp = RestAssured.delete("rest/api/2/issue/"+issueid);
		
		resp.then().assertThat().statusCode(Matchers.equalTo(204));
		
		
		
	}

}
