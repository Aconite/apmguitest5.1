@donotrun
Feature: Login

  Background: User is logged in and on the scheduler page
#
##    Scenario: Add tasks
##      Given I am logged in and on the scheduler page
##      When I add the following daily tasks
##        | accesslogdataextract | active |
##        | tokenorderfeedback   | active |
##        | tokenimportfeedback  | active |
##        | pinmailer            | active |
##      Then the tasks are added successfully
#
#
##    Scenario: Run tasks and wait for 10 minutes
##      Given I am logged in and on the scheduler page
##      When I add the following daily tasks
##        | accesslogdataextract |
##        | tokenorderfeedback   |
##        | tokenimportfeedback  |
##        | pinmailer            |
##      Then I wait for <10> minutes

  Scenario Outline: Add tasks
    Given I am logged in and on the scheduler page
    When I add a new daily pinmailer task for Issuer "<issuer>"
    Then the tasks are added successfully

    Examples:
  |issuer|
  |LastBank|

##    Scenario: Validate outputs