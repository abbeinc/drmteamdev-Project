
Feature: As a user I have to be able register on the website

  Scenario:
    Given user at the "Главная" page
    When user click "Зарегистрироваться"
    Then user should see page with a title "Регистрация"

    Scenario:
      Given user at the "Регистрация" page2
      When user click registration button without email and password
      Then user should see warning "Email не может быть пустым"



    Scenario:
      Given user at the "Регистрация" page2
      When user enters e-mail
      And password and repeat password
      And click "Зарегистрироваться"
      Then user should see "User has been successfully created, check your email"

  @bla
      Scenario:
        Given user at the "Регистрация" page2 trying to create with the same credentials
        When user enters existing e-mail and password
        Then user should see alert "User already exist" message