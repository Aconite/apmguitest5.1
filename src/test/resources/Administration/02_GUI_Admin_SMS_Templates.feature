@admin @smstemplate
#noinspection CucumberUndefinedStep

Feature: Administration - SMS Templates

  Background: Checks Administration of SMS Templates

  Scenario: Add an SMS Template
    Given I set test type "Admin"
    Given I am logged in
    Then I click on the Admin Menu SMS Templates
    Then I check the SMS Template required fields
    Given I am logged in
    Then I click on the Admin Menu SMS Templates
    Then I add a new SMS Template
    Then I take a screenshot "SMS Template Added"
    Given I am logged in
    Then I click on the Admin Menu SMS Templates
    Then I edit an SMS Template
    Then I take a screenshot "SMS Template Edited"
    Given I am logged in
    Then I click on the Admin Menu SMS Templates
    Then I delete an SMS Template
    Then I take a screenshot "SMS Template Deleted"
    Then Check SMS Template scenario

