@scheduledtasks @vpp
#noinspection CucumberUndefinedStep

Feature: Transaction VPP Data Extract in Scheduler Task List
  ############################################################
  # Data: VPPGetPIN
  ############################################################

  Background: Creates and runs a VPP Data Extract task and checks logs and database

  Scenario: Add a new vppdataextract task
    Given I am logged in and on the scheduler page
    Then I create data for the vppdataextract extract
    When I add a new daily vppdataextract task
    Then I take a screenshot "Task Added"
    Given I am logged in and on the scheduler page
    When I run a vppdataextract task
    Then I take a screenshot "Task Run"
    Given I am logged in and on the scheduler page
    Then I can delete the vppdataextract from the list of tasks
    Then I take a screenshot "Task Deleted"
    Then the vppdataextract task runs successfully and the output is correct
    Then Check scheduler scenario