package stepDefinitions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utils.TestContextSetup;

public class Hooks 
{
TestContextSetup testContextSetup;
	
	public Hooks(TestContextSetup testContextSetup)
	{
		this.testContextSetup= testContextSetup;
	}
	
	

	@After //executes after each scenario of step definition file
	public void AfterScenario() throws IOException, InterruptedException
	{   
		/*WebDriver driver=testContextSetup.testBase.WebDriverManager();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));*/
		Thread.sleep(2000);
		testContextSetup.testBase.WebDriverManager().quit();
	}
	
	
	@AfterStep
	public void AddScreenshot(Scenario scenario) throws IOException
	{
		if(scenario.isFailed())
		{
			WebDriver driver=testContextSetup.testBase.WebDriverManager();
			File SourcePath=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			byte[] filecontent=FileUtils.readFileToByteArray(SourcePath);
			scenario.attach(filecontent, "image/png", "image");
		}
	}
	
	
}
