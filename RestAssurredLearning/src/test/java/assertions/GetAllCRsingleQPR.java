package assertions;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetAllCRsingleQPR extends Baseclass {

	@Test(dependsOnMethods = "assertions.CreateCR.createChangeCR")
	public void getusingsingleqpr() {

		Response resp = RestAssured.given().queryParam("sysparm_fields", "sys_id,number,short_description,description")
				.get("change_request");

		resp.prettyPrint();

		resp.then().assertThat().body("result.sys_id", Matchers.hasItem(sysid));
		resp.then().assertThat().body("result.short_description", Matchers.hasItem("Mobile"));
		resp.then().assertThat().body("result.number",Matchers.anything("CHG"));

	}

}
