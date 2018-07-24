@tag
Feature: Subscribe to NewsLetter
  

  @tag1
  Scenario: Verify user subscribes to Newsletter successfuly
   Given User is on application
   When User provides email in Newsletter.
   And  User clicks on submit button
   Then Message should be displayed  Newsletter : You have successfully subscribed to this newsletter.


