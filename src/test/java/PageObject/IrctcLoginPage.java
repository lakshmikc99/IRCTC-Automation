package PageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

import testScenarios.Driver;

//Operating Login Page
public class IrctcLoginPage extends Driver {
	
WebDriver driver;
Keyword keyword = new Keyword();
	
	public IrctcLoginPage(WebDriver driver ) {
		this.driver= driver;
	}
	
	@FindBy (xpath="//input[@type='text' and @formcontrolname='userid']")
	 WebElement userName;
	
	@FindBy (xpath ="//input[@type='password']")
	 WebElement password;
	
	@FindBy (xpath ="/html/body/app-root/app-home/div[3]/app-login/p-dialog[1]/div/div/div[2]/div[2]/div/div[2]/div[2]/div[2]/form/span/button")
		WebElement signIn;
	
	@FindBy (xpath ="/html/body/app-root/app-home/div[3]/app-login/p-dialog[1]/div/div/div[2]/a")
		WebElement crosslogin;
	
	@FindBy (xpath ="//div[@class='ng-tns-c19-64 ui-dialog-content ui-widget-content']//child::a")
		WebElement cross;
	
	
//Enter the Username using Excel File	
	public void enterUserName(String Name) throws InterruptedException{
		keyword.clickWebElement(driver, userName);
		userName.sendKeys(Name);
		Thread.sleep(4000);
		log.info("Enter UserName");
		
	}
//Enter the Password using Excel File		
	public void enterPassword(String pass) throws InterruptedException{
		
		keyword.clickWebElement(driver, password);
		password.sendKeys(pass);
		log.info("Enter Password");
		Thread.sleep(3000);
	}

//Click on Sign-in button	
	public void clickSignIn() throws InterruptedException {
		keyword.clickWebElement(driver, signIn);
		Thread.sleep(4000);
		log.info("Click on Sign-in button");
	}
	
//To check the message appeared after clicking Sign-in button using Assert
	public void invalidLogin() throws InterruptedException {
//		WebElement checkMsg = driver.findElement(By.xpath("//*[@id=\"login_header_disable\"]/div/div/div[2]/div[2]/div/div[2]/div[1]"));
//	Thread.sleep(4000);
//		String convertToString = checkMsg.getText();
//		Assert.assertTrue(convertToString.matches("Please Enter Valid Captcha"));
//		System.out.println("Not Able To Login. Asking to Enter Valid Captcha");
		String actErrMsg=driver.findElement(By.xpath("//div[contains(text(),'Please Enter Valid Captcha')]")).getText();
	    SoftAssert softAssert=new SoftAssert();
		softAssert.assertEquals(actErrMsg, "Please Enter Valid Captcha");
		softAssert.assertAll();	
		log.info("Invalid message should be displayed");
	}
//closing the login page
	public void crossLogin() throws InterruptedException
	{
		keyword.clickWebElement(driver, crosslogin);
		Thread.sleep(4000);
	}
//Closing the application	
	public void selectCross() throws InterruptedException {
		keyword.clickWebElement(driver, cross);
		Thread.sleep(4000);
	}

	

}
