package testCase;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.BaseClass;
import pageObject.CategoriesPage;
import pageObject.LandingPage;
import pageObject.LoginPage;
import utility.Cnfgrtn;

public class Common extends BaseClass {
	
@Test(priority=1)
public void allCases()
{
	logger = report.createTest("TestCase: AllCases");
	lp = new LoginPage(driver);
	driver.get(cnfgr.getURL());
	logger.info("URL Accessed");
	lp.typeUname(cnfgr.getUname());
	lp.typePsswrd(cnfgr.getPsswrd());
	lp.clickLogin();
	logger.pass("Login Done");
	Assert.assertEquals(driver.getCurrentUrl(), cnfgr.getAdminURL());
	logger.pass("Base URL Accessed");
	LandP = new LandingPage(driver);
	LandP.clickCatalog();
	LandP.clickCategories_subMenu();
	Assert.assertEquals(driver.getCurrentUrl(), cnfgr.getListURL());
	logger.pass("List URL Accessed");
}	

@Test(priority=2)
public void allCases2()
{
	logger = report.createTest("TestCase: AllCases2");
    cp = new CategoriesPage(driver);
	cp.click_Add_New();
	Assert.assertEquals(driver.getCurrentUrl(), cnfgr.getCreateURL());
	logger.pass("Create URL Accessed");
	cp.enter_Name(cnfgr.getNewTrm());
    cp.choose_Parent_Category();
    cp.save_Category();
    Assert.assertEquals(driver.getCurrentUrl(), cnfgr.getListURL());
    logger.pass("List URL Accessed");
    cp.check_Success_Msg();
    cp.enter_Srch_Name(cnfgr.getSrchTrm());
    cp.click_Srch_Btn();
    cp.match_FirstName(cnfgr.getSrchTrm());
    logger.fail("Name not Matching");
    
}


}
