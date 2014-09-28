Feature: Using REST calculator.

  Scenario: Adding two positive numbers.
    Given A Calculator
    When the user add 10 and 20 
    Then returns 30 as the sum