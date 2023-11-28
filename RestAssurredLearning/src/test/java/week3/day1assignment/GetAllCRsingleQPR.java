package week3.day1assignment;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetAllCRsingleQPR {
	
	@Test
	public void getusingsingleqpr() {
		
		RestAssured.baseURI="https://dev90367.service-now.com/api/now/table/";
		
		RestAssured.authentication=RestAssured.basic("admin", "NQvluT54==pQ");	
		
		Response resp = RestAssured.given().queryParam("sysparm_fields", "short_description,description").get("change_request");
		
		resp.prettyPrint();
		
		//resp.then().assertThat().body("result.sysid", Matchers.hasItem(sysid));
		
	}

}
