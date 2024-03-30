package flightQEdge.library;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utils.AppUtils;

public class Ticket extends AppUtils
{
	public boolean bookTicket(String dateFly, String flyFrom, String flyTo, String passName) throws InterruptedException
	{
		//Date Format --- "MM/DD/YYYY"
		myDriver.findElement(By.id("search-date")).sendKeys(dateFly);

		Select flyFm = new Select(myDriver.findElement(By.xpath("//section[2]/div/div[2]/div/div[2]/div[1]/div/div/div[2]/select")));
		flyFm.selectByVisibleText(flyFrom);

		Select flyT = new Select(myDriver.findElement(By.xpath("//section[2]/div/div[2]/div/div[2]/div[1]/div/div/div[3]/select")));
		flyT.selectByVisibleText(flyTo);
		myDriver.findElement(By.xpath("//section[2]/div/div[2]/div/div[2]/div[1]/div/div/div[4]/button")).click();

		Thread.sleep(2000);

		WebElement flightTable = myDriver.findElement(By.className("flights_table"));
				List<WebElement>resultRows =flightTable.findElements(By.tagName("tr"));
		for(int i=1;i<resultRows.size();i++) {

			List<WebElement>resultCol = resultRows.get(i).findElements(By.tagName("td"));

			for(WebElement colData : resultCol) 
			{
				if(colData.getText().contains("Soft")) 
				{
					for(int j=0;j<resultCol.size();j++) 
					{
						if(resultCol.get(j).getText().equalsIgnoreCase("select"))
						{
							resultCol.get(j).click();
							break;
						}
					}
				}
			}
		}

		myDriver.findElement(By.id("name")).sendKeys(passName);

		WebElement radioPriceClass = myDriver.findElement(By.xpath("//form/div/div[2]/div[2]/div/div[2]/input"));
		if(!radioPriceClass.isSelected()) {
			radioPriceClass.click();
		}
		myDriver.findElement(By.xpath("//form/div/div[4]/div/button")).click();
		myDriver.findElement(By.linkText("View Ticket")).click();
		String fullOrderId = myDriver.findElement(By.xpath("/html/body/section[2]/div/div[2]/div/div[2]/div[1]/div/div/div/div[2]/div[1]")).getText();
		String ticketOrderId = fullOrderId.substring(9);
		Thread.sleep(3000);

		//Verify ticket book order id 

		myDriver.findElement(By.linkText("Flight Bookings")).click();
		WebElement resTable = myDriver.findElement(By.className("flights_table"));
		List<WebElement>resTableRows =resTable.findElements(By.tagName("tr"));
        
		boolean isOderId = false;
		
		for(int i=1;i<resTableRows.size();i++) 
		{
			List<WebElement>resTableCol = resTableRows.get(i).findElements(By.tagName("td"));


			for(WebElement element : resTableCol) 
			{
				String tableData = element.getText();
				if(tableData.equals(ticketOrderId)) 
				{
					isOderId = true;
				}
				
			}

		}
		return isOderId;
	}
	
	public boolean delTicket(String delOrderID)
	{
		myDriver.findElement(By.linkText("Flight Bookings")).click();
		WebElement delTable = myDriver.findElement(By.className("flights_table"));
		List<WebElement>delTableRows =delTable.findElements(By.tagName("tr"));
        
		boolean isDelOderId = false;
		
		for(int i=1;i<delTableRows.size();i++) 
		{
			List<WebElement> delTableCol = delTableRows.get(i).findElements(By.tagName("td"));
			
			String orderID = delTableCol.get(0).getText();
			if(orderID.contains(delOrderID))
			{
				List<WebElement> alist = delTableCol.get(9).findElements(By.tagName("a"));
				
				for (int j = 0; j < alist.size(); j++) 
				{
					String del = alist.get(j).getText();
					if(del.contains("Delete"))
					{
						alist.get(j).click();
						myDriver.switchTo().alert().accept();
						isDelOderId = true;
						break;
					}
				}
			}
			

//			for(WebElement element : delTableCol) 
//			{
//				String tableData = element.getText();
//				if(tableData.equals(delOrderID)) 
//				{
//					List<WebElement> alist = delTableCol.get(9).findElements(By.tagName("a"));
//
//					for(WebElement a : alist) {
//						if(a.getText().contains("Delete"))
//						{
//							a.click();
//							myDriver.switchTo().alert().accept();
//							isDelOderId = true;
//							break;
//						}
//					}
//				}
//				
//			}

		}
		return isDelOderId;
	}
}
