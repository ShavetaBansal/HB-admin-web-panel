Feature: validate the Patient Listing Module

  Background: 
    Given user is on login page
    When user enters valid userID "admin@memorres.com" and password "memorres@007"
    And clicks on login button
    Then user logged in sucessfully
    

  #Test-001
  Scenario: Validate if patient listing page opens by default after login with valid credentials
    And user landed to patient listing page successfully

#Test-002
  Scenario: Validate if patient listing page contains logout button to log out of the application
    When user landed to patient listing page successfully
    Then logout button is displayed on patient listing page
                  

  #Test-003
  Scenario: Validate if Search bar is present and the placeholder text of search bar in patient listing page
    Given user landed to patient listing page successfully
    Then search bar is displayed and working properly
    And the placeholder text of search bar is as per requirement
    

  #Test-004
  Scenario: Validate if Check box and text of label is displayed to view data based on pending delete request in patient listing page
    Given user landed to patient listing page successfully
    Then Check box is displayed to view data based on pending delete request
    And the label of the checkbox is as per requirement
    
   #Test-005
   Scenario: Validate if checkbox is not selected by default when user logged in and redirected to patient listing page after login
    Given user landed to patient listing page successfully
    Then checkbox is not selected by default when user logged in and landed on patient listing page
    
  #Test-006
   Scenario: Validate if datatable is available has all the columns as per requirement
    Given user landed to patient listing page successfully
    Then all of the columns and their names should be displayed correctly
      
 #Test-007
 Scenario: Validate if number of patients in datatable matches with the count of patients showing in patient listing page
  Given user landed to patient listing page successfully
  Then patient count is displayed correctly in patient listing
  
 #Test-008
  Scenario: Validate sorting of column when user clicked on column heading
  Given user landed to patient listing page successfully
  When user clicks on ID column Heading
  Then column gets sorted based on ID succesfully
  
    
 
  #Test-009
  Scenario Outline: Validate the datatable when user searches with valid Email in searchbar
  Given user landed to patient listing page successfully
  When user Enters valid input email <Email> in search bar
  Then result should be displayed correctly in the datatable for valid email <Email>
   Examples:
  |     Email                | 
  |    shaveta@memorres.com  |

 
  #Test-010 
  Scenario Outline: Validate the datatable when user searches with valid patient name in searchbar
  Given user landed to patient listing page successfully
  When user Enters valid input patient name <Name> in search bar
  Then result should be displayed correctly in the datatable for valid patient name <Name>
  
  Examples:
  |     Name     |
  |   Shaveta    | 
  |     ma       |
  

  
  #Test-011
  Scenario Outline: Validate the datatable when user searches with invalid input in searchbar
  Given user landed to patient listing page successfully
  When user Enters invalid input <Invalid input> in search bar
  Then error message should be displayed correctly in the datatable for invalid input
  
    Examples:
  |     Invalid input   | 
  |     sjhbxf          |
  |     sjhbx%w6        |
  |     shaveta@@memorr |
  |dihek36716@tingn.com |
  
   #Test-012
  Scenario: Validate clicking on checkbox patients with pending delete request are displayed
  Given user landed to patient listing page successfully
  When user clicks on checkbox 
  Then patients with delete pending request are correctly displayed
  
  #Test-013
  Scenario Outline: Validate if user can accept the pending delete request
  Given user landed to patient listing page successfully
  When user enters valid patient email <email> whose request is to be accepted
  Then user clicks on accept delete request
  And patient with valid email <email> will be deleted successfully
  Examples:
  |  email               |
  |  akash@memorres.com  |
  
  
#Test-014
  Scenario Outline: Validate if user can reject the pending delete request
  Given user landed to patient listing page successfully
  When user enters valid patient email <email> whose request is to be rejected
  Then user clicks on rejects the delete request
  But patient with valid email <email> will not be deleted
  Examples:
  |  email                  |
  |  shaveta+@memorres.com  |
  
  
#Test-015
  Scenario: Validate the page title, Heading  and Url of the Patient Listing page
   Given user landed to patient listing page successfully
   Then validate the page title, Heading and url of patient listing page
  
  
  
  
 
   
    
