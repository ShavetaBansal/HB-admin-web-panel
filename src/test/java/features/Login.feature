Feature: validate the login functionality

  
  Scenario Outline: User logins into the application with valid credentials
    Given user is on login page
    When user enters valid username <username> and password <password>
    And clicks on login button
    Then user logged in sucessfully

    Examples: 
      | username           | password     |
      | admin@memorres.com | memorres@007 |

  #Test-002
  Scenario Outline: User should not be able to login into the application with invalid credentials
    Given user is on login page
    When user enters invalid username <username> and password <password>
    And clicks on login button
    Then user not able to login

    Examples: 
      | username               | password           |
      | admin@memorres.com     | memorre            |
      | admin@memorres.com     | Memorres@007       |
      | admin1234@memorres.com | memorre            |
      | admin@@memorres.com    | memorres@007       |
      | admin1234@memorres.com | memorres@007       |
     

  #Test-003
  Scenario: User should not be able to login into the application without any credentials
    Given user is on login page
    When user does not enter any username "" and password ""
    And clicks on login button
    Then user not able to login

  #Test-004
  Scenario: User should not be able to login into the application with only username
    Given user is on login page
    When user enters only username "admin@memorres.com" and does not enter any password ""
    And clicks on login button
    Then user not able to login

  #Test-005
  Scenario: User should not be able to login into the application with only password
    Given user is on login page
    When user does not enter any username "" and enters only password "memorres@007"
    And clicks on login button
    Then user not able to login

  #Test-006
  Scenario: verify if error messages are shown when user try login without any credentials
    Given user is on login page
    When user does not enter any username "" and password ""
    And clicks on login button
    Then error messages are displyed for email and password fields

  #Test-007
  Scenario: Verify error message for invalid username
    Given user is on login page
    When user enters invalid username "admin@memorres"
    And clicks on login button
    Then error message is displayed for email field

  #Test-008
  Scenario Outline: Verify error message for invalid username and invalid password
    Given user is on login page
    When user enters invalid username <username> and password <password>
    And clicks on login button
    Then error message is shown for invalid credentials

    Examples: 
      | username               | password |
      | admin1234@memorres.com | memorres |

 
  
  #Test-009
  
  Scenario: Validate placeholder text on email and password text fields
    Given user is on login page
    Then verify placeholder texts are visible correctly on email and password text fields

  #Test-010
  Scenario: Validate if forgot password link is available and working properly on login page
    Given user is on login page
    And check if forgot password link is available
    When user clicks on forgot password link
    Then user redirected to forgot password page

  #Test-011
  Scenario: Validate the page title and Url of the login page
    Given user is on login page
    Then verify if url and page title are visible correctly on login page

  #Test-012
  Scenario: Validate text of login button on login page
    Given user is on login page
    Then verify if text of login button on login page is correctly displayed
