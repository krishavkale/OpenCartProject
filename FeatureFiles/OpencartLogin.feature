#Author: your.email@your.domain.com
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
Feature: Login Feature
  I want to use this feature file to test login page of OpenCart application

  Background: Launch the Application
    Given OpenCart Application Launched

  @Regression @Sanity
  Scenario: Verify Application Logo
    Then Application Logo Should be available

  @Tag1
  Scenario: Verify LoginPage is Open if user is click on Login Link
    When I click My Account menu
    And click on Login Link
    Then I should get  LoginPage

  @Smoke
  Scenario Outline: Verify Application Login Functionality
    When I Enter <Email> and <password> in login page
    And I clicked on Login button
    Then I should get account overview page

    Examples: 
      | Email            | password |
      | com001@gmail.com | master   |

  @Smoke
  Scenario: Verify Application Registration Page
    When Click on Register link in Login page
    Then Registration page should be displayed
