package day6;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.matcher.RestAssuredMatchers;

public class XMLSchemaValidation {
	
	@Test
	void testXMLSchemaValidation() {
		
		given()
		
		.when()
		.get("https://run.mocky.io/v3/d956bd36-fefd-4156-a5ea-5d1dc3508ba8")
		
		.then()
		.assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("customer_xmlSchema.xsd"));
		
	}

}
