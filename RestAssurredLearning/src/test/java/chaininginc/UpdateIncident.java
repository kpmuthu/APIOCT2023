package chaininginc;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateIncident extends Baseclass {

	@Test(dependsOnMethods = "chaining.CreateIncident.createIncident")
	public void updateIncident() {

		RequestSpecification input = RestAssured.given().contentType("application/json").when().body("{\r\n"
				+ "    \"description\": \"Mobile Service\",\r\n" + "    \"short_description\": \"Mobile\"\r\n" + "}");

		Response resp = input.put("incident/" + sysid);

		resp.prettyPrint();

		int statusCode = resp.getStatusCode();
		System.out.println("The status code is ---" + statusCode);

		String statusLine = resp.getStatusLine();
		System.out.println("The ststus line is ---" + statusLine);

		sysid = resp.jsonPath().get("result.sys_id");
		System.out.println("The generated sysId is --- " + sysid);

		resp.then().assertThat().statusCode(Matchers.equalTo(200));
	}

}
