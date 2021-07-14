package Tasks;

import Framework.Waits;
import PageObjects.SearchFormPage;
import PageObjects.SearchResultsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchResultsTask {

    private static WebDriver driver;
    private static SearchResultsPage searchResults;
    private static Waits wait;

    public SearchResultsTask(WebDriver driver) {

        this.driver = driver;
        searchResults = new SearchResultsPage(this.driver);
    }

    public void seatsFound(String text){

        validateSearchResultsPageLoad();
        //assertEquals(text, searchResults.getSearchResultsText().getText());
        System.out.println("text: " + searchResults.getSearchResultsText().getText());
        System.out.println("text2: " + searchResults.getSearchResultsText2().getText());
        System.out.println("text3: " + searchResults.getSearchResultsText3().getText());

        assertTrue(text.contains(searchResults.getSearchResultsText().getText()));

    }


    private void validateSearchResultsPageLoad() {
        try{

            assertTrue(searchResults.getSearchResultsText().isDisplayed());
//                Report.log(Status.PASS, "Login Realizado : " + label , Screenshot.fullPageBase64(driver));
        }catch (Exception e){
            e.getMessage();
//                Report.log(Status.FAIL,"Login Falhou", Screenshot.fullPageBase64(driver));
        }
    }

}
