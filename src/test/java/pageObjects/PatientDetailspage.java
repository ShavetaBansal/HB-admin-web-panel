package pageObjects;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import utils.GenericUtils;
import utils.TestContextSetup;

public class PatientDetailspage 
{
    public WebDriver driver;
	
    private By Searchbar=By.xpath("//input[@name='search']");
    private By datatableEmailID=By.xpath("//tbody//tr//td[2]");
    private By patientHeading=By.xpath("(//h6)[1]");
    private By backButton=By.xpath("//button[normalize-space()='Back']");
    private By patientDetails=By.xpath("//h6[normalize-space()='Patient Detail']");
    private By programManage=By.xpath("//h6[normalize-space()='Program Management']");
    private By weightRecords=By.xpath("//h6[normalize-space()='Weight Records']");
    private By heightRecords=By.xpath("//h6[normalize-space()='Height Records']");
    private By weightReminders=By.xpath("//h6[normalize-space()='Weight Reminders']");
    private By Name=By.xpath("//p[normalize-space()='Name']");
    private By email=By.xpath("//p[normalize-space()='Email']");
    private By DOB=By.xpath("//p[normalize-space()='Date Of Birth']");
    private By Gender=By.xpath("//p[normalize-space()='Gender']");
    private By ChangePassButton=By.xpath("//button[normalize-space()='Change Password']");
    private By EditButtonPatientDetail=By.xpath("//body//div//button[2]");
    private By SubmitChangePass=By.xpath("//button[normalize-space()='Submit']");
    private By CancelChangePass=By.xpath("//button[normalize-space()='Cancel']");
    private By NewPassField=By.cssSelector("input[placeholder='New password']");
    private By ConfirmPassField=By.cssSelector("input[placeholder='Confirm password']");
    private By ErrorNewPassEmpty=By.xpath("//body//div[contains(@role,'dialog')]//div//div//div//div//div[1]//div[1]//span[1]");
    private By ErrorConfirmPassEmpty=By.xpath("//body//div[contains(@role,'dialog')]//div//div//div//div//div[1]//div[1]//span[1]");
    private By ErrorInvaidNewPass=By.xpath("//div[contains(@role,'dialog')]//div[contains(@class,'row')]//div[1]//div[1]//span[1]");
    private By ErrorMatchPass=By.xpath("//span[normalize-space()='Password and Confirm Password must be a match']");
    private By EditFNPatientDetailsLabel=By.xpath("//label[normalize-space()='First Name']");
    private By EditLNPatientDetailsLabel=By.xpath("//label[normalize-space()='Last Name']");
    private By EditDOBPatientDetailsLabel=By.xpath("//label[normalize-space()='Date Of Birth']");
    private By EditGenderPatientDetailsLabel=By.xpath("//label[normalize-space()='Gender']");
    private By EditFNPatientDetailsField=By.xpath("//input[@name='firstName']");
    private By EditLNPatientDetailsField=By.xpath("//input[contains(@name,'lastName')]");
    private By EditDOBPatientDetailsField=By.xpath("//input[@name='dateOfBirth']");
    private By EditGenderPatientDetailsField=By.xpath("//body/div[contains(@role,'dialog')]/div/div/div/form/div/div[3]/div[1]/div[1]/div[1]");
    private By EditSubmitButtonPatientDetails=By.xpath("//button[normalize-space()='Submit']");
    private By EditCancelButtonPatientDetails=By.xpath("//button[normalize-space()='Cancel']");
    private By ErrorFNEditPatientDetails=By.xpath("//span[normalize-space()='Please enter first name']");
    private By ErrorLNEditPatientDetails=By.xpath("//span[normalize-space()='Please enter last name']");
    private By ErrorDOBEditPatientDetails=By.xpath("//span[normalize-space()='Please select a valid date of birth']");
    
