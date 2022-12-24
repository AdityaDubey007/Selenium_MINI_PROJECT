package com.cognizant;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

		/****
		Method Name : BrowserSetup
		Method Description : To set the driver
		EmpId  : 2111910
		Date of creation : 08/03/2022
		****/

public class BrowserChoice 
{
	public WebDriver WD;
	public Properties P = new Properties();
	public void BrowserSetup() throws IOException
	{
		//String path2="C:\\Users\\2111910\\eclipse-workspace\\WindowMultiple\\src\\main\\resources\\Data.properties";
		String path2= System.getProperty("user.dir")+"\\src\\main\\resources\\Data.properties";
		FileReader fr2=new FileReader(path2);
		P.load(fr2);
		
		if(P.getProperty("browserName").matches("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			//System.setProperty("webdriver.chrome.driver","C:\\Users\\2111910\\eclipse-workspace\\WindowMultiple\\DRIO\\chromedriver.exe");
			WD = new ChromeDriver();
		}
		if(P.getProperty("browserName").matches("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			//System.setProperty("webdriver.gecko.driver","C:\\Users\\2111910\\eclipse-workspace\\WindowMultiple\\DRIO\\geckodriver.exe");
			WD = new FirefoxDriver();
		}
		WD.manage().window().maximize();	
	}
}
