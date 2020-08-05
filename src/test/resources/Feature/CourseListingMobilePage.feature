
@CourseListingPage
Feature: Course listing page

  Background:
    When Accept the cookies
    When Enter a course in the search field
      | CityName  |
    Then Show the courses list suggestions
      | CityAuto |
    And Made click on search button

  @TC_02-ShowCourseListingPageOptions
  Scenario: Check Sort by distance is selected
    And Check Sort by dropdown is displayed
    Then Check Map button is present
    Then Verify the data for the courses is present
    Then Verify the next and previous button are displayed
    Then Verify list of courses in the screen

  @TC_03-ClickOnNextButton
  Scenario: Click Next button
    Then Click on next button
    Then Click on previous button

  @TC_04-ShowMapView
  Scenario: Check map view is present
    Then Select the option map view
    Then Select Max view
    Then Select Min view
    Then Select a course in the map view
    Then Verify tee time page is displayed


  @TC_05-MadeASearchByZipCode
  Scenario: Made a search by zipCode
    When Click on search field
    When Enter a course in the search field
      | ZipCode  |
    Then Show the courses list suggestions
      | CityAutoZ |
    And  Made click on search button
    Then Verify the data for the courses is present




