package pageObjects;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

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
    private By allMeasurement= By.xpath("//h6[normalize-space()='All Measurements']");
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
    private By Addressfield= By.xpath("//p[normalize-space()='Address Detail']");
    private By AddressIcon = By.xpath("//img[@alt='edit-green']");
    private By AddressAddIcon = By.xpath("//img[@alt='plus-green']");
    private By AddressLine1 = By.xpath("//label[normalize-space()='Address Line 1']");
    private By AddressLine2 = By.xpath("//label[normalize-space()='Address Line 2 (Optional)']");
    private By City =By.xpath("//label[normalize-space()='City']");
    private By Postalcode =By.xpath("//label[normalize-space()='Postal Code']");
    private By State =By.xpath("//label[normalize-space()='State']");
    private By Country =By.xpath("//label[normalize-space()='Country']");
    private By SubmitButton1 =By.xpath("//button[normalize-space()='Submit']");
    private By Cancel = By.xpath("//button[normalize-space()='Cancel']");
    private By ErrorAddressLine1 = By.xpath("//span[normalize-space()='Please enter address']");
    private By ErrorCity = By.xpath("//span[normalize-space()='Please enter city']");
    private By ErrorPostalCode = By.xpath("//span[normalize-space()='Please enter postal code']");
    private By ErrorState= By.xpath("//span[normalize-space()='Please enter state']");
    private By ErrorCountry = By.xpath("//span[normalize-space()='Please enter country']");
    private By AddressLine1TextBox =By.xpath("//input[@id='streetAddress1']");
    private By AddressLine2TextBox =By.xpath("//input[@id='streetAddress2']");
    private By CityTextBox =By.xpath("//input[@id='city']");
    private By PostalCodeTextBox =By.xpath("//input[@id='postalCode']");
    private By StateTextBox =By.xpath("//input[@id='state']");
    private By CountryTextBox =By.xpath("//input[@id='country']");
    private By Addressdetail= By.cssSelector("div[class='col-md-12'] p[class='location-detail__detail']");
    private By editOfProgramManage=By.xpath("(//button[contains(text(),'Edit')])[2]");
    private By startingWeightInputEditPM=By.xpath("//input[@name='startingWeight']");
    private By goalWeightInputEditPM=By.xpath(" //input[@name='goalWeight']");
    private By submitEditPM=By.xpath("//button[normalize-space()='Submit']");
    private By errorStartingWeightPM=By.xpath("//span[normalize-space()='Please enter starting weight']");
    private By errorGoalWeightPM=By.xpath("//span[normalize-space()='Please enter goal weight']");
    private By radioGrowthlossPM=By.xpath("//label[normalize-space()='Growth']");
    private By weightdata= By.xpath("//p[normalize-space()='Weight']");
    private By HeartRatedata= By.xpath("//p[normalize-space()='Heart Rate']");
    private By BMItdata= By.xpath("//p[normalize-space()='BMI']");
    private By BodyFatdata= By.xpath("//p[normalize-space()='Body Fat']");
    private By MuscleMassdata= By.xpath("//p[normalize-space()='Muscle Mass']");
    private By BodyWaterdata= By.xpath("//p[normalize-space()='Body Water']");
    private By VisceralFatdata= By.xpath("//p[normalize-space()='Visceral Fat']");
    private By BoneMassdata= By.xpath("//p[normalize-space()='Bone Mass']");
    private By BMRdata= By.xpath("//p[normalize-space()='BMR']");
    private By Proteindata= By.xpath("//p[normalize-space()='Protein']");
    private By SubcutaneousFatdata= By.xpath("//p[normalize-space()='Subcutaneous Fat']");
    private By FatLeveldata= By.xpath("//p[normalize-space()='Fat Level']");
    private By BodyTypedata= By.xpath("//p[normalize-space()='Body Type']");
    private By LeanBodyMassdata= By.xpath("//p[normalize-space()='Lean Body Mass']");
    private By StandardWeight= By.xpath("//p[normalize-space()='Standard Weight']");
    private By WeightInfoIcon = By.xpath("//body//div[@id='root']//div[@class='row']//div[@class='row']//div[1]//div[1]//div[1]//img[1]");
    private By HeartRateInfoIcon = By.xpath("(//img[@alt='info'])[2]");
    private By BMIInfoIcon = By.xpath("(//img[@alt='info'])[3]");
    private By BMRInfoIcon = By.xpath("(//img[@alt='info'])[4]");
    private By weightinfomessage = By.cssSelector("div[class='tooltip-inner'] p[class=' mb-0']");
    private By weightvalue= By.cssSelector("body > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(6) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > p:nth-child(2)");
    private By BodyFatValue= By.cssSelector("body > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(6) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > p:nth-child(2)");
    private By VisceralFatValue = By.cssSelector("body > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(6) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(7) > div:nth-child(1) > p:nth-child(2)");
    private By ProteinValue =By.cssSelector("body > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(6) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(10) > div:nth-child(1) > p:nth-child(2)");
    private By BodyTypeValue = By.cssSelector("body > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(6) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(13) > div:nth-child(1) > p:nth-child(2)");
    private By HeartRateValue = By.cssSelector("body > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(6) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > p:nth-child(2)");
    private By MuscleMassValue = By.cssSelector("body > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(6) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(5) > div:nth-child(1) > p:nth-child(2)");
    private By BoneMassValue = By.cssSelector("body > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(6) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(8) > div:nth-child(1) > p:nth-child(2)");
    private By SubcutanousFatValue= By.cssSelector("body > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(6) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(11) > div:nth-child(1) > p:nth-child(2)");
    private By  LeanBodyMassValue= By.cssSelector("body > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(6) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(14) > div:nth-child(1) > p:nth-child(2)");
    private By  BMIValue= By.cssSelector("body > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(6) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > p:nth-child(2)");
    private By BodyWaterValue= By.cssSelector("body > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(6) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(6) > div:nth-child(1) > p:nth-child(2)");
    private By BMRValue = By.cssSelector("body > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(6) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(9) > div:nth-child(1) > p:nth-child(2)");
    private By FatLeaveValue = By.cssSelector("body > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(6) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(12) > div:nth-child(1) > p:nth-child(2)");
    private By StandardWeightValue = By.cssSelector("body > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(6) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(15) > div:nth-child(1) > p:nth-child(2)");
    
    
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
 	  List.add(driver.findElement(allMeasurement).getText());
 	  
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
  	 List.add("All Measurements");
 	  
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
    
    public String verify_address_field()
    {
  String address=   driver.findElement(Addressfield).getText();
  return address;
    
    }
    
    
    public void clickOnAddressIcon()
    {
    	driver.findElement(AddressIcon).click();
    }
    
    
    public ArrayList<String> verifyActualAllLabelsOfAddressField()
    
    { ArrayList<String> List = new ArrayList<String>();
    List.add(driver.findElement(AddressLine1).getText());
    List.add(driver.findElement(AddressLine2).getText());
    List.add(driver.findElement(City).getText());
    List.add(driver.findElement(Postalcode).getText());
    List.add(driver.findElement(Country).getText());
    List.add(driver.findElement(State).getText());
    	return List;
   
    }
    
    public ArrayList<String> expectedAllLabelOfAddressField()
    { ArrayList<String> List = new ArrayList<String>();
    List.add("Address Line 1");
    List.add("Address Line 2 (Optional)");
    List.add("City");
    List.add("Postal Code");
    List.add("Country");
    List.add("State");
    return List;
    	
    }
    public void clickOnAddressAddIcon()
    {
    	driver.findElement(AddressAddIcon).click();
    }
    
    public void clickOnSubmitButtonOnAddressPopup() throws Exception
    {
    	driver.findElement(SubmitButton1).click();
    	Thread.sleep(3000);
    }
    
    public ArrayList<String> verifyActualErrorMessagesOfAddressField()
    {ArrayList<String> List = new ArrayList<String>();
    List.add(driver.findElement(ErrorAddressLine1).getText());
     List.add(driver.findElement(ErrorCity).getText());
    List.add(driver.findElement(ErrorPostalCode).getText());
    List.add(driver.findElement(ErrorState).getText());
    List.add(driver.findElement(ErrorCountry).getText());
    return List;
    	
    }
    public ArrayList<String> verifyExpectedErrorMessagesOfAddressField()
    {
    	ArrayList<String> List = new ArrayList<String>();
    	List.add("Please enter address");
    	List.add("Please enter city");
    	List.add("Please enter postal code");
    	List.add("Please enter state");
    	List.add("Please enter country");
    	return List;
    }
    
    public void enterAddressinAddressPopup()
    { driver.findElement(AddressLine1TextBox).sendKeys("vaishali Nagar");
    driver.findElement(AddressLine2TextBox).sendKeys("ghandhi path west");
    driver.findElement(CityTextBox).sendKeys("jaipur");
    driver.findElement(PostalCodeTextBox).sendKeys("302021");
    driver.findElement(StateTextBox).sendKeys("Rajasthan");
    driver.findElement(CountryTextBox).sendKeys("India");
 
    	
    }
    public void verifyAddressOnAddressDetailPage() throws Exception
    {
    	Thread.sleep(2000);
   String ActualAddress = 	driver.findElement(Addressdetail).getText();
   String ExpectedAddress = "vaishali Nagar, ghandhi path west, jaipur, Rajasthan, India, 302021" ;
   Assert.assertEquals(ActualAddress, ExpectedAddress);
    }
    
    public ArrayList<String> verifyActualMEasurementDataPoint()
    {ArrayList<String> List = new ArrayList<String>();
    	List.add(driver.findElement(weightdata).getText());
    	List.add(driver.findElement(HeartRatedata).getText());
    	List.add(driver.findElement(BMItdata).getText());
    	List.add(driver.findElement(BodyFatdata).getText());
    	List.add(driver.findElement(MuscleMassdata).getText());
    	List.add(driver.findElement(BodyWaterdata).getText());
    	List.add(driver.findElement(VisceralFatdata).getText());
    	List.add(driver.findElement(BoneMassdata).getText());
    	List.add(driver.findElement(BMRdata).getText());
    	List.add(driver.findElement(Proteindata).getText());
    	List.add(driver.findElement(SubcutaneousFatdata).getText());
    	List.add(driver.findElement(FatLeveldata).getText());
    	List.add(driver.findElement(BodyTypedata).getText());
    	List.add(driver.findElement(LeanBodyMassdata).getText());
    	List.add(driver.findElement(StandardWeight).getText());
    	
    	return List;
    }
    
    public ArrayList<String> verifyExpectedMeasurementDataPoint()
    {
    	ArrayList<String> List = new ArrayList<String>();
    	List.add("Weight");
    	List.add("Heart Rate");
    	List.add("BMI");
    	List.add("Body Fat");
    	List.add("Muscle Mass");
    	List.add("Body Water");
    	List.add("Visceral Fat");
    	List.add("Bone Mass");
    	List.add("BMR");
    	List.add("Protein");
    	List.add("Subcutaneous Fat");
    	List.add("Fat Level");
    	List.add("Body Type");
    	List.add("Lean Body Mass");
    	List.add("Standard Weight");
    	return List;
    	
    }
    public void scroll() throws InterruptedException
    {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,1500)", "");
	Thread.sleep(3000);
    	
    }
    
    public void clickWeightInfoIcon() throws Exception
    
    { 
    	WebElement ele = driver.findElement(WeightInfoIcon);
    	Actions action = new Actions(driver);
    	action.moveToElement(ele).perform();
    	Thread.sleep(3000);
    }
    
    
    public String verifyWeightinfoMessage()
    {
    String actual_Message =	driver.findElement(weightinfomessage).getText();
    return actual_Message;
    }
    
    
    public String ExpectedWeightInfoMessage()
    {
    	String Expected = "Body weight refers to the weight obtained by weighing yourself on a scale. Body weight is one of the important indicators to reflect people's health status.";
    	return Expected;
    }
    
    
    public void clickHeartRateInfoIcon() throws Exception
    {
    	WebElement ele = driver.findElement(HeartRateInfoIcon);
    	 Actions action = new Actions(driver);
    	 action.moveToElement(ele).perform();
    	 Thread.sleep(3000);


    }
    public String verifyHeartrateinfoMessage()
    {
    String actual_Message =	driver.findElement(weightinfomessage).getText();
    return actual_Message;
    }
    
    
    public String ExpectedHeartRateInfoMessage()
    {
    	String Expected = "Heart rate is the frequency of the heartbeat measured by the number of contractions of the heart per minute.";
    	return Expected;
    }
    
    
  
    
    public void clickBMIInfoIcon() throws Exception
    {
    	WebElement ele = driver.findElement(BMIInfoIcon);
   	 Actions action = new Actions(driver);
   	 action.moveToElement(ele).perform();
   	 Thread.sleep(3000);

    }
    public String verifyBMIinfoMessage()
    {
    	 String actual_Message =	driver.findElement(weightinfomessage).getText();
    	    return actual_Message;
    }
    
    public String ExpectedBMIInfoMessage()
    {
    	String Expected = "Body Mass Index (BMI) is a person’s weight in kilograms (or pounds) divided by the square of height in meters (or feet). A high BMI can indicate high body fatness. BMI screens for weight categories that may lead to health problems, but it does not diagnose the body fatness or health of an individual.";
    	return Expected;
    }
    
    public void clickBMRInfoIcon() throws Exception
    {
    	WebElement ele = driver.findElement(BMRInfoIcon);
      	 Actions action = new Actions(driver);
      	 action.moveToElement(ele).perform();
      	 Thread.sleep(3000);
    }
    public String verifyBMRinfoMessage()
    {
    	 String actual_Message =	driver.findElement(weightinfomessage).getText();
    	    return actual_Message;
    }
    
    public String ExpectedBMRInfoMessage()
    {
    	String Expected = "The basal metabolic rate (BMR) is defined as the energy expenditure at complete bodily rest. Basal metabolic rate is the number of calories your body needs to accomplish its most basic (basal) life-sustaining functions. Generally, it's the number of calories your body will burn at rest in a given day.";
    	return Expected;
    }
    
    


    public boolean verifyWeightValueInAllMeasurement()
    {String str = driver.findElement(weightvalue).getText();
    boolean result = false ;
	String str2 = str.replace(" ", "");
	
	for(int i=0; i<str2.length();i++)
    {
    	if((str2.contains("-"))||(((str2.contains("LB"))||(str2.contains("KG")))&&(Character.isDigit(str2.charAt(i)))))
    	{
    		result = true;
    		
    	}
    	else if ((str2.contains(" "))||(str2 == null)||(str2 == ""))
    	{
    		result = false;
    	}
    }return result;
    }
    
    
    
    public boolean verifyBodyFatValueInAllMeasurement()
    {
    	String str = driver.findElement(BodyFatValue).getText();
    	boolean result = false ;
    	String str2 = str.replace(" ", "");
    	for(int i=0; i<str2.length();i++)
    	{
    	if((str2.contains("-"))||((str2.contains("%"))&&(Character.isDigit(str2.charAt(i)))))
    	{
    		result = true;
    		
    	}
    	else if ((str2.contains(" "))||(str2 == null)||(str2 == ""))
    	{
    		result = false;
    	}
    	}
    	return result;
    
    
    
    
   }
    
    
    public boolean verifyVisceralFatValueInAllMeasurement()
    {
    	String str = driver.findElement(VisceralFatValue).getText();
    	boolean result = false ;
        String str2 = str.replace(" ", "");
        for(int i=0; i<str2.length();i++)
        {
        	if((str2.contains("-"))||((str2.contains("%"))&&(Character.isDigit(str2.charAt(i)))))
        	{
        		result = true;
        		
        	}
        	else if ((str2.contains(" "))||(str2 == null)||(str2 == ""))
        	{
        		result = false;
        	}
        }return result;
    }
    public boolean verifyProteinValueInAllMeasurement()
    {
    	String str = driver.findElement(ProteinValue).getText();
    	boolean result = false ;
        String str2 = str.replace(" ", "");
        for(int i=0; i<str2.length();i++)
        {
        	if((str2.contains("-"))||((str2.contains("%"))&&(Character.isDigit(str2.charAt(i)))))
        	{
        		result = true;
        		
        	}
        	else if ((str2.contains(" "))||(str2 == null)||(str2 == ""))
        	{
        		result = false;
        	}
        }return result;
    }
    public boolean verifyBodyTypeValueInAllMeasurement()
    {String str = driver.findElement(BodyTypeValue).getText();
	boolean result = false ;
	String str2 = str.replace(" ", "");
	for(int i=0; i<str2.length();i++)
    {
    	if((str2.contains("-"))||(str2.matches("^[a-zA-Z]*$")))
    	{
    		result = true;
    		
    	}
    	else if ((str2.contains(" "))||(str2 == null)||(str2 == ""))
    	{
    		result = false;
    	}
    }return result;
    }
    
    public boolean verifyHeartRateValueInAllMeasurement()
    {String str = driver.findElement(HeartRateValue).getText();
	boolean result = false ;
	String str2 = str.replace(" ", "");
	for(int i=0; i<str2.length();i++)
	{
    	if((str2.contains("-"))||(Character.isDigit(str2.charAt(i))))
    	{
    		result = true;
    		
    	}
    	else if ((str2.contains(" "))||(str2 == null)||(str2 == "")||(str2.matches("^[a-zA-Z]*$")))
    	{
    		result = false;
    	}
    }return result;
    }
    
    public boolean verifyMuscleMassValueInAllMeasurement()
    {String str = driver.findElement(MuscleMassValue).getText();
    boolean result = false ;
	String str2 = str.replace(" ", "");
	
	for(int i=0; i<str2.length();i++)
    {
    	if((str2.contains("-"))||(((str2.contains("LB"))||(str2.contains("KG")))&&(Character.isDigit(str2.charAt(i)))))
    	{
    		result = true;
    		
    	}
    	else if ((str2.contains(" "))||(str2 == null)||(str2 == ""))
    	{
    		result = false;
    	}
    }return result;
 	
    }
    public boolean verifyBoneMassValueInAllMeasurement()
    {
    	String str = driver.findElement(BoneMassValue).getText();
        boolean result = false ;
    	String str2 = str.replace(" ", "");
    	
    	for(int i=0; i<str2.length();i++)
        {
        	if((str2.contains("-"))||(((str2.contains("LB"))||(str2.contains("KG")))&&(Character.isDigit(str2.charAt(i)))))
        	{
        		result = true;
        		
        	}
        	else if ((str2.contains(" "))||(str2 == null)||(str2 == ""))
        	{
        		result = false;
        	}
        }return result;
     	
    }
    
    public boolean verifySubcutaneousFatValueInAllMeasurement()
    {
    	String str = driver.findElement(SubcutanousFatValue).getText();
    	boolean result = false ;
        String str2 = str.replace(" ", "");
        for(int i=0; i<str2.length();i++)
        {
        	if((str2.contains("-"))||((str2.contains("%"))&&(Character.isDigit(str2.charAt(i)))))
        	{
        		result = true;
        		
        	}
        	else if ((str2.contains(" "))||(str2 == null)||(str2 == ""))
        	{
        		result = false;
        	}
        }return result;
    }
    public boolean verifyBodyLeanMassValueInAllMeasurement()
    {String str = driver.findElement(LeanBodyMassValue).getText();
    boolean result = false ;
	String str2 = str.replace(" ", "");
	
	for(int i=0; i<str2.length();i++)
    {
    	if((str2.contains("-"))||(((str2.contains("LB"))||(str2.contains("KG")))&&(Character.isDigit(str2.charAt(i)))))
    	{
    		result = true;
    		
    	}
    	else if ((str2.contains(" "))||(str2 == null)||(str2 == ""))
    	{
    		result = false;
    	}
    }return result;
 	
    	
    }
    public boolean verifyBMIValueInAllMeasurement()
    {String str = driver.findElement(BMIValue).getText();
	boolean result = false ;
    String str2 = str.replace(" ", "");
    for(int i=0; i<str2.length();i++)
    {
    	if((str2.contains("-"))||(Character.isDigit(str2.charAt(i))))
    	{
    		result = true;
    		
    	}
    	else if ((str2.contains(" "))||(str2 == null)||(str2 == ""))
    	{
    		result = false;
    	}
    }return result;
    	
    }
    
    public boolean verifyBodyWaterValueInAllMeasurement()
    {String str = driver.findElement(BodyWaterValue).getText();
	boolean result = false ;
    String str2 = str.replace(" ", "");
    for(int i=0; i<str2.length();i++)
    {
    	if((str2.contains("-"))||((str2.contains("%"))&&(Character.isDigit(str2.charAt(i)))))
    	{
    		result = true;
    		
    	}
    	else if ((str2.contains(" "))||(str2 == null)||(str2 == ""))
    	{
    		result = false;
    	}
    }return result;
    	
    }
    public boolean verifyBMRValueInAllMeasurement()
    {
    	String str = driver.findElement(BMRValue).getText();
    	boolean result = false ;
        String str2 = str.replace(" ", "");
        for(int i=0; i<str2.length();i++)
        {
        	if((str2.contains("-"))||((str2.contains("Kcal"))&&(Character.isDigit(str2.charAt(i)))))
        	{
        		result = true;
        		
        	}
        	else if ((str2.contains(" "))||(str2 == null)||(str2 == ""))
        	{
        		result = false;
        	}
        }return result;
        	
    }
    
    public boolean verifyFatLevelValueInAllMeasurement()
    {String str = driver.findElement(FatLeaveValue).getText();
    boolean result = false ;
    String str2 = str.replace(" ", "");
    for(int i=0; i<str2.length();i++)
    {
    	if((str2.contains("-"))||((str2.contains("%"))&&(Character.isDigit(str2.charAt(i)))))
    	{
    		result = true;
    		
    	}
    	else if ((str2.contains(" "))||(str2 == null)||(str2 == ""))
    	{
    		result = false;
    	}
    }return result;
    
    	
    }
    public boolean verifyStandardWeightValueInAllMeasurement()
    {
    	String str = driver.findElement(StandardWeightValue).getText();
        boolean result = false ;
    	String str2 = str.replace(" ", "");
    	
    	for(int i=0; i<str2.length();i++)
        {
        	if((str2.contains("-"))||(((str2.contains("LB"))||(str2.contains("KG")))&&(Character.isDigit(str2.charAt(i)))))
        	{
        		result = true;
        		
        	}
        	else if ((str2.contains(" "))||(str2 == null)||(str2 == ""))
        	{
        		result = false;
        	}
        }return result;
    }
    
    
}
