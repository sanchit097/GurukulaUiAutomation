#Author: sanchit_negi@yahoo.com

@assignment
Feature: Search from home page
  I want to search specific product from searchResult

  Background: User is navigated to website
    Given I navigate to the login page
    When I enter following for login
      | username | admin |
      | password | admin |
    Then I should be navigated to homepage

  Scenario Outline: create new Branch
    Given I am at branch creation page
    When i click on create new branch button
    And enter branch <branchName> and <branchCode>
    And press save branch button
    Then new branch should be created with Code <branchCode>

    Examples: 
      | branchName | branchCode |
      | PHYSICS    | PHY01      |

  Scenario Outline: Edit existing Branch
    Given I am at branch creation page
    When i click on edit branch button of code <ExistingCode>
    And enter branch <branchName> and <branchCode>
    And press save branch button
    Then branch should be edited with code <branchCode>

    Examples: 
      | ExistingCode | branchName | branchCode |
      | PHY01        | MATHS      | MAT01      |
 	

  Scenario Outline: delete existing Branch
    Given I am at branch creation page
    When i click on delete button of <branchCode>
    And i confirms deletion
    Then <branchCode> branch should be deleted

    Examples: 
      | branchCode  |
      | MAT01 |
