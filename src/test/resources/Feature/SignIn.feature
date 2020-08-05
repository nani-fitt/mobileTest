@PostDeployValidationStaging
@SignIn
Feature: SignIN page

  Background:
    When Accept the cookies
    When Click on my account
    Then Select Sign In option


  @TC_01-ShowSignIn
  Scenario: Tap On Sign In option
    Then Verify the message below Sign In
    And Verify email is present
    And Verify password is present
    And Verify Keep me login is present

  @PostDeployValidation @TC_02-EmailIncorrect
  Scenario: Email invalid
    When Enter invalid email
      | EmailIncorrect |
    Then Verify the error message is present
    And Clean email field

  @TC_03-LoginDisable
  Scenario: Tap On Sign In button if the fields are empty.
    Then Verify the login button is disable

  @TC_04-PasswordField
  Scenario: Password field
    Then Enter password
      | pass |
    And Select Show option
    And Clear password field

  @PostDeployValidation @TC_05-EmailAndPasswordEmpty
  Scenario: Tap On Sign In button if email is entered
    And Enter correct email
      | EmailCorrect |
    Then Verify the login button is disable
    Then Verify the message is present for password

  @PostDeployValidation @TC_06-EmailAndPasswordInvalid
  Scenario: Tap On Sign In button if email is correct but password is wrong
    And Enter correct email
      | EmailCorrect |
    And Enter Invalid password
      | PasswordShow |
    And Click on Login button
    Then Verify the message error

  @PostDeployValidation @TC_07-EmailAndPasswordInvalid
  Scenario: Tap On Sign In button if password is correct but email is wrong
    And Enter invalid email
      | EmailIncorrect |
    And Enter valid password
      | PassCorrect |
    Then Verify the error message is present

  @PostDeployValidation @TC_08-VerifyForgotPassword
  Scenario: Show the functionality of Forgot password
    And Select Forgot Password Link
    Then Verify the Reset Password is present
    When Enter correct email
      | EmailCorrectC |
    Then Verify the windows for confirmation is displayed

  @PostDeployValidation @TC_09-VerifyForgotPasswordInvalid
  Scenario: Forgot password email invalid
    And Select Forgot Password Link
    Then Verify the Reset Password is present
    When Enter invalid email
      | EmailIncorrect |
    Then Verify the windows for error message

  @PostDeployValidation @TC_10-SignInWithFacebook
  Scenario: Sign In with Facebook
    When Select Facebook option
      | EmailFacebook| PassFacebook |
    When Verify the current date

  @TC_11-SignInWithFacebookInvalid
  Scenario: Sign In with Facebook invalid
    When Select Facebook option incorrect
      | EmailFacebook| EmailFacebookIncorrect |


  @PostDeployValidation @TC_12-SignInCreateAccount
  Scenario: Tap on Create Account
    Then Select SignUp link
    Then Check the Sign Up popup is present

  @PostDeployValidation @TC_13-SignInWithGoogle
  Scenario: Sign In with google
    When Select Google option and enter credentials
      | EmailGoogle| PassGoogle |
    When Verify the current date



  @TC_14-SignInWithGoogleInvalidData
  Scenario: Sign In with google
    When Select Google option and enter credentials
      | EmailGoogle| PassGoogleInvalid |


  @PostDeployValidation @TC_15-SignInWithGoogleUsed
  Scenario: Sign In with google used
    When Select Google option and enter credentials
      | EmailGoogleUsed| PassGoogleUsed |
    When Verify error message google used

  @PostDeployValidation @TC_16-EmailAndPasswordCorrect
  Scenario: Made a Sign In correct
    And Enter correct email
      | EmailCorrectC |
    And Enter valid password
      | PassCorrectC |
    And Click on Login button
    Then Verify the current location is displayed
    When Click on menu header
    And Click on Bookings menu

  @PostDeployValidation @TC_17-MadeAsignOUt
  Scenario: Made a Sign Out correct
    And Enter correct email
      | EmailCorrectC |
    And Enter valid password
      | PassCorrectC |
    And Click on Login button
    Then Verify the current location is displayed
    When Click on menu header
    And Click on SignOut button

  @TC_08-SignInWithApple
  Scenario: Sign In with apple
    When Select Apple option and enter credentials
      | EmailApple| PassApple |
    Then Verify the home page is displayed

