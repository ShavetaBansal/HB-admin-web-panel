package stepDefinitions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.PageObjectManager;
import pageObjects.PatientListingpage;
import utils.TestContextSetup;

public class PatientListing 
{

	public WebDriver driver;
	TestContextSetup testContextSetup;
	PageObjectManager pageObjectManager;
	PatientListingpage patientListingpage;
	
	public PatientListing(TestContextSetup testContextSetup)
	{
		this.testContextSetup=testContextSetup;
		this.patientListingpage=testContextSetup.pageObjectManager.getPatientListingpage();
	}
	
	   @When("^user enters valid userID \"([^\"]*)\" and password \"([^\"]*)\"$")
	    public void user_enters_valid_userid_something_and_password_something(String Username, String password) throws Throwable {
		   patientListingpage.enterLoginID(Username);
		   patientListingpage.enterPassword(password);
		   
	    } 
	   
	 @And("^user landed to patient listing page successfully$")
	    public void user_landed_to_patient_listing_page_successfully() throws Throwable {
		 String ActualUrl=patientListingpage.validatePatientListPageWithUrl();
		    String ExpectedUrl="https://d3m9qt69oyomfa.cloudfront.net/#/patients";
		       Assert.assertEquals(ActualUrl, ExpectedUrl, "patient listing page assertion");
	    }
	

	 @When("^logout button is displayed on patient listing page$")
	    public void logout_button_is_displayed_on_patient_listing_page() throws Throwable {
		 boolean Actual=patientListingpage.validateLogoutButton();
		 Assert.assertTrue(Actual);
		 
	    }



	    @Then("^search bar is displayed and working properly$")
	    public void search_bar_is_displayed_and_working_properly() throws Throwable {
	    	 boolean Actual=patientListingpage.validateSearchbarVisiblity();
			 Assert.assertTrue(Actual);
	    }
	    

	    @And("^the placeholder text of search bar is as per requirement$")
	    public void the_placeholder_text_of_search_bar_is_as_per_requirement() throws Throwable {
	    	String Actualplaceholder=patientListingpage.validateSearchbarPlaceholder();
		    String ExpectedPlaceholder="Search";
		       Assert.assertEquals(Actualplaceholder, ExpectedPlaceholder);
	    	
	    }

	
	    @Then("^Check box is displayed to view data based on pending delete request$")
	    public void check_box_is_displayed_to_view_data_based_on_pending_delete_request() throws Throwable {
	    	 boolean Actual=patientListingpage.validateCheckboxVisiblity();
			 Assert.assertTrue(Actual);
	    }
	
	    @And("^the label of the checkbox is as per requirement$")
	    public void the_label_of_the_checkbox_is_as_per_requirement() throws Throwable {
	    	String ActualLabel=patientListingpage.validateCheckboxLabel();
		    String ExpectedLabel="View patients with pending delete request";
		       Assert.assertEquals(ActualLabel, ExpectedLabel);
	    }
	
	    @Then("^checkbox is not selected by default when user logged in and landed on patient listing page$")
	    public void checkbox_is_not_selected_by_default_when_user_logged_in_and_landed_on_patient_listing_page() throws Throwable {
	    	boolean checkboxDisabled=patientListingpage.validateIfCheckboxSelected();
			 Assert.assertFalse(checkboxDisabled);
	    }
	   
	

	    @Then("^all of the columns and their names should be displayed correctly$")
	    public void all_of_the_columns_and_their_names_should_be_displayed_correctly() throws Throwable {
	      ArrayList<String>	ActualList =patientListingpage.columnNames();
	      ArrayList<String> ExpectedList=patientListingpage.ExpectedColumnNames();
	      Assert.assertEquals(ActualList, ExpectedList);
	    }
	
	    @Then("^patient count is displayed correctly in patient listing$")
	    public void patient_count_is_displayed_correctly_in_patient_listing() throws Throwable {
	    	int ActualCount=patientListingpage.patientCount();
	    	int ExpectdCount=patientListingpage.ExpectedPatientCount();
	    	Assert.assertEquals(ActualCount, ExpectdCount);
	    }
	    
	    @When("^user clicks on ID column Heading$")
	    public void user_clicks_on_id_column_heading() throws Throwable {
	    	patientListingpage.clickOnIDColumnHeading();
	    }

