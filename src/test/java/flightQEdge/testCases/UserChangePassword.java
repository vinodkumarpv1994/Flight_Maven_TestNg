package flightQEdge.testCases;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import flightQEdge.library.LoginPage;
import utils.AppUtils;

public class UserChangePassword extends AppUtils{
   
	@Parameters({"userID","userPWD","oldPassword","newPassword"})
	@Test
	public void changePassword(String userID, String userPWD, String oldPassword, String newPassword) throws InterruptedException
	{
		LoginPage lp = new LoginPage();
		lp.login(userID, userPWD);
		String successMsg = lp.changePWD(oldPassword, newPassword);
		lp.logout();
		lp.login(userID, newPassword);
		boolean expRes = lp.isUserModuleDisplayed();
		assertTrue(expRes, successMsg);
		lp.logout();
		
	}
	
}
