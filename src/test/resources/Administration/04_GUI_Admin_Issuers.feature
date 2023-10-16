@admin @issuers
#noinspection CucumberUndefinedStep

Feature: Administration - Issuers

  Background: Checks Administration of Issuers

  Scenario: Add an Issuer
    Given I set test type "Admin"
    Given I am logged in
    Then I click on the Admin Menu Issuers
    Then I check the issuer required fields
    Given I am logged in
    Then I click on the Admin Menu Issuers
    Then I add a new issuer
    Then I take a screenshot "Issuer Added"
    Given I am logged in
    Then I click on the Admin Menu Issuers
    Then I edit an issuer
    Then I take a screenshot "Issuer Edited"
    Given I am logged in
    Then I click on the Admin Menu Issuers
    Then I delete an issuer
    Then I take a screenshot "Issuer Deleted"
    Then Check issuer scenario
