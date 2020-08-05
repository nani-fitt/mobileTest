
@MainSearchBar
Feature: Main Search Bar
  Background:
    When Accept the cookies

  @Connection
  @TC_01-LocationDismiss
  Scenario: Deleted the location services
    Then Enter current location
    And Show a error message for current location

  @TC-02-SuggestionCourse
  Scenario: Search a course
    When Enter a course in the search field
      | CourseNameAutoA |
   Then Show the courses list suggestions
      | CourseAutoA|

  @TC-03SuggestionCity
  Scenario: Search by a city
    When Enter a city in the search field
      | CityNameCA |
    Then Show the city list suggestions
      | CityAutoCA |

  @TC_04-DataPicker
  Scenario: Search by a date
    When Verify the current date
    Then Select one day
      |Date            |
      |DateDataPickerA |
    Then Select Done button

  @TC_05-PlayersSearch
  Scenario: Show Filters in the tee time screen
    Then Select the option Players
    When Select number of Players desired
      | PlayersFiltersA |
    Then Select Done button

  @TC_6-ShowHoles
  Scenario: Select Hole option
    And  Click on holes option
    And  Select the option Holes
      | NumberHoleA |
    Then Select Done button

  @TC-7InvalidData
  Scenario: Search by city or course invalid
    When Enter city or course invalid
      |InvalidCourse|
    Then Show the error message

  @TC-8InvalidZipCode
  Scenario: Search by zip code invalid
    When Enter zip code invalid
      |InvalidZipCode|
    Then Show zip code message error
