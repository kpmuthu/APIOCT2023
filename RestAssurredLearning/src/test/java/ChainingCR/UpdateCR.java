package ChainingCR;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateCR extends Baseclass {

	@Test(dependsOnMethods = "ChainingCR.CreateCR.createChangeCR")
	public void updateChangeCR() {

		RequestSpecification input = RestAssured.given().contentType("application/json").when().body("{\r\n"
				+ "    \"description\": \"IPAD Service\",\r\n" + "    \"short_description\": \"IPAD\"\r\n" + "}");

		Response resp = input.put("change_request/" + sysid);

		resp.prettyPrint();

		int statusCode = resp.getStatusCode();
		System.out.println(statusCode);

		sysid = resp.jsonPath().get("result.sys_id");
		System.out.println(sysid);

		resp.then().assertThat().statusCode(Matchers.equalTo(200));
	}

}
