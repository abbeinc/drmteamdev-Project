@bla
Feature: User with the wrong credentials should not be able
  to login on the website
  Scenario: User login fail
    Given user on the main page
    When user enters not registered email
    Then user should not be able to login

    Scenario: User login fail without password
      Given user on the main page
      When user enters just unregistered email
      Then user will see "Пароль не может быть пустым"

      Scenario: User should be able to login with the correct credentials
        Given user on the login page
        When user enters confirmed email and valid password
        Then user should see Task Page

        Scenario: User have to be able to logout
          Given user on the task page
          When if user click "Выйти"
          Then user should see login page


