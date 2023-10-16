@admin @tokenapplicationprofiles @failed
#noinspection CucumberUndefinedStep

Feature: Administration - Token Application Profiles

  Background: Checks Administration of Token Application Profiles

  Scenario: Add a Token Application Profile
    Given I set test type "Admin"
    Given I am logged in
    Then I click on the Admin Menu Token Products
    Then I check the Token Application Profile required fields
    Given I am logged in
    Then I click on the Admin Menu Token Products
    Then I add a new token application profile
    Then I take a screenshot "Token Application Profile Added"
    Given I am logged in
    Then I click on the Admin Menu Token Products
    Then I edit an existing token application profile
    Then I take a screenshot "Token Application Profile Edited"
    Given I am logged in
    Then I click on the Admin Menu Token Products
    Then I delete a token application profile
    Then I take a screenshot "Token Application Profile Deleted"
    Then I delete the parent token product
    Then Check token application profile scenario
