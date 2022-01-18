 3.46 KB
   
#Author: your.Vishnu.Raj@lntinfotech.com
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
Feature: Log in to ZeroBank
As a user of Zero bank,
I should be able to enter username and password to proceed further transcations
Scenario: Successful Login with Valid entries
Given I navigates to the website zero.webappsecurity.com 
When I click on Sign-in button
And I navigate to Login Page
And I enter Username as "username"
And I enter Password as "password"
And I click on 'Sign In' button
Then I should see 'Account summary' page


Feature: Forgotten Password
As a user of Zero bank,
I should be able to enter email in order to generate new password
Scenario: Successful change new password with Valid email
Given I navigates to the website zero.webappsecurity.com 
When I click on Sign-in button
And I navigate to Login Page 
And I click on "Forgotten Password"
And I navigate to Forgotten Password page
When I enter "vishnu@gamil.com" in the "Email" field
And I press the "Send Password" button
Then I should get the "new password" to my Email

Feature: Home page
As a user of Zero bank,
On landing to Home page I should be able to see the Brand Logo, Sign in Button and search box field for easy accessable
Scenario: Successful land on home page of Zero Bank
Given I navigates to the website zero.webappsecurity.com 
When I land on home page
And I should see Brand Logo, Sign In button and search box field.
Then I can easily access required field

Feature: Account Summary
As a user of Zero bank,
On sign in with valid cred I should land on Account Summary in order to check Account details and Balance first 
Scenario: Successful land on 'Account Summary' page of Zero Bank
When I click on Sign-in button
And I navigate to Login Page
And I enter Username as "username"
And I enter Password as "password"
And I click on 'Sign In' button
And I navigate to'Account summary' page
Then I should see Account details and Balance in Account summary page

Feature: Search 
As a user of Zero bank,
I should be able to use the search box field to get search result page
Scenario: Successful land on home page of Zero Bank
Given I navigates to the website zero.webappsecurity.com 
When I enter "Online Banking" in the search box
And I press enter button
And I navigate to search result page
And I click on 'Zero - Free Access to Online Banking' link
Then I should land on 'Online Banking' page

Feature: Forgotten Password
As a user of Zero bank 
When I enter invalid email into Forgotten Password page then I should get an error message
Scenario Outline: When I enter invalid email into application then I should get an error message
Given I navigates to the website zero.webappsecurity.com 
When I click on Sign-in button
And I navigate to Login Page 
And I click on 'Forgotten Password' link
And I navigate to Forgotten Password page
When I enter <email> in the 'Email' field
And I press the "Send Password" button
Then I validate that I get an error message "Invalid Email ID"

Example:

|email|
|"abc21&*"|