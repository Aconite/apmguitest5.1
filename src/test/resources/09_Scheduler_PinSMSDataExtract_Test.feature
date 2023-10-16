@scheduledtasks @pinsms
#noinspection CucumberUndefinedStep
Feature: Pin SMS Data Log Extract in Scheduler Task List
  ############################################################
  # Data: Token Order with PIN Delivery
  #       PIN Import - PIN Advice -SMS
  #
  # Ensure "pinsms" task is run before test is run
  ############################################################

  Background: Creates and runs a PIN SMS Data Extract task and checks logs and database

  Scenario: Add a new pinsmsdataextract task
    Given I am logged in and on the scheduler page
    Then I create data for the pinsms extract
    When I add a new daily pinsms task
    Then I take a screenshot "Task Added"
    Given I am logged in and on the scheduler page
    When I run a pinsms task
    Then I take a screenshot "Task Run"
    Given I am logged in and on the scheduler page
    Then I can delete the pinsms from the list of tasks
    Then I take a screenshot "Task Deleted"
    Given I am logged in and on the scheduler page
    When I add a new daily pinsmsdataextract task
    Then I take a screenshot "Task Added"
    Given I am logged in and on the scheduler page
    When I run a pinsmsdataextract task
    Then I take a screenshot "Task Run"
    Given I am logged in and on the scheduler page
    Then I can delete the pinsmsdataextract from the list of tasks
    Then I take a screenshot "Task Deleted"
    Then the pinsmsdataextract task runs successfully and the output is correct
    Then Check scheduler scenario