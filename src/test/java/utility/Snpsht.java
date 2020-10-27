package utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Snpsht {

	
	
	
	public void Snpshot(WebDriver driver) {
		
		try {
		String path = "./src/test/resources/Clicks/ClickedAt"+getTime()+".png";	
		TakesScreenshot tss = (TakesScreenshot)driver;
		File src = tss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(path));
		} catch (IOException e) {
			e.getCause();
			e.getMessage();
			System.out.println("Snpsht Class");
		}
	}
	
	public String getTime()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss"); 
		Date curr = new Date();
		return(sdf.format(curr));
	}

}
