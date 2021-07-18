package TestCases;

import Framework.TestBase;
import Tasks.HomeTask;
import Tasks.SearchFormTask;
import Tasks.SearchResultsTask;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class InvalidReturnDates extends TestBase {

    private WebDriver driver = this.getDriver();

    HomeTask home = new HomeTask(driver);
    SearchFormTask searchForm = new SearchFormTask(driver);
    SearchResultsTask searchResults = new SearchResultsTask(driver);

    @Test
    void OpenMarsAir() throws InterruptedException {

        home.loadPage();
        searchForm.selectTravelDate("July", "December (two years from now)");
        searchForm.searchFlights();

        Thread.sleep(5000);
    }

    @Test
    void mustDisplayMessageWhenReturnDateLessThanOneYearFromDeparture() {

        home.loadPage();
        searchForm.validatesTheListOfMonthsDepartureAndReturnFlights();
        searchForm.selectTravelDate("July", "December (two years from now)");
//        searchForm.selectTravelDate("July", "December");
        searchForm.searchFlights();
//        searchResults.teste("Unfortunately, this schedule is not possible. Please try again.");
        searchResults.checkSearchResultsMessage("Seats available! Call now on 0800 MARSAIR to book!");

    }


}
