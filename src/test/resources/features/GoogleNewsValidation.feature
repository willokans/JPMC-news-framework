@regression
Feature: Google news validation

  Scenario: Validate News Feed on Google search
    Given John navigate to The Guardian news feed page
    And John needs to check other sources to confirm a news article is valid
    Then John can confirm the validity on the article on "google" search engine

  Scenario: Can not validate broken URL on Google search
    Given John navigate to a broken Guardian link
    Then John can't access The Guardian news