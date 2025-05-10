package day5;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;


public class ParsingXMLResponse {

	//@Test
	void validatingXMLResponse() {
		
		//Approach 1
//		
//		given()
//		
//		.when()
//		.get("https://run.mocky.io/v3/d956bd36-fefd-4156-a5ea-5d1dc3508ba8")
//		
//		.then()
//		.statusCode(200)
//		.header("Content-Type", "application/xml; charset=UTF-8")
//		.body("customers.pagination.page", equalTo("1"))
//		.body("customers.customer_records.customer[0].full_name", equalTo("Emily Williams"));
		
		
		//Approach 2
		
		Response res = given()
		
		.when()
		.get("https://run.mocky.io/v3/d956bd36-fefd-4156-a5ea-5d1dc3508ba8");
		
		Assert.assertEquals(res.getStatusCode(), 200);
		Assert.assertEquals(res.header("Content-Type"), "application/xml; charset=UTF-8");
		
		String pageNo = res.xmlPath().get("customers.pagination.page").toString();
		Assert.assertEquals(pageNo, "1");
		
		String customerName= res.xmlPath().get("customers.customer_records.customer[0].full_name").toString();
		Assert.assertEquals(customerName, "Emily Williams");
		
		
	}
	
	
	@Test
	void testXMLResponse() {
		  
		Response res= given()
					
					 .when()
					 .get("https://run.mocky.io/v3/d956bd36-fefd-4156-a5ea-5d1dc3508ba8");
		
		XmlPath xobject=new XmlPath(res.asString());
		
		List<String> customerinfo = xobject.getList("customers.customer_records.customer");
		Assert.assertEquals(customerinfo.size(), 200);
		
		List<String> customerName =xobject.getList("customers.customer_records.customer.full_name");
		
		
		boolean status = false;
		for(String fullName :customerName) {
			
			if (fullName.equals("John Davis")) {
				status= true;
				break;
			}
		}
		Assert.assertEquals(status, true);
	}
	
	/*
	 * File Upload-->
	 * 
	 * 1)SINGLE FILE UPLOAD
	 * 
	 * IMP - We dont have any jar file right noe so we only write the file upload code and logics and validate
	 * 
	 * 		void singleFileUpload(){
	 * 		
	 * 			File myFile= new File("Enter the path of file here");
	 * 
	 * 			given()
	 * 			.multipart("file",myFile)
	 * 			.contentType("multipart/form-data")
	 * 
	 * 			.when()
	 * 			.post("File upload URL")
	 * 
	 * 			.then()
	 * 			.statusCode(200)
	 * 			.body("myfile", equalTo("fileName")
	 * 			.log().all();
	 * 
	 * 2)MULTIPLE FILE UPLOAD	
	 * 
	 * 		void multipleFileUpload(){
	 * 		
	 * 			File myFile= new File("Enter the path of file here");
	 * 
	 * 			given()
	 * 			.multipart("files",myFile1)  -----------observe change 'file' to 'files'
	 * 			.multipart("files",myFile2)  -----------observe change 'file' to 'files'
	 * 			.contentType("multipart/form-data")
	 * 
	 * 			.when()
	 * 			.post("File upload URL")
	 * 
	 * 			.then()
	 * 			.statusCode(200)
	 * 			.body("[0].myfile1", equalTo("fileName1")
	 * 			.body("[1].myfile1", equalTo("fileName2")
	 * 			.log().all();
	 * 
	 * 
	 * 3) FILE DOWNLOAD
	 *   	
	 *   	void fileUpload(){
	 *   
	 *   	given()
	 *   
	 *   	.when()
	 *   	.get("download file url enter here")
	 *   	.then()
	 *   	.statusCode(200);
	 *   
	 *   
	 *   }
	 * }
	 */
	
	
     }
