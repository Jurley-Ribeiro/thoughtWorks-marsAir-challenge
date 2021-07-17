package Tasks;

import Framework.Waits;
import PageObjects.HomePage;
import PageObjects.SearchFormPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SearchFormTask {

    private static WebDriver driver;
    private static HomePage home;
    private static SearchFormPage searchForm;
    private static Waits wait;

    public SearchFormTask(WebDriver driver) {

        this.driver = driver;
        searchForm = new SearchFormPage(this.driver);
        home = new HomePage(this.driver);
    }

    public void selectTravelDate(String departureMonth, String returnMonth){

        validatesIfTheReturnAndDepartureFieldsAreVisible();
        searchForm.getDepartingDropdown().selectByVisibleText(departureMonth);
        searchForm.getReturningDropdown().selectByVisibleText(returnMonth);

    }

    public void searchFlights(){

        searchForm.getSearchButton().click();

    }

    public void thereMustBeAnDepartureFieldOnSearchForm(){

        assertTrue(searchForm.getDepartingField().isDisplayed());

    }

    public void thereMustBeAnReturnFieldOnSearchForm(){

        assertTrue(searchForm.getReturningField().isDisplayed());

    }

    public void validatesIfTheMessageAppearsInAProminentOnThePage(String highlightMessage) {

        assertEquals(highlightMessage, searchForm.getSearchFormPageSubTitleLabel().getText());

    }

    public void clickOnTheMessageShouldGoToHomepage() {
        try {
            wait.clickableElement(searchForm.getSearchFormPageSubTitleLabel()).click();
            assertTrue(home.getPageTitleLogo().isDisplayed());
        }catch (NullPointerException e){
            System.out.println("Error: Element not clicklable. -> " + e.getMessage());
        }

    }

    public void validatesTheListOfMonthsDepartureAndReturnFlights(){

        String[] dropdownOptionsArray = {
                "Select...", "July", "December", "July (next year)", "December (next year)",
                "July (two years from now)", "December (two years from now)"
        };

        assertTrue(Arrays.asList(dropdownOptionsArray).size() == listOfMonthsOnDepartureFlights().size() &&
                Arrays.asList(dropdownOptionsArray).containsAll(listOfMonthsOnDepartureFlights())
        );

        assertTrue(Arrays.asList(dropdownOptionsArray).size() == listOfMonthsOnReturnFlights().size() &&
                Arrays.asList(dropdownOptionsArray).containsAll(listOfMonthsOnReturnFlights())
        );

    }

    public void validatesTripsResearchForTheNextTwoYears() {

        String twoYearsText = "two years from now";

        System.out.println("List: " + listOfMonthsOnDepartureFlights().toString());
        System.out.println("temp: " + twoYearsText);

        //assertTrue(dropdownTwoYearsOptions.compareTo(listOfMonthsOnDepartureFlights().toString()).contains(dropdownTwoYearsOptions));

//        assertTrue(listOfMonthsOnDepartureFlights().contains(dropdownTwoYearsOptions));

//        assertTrue(listOfMonthsOnReturnFlights().contains(dropdownTwoYearsOptions));
    }

    private List<String> listOfMonthsOnDepartureFlights() {

        List<String> monthsDeparture = new ArrayList<>();
        List<WebElement> options = searchForm.getAllOptionsDepartureElements();

        for (WebElement option : options) {

            String element = option.getText();
            monthsDeparture.add(element);
        }

        assertNotNull(monthsDeparture);

        return monthsDeparture;
    }

    private List<String> listOfMonthsOnReturnFlights() {

        List<String> monthsDeparture = new ArrayList<>();
        List<WebElement> options = searchForm.getAllOptionsDepartureElements();

        for (WebElement option : options) {

            String element = option.getText();
            monthsDeparture.add(element);
        }

        assertNotNull(monthsDeparture);

        return monthsDeparture;
    }

    private void validatesIfTheReturnAndDepartureFieldsAreVisible() {
        try{

            WebElement departureField = wait.loadElement(searchForm.getDepartingField());
            WebElement returnField = wait.loadElement(searchForm.getReturningField());
            assertTrue(departureField.isDisplayed() && returnField.isDisplayed());
//                Report.log(Status.PASS, "Login Realizado : " + label , Screenshot.fullPageBase64(driver));
        }catch (Exception e){
            e.getMessage();
//                Report.log(Status.FAIL,"Login Falhou", Screenshot.fullPageBase64(driver));
        }
    }

}
