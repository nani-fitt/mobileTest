$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/Feature/HomePage.feature");
formatter.feature({
  "name": "Home page header",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@HomePageHeader"
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
formatter.scenario({
  "name": "Show menu header",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@HomePageHeader"
    },
    {
      "name": "@TC_02-Menu"
    }
  ]
});
formatter.step({
  "name": "Click on menu header",
  "keyword": "When "
});
formatter.match({
  "location": "HomePageStep.clickOnMenuHeader()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify the menu options are present",
  "keyword": "Then "
});
formatter.match({
  "location": "HomePageStep.verifyTheMenuOptionsArePresent()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});