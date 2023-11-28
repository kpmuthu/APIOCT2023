package chaininginc;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteIncident extends Baseclass {

	@Test(dependsOnMethods = "chaining.UpdateIncident.updateIncident")
	public void deleteIncident() {

		Response resp = RestAssured.delete("incident/" + sysid);

		int statusCode = resp.getStatusCode();
		System.out.println("The status code is ---" + statusCode);

		String statusLine = resp.getStatusLine();
		System.out.println("The ststus line is ---" + statusLine);

		resp.then().assertThat().statusCode(Matchers.equalTo(204));

	}

}
