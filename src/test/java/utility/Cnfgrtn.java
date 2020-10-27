package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Cnfgrtn {
	
	String path=null;
	Properties prop;

	public Cnfgrtn() {
		
		try {
			path = "./src/test/resources/Cnfgrtn/Cnfg.properties";
			FileInputStream fis = new FileInputStream(path);
			prop = new Properties();
			prop.load(fis);
			
		} catch (IOException e) {
			e.getCause();
			e.getMessage();
			System.out.println("Cnfgrtn");
		}
		
	}
	
	public String getURL()
	{
		return(prop.getProperty("baseurl"));
	}

	public String getUname()
	{
		return(prop.getProperty("username"));
	}
	
	public String getPsswrd()
	{
		return(prop.getProperty("psswrd"));
	}
	
	public String getNewTrm()
	{
		return(prop.getProperty("newtrm"));
	}
	
	public String getSrchTrm()
	{
		return(prop.getProperty("srchtrm"));
	}
	
	public String getAdminURL()
	{
		return(prop.getProperty("adminurl"));
	}
	
	public String getListURL()
	{
		return(prop.getProperty("listurl"));
	}
	
	public String getCreateURL()
	{
		return(prop.getProperty("createurl"));
	}
}
