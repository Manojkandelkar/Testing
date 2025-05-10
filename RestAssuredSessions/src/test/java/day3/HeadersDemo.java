package day3;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;


public class HeadersDemo {

	@Test
	void headersDemo() {
		
		
		Response res=given()
		
		.when()
		.get("https://www.facebook.com");
		
//		String header_value=res.getHeader("Content-Type");
//		System.out.println("Value of header :"+header_value);
		
		Headers all_headers= res.getHeaders();
		
		for(Header values:all_headers) {
			System.out.println(values.getName()+"          "+values.getValue());
		}
	}
}
