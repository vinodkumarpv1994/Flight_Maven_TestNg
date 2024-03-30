package flightQEdge.testCases;

import static org.testng.Assert.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import flightQEdge.library.LoginPage;
import utils.AppUtils;



public class UserLoginWithValidInputs  extends AppUtils{
	
	@Parameters({"userID", "userPWD"})
	@Test
	public void userLogin(String userID, String userPWD) throws InterruptedException
	{
		LoginPage lp = new LoginPage();
		lp.login(userID, userPWD);
		boolean expRes = lp.isUserModuleDisplayed();
		assertTrue(expRes);
		lp.logout();
	}
	
}
