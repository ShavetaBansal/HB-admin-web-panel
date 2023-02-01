package cucumberOptions;

import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features",
                 glue="stepDefinitions",
               tags="@tagname",
		         publish = true,
                 monochrome=true,
                  plugin={"pretty","html:target/cucumber.html","json:target/cucumber.json",
		          "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		          "rerun:target/failed_scenarios.txt"})

public class TestNGTestRunner extends AbstractTestNGCucumberTests
{
    @Override
    @DataProvider(parallel=false)
	public Object[][] scenarios()
	{
		return super.scenarios();
	}

}
