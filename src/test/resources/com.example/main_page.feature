Feature: Main page functionality

  @positive
  Scenario: User create new task
    Given user is on the main page
    When user click new task button
    And create new task
    Then new task is generate

#  Scenario: User create 2 new Tasks
#    Given user is on the main page
#    When user add 2 tasks on the board
#    | buy hockey tickets|
#    |finish repairing the motorcycle|
#    Then 3 tasks on the board
#
#  Scenario: User delete 1 task
#    Given user is on the main page
#    When user delete  1 task "car repairs"
#    Then left 2 task on the board
#
#  Scenario: User delete all tasks
#    Given user is on the main page
#    When user delete all tasks
#    Then the board is empty
#
#  @negative
#  Scenario: User create new task
#    Given user is on the main page
#    When user click new task button
#    And  create a empty task
#    Then new task can not generate