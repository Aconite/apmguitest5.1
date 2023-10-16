@scheduledtasks @tokenapplicationdata
#noinspection CucumberUndefinedStep
Feature: Token Application Data Log Extract in Scheduler Task List

  Background: Creates and runs a Token Application Data Extract task and checks logs and database

  Scenario: Add a new tokenapplicationdataextract task
    Given I am logged in and on the scheduler page
    Then I create data for the tokenapplicationdataextract extract
    When I add a new daily tokenapplicationdataextract task
    Then I take a screenshot "Task Added"
    Given I am logged in and on the scheduler page
    When I run a tokenapplicationdataextract task
    Then I take a screenshot "Task Run"
    Given I am logged in and on the scheduler page
    Then I can delete the tokenapplicationdataextract from the list of tasks
    Then I take a screenshot "Task Deleted"
    Then the tokenapplicationdataextract task runs successfully and the output is correct
    Then Check scheduler scenario