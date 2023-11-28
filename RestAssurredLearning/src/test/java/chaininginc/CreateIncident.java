package chaininginc;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.AuthenticationScheme;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateIncident extends Baseclass {

	@Test
	public void createIncident() {

		RequestSpecification input = RestAssured.given().contentType("application/json").when().body("{\r\n"
				+ "    \"description\": \"Laptop Service\",\r\n" + "    \"short_description\": \"Laptop\"\r\n" + "}");

		Response resp = input.post("incident");

		resp.prettyPrint();

		int statusCode = resp.getStatusCode();
		System.out.println("The status code is ---" + statusCode);

		String statusLine = resp.getStatusLine();
		System.out.println("The ststus line is ---" + statusLine);

		sysid = resp.jsonPath().get("result.sys_id");
		System.out.println("The generated sysId is --- " + sysid);

		resp.then().assertThat().statusCode(Matchers.equalTo(201));

	}

}
