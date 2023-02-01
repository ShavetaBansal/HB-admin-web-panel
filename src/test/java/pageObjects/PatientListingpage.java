package pageObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import utils.GenericUtils;

public class PatientListingpage 
{
public WebDriver driver;
public GenericUtils wait; 
public List<String> IDoriginalList;
public List<String> appIDoriginalList;
public List<String> NameoriginalList;

    private By email=By.xpath("//input[@name='email']");
    private By pass=By.xpath("//input[@name='password']");
    private By LogoutButton=By.xpath("//button[normalize-space()='Logout']");
    private By logoutYesButton=By.cssSelector("div[role='dialog'] button:nth-child(1)");
    private By Searchbar=By.xpath("//*[@name='search']");
    private By Checkbox=By.xpath("//label[@for='requestPending']");
    private By tableColumnNames=By.xpath("//table[@class='table']//thead//tr//th");
    private By activePage=By.xpath("//li[contains(@class, 'active') and contains(@class, 'pagination')]");
    private By ExpectedPatientCount=By.xpath("//span[@class='c-chip']");
    private By pagination=By.xpath("//ul[contains(@class, 'pagination')]//li");
    private By tableRows=By.xpath("//table[@class='table']//tbody//tr");
    private By IDcolumn=By.xpath("//th[normalize-space()='ID']");
    private By IDcolumnElements=By.xpath("//tbody/tr/td[1]");
    private By appIDcolumn=By.xpath("//th[normalize-space()='Scale App User Id']");
    private By appIDcolumnElements=By.xpath("//tbody/tr/td[2]");
    private By Namecolumn=By.xpath("//th[normalize-space()='Name']");
    private By NamecolumnElements=By.xpath("//tbody/tr/td[3]");
    private By ErrorMessageInvalidInput=By.xpath("//td[normalize-space()='No record found']");
    private By heading=By.xpath("//h6[normalize-space()='Patients']");
  
  
    public PatientListingpage(WebDriver driver)
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

    public String validatePatientListPageWithUrl() throws InterruptedException 
    {
          Thread.sleep(2000);
      System.out.println("Found this URL: "+driver.getCurrentUrl());   
      String url=driver.getCurrentUrl();
       return url;   
    }
    
    public boolean validateLogoutButton() throws InterruptedException 
    {
    	boolean ifLogoutButtonDiplayed= driver.findElement(LogoutButton).isDisplayed();
        return ifLogoutButtonDiplayed;
    }
    
    public void clickOnNOfLogoutAlert() throws InterruptedException
    {
    	  Thread.sleep(2000);
    	driver.findElement(logoutYesButton).click();
    	System.out.println("This is button: "+ driver.findElement(logoutYesButton).getText());
    	
    }
    
    public void clickOnLogoutButton()
    {
    	driver.findElement(LogoutButton).click();
    }
    
    public boolean validateSearchbarVisiblity()
    {
    	boolean ifSearchbarDiplayed= driver.findElement(Searchbar).isDisplayed();
        return ifSearchbarDiplayed;
    }
    public String validateSearchbarPlaceholder()
    {
    	String searchbarPlaceholder= driver.findElement(Searchbar).getAttribute("placeholder");
        return searchbarPlaceholder;
    }
   
    public boolean validateCheckboxVisiblity()
    {
    	boolean ifCheckboxDiplayed= driver.findElement(Checkbox).isDisplayed();
        return ifCheckboxDiplayed;
    }
    public String validateCheckboxLabel()
    {
    	String checkBoxLabel= driver.findElement(Checkbox).getText();
        return checkBoxLabel;
    }
    
    public boolean validateIfCheckboxSelected()
    {
    	boolean CheckboxDisabled=driver.findElement(Checkbox).isSelected();
    	return CheckboxDisabled;
    }
    
    public ArrayList<String> columnNames()
    {
    	List<WebElement> tableColumns=driver.findElements(tableColumnNames);
    	//ArrayList<String> ColumnNames= new ArrayList<String>();
    	ArrayList<String> ColumnNames=(ArrayList<String>) tableColumns.stream().map(s->s.getText()).collect(Collectors.toList());
    	
    	/*for(WebElement NameOfColumn:tableColumns)
    	{
    		ColumnNames.add(NameOfColumn.getText());	
    	}*/

    	return ColumnNames;
    }
    
    
    public ArrayList<String> ExpectedColumnNames()
    {
    	ArrayList<String> ExpectedColumns= new ArrayList<String>();
    	ExpectedColumns.add("ID");
    	ExpectedColumns.add("Scale App User Id");
    	ExpectedColumns.add("Name");
    	ExpectedColumns.add("Units");
    	ExpectedColumns.add("Start Weight");
    	ExpectedColumns.add("Goal Weight");
    	ExpectedColumns.add("Gender");
    	ExpectedColumns.add("Dob");
    	ExpectedColumns.add("Height");
    	ExpectedColumns.add("Reminders");
    	ExpectedColumns.add("Program");
    	ExpectedColumns.add("Start Date");
    	ExpectedColumns.add("Last Seen");
    	ExpectedColumns.add("Delete Request");
    	
		return ExpectedColumns;
    	
    }
    
