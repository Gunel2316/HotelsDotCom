@web @regression @SignUp
  Feature: SignUp Feature

    Background:
      Given I am on Darksky homepage

      @SignUp-1
      Scenario: Verify signup from DarkSky homepage
        When I click on DarkSky API
        And I click on signup button
        And I enter hasanova.gunel@gmail.com into email address field on DarkSky page
        And I enter sudu1958 into password field on DarkSky page
        And I enter sudu1958 into confirm password field on DarkSky page
        And I click on register button
        Then I verify login verify message on DarkSky page


