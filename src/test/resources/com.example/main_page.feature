Feature: Main page functionality

  @positive
  Scenario: User create new task
    Given user is on the main page
    When create new task
    Then new task is generate

  Scenario: User create 2 new Tasks
    Given user is on the main page
    When user add 2 tasks on the board
    Then  2 tasks on the board

  Scenario: User delete a task
    Given user is on the main page
    When user delete a task
    Then left 1 task on the board

  Scenario: User delete all tasks
    Given user is on the main page
    When user delete all tasks
    Then the board is empty

  @negative
  Scenario: User create new task
    Given user is on the main page
    When user create a empty task
    Then new task can not generate