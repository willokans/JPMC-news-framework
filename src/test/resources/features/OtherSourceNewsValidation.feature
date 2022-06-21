@regression
Feature: Validate news on other news feed

  Scenario Outline: Confirm News from The Guardian is valid on <News Feeds>
    Given John navigate to The Guardian news feed page
    And John needs to check other sources to confirm a news article is valid
    Then John can confirm the validity of the article on the following source <News Feeds>
    Examples:
      | News Feeds |
      | theTimes   |
      | telegraph  |
      | BBC        |