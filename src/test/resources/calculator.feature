Feature: Using REST calculator.

  Scenario Outline: Adding two positive numbers.
    Given A Calculator
    When the user add <num1> and <num2>
    Then returns <result> as the sum
    Examples:
      | num1 | num2 | result |
      | 10   | 20   | 30     |
      | -3   | -4   | -7     |
      | -3   | 4    | 1      |
      | 3    | -4   | -1     |
      | 0    | 3    | 3      |
      | 0    | -3   | -3     |
