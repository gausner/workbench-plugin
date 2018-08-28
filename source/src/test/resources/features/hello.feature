Feature: Test Applicant approval

  Scenario Outline: Applicant Old With Money
    Given applicant is <age> years old and has <investment> dollars investment
    When I run the rules
    Then approved
    Examples:
      | age | investment |
      | 18  | 32         |
      | 21  | 29         |