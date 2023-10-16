@admin @pvv @failed
#noinspection CucumberUndefinedStep

Feature: Administration - PVV

  Background: Checks Administration of PVV

  Scenario: Add a PVV
    Given I set test type "Admin"
    Given I am logged in
    Then I click on the Admin Menu Token Products
    Then I check the pvv required fields
    Given I am logged in
    Then I click on the Admin Menu Token Products
    Then I add a new pvv
    Then I take a screenshot "PVV Added"
    Given I am logged in
    Then I click on the Admin Menu Token Products
    Then I edit an existing pvv
    Then I take a screenshot "PVV Edited"
    Given I am logged in
    Then I click on the Admin Menu Token Products
    Then I delete a pvv
    Then I take a screenshot "PVV Deleted"
    Given I am logged in
    Then I click on the Admin Menu Token Products
    Then I delete the pvv parent application profile
    Given I am logged in
    Then I click on the Admin Menu Token Products
    Then I delete the pvv parent token product
    Then Check pvv scenario
