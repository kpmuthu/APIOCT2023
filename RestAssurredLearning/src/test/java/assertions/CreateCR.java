package assertions;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateCR extends Baseclass{

	@Test
	public void createChangeCR() {

		RequestSpecification input = RestAssured.given().contentType("application/json").when().body("{\r\n"
				+ "    \"description\": \"Mobile Service\",\r\n" + "    \"short_description\": \"Mobile\"\r\n" + "}");

		Response resp = input.post("change_request");

		resp.prettyPrint();

		int statusCode = resp.getStatusCode();
		System.out.println(statusCode);

		sysid = resp.jsonPath().get("result.sys_id");
		System.out.println(sysid);
		resp.then().assertThat().statusCode(Matchers.equalTo(201));
		
		//resp.then().assertThat().body("result.short_description", Matchers.hasItem("Mobile"));
		
		resp.then().assertThat().statusLine(Matchers.containsString("201"));
		resp.then().assertThat().body("result.number", Matchers.containsString("CHG"));

	}
}