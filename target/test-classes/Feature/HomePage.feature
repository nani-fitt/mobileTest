
@HomePageHeader
Feature: Home page header

  Background:
    When Accept the cookies

  @TC_01-SGLogo
  Scenario: Show the Supreme Golf Logo
    Then Verify that Supreme Golf logo is displayed
    Then Verify that Menu header is displayed
    Then Verify that Search component is displayed

  @TC_02-Menu
  Scenario: Show menu header
    When Click on menu header
    Then Verify the menu options are present








