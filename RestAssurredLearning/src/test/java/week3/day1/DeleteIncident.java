package week3.day1;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteIncident  {
	
	@Test
	public void delete()
	{
		RestAssured.baseURI = "https://dev90367.service-now.com/api/now/table/";
		RestAssured.authentication = RestAssured.basic("admin", "NQvluT54==pQ");
		
			Response resp = RestAssured.delete("incident/");	
		

		int statusCode = resp.getStatusCode();
		System.out.println("The status code is ---" + statusCode);

		String statusLine = resp.getStatusLine();
		System.out.println("The ststus line is ---" + statusLine);

		
	}

}
