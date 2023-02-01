package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.Loginpage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class Login 
{

	public WebDriver driver;
	TestContextSetup testContextSetup;
	PageObjectManager pageObjectManager;
	Loginpage loginpage;
	public Login(TestContextSetup testContextSetup)
	{
		this.testContextSetup=testContextSetup;
		this.loginpage=testContextSetup.pageObjectManager.getLoginpage();
	}


	@Given("user is on login page")
	public void user_is_on_login_page() throws InterruptedException, IOException {
		
	}
	
	@When("^user enters valid username (.+) and password (.+)$")
	public void user_enters_valid_username_and_password(String username, String password) throws Throwable
	{ 
		
		loginpage.enterLoginID(username);
		loginpage.enterPassword(password);	 
	}
	 
	 @And("clicks on login button")
	 public void clicks_on_login_button()  {
		 
			loginpage.clickOnLogin();
			
		}
		
		@Then("user logged in sucessfully")
		public void user_logged_in_sucessfully() throws InterruptedException {

			
			String url=loginpage.validateLoginWithUrl();
			Assert.assertEquals(url,"https://d3m9qt69oyomfa.cloudfront.net/#/patients");
		
		}
		
		 @When("^user enters invalid username (.+) and password (.+)$")
		    public void user_enters_invalid_username_and_password(String username, String password) throws Throwable {
			 loginpage.enterLoginID(username);
		     loginpage.enterPassword(password);
		     
		    }

		    @Then("^user not able to login$")
		    public void user_not_able_to_login() throws Throwable {
		    
		    	//String title=loginpage.validateLoginWithTitle();
				//Assert.assertEquals(title,"Clinimise - Login");
		    	String url=loginpage.validateLoginWithUrl();
				Assert.assertEquals(url,"https://d3m9qt69oyomfa.cloudfront.net/#/login");
		    }
		    
		
		 
		    @When("^user does not enter any username \"([^\"]*)\" and password \"([^\"]*)\"$")
		    public void user_does_not_enter_any_username_something_and_password_something(String email, String pass) throws Throwable {
		    	loginpage.enterLoginID(email);
			    loginpage.enterPassword(pass);
		    }

		    
		    
		    @When("^user enters only username \"([^\"]*)\" and does not enter any password \"([^\"]*)\"$")
		    public void user_enters_only_username_something_and_does_not_enter_any_password_something(String email, String pass) throws Throwable {
		    	loginpage.enterLoginID(email);
			    loginpage.enterPassword(pass);
			   
		    }
		    
		    @When("^user does not enter any username \"([^\"]*)\" and enters only password \"([^\"]*)\"$")
		    public void user_does_not_enter_any_username_something_and_enters_only_password_something(String email, String pass) throws Throwable {
		    	loginpage.enterLoginID(email);
			    loginpage.enterPassword(pass);
		    }
		    
		    
		    @Then("^error messages are displyed for email and password fields$")
		    public void error_messages_are_displyed_for_email_and_password_fields() throws Throwable {
		    	String Email_error=loginpage.errorMessageForEmptyFields().get(0);
		    	String pass_error=loginpage.errorMessageForEmptyFields().get(1);
		    	Assert.assertEquals(Email_error,"Please enter an email address");
		    	Assert.assertEquals(pass_error,"Please enter a password");
		    	loginpage.errorMessageForEmptyFields().clear();
		    }
		    
		    @When("^user enters invalid username \"([^\"]*)\"$")
		    public void user_enters_invalid_username_something(String email) throws Throwable {
		    	loginpage.enterLoginID(email);
		    }
		    

		    @Then("^error message is displayed for email field$")
		    public void error_message_is_displayed_for_email_field() throws Throwable {
		           String errorMessageForInvalidEmail=loginpage.errorMessageForInvalidEmail();
		           Assert.assertEquals(errorMessageForInvalidEmail,"Please enter a valid email");
		    }
		    
		    @Then("^error message is shown for invalid credentials$")
		    public void error_message_is_shown_for_invalid_credentials() throws Throwable {
		    	
		    	 String errorMessageForInvalidCredentials=loginpage.errorMessageForInvalidCredentials();
		           Assert.assertEquals(errorMessageForInvalidCredentials,"Hmmm, we could not find a record matching these details. Could you please update and try again?");
		    }
		    
		    @When("^user enters valid username \"([^\"]*)\" and invalid password \"([^\"]*)\"$")
		    public void user_enters_valid_username_something_and_invalid_password_something(String email, String pass) throws Throwable {
		    	loginpage.enterLoginID(email);
			    loginpage.enterPassword(pass);
		    }
		   
		
		    
		    @Then("^verify placeholder texts are visible correctly on email and password text fields$")
		    public void verify_placeholder_texts_are_visible_correctly_on_email_and_password_text_fields() throws Throwable {
		     String emailPlaceholder=loginpage.getPlaceholderText().get(0);
		     String passwordPlaceholder=loginpage.getPlaceholderText().get(1);
		        Assert.assertEquals(emailPlaceholder,"Email");
		    	Assert.assertEquals(passwordPlaceholder,"Password");
		    	loginpage.getPlaceholderText().clear();
		    }
		    
		    @And("^check if forgot password link is available$")
		    public void check_if_forgot_password_link_is_available() throws Throwable {
		       boolean ifForgotPasswordLinkPresent= loginpage.getForgotPasswordLink();
		       System.out.println(ifForgotPasswordLinkPresent);
		       Assert.assertTrue(ifForgotPasswordLinkPresent);
		    }
		    
		    @When("^user clicks on forgot password link$")
		    public void user_clicks_on_forgot_password_link() throws Throwable {
		        loginpage.ClickOnForgotPasswordLink();
		    }  
		    
		    @Then("^user redirected to forgot password page$")
		    public void user_redirected_to_forgot_password_page() throws Throwable {
		       String ForgotPasswordPageurl= loginpage.getForgotPasswordPageUrl();
		    	Assert.assertEquals(ForgotPasswordPageurl, "https://d3m9qt69oyomfa.cloudfront.net/#/request-reset-password-link");
		    }

		    @Then("^verify if url and page title are visible correctly on login page$")
		    public void verify_if_url_and_page_title_are_visible_correctly_on_login_page() throws Throwable {
		       String url=loginpage.validateLoginWithUrl();
		     //  String title=loginpage.validateLoginWithTitle();
		       Assert.assertEquals(url,"https://d3m9qt69oyomfa.cloudfront.net/#/login");
		      // Assert.assertEquals(title,"Clinimise - Login");
		    }
		    
		    @Then("^verify if text of login button on login page is correctly displayed$")
		    public void verify_if_text_of_login_button_on_login_page_is_correctly_displayed() throws Throwable {
		    	String ActulLoginText=loginpage.validateLoginButtonText();
		        String ExpectedLoginText="Submit";
		    	Assert.assertEquals(ActulLoginText, ExpectedLoginText);
		    }
		    
		    

}
