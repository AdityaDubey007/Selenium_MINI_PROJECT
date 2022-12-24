package com.cognizant;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MultipleWind extends BrowserChoice  
{
	 /****
	 Method Name : OpenUrl
	 Method Description : To launch the website link in a Browser
     EmpId  : 211910
     Date of creation : 08/03/2022
     ****/
	
	public void OpenUrl() throws IOException
	{
		String path1= System.getProperty("user.dir")+"\\src\\main\\resources\\Data.properties";
		//String path1= "C:\\Users\\2111910\\eclipse-workspace\\WindowMultiple\\src\\main\\resources\\Data.properties";
	    FileReader FR1 = new FileReader(path1);
	    P.load(FR1);
		
		WD.get(P.getProperty("baseurl"));
		System.out.println("Rediff Website Homepage is Opened");
	}
	
	/****
	 Method Name : FIND
	 Method Description : To click on Create Account
	 					: To validate “Create Rediffmail account” webpage is opened.
	 					: To count the total number of links in “Create Rediffmail account” webpage
	 					: To click on terms and conditions link
	 					: To validate child window “Terms and Conditions” is opened.
		 				: To Switch to the child window
						: To Get the title of the child window
						: To validate the title of the child window with the expected title.
						: To close the child window
						: To Switch to the parent window 
     EmpId  : 2111910
     Date of creation : 08/03/2022
     ****/

	public void FIND() throws IOException, InterruptedException
	{
		String path1 = System.getProperty("user.dir")+"\\src\\main\\resources\\Data.properties";
		//String path1= "C:\\Users\\2111910\\eclipse-workspace\\WindowMultiple\\src\\main\\resources\\Data.properties";
	    FileReader FR1 = new FileReader(path1);
	    P.load(FR1);

		WebElement CreateAccountlink = WD.findElement(By.linkText(P.getProperty("locator1")));
		CreateAccountlink.click();
		
		if(WD.getTitle() != null && WD.getTitle().contains("Rediffmail Free Unlimited Storage"))
		{
			System.out.println("I clicked on Create Account link");
			System.out.println("Create Rediffmail account web page is opened");
			System.out.println("We are in Parent Window Create Rediffmail account AND Parent window title = "+ WD.getTitle());
		}
		else
		{
			System.out.println("“Create Rediffmail account web page could not open.");
		}
		
		WD.findElement(By.tagName("a"));
		List<WebElement> links = WD.findElements(By.tagName("a"));
		int count = links.size();
		System.out.println("Total number of links in Create Rediffmail account webpage = "+count);
		
		WD.findElement(By.linkText(P.getProperty("locator2"))).click();
		
		
		Set <String> set = WD.getWindowHandles();
	    Iterator<String> it = set.iterator();
	    String parentWindowId = it.next();
	    String childWindowId = it.next();

	    System.out.println("");
	    System.out.println("SET="+set);
	    
	    System.out.println("");
	    Thread.sleep(1000);
	    WD.switchTo().window(childWindowId);
	    if(WD.getTitle() != null && WD.getTitle().contains("Rediffmail: Terms and Conditions"))
		{
	    	System.out.println("I clicked on terms and conditions link");
			System.out.println("terms and conditions webpage is opened");
		    System.out.println("Now i switch in Child Window AND Child window title = "+ WD.getTitle());
		}
		else
		{
			System.out.println(" Terms and Conditions webpage could not open.");
		}
	    WD.close();
	    
	    
	    System.out.println("");
	    Thread.sleep(1000);
	    WD.switchTo().window(parentWindowId);
	    System.out.println("I closed the Child Window using close function AND Now ");
	    System.out.println("We are again in Parent Window AND Parent window title = "+ WD.getTitle());

	}
	
	 /****
	 Method Name : CloseBrowser
	 Method Description : To Close the Browser
     EmpId  : 211910
     Date of creation : 08/03/2022
     ****/
	
	public void CloseBrowser() 
	{
		WD.quit();
	}
}
