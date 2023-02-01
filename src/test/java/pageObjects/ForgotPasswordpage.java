package pageObjects;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.GenericUtils;

public class ForgotPasswordpage 
{
	public WebDriver driver;
	GenericUtils GenericUtils;
	private By ForgotPassLink=By.partialLinkText("Forgot") ;
	private By GetPassResetLinkButton=By.xpath("//button[text()='Get Password Reset Link']");
	private By EmailInput=By.name("email");
	private By ErrorUnauthorizedEmail=By.xpath("//div[contains(text(),'Hmmm, we could not find a record matching')]");
	private By ErrorInvalidEmail=By.xpath("//span[normalize-space()='Please enter a valid email']");
	private By ErrorNoEmail=By.xpath("//span[normalize-space()='Please enter an email address']");
	private By ConfirmationMessage=By.xpath("//div[@role='alert']//div//div//div//div//span");
	private By BackButton=By.cssSelector("a[href='#/login']");
	private By PlaceholderEmail=By.name("email");

	
	
	
	public ForgotPasswordpage(WebDriver driver)
     {
   	       this.driver=driver;
   
     }

	public void ClickOnForgotPasswordLink() throws InterruptedException
    { Thread.sleep(2000);
  	  driver.findElement(ForgotPassLink).click();
    }
	
	public String validateForgotPasswordTitle() throws InterruptedException
    {  Thread.sleep(2000);
  	  String title=driver.getTitle();
  	  return title;
  	  
    }
	
	public String validateForgotPasswordUrl() throws InterruptedException
    {  Thread.sleep(2000);
  	  String url=driver.getCurrentUrl();
  	  return url;
  	  
    }
	
	public void clickOnBrowserBack() throws InterruptedException
	{Thread.sleep(2000);
		driver.navigate().back();
	}
	
	public void clickOnGetPassResetLinkButton()
	{
		driver.findElement(GetPassResetLinkButton).click();
	}
	
	public void enterEmailOnForgotPasswordPage(String email)
	{
		driver.findElement(EmailInput).sendKeys(email);
	}
	
	
	public String getErrorUnauthorizedEmail()
	{
         String ErrorUnauthEmail=driver.findElement(ErrorUnauthorizedEmail).getText();
		 return ErrorUnauthEmail;
	}
	public String getErrorInvalidEmail()
	{
         String ErrorInvalidmail=driver.findElement(ErrorInvalidEmail).getText();
		 return ErrorInvalidmail;
	}
	public String getErrorNoEmail()
	{
         String ErrorNomail=driver.findElement(ErrorNoEmail).getText();
		 return ErrorNomail;
	}
	
	
	public String getConfirmationMessage()
	{  GenericUtils GenericUtils=new GenericUtils(driver);
	     GenericUtils.explicitWait(ConfirmationMessage);
		 String Confirmation_toast=driver.findElement(ConfirmationMessage).getText();
	     System.out.println("message: --------------> "+Confirmation_toast);
	     return Confirmation_toast;
	}
	

	public void clickOnBackButton()
	{
		driver.findElement(BackButton).click();
	}
	
	   public ArrayList<String> validateHeadingsTextPlaceholder()
	      {    ArrayList<String> validate = new ArrayList<String>();
	      validate.add(driver.findElement(PlaceholderEmail).getAttribute("placeholder"));
	      validate.add(driver.findElement(GetPassResetLinkButton).getText());
	      validate.add(driver.findElement(BackButton).getText());
	      
		  return validate;
	    	  
	      }
}
