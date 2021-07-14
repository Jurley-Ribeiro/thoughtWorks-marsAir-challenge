package Tasks;

import Framework.Waits;
import PageObjects.HomePage;
import PageObjects.SearchFormPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchFormTask {

    private static WebDriver driver;
    private static SearchFormPage searchForm;
    private static Waits wait;

    public SearchFormTask(WebDriver driver) {

        this.driver = driver;
        searchForm = new SearchFormPage(this.driver);
    }

    public void selectTravelDate(String departureMonth, String returnMonth){

        validatesIfTheReturnAndDepartureFieldsAreVisible();
        searchForm.getDepartingDropdown().selectByVisibleText(departureMonth);
        searchForm.getReturningDropdown().selectByVisibleText(returnMonth);

    }

    public void searchFlights(){

        searchForm.getSearchButton().click();

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
