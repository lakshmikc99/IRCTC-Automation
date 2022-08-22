package testScenarios;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import PageObject.IrctcHomePage;


public class IrctcHomePageTestt extends Driver{
	@Test
	public void homePageOperation() throws Exception
	{
		
		extentTest = extent.startTest("HomePage");
		IrctcHomePage obj1=PageFactory.initElements(driver,IrctcHomePage.class);
		
		obj1.clickpopUp();
		obj1.searchSource("SBC");
		obj1.searchDestination("PUNE");
		obj1.selectQuota();
		obj1.date();
		obj1.selectClass();
		obj1.checkBox();
		obj1.clickSearch();
	}
}


