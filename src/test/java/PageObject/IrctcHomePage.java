package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testScenarios.Driver;

//Operating Home Page
public class IrctcHomePage extends Driver {

	WebDriver driver;
	Keyword keyword= new Keyword();

	public IrctcHomePage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "//button[@type='submit']")
	WebElement popUp;

	@FindBy(xpath = "//input[@type='text'][1]")
	WebElement fromSource;

	@FindBy(xpath = "//*[@id=\"destination\"]/span/input")
	WebElement toDestination;

	@FindBy(xpath = "//div[@class='ui-dropdown-trigger ui-state-default ui-corner-right ng-tns-c65-12']")
	WebElement quota;

	@FindBy(xpath = "//*[@id=\"journeyClass\"]/div")
	WebElement selectClass;

	@FindBy(xpath = "//*[@id=\"jDate\"]/span/input")
	WebElement date;

	@FindBy(xpath = "//input[@name='availableBerth']//following-sibling::label")
	WebElement selectCheckBox;

	@FindBy(xpath = "//button[@type='submit' and @label='Find Trains']")
	WebElement Search;

//Clicks the pop-up appeared in the irctc page

	public void clickpopUp() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(popUp));
		keyword.clickWebElement(driver, popUp);
		log.warn("Click OK on Covid pop-up alert");
	}

//In 'From' source it will type KSR select the KSR BENGALURU - SBC

	public void searchSource(String searchInput) throws InterruptedException {
		fromSource.sendKeys(searchInput);

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//li[@id='p-highlighted-option']//span[contains(text(), 'KSR BENGALURU - SBC')]"))).click();
		log.info("Enter From source");

	}

//In 'To' source it will type PUNE and select the PUNE as destination	
	public void searchDestination(String searchDest) throws InterruptedException {
		toDestination.sendKeys(searchDest);		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//li[@role='option']//span[contains(text(), 'PUNE JN - PUNE')]")))
				.click();
		log.info("Enter destination source");

	}

//Selects the Ladies quota from the dropdown	
	public void selectQuota() throws InterruptedException {

		keyword.clickWebElement(driver, quota);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"journeyQuota\"]/div/div[4]/div/ul/p-dropdownitem[1]/li/span")))
				.click();
		log.info("Select Ladies quota from the dropdown");

	}

//Selects the date	

	public void date() throws InterruptedException {
		keyword.clickWebElement(driver, date);
		driver.findElement(By.xpath("/html/body/app-root/app-home/div[3]/div/app-main-page/div/div/div[1]/div[1]/div[1]/app-jp-input/div/form/div[2]/div[2]/div[1]/p-calendar/span/div/div/div[2]/table/tbody/tr[4]/td[3]/a")).click();
		log.info("Select the date");
	}

//Selects the 'Ac 2 tier 2A' class	
	public void selectClass() throws InterruptedException {
		selectClass.click();
		driver.findElement(By.xpath("//*[@id=\"journeyClass\"]/div/div[4]/div/ul/p-dropdownitem[6]/li")).click();
		log.info("Select classes as 'AC 2 tier 2A' from dropdown");
	}

//Selects the 'Train with available berth' checkbox	

	public void checkBox() throws InterruptedException {		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(selectCheckBox)).click();
		log.info("Click 'Train with available berth' checkbox");
	}

//Click on Search button	
	public void clickSearch() throws InterruptedException {
		// Search.click();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(Search));
		keyword.clickWebElement(driver, Search);
		log.info("Click Search button");
	}
}
