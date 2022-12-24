package mutipleWindow;

import java.io.IOException;
import com.cognizant.MultipleWind;

public class Test_Script {
	
	public static void main(String[] args) throws InterruptedException,IOException
	{
		MultipleWind obj = new MultipleWind();		
		
		obj.BrowserSetup();
		Thread.sleep(2000);
		
		obj.OpenUrl();
		Thread.sleep(2000);
	
		obj.FIND();
		Thread.sleep(2000);
		
		obj.CloseBrowser();
	}

}
