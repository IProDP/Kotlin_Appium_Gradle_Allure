Feature: Successful application launch AppOne
  As a user, I want to be able to review the direction of the application in order to make a decision about registration

  Background:
    Given First description "People help People" displayed on the main screen


  @Smoke
  Scenario: Successful start of the application.
    Then Second description "Volunteering community to help those in need in Ukraine with humanitarian purposes" displayed on the main screen
    Then "LET’S GO!" button displayed on the main screen
    Then LET’S GO! button clickable on the main screen
