package week3.day1assignment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllCRmultipleQPRS {
	
	@Test
	public void getusingmultipleqpr() {
		
		RestAssured.baseURI="https://dev90367.service-now.com/api/now/table/";
		
		RestAssured.authentication=RestAssured.basic("admin", "NQvluT54==pQ");
		
		Map<String,String> paarameters=new HashMap<String,String>();
		
		paarameters.put("sysparm_fields", "short_description,description");
		paarameters.put("sysparm_limit", "3");
		
		Response resp = RestAssured.given().queryParams(paarameters).get("change_request");
		
		resp.prettyPrint();
		
		List<String> sys_ids = resp.jsonPath().getList("result.sys_id");
		System.out.println("Size of teh list---"+sys_ids.size());
		resp.prettyPrint();
		
	}

}
