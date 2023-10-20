@bla
Feature: If user forgot password he should be able to change it through his email

  Background:
    Given user at the login page

  Scenario Outline: registered user forgot his password
    When user click Вспомнить пароль
    And enters his valid "<email>" and click Вспомнить
    Then user should see the message Repass successfully started
    Examples:
      | email                    |
      | volunteer@fake-email.com |
      | admin@fake-email.com     |


    Scenario: not registered user can't use Вспомнть пароль function
      When user click Вспомнить пароль
      And enters his valid  not registered email and click Вспомнить
      Then user should see warning message