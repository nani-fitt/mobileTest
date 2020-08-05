$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/Feature/SignIn.feature");
formatter.feature({
  "name": "SignIN page",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@PostDeployValidationStaging"
    },
    {
      "name": "@SignIn"
    }
  ]
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Accept the cookies",
  "keyword": "When "
});
formatter.match({
  "location": "HomePageStep.acceptTheCookies()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click on my account",
  "keyword": "When "
});
formatter.match({
  "location": "HomePageStep.clickOnMyAccount()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Select Sign In option",
  "keyword": "Then "
});
formatter.match({
  "location": "HomePageStep.selectSignInOption()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Tap On Sign In option",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@PostDeployValidationStaging"
    },
    {
      "name": "@SignIn"
    },
    {
      "name": "@TC_01-ShowSignIn"
    }
  ]
});
formatter.step({
  "name": "Verify the message below Sign In",
  "keyword": "Then "
});
formatter.match({
  "location": "SignInSteps.verify_the_message_below_Sign_In()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify email is present",
  "keyword": "And "
});
formatter.match({
  "location": "SignInSteps.verify_email_is_present()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify password is present",
  "keyword": "And "
});
formatter.match({
  "location": "SignInSteps.verify_password_is_present()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify Keep me login is present",
  "keyword": "And "
});
formatter.match({
  "location": "SignInSteps.verifyKeepMeLoginIsPresent()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});