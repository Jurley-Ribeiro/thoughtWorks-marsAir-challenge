package TestCases;

import Framework.TestBase;
import Tasks.HomeTask;
import Tasks.SearchFormTask;
import Tasks.SearchResultsTask;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class LinkToHomePage extends TestBase {

    private WebDriver driver = this.getDriver();

    HomeTask home = new HomeTask(driver);
    SearchFormTask searchForm = new SearchFormTask(driver);
    SearchResultsTask searchResults = new SearchResultsTask(driver);

    @Test
    void shouldMessageAppearSomewhereProminentlyPage() {

        home.loadPage();
        searchForm.validatesIfTheMessageAppearsInAProminentOnThePage("Book a ticket to the red planet now!");
    }

    @Test
    void clickingOnTheMessageShouldTakeToHomepage(){

        home.loadPage();
        searchForm.validatesIfTheMessageAppearsInAProminentOnThePage("Book a ticket to the red planet now!");


    }



}
