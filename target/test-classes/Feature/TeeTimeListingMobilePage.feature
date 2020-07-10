@TeeTimeListingPage
Feature: Tee time listing page

Background:
  When Accept the cookies

  @TC_02-ShowDetailsTeeTime
  Scenario: Show details of the course
    When Enter a course in the search field
      | CourseNameAutoT |
    Then Show the courses list suggestions
      | CourseAutoT1 |
    And Made click on search button
    Then Verify name and address is present
      | Course       | Address         |
      | CourseNameT1 | AddressCourseT1 |
    Then Verify the save icon is present
    Then Verify the alert icon is present
    Then Verify Back to courses text link is displayed
    Then Click on Back to courses text link
    Then Verify the data for the courses is present

  @TC_03-ShowCourseInfo
  Scenario: Show the course info
    When Enter a course in the search field
      | CourseNameAutoT |
    Then Show the courses list suggestions
      | CourseAutoT |
    And Made click on search button
    Then Verify course info is present
    And Click course info icon
    Then Verify result course info

  @TC_05-CheckGolferReviewsLink
  Scenario: Check the course reviews link
    When Enter a course in the search field
      | CourseNameAutoT |
    Then Show the courses list suggestions
      | CourseAutoT |
    And Made click on search button
    Then Verify course reviews link
    And Click on golfer reviews
    And Verify Golfer reviews screen is opened


  @TC_07-CheckSaveIcon
  Scenario: Check functionality of save icon
    When Enter a course in the search field
      | CourseNameAutoT |
    Then Show the courses list suggestions
      | CourseAutoT |
    And Made click on search button
    Then Verify the save icon is present
    And Click on save icon
    Then Verify the message below Sign In


  @TC_08-CheckFavoriteIconSignIn
  Scenario: Check functionality of save icon made sign in before
    When Click on Profile button
    And Click on Sign In button
    And Enter correct email
      | EmailCorrectT |
    And Enter valid password
      | PassCorrectT |
    And Click on Login button
    When Enter a course in the search field
      | CourseNameAutoT |
    Then Show the courses list suggestions
      | CourseAutoT1 |
    And Made click on search button
    Then Verify the save icon is present
    And Click on save icon
    And Verify the color of icon change

  @TC_09-ShowAlertIconWithSignIn
  Scenario: Show functionality of alert ($) icon
    When Click on Profile button
    And Click on Sign In button
    And Enter correct email
      | EmailCorrectT |
    And Enter valid password
      | PassCorrectT |
    And Click on Login button
    When Enter a course in the search field
      | CourseNameAutoT |
    Then Show the courses list suggestions
      | CourseAutoT1 |
    And Made click on search button
    Then Verify the alert icon is present
    And Click on alert icon
    And Verify alerts screen is displayed

  @TC_10-ShowAlertIcon
  Scenario: Show functionality of alert ($) icon
    When Enter a course in the search field
      | CourseNameAutoT |
    Then Show the courses list suggestions
      | CourseAutoT1 |
    And Made click on search button
    Then Verify the alert icon is present
    And Click on alert icon
    Then Verify the message below Sign In

  @TC_12-CheckSearchByOtherOptionPlayers
  Scenario: Change any criteria after search by a course
    When Enter a course in the search field
      | CourseNameAutoT |
    Then Show the courses list suggestions
      | CourseAutoT1 |
    And Made click on search button
    Then Verify the data for the courses is present
    When Click on search field
    When Verify the current date
    Then Select one day
      |Fecha           |
      |FechaDataPicker |
    Then Select Done button
    Then Select the option Players
    When Select number of Players desired
      | FilterPlayers  |
      | PlayersFilters |
    Then Select Done button
    And Made click on search button
    Then Verify the result for the search

  @TC_13-CheckSearchByOtherOptionHoles
  Scenario: Change any criteria after search by a course
    When Enter a course in the search field
      | CourseNameAutoT |
    Then Show the courses list suggestions
      | CourseAutoT1 |
    And Made click on search button
    And Select in the main search option holes
    And Made click on search button
    Then Verify the result for the search for hole

  @TC_16-CheckSearchByOtherOptionCourse
  Scenario: Change any criteria after search by a course
    When Enter a course in the search field
      | CourseNameAutoT |
    Then Show the courses list suggestions
      | CourseAutoT1 |
    And Made click on search button
    When Enter a course in the search field
      | CourseNameAutoT |
    Then Show the courses list suggestions
      | CourseAutoT2 |
    And Made click on search button
    Then Verify name and address is present
      | Course       | Address         |
      | CourseNameT2 | AddressCourseT2 |


  @TC_19-ShowNextIcon
  Scenario: Show the Next icon
    When Enter a course in the search field
      | CourseNameAutoT |
    Then Show the courses list suggestions
      | CourseAutoT1 |
    And Made click on search button
    Then Verify next icon is present
    And Click on next icon

  @TC_20-ShowPreviousIcon
  Scenario: Show the Previous icon
    When Enter a course in the search field
      | CourseNameAutoT |
    Then Show the courses list suggestions
      | CourseAutoT1 |
    And Made click on search button
    Then Verify previous icon is present
    And Click on previous icon

  @TC_23-ShowFilterBy
  Scenario: Show in the left on the screen Filter by
    When Enter a course in the search field
      | CourseNameAutoT |
    Then Show the courses list suggestions
      | CourseAutoT1 |
    And Made click on search button
    Then Verify FilterBy is present

  @TC_27-ShowFooter
  Scenario: Check that footer at the button is present
    When Enter a course in the search field
      | CourseNameAutoT |
    Then Show the courses list suggestions
      | CourseAutoT1 |
    And Made click on search button
    Then Verify footer is present

  @TC_28-DealsButton
  Scenario: Show Deals only tee time
    When Enter a course in the search field
      | CourseNameAutoT |
    Then Show the courses list suggestions
      | CourseAutoT1 |
    And Made click on search button
    And Click on next icon
    Then Verify the deals button is displayed
    And Click on Deals button
    And Check the result for tee time

