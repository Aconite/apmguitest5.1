@housekeeper
#noinspection CucumberUndefinedStep

Feature: Housekeeper in Scheduler Task List
  ############################################################
  # Data:
  ############################################################

  Background: Creates and runs a Housekeeper task and checks files and database

  Scenario: Add a new housekeeper task
    Given I am logged in and on the scheduler page
    Then I create my expected results
    When I add a new daily housekeeper task
    Then I take a screenshot "Task Added"
    Given I am logged in and on the scheduler page
    When I run a housekeeper task
    Then I take a screenshot "Task Run"
    Given I am logged in and on the scheduler page
    Then I can delete the housekeeper from the list of tasks
    Then I take a screenshot "Task Deleted"
    Then I create my actual results
    Then the housekeeper task runs successfully and the output is correct
    Then Check scheduler scenario