package testScenarios;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import PageObject.IrctcBookPage;

public class IrctcBookPageTest extends Driver {
	@Test
	public void bookPageOperation() throws InterruptedException
	{
		extentTest = extent.startTest("BookPage");
	
		IrctcBookPage obj2=PageFactory.initElements(driver,IrctcBookPage.class);
		obj2.clickSort();;
		obj2.listOfAllTrains();
		obj2.selectTrainNameSl();
		obj2.selectAvailableSeat();
		obj2.clickBookNow();
		obj2.ticketPrice();
		obj2.clickagree();

	}
}
