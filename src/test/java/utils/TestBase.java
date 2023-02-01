package utils;

import java.io.FileInputStream;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestBase 
{
	public WebDriver driver; 
	public WebDriver WebDriverManager()  throws IOException
	{
       FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\global.properties");
		//  FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/global.properties");
      // FileInputStream fis= new FileInputStream(System.getProperty("/var/jenkins_home/workspace/hb_scale_web_test_6/src/test/resources/global.properties"));
      
		Properties prop= new Properties();
		prop.load(fis);
		String url=prop.getProperty("QAurl");
		String browser_properties=prop.getProperty("browser");  //coming from framework
		String browser_maven=System.getProperty("browser");     //from command line
		
		//result= testCondition? value1 : value2;   ternary operator in java
		String browser= browser_maven!=null? browser_maven : browser_properties;  
		
		if(driver==null)
		{
	       if(browser.equalsIgnoreCase("chrome"))
	       {
		    
	    	//   System.setProperty("webdriver.chrome.driver", System.getProperty("/var/jenkins_home/workspace/hb_scale_web_test_6/src/test/resources/chromedriver"));
		   System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\chromedriver.exe");
	    	//   System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/test/resources/chromedriver_linux64/chromedriver");
		      driver=new ChromeDriver(); 
//		      ChromeOptions options= new  ChromeOptions();
//		      options.addArguments("headless");
//		      options.addArguments("disable-gpu");
//		      driver=new ChromeDriver(options);
	
	//	  URL u= new URL("");
	  //  	   RemoteWebDriver driver=new RemoteWebDriver(u, cap);
	    	   
	    	/*   ChromeOptions chromeOptions = new ChromeOptions();
	     
	           chromeOptions.setCapability("browserName", "chrome");
	      
	           chromeOptions.setCapability("platformName", "LINUX");
	         
	           chromeOptions.addArguments("--headless");
	      
	         driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);
	           //URL to the hub running on your local system
	        */
	     
	       }
	       if(browser.equalsIgnoreCase("firefox"))
	       {
	    	// System.setProperty("webdriver.gecko.driver",  System.getProperty("/var/jenkins_home/workspace/hb_scale_web_test_6/src/test/resources/geckodriver.exe"));
	    	 System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\geckodriver.exe");
	    	  driver= new FirefoxDriver();
	       }
	       
	       if(browser.equalsIgnoreCase("edge"))
	       {
	    	  // System.setProperty("webdriver.edge.driver", System.getProperty("/var/jenkins_home/workspace/hb_scale_web_test_6/src/test/resources/msedgedriver.exe"));
	    	   System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\msedgedriver.exe");
	    	   driver = new EdgeDriver();
	       }
	       driver.manage().window().maximize();
	       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
	       driver.get(url);
		  
		

	}
		return driver;
	
	
}

}
