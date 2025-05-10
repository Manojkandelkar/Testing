 package day4;


import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class ParsingJSONResponseData {
	
	@Test
	void testJsonResponse() {
		
		//Approach 1
		
//		given()
//		.contentType(Content-Type.JSON)
//		.when()
//		.get("http://localhost:3000/store")
//		
//		.then()
//		.statusCode(200)
//		.header("Content-Type", "application/json; charset=utf-8")
//		.body("book[3].title", equalTo("The lord of the rings"));
		
		//Approch 2
		
//		Response res = given()
//				.contentType(ContentType.JSON)
//				
//				.when()
//				.get("http://localhost:3000/store");
//		
//				Assert.assertEquals(res.getStatusCode(), 200);
//				Assert.assertEquals(res.getHeader("Content-type"), "application/json; charset=utf-8");
//				String bookname= res.jsonPath().getString("book[3].title").toString();
//				Assert.assertEquals(bookname, "The lord of the rings");
		
		//Approach 3
		
		Response res = given()
						.contentType(ContentType.JSON)
					   .when()
					   .get("http://localhost:3000/store");
					   
					   
					   JSONObject jo= new JSONObject(res.asString());
					   
					   
					   //Searching for title of the book - validation
					   boolean status = false;
					   
					   for(int i=0; i<jo.getJSONArray("book").length();i++) {
						   
						   String booktitle= jo.getJSONArray("book").getJSONObject(i).get("title").toString();
						   
						   if(booktitle.equals("The lord of the rings")) {
							   status = true;
							   break;
						   }
						   
					   }
					   Assert.assertEquals(status, true);
					   
					   // Calculating total price of the books available  - validation 2
					   double totalprice =0;
					   for(int i=0; i<jo.getJSONArray("book").length();i++) {
						   
						   String price =jo.getJSONArray("book").getJSONObject(i).get("price").toString();
						   totalprice = totalprice+ Double.parseDouble(price);
						   						   
					   }
					   
					   System.out.println("Total price of the books   :"  +totalprice);
					   Assert.assertEquals(totalprice, 533.5);
		
		
	}

}