    public void scrolling() throws InterruptedException
    {
    	JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(847, 907)");
        Thread.sleep(2200);
    }
    public int patientCount() throws InterruptedException 
    {  
        scrolling();
       List<WebElement> Pagination=driver.findElements(pagination);
       System.out.println(Pagination.size()-2);
        
       Thread.sleep(2200);
       int totalcount=0;
    	for(int p=1; p<=(Pagination.size()-2);p++)
    	{      
    		WebElement active_page=driver.findElement(activePage);
    		System.out.println("page number: "+active_page.getText());
    		scrolling();
    		active_page.click();
    		int rows= driver.findElements(tableRows).size();
    		totalcount=rows+totalcount;
    	    System.out.println(totalcount);
    		Thread.sleep(2200);
    		String pageNo=Integer.toString(p+1);
    		 if (p+1>=(Pagination.size()-1))
    		   {
    			  break;
    		   }
    		 scrolling();
    	    driver.findElement(By.xpath("//ul[@class='c-paginations c-pagination']//li[text()='"+pageNo+"']")).click();
    		Thread.sleep(2200);
    		}
	System.out.println(totalcount);
	return totalcount;
	
    }
    
    public int ExpectedPatientCount()
    {
    	int expectedcount=Integer.parseInt(driver.findElement(ExpectedPatientCount).getText());
    	
    	return expectedcount;
    }
    
    
    
    public void clickOnIDColumnHeading()
    {    GenericUtils GenericUtils=new GenericUtils(driver);
         GenericUtils.explicitWait(IDcolumn);
    	driver.findElement(IDcolumn).click();
    }
    
    
    public List<String> ActulSortingColumnID()
    {
    	List<WebElement> elementList=driver.findElements(IDcolumnElements);
    	 IDoriginalList=elementList.stream().map(s->s.getText()).collect(Collectors.toList());
    	return IDoriginalList;
    }
   
    public List<String> ExpectedSortingColumnID()
    {
    List<String> sortedList=IDoriginalList.stream().sorted().collect(Collectors.toList());
	return sortedList;
    }
    
    
    public void enterValidSearchEmail(String Email) throws InterruptedException
    {
                    driver.findElement(Searchbar).sendKeys(Email);
                    driver.findElement(Searchbar).sendKeys(Keys.ENTER);
                   for(int i=0;i<=1;i++)
                   {  driver.findElement(Searchbar).sendKeys(Keys.ARROW_RIGHT);}
                   driver.findElement(Searchbar).sendKeys(Keys.BACK_SPACE);
                    Thread.sleep(4000);
               
    }
    
    public void validateSearchResultforEmail(String Email) throws InterruptedException
    { 
    	Thread.sleep(4000);
    	 List<WebElement> emailList  =  driver.findElements(By.xpath("//tr/td[2]"));
    	 Thread.sleep(4000);
         List<WebElement> filteredList  = emailList.stream().filter(mail->mail.getText().contains(Email))
         .collect(Collectors.toList());
         Assert.assertEquals(emailList.size(),filteredList.size() );
    }
    
    public void enterValidSearchName(String Name) throws InterruptedException
    {
                    driver.findElement(Searchbar).sendKeys(Name);
                    driver.findElement(Searchbar).sendKeys(Keys.ENTER);
                    Thread.sleep(4000); 
    }
    
    public void validateSearchResultforName(String Name) throws InterruptedException
    { 
    	Thread.sleep(4000);
    	 List<WebElement> NameList  =  driver.findElements(By.xpath("//tr/td[3]"));
    	 Thread.sleep(4000);
         List<WebElement> filteredNameList  = NameList.stream().collect(Collectors.toList());
         Assert.assertEquals(NameList.size(),filteredNameList.size() );
    }
    
    public void enterInvalidSearchinput(String InvalidInput) throws InterruptedException
    {
                    driver.findElement(Searchbar).sendKeys(InvalidInput);
                    driver.findElement(Searchbar).sendKeys(Keys.ENTER);
                    Thread.sleep(4000);       
    }
    
    public String errorMessageInvalidInput()
    {   
    	String ErrorMessage=driver.findElement(ErrorMessageInvalidInput).getText();
		return ErrorMessage;
    	
    }
    
    public void clickOnCheckbox() throws InterruptedException
    {
    	driver.findElement(Checkbox).click();
    	Thread.sleep(4000);
    }
    
    public void ValidatePendingRequestName() throws InterruptedException
    {Thread.sleep(4000);
    	List<WebElement> ActualList  =  driver.findElements(By.xpath("//tr/td[14]"));
    	Thread.sleep(4000);
        List<WebElement> ExpectedList  = ActualList.stream().filter(request->request.getText().contains("Accept"))
        .collect(Collectors.toList());
        Thread.sleep(2000);
        Assert.assertEquals(ActualList.size(),ExpectedList.size() );
    }
    
    public void aceeptPendingRequest() throws InterruptedException
    {   
    	driver.findElement(By.xpath("//tr[1]/td[14]"));
    	driver.findElement(By.xpath("//button[normalize-space()='Accept']")).click();
    	driver.findElement(By.xpath("//button[normalize-space()='No']")).click();
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("//button[normalize-space()='Accept']")).click();
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("//button[normalize-space()='Yes']")).click();
    }
    
    public void rejectPendingRequest() throws InterruptedException
    {   
    	driver.findElement(By.xpath("//tr[1]/td[14]"));
    	driver.findElement(By.xpath("//button[normalize-space()='Reject']")).click();
    	driver.findElement(By.xpath("//button[normalize-space()='No']")).click();
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("//button[normalize-space()='Reject']")).click();
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("//button[normalize-space()='Yes']")).click();
    }
    
    public String validateIfUserNotDeleted()
    {
    	String userPresent=driver.findElement(By.xpath("//tr[1]/td[2]")).getText();
    	System.out.println(userPresent);
    	return userPresent;
    }
    
    public String ValidateHeading()
    {
     	String Heading=driver.findElement(heading).getText();
     	return Heading;
     	
     }

    
}
