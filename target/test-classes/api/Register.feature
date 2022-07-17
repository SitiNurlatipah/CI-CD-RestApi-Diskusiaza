Feature: As a user on register page

  Scenario: User register with valid data
    Given user post regist endpoint1
    When user regist using valid data
    Then user succes regist respon 200 OK on regist 1
    And user get a message proses register berhasil

  Scenario: User register but no input firstname
    Given user post regist endpoint2
    When user regist using empty firstname
    Then user unsucces regist respon 400 OK on regist 2
    And user get a message2 ada inputan yang tidak sesuai

  Scenario: User register but no input lastname
    Given user post regist endpoint3
    When user regist using empty lastname
    Then user unsucces regist respon 400 Bad Request on regist 3
    And user get a message3 ada inputan yang tidak sesuai

  Scenario: User register but no input email
    Given user post regist endpoint4
    When user regist using empty email
    Then user unsucces regist respon 400 Bad Request on regist 4
    And user get a message4 ada inputan yang tidak sesuai

  Scenario: User register but no input password
    Given user post regist endpoint5
    When user regist using empty password
    Then user unsucces regist respon 400 Bad Request on regist 5
    And user get a message5 ada inputan yang tidak sesuai

  Scenario: User register but no input tanggal lahir
    Given user post regist endpoint6
    When user regist using empty tanggal lahir
    Then user unsucces regist respon 400 Bad Request on regist 6
    And user get a message6 ada inputan yang tidak sesuai

  Scenario: User register but no input jenis kelamin
    Given user post regist endpoint7
    When user regist using empty jenis kelamin
    Then user unsucces regist respon 400 Bad Request on regist 7
    And user get a message7 ada inputan yang tidak sesuai

