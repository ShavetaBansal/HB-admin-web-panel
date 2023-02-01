package stepDefinitions;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.PageObjectManager;
import pageObjects.PatientDetailspage;
import utils.TestContextSetup;

public class PatientDetails 
{

	public WebDriver driver;
	TestContextSetup testContextSetup;
	PageObjectManager pageObjectManager;
	PatientDetailspage patientDetailspage;
	public PatientDetails(TestContextSetup testContextSetup)
	{
		this.testContextSetup=testContextSetup;
		this.patientDetailspage=testContextSetup.pageObjectManager.getPatientDetailspage();
	}

	   @And("^user Enters valid input email \"([^\"]*)\" in search bar and clicks similar email in data table$")
	    public void user_enters_valid_input_email_something_in_search_bar_and_clicks_similar_email_in_data_table(String email) throws Throwable {
		
		   patientDetailspage.enterValidSearchEmail(email);
		   patientDetailspage.clickOnPatientEmail();
		  
	    }
	 
	 @Then("^user redirected to patient details page$")
	    public void user_redirected_to_patient_details_page() throws Throwable 
	 {
		
		 boolean heading= patientDetailspage.validatePatientDetailsPage();
		 Assert.assertTrue(heading);
	 }

	 @When("^user clicks on back button of browser$")
	    public void user_clicks_on_back_button_of_browser() throws Throwable {
		 patientDetailspage.clickonBrowserBackButton();
	    }
	  

	    @When("^user clicks on back button of UI$")
	    public void user_clicks_on_back_button_of_ui() throws Throwable {
	    	patientDetailspage.clickonUIBackButton();
	    }
	
	    @And("^Verify if all patient details field are available on the page$")
	    public void verify_if_all_patient_details_field_are_available_on_the_page() throws Throwable {
	    	ArrayList<String>Actual=patientDetailspage.ActualvalidatePatientDetailsFields();
	    	ArrayList<String>Expected=patientDetailspage.ExpectedvalidatePatientDetailsFields();
	    	Assert.assertEquals(Actual, Expected);	
	    }
	    
	    
	    @Then("^patient details section has fields name, email, gender and date of birth fields with 'change password' and 'edit' button$")
	    public void patient_details_section_has_fields_name_email_gender_and_date_of_birth_fields_with_change_password_and_edit_button() throws Throwable {
	    	ArrayList<String>Actual=patientDetailspage.ActualvalidatePatientDetailField();
	    	ArrayList<String>Expected=patientDetailspage.ExpectedvalidatePatientDetailField();
	    	Assert.assertEquals(Actual, Expected);	
	    }
	
	    @When("^user clicks on submit button without any input in password fields$")
	    public void user_clicks_on_submit_button_without_any_input_in_password_fields() throws Throwable {
	    	patientDetailspage.clickOnSubmitButtonChangePass();
	    }

	    @Then("^Error messages are displayed correctly$")
	    public void error_messages_are_displayed_correctly() throws Throwable {
	    	ArrayList<String>Actual=patientDetailspage.ActualErrorEmptyPass();
	    	ArrayList<String>Expected=patientDetailspage.ExpectedErrorEmptyPass();
	    	Assert.assertEquals(Actual, Expected);	
	    }

	    @And("^user clicks on change password button$")
	    public void user_clicks_on_change_password_button() throws Throwable {
	    	patientDetailspage.clickOnChangePassButton();
	    }
	    
	    @When("^user clicks on submit button with invalid input (.+) in password fields$")
	    public void user_clicks_on_submit_button_with_invalid_input_in_password_fields(String pass) throws Throwable {
	    	patientDetailspage.EnterPassNewPass(pass);
	    	patientDetailspage.EnterPassConfPass(pass);
	    	patientDetailspage.clickOnSubmitButtonChangePass();
	    }

	    @Then("^Error messages are displayed correctly for invalid input$")
	    public void error_messages_are_displayed_correctly_for_invalid_input() throws Throwable {
	    	ArrayList<String>Actual=patientDetailspage.ActualErrorInvalidPass();
	    	ArrayList<String>Expected=patientDetailspage.ExpectedErrorInvalidPass();
	    	Assert.assertEquals(Actual, Expected);	
	    }
	
	

	    @When("^user clicks on submit button with valid unmatching New Password (.+) and confirm password (.+) in respective password fields$")
	    public void user_clicks_on_submit_button_with_valid_unmatching_new_password_and_confirm_password_in_respective_password_fields(String newpassword, String confirmpassword) throws Throwable {
	    	patientDetailspage.EnterPassNewPass(newpassword);
	    	patientDetailspage.EnterPassConfPass(confirmpassword);
	    	patientDetailspage.clickOnSubmitButtonChangePass();
	    }