    private By editOfProgramManage=By.xpath("(//button[contains(text(),'Edit')])[2]");
    private By startingWeightInputEditPM=By.xpath("//input[@name='startingWeight']");
    private By goalWeightInputEditPM=By.xpath(" //input[@name='goalWeight']");
    private By submitEditPM=By.xpath("//button[normalize-space()='Submit']");
    private By errorStartingWeightPM=By.xpath("//span[normalize-space()='Please enter starting weight']");
    private By errorGoalWeightPM=By.xpath("//span[normalize-space()='Please enter goal weight']");
    private By radioGrowthlossPM=By.xpath("//label[normalize-space()='Growth']");
    
    private By addRecordButton=By.xpath("(//button[text()='Add'])[1]");
    private By weightFieldAddRecord=By.xpath("//input[@placeholder='Weight']");
    private By SubmitButtonAddrecord=By.xpath("//button[normalize-space()='Submit']");
    private By ErrorAddWeightRecord=By.xpath("//span[normalize-space()='Please enter weight']");
    private By weighttext=By.cssSelector("body > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) "
    		                       + "  > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) "
    		                        + " > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > span:nth-child(1)");
    
    private By addRecordButtonHt=By.xpath("(//button[text()='Add'])[2]");
    private By heightFieldAddRecord=By.xpath("//input[@placeholder='Height']");
    private By SubmitButtonAddrecordheight=By.xpath("//button[normalize-space()='Submit']");
    private By ErrorAddheightRecord=By.xpath("//span[normalize-space()='Please enter height']");
    private By heighttext=By.cssSelector("body > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) "
    		                       + "> div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > div:nth-child(2) "
    		                       + "> div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > span:nth-child(1)");
    
    public void clickOnAddRecordButtonAddHt() throws InterruptedException
    {   Thread.sleep(3000);
    	
    	driver.findElement(addRecordButtonHt).click();
    }
    
    public void enterHtAddRecord(String height) throws InterruptedException
    {Thread.sleep(3000);
    	 driver.findElement(heightFieldAddRecord).sendKeys(height);
    }
    public String newHtrecord() throws InterruptedException
    {Thread.sleep(3000);
    	String weight=driver.findElement(heighttext).getText();
    	return weight;
    }
    public void clickOnSubmitofAddHtRecord() throws InterruptedException
    {   Thread.sleep(5000);
    	
    	driver.findElement(SubmitButtonAddrecordheight).click();
    }
    
    public String errorAddHtRecord() throws InterruptedException
    {Thread.sleep(3000);
    	String record=driver.findElement(ErrorAddheightRecord).getText();
    	return record;
    }
    
    
    
    
    
    public void clickOnAddRecordButtonAddWt() throws InterruptedException
    {   Thread.sleep(3000);
    	
    	driver.findElement(addRecordButton).click();
    }
    
    public void enterWeightAddRecord(String weight) throws InterruptedException
    {Thread.sleep(3000);
    	 driver.findElement(weightFieldAddRecord).sendKeys(weight);
    }
    public String newWeightrecord() throws InterruptedException
    {Thread.sleep(3000);
    	String weight=driver.findElement(weighttext).getText();
    	return weight;
    }
    public void clickOnSubmitofAddWtRecord() throws InterruptedException
    {   Thread.sleep(5000);
    	
    	driver.findElement(SubmitButtonAddrecord).click();
    }
    
    public String errorAddwtRecord() throws InterruptedException
    {Thread.sleep(3000);
    	String record=driver.findElement(ErrorAddWeightRecord).getText();
    	return record;
    }
    
