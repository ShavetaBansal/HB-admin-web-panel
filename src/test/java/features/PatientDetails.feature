Feature: validate the patient Details Module

Background: 
    Given user is on login page
    When user enters valid userID "admin@memorres.com" and password "memorres@007"
    And clicks on login button
    And user logged in sucessfully
    And user Enters valid input email "testermemor341@gmaiil.com" in search bar and clicks similar email in data table
    Then user redirected to patient details page

    #Test-001    
    Scenario: Validate back button of browser redirects user to patient listing page
    Given user redirected to patient details page
    When user clicks on back button of browser
    Then user landed to patient listing page successfully
    
    #Test-002
    Scenario: Validate back button of UI redirects user to patient listing page
    Given user redirected to patient details page
    When user clicks on back button of UI
    Then user landed to patient listing page successfully
    
    #Test-003
    Scenario: Verify if all patient detail fields are available on the page for updating the changes
    Given user redirected to patient details page
    Then Verify if all patient details field are available on the page

    #Test-004
    #Scenario: Verify if patient details section contains name, email, gender and date of birth fields with 'change password' and 'edit' button
    #Given user redirected to patient details page
    #Then patient details section has fields name, email, gender and date of birth fields with 'change password' and 'edit' button

    #Test-005
    Scenario: Verify error messages if user clicks on submit button of change password without any input in password fields
    Given user redirected to patient details page
    And user clicks on change password button
    When user clicks on submit button without any input in password fields
    Then Error messages are displayed correctly
    
 #Test-006
    Scenario Outline: Verify error message if user clicks on submit button of change password with invalid input in password fields
    Given user redirected to patient details page
    And user clicks on change password button
    When user clicks on submit button with invalid input <Invalid> in password fields
    Then Error messages are displayed correctly for invalid input
    
    Examples: 
    | Invalid       |
    | akash         |
   
   #Test-007
    Scenario Outline: Verify error message if user clicks on submit button of change password with valid unmatching input in password fields
    Given user redirected to patient details page
    And user clicks on change password button
    When user clicks on submit button with valid unmatching New Password <New password> and confirm password <Confirm password> in respective password fields 
    Then Error messages are displayed correctly for valid unmatching input
    
    Examples: 
    | New password      |   Confirm password      |
    | Ak@sh12345        |    Ak@sh1234            |
    
  #Test-008
    Scenario: Validate cancel button of change password takes user back to patient details page
     Given user redirected to patient details page
    And user clicks on change password button
    When user clicks on cancel button of change password 
    Then user redirected to patient details page
    
    #Test-009
    Scenario: Validate if Firstname, Lastname, Gender, Date of birth fields with Submit and cancel button are displayed after clicking Edit button of change password 
     Given user redirected to patient details page
     When user click on edit of patient detail section
     Then verify if Firstname, Lastname, Gender, Date of birth fields with Submit and cancel button are displayed after clicking Edit button of change password
    
    
    #Test-010
       Scenario: Validate Error Messages for Edit dtails page when user clicks on submit with empty First Name, Last Name and Date of Birth fields
    Given user redirected to patient details page
     When user click on edit of patient detail section
     And Clears the First Name, Last Name and Date of Birth fields
     And Clicks on submit buton of edit patient details
     Then Error messages are displayed correctly for edit patient details 
     
     
    #Test-011
    Scenario Outline: Validate after editing patient details changes are reflected in patient details section correctly
    Given user redirected to patient details page
    And  user click on edit of patient detail section
    When user enters valid first name <First Name> of the patient
    And user enters valid last name <Last Name> of the patient
    And user selects gender of patient
    And user selects Date of Birth of patient
    Then Clicks on submit buton of edit patient details
    And changes are reflected in patient details section correctly
    
   Examples:
   | First Name | Last Name |
   | Anna       |  kumari   |
   
   #Test-012
    Scenario: Verify if program management section contains program, Starting weight, Goal weight, weight unit and height unit with 'edit' button
    Given user redirected to patient details page
    Then program management section contains program, Starting weight, Goal weight, weight unit and height unit with 'edit' button  
    
    
    #Test-013
    Scenario: Validate Error Messages for Edit program management section when user clicks on submit with empty Starting weight and Goal weight fields
    Given user redirected to patient details page
     When user click on edit program management section
     And Clears the Starting weight and Goal weight fields
     And Clicks on submit buton of edit  program management section
     Then Error messages are displayed correctly for edit program management section
     
   #Test-014
    Scenario Outline: Validate after editing program management changes are reflected in patient details section correctly
    Given user redirected to patient details page
    When user click on edit program management section
    And selects the weight loss program
    And Clears the Starting weight and Goal weight fields
    And enters new Starting weight <Starting weight> and Goal Weight <Goal weight>
    And Clicks on submit buton of edit  program management section
    Then changes are reflected in program management section correctly with Starting weight <Starting weight> and Goal Weight <Goal weight>
    
    
   Examples:
   | Starting weight  | Goal weight |
   |   50.9           |   60.8   |
   
   
   #Test-15
   Scenario: verify error message if user clicks on submit without adding weight record in weight record section
   Given user redirected to patient details page
   And user clicks on add weight record 
   When user clicks on submit button of add weight record  
   Then error message for empty weight field correctly displayed
   
 #Test-16
   Scenario Outline: verify if user can add new weight in weight record and added record is displayed correctly in weight record section
   Given user redirected to patient details page
   And user clicks on add weight record 
   And user enters new weight <New Weight> in weight field
   When user clicks on submit button of add weight record  
   Then record is displayed correctly with <New Weight> weight in weight record section
    Examples:
   | New Weight  |  
   |   80.0        |  
     
 #Test-17
   Scenario: verify error message if user clicks on submit without adding Height record in Height record section
   Given user redirected to patient details page
   And user clicks on add Height record 
   When user clicks on submit button of add Height record  
   Then error message for empty Height field correctly displayed
   
