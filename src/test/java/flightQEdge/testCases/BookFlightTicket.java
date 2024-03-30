package flightQEdge.testCases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import flightQEdge.library.LoginPage;
import flightQEdge.library.Ticket;



public class BookFlightTicket extends LoginPage{
   
	@Parameters({"dateFly", "flyFrom", "flyTo", "passengerName"})
	@Test
	public void bookFlyTk(String dateFly, String flyFrom, String flyTo, String passengerName) throws InterruptedException 
	{	
		Ticket tk = new Ticket();
		boolean expRes = tk.bookTicket(dateFly, flyFrom, flyTo, passengerName);
		assertTrue(expRes);
	}
	
}
