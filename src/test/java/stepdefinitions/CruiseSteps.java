package stepdefinitions;

import base.DriverManager;
import io.cucumber.java.en.*;
import org.openqa.selenium.JavascriptExecutor;
import pages.CruisePage;

import java.time.LocalDate;

public class CruiseSteps {
    CruisePage cruisePage;
    JavascriptExecutor js;

    @Given("I am on Booking.com homepage for cruise search")
    public void open_homepage() {
        cruisePage = new CruisePage(DriverManager.getDriver());
        js = (JavascriptExecutor) DriverManager.getDriver();
    }

    @When("I search cruises in {string}")
    public void search_cruises(String city) throws InterruptedException {

        cruisePage.closePopup();
        cruisePage.clickAttractions();
        cruisePage.enterDestination(city);
    }
    
    @When("For the next {int} days")
    public void for_the_next_days(Integer numberOfDays) {
    	LocalDate checkIn = LocalDate.now().plusDays(numberOfDays);
        LocalDate checkOut = checkIn.plusDays(numberOfDays);
        cruisePage.selectCheckInDate(checkIn);
        cruisePage.selectCheckOutDate(checkOut);
    }
    
    @When("Apply filter of {string}")
    public void apply_filter_of_cruises_and_boats(String filterName) {
    	  cruisePage.clickSearch();
          cruisePage.expandCruiseFilter(js);
    }
    
    @Then("Cruise results should be displayed")
    public void verify_results() {
    	cruisePage.printCruiseDetails(js);
        System.out.println("Cruises displayed successfully!");
    }
}
