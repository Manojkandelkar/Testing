package day2;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

/*
 * Diiferent way s to create post request body
 * 1. By using Hashmap
 * 2. By using  org.json
 * 3. By using POJO class
 * 4. By using external json file data
 */



public class WaysToCreatePostReqBody {
	
	// 1. Post request using hashmap
	
	//@Test(priority=1)
	void testUsingHashmap()
	{
		HashMap data = new HashMap();
		
		data.put("name", "Mohan");
		data.put("location", "USA");
		data.put("phone", "123456789");
		String coursearray[] = {"Java","C#"};
		data.put("courses", coursearray);
		
		given()
		.contentType("application/json")
		.body(data)
		
		
		.when()
		.post("http://localhost:3000/students")
		
		
		.then()
		.statusCode(201)
		.body("name",equalTo("Mohan"))
		.body("location", equalTo("USA"))
		.body("phone", equalTo("123456789"))
		.body("courses[0]", equalTo("Java"))
		.body("courses[1]", equalTo("C#"))
		.header("Content-Type", "application/json; charset=utf-8")
		.log().all();
			
	}
	
	
	// 2. Post request using org.json
	
	//@Test(priority=1)
	void postUsingOrgJson() {
		
		JSONObject data = new JSONObject();
		
		data.put("name", "Manoj");
		data.put("location", "UK");
		data.put("phone", "88818881");
		
		String coursearr[] = {"Engineering", "Medical"};
		data.put("courses", coursearr);
		
		
		given()
		.contentType("application/json")
		.body(data.toString())
		
		.when()
		.post("http://localhost:3000/students")
		
		.then()
		.statusCode(201)
		.body("name", equalTo("Manoj"))
		.body("location", equalTo("UK"))
		.body("phone", equalTo("88818881"))
		.body("courses[0]", equalTo("Engineering"))
		.body("courses[1]", equalTo("Medical"))
		.header("Content-Type", "application/json; charset=utf-8")
		.log().all();
		
	}
	
	
	//Post request body using POJO class
	
	//@Test(priority=1)
	void postUsingPOJO() {
		
		GetSetForPojo data = new GetSetForPojo();
		
		data.setName("Paul");
		data.setLocation("Sweden");
		data.setPhone("5566778899");
		
		String coursearr[] = {"BE","ME"};
		data.setCourses(coursearr);
		
		
		given()
		.contentType("application/json")
		.body(data)
		
		.when()
		.post("http://localhost:3000/students")
		
		.then()
		.statusCode(201)
		.log().all();
	}
	
	//Post request body using external json file
	
	@Test(priority=1)
	void postUsingExternalJsonFile() throws FileNotFoundException {
		
		File fl= new File(".\\target\\body.json");
		
		FileReader fr=new FileReader(fl);
		
		JSONTokener jtoken=new JSONTokener(fr);
		
		JSONObject data=new JSONObject(jtoken);
		
		
		given()
		.contentType("application/json")
		.body(data.toString())
		
		.when()
		.post("http://localhost:3000/students")
		
		.then()
		.statusCode(201)
		.body("name", equalTo("Johny"))
		.body("location", equalTo("India"))
		.body("phone", equalTo("1112223333"))
		.body("courses[0]", equalTo("Java"))
		.log().all();
		
	}
	
	
	@Test(priority=2)
	void testDelete() {
		
		when()
		.delete("http://localhost:3000/students/5")
		
		.then()
		.statusCode(200);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
