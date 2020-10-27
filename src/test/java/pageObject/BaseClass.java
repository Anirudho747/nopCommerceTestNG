package pageObject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

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
    
    @BeforeClass
    public void setUp()
    {
    	WebDriverManager.chromedriver().setup();
    	driver = new ChromeDriver();
    	driver.manage().window().maximize();
    	driver.manage().timeouts().pageLoadTimeout(160, TimeUnit.SECONDS);
    	driver.manage().timeouts().implicitlyWait(160,TimeUnit.SECONDS);
    	cnfgr = new Cnfgrtn();
    }
    
    @AfterClass
    public void tearDown()
    {
    	ss = new Snpsht();
    	ss.Snpshot(driver);
    	driver.quit();
    }

}
