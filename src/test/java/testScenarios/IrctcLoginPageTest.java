package testScenarios;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Excel.ExcelRead;
import PageObject.IrctcLoginPage;


public class IrctcLoginPageTest extends Driver{
	@Test
	public void loginPageOperation() throws Exception
	{
		extentTest = extent.startTest("LoginPage");

		IrctcLoginPage obj3=PageFactory.initElements(driver,IrctcLoginPage.class);
		
		ExcelRead er = new ExcelRead();
        String username = er.getUsername();
        String password = er.getPassword();
		
		obj3.enterUserName(username);
		obj3.enterPassword(password);
		obj3.clickSignIn();
		obj3.invalidLogin();
		obj3.selectCross();

	}
}
