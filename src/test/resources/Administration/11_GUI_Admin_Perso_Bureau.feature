@admin @persobureau
#noinspection CucumberUndefinedStep

Feature: Administration - Interfaces - Perso Bureau

  Background: Checks Administration of Interfaces - Perso Bureau

  Scenario: Add a Perso Bureau
    Given I set test type "Admin"
    Given I am logged in
    Then I click on the Admin Menu Interfaces Perso Bureau
    Then I check the perso bureau required fields
    Given I am logged in
    Then I click on the Admin Menu Interfaces Perso Bureau
    Then I add a new perso bureau
    Then I take a screenshot "Perso Bureau Added"
    Given I am logged in
    Then I click on the Admin Menu Interfaces Perso Bureau
    Then I edit a perso bureau
    Then I take a screenshot "Perso Bureau Edited"
    Given I am logged in
    Then I click on the Admin Menu Interfaces Perso Bureau
    Then I delete a perso bureau
    Then I take a screenshot "Perso Bureau Deleted"
    Then Check Perso Bureau scenario

