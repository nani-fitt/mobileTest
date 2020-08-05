@TeeTimeListingPage
Feature: Tee time listing page

Background:
  When Accept the cookies


  @TC_01-ShowDetailsTeeTime
  Scenario: Show details of the course
    When Enter a course in the search field
      | CourseNameAutoT |
    Then Show the courses list suggestions
      | CourseAutoT |
    And Made click on search button
    Then Verify name and address is present
      | Course      | Address        |
      | CourseNameT | AddressCourseT |
    Then Verify the save icon is present
    Then Verify the alert icon is present
    Then Verify Back to courses text link is displayed
    Then Click on Back to courses text link
    Then Verify the data for the courses is present

  @TC_02-ShowCourseInfo
  Scenario: Show the course info
    When Enter a course in the search field
      | CourseNameAutoT |
    Then Show the courses list suggestions
      | CourseAutoT |
    And Made click on search button
    Then Verify course info is present
    And Click course info icon
    Then Verify result course info

  @TC_03-CheckGolferReviewsLink
  Scenario: Check the course reviews link
    When Enter a course in the search field
      | CourseNameAutoT |
    Then Show the courses list suggestions
      | CourseAutoT |
    And Made click on search button
    Then Verify course reviews link
    And Click on golfer reviews
    And Verify Golfer reviews screen is opened


  @TC_04-CheckSaveIcon
  Scenario: Check functionality of save icon
    When Enter a course in the search field
      | CourseNameAutoT |
    Then Show the courses list suggestions
      | CourseAutoT |
    And Made click on search button
    Then Verify the save icon is present
    And Click on save icon
    Then Verify the message below Sign In


  @TC_05-CheckFavoriteIconSignIn
  Scenario: Check functionality of save icon made sign in before
    When Click on my account
    Then Select Sign In option
    And Enter correct email
      | EmailCorrect |
    And Enter valid password
      | PassCorrect |
    And Click on Login button
    When Enter a course in the search field
      | CourseNameAutoT |
    Then Show the courses list suggestions
      | CourseAutoT |
    And Made click on search button
    Then Verify the save icon is present
    And Click on save icon
    And Verify the color of icon change

  @TC_06-ShowAlertIconWithSignIn
  Scenario: Show functionality of alert ($) icon
    When Click on my account
    Then Select Sign In option
    And Enter correct email
      | EmailCorrect |
    And Enter valid password
      | PassCorrect |
    And Click on Login button
    When Enter a course in the search field
      | CourseNameAutoT |
    Then Show the courses list suggestions
      | CourseAutoT |
    And Made click on search button
    Then Verify the alert icon is present
    And Click on alert icon


  @TC_7-ShowAlertIcon
  Scenario: Show functionality of alert ($) icon
    When Enter a course in the search field
      | CourseNameAutoT |
    Then Show the courses list suggestions
      | CourseAutoT |
    And Made click on search button
    Then Verify the alert icon is present
    And Click on alert icon
    Then Verify the message below Sign In

  @TC_8-CheckSearchByOtherOptionPlayers
  Scenario: Change any criteria after search by a course
    When Enter a course in the search field
      | CourseNameAutoT |
    Then Show the courses list suggestions
      | CourseAutoT |
    And Made click on search button
    Then Verify the data for the courses is present
    When Click on search field
    When Verify the current date
    Then Select one day
      |Date           |
      |DateDataPicker |
    Then Select Done button
    Then Select the option Players
    When Select number of Players desired
      | PlayersFiltersT |
    Then Select Done button
    And Made click on search button
    Then Verify the result for the search
      | PlayersFiltersT |

  @TC_9-CheckSearchByOtherOptionHoles
  Scenario: Change any criteria after search by a course
    When Enter a course in the search field
      | CourseNameAutoT |
    Then Show the courses list suggestions
      | CourseAutoT |
    And Made click on search button
    Then Verify the data for the courses is present
    When Click on search field
    When Click on holes option
    And  Select the option Holes
      | NumberHoleT |
    And Made click on search button
    Then Select Done button
    Then Verify the result for the search for hole
      | NumberHoleT |

  @TC_10-CheckSearchByOtherOptionCourse
  Scenario: Change any criteria after search by a course
    When Enter a course in the search field
      | CourseNameAutoT |
    Then Show the courses list suggestions
      | CourseAutoT |
    And Made click on search button
    When Click on search field
    When Enter a course in the search field
      | CourseNameAutoT1 |
    Then Show the courses list suggestions
      | CourseAutoT1 |
    And Made click on search button
    Then Verify name and address is present
      | Course       | Address         |
      | CourseNameT1 | AddressCourseT1 |


  @TC_11-ShowNextIcon
  Scenario: Show the Next icon
    When Enter a course in the search field
      | CourseNameAutoT |
    Then Show the courses list suggestions
      | CourseAutoT |
    And Made click on search button
    Then Verify next icon is present
    And Click on next icon
    And Click on previous icon


  @TC_12-ShowFilterBy
  Scenario: Show in the left on the screen Filter by
    When Enter a course in the search field
      | CourseNameAutoT |
    Then Show the courses list suggestions
      | CourseAutoT |
    And Made click on search button
    Then Verify FilterBy is present





