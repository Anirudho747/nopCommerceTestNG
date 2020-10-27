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
	
@Test
public void allCases()
{
	lp = new LoginPage(driver);
	driver.get(cnfgr.getURL());
	lp.typeUname(cnfgr.getUname());
	lp.typePsswrd(cnfgr.getPsswrd());
	lp.clickLogin();
	Assert.assertEquals(driver.getCurrentUrl(), cnfgr.getAdminURL());
	LandP = new LandingPage(driver);
	LandP.clickCatalog();
	LandP.clickCategories_subMenu();
	Assert.assertEquals(driver.getCurrentUrl(), cnfgr.getListURL());
    cp = new CategoriesPage(driver);
	cp.click_Add_New();
	Assert.assertEquals(driver.getCurrentUrl(), cnfgr.getCreateURL());
	cp.enter_Name(cnfgr.getNewTrm());
    cp.choose_Parent_Category();
    cp.save_Category();
    Assert.assertEquals(driver.getCurrentUrl(), cnfgr.getListURL());
    cp.check_Success_Msg();
    cp.enter_Srch_Name(cnfgr.getSrchTrm());
    cp.click_Srch_Btn();
    cp.match_FirstName(cnfgr.getSrchTrm());
    
}


}
