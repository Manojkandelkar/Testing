package day3;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class LoggingDemo {
	
	@Test
	void logExample() {
		
		given()
		
		.when()
		.get("https://www.facebook.com")
		
		.then()
//		.log().headers()
//		
//		.log().cookies()
//		
//		.log().body()
		.log().all();
	}

}
