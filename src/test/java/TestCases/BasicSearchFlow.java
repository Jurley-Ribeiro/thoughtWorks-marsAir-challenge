package TestCases;

import Framework.TestBase;
import Tasks.HomeTask;
import Tasks.SearchFormTask;
import Tasks.SearchResultsTask;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasicSearchFlow extends TestBase {

    private WebDriver driver = this.getDriver();

    HomeTask home = new HomeTask(driver);
    SearchFormTask searchForm = new SearchFormTask(driver);
    SearchResultsTask searchResults = new SearchResultsTask(driver);

    @Test
    void shouldBeDepartureAndReturnFieldsOnSearchForm() {

        home.loadPage();
        searchForm.thereMustBeAnDepartureFieldOnSearchForm();
        searchForm.thereMustBeAnReturnFieldOnSearchForm();

    }

    @Test
    void flightsMustDepartAndArriveInJulyAndDecember() {

        home.loadPage();
        searchForm.validatesTheListOfMonthsDepartureAndReturnFlights();

    }

    @Test
    void successMessageIfThereAreSeats() {

        home.loadPage();
        searchForm.validatesTheListOfMonthsDepartureAndReturnFlights();
        searchForm.selectTravelDate("July", "December (two years from now)");
        searchForm.searchFlights();
        searchResults.validateMessageIfThereAreSeats("Seats available! Call now on 0800 MARSAIR to book!");

    }

    @Test
    void messageIfThereAreNoSeatsAvailable() {

        home.loadPage();
        searchForm.validatesTheListOfMonthsDepartureAndReturnFlights();
        searchForm.selectTravelDate("July", "December (next year)");
        searchForm.searchFlights();
        searchResults.validateMessageIfThereAreNoSeats("Sorry, there are no more seats available.");

    }

    @Test
    void shouldBeDisplayTripsForTheNextTwoYears() {

        home.loadPage();
        searchForm.validatesTripsResearchForTheNextTwoYears();

    }
}
