package api.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTest {
	
	
	Faker faker;
	User userPayLoad;
	
	
	@BeforeClass
	public void setupData() 
	
	{
	
		faker = new Faker();
		userPayLoad = new User();
		
		userPayLoad.setId(faker.idNumber().hashCode()); // generating fake id 
		userPayLoad.setUsername(faker.name().username());
		userPayLoad.setFirstName(faker.name().firstName());
		userPayLoad.setLastName(faker.name().lastName());
		userPayLoad.setEmail(faker.internet().emailAddress());
		userPayLoad.setPassword(faker.internet().password());
		userPayLoad.setPhone(faker.phoneNumber().cellPhone());
		
	}
	


	
	
	@Test(priority = 1)
	public void postUser()
	{
		
		
		Response response = UserEndPoints.createUser(userPayLoad);
		response.then().log().all();
		
	
		Assert.assertEquals(response.getStatusCode(),200);
		System.out.println(">>>>>public void postUser\\n");
		 
	}
	
	@Test(priority = 2)
	public void getUserByName() {
		
		Response response = UserEndPoints.readUSer(this.userPayLoad.getUsername());
		
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
		
		System.out.println(">>>>>public void getUserByName DONE\\n");
		
	}
	
	@Test(priority = 3)
	public void updateUser() 
	{
		
		faker = new Faker();
		userPayLoad = new User();
		
		userPayLoad.setId(faker.idNumber().hashCode()); // generating fake id 
		userPayLoad.setUsername(faker.name().username());
		userPayLoad.setFirstName(faker.name().firstName());
		userPayLoad.setLastName(faker.name().lastName());
		userPayLoad.setEmail(faker.internet().emailAddress());
		userPayLoad.setPassword(faker.internet().password());
		userPayLoad.setPhone(faker.phoneNumber().cellPhone());
		
		
		Response response = UserEndPoints.updateUser(this.userPayLoad.getUsername(),userPayLoad);
		response.then().log().all();
		Assert.assertEquals(response.statusCode(),200); 
		
		System.out.println(">>>>>public void updateUser DONE\\n");
		
	}
	
	
	@Test(priority=4)
	public void deleteUserByUserName()
	
	{
		
		Response response=UserEndPoints.deleteUser(this.userPayLoad.getUsername());
		Assert.assertEquals(response.getStatusCode(), 200);
		
		
		System.out.println(">>>>>public void deleteUserByUserName DONE\n");
		
		
		
	}
	
	
	
	

	
	}
//	
//	
//	@Test(priority=2)
//	public void getUserByName() {
//		
//		Response response = UserEndPoints.readUser(this.userPayload.getUsername());
//		response.then().log().all();
//		AssertJUnit.assertEquals(response.statusCode(), 200);
//	
//	}
//	
//	@Test(priority=3)
//	public void updateUserByName() {
//		
//		
//		userPayload.setFirstName(faker.name().firstName());
//		userPayload.setLastName(faker.name().lastName());
//		userPayload.setEmail(faker.internet().emailAddress());
//		
//		Response response = UserEndPoints.updateUser(this.userPayload.getUsername(),userPayload);
//		response.then().log().all();// or use .body(StatusCode, 200)
//		
//		AssertJUnit.assertEquals(response.getStatusCode(), 200);// or use .body(StatusCode, 200)
//		
//		Response responseAfterUpdate = UserEndPoints.readUser(this.userPayload.getUsername());
//		response.then().log().all();
//		
//		AssertJUnit.assertEquals(response.getStatusCode(), 200);
//	
//	}
//	
//	
//	public void deletUserByName() 
//	
//	{
//		Response response = UserEndPoints.deleteUser(this.userPayload.getUsername());
//		AssertJUnit.assertEquals(response.getStatusCode(), 200);
//		
//		
//		
//		
//		
//		
//	}
//
//}
//














