package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.*;
import io.restassured.response.Response;



public class DDTest {
	
	
	@Test(priority=1, dataProvider="Data", dataProviderClass =  DataProviderClass.class)
	public void postUser
			(
			String userId,
			String userName,
			String lastName,
			String userEmail,
			String password,
			String phonNumber
			) 
	
	
	{
		
		User userPayLoad = new User();
		
		
		userPayLoad.setId(Integer.parseInt(userId));
		userPayLoad.setUsername(userName);
		userPayLoad.setLastName(lastName);
		userPayLoad.setEmail(userEmail);
		userPayLoad.setPassword(password);
		userPayLoad.setPhone(phonNumber);
		
		
		Response response = UserEndPoints.createUser(userPayLoad);
		Assert.assertEquals(response.statusCode(), 200);
		
		
		
	}
	
	
	@Test(priority=2, dataProvider = "userName", dataProviderClass = DataProviderClass.class)
	public void deleteUserByName()
	
	{
		
		Response response=UserEndPoints.deleteUser("userName");
		Assert.assertEquals(response.getStatusCode(), 200);
		
		
		 
	}
	
	
	

}









