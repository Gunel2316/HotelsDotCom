@web @regression @Login
  Feature: Login feature

    Background:
      Given I am on Darksky homepage

      @Login-1
      Scenario: Verify login from DarkSky homepage
        When I click on DarkSky API
        And I click on login button
        And I enter hasanova.gunel@gmail.com into email address field on DarkSky page
        And I enter sudu1958 into password field on DarkSky page
        And I click on submit button
        Then I verify account login message on DarkSky page


