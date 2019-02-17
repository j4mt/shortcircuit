@googlsearch
Feature: Google search feature sample

  Scenario Outline: A user can search on google home
  When I am on homepage
  And I search "<word>"
  Then is displayed "<resultLink>"

    Examples:
    |word|resultLink|
    |j4mt|https://github.com/j4mt|


