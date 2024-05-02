Feature: Update Consumed Time in Activity

  Scenario: Input consumed time is less than or equal to zero
    Given an activity with no consumed time
    When I try to update the consumed time with -0.5 hours
    Then I receive the error "Consumed time must be greater than 0.5 hours"

  Scenario: Input consumed time is not a multiple of 0.5
    Given an activity with no consumed time
    When I try to update the consumed time with 0.3 hours
    Then I receive an error "Invalid input. Please ensure your time is in increments of 0.5"

  Scenario: Valid consumed time input
    Given an activity with initial consumed time of 1.0 hours
    When I update the consumed time with 1.0 hours
    Then the total consumed time for the activity should be 2.0 hours