	    @Then("^Error messages are displayed correctly for valid unmatching input$")
	    public void error_messages_are_displayed_correctly_for_valid_unmatching_input() throws Throwable {
	    	
	    	Assert.assertEquals(patientDetailspage.ErrorUnmatchingPass(), "Password and Confirm Password must be a match");
	    }
	
	    @When("^user clicks on cancel button of change password$")
	    public void user_clicks_on_cancel_button_of_change_password() throws Throwable {
	    	patientDetailspage.clickOnCancelOfChangePass();
	    }
	
	    @When("^user click on edit of patient detail section$")
	    public void user_click_on_edit_of_patient_detail_section() throws Throwable {
	    	patientDetailspage.clickOnEditOfpatientDetails();
	    }

	    @Then("^verify if Firstname, Lastname, Gender, Date of birth fields with Submit and cancel button are displayed after clicking Edit button of change password$")
	    public void verify_if_firstname_lastname_gender_date_of_birth_fields_with_submit_and_cancel_button_are_displayed_after_clicking_edit_button_of_change_password() throws Throwable {
	    	ArrayList<String>Actual=patientDetailspage.ActualEditPatientDetailsFields();
	    	ArrayList<String>Expected=patientDetailspage.ExpectedEditPatientDetailsFields();
	    	Assert.assertEquals(Actual, Expected);	
	    }
	    
	    @Then("^Error messages are displayed correctly for edit patient details$")
	    public void error_messages_are_displayed_correctly_for_edit_patient_details() throws Throwable {
	    	ArrayList<String>Actual=patientDetailspage.ActualErrorEmptyFieldsEditPatientDetails();
	    	ArrayList<String>Expected=patientDetailspage.ExpectedErrorEmptyFieldsEditPatientDetails();
	    	Assert.assertEquals(Actual, Expected);	
	    }

	    @And("^Clears the First Name, Last Name and Date of Birth fields$")
	    public void clears_the_first_name_last_name_and_date_of_birth_fields() throws Throwable {
	    	patientDetailspage.ClearEditPatientDetailFields();
	    }

	    @And("^Clicks on submit buton of edit patient details$")
	    public void clicks_on_submit_buton_of_edit_patient_details() throws Throwable {
	    	patientDetailspage.clickOnSubmitButtonOfEditPatientDetail();
	    }
	    @When("^user enters valid first name (.+) of the patient$")
	    public void user_enters_valid_first_name_of_the_patient(String firstname) throws Throwable {
	    	patientDetailspage.enterFNEditPatientField(firstname);
	    }

	    @And("^user enters valid last name (.+) of the patient$")
	    public void user_enters_valid_last_name_of_the_patient(String lastname) throws Throwable {
	    	patientDetailspage.enterLNEditPatientField(lastname);
	    }

	    @And("^user selects gender of patient$")
	    public void user_selects_gender_of_patient() throws Throwable {
	    	patientDetailspage.selectGenderEditPatientField();
	    }

	    @And("^user selects Date of Birth of patient$")
	    public void user_selects_date_of_birth_of_patient() throws Throwable {
	    	patientDetailspage.selectDOBEditPatientField();
	    }
	    
	    @And("^changes are reflected in patient details section correctly$")
	    public void changes_are_reflected_in_patient_details_section_correctly() throws Throwable {
	    	ArrayList<String>Actual=patientDetailspage.ActualEditPatientDetailsFieldsInput();
	    	ArrayList<String>Expected=patientDetailspage.ExpectedEditPatientDetailsFieldsInput();
	    	Assert.assertEquals(Actual, Expected);	
	    }
	    @Then("^program management section contains program, Starting weight, Goal weight, weight unit and height unit with 'edit' button$")
	    public void program_management_section_contains_program_starting_weight_goal_weight_weight_unit_and_height_unit_with_edit_button() throws Throwable {
	    	ArrayList<String>Actual=patientDetailspage.ActualProgramFeilds();
	    	ArrayList<String>Expected=patientDetailspage.ExpectedProgramFields();
	    	Assert.assertEquals(Actual, Expected);	
	    }
	    
	    @When("^user click on edit program management section$")
	    public void user_click_on_edit_program_management_section() throws Throwable {
	    	patientDetailspage.clickOnEditOfPM();
	    }

	    @Then("^Error messages are displayed correctly for edit program management section$")
	    public void error_messages_are_displayed_correctly_for_edit_program_management_section() throws Throwable {
	    	ArrayList<String>Actual=patientDetailspage.ActualErrorEmptyStartGoalWtPM();
	    	ArrayList<String>Expected=patientDetailspage.ExpectedErrorEmptyStartGoalWtPM();
	    	Assert.assertEquals(Actual, Expected);
	    }

