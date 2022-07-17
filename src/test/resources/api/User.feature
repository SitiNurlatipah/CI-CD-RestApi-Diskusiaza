Feature: User

  Scenario: get all data users
    Given user success auth using token a
    When user set get all user endpoints
    And user send get all user endpoints
    Then user get 1 respon code 200

  Scenario: get data followers details
    Given user success auth using token b
    When user set get followers details endpoints
    And user send get followers details endpoints
    Then user get 2 respon code 200
    And user get message details followers

  Scenario: get data following details users
    Given user success auth using token c
    When user set get following details endpoints
    And user send get following details endpoints
    Then user get 3 respon code 200
    And user get message details following

