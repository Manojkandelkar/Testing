package day3;

import static io.restassured.RestAssured.given;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;


public class CookiesDemo {

	//@Test
	void cookiesExample() {
		
		given()
		
		
		.when()
		.get("https://www.facebook.com")
		
		.then()
		.cookie("fr", "0xZLlwKBJmBuoVSlH..Bn0TPW..AAA.0.0.Bn0TPp.AWUMER32FyY")
		.statusCode(200);

	}
	
	@Test
	void getCookieInfo() {
		
		
		Response res=given()
		
		.when()
		.get("https://www.facebook.com");

		
//		Get single cookies info		
//		String cookie=res.getCookie("fr");
//		System.out.println("Value of cookie :" +cookie);
		
		//get multiple cookies info
		
		Map <String,String>cookies_values=res.getCookies();
		
		for(String k:cookies_values.keySet()) {
			 String cookies= res.getCookie(k);
			 System.out.println(k+"             "+cookies);
		}
		
	}
	}
