Feature: Successful launch Home Page
  As a user, I want to be able to review Start page of the site

  Background:
    Given Home page opened

  @Smoke
  Scenario: Successful launch Home Page.
    Then "About us" button is displayed on the Home page
    When I clicked on the About us button
