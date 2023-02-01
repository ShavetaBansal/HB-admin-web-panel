package pageObjects;

import org.openqa.selenium.WebDriver;

import stepDefinitions.PatientListing;

public class PageObjectManager 
{
    public  WebDriver driver;
	
	public Loginpage loginpage;
	public ForgotPasswordpage ForgotPasswordpage;
	public PatientListingpage patientListingpage;
	public PatientDetailspage patientDetailspage;
	public LogoutandUserpage logoutandUserpage;
	
	public PageObjectManager (WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	public Loginpage getLoginpage()
	{
		loginpage= new Loginpage(driver);
		return loginpage;
	}
	

	public ForgotPasswordpage getForgotPasswordpage()
	{
		ForgotPasswordpage= new ForgotPasswordpage(driver);
		return ForgotPasswordpage;
	}
	
	public PatientListingpage getPatientListingpage()
	{
		patientListingpage= new PatientListingpage(driver);
		return patientListingpage;
	}
	public PatientDetailspage getPatientDetailspage()
	{
		patientDetailspage= new PatientDetailspage(driver);
		return patientDetailspage;
	}
	
	
	public LogoutandUserpage getLogoutandUserpage()
	{
		logoutandUserpage= new LogoutandUserpage(driver);
		return logoutandUserpage;
	}

}
