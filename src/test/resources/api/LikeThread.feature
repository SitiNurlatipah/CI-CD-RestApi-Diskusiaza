@nyoba
Feature: As a user i can like or unlike thread

  Scenario: User like a thread
    Given user success auth using token
    When user post like thread endpoints
    And user input thread id
    Then user succes like thread with respon code 200
    And user got message "anda berhasil menyukai therad ini"

  Scenario: User unlike a thread
    Given user success auth using token1
    When user delete like thread endpoints
    And user input thread id2
    Then user succes unlike thread with respon code 200
    And user got massage2 "anda berhasil unlike therad ini"

