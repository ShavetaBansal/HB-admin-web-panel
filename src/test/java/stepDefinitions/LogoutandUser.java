package stepDefinitions;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LogoutandUserpage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class LogoutandUser 
{

	public WebDriver driver;
	TestContextSetup testContextSetup;
	PageObjectManager pageObjectManager;
	LogoutandUserpage logoutandUserpage;
	public LogoutandUser(TestContextSetup testContextSetup)
	{
		this.testContextSetup=testContextSetup;
		this.logoutandUserpage=testContextSetup.pageObjectManager.getLogoutandUserpage();
	}
	
	 @Then("^user clicks on user tab of side panel$")
	    public void user_clicks_on_user_tab_of_side_panel() throws Throwable {
		 logoutandUserpage.clickOnUserTab();
	    }

	    @And("^user page opens successfully$")
	    public void user_page_opens_successfully() throws Throwable {
	      Assert.assertEquals(logoutandUserpage.validateUserPageWithUrl(), "https://d3m9qt69oyomfa.cloudfront.net/#/users");
	    }
	

	    @When("^user clicks on logout button$")
	    public void user_clicks_on_logout_button() throws Throwable {
	    	logoutandUserpage.clickOnLogoutButton();
	    }

	    @Then("^user logged out of application successfully$")
	    public void user_logged_out_of_application_successfully() throws Throwable {
	    	String ActualURL=logoutandUserpage.validateUserPageWithUrl();
	    	String ExpectedURL="https://d3m9qt69oyomfa.cloudfront.net/#/login";
	    	Assert.assertEquals(ActualURL, ExpectedURL);
	    }

	    @And("^user clicks on Yes of alert box$")
	    public void user_clicks_on_yes_of_alert_box() throws Throwable {
	    	logoutandUserpage.clickOnLogoutYESButton();
	    }

	    @When("^user clicks on Add button$")
	    public void user_clicks_on_add_button() throws Throwable {
	    	logoutandUserpage.clickOnAddButton();
	    }

	    @Then("^user gets created sucessfully for (.+) registered$")
	    public void user_gets_created_sucessfully_for_registered(String email) throws Throwable {
	    	logoutandUserpage.EnterMailInSearchbar(email);
	    	Thread.sleep(4000);
	    	String Actual=logoutandUserpage.verifyUserAdded();
	    	String Expected=email;
	    	Assert.assertEquals(Actual, Expected);
	    }

	    @And("^enters valid (.+), (.+), (.+) in add user$")
	    public void enters_valid_in_add_user(String firstname, String lastname, String email) throws Throwable {
	    	logoutandUserpage.EnterFNLNandEmailAddUser(firstname, lastname, email);
	    }

	    @And("^select role of a user$")
	    public void select_role_of_a_user() throws Throwable {
	    	logoutandUserpage.selectRoleAdmin();
	    }

	    @And("^click on submit button to add user$")
	    public void click_on_submit_button_to_add_user() throws Throwable {
	    	logoutandUserpage.clickOnSubmitButtonAdd();
	    }
	    
	    @Then("^Error message should be displayed for already existing user$")
	    public void error_message_should_be_displayed_for_already_existing_user() throws Throwable {
	    	String Actual=logoutandUserpage.ExistingUserError();
	    	String Expected="User with the provided email address already exists in the system";
	    	Assert.assertEquals(Actual, Expected);
	    }
	    @Then("^Error messages should be displayed correctly for each field$")
	    public void error_messages_should_be_displayed_correctly_for_each_field() throws Throwable {
	    	ArrayList<String>Actual=logoutandUserpage.ActualErrorEmptyAddUser();
	    	ArrayList<String>Expected=logoutandUserpage.ExpectedErrorEmptyAddUser();
	    	Assert.assertEquals(Actual, Expected);
	    }
	    

	    @When("^user searches with valid email (.+) and clicks on edit button$")
	    public void user_searches_with_valid_email_and_clicks_on_edit_button(String email) throws Throwable {
	    	logoutandUserpage.EnterMailInSearchbar(email);
	    	logoutandUserpage.clickOnEditButton();
	    	
	    }

	    @Then("^user get updated succesfully with new (.+) email$")
	    public void user_get_updated_succesfully_with_new_email(String newemail) throws Throwable {
	    	logoutandUserpage.EnternewMailInSearchbar(newemail);
	    	String Actualmail=logoutandUserpage.verifyUserAdded();
	    	String Expectedmail=newemail;
	    	Assert.assertEquals(Actualmail, Expectedmail);
	    	
	    }

	    @And("^user saves the updated changes by entering valid new (.+) in email field of edit box$")
	    public void user_saves_the_updated_changes_by_entering_valid_new_in_email_field_of_edit_box(String newemail) throws Throwable {
	    	logoutandUserpage.enterNewEmailEditUser(newemail);
	    	logoutandUserpage.clickOnSubmitbuttonEditUser();
	    }
	    
	    @When("^user searches with valid (.+) and clicks on delete button$")
	    public void user_searches_with_valid_and_clicks_on_delete_button(String email) throws Throwable {
	    	logoutandUserpage.EnternewMailInSearchbar(email);
	    	Thread.sleep(4000);
	    	logoutandUserpage.clickOnDeleteButton();
	    	logoutandUserpage.clickOnYesOfDeleteButton();
	    }

	    @Then("^user gets deleted successfully having (.+) Email ID$")
	    public void user_gets_deleted_successfully_having_email_id(String email) throws Throwable {
	    	logoutandUserpage.EnterMailInSearchbar(email);
	    	String Actual=logoutandUserpage.errorDeletedSuccessfully();
	        String Expected="No record found";
	    	Assert.assertEquals(Actual, Expected);
	    }
	    
	    @Then("^validate the page title, heading and url of user page is as per requirement$")
	    public void validate_the_page_title_heading_and_url_of_user_page_is_as_per_requirement() throws Throwable {
	    	String ActualURL=logoutandUserpage.validateUserPageWithUrl();
	    	String ExpectedURL="https://d3m9qt69oyomfa.cloudfront.net/#/users";
	    	Assert.assertEquals(ActualURL, ExpectedURL);
	    	String Actualheading=logoutandUserpage.validateHeading();
	    	String Expectedheading="Users";
	       Assert.assertEquals(Actualheading, Expectedheading);		
	    }

	    @Then("^verify if all the columns are displayed as per requirement$")
	    public void verify_if_all_the_columns_are_displayed_as_per_requirement() throws Throwable {
	    	ArrayList<String>Actual=logoutandUserpage.ActualValidateColumnUser();
	    	ArrayList<String>Expected=logoutandUserpage.ExpectedValidateColumnUser();
	    	Assert.assertEquals(Actual, Expected);	
	    }
	}
	
	
	
	
	
	
	
	