#Test-18
   Scenario Outline: verify if user can add new Height in Height record and added record is displayed correctly in Height record section
   Given user redirected to patient details page
   And user clicks on add Height record 
   And user enters new Height <New Height> in Height field
   When user clicks on submit button of add Height record  
   Then record is displayed correctly with <New Height> Height in Height record section
    Examples:
   | New Height  |  
   |   170.0     |  
   
   
   #Test-19
   Scenario: validate url, page title and heading of patient details page
   Given user redirected to patient details page
   Then validate url, page title and heading of patient details page
   
   
   #Test-20
   Scenario: validate if address field is present on patient detail page
   Given user redirected to patient details page
   Then address field is present on patient details page
   
     #Test-21
    Scenario: validate if all labels are correctly displayed on address popup of patient detail page
   Given user redirected to patient details page
   When user clicks on address edit icon
   Then all labels are displayed correctly on address popup
   
   #Test-22
   Scenario: Verify error messages if user clicks on submit button on Address Popup of without any input in any fields
   Given user redirected to patient details page
   When user clicks on address Add icon
   And user click on submit button
   Then all error messages displayed on address popup
   
   #Test-23
    Scenario: Verify user can add address in address popup of patient detail page
   Given user redirected to patient details page
   When user clicks on address Add icon
   And user enter data in Address fields
   And user click on submit button
   Then user address is display on patient detail page
   
   #Test-24
    Scenario: Verify All Data points are displaying in All Measurement Section
   Given user redirected to patient details page
   Then Verify if all patient data points are displaying in All Measurement Section
    
 #Test-25
    Scenario: Verify weight info article displaying on clicking info icon in All Measurement Section
   Given user redirected to patient details page
   When click on weight info icon
   Then weight info article is displaying in all measurement section
    
    #Test-26
   Scenario: Verify HeartRate info article displaying on clicking info icon in All Measurement Section
   Given user redirected to patient details page
   When click on heart info icon
   Then heart info article is displaying in all measurement section
     
     #Test-27
   Scenario: Verify BMI info article displaying on clicking info icon in All Measurement Section
   Given user redirected to patient details page
   When click on BMI info icon
   Then BMI info article is displaying in all measurement section
    
    
    #Test-28
   Scenario: Verify BMR info article displaying on clicking info icon in All Measurement Section
   Given user redirected to patient details page
   When click on BMR info icon
   Then BMR info article is displaying in all measurement section
   
   
     #Test-29
    
    Scenario: Verify weight value is displaying in All Measurement Section
   Given user redirected to patient details page
   Then weightValue with unit is displaying in all measurement section
#Test-30
   
    Scenario: Verify BodyFat value is displaying in All Measurement Section
   Given user redirected to patient details page
   Then BodyFat Value with unit is displaying in all measurement section
   
   #Test-31
    
    Scenario: Verify visceralFat value is displaying in All Measurement Section
   Given user redirected to patient details page
   Then visceral Fat Value with unit is displaying in all measurement section
   
   
    #Test-32
 
    Scenario: Verify Protein value is displaying in All Measurement Section
   Given user redirected to patient details page
   Then Protein Value with unit is displaying in all measurement section
   
    #Test-33
  
    Scenario: Verify BodyType value is displaying in All Measurement Section
   Given user redirected to patient details page
   Then BodyType with unit is displaying in all measurement section
    
    
     
    #Test-34

    Scenario: Verify HeartRate value is displaying in All Measurement Section
   Given user redirected to patient details page
   Then HeartRate Value with unit is displaying in all measurement section
   
     #Test-35
 
    Scenario: Verify MuscleMass value is displaying in All Measurement Section
   Given user redirected to patient details page
   Then Muscle Mass Value with unit is displaying in all measurement section
   
   #Test-36

    Scenario: Verify  Bone Mass value is displaying in All Measurement Section
   Given user redirected to patient details page
   Then Bone Mass Value with unit is displaying in all measurement section
   
   
   
   #Test-37

    Scenario: Verify Subcutaneous Fat value is displaying in All Measurement Section
   Given user redirected to patient details page
   Then Subcutaneous Fat Value with unit is displaying in all measurement section
  
   #Test-38 
   
    Scenario: Verify Lean Body Mass value is displaying in All Measurement Section
   Given user redirected to patient details page
   Then Lean Body Mass Value with unit is displaying in all measurement section
   
    #Test-39
  
    Scenario: Verify BMI value is displaying in All Measurement Section
   Given user redirected to patient details page
   Then BMI Value with unit is displaying in all measurement section
   
    #Test-40
   
    Scenario: Verify Body Water value is displaying in All Measurement Section
   Given user redirected to patient details page
   Then Body water Value with unit is displaying in all measurement section
   
   #Test-41
  
    Scenario: Verify BMR Value is displaying in All Measurement Section
   Given user redirected to patient details page
   Then BMR Value with unit is displaying in all measurement section
   #Test-42
  
    Scenario: Verify Fat level value is displaying in All Measurement Section
   Given user redirected to patient details page
   Then Fat Level Value with unit is displaying in all measurement section
   
   #Test-43
  
    Scenario: Verify Standard weight value is displaying in All Measurement Section
   Given user redirected to patient details page
   Then Standard Weight Value with unit is displaying in all measurement section
   
   
    