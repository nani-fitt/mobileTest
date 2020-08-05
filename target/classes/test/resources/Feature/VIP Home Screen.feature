
 Feature: VIP Home page
   Background:
     When Accept the cookies
     When Verify SG Club header is displayed
     And  Makes click on SG Club header
     Then Verify the SG page is open

   @TC_01:SGClubHeader
    Scenario: Verify SG Club header
       And  Verify the static page link is correct

   @TC_02:SGClubPage
   Scenario: Open SG Club page
     When Verify <Supreme Golf Club> text is present
     And  Verify <No booking fees on any tee time. Ever.> text is present
     And  Verify <The Supreme Golf Club button> is displayed


   @TC_03:SGClubPageAmeneties
   Scenario: Verify SG Club amenities
     When Verify <Why join The Supreme Golf Club?> text is present
     Then Verify the SG club ameneties are present
     And  Verify <Join Now button> is displayed


   @TC_04:SGClubPageLink
   Scenario: Open SG Club page and select the links
     When Verify Terms and Conditions link is present
     And  Click on Terms and Conditions link
     Then Verify the correct Terms and Conditions link page is open
     When Verify Cancellation Policy link is present
     And  Click on Cancellation Policy link
     Then Verify the correct Cancellation Policy link page is open

   @TC_05:SGClubPageButton
   Scenario: Open SG Club page and select SG Button without to be loggued
     When  Click on <The Supreme Golf Club button>
     And   Verify the Sign In page displayed
     And   Enter incorrect data
     Then  Verify the error message is displayed


   @TC_06:SGClubPageButton2
   Scenario: Open SG Club page and select join Now Button without to be loggued
     When Click on <Join Now button>
     And  Verify the Sign In page displayed
     And  Enter incorrect data
     Then Verify the error message is displayed






