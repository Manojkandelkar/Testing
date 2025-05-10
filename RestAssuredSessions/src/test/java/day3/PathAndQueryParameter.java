package day3;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class PathAndQueryParameter {
	
	
	@Test
	void testpathAndQueryPara()
	{	
		//https://reqres.in/api/users?page=2&id=5


		
		given()
		.pathParam("mypath", "users")
		.queryParam("page", "2")
		.queryParam("id", "11")
	
		.when()
		.get("https://reqres.in/api/{mypath}")
	
		.then()
		.statusCode(200)
		.log().all();
	}
}
