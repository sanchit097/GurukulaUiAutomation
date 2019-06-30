#Author: sanchit_negi@yahoo.com
@assignment
Feature: Registeration feature

  Scenario Outline: I want to register in Gurukula
    Given I am at registration page
    When I enter valid login as <login>
    And enter email as <email>
    And enter password as <password>
    And enter confirm password as <confirmPassword>
    And click on register button
    Then i should be successfully logged in

    Examples: 
      | login    | email              | password    | confirmPassword |
      | testuser | testUser@gmail.com | Testuser123 | Testuser123     |
