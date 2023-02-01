package pageObjects;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class LogoutandUserpage 
{
    public WebDriver driver;
    
   
    private By userTab=By.xpath("//span[normalize-space()='Users']");
    private By LogoutButton=By.xpath("//button[normalize-space()='Logout']");
    private By LogoutYes=By.xpath(" //button[normalize-space()='Yes']");
    private By LogoutNo=By.xpath(" //button[normalize-space()='No']");
    private By AddButton=By.xpath("//button[normalize-space()='Add']");
    private By FirstName=By.xpath("//input[contains(@placeholder,'First Name')]");
    private By LastName=By.xpath("//input[@placeholder='Last Name']");
    private By Email=By.xpath("//input[@placeholder='Email']");
    private By UserTypeAdd=By.xpath("//div[contains(@class,'ms-3__input-container css-hdlfl0')]");
    private By SubmitAdd=By.xpath("//button[contains(@type,'submit')]");
    private By CancelAdd=By.xpath("//button[normalize-space()='Cancel']");
    private By SearchBar=By.xpath("//input[contains(@placeholder,'Search')]");
    private By ErrorExisitingAddUser=By.xpath("//div[contains(@role,'alert')]");
    private By ErrorFNAddUser=By.xpath("//span[normalize-space()='Please enter first name']");
    private By ErrorLNAddUser=By.xpath("//span[normalize-space()='Please enter last name']");
    private By ErrorEmailAddUser=By.xpath("//span[normalize-space()='Please enter an email address']");
    private By EditButtonUserPage=By.xpath("//img[@alt='edit']");
    private By DeleteButtonUserPage=By.xpath("//img[@alt='deleteSmall']");
    private By EnterNewMailEditUserField=By.xpath("//input[@placeholder='Email']");
    private By submitButtonEditUser=By.xpath("//button[@type='submit']");
    private By clickOnYesDeleteButton=By.xpath("//button[normalize-space()='Yes']");
    private By errorDeletedAccount=By.xpath("//td[normalize-space()='No record found']");
    
    
    public LogoutandUserpage(WebDriver driver)
    {
  	  this.driver=driver;
    }
    
    public void clickOnUserTab()
    {
    	driver.findElement(userTab).click();
    }
    
    public String validateUserPageWithUrl()
    {
    	String Url=driver.getCurrentUrl();
    	return Url;
    }
    
    public void clickOnLogoutButton()
    {
    	driver.findElement(LogoutButton).click();
    }
    public void clickOnLogoutYESButton()
    {
    	driver.findElement(LogoutYes).click();
    }
    public void clickOnLogoutNOButton()
    {
    	driver.findElement(LogoutNo).click();
    }
    
    
    public void clickOnAddButton()
    {
    	driver.findElement(AddButton).click();
    }
    
    public void EnterFNLNandEmailAddUser(String FN, String LN, String mail)
    {
    	driver.findElement(FirstName).sendKeys(FN);
    	driver.findElement(LastName).sendKeys(LN);
    	driver.findElement(Email).sendKeys(mail);
    }
    
    public void selectRoleAdmin() throws InterruptedException
    {   Thread.sleep(4000);
    	driver.findElement(UserTypeAdd).click();
    	Thread.sleep(2000);
    
    	driver.findElement(By.xpath("//div[normalize-space()='Admin']")).click();
    	
    	Thread.sleep(2000);
    }
    
    public void clickOnSubmitButtonAdd()
    {
    	driver.findElement(SubmitAdd).click();
    }
    
    public void clickOnCancelButtonAdd()
    {
    	driver.findElement(CancelAdd).click();
    }
    
    public void EnterMailInSearchbar(String mail) throws InterruptedException
    {     Thread.sleep(3000);
        driver.findElement(SearchBar).clear();
    	driver.findElement(SearchBar).sendKeys(mail);
    	 driver.findElement(SearchBar).click();
         Thread.sleep(3000); 
         driver.findElement(SearchBar).sendKeys(Keys.ENTER);
         Thread.sleep(2000);
         driver.findElement(SearchBar).sendKeys(Keys.ARROW_RIGHT);         
         driver.findElement(SearchBar).sendKeys(Keys.ARROW_RIGHT);
         driver.findElement(SearchBar).sendKeys(Keys.ARROW_RIGHT);         
         driver.findElement(SearchBar).sendKeys(Keys.ARROW_RIGHT);
         driver.findElement(SearchBar).sendKeys(Keys.BACK_SPACE);
         Thread.sleep(4000);   
    	
    
    	Thread.sleep(4000);
    	
    }
    public void EnternewMailInSearchbar(String newemail) throws InterruptedException
    {     Thread.sleep(3000);
        driver.findElement(SearchBar).clear();
    	driver.findElement(SearchBar).sendKeys(newemail);
    	
    	 Thread.sleep(3000); 
         driver.findElement(SearchBar).sendKeys(Keys.ENTER);
         Thread.sleep(2000);
         driver.findElement(SearchBar).sendKeys(Keys.ARROW_RIGHT);         
         driver.findElement(SearchBar).sendKeys(Keys.ARROW_RIGHT);
         driver.findElement(SearchBar).sendKeys(Keys.BACK_SPACE);
         Thread.sleep(4000);   
    	Thread.sleep(4000);
    	
    }
    
    public String verifyUserAdded()
    {
    	String ActualMail=driver.findElement(By.xpath("//tbody/tr[1]/td[2]")).getText();
    	return ActualMail;
    }
    
    public String ExistingUserError()
    {
    	String ExistingUser=driver.findElement(ErrorExisitingAddUser).getText();
    	return ExistingUser;
    }
    
    
    public ArrayList<String> ActualErrorEmptyAddUser()
    {
  	  ArrayList<String> List = new ArrayList<String>();
  	  List.add(driver.findElement(ErrorFNAddUser).getText());
  	  List.add(driver.findElement(ErrorLNAddUser).getText());
  	  List.add(driver.findElement(ErrorEmailAddUser).getText());
  	 
 	  
  	  return List;
    }
    
    public ArrayList<String> ExpectedErrorEmptyAddUser()
    {
  	  ArrayList<String> List = new ArrayList<String>();
  	 List.add("Please enter first name");
  	 List.add("Please enter last name");
	 List.add("Please enter an email address");
  	 
  	  return List;
    }
    
    public void clickOnEditButton() throws InterruptedException
    {    Thread.sleep(3000);
    	driver.findElement(EditButtonUserPage).click();
    }
    
    public void clickOnDeleteButton() throws InterruptedException
    {   Thread.sleep(3000);
    	driver.findElement(DeleteButtonUserPage).click();
    }
    
    public void enterNewEmailEditUser(String Newmail)
    {
    	driver.findElement(EnterNewMailEditUserField).clear();
    	driver.findElement(EnterNewMailEditUserField).sendKeys(Newmail);;
    }
    
    public void clickOnSubmitbuttonEditUser() throws InterruptedException
    { Thread.sleep(2000);
    	driver.findElement(submitButtonEditUser).click();
    }
    
    public void clickOnYesOfDeleteButton() throws InterruptedException
    {Thread.sleep(2000);
        driver.findElement(clickOnYesDeleteButton).click();
        Thread.sleep(2000);
    }
    
    public String errorDeletedSuccessfully() throws InterruptedException
    {Thread.sleep(2000);
    	String errorDeleted=driver.findElement(errorDeletedAccount).getText();
    	return errorDeleted;
    }
    
    public String validateHeading()
    {
    	String s=driver.findElement(By.xpath("//h6[normalize-space()='Users']")).getText();
    	return s;
    }
    
    public ArrayList<String> ActualValidateColumnUser()
    {
  	  ArrayList<String> List = new ArrayList<String>();
  	  List.add(driver.findElement(By.xpath("//th[1]")).getText());
  	  List.add(driver.findElement(By.xpath("//th[2]")).getText());
  	  List.add(driver.findElement(By.xpath("//th[3]")).getText());
  	  return List;
    }
    
    public ArrayList<String> ExpectedValidateColumnUser()
    {
  	  ArrayList<String> List = new ArrayList<String>();
  	 List.add("Name");
  	 List.add("Email");
  	 List.add("User Type");
  	  return List;
    }
    
    
    
}