    public ArrayList<String> ActualNewStartGoalWtPM() throws InterruptedException
    {Thread.sleep(3000);
  	  ArrayList<String> List = new ArrayList<String>();
  	  List.add(driver.findElement(By.xpath("(//p[@class='location-detail__detail'])[6]")).getText());Thread.sleep(3000);
  	  List.add(driver.findElement(By.xpath("(//p[@class='location-detail__detail'])[7]")).getText());Thread.sleep(3000);
  	List.add(driver.findElement(By.xpath("(//p[@class='location-detail__detail'])[5]")).getText());Thread.sleep(3000);
  	 
 	  
  	  return List;
    }
    public ArrayList<String> ExpectedNewStartGoalWtPM(String StartWt, String Gaolwt)
    {
  	  ArrayList<String> List = new ArrayList<String>();
  	 List.add(StartWt+" KG");
  	 List.add(Gaolwt+" KG");
  	List.add("Growth");
  	 
  	  return List;
    }
    public void enterStartingWeightPM(String startweight) throws InterruptedException
    {      Thread.sleep(2000);

    	 driver.findElement(startingWeightInputEditPM).sendKeys(Keys.chord(Keys.CONTROL, "a"));
    	 driver.findElement(startingWeightInputEditPM).sendKeys(Keys.DELETE);
    	 Thread.sleep(2000);
    	 driver.findElement(startingWeightInputEditPM).sendKeys(startweight);
    	
    }
    public void enterGoalWeightPM(String Goalweight) throws InterruptedException
    {   Thread.sleep(2000);
   
    	 driver.findElement(goalWeightInputEditPM).sendKeys(Keys.chord(Keys.CONTROL, "a"));
    	 driver.findElement(goalWeightInputEditPM).sendKeys(Keys.DELETE);
    	 Thread.sleep(2000);
    	 driver.findElement(goalWeightInputEditPM).sendKeys(Goalweight);
    	
    }
    public void selectRadioGrowthPM() throws InterruptedException
    {   Thread.sleep(2000);
    	driver.findElement(radioGrowthlossPM).click();
    }
    public void clickOnEditOfPM() throws InterruptedException
    {    Thread.sleep(2000);
    	driver.findElement(editOfProgramManage).click();
    }
    public void clickOnSubmitofEditPM() throws InterruptedException
    {   Thread.sleep(10000);
    	
    	driver.findElement(submitEditPM).click();
    }
    public void enterEmptyStartingWeightPM() throws InterruptedException
    {      Thread.sleep(2000);

    	 driver.findElement(startingWeightInputEditPM).sendKeys(Keys.chord(Keys.CONTROL, "a"));
    	 driver.findElement(startingWeightInputEditPM).sendKeys(Keys.DELETE);
    	
    }
    public void enterEmptyGoalWeightPM() throws InterruptedException
    {   Thread.sleep(2000);
   
    	 driver.findElement(goalWeightInputEditPM).sendKeys(Keys.chord(Keys.CONTROL, "a"));
    	 driver.findElement(goalWeightInputEditPM).sendKeys(Keys.DELETE);
    	
    }
    public ArrayList<String> ActualErrorEmptyStartGoalWtPM()
    {
  	  ArrayList<String> List = new ArrayList<String>();
  	  List.add(driver.findElement(errorStartingWeightPM).getText());
  	  List.add(driver.findElement(errorGoalWeightPM).getText());
  	 
 	  
  	  return List;
    }
    public ArrayList<String> ExpectedErrorEmptyStartGoalWtPM()
    {
  	  ArrayList<String> List = new ArrayList<String>();
  	 List.add("Please enter starting weight");
  	 List.add("Please enter goal weight");
  	 
  	  return List;
    }
    

    public PatientDetailspage(WebDriver driver)
    {
  	  this.driver=driver;
    }
    public void enterValidSearchEmail(String Email) throws InterruptedException
     {                 
    	            driver.findElement(Searchbar).click();
    	          
    	            
                    driver.findElement(Searchbar).sendKeys(Email);
                    driver.findElement(Searchbar).click();
                    Thread.sleep(3000); 
                    driver.findElement(Searchbar).sendKeys(Keys.ENTER);
                    Thread.sleep(2000);
                    driver.findElement(Searchbar).sendKeys(Keys.ARROW_RIGHT);         
                    driver.findElement(Searchbar).sendKeys(Keys.ARROW_RIGHT);
                    driver.findElement(Searchbar).sendKeys(Keys.BACK_SPACE);
                    Thread.sleep(4000);   
    }
    
