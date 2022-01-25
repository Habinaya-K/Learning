#Author: your.Habinaya.Krishnamoorthy@lntinfotech.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: Log in to Orangehrm application
As a user of Orangehrm website,
I should be able to enter username and password to login to their account
Scenario: Successful Login with Valid entries
Given I navigate to the website https://opensource-demo.orangehrmlive.com/ 
When I enter "admin" in the 'Admin' field
And I enter "password" in the 'Password' field
And I click on 'Login' button
Then I will be on "Dashboard" page

Feature: Log in to Orangehrm application
As a user of Orangehrm website,
I should get error message when I enter invalid username and password 
Scenario Outline: Successful Login with invalid entries
Given I navigate to the website https://opensource-demo.orangehrmlive.com/ 
When I enter <admin> in the 'Admin' field
And I enter <password> in the 'Password' field
And I click on 'Login' button
Then I validate that I get an error message "Invalid credentials"

Example:

|admin|password|
|admin1|password1|

Feature: Adding Candidate
As a user of Orangehrm website,
I should be able to add a candidate in recruitment page
Scenario: Adding candidate in recruitment page
Given I navigate to the website https://opensource-demo.orangehrmlive.com/ 
When I enter "admin" in the 'Admin' field
And I enter "password" in the 'Password' field
And I click on 'Login' button
And I will click on 'Recruitment' button
And I click on 'Candidate' button
And I click on 'Add' to add a candidate
And I enter "New" in the 'First Name' field
And I enter "User" in the ' Last Name' field
And I enter "newuser@mail.com" in 'Email' field
And I click on save 'Save' button
Then I should get confirmation message "Successfully saved"


Feature: Searching Candidate
As a user of Orangehrm website,
I should be able to search a candidate in recruitment page
Scenario: Adding candidate in recruitment page
Given I navigate to the website https://opensource-demo.orangehrmlive.com/ 
When I enter "admin" in the 'Admin' field
And I enter "password" in the 'Password' field
And I click on 'Login' button
And I will click on 'Recruitment' button
And I click on 'Candidate' button
And I enter "New User" in 'Candidate Name' field 
And I click on 'Search' button
And I will get a list of candidates added
And I click on "New User"
Then I can seee the details of the candidate in 'Candidate' page