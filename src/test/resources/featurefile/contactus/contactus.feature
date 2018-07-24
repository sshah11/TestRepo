@tag
Feature:Fill Contact Form and Submit it with EmailID

  @tag1
  Scenario:  Fill in Contact Us Form
    Given User in on Application
    When User clicked on ContactUs Icon
    And  Selects the subject Heading as "Customer service"
    And  user click on the send button
    Then An error message should be displayed as "Invalid email address"
   
