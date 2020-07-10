
@MainSearchBar
Feature: Main Search Bar
  Background:
    When Accept the cookies

  @Connection
  @TC_04-LocationDismiss
  Scenario: Deleted the location services
    Then Enter current location
    And Show a error message for current location

  @TC-05-SuggestionCourse
  Scenario: Search a course
    When Enter a course in the search field
      | CourseNameAutoT |
   Then Show the courses list suggestions
      | CourseAutoT|

  @TC-06SuggestionCity
  Scenario: Search by a city
    When Enter a city in the search field
      | CityNameC |
    Then Show the city list suggestions
      | CityAutoC |

  @TC_07-DataPicker
  Scenario: Search by a date
    When Verify the current date
    Then Select one day
      |Fecha           |
      |FechaDataPicker |
    Then Select Done button

  @TC_07-PlayersSearch
  Scenario: Show Filters in the tee time screen
    Then Select the option Players
    When Select number of Players desired
      | FilterPlayers  |
      | PlayersFilters |
    Then Select Done button

  @TC_25-ShowHoles
  Scenario: Select Hole option
    And  Click on holes option
    And  Select the option Holes
      | Holes      |
      | NumberHole |
    Then Select Done button

  @TC-13InvalidData
  Scenario: Search by city or course invalid
    When Enter city or course invalid
      |InvalidCourse|
    Then Show the error message

  @TC-14InvalidZipCode
  Scenario: Search by zip code invalid
    When Enter zip code invalid
      |InvalidZipCode|
    Then Show zip code message error