	    @Then("^column gets sorted based on ID succesfully$")
	    public void column_gets_sorted_based_on_id_succesfully() throws Throwable {
	      List<String>originalList=patientListingpage.ActulSortingColumnID();
	      List<String>ExpectedList=patientListingpage.ExpectedSortingColumnID();
	      Assert.assertTrue(originalList.equals(ExpectedList));
	    }
	    
	   

	    @When("^user Enters valid input email (.+) in search bar$")
	    public void user_enters_valid_input_email_in_search_bar(String email) throws Throwable {
	    	patientListingpage.enterValidSearchEmail(email);
	    }

	    @Then("^result should be displayed correctly in the datatable for valid email (.+)$")
	    public void result_should_be_displayed_correctly_in_the_datatable_for_valid_email(String email) throws Throwable {
	    	patientListingpage.validateSearchResultforEmail(email);
	    }
	    @When("^user Enters valid input patient name (.+) in search bar$")
	    public void user_enters_valid_input_patient_name_in_search_bar(String name) throws Throwable {
	    	patientListingpage.enterValidSearchName(name);
	    }

	    @Then("^result should be displayed correctly in the datatable for valid patient name (.+)$")
	    public void result_should_be_displayed_correctly_in_the_datatable_for_valid_patient_name(String name) throws Throwable {
	    	patientListingpage.validateSearchResultforName(name);
	    }
	    
	    @When("^user Enters invalid input (.+) in search bar$")
	    public void user_enters_invalid_input_in_search_bar(String invalidinput) throws Throwable {
	    	patientListingpage.enterInvalidSearchinput(invalidinput);
	    }

	    @Then("^error message should be displayed correctly in the datatable for invalid input$")
	    public void error_message_should_be_displayed_correctly_in_the_datatable_for_invalid_input() throws Throwable {
	       String ActualMessage=patientListingpage.errorMessageInvalidInput();
	       String ExpectedMessage="No record found";
	       Assert.assertEquals(ActualMessage, ExpectedMessage); 
	    }
	    
	    
	    @When("^user clicks on checkbox$")
	    public void user_clicks_on_checkbox() throws Throwable {
	    	patientListingpage.clickOnCheckbox();
	    }

	    @Then("^patients with delete pending request are correctly displayed$")
	    public void patients_with_delete_pending_request_are_correctly_displayed() throws Throwable {
	    	patientListingpage.ValidatePendingRequestName();
	    }
	    

	    @When("^user enters valid patient email (.+) whose request is to be accepted$")
	    public void user_enters_valid_patient_email_whose_request_is_to_be_accepted(String email) throws Throwable {
	    	patientListingpage.enterValidSearchEmail(email);
	    }
	    
	    @Then("^user clicks on accept delete request$")
	    public void user_clicks_on_accept_delete_request() throws Throwable {
	    	patientListingpage.aceeptPendingRequest();
	    }

	    @And("^patient with valid email (.+) will be deleted successfully$")
	    public void patient_with_valid_email_will_be_deleted_successfully(String email) throws Throwable {
	    	patientListingpage.enterValidSearchEmail(email);
	    	 String ActualMessage=patientListingpage.errorMessageInvalidInput();
		       String ExpectedMessage="No record found";
		       Assert.assertEquals(ActualMessage, ExpectedMessage); 
	    }


	    @When("^user enters valid patient email (.+) whose request is to be rejected$")
	    public void user_enters_valid_patient_email_whose_request_is_to_be_rejected(String email) throws Throwable {
	    	patientListingpage.enterValidSearchEmail(email);
	    }



	    @Then("^user clicks on rejects the delete request$")
	    public void user_clicks_on_rejects_the_delete_request() throws Throwable {
	    	patientListingpage.rejectPendingRequest();
	    }
	    
	    @But("^patient with valid email (.+) will not be deleted$")
	    public void patient_with_valid_email_will_not_be_deleted(String email) throws Throwable {
	    	patientListingpage.enterValidSearchEmail(email);
	    	String ActualUser=patientListingpage.validateIfUserNotDeleted();
	    	String ExpectedUser=email;
	    	Assert.assertEquals(ActualUser, ExpectedUser);
	    }

	    
	    @Then("^validate the page title, Heading and url of patient listing page$")
	    public void validate_the_page_title_heading_and_url_of_patient_listing_page() throws Throwable {
	    	Assert.assertEquals(patientListingpage.validatePatientListPageWithUrl(),"https://d3m9qt69oyomfa.cloudfront.net/#/patients" );
	    	Assert.assertEquals(patientListingpage.ValidateHeading(),"Patients" );
	    	
	    }
}
