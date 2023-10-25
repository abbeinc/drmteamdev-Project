@bla
Feature: As a user I have to be able register on the website

  Scenario: After user clicked button "Зарегистрироваться" he must see page "Регистрация"
    Given user at the "Главная" page
    When user click "Зарегистрироваться"
    Then user should see page with a title "Регистрация"

  Scenario: User cant register if email field is empty
    Given user at the "Регистрация" page2
    When user click registration button without email and password
    Then user should see warning "Email не может быть пустым"


  Scenario: If user entered correct email and password he should be able to register
    Given user at the "Регистрация" page2
    When user enters e-mail
    And password and repeat password
    And click "Зарегистрироваться"
    Then user should see "User has been successfully created, check your email"


  Scenario: User can't register again with the same credentials
    Given user at the "Регистрация" page2 trying to create with the same credentials
    When user enters existing e-mail and password
    Then user should see alert "User already exist" message


  Scenario Outline: User can't register with incorrect email
    Given user at the Регистрация page
    When user enters "<email>" and "<password>"
    Then user should see warning


    Examples:
      | email              | password  |
      | aaa.yandex.ru      | 12345372  |
      | .@yandex.ru        | 12976567  |
      | aaaa@.ru           | 12256784  |
      | кирилица@yandex.ru | 123452464 |
      | bbb@.ru            | 123454562 |


  Scenario: user can't register if enters correct email and password more than 50 characters
    Given user at the "Регистрация" page2
    When user enters e-mail
    And 1000 char. password and repeat password
    And click "Зарегистрироваться"
    Then user should see registration page