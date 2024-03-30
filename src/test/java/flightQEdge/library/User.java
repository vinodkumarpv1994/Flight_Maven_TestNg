package flightQEdge.library;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utils.AppUtils;

public class User extends AppUtils
{
   public boolean userRegistration(String userName, String mobileNo, String email, String pwd, String gender, String dob) 
   {
	    myDriver.findElement(By.linkText("Register")).click();
		myDriver.findElement(By.id("name")).sendKeys(userName);
		myDriver.findElement(By.id("contact")).sendKeys(mobileNo);
		myDriver.findElement(By.id("email")).sendKeys(email);
		myDriver.findElement(By.id("address")).sendKeys(pwd);
		Select gen = new Select(myDriver.findElement(By.xpath("//select[@name='gender']")));
		gen.selectByVisibleText(gender);
		myDriver.findElement(By.id("popupDatepicker")).sendKeys(dob);
		
		WebElement checkBox = myDriver.findElement(By.id("flexCheckChecked"));
		if(!checkBox.isSelected()) {
			checkBox.click();
		}
		
		myDriver.findElement(By.xpath("//input[@type='submit' and @name='submit']")).click();
	    
		
		
		try {
			myDriver.findElement(By.xpath("/html/body/div/div[2]/div/div[1]/h4")).isDisplayed();
			return true;
		} 
		catch (Exception e) 
		{
			return false;
		}
   }
}
