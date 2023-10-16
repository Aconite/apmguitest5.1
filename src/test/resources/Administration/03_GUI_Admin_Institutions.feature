@admin @institutions
#noinspection CucumberUndefinedStep

Feature: Administration - Institutions

  Background: Checks Administration of Institutions

  Scenario: Add an Institution
    Given I set test type "Admin"
    Given I am logged in
    Then I click on the Admin Menu Institutions
    Then I check the institution required fields
    Given I am logged in
    Then I click on the Admin Menu Institutions
    Then I add a new institution
    Then I take a screenshot "Institution Added"
    Given I am logged in
    Then I click on the Admin Menu Institutions
    Then I edit an institution
    Then I take a screenshot "Institution Edited"
    Given I am logged in
    Then I click on the Admin Menu Institutions
    Then I delete an institution
    Then I take a screenshot "Institution Deleted"
    Then Check institution scenario
