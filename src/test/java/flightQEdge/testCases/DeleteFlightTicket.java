package flightQEdge.testCases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import flightQEdge.library.LoginPage;
import flightQEdge.library.Ticket;

public class DeleteFlightTicket extends LoginPage {
    
	@Parameters({"delorderID"})
	@Test
	public void delTicket(String delorderID)
	{
		Ticket tk = new Ticket();
		boolean expRes = tk.delTicket(delorderID);
		assertTrue(expRes);
		
	}
}
