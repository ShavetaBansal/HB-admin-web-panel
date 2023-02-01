package stepDefinitions;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ForgotPasswordpage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class ForgotPassword 
{
	public WebDriver driver;
	TestContextSetup testContextSetup;
	PageObjectManager pageObjectManager;
	ForgotPasswordpage ForgotPasswordpage;
	public ForgotPassword(TestContextSetup testContextSetup)
	{
		this.testContextSetup=testContextSetup;
		this.ForgotPasswordpage=testContextSetup.pageObjectManager.getForgotPasswordpage();
	}
   

    @Given("^user clicks on forgot password link of login page$")
    public void user_clicks_on_forgot_password_link_of_login_page() throws Throwable {
    	ForgotPasswordpage.ClickOnForgotPasswordLink();
    }

    @Then("^forgot password page is opened$")
    public void forgot_password_page_is_opened() throws Throwable {
    	ForgotPasswordpage.validateForgotPasswordUrl();
    }

    @Given("^user clicks on browser back button of browser$")
    public void user_clicks_on_browser_back_button_of_browser() throws Throwable {
    	ForgotPasswordpage.clickOnBrowserBack();
    }

    @Then("^user navigated to login page$")
    public void user_navigated_to_login_page() throws Throwable {
    	String ForgotpasswordpageUrl=ForgotPasswordpage.validateForgotPasswordUrl();
    	Assert.assertNotEquals(ForgotpasswordpageUrl, "https://d3m9qt69oyomfa.cloudfront.net/#/request-reset-password-link");
    }
	

    @Given("^user enters unauthorized \"([^\"]*)\" email ID$")
    public void user_enters_unauthorized_something_email_id(String email) throws Throwable {
    	ForgotPasswordpage.enterEmailOnForgotPasswordPage(email);
    }

    
    @Then("^error message should be displayed correctly for unauthorized email$")
    public void error_message_should_be_displayed_correctly_for_unauthorized_email() throws Throwable {
    	String ErrorUnauthEmail=ForgotPasswordpage.getErrorUnauthorizedEmail();
    	Assert.assertEquals(ErrorUnauthEmail,"Hmmm, we could not find a record matching these details. Could you please update and try again?");
    }

    @And("^user clicks on Get Password Reset Link button$")
    public void user_clicks_on_get_password_reset_link_button() throws Throwable {
    	ForgotPasswordpage.clickOnGetPassResetLinkButton();
    }
	
    @Given("^user enters invalid \"([^\"]*)\" email ID$")
    public void user_enters_invalid_something_email_id(String email) throws Throwable {
    	ForgotPasswordpage.enterEmailOnForgotPasswordPage(email);
    }
    
    @Then("^error message should be displayed correctly for invalid email$")
    public void error_message_should_be_displayed_correctly_for_invalid_email() throws Throwable {
    	String ErrorInvalidEmail=ForgotPasswordpage.getErrorInvalidEmail();
    	Assert.assertEquals(ErrorInvalidEmail,"Please enter a valid email");
    }
    
    @Given("^user does not enter any \"([^\"]*)\" email ID$")
    public void user_does_not_enter_any_something_email_id(String email) throws Throwable {
    	ForgotPasswordpage.enterEmailOnForgotPasswordPage(email);
    }

    @Then("^error message should be displayed correctly for empty email field$")
    public void error_message_should_be_displayed_correctly_for_empty_email_field() throws Throwable {
    	String EmptyEmail=ForgotPasswordpage.getErrorNoEmail();
    	Assert.assertEquals(EmptyEmail,"Please enter an email address");
    }
	

    @Given("^user enters a valid and authorized \"([^\"]*)\" email ID$")
    public void user_enters_a_valid_and_authorized_something_email_id(String email) throws Throwable {
    	ForgotPasswordpage.enterEmailOnForgotPasswordPage(email);
    }
	
    @Then("^confirmation message displayed correctly$")
    public void confirmation_message_displayed_correctly() throws Throwable {
    	String Confirmation_message=ForgotPasswordpage.getConfirmationMessage();
    	Assert.assertEquals(Confirmation_message,"Reset password link has been sent! Please check your registered email.");
    }

   
    @Given("^user clicks on back button of forgot password page$")
    public void user_clicks_on_back_button_of_forgot_password_page() throws Throwable {
    	ForgotPasswordpage.clickOnBackButton();
    }
    @Then("^Validate page title and url of forgot password page$")
    public void validate_page_title_and_url_of_forgot_password_page() throws Throwable {
    	String url=ForgotPasswordpage.validateForgotPasswordUrl();
	      // String title=ForgotPasswordpage.validateForgotPasswordTitle();
	       Assert.assertEquals(url,"https://d3m9qt69oyomfa.cloudfront.net/#/request-reset-password-link");
	     //  Assert.assertEquals(title,"Clinimise - Forgot Password");
    }
    
    @Then("^Validate placeholder text, headings and text on buttons of forgot password page$")
    public void validate_placeholder_text_headings_and_text_on_buttons_of_forgot_password_page() throws Throwable {
    	 String PlaceholderEmail=ForgotPasswordpage.validateHeadingsTextPlaceholder().get(0);
	     String GetPassResetLinkButton=ForgotPasswordpage.validateHeadingsTextPlaceholder().get(1);
	     String BackButton=ForgotPasswordpage.validateHeadingsTextPlaceholder().get(2);
	        Assert.assertEquals(PlaceholderEmail,"Email");
	        Assert.assertEquals(GetPassResetLinkButton,"Get Password Reset Link");
		    Assert.assertEquals(BackButton,"Back To Login");
		    	ForgotPasswordpage.validateHeadingsTextPlaceholder().clear();
    }
}
