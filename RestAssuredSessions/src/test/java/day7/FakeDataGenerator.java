package day7;

import org.testng.annotations.Test;

import com.github.javafaker.Address;
import com.github.javafaker.Faker;

public class FakeDataGenerator {
	
	
	@Test
	void creatFakeData() {
		
		Faker faker=new Faker();
		
		String fullname=faker.name().fullName();
		String fulladress= faker.address().fullAddress();
		
		String userName = faker.name().username();
		String password = faker.internet().password();
		
		String phoneNum = faker.phoneNumber().cellPhone();
		
		String mailID = faker.internet().emailAddress();
		
		System.out.println("Full Name :" +fullname);
		System.out.println("Address :" +fulladress);
		System.out.println("Phone Number :" +phoneNum);
		System.out.println("Email :" +mailID);
		
		System.out.println("Username :" +userName);
		System.out.println("Password :" +password);
	

		
	}

}
