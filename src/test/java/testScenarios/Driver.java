package testScenarios;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {
	public static WebDriver driver;
	public static ChromeOptions options; 

    public static JavascriptExecutor js;
    public static ExtentReports extent;
    public static ExtentTest extentTest;

	public Logger log = Logger.getLogger(Driver.class);

    @BeforeTest
    public void setUp() throws IOException {
    	options= new ChromeOptions();
		options.addArguments("--disable-notifications");
		
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver(options);	
        js = (JavascriptExecutor) Driver.driver;
        log.info("Opening Browser");
        //implicit wait
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        //Navigating to Irctc Page.
        driver.get("https://www.irctc.co.in/nget/train-search");
        log.info("Opened browser");
    }
    //Extent Report Generate location
    @BeforeTest
    public void setExtent(){
        extent= new ExtentReports(System.getProperty("user.dir")+"/test-output/IRCTCExtentReport.html", true);
        extent.addSystemInfo("Host Name", "LakshmiDebosmithaSoumya");
        extent.addSystemInfo("User Name", "Team 6");
        extent.addSystemInfo("Environment", "QA");
    }
    @AfterTest
    public void endReport(){
        extent.flush();
        extent.close();
    }
    //Capture the Failed Testcase Screenshots.
    public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException{
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName
                + ".png";
        File finalDestination = new File(destination);
        FileUtils.copyFile(source, finalDestination);//methods to copy file and directories
        return destination;


    }
    //Generating the logs of testcases  
    @AfterMethod
    public void ListenerTest(ITestResult result ) throws IOException {
        if(result.getStatus()==ITestResult.FAILURE){
            extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getName());
            extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getThrowable()); 
          //To capture screenshot path and store the path of the screenshot in the string "screenshotPath"
            String screenshotPath = Driver.getScreenshot(driver, result.getName());
            extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath)); 
            //extentTest.log(LogStatus.FAIL, extentTest.addScreencast(screenshotPath)); 
        }
        else if(result.getStatus()==ITestResult.SKIP){
            extentTest.log(LogStatus.SKIP, "Test Case SKIPPED IS " + result.getName());
        }
        else if(result.getStatus()==ITestResult.SUCCESS){
            extentTest.log(LogStatus.PASS, "Test Case PASSED IS " + result.getName());

        }


        extent.endTest(extentTest); 


}

    @AfterTest
    public void TeardownTest() {
        driver.close();
        log.info("Browser Closed");
    }
}



