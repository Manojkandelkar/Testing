package day6;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;




//POJO ----serilize--> JSON Object --- de-serilization---->POJO

public class SerilizationDeserilization {
	
	//@Test
	void testConvertPOJO2Json() throws JsonProcessingException {
		//created Java obj using pojo class 
		StudentsPojo data= new StudentsPojo(); //'data' is java object
		
		data.setName("Marc");
		data.setLocation("China");
		data.setPhone("0000100011");
		String coursearray[] = {"MCA","CA"}; 
		data.setCourses(coursearray);
		
		//convert java obj to json (serilization)
		
		ObjectMapper objMapper = new ObjectMapper();
		
		String jsonData= objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(data);
		
		System.out.println(jsonData);
		
	}
	
	@Test 
	void testJSON2Pojo() throws  JsonProcessingException {
		
		String jsonData ="{\r\n" + 
				"  \"name\" : \"Marc\",\r\n" + 
				"  \"location\" : \"China\",\r\n" + 
				"  \"phone\" : \"0000100011\",\r\n" + 
				"  \"courses\" : [ \"MCA\", \"CA\" ]\r\n" + 
				"}";
		
		ObjectMapper objectMap= new ObjectMapper();
		
		//convert json to pojo --------deserilization
		
		StudentsPojo studJson2Pojo =objectMap.readValue(jsonData, StudentsPojo.class);
		
		System.out.println("Name :" +studJson2Pojo.getName());
		System.out.println("Location :"+studJson2Pojo.getLocation());
		System.out.println("Phone :"+studJson2Pojo.getPhone());
		System.out.println("Course :"+studJson2Pojo.getCourses()[0]);
		System.out.println("Course :"+studJson2Pojo.getCourses()[1]);

	}

}
