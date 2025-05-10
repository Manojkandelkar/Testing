package day6;


import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

// site json convert jsonschema - https://jsonformatter.org/json-to-jsonschema

public class JSONSchemaValidation {
	
	@Test
	void testSchemaValidation() {
		
		given()
		
		.when()
		.get("http://localhost:3000/store")
		
		.then()
		.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("store_schema.json"));
		
	}

}