    public void clickOnPatientEmail() throws InterruptedException
    {  Thread.sleep(3000);  
    	 driver.findElement(datatableEmailID).click();
    	 Thread.sleep(3000);  
    }
    
    public boolean validatePatientDetailsPage() throws InterruptedException
    {   Thread.sleep(4000);
    	boolean heading=driver.findElement(patientHeading).getText().contains(":");
    	return heading;
    }
    
    public void clickonUIBackButton() throws InterruptedException
    {
    	driver.findElement(backButton).click();
    	Thread.sleep(2000);
    }
    public void clickonBrowserBackButton() throws InterruptedException
    {
    	driver.navigate().back();
    	Thread.sleep(2000);
    }
    
    public ArrayList<String> ActualvalidatePatientDetailsFields()
    {
  	  ArrayList<String> List = new ArrayList<String>();
  	  List.add(driver.findElement(patientDetails).getText());
  	  List.add(driver.findElement(programManage).getText());
  	  List.add(driver.findElement(weightRecords).getText());
 	  List.add(driver.findElement(heightRecords).getText());
 	  List.add(driver.findElement(weightReminders).getText());
 	  
  	  return List;
    }
    
    public ArrayList<String> ExpectedvalidatePatientDetailsFields()
    {
  	  ArrayList<String> List = new ArrayList<String>();
  	 List.add("Patient Detail");
  	 List.add("Program Management");
  	 List.add("Weight Records");
 	 List.add("Height Records");
  	 List.add("Weight Reminders");
 	  
  	  return List;
    }
    
    
    public ArrayList<String> ActualvalidatePatientDetailField()
    {
  	  ArrayList<String> List = new ArrayList<String>();
  	  List.add(driver.findElement(Name).getText());
  	  List.add(driver.findElement(email).getText());
  	  List.add(driver.findElement(Gender).getText());
 	  List.add(driver.findElement(DOB).getText());
 	  List.add(driver.findElement(ChangePassButton).getText());
	  List.add(driver.findElement(EditButtonPatientDetail).getText());
 	
 	  
  	  return List;
    }
    
    public ArrayList<String> ExpectedvalidatePatientDetailField()
    {
  	  ArrayList<String> List = new ArrayList<String>();
  	 List.add("Name");
  	 List.add("Email");
  	 List.add("Gender");
 	 List.add("Date Of Birth");
 	 List.add("Change Password");
	 List.add("Edit");
  	  return List;
    }
    
    
    public void clickOnSubmitButtonChangePass()
    {
    	driver.findElement(SubmitChangePass).click();
    }
    public void clickOnChangePassButton()
    {
    	driver.findElement(ChangePassButton).click();
    }
    public ArrayList<String> ActualErrorMessagesChangePass()
    {
  	  ArrayList<String> List = new ArrayList<String>();
  	  List.add(driver.findElement(patientDetails).getText());
  	  List.add(driver.findElement(programManage).getText());
  	  List.add(driver.findElement(weightRecords).getText());
 	  List.add(driver.findElement(heightRecords).getText());
 	  List.add(driver.findElement(weightReminders).getText());
 	  
  	  return List;
    }
    
    public ArrayList<String> ExpectedErrorMessagesChangePass()
    {
  	  ArrayList<String> List = new ArrayList<String>();
  	 List.add("Patient Detail");
  	 List.add("Program Management");
  	 List.add("Weight Records");
 	 List.add("Height Records");
  	 List.add("Weight Reminders");
 	  
  	  return List;
    }
    public ArrayList<String> ActualErrorEmptyPass()
    {
  	  ArrayList<String> List = new ArrayList<String>();
  	  List.add(driver.findElement(ErrorNewPassEmpty).getText());
  	  List.add(driver.findElement(ErrorConfirmPassEmpty).getText());
  	 
 	  
  	  return List;
    }
    public ArrayList<String> ExpectedErrorEmptyPass()
    {
  	  ArrayList<String> List = new ArrayList<String>();
  	 List.add("Please enter a password");
  	 List.add("Please enter a password");
  	 
  	  return List;
    }
    
