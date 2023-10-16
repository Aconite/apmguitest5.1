@scheduledtasks @accesslog
  #noinspection CucumberUndefinedStep
Feature: Access Data Log Extract in Scheduler Task List

    Background: Creates and runs an Access Log Data Extract task and checks logs and database

    Scenario: Add a new accesslogdataextract task
      Given I am logged in and on the scheduler page
      When I add a new daily accesslogdataextract task
      Then I take a screenshot "Task Added"
      Given I am logged in and on the scheduler page
      When I run a accesslogdataextract task
      Then I take a screenshot "Task Run"
      Then the accesslogdataextract task runs successfully and the output is correct
      Given I am logged in and on the scheduler page
      Then I can delete the accesslogdataextract from the list of tasks
      Then I take a screenshot "Task Deleted"
      Then Check scheduler scenario