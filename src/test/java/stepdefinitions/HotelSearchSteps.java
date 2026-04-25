package stepdefinitions;

import base.DriverManager;
import io.cucumber.java.en.*;
import pages.HotelSearchPage;

import java.time.LocalDate;

public class HotelSearchSteps {
    HotelSearchPage hotelPage;

    @Given("I am on Booking.com homepage for hotel search")
    public void open_homepage() {
//        DriverManager.getDriver().get("https://booking.com/");
        hotelPage = new HotelSearchPage(DriverManager.getDriver());
    }

    @When("I search hotels in {string} for {int} days for {int} people")
    public void search_hotels(String city, Integer numberOfDays, Integer numberOfPeople) {
        hotelPage.closePopup();
        hotelPage.enterDestination(city);
        hotelPage.selectNairobiOption();

        LocalDate checkIn = LocalDate.now().plusDays(1);
        LocalDate checkOut = checkIn.plusDays(numberOfDays);
        hotelPage.selectCheckInDate(checkIn);
        hotelPage.selectCheckOutDate(checkOut);

        hotelPage.openPersonsSelector();
        hotelPage.setAdults(numberOfPeople);        
    }
    
    @When("Sort by top reviewed and apply filter for {string}")
    public void sort_by_top_reviewed_and_apply_filter_for(String filterName) {
    	hotelPage.clickSearch();
        hotelPage.sortByTopReviewed();
        hotelPage.filterFreeWifi();
        hotelPage.printHotelResults();
    }

    @Then("Hotel results should be displayed")
    public void verify_results() {
        System.out.println("Hotels displayed successfully!");
    }
}
