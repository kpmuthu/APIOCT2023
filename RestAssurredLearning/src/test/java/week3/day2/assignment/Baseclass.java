package week3.day2.assignment;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import io.restassured.RestAssured;

public class Baseclass {

	public static String issueid;
	public static String projkey;

	@BeforeMethod
	public void baseclass() {
		RestAssured.baseURI = "https://pet2023.atlassian.net/";

		RestAssured.authentication = RestAssured.preemptive().basic("petchimuthu0891@gmail.com",
				"ATATT3xFfGF0Wy_KjnN8EG-c3oHk_aFZtURUcesN_YKAhYKyYSkGJzBpLP_GainAgVpQTvDZCR9_BIgL0wqgAG-Fa2VfUFzzzBFfW960k7fUUe2nO_ck8lH5AHkHA6mk-mdRBaG8YCUDbF9BOVRW63Vn-HrTxBBRdLjN3vhO90gZFl9qObwxibs=5B5C25E3");

	}
	
	@AfterTest
	public void Afterdeletevalidation()
	{
		
	}

}
