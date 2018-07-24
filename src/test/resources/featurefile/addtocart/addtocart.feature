@tag 
Feature: Login and add to cart
Scenario: 
Given navigate to application
When user click on add to cart
And user should be able to click on proceed to checkout
And enter the email address as "shahsport07@gmail.com" 
And enter password as "abid123"
And  Login is successful
And user should click the terms of service button and click on checkout
And user should click on pay by check option
Then user should be able to see confirm my order box