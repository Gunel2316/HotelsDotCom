package stepdefinition;
import cucumber.api.java.en.*;
import framework.webPages.BasePage;
import framework.webPages.HotelsDotComeHomePage;
import cucumber.api.java.en.Given;
import org.testng.Assert;

public class HotelsDotComSD {
    private BasePage basePage=new BasePage();
    private HotelsDotComeHomePage hotelsDotComeHomePage=new HotelsDotComeHomePage();

    @Given("^I am on default locations search result screen$")
    public void iAmOnSearchScreen()throws InterruptedException{
        hotelsDotComeHomePage.clickOnFlightsAndPackages();
        hotelsDotComeHomePage.enterOrigin("New York");
        hotelsDotComeHomePage.enterDestination(" Orlando, Florida");
        hotelsDotComeHomePage.clickOnChecInCalendar();
        hotelsDotComeHomePage.enterCheckInDate("04/05/2019");
        hotelsDotComeHomePage.clickOnCheckOutCalendar();
        hotelsDotComeHomePage.clearCheckOutField();
        hotelsDotComeHomePage.enterCheckOutDate("04/20/2019");
        hotelsDotComeHomePage.clickOnSearch(); }


@When("^I select property class (.+)$")
    public void clickOnStars(String stars) throws InterruptedException {
switch (stars){
    case "5 stars":
        hotelsDotComeHomePage.selectProperty("5");
        Thread.sleep(11000);
        break;
    case "4 stars":
        hotelsDotComeHomePage.selectProperty("4");
        Thread.sleep(11000);
        break;
    case "3 stars":
        hotelsDotComeHomePage.selectProperty("3");
        Thread.sleep(11000);
        break;
}
}

        @Then("^I verify system displays only (.+) hotels on search result$")
    public void verifyStars(String starRatings)throws InterruptedException{
       switch (starRatings){
           case "5 stars":
               Assert.assertTrue(hotelsDotComeHomePage.verifyHotelStars("5"));
               Thread.sleep(3000);
               break;
           case "4 stars":
               Assert.assertTrue(hotelsDotComeHomePage.verifyHotelStars("4"));
               Thread.sleep(3000);
               break;
           case "3 stars":
               Assert.assertTrue(hotelsDotComeHomePage.verifyHotelStars("3"));
               Thread.sleep(3000);
               break; } }

        @Then("^I verify system displays all hotels within 10 miles radius of airport$")
    public void verifyMilesFromAirport()throws InterruptedException{
        hotelsDotComeHomePage.expandNeighborhoodShowMore();
        Thread.sleep(7000);

hotelsDotComeHomePage.verifyHotelsNamesAndDistances(); Thread.sleep(3000);
hotelsDotComeHomePage.verifyHotelsAreWithin10Miles();

        }
        @Then("^I verify Hilton Hotel is within radius$")
    public void HiltonPresent(){
        hotelsDotComeHomePage.isHiltonPresentInTheList();
        hotelsDotComeHomePage.isHiltonPresentWithin10Miles();
        }





}
