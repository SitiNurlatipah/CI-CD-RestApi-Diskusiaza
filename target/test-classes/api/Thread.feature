@thread
Feature: As a user on category thread

  Scenario: User get thread category
    Given user kategori success auth using token
    When user set get category thread endpoints
    And user send get category thread endpoints
    Then user get respon code 200
    And user receive details category thread

  Scenario: User get all thread
    Given user success auth using token3
    And user set get all thread endpoints
    When user send get all thread endpoints
    Then user get response code2 200
    And user receive details all thread

  Scenario: User get thread by id
    Given user success auth using token4
    And user set get thread by id endpoints
    When user send get thread by id endpoints
    Then user get response code3 200
    And user receive thread by id

  Scenario: User get thread by kategori
    Given user success auth using token 5
    And user set get thread by kategori endpoints
    When user send get thread by kategori endpoints
    Then user get response code4 200
    And user receive thread by kategori

  Scenario: User get trending thread
    Given user success auth using token 6
    And user set get thread trending endpoints
    When user send get thread trending endpoints
    Then user get response code5 200
    And user receive thread trending

