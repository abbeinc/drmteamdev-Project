

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

  Scenario: User as a volunteer should be able to login with the correct credentials
    Given user on the login page
    When user enters confirmed email and valid password
    Then user should see Task Page

  Scenario: User as a volunteer have to be able to logout
    Given user on the task page
    When if user click "Выйти"
    Then user should see login page


  Scenario: User as an admin should be able to login with the correct credentials
    Given user on the login page
    When user as an admin enters confirmed email and valid password
    Then user should see Task Page

  Scenario: User as an admin have to be able to logout
    Given user on the login page
    When user as an admin enters confirmed email and valid password
    And if user click "Выйти"
    Then user should see login page


  Scenario Outline: User as an admin should not be able to login with an incorrect password
    Given user on the login page
    When user as an admin enters confirmed email and invalid "<password>"
    Then user should see warning sign Password not correct
    Examples:
      | password   |
      | ...        |
      | 1234       |
      | 321        |
      | vnaoshi    |
      | доаыщшоващ |
      | 123123     |
      | @#$%^&*()  |
      |            |


  Scenario Outline: User as a volunteer should not be able to login with an incorrect password
    Given user on the login page
    When user as a volunteer enters confirmed email and invalid "<password>"
    Then user should see warning sign Password not correct
    Examples:
      | password   |
      | ...        |
      | 1234       |
      | 321        |
      | vnaoshi    |
      | доаыщшоващ |
      | 123123     |
      | @#$%^&*()  |
      |            |


