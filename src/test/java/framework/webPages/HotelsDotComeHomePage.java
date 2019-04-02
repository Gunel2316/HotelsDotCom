package framework.webPages;

import cucumber.api.java.it.Ma;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import stepdefinition.SharedSD;

import java.text.SimpleDateFormat;
import java.util.*;

import static stepdefinition.SharedSD.getDriver;

public class HotelsDotComeHomePage extends BasePage {
    private By destination=By.id("qf-0q-destination");
    private By checkIn=By.id("qf-0q-localised-check-in");
    private By checkOut=By.id("q-localised-check-out");
    private By searchButton=By.xpath("//button[@type='submit']");
    private By packagesAndFlights=By.id("hdr-packages");
    private By originField=By.xpath("//input[@id='package-origin-hp-package']");
    private By destinationField=By.xpath("//input[@id='package-destination-hp-package']");
    private By checkInField=By.id("package-departing-hp-package");
    private By checkOutField=By.id("package-returning-hp-package");
    private By searchButton2=By.xpath("//button[@id='search-button-hp-package']");
    String starSelectorBox ="//input[@id='star";
    private By starRating=By.xpath("//li[contains(@class,'starRating')]");
    private By distanceAirport =By.xpath("//li[contains(@class, 'distance')]");
    private By showMoreButton=By.xpath("//div[@id='neighborhoodContainer']//span[@class='more'][contains(text(),'Show more')]");
    private By OrlandoMCOAirport=By.xpath("//input[@id='neighborhood19']");
    private By hotelNames=By.xpath("//li[@class='hotelTitle']//h4[starts-with(@class,'hotelName')]");


    public List<String> starRatings(){
        List<WebElement> stars=SharedSD.getDriver().findElements(starRating);
        List<String> starRatings=new ArrayList<>();
        for (WebElement star: stars){
            starRatings.add(star.getText());
            System.out.println(starRatings);
        }
        return starRatings;
    }

    public void clickOnFlightsAndPackages(){clickOn(packagesAndFlights);}
    public void enterOrigin(String origin){setValue(originField, origin);}
    public void enterDestination(String destination){setValue(destinationField, destination);}
    public void clickOnChecInCalendar() throws InterruptedException {clickOn(checkInField);Thread.sleep(3000);}
    public void enterCheckInDate(String checkInDate){setValue(checkInField, checkInDate);}


    public String checkInDate(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(calendar.DAY_OF_MONTH, 4);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d");
        return simpleDateFormat.format(calendar.getTime());}

    public void clickOnCheckOutCalendar() throws InterruptedException {clickOn(checkOutField);Thread.sleep(3000);}
    public void clearCheckOutField() throws InterruptedException {
       SharedSD.getDriver().findElement(checkOutField).clear();Thread.sleep(3000);}
    public void enterCheckOutDate(String checkOutDate) throws InterruptedException {setValue(checkOutField, checkOutDate);Thread.sleep(3000);}



