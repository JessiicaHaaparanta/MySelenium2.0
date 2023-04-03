Feature: Test SVT Play

  Scenario: SVT Play should show correct title
    Given SVT Play is available
    When User visits SVT Play
    Then The title should be "SVT Play"