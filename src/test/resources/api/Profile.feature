@profil
Feature: As a user on profil page

  Scenario: User get data profile
    Given user login and success auth using token
    When user set get profile endpoints
    And user send get profile endpoints
    Then user get profile respon code 200
    And user get valid data profile

  Scenario: User get my thread
    Given user success auth using token 7
    When user set get user thread endpoints
    And user send get user thread endpoints
    Then user get profile respon7 code 200

  Scenario: User delete my thread
    Given user success auth using token 8
    When user set delete user thread endpoints
    And user send delete user thread endpoints
    Then user get profile respon8 code 200
    And user get message delete succes




