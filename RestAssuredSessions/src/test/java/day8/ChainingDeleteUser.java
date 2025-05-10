package day8;

import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class ChainingDeleteUser {
	
	@Test
	void deleteUser(ITestContext context) {
		
		String token = "459b95f3c8c15d66681b6dc92c04d226263d3c1ebf4298c4fa955a1be333c514";
		//int id=(Integer) context.getAttribute("user_id");
		
		int id=(Integer) context.getSuite().getAttribute("user_id"); //use this attribute to run at suite level

		
		given()
		.headers("Authorization","Bearer "+token)
		.pathParam("id", id)
		
		.when()
		.delete("https://gorest.co.in/public/v2/users/{id}")
		
		.then()
		.statusCode(204);
		
	}

}
