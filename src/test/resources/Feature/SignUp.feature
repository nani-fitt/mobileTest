@PostDeployValidationStaging
@SignUp
Feature: SignUp page
  Sign Up execution test cases

  Background:
    When Accept the cookies
    When Click on my account
    Then Select Sign In option
    Then Select SignUp link
    Then Check the Sign Up popup is present

  @TC_01-ShowSignUp
  Scenario: Tap On Sign Up option
    Then Verify the message below Sign Up
    And Click on enter email field
    And Verify FirstName is present
    And Verify LastName is present
    And Verify ZipCode is present
    And Verify Email is present
    And Verify Password is present
    And Verify Referral Code is present

  @PostDeployValidation @TC_02-MadeASignUp
  Scenario Outline: Sign Up enter the valid data
    Then Click on enter email field
    When Enter the data "<firstname>" "<lastname>" "<zipcode>" "<email>" "<password>"
    And Select Show option
    And Click on Create Account Button
    And Verify Welcome SG screen
    And Click on welcome button
    Then Verify the home page is displayed
    When Click on menu header
    And Click on SignOut button
    Examples:
      | firstname | lastname | zipcode | email | password |
      | Firstname | Lastname | zipcode | email | password |



  @PostDeployValidation @TC_03-ValidationForPassword
  Scenario Outline: Check password validation
    Then Click on enter email field
    When Enter the data "<firstname>" "<lastname>" "<zipcode>" "<email>" "<password>"
    Then Verify log for the characteres
    And Verify at least one uppercase and lowercase letter
    And Verify at least one number

    Examples:
      | firstname | lastname | zipcode | email | password  |
      | Firstname | Lastname | zipcode | email | passwordI |

  @PostDeployValidation @TC_04-MadeASignUpEmailUsedInOtherAccount
  Scenario Outline: Sign Up using another account
    Then Click on enter email field
    When Enter the data invalid "<firstname>" "<lastname>" "<zipcode>" "<email>" "<password>"
    Then Verify the message for account used is present
    Then Click on Sign In link since sign up screen
    Then Verify the message below Sign In
    And Enter correct email
      | EmailCorrectC |
    And Enter valid password
      | PassCorrectC |
    And Click on Login button
    Then Verify the current location is displayed
    Examples:
      | firstname | lastname | zipcode | email     | password  |
      | Firstname | Lastname | zipcode | emailUsed | password  |

  @TC_05-SignInWithFacebook
  Scenario: Sign In with Facebook
    Then Verify the message below Sign Up
    When Select Facebook option
      | EmailFacebook1| PassFacebook |
    And Verify Welcome SG screen
    And Click on welcome button
    Then Verify the home page is displayed

  @TC_06-SignInWithFacebookInvalid
  Scenario: Sign In with Facebook invalid
    Then Verify the message below Sign Up
    When Select Facebook option incorrect
      | EmailFacebook| EmailFacebookIncorrect |


  @TC_07-SignInWithGoogle
  Scenario: Sign In with google
    Then Verify the message below Sign Up
    When Select Google option and enter credentials
      | EmailGoogleNew| PassGoogleNew |
    And Verify Welcome SG screen
    And Click on welcome button
    Then Verify the home page is displayed

  @PostDeployValidation @TC_08-SignInWithGoogleSameCredentials
  Scenario: Sign In with google using credentials registered in the app
    Then Verify the message below Sign Up
    When Select Google option and enter credentials
      | EmailGoogleUsed| PassGoogle |
    Then Verify Message email taken is displayed


  @TC_09-SignInWithGoogleInvalidData
  Scenario: Sign In with google
    Then Verify the message below Sign Up
    When Select Google option and enter credentials
      | EmailGoogle| PassGoogleInvalid |


  @PostDeployValidation @TC_10-VerifyMessageForEmptyField
  Scenario Outline: Verify message for empty field
    Then Verify the message below Sign Up
    And Click on enter email field
    When Enter the data invalid "<firstname>" "<lastname>" "<zipcode>" "<email>" "<password>"
    Then Verify message for field empty
    Then Verify the Create Account button is disable
    Then Click on Sign In link since sign up screen
    Then Verify the message below Sign In
    And Verify email is present
    And Verify password is present
    And Verify Keep me login is present
    Examples:
      | firstname      | lastname | zipcode           | email      | password |
      | NameEmptySignUp| LastName | ZipCodEmptySignUp | EmailEmpty | passwordI|