    public void EnterPassNewPass(String NewPass)
    { 
    	driver.findElement(NewPassField).sendKeys(NewPass);  	
    	
    }
    
    public void EnterPassConfPass(String ConfirmPass)
    {
    	driver.findElement(ConfirmPassField).sendKeys(ConfirmPass);
    }
    public ArrayList<String> ActualErrorInvalidPass()
    {
  	  ArrayList<String> List = new ArrayList<String>();
  	  List.add(driver.findElement(ErrorInvaidNewPass).getText());
  	
  	 
 	  
  	  return List;
    }
    public ArrayList<String> ExpectedErrorInvalidPass()
    {
  	  ArrayList<String> List = new ArrayList<String>();
  	 List.add("Password must be at least 8 characters long, starts with a capital letter, includes a number and has a special character");
  	 
  	  return List;
    }
    
    public String ErrorUnmatchingPass()
    {
    	String unmatchPassError=driver.findElement(ErrorMatchPass).getText();
    	return unmatchPassError;
    }
    
    public void clickOnCancelOfChangePass()
    {
    	driver.findElement(CancelChangePass).click();
    }
    
    public void clickOnEditOfpatientDetails()
    {
    	GenericUtils wait=new GenericUtils(driver);
    	wait.explicitWait(EditButtonPatientDetail);
    	driver.findElement(EditButtonPatientDetail).click();
    }
    public ArrayList<String> ActualEditPatientDetailsFields()
    {
  	  ArrayList<String> List = new ArrayList<String>();
  	  List.add(driver.findElement(EditFNPatientDetailsLabel).getText());
  	  List.add(driver.findElement(EditLNPatientDetailsLabel).getText());
  	  List.add(driver.findElement(EditDOBPatientDetailsLabel).getText());
 	  List.add(driver.findElement(EditGenderPatientDetailsLabel).getText());
 	  List.add(driver.findElement(EditSubmitButtonPatientDetails).getText());
	  List.add(driver.findElement(EditCancelButtonPatientDetails).getText());
 	  
  	  return List;
    }
    
    public ArrayList<String> ExpectedEditPatientDetailsFields()
    {
  	  ArrayList<String> List = new ArrayList<String>();
  	 List.add("First Name");
  	 List.add("Last Name");
  	 List.add("Date Of Birth");
 	 List.add("Gender");
  	 List.add("Submit");
  	 List.add("Cancel");
 	  
  	  return List;
    }
    
    public void ClearEditPatientDetailFields() throws InterruptedException
    { 
    	
    	driver.findElement(EditFNPatientDetailsField).sendKeys(Keys.chord(Keys.CONTROL, "a"));
	    driver.findElement(EditFNPatientDetailsField).sendKeys(Keys.DELETE);
    	Thread.sleep(2000);
	    driver.findElement(EditLNPatientDetailsField).sendKeys(Keys.chord(Keys.CONTROL, "a"));
	    driver.findElement(EditLNPatientDetailsField).sendKeys(Keys.DELETE);
    	
    	
    	
    	Thread.sleep(4000);
    }
    
    public void clickOnSubmitButtonOfEditPatientDetail() throws InterruptedException
    {	Thread.sleep(5000);
    	driver.findElement(EditSubmitButtonPatientDetails).click();
    	Thread.sleep(2000);
    }
    
