Feature: Checking consultation
  @Launch
  Scenario Outline: first
    When the certificate number is entered "<NUMBER>"
    And the check button is clicked
    Then confirm "<RESULT>"
    Examples:
      | NUMBER   | RESULT |
      | 1232132  | false  |
      | 45924126 | true   |