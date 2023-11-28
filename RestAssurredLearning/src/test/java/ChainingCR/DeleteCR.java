package ChainingCR;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteCR extends Baseclass {

	@Test(dependsOnMethods = "ChainingCR.UpdateCR.updateChangeCR")
	public void deleteChangeCR() {

		Response resp = RestAssured.delete("change_request/" + sysid);

		int statusCode = resp.getStatusCode();
		System.out.println("The status code is ---" + statusCode);

		String statusLine = resp.getStatusLine();
		System.out.println("The ststus line is ---" + statusLine);

		resp.then().assertThat().statusCode(Matchers.equalTo(204));

	}

}