    public String checkOutDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(calendar.DAY_OF_MONTH, 12);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d");
        return simpleDateFormat.format(calendar.getTime());
    }

    public void clickOnSearch() throws InterruptedException {clickOn(searchButton2);Thread.sleep(6000);}


    public void selectProperty(String stars) throws InterruptedException {
      /*  WebElement element=SharedSD.getDriver().findElement(By.xpath(starSelectorBox + stars + "']"));
        ((JavascriptExecutor)SharedSD.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(3000);
        element.click();
        Thread.sleep(3000);*/
       clickOn(By.xpath(starSelectorBox + stars + "']"));
    }

    public boolean verifyHotelStars(String stars) {
        List<String> expectedStars = new ArrayList<>();
        List<String> actualStars = new ArrayList<>();
        List<WebElement> hotels = SharedSD.getDriver().findElements(starRating);
        for (WebElement hotel : hotels) {
            expectedStars.add(hotel.getText());
            switch (stars) {
                case "5":
                    if (hotel.getText().contains(stars + ".0 " + "out of 5.0")) {
                        actualStars.add(hotel.getText()); }
                    break;
                case "4":
                    if(hotel.getText().contains(stars + ".0 " + "out of 5.0")){
                        actualStars.add(hotel.getText()); }
                        break;
                case "3":
                    if (hotel.getText().contains(stars + ".0 " + "out of 5.0")) {
                        actualStars.add(hotel.getText()); }
                    break;
            }
        }
        System.out.print("expected "+ expectedStars);
        System.out.println("actual "+actualStars);
        return expectedStars.equals(actualStars);
    }

    public void expandNeighborhoodShowMore() throws InterruptedException {
        SharedSD.getDriver().manage().window().maximize();
        JavascriptExecutor jse = (JavascriptExecutor)getDriver();
        jse.executeScript("window.scrollBy(0,750)", "");
        Thread.sleep(3000);
        clickOn(showMoreButton);
        Thread.sleep(3000);
        clickOn(OrlandoMCOAirport);
        Thread.sleep(10000); }

        public void verifyHotelsNamesAndDistances(){
        List<String> distanceFromAirport=new ArrayList<>();
        List<String> AllHotelNames=new ArrayList<>();
        List<WebElement> hotels= SharedSD.getDriver().findElements(hotelNames);
       List<WebElement>distances=SharedSD.getDriver().findElements(distanceAirport);
        for (WebElement hotel : hotels){
            AllHotelNames.add(hotel.getText());
        }
        for (WebElement distance : distances ){
            distanceFromAirport.add(distance.getText());

        }
        ArrayList<Double> distanceInNumbers=new ArrayList<Double>();
        for(int i=0; i<distanceFromAirport.size(); i++){
            distanceInNumbers.add(Double.parseDouble(distanceFromAirport.get(i).substring(0,5)));
                    //(distanceFromAirport.get(i).substring(0,5)));

        }

            System.out.println("distance in numbers "+distanceInNumbers);
            System.out.println("********************************");
            System.out.println("distance "+ distanceFromAirport);
            System.out.println("********************************");
            System.out.println("hotels "+AllHotelNames);

            Map<String,Double> newList=new HashMap<String, Double>();
            for(int i=0; i<AllHotelNames.size(); i++){
                newList.put(AllHotelNames.get(i), distanceInNumbers.get(i));
            }
            System.out.println("********************************");
            System.out.println("new list " +newList);

            TreeMap<String, Double> treeMapDistance = new TreeMap<String, Double>();
            treeMapDistance.putAll(newList);


            treeMapDistance.entrySet().removeIf(e ->e.getValue()>=10.00);

            System.out.println("treeMap "+treeMapDistance);}




        /*ArrayList<Integer> numbers = new ArrayList<Integer>();

for(int i = 0; i < strArrayList.size(); i++) {
   numbers.add(Integer.parseInt(strArrayList.get(i)));
}*/
public boolean verifyHotelsAreWithin10Miles(){
    List<String> distanceFromAirport=new ArrayList<>();
    List<WebElement>distances=SharedSD.getDriver().findElements(distanceAirport);
    for (WebElement distance : distances ){
        distanceFromAirport.add(distance.getText()); }
    ArrayList<Double> distanceInNumbers=new ArrayList<Double>();
    for(int i=0; i<distanceFromAirport.size(); i++){
        distanceInNumbers.add(Double.parseDouble(distanceFromAirport.get(i).substring(0,5)));
        //(distanceFromAirport.get(i).substring(0,5)));
        }
        for(int i=0; i<distanceInNumbers.size(); i++){
            if(distanceInNumbers.get(i)>10){
                return true;
            }
        }
        return true;}

        public boolean isHiltonPresentInTheList(){
            List<String> AllHotelNames=new ArrayList<>();
            List<WebElement> hotels= SharedSD.getDriver().findElements(hotelNames);
            for (WebElement hotel : hotels){
                AllHotelNames.add(hotel.getText());}

            for(int i=0; i<AllHotelNames.size(); i++){
                if(AllHotelNames.get(i).contains("Hilton")){
                    return true;
                }
            }
            return false;

        }

        public boolean isHiltonPresentWithin10Miles(){
            List<String> distanceFromAirport=new ArrayList<>();
            List<String> AllHotelNames=new ArrayList<>();
            List<WebElement> hotels= SharedSD.getDriver().findElements(hotelNames);
            List<WebElement>distances=SharedSD.getDriver().findElements(distanceAirport);
            for (WebElement hotel : hotels){
                AllHotelNames.add(hotel.getText());
            }
            for (WebElement distance : distances ){
                distanceFromAirport.add(distance.getText());

            }
            ArrayList<Double> distanceInNumbers=new ArrayList<Double>();
            for(int i=0; i<distanceFromAirport.size(); i++){
                distanceInNumbers.add(Double.parseDouble(distanceFromAirport.get(i).substring(0,5)));

                Map<String,Double> newList=new HashMap<String, Double>();

                for(i=0; i<AllHotelNames.size(); i++){
                    newList.put(AllHotelNames.get(i), distanceInNumbers.get(i)); }

                TreeMap<String, Double> treeMapDistance = new TreeMap<String, Double>();
                treeMapDistance.putAll(newList);

                treeMapDistance.entrySet().removeIf(e ->e.getValue()>=10.00);
            if(treeMapDistance.containsKey("Hilton")){
                return true;
            }

            }
            return false;

            //List<List<String>> trendyList = new ArrayList<>(mMap.values());

        }




}




    /*   List<WebElement>list=getDriver().findElements(By.xpath("//span[contains(@style,'opacity')]//span"));
            Iterator<WebElement>iterator=list.iterator();

            List<String>values=new ArrayList<String>();
            while (iterator.hasNext()){
                WebElement element=iterator.next();
                values.add(element.getText());
            }
           System.out.println(values.toString());Thread.sleep(3000);}*/


    /* List<WebElement>list=getDriver().findElements(By.xpath("/li[starts-with(@class, 'starRating')]"));


            Iterator<WebElement>iterator=list.iterator();

            List<String>values=new ArrayList<String>();
            while (iterator.hasNext()){
                WebElement element=iterator.next();
                values.add(element.getText());
            }
           System.out.println(values);Thread.sleep(3000);}*/
/* public String checkInDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(calendar.DAY_OF_MONTH, 1);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d");
        return simpleDateFormat.format(calendar.getTime());
    }

     homepage.clickOnCheckIn();
    List<WebElement> days = getDriver().findElements(By.xpath("//*[@class=\"widget-daterange-cont\"]/div[1]/descendant::a"));
        for (WebElement day : days) {
        if (day.getText().equals(homepage.checkInDate())) {
            day.click();
            break;*/





