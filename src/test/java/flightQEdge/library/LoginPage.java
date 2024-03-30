package flightQEdge.library;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import utils.AppUtils;

public class LoginPage extends AppUtils
{ 
	@Parameters({"userID","userPWD"})
	@BeforeTest
	public void login(String userID, String userPWD)
	{
		myDriver.findElement(By.xpath("//input[@placeholder='Email ID']")).sendKeys(userID);
		myDriver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(userPWD);
		myDriver.findElement(By.xpath("//button[@type='submit']")).click();
	}
    
	
	public Boolean isUserModuleDisplayed() 
	{
		try 
		{
			myDriver.findElement(By.partialLinkText("Flight Reservation")).isDisplayed();
			return true;
		} 
		catch (Exception e) 
		{
			return false;
		}

	}
    
	public String changePWD(String oldPWD, String updPWD) throws InterruptedException {
		myDriver.findElement(By.xpath("//a[@data-toggle='dropdown']")).click();
	    myDriver.findElement(By.linkText("Change Password")).click();
	    myDriver.findElement(By.id("address")).sendKeys(oldPWD);
	    myDriver.findElement(By.id("password")).sendKeys(updPWD);
	    myDriver.findElement(By.id("confirm_password")).sendKeys(updPWD);
	    Thread.sleep(3000);
	    myDriver.findElement(By.xpath("//input[@name='submit' and @value='Update']")).click();
	    String scsMSG = myDriver.findElement(By.xpath("/html/body/section[2]/div/div[2]/div/div[2]/div/h4")).getText();
	    return scsMSG;
	}
	
	@AfterTest
	public void logout()
	{
		 myDriver.findElement(By.xpath("//a[@data-toggle='dropdown']")).click();
	     myDriver.findElement(By.linkText("Logout")).click();

	}


}
