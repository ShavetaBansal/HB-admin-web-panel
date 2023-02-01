package pageObjects;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Loginpage 
{
	public WebDriver driver;
	
    private By email=By.xpath("//input[@name='email']");
    private By pass=By.xpath("//input[@name='password']");
    private By login=By.xpath("//button[@type='submit']");
    private By Error_email=By.xpath("//span[normalize-space()='Please enter an email address']");
    private By Error_pass=By.xpath("//span[normalize-space()='Please enter a password']");
    private By ErrorInvalidEmail=By.xpath("//span[text()='Please enter a valid email']");
    private By ErrorInvalidCredentials=By.xpath("//*[text()='Hmmm, we could not find a record matching these details. Could you please update and try again?']");
    private By EmailPlaceholder=By.xpath("//input[@name='email']");
    private By PasswordPlaceholder=By.xpath("//input[@name='password']");
    private By ForgotPassLink=By.partialLinkText("Forgot") ;
 
   
  
    
    public Loginpage(WebDriver driver)
     {
   	  this.driver=driver;
     }
     
     public void enterLoginID(String username)
     {
                     driver.findElement(email).sendKeys(username);
     }
     
     public void enterPassword(String password)
     {
                     driver.findElement(pass).sendKeys(password);
     }
     
     public void clickOnLogin()
     {
           driver.findElement(login).click();
     }
     
    
     public String validateLoginWithUrl() throws InterruptedException 
     {
           Thread.sleep(3000);
       System.out.println("Found this URL: "+driver.getCurrentUrl());   
       String url=driver.getCurrentUrl();
        return url;   
     }
     
     public String validateLoginWithTitle()
     {
   	  System.out.println("Found this Title: "+driver.getTitle());
   	  String title=driver.getTitle();
   	  return title;
   	  
     }
     
     public ArrayList<String> errorMessageForEmptyFields()
     {
   	  ArrayList<String> actual_messages = new ArrayList<String>();
   	  actual_messages.add(driver.findElement(Error_email).getText());
   	  actual_messages.add(driver.findElement(Error_pass).getText());
   	  return actual_messages;
     }
     
     public String errorMessageForInvalidEmail()
     {
   	 String errorMessageForInvalidEmail=driver.findElement(ErrorInvalidEmail).getText(); 
   	 return errorMessageForInvalidEmail;
     }
     
     public String errorMessageForInvalidCredentials()
     {
   	 String errorMessageForInvalidCredentials=driver.findElement(ErrorInvalidCredentials).getText();
   	 return errorMessageForInvalidCredentials;
     }
     
   

     
     public void getPlaceholderTextboolean()
     {
   	// boolean email_placeholder= driver.getPageSource().contains("Email *");
   	 
     }
     
     public ArrayList<String> getPlaceholderText()
     {
   	  ArrayList<String> PlaceholderText = new ArrayList<String>();
   	  PlaceholderText.add(driver.findElement(EmailPlaceholder).getAttribute("placeholder"));
   	  PlaceholderText.add(driver.findElement(PasswordPlaceholder).getAttribute("placeholder"));
   	  return PlaceholderText;
     }
     
     public boolean getForgotPasswordLink()
     {
   	    boolean ForgotPasswordLinkDisplayed=driver.findElement(ForgotPassLink).isDisplayed();
   	    return ForgotPasswordLinkDisplayed;
     }
     
     public void ClickOnForgotPasswordLink()
     {
   	  driver.findElement(ForgotPassLink).click();
     }
     
     public String getForgotPasswordPageTitle()
     {
   	 String ForgotPasswordPageTitle= driver.getTitle();
   	 return ForgotPasswordPageTitle;
     }
     
     public String getForgotPasswordPageUrl()
     {
   	 String ForgotPasswordPageUrl= driver.getCurrentUrl();
   	 return ForgotPasswordPageUrl;
     }
     
     public String validateLoginButtonText() 
     {
   	 String logintext= driver.findElement(login).getText();
   	 return logintext;
	  }
  
}
