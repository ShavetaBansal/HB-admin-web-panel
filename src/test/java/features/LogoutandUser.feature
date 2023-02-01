Feature: validate the User Module and Logout functionality

Background: 
    Given user is on login page
    When user enters valid userID "admin@memorres.com" and password "memorres@007"
    And clicks on login button
    And user logged in sucessfully
    
     #Test-001
     Scenario: Validate if user redirected to user page when clicked on user tab of side panel  
     When user clicks on user tab of side panel
     Then user page opens successfully
     
     
       #Test-002
       Scenario: Validate if user can Log Out from application
       Given user clicks on user tab of side panel
       And user page opens successfully
       When user clicks on logout button
       And user clicks on Yes of alert box
       Then user logged out of application successfully
       
      #Test-003
       Scenario Outline: Validate if user can Add new user with Add button
       Given user clicks on user tab of side panel
       And user page opens successfully
       When user clicks on Add button
       And enters valid <First name>, <Last Name>, <Email> in add user 
       And select role of a user
       And click on submit button to add user
       Then user gets created sucessfully for <Email> registered
       
       Examples: 
       |First name      |Last Name      |       Email                |
       | Ajay           |    kumar      |   dihek36716@tingn.com     |
       | Kumar          |    sahu       |      kumaremail@pl.com     |
    
      #Test-004
       Scenario Outline: Validate error message if user Adds new user with Existing email
       Given user clicks on user tab of side panel
       And user page opens successfully
       When user clicks on Add button
       And enters valid <First name>, <Last Name>, <Email> in add user 
       And select role of a user
       And click on submit button to add user
       Then Error message should be displayed for already existing user
       
       Examples: 
       |First name      |Last Name      | Email                      |
       | Ajay           |    kumar      |   dihek36716@tingn.com     |
      
      #Test-005
       Scenario: Validate error messages if user clicks on submit button without any input
       Given user clicks on user tab of side panel
       And user page opens successfully
       When user clicks on Add button
       And click on submit button to add user
       Then Error messages should be displayed correctly for each field
       
       
       #Test-006
       Scenario Outline: Validate if user can edit existing user 
       Given user clicks on user tab of side panel
       And user page opens successfully
       When user searches with valid email <email> and clicks on edit button
       And user saves the updated changes by entering valid new <New email> in email field of edit box
       Then user get updated succesfully with new <New email> email
       Examples:
       |email                 |New email          |
       |dihek36716@tingn.com  |new1for@always.com |
       
       
       #Test-007
       Scenario Outline: Validate if user can delete existing user
       Given user clicks on user tab of side panel
       And user page opens successfully
       When user searches with valid <email> and clicks on delete button
       Then user gets deleted successfully having <email> Email ID
        Examples:
        |     email          |
        |new1for@always.com  |
        | kumaremail@pl.com  | 
        
        
        #Test-008
         Scenario Outline: Validate the column names of user datatable
         Given user clicks on user tab of side panel
         When user page opens successfully
         Then verify if all the columns are displayed as per requirement
         
         
       #Test-009
         Scenario Outline: Validate the page title, heading and url of user page
         Given user clicks on user tab of side panel
         When user page opens successfully
         Then validate the page title, heading and url of user page is as per requirement
         
         
         
       
       
    
