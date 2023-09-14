Feature: Test to retreive get method of Order

  Scenario Outline: Send a valid Request to GET Order
    Given Get Call to url
    Then Response Code status is validated
    And verify response content type is "<contentType>"
    And print out the response body to console

    Examples: 
      | contentType      |
      | application/json |
