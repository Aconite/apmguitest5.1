@scheduledtasks @tokendata
#noinspection CucumberUndefinedStep
Feature: Token Data Log Extract in Scheduler Task List

  Background: Creates and runs a Token Data Extract task and checks logs and database

  Scenario: Add a new tokendataextract task
    Given I am logged in and on the scheduler page
    Then I create data for the tokendataextract extract
    When I add a new daily tokendataextract task
    Then I take a screenshot "Task Added"
    Given I am logged in and on the scheduler page
    When I run a tokendataextract task
    Then I take a screenshot "Task Run"
    Given I am logged in and on the scheduler page
    Then I can delete the tokendataextract from the list of tasks
    Then I take a screenshot "Task Deleted"
    Then the tokendataextract task runs successfully and the output is correct
    Then Check scheduler scenario