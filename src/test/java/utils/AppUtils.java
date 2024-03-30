package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;



public class AppUtils
{

	public static WebDriver myDriver;
	public static String url = "http://flights.qedgetech.com";
	//static String broswerName;

    @Parameters({"broswerName"})
	@BeforeSuite
	public static void launchApp(String broswerName)
	{	
		switch (broswerName) 
		{
		case "Chrome":
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			myDriver = new ChromeDriver();
			break;

		case "Edge":
			System.setProperty("webdriver.edge.driver", "msedgedriver.exe");
			myDriver = new EdgeDriver();
			break;

		}
		myDriver.manage().deleteAllCookies();
		myDriver.manage().window().maximize();
		myDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		myDriver.get(url);


	}

	@AfterSuite
	public static void closeApp()
	{
		myDriver.close();
	}

}
