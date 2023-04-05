Feature: Test SVT Play

  Scenario:  SVT Play it should show  correct title
    Given SVT Play is available
    When User visits SVT Play
    Then The title should be "SVT Play"

  Scenario:
    Given SVT Play is available
    When User visits SVT Play
    Then The website logo is visible

  Scenario:
    Given SVT Play is available
    When User visits SVT Play
    Then test the MainLink "START"

  Scenario:
    Given SVT Play is available
    When User visits SVT Play
    Then test the second MainLink "KANALER"

  Scenario:
    Given SVT Play is available
    When User visits SVT Play
    Then test the third MainLink "PROGRAM"

  Scenario:
    Given SVT Play is available
    When User visits SVT Play
    Then test the Acessability

  Scenario:
    Given SVT Play is available
    When User visits SVT Play
    Then test the AcessabilityMainHeading

  Scenario:
    Given SVT Play is available
    When User visits SVT Play
    Then countTheGenre

  Scenario:
    Given SVT Play is available
    When User visits SVT Play
    Then test the Acessability for Kids

  Scenario:
    Given SVT Play is available
    When User visits SVT Play
    Then testContact

  Scenario:
    Given SVT Play is available
    When User visits SVT Play
    Then test NewsLetter

  Scenario:
    Given SVT Play is available
    When User visits SVT Play
    Then test the Settings

  Scenario:
    Given SVT Play is available
    When User visits SVT Play
    Then test Series
