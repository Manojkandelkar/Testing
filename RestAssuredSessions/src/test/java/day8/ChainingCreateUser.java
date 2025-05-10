package day8;


import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class ChainingCreateUser {
	
	
	@Test 
	void createUser(ITestContext context) {
		
		Faker faker=new Faker();
		
		JSONObject data= new JSONObject();
		
		
		data.put("name", faker.name().fullName());
		data.put("gender", "male");
		data.put("email", faker.internet().emailAddress());
		data.put("status", "active");
		
		String token = "459b95f3c8c15d66681b6dc92c04d226263d3c1ebf4298c4fa955a1be333c514";
		
		int id = given()
		.contentType("application/json")
		.header("Authorization", "Bearer "+token)
		.body(data.toString())
		
		.when()
		.post("https://gorest.co.in/public/v2/users")
		.jsonPath().getInt("id");
		
		System.out.println("Id Created :"+id);
		
		context.setAttribute("user_id", id);//this attribute is accessible to only test level
		
		//to make this attribute run at suite level then minor change is need 
		
		context.getSuite().setAttribute("user_id", id);

	}

	
}
