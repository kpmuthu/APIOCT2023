package week3.day1assignment;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteCR extends Baseclass{
	
	@Test
	public void delete()
	{
		RestAssured.baseURI = "https://dev90367.service-now.com/api/now/table/";
		RestAssured.authentication = RestAssured.basic("admin", "NQvluT54==pQ");
		
		Response resp = RestAssured.delete("change_request/"+sysid);	
		

		int statusCode = resp.getStatusCode();
		System.out.println("The status code is ---" + statusCode);

		String statusLine = resp.getStatusLine();
		System.out.println("The ststus line is ---" + statusLine);

		
	}


}