	    @And("^Clears the Starting weight and Goal weight fields$")
	    public void clears_the_starting_weight_and_goal_weight_fields() throws Throwable {
	    	patientDetailspage.enterEmptyStartingWeightPM();
	    	patientDetailspage.enterEmptyGoalWeightPM();
	    }

	    @And("^Clicks on submit buton of edit  program management section$")
	    public void clicks_on_submit_buton_of_edit_program_management_section() throws Throwable {
	    	patientDetailspage.clickOnSubmitofEditPM();
	    }
	    
	    @And("^selects the weight loss program$")
	    public void selects_the_weight_loss_program() throws Throwable {
	    	patientDetailspage.selectRadioGrowthPM();
	    }
	    
	    
	    @And("^enters new Starting weight (.+) and Goal Weight (.+)$")
	    public void enters_new_starting_weight_and_goal_weight(String startingweight, String goalweight) throws Throwable {
	    	patientDetailspage.enterStartingWeightPM(startingweight);
	    	patientDetailspage.enterGoalWeightPM(goalweight);
	    	
	    }
	    
	    @Then("^changes are reflected in program management section correctly with Starting weight (.+) and Goal Weight (.+)$")
	    public void changes_are_reflected_in_program_management_section_correctly_with_starting_weight_and_goal_weight(String startingweight, String goalweight) throws Throwable {
	    	ArrayList<String>Actual=patientDetailspage.ActualNewStartGoalWtPM();
	    	ArrayList<String>Expected=patientDetailspage.ExpectedNewStartGoalWtPM(startingweight,goalweight);
	    	Assert.assertEquals(Actual, Expected);
	    }
	   
	    @When("^user clicks on submit button of add weight record$")
	    public void user_clicks_on_submit_button_of_add_weight_record() throws Throwable {
	    	patientDetailspage.clickOnSubmitofAddWtRecord();
	    }

	    @Then("^error message for empty weight field correctly displayed$")
	    public void error_message_for_empty_weight_field_correctly_displayed() throws Throwable {
	    	Thread.sleep(4000);
	    	Assert.assertEquals(patientDetailspage.errorAddwtRecord(),"Please enter weight");
	    }

	    @And("^user clicks on add weight record$")
	    public void user_clicks_on_add_weight_record() throws Throwable {
	    	patientDetailspage.clickOnAddRecordButtonAddWt();
	    }
	    
	    @And("^user enters new weight (.+) in weight field$")
	    public void user_enters_new_weight_in_weight_field(String newweight) throws Throwable {
	    	patientDetailspage.enterWeightAddRecord( newweight);
	    }
	    

	    @Then("^record is displayed correctly with (.+) weight in weight record section$")
	    public void record_is_displayed_correctly_with_weight_in_weight_record_section(String newweight) throws Throwable {
	    	Thread.sleep(4000);
	    	String actual=patientDetailspage.newWeightrecord();
	            		   String Expected=newweight;
	            		   Assert.assertEquals(actual, Expected);
	    }

	    @When("^user clicks on submit button of add Height record$")
	    public void user_clicks_on_submit_button_of_add_height_record() throws Throwable {
	    	patientDetailspage.clickOnSubmitofAddHtRecord();
	    }

	    @Then("^error message for empty Height field correctly displayed$")
	    public void error_message_for_empty_height_field_correctly_displayed() throws Throwable {
	    	Thread.sleep(4000);
	    	Assert.assertEquals(patientDetailspage.errorAddHtRecord(),"Please enter height");
	    }

	    @And("^user clicks on add Height record$")
	    public void user_clicks_on_add_height_record() throws Throwable {
	    	patientDetailspage.clickOnAddRecordButtonAddHt();
	    }
	    
	    @And("^user enters new Height (.+) in Height field$")
	    public void user_enters_new_height_in_height_field(String newheight) throws Throwable {
	    	patientDetailspage.enterHtAddRecord(newheight);
	    }
	    
	    @Then("^record is displayed correctly with (.+) Height in Height record section$")
	    public void record_is_displayed_correctly_with_height_in_height_record_section(String newheight) throws Throwable {
	    	Thread.sleep(4000);
	    	String actual=patientDetailspage.newHtrecord();
  		   String Expected=newheight;
  		   Assert.assertEquals(actual, Expected);
	    }
	    
	    @Then("^validate url, page title and heading of patient details page$")
	    public void validate_url_page_title_and_heading_of_patient_details_page() throws Throwable {
	    	 boolean heading= patientDetailspage.validatePatientDetailsPage();
			 Assert.assertTrue(heading);
			 
	    }

	
}
