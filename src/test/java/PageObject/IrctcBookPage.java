package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testScenarios.Driver;



//Operating Book Page
public class IrctcBookPage extends Driver{
WebDriver driver;
Keyword keyword= new Keyword();

	
	public  IrctcBookPage(WebDriver driver ) {
		this.driver= driver;
	}
	
	 @FindBy (xpath="//button[@type='button'][1]")
	 	WebElement searchSort;
	 
	@FindBy (xpath="//*[@id=\"divMain\"]/div/app-train-list/div[4]/div/div[5]/div[4]/div[1]/app-train-avl-enq/div[1]/div[5]/div[1]/table/tr/td[2]/div/div[2]")
		WebElement trainNameSl;
	
	@FindBy (xpath="//*[@id=\"divMain\"]/div/app-train-list/div[4]/div/div[5]/div[4]/div[1]/app-train-avl-enq/div[1]/div[7]/div[1]/div[3]/table/tr/td[2]/div/div[2]")
		WebElement availableseat;
	
	@FindBy (xpath="//*[@id=\"divMain\"]/div/app-train-list/div[4]/div/div[5]/div[4]/div[1]/app-train-avl-enq/div[2]/div/span/span[1]/button[1]")
		WebElement bookNow;
	
	@FindBy (xpath="//*[@id=\"divMain\"]/div/app-train-list/p-confirmdialog[1]/div/div/div[3]/button[1]/span[2]")
		WebElement agree;
	
	@FindBy (xpath="//button[@type='button']//span[contains(text(), Yes)][2]")
	WebElement yesButton;
	
	
//Click on 'Sort By Duration' button	
	public void clickSort() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(searchSort));
		keyword.clickWebElement(driver, searchSort);			
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div/div[1]/div[4]/button"))).click();
		log.info("Click on 'Sort by duration' button");
	}
//Click on 'Departure Late First' and Prints all the list of trains	
	public void listOfAllTrains()
	{
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='col-sm-5 col-xs-11 train-heading']"));
        for (WebElement wb : list) {
            System.out.println(wb.getText());
        log.info("Click on 'Departure Late First' and printing all the list of Trains");
        }
	}
//printing  the train names and details we booked	
	public void selectTrainNameSl() throws InterruptedException {
		
		WebElement trainDetails = driver.findElement(By.xpath("//div[@class='white-back no-pad col-xs-12']"));
        System.out.println("Train detains - " +trainDetails.getText());
		WebDriverWait wait = new WebDriverWait(driver, 30);		
		wait.until(ExpectedConditions.visibilityOf(trainNameSl));       
        keyword.clickWebElement(driver, trainNameSl);       
		WebElement availableTrainName = driver.findElement(By.xpath("//td[@class='link ng-star-inserted']"));		
        System.out.println("The available train - " +availableTrainName.getText());      
        log.info("Train details will be printed");
		
	}
//Selecting and 4th Train in the list and click on available seats	
	public void selectAvailableSeat() throws InterruptedException {		
		keyword.clickWebElement(driver, availableseat);		
		log.info("Select the 4th Train in the list");
		
	}
//Click on Book button	
	public void clickBookNow() throws InterruptedException {		
		keyword.clickWebElement(driver, bookNow);		
		log.info("Click on Book button");
		
	}
//Printing the price of the Train we booked	
	public void ticketPrice() throws InterruptedException {
        WebElement checkPrice = driver.findElement(By.xpath("//*[@id=\"divMain\"]/div/app-train-list/div[4]/div/div[5]/div[4]/div[1]/app-train-avl-enq/div[2]/div/span/span[2]/strong"));
        System.out.println("The Price Is - " +checkPrice.getText());
        log.info("Train price will be printed");

    }
//Click on 'I agree' button and 'Yes' button	
	
	public void clickagree() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(agree));		
		keyword.clickWebElement(driver, agree);
		log.info("Click on 'I agree' button");		
		wait.until(ExpectedConditions.elementToBeClickable(yesButton));
		keyword.clickWebElement(driver, yesButton);		
		log.info("Click on 'Yes button' button");

	}
}