    public ArrayList<String> ActualErrorEmptyFieldsEditPatientDetails()
    {
  	  ArrayList<String> List = new ArrayList<String>();
  	  List.add(driver.findElement(ErrorFNEditPatientDetails).getText());
  	  List.add(driver.findElement(ErrorLNEditPatientDetails).getText());
  
  	 
 	  
  	  return List;
    }
    public ArrayList<String> ExpectedErrorEmptyFieldsEditPatientDetails()
    {
  	  ArrayList<String> List = new ArrayList<String>();
  	 List.add("Please enter first name");
  	 List.add("Please enter last name");
  	
  	  return List;
    }
    
    public void enterFNEditPatientField(String FN)
    {
    	driver.findElement(EditFNPatientDetailsField).clear();
    	driver.findElement(EditFNPatientDetailsField).sendKeys(FN);
    }
   
    public void enterLNEditPatientField(String LN)
    {
    	driver.findElement(EditLNPatientDetailsField).clear();
    	driver.findElement(EditLNPatientDetailsField).sendKeys(LN);
    }
    public void selectDOBEditPatientField() throws InterruptedException
    {
    	String month="August 2002";
    	String day="20";
    	Thread.sleep(5000);
    	driver.findElement(EditDOBPatientDetailsField).click();
    	Thread.sleep(5000);
    	while(true)
    	{
    		String Text=driver.findElement(By.xpath("//tr[1]//th[2]")).getText();
    		if(Text.equals(month))
    		{
    			break;
    		}
    		else
    		{
    			driver.findElement(By.xpath("//span[contains(text(),'‹')]")).click();
    		}
    	}
    	driver.findElement(By.xpath("//tbody/tr/td[contains(text(),"+day+" )]")).click();
    	
 
    }
   
    public void selectGenderEditPatientField() throws InterruptedException
   {
	   driver.findElement(EditGenderPatientDetailsField).click();
	   Thread.sleep(3000);
	   driver.findElement(By.xpath("//div[normalize-space()='FEMALE']")).click();
	   
   }
    
    public ArrayList<String> ActualEditPatientDetailsFieldsInput() throws InterruptedException
    { Thread.sleep(3000);
  	  ArrayList<String> List = new ArrayList<String>();
  	  List.add(driver.findElement(By.xpath("(//p[@class='location-detail__detail'])[1]")).getText());
  	 List.add(driver.findElement(By.xpath("(//p[@class='location-detail__detail'])[3]")).getText());
  	 List.add(driver.findElement(By.xpath("(//p[@class='location-detail__detail'])[4]")).getText());
  	 
 	  
 	 
 	  
  	  return List;
    }
    
    public ArrayList<String> ExpectedEditPatientDetailsFieldsInput()
    {
  	  ArrayList<String> List = new ArrayList<String>();
  	 List.add("Anna kumari");
  	 List.add("FEMALE");
  	 List.add("20/08/2002");
 
 	  
  	  return List;
    }
    
    public ArrayList<String> ActualProgramFeilds()
    {
  	  ArrayList<String> List = new ArrayList<String>();
  	  List.add(driver.findElement(By.xpath("//p[normalize-space()='Program']")).getText());
  	List.add(driver.findElement(By.xpath("//p[normalize-space()='Starting Weight']")).getText());
  	List.add(driver.findElement(By.xpath("//p[normalize-space()='Goal Weight']")).getText());
  	List.add(driver.findElement(By.xpath("//p[normalize-space()='Weight Unit']")).getText());
  	List.add(driver.findElement(By.xpath("//p[normalize-space()='Height Unit']")).getText());
  
  	 
 	  
  	  return List;
    }
    public ArrayList<String> ExpectedProgramFields()
    {
  	  ArrayList<String> List = new ArrayList<String>();
  	 List.add("Program");
  	 List.add("Starting Weight");
  	List.add("Goal Weight");
  	 List.add("Weight Unit");
   	List.add("Height Unit");
  	 
  	  return List;
    }
    
    
    
    
    
    
}
