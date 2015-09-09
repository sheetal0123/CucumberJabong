Feature: Login Functionality Feature
  
  In order to ensure Login Functionality works,
  I want to run the cucumber test to verify it is working

  @negativeScenario
  Scenario: Login Functionality
    Given user navigates to Jabong.com
    When user navigates to login page
    When user logs in using Username as "invalid@user.com" and Password "invalidpassword"
    Then error message should be thrown

  @positiveScenario
  Scenario: Login Functionality
    Given user navigates to Jabong.com
    When user navigates to login page
    When user logs in using Username as "sheetal0123@gmail.com" and Password "xebia@123"
    Then "Hi, sheetal" should display on home page

  @sanity
  @positiveScenario
  Scenario: Search Functionality
    Given user navigates to Jabong.com
    When user searched for "shoes"
    Then user verifies title starts with "shoes"
