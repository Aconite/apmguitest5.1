@admin @tokenproductgroups
#noinspection CucumberUndefinedStep

Feature: Administration - Token Product Groups

  Background: Checks Administration of Token Product Groups

  Scenario: Add a Token Product Group
    Given I set test type "Admin"
    Given I am logged in
    Then I click on the Admin Menu Token Product Groups
    Then I check the token product group required fields
    Given I am logged in
    Then I click on the Admin Menu Token Product Groups
    Then I add a new token product group
    Then I take a screenshot "Token Product Group Added"
    Given I am logged in
    Then I click on the Admin Menu Token Product Groups
    Then I edit a token product group
    Then I take a screenshot "Token Product Group Edited"
    Given I am logged in
    Then I click on the Admin Menu Token Product Groups
    Then I delete a token product group
    Then I take a screenshot "Token Product Group Deleted"
    Then Check token product group scenario
