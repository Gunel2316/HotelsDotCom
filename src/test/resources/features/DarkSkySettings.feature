@web @regression @Settings
  Feature: Settings feature

    Background:
      Given I am on Darksky homepage

      @Settings-1
      Scenario: Verify invalid credit card information on Darksky settings page
        When
        And I enter Hasanova Gunel on Cardholder's name text field
        And I enter 1234123423452345 on Card number text field
        And I select February on Expiration Date month
        And I select 2010 on Expiration Date year
        And I enter 123 on CVC text field
        And I enter 25 Prospect street on Address Line 1 text field
        And I enter 55 on Address Line 2 text field
        And I enter New York on City text field
        And I enter NY in State text field
        And I enter 1000 on Zip/Postal Code text field
        And I enter USA on Country text field
        Then I click on Add Card button
        And I verify Invalid credit card error message on Darksky page




