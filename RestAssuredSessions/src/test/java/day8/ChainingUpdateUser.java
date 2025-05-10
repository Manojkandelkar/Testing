package day8;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class ChainingUpdateUser {
	
	@Test
	void updateUser(ITestContext context) {
		
		Faker faker=new Faker();
		JSONObject data=new JSONObject();
		
		data.put("name", faker.name().fullName());
		data.put("gender", "female");
		data.put("email", faker.internet().emailAddress());
		data.put("status", "inactive");
		
		String token = "459b95f3c8c15d66681b6dc92c04d226263d3c1ebf4298c4fa955a1be333c514";
		
		//int id =(Integer) context.getAttribute("user_id");
		
		int id=(Integer) context.getSuite().getAttribute("user_id"); //use this attribute to run at suite level

		
		given()
		.headers("Authorization","Bearer "+token)
		.contentType("application/json")
		.body(data.toString())
		.pathParam("id", id)
		
		.when()
		.put("https://gorest.co.in/public/v2/users/{id}")
		
		.then()
		.statusCode(200)
		.log().all();
	}
	
	


}
