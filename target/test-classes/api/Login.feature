Feature: As a user on login page

  Scenario: User input valid email and password
    Given user post login endpoints
    When user login with valid email and valid password
    Then user succes login respon 200 OK on login 1

  Scenario: User input valid email and unvalid password
    Given user post login endpoints2
    When user login with valid email and unvalid password
    Then user unsucces login respon 401 on login 2
    And user receive message email atau password salah

  Scenario: User input unvalid email and valid password
    Given user post login endpoints3
    When user login with unvalid email and valid password
    Then user unsucces login respon 401 on login 3
    And user receive message2 email atau password salah

  Scenario: User input unvalid email and unvalid password
    Given user post login endpoints4
    When user login with unvalid email and unvalid password
    Then user unsucces login respon 401 on login 4
    And user receive message3 email atau password salah




