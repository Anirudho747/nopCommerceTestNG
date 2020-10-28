package pageObject;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.Cnfgrtn;
import utility.Snpsht;

public class BaseClass {

	public static WebDriver driver;
	public LoginPage lp;
	public LandingPage LandP;
	public CategoriesPage cp;
    public Cnfgrtn cnfgr;
    public Snpsht ss;
    public ExtentHtmlReporter ehr;
    public ExtentReports report;
    public ExtentTest logger;
    public String ReportPath;
    
    @BeforeClass
    public void setUp()
    {
    	WebDriverManager.chromedriver().setup();
    	driver = new ChromeDriver();
    	driver.manage().window().maximize();
    	driver.manage().timeouts().pageLoadTimeout(160, TimeUnit.SECONDS);
    	driver.manage().timeouts().implicitlyWait(160,TimeUnit.SECONDS);
    	cnfgr = new Cnfgrtn();
    	ss = new Snpsht();
    	
    	ReportPath = "./src/test/resources/Reports/ExtentAt"+ss.getTime()+".html";
    	ehr = new ExtentHtmlReporter(ReportPath); 
    	report = new ExtentReports();
    	report.attachReporter(ehr);
    	
    }
    
    @AfterMethod
    public void tearDown(ITestResult result) throws IOException
    {
    	
    	ss.Snpshot(driver);
    	if(result.getStatus()==ITestResult.FAILURE)
    	{
    	logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(ss.Snpshot(driver)).build());
    	}
    	report.flush();
    	
    }
    
    @AfterSuite
    public void tearDownSuite()
    {
    	driver.quit();
    }

}
