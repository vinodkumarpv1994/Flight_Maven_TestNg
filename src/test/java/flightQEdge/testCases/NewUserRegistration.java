package flightQEdge.testCases;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import flightQEdge.library.User;
import utils.AppUtils;

public class NewUserRegistration extends AppUtils{

	@Parameters({"userName","mobileNo","email","pwd","gender","dob"})
	@Test
	public void userReg(String userName, String mobileNo, String email, String pwd, String gender, String dob) 
	{
		
		User us = new User();
		boolean expRes = us.userRegistration(userName, mobileNo, email, pwd, gender, dob);
		assertTrue(expRes);
	}
	
}
