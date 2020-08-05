@PostDeployValidationStaging
@CheckoutScreen
Feature: Checkout Screen

  Background:
    When Accept the cookies


  @TC_1CheckoutScreenTest
  Scenario Outline: Checkout Screen
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
    Then Click on next button
    Then Click on next button
    And Select the tee time desired "<Time>"
    Then Click on any Rate type "<Rate>"
    Then Verify the provider screen is displayed
    When Select one provider
    Then Verify checkout screen is present
    When Select number of Players desired
      | PlayersNumberFiltersCheckout |
    When Values checkout after select players
      | PlayersNumberFiltersCheckout |
    Then Select Book now button
    And Verify the Confirmation screen is displayed
    Examples:
      | Time       | Rate       |
      | TimeSelect | RateSelect |

  @TC_2CheckoutScreenWithoutCreditCard
  Scenario Outline: Checkout Screen without credit cards add
    When Click on my account
    Then Select Sign In option
    Then Select SignUp link
    Then Check the Sign Up popup is present
    Then Click on enter email field
    When Enter the data "<firstname>" "<lastname>" "<zipcode>" "<email>" "<password>"
    And Select Show option
    And Click on Create Account Button
    And Verify Welcome SG screen
    And Click on welcome button
    When Enter a course in the search field
      | CourseNameAutoT |
    Then Show the courses list suggestions
      | CourseAutoT |
    And Made click on search button
    Then Click on next button
    Then Click on next button
    And Select the tee time desired "<Time>"
    Then Click on any Rate type "<Rate>"
    Then Verify the provider screen is displayed
    When Select one provider
    Then Verify checkout screen is present
    And Verify the button Add new is present
    When Click on Add New button
    And Enter full name
      | Name |
    And Enter credit card
      | NumberCreditCards |
    And Enter Exp years
      | ExpYears |
    And Enter CVV
      | CVV |
    And Enter zip code
      | ZipCodeC |
    When Click on Add New Credit Card button
    Then Select Book now button
    And Verify the Confirmation screen is displayed

    Examples:
      | firstname | lastname | zipcode | email | password |  Time       | Rate       |
      | Firstname | Lastname | zipcode | email | password |  TimeSelect | RateSelect |

  @TC_3CheckoutScreenPaymentMethodsIncorrect
  Scenario Outline: Checkout Screen add Payment methods incorrect
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
    Then Click on next button
    Then Click on next button
    And Select the tee time desired "<Time>"
    Then Click on any Rate type "<Rate>"
    Then Verify the provider screen is displayed
    When Select one provider
    Then Verify checkout screen is present
    When Click on change credit cards
    When Click on Add New Credit Card button
    And Enter full name
      | Name      |
    And Enter credit card
      | IncorrectCreditCards |
    And Enter Exp years
      | ExpYears  |
    And Enter CVV
      | CVV |
    And Enter zip code
      | ZipCodeC |
    And Verify the message for credit card incorrect is displayed
    Examples:
      | Time       | Rate       |
      | TimeSelect | RateSelect |

  @TC_04-BackVerifyBackProvider
  Scenario Outline: Display the link off text Back to provider
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
    Then Click on next button
    Then Click on next button
    And Select the tee time desired "<Time>"
    Then Click on any Rate type "<Rate>"
    Then Verify the provider screen is displayed
    When Select one provider
    Then Verify checkout screen is present
    And Verify Back to provider link is present
    When Click on Back to provider link
    Then Verify the provider screen is displayed
    Examples:
      | Time       | Rate       |
      | TimeSelect | RateSelect |



  @TC_5CheckoutScreenPaymentMethodsChange
  Scenario Outline: Checkout Screen add Payment methods change credit card
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
    Then Click on next button
    Then Click on next button
    And Select the tee time desired "<Time>"
    Then Click on any Rate type "<Rate>"
    Then Verify the provider screen is displayed
    When Select one provider
    Then Verify checkout screen is present
    When Click on change credit cards
    And Selected the credit card desired
    Then Select Book now button
    And Verify the Confirmation screen is displayed
    Examples:
      | Time       | Rate       |
      | TimeSelect | RateSelect |


  @TC_6CheckoutBookingWithoutSignIn
  Scenario Outline: Checkout Screen without signIn
    When Enter a course in the search field
      | CourseNameAutoT |
    Then Show the courses list suggestions
      | CourseAutoT |
    And Made click on search button
    Then Click on next button
    Then Click on next button
    And Select the tee time desired "<Time>"
    Then Click on any Rate type "<Rate>"
    Then Verify the provider screen is displayed
    When Select one provider
    Then Verify the message below Sign In
    And Enter correct email
      | EmailCorrect |
    And Enter valid password
      | PassCorrect |
    And Click on Login button
    Then Verify checkout screen is present
    Then Select Book now button
    And Verify the Confirmation screen is displayed
    Examples:
      | Time       | Rate       |
      | TimeSelect | RateSelect |

  @TC_7CheckoutBookingWithoutSignUp1
  Scenario Outline: Checkout Screen without signUp
    When Enter a course in the search field
      | CourseNameAutoT |
    Then Show the courses list suggestions
      | CourseAutoT |
    And Made click on search button
    Then Click on next button
    Then Click on next button
    Then Click on next button
    And Select the tee time desired "<Time>"
    Then Click on any Rate type "<Rate>"
    Then Verify the provider screen is displayed
    When Select one provider
    Then Verify checkout screen is present
    Then Verify the message below Sign In
    Then Select SignUp link
    Then Click on enter email field
    When Enter the data "<firstname>" "<lastname>" "<zipcode>" "<email>" "<password>"
    And Select Show option
    And Click on Create Account Button
    And Verify Welcome SG screen
    And Click on welcome button
    Then Verify checkout screen is present
    And Verify the button Add new is present
    When Click on Add New button
    And Enter full name
      | Name      |
    And Enter credit card
      | NumberCreditCards |
    And Enter Exp years
      | ExpYears  |
    And Enter CVV
      | CVV |
    And Enter zip code
      | ZipCodPay |
    When Click on Add New Credit Card button
    Then Select Book now button
    And Verify the Confirmation screen is displayed
    Examples:
      | firstname | lastname | zipcode | email | password | Time       | Rate      |
      | Firstname | Lastname | zipcode | email | password | TimeSelect | RateSelect|


  @TC_8CheckoutBookingWithGoogleUser
  Scenario Outline: Checkout Screen without signUp with google
    When Enter a course in the search field
      | CourseNameAutoT |
    Then Show the courses list suggestions
      | CourseAutoT |
    And Made click on search button
    Then Click on next button
    Then Click on next button
    And Select the tee time desired "<Time>"
    Then Click on any Rate type "<Rate>"
    Then Verify the provider screen is displayed
    When Select one provider
    Then Verify the message below Sign In
    When Select Google option and enter credentials
      | EmailGoogle | PassGoogle |
    When Verify the current date
    When Enter a course in the search field
      | CourseNameCheckout |
    Then Show the courses list suggestions
      | CourseAutoCheckout |
    And Made click on search button
    Then Click on next button
    Then Click on next button
    And Select the tee time desired "<Time>"
    Then Click on any Rate type "<Rate>"
    Then Verify the provider screen is displayed
    When Select one provider
    Then Verify checkout screen is present
    Then Select Book now button
    And Verify the Confirmation screen is displayed
    When Click on Done
    Examples:
      | Time       | Rate       |
      | TimeSelect | RateSelect |


  @TC_9CheckoutBookingWithGoogleSignUp
  Scenario Outline: Checkout Screen without signUp google since provider
    When Enter a course in the search field
      | CourseNameAutoT |
    Then Show the courses list suggestions
      | CourseAutoT |
    And Made click on search button
    Then Click on next button
    Then Click on next button
    And Select the tee time desired "<Time>"
    Then Click on any Rate type "<Rate>"
    Then Verify the provider screen is displayed
    When Select one provider
    Then Verify the message below Sign In
    When Select Google option and enter credentials
      | EmailGoogleNew | PassGoogleNew |
    And Verify Welcome SG screen
    And Click on welcome button
    Then Verify checkout screen is present
    And Verify the button Add new is present
    When Click on Add New button
    And Enter full name
      | Name      |
    And Enter credit card
      | NumberCreditCards |
    And Enter Exp years
      | ExpYears  |
    And Enter CVV
      | CVV |
    And Enter zip code
      | ZipCodeC |
    When Click on Add New Credit Card button
    Then Select Book now button
    And Verify the Confirmation screen is displayed
    Examples:
      | Time       | Rate       |
      | TimeSelect | RateSelect |

  @TC_10CheckoutBookingWithGoogle1
  Scenario Outline: Checkout Screen without signUp
    When Click on my account
    Then Select Sign In option
    Then Verify the message below Sign In
    When Select Google option and enter credentials
      | EmailGoogle | PassGoogle |
    When Verify the current date
    When Enter a course in the search field
      | CourseNameAutoT |
    Then Show the courses list suggestions
      | CourseAutoT |
    And Made click on search button
    Then Click on next button
    Then Click on next button
    And Select the tee time desired "<Time>"
    Then Click on any Rate type "<Rate>"
    Then Verify the provider screen is displayed
    When Select one provider
    Then Verify checkout screen is present
    Then Select Book now button
    And Verify the Confirmation screen is displayed
    When Click on Done
    Examples:
      | Time       | Rate       |
      | TimeSelect | RateSelect |


  @TC_11CheckoutBookingWithFacebook
  Scenario Outline: Checkout Screen without signUp
    When Enter a course in the search field
      | CourseNameAutoT |
    Then Show the courses list suggestions
      | CourseAutoT |
    And Made click on search button
    Then Click on next button
    Then Click on next button
    And Select the tee time desired "<Time>"
    Then Click on any Rate type "<Rate>"
    Then Verify the provider screen is displayed
    When Select one provider
    Then Verify checkout screen is present
    Then Verify the message below Sign In
    When Select Facebook option
      | EmailFacebook | PassFacebook |
    When Verify the current date
    When Enter a course in the search field
      | CourseNameCheckout |
    Then Show the courses list suggestions
      | CourseAutoCheckout |
    And Made click on search button
    Then Click on next button
    Then Click on next button
    And Select the tee time desired "<Time>"
    Then Click on any Rate type "<Rate>"
    Then Verify the provider screen is displayed
    When Select one provider
    Then Verify checkout screen is present
    When Click on change credit cards
    And Verify the button Add new is present
    When Click on Add New button
    And Enter full name
      | Name      |
    And Enter credit card
      | NumberCreditCards |
    And Enter Exp years
      | ExpYears  |
    And Enter CVV
      | CVV |
    And Enter zip code
      | ZipCodeC |
    When Click on Add New Credit Card button
    Then Select Book now button
    And Verify the Confirmation screen is displayed
    When Click on Done
    When Click on menu header
    And  Click on MYy SG dashboard
    And  Select Payment Methods options
    When Click on Remove option
    Then Verify the credit card was deleted
    Examples:
      | Time       | Rate       |
      | TimeSelect | RateSelect |


  @12-ErrorMessages
  Scenario Outline: Checkout Screen error messages
    When Enter a course in the search field
      | CourseNameAutoT |
    Then Show the courses list suggestions
      | CourseAutoT |
    And Made click on search button
    Then Click on next button
    Then Click on next button
    Then Click on next button
    And Select the tee time desired "<Time>"
    Then Click on any Rate type "<Rate>"
    Then Verify the provider screen is displayed
    When Select one provider
    Then Verify the message below Sign In
    And Enter invalid email
      | EmailIncorrect |
    And Enter valid password
      | PassCorrect |
    Then Verify the error message is present
    Examples:
      | Time       | Rate       |
      | TimeSelect | RateSelect |


  @TC_13CheckoutBookingWithApple
  Scenario Outline: Checkout Screen without signUp
    When Click on my account
    Then Select Sign In option
    Then Verify the message below Sign In
    When Select Apple option and enter credentials
      | EmailApple| PassApple |
    When Verify the current date
    When Enter a course in the search field
      | CourseNameAutoT |
    Then Show the courses list suggestions
      | CourseAutoT |
    And Made click on search button
    Then Click on next button
    Then Click on next button
    And Select the tee time desired "<Time>"
    Then Click on any Rate type "<Rate>"
    Then Verify the provider screen is displayed
    When Select one provider
    Then Verify checkout screen is present
    Then Select Book now button
    And Verify the Confirmation screen is displayed
    When Click on Done
    Examples:
      | Time       | Rate       |
      | TimeSelect | RateSelect |

