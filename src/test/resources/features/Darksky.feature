@web @regression @verification
  Feature: Verification feature

    Background:
      Given I am on Darksky homepage

      @verification-1
      Scenario: Verify timeline is displayed in correct format
        Then I verify timeline is displayed with two hours incremented

      @verification-2
       Scenario: Verify individual day temp timeline
        When I expand today's timeline
        Then I verify lowest and highest temp is displayed correctly



       @verification-3
       Scenario: Verify Current Temperature should not be greater or less than the Temperature from Daily Timeline
         Then I verify current temp is not greater or less then temps from daily timeline



