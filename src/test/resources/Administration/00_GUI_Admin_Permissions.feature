@admin @permissions
#noinspection CucumberUndefinedStep

Feature: Administration - Permissions

  Background: Checks Permission Based Access

  Scenario: Check Permissions
    When I set test type "Admin"
    ##########################################
    # Token Products blocked by PMV 2428
    ##########################################
#    Given I am logged in as "admin_tp_g/password"
#    Then I click on the Admin Menu Token Products
#    Then I check the user cannot make changes to "Token Products"
#    Then I take a screenshot "Token Product Get User Prohibited"
#    Given I am logged in as "admin_tp_s/password"
#    Then I click on the Admin Menu Token Products
#    Then I check the user can make changes to "Token Products"
#    Then I take a screenshot "Token Product Set User Changes Made"
    Given I am logged in as "admin_tpg_g/password"
    Then I check the menu for "admin_tpg_g"
    Then I click on the Admin Menu Token Product Groups
    Then I check the user cannot make changes to "Token Product Groups"
    Then I take a screenshot "Token Product Group Get User Prohibited"
    Given I am logged in as "admin_tpg_s/password"
    Then I check the menu for "admin_tpg_s"
    Then I click on the Admin Menu Token Product Groups
    Then I check the user can make changes to "Token Product Groups"
    Then I take a screenshot "Token Product Group Set User Changes Possible"
    Given I am logged in as "admin_iss_g/password"
    Then I check the menu for "admin_iss_g"
    Then I click on the Admin Menu Issuers
    Then I check the user cannot make changes to "Issuers"
    Then I take a screenshot "Issuer Get User Prohibited"
    Given I am logged in as "admin_iss_s/password"
    Then I check the menu for "admin_iss_s"
    Then I click on the Admin Menu Issuers
    Then I check the user can make changes to "Issuers"
    Then I take a screenshot "Issuer Set User Changes Made"
    Given I am logged in as "admin_ins_g/password"
    Then I check the menu for "admin_ins_g"
    Then I click on the Admin Menu Institutions
    Then I check the user cannot make changes to "Institutions"
    Then I take a screenshot "Institution Get User Prohibited"
    Given I am logged in as "admin_ins_s/password"
    Then I check the menu for "admin_ins_s"
    Then I click on the Admin Menu Institutions
    Then I check the user can make changes to "Institutions"
    Then I take a screenshot "Institution Set User Changes Possible"
    Given I am logged in as "admin_sch_g/password"
    Then I check the menu for "admin_sch_g"
    Then I click on the Admin Menu Task Scheduler
    Then I check the user cannot make changes to "Task Scheduler"
    Then I take a screenshot "Task Scheduler Get User Prohibited"
    Given I am logged in as "admin_sch_s/password"
    Then I check the menu for "admin_sch_s"
    Then I click on the Admin Menu Task Scheduler
    Then I check the user can make changes to "Task Scheduler"
    Then I take a screenshot "Task Scheduler Set User Changes Possible"
    ##########################################
    # Encryption Keys blocked by PMV-2432
    ##########################################
    ##########################################
    # Encryption Zones blocked by PMV-2429
    ##########################################
    Given I am logged in as "admin_int_g/password"
    Then I check the menu for "admin_int_g"
    Then I click on the Admin Menu Interfaces Interfaces
    Then I check the user cannot make changes to "Interfaces"
    Then I take a screenshot "Interfaces Get User Prohibited"
    Given I am logged in as "admin_int_s/password"
    Then I check the menu for "admin_int_s"
    Then I click on the Admin Menu Interfaces Interfaces
    Then I check the user can make changes to "Interfaces"
    Then I take a screenshot "Interfaces Set User Changes Possible"
    ################################################
    # Data Dictionary Countries blocked by PMV-2431
    ################################################
    Given I am logged in as "admin_pbu_g/password"
    Then I check the menu for "admin_pbu_g"
    Then I click on the Admin Menu Interfaces Perso Bureau
    Then I check the user cannot make changes to "Perso Bureau"
    Then I take a screenshot "Perso Bureau Get User Prohibited"
    Given I am logged in as "admin_pbu_s/password"
    Then I check the menu for "admin_pbu_s"
    Then I click on the Admin Menu Interfaces Perso Bureau
    Then I check the user can make changes to "Perso Bureau"
    Then I take a screenshot "Perso Bureau Set User Changes Possible"
    Then Check Permissions scenario

