@admin @interface
#noinspection CucumberUndefinedStep

Feature: Administration - Interfaces - Interfaces

  Background: Checks Administration of Interfaces - Interfaces

  Scenario: Add an Interfaces
    Given I set test type "Admin"
    Given I am logged in
    Then I click on the Admin Menu Interfaces Interfaces
    Then I check the interface required fields
    Given I am logged in
    Then I click on the Admin Menu Interfaces Interfaces
    Then I add a new interface
    Then I take a screenshot "Interface Added"
    Given I am logged in
    Then I click on the Admin Menu Interfaces Interfaces
    Then I edit an interface
    Then I take a screenshot "Interface Edited"
    Given I am logged in
    Then I click on the Admin Menu Interfaces Interfaces
    Then I delete an interface
    Then I take a screenshot "Interface Deleted"
    Then Check Interface scenario

