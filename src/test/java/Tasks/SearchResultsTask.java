package Tasks;

import Framework.Waits;
import PageObjects.SearchResultsPage;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

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

    public void validateMessageIfThereAreSeats(String expectedText){

        validateSearchResultsPageLoad();

        assertTrue(concatenateParagraphsMessage().contains(expectedText));

    }

    public void validateMessageIfThereAreNoSeats(String expectedText){

        validateSearchResultsPageLoad();

        assertTrue(searchResults.getTextFirstParagraph()
                .getText()
                .contains(expectedText));

    }

    public void checkSearchResultsMessage(String message) {

        validateSearchResultsPageLoad();

        List<String> listElements = new ArrayList<>();

        for (int i = 0; i < searchResults.getSearchResultsMessage().size() - 1; i++) {

            listElements.add(searchResults.getSearchResultsMessage().get(i).getText());
        }

//        assertTrue(list.contains(message));
        assertEquals(message, String.join(" ", listElements));

    }
    private String concatenateParagraphsMessage() {

        String searchResultsFullMessage = String.join(" ", searchResults.getTextFirstParagraph().getText(), searchResults.getTextSecondParagraph().getText());
        return searchResultsFullMessage;

    }

    private void validateSearchResultsPageLoad() {
        try{

            assertTrue(searchResults.getTitleSearchResults().isDisplayed());
//                Report.log(Status.PASS, "Login Realizado : " + label , Screenshot.fullPageBase64(driver));
        }catch (Exception e){
            e.getMessage();
//                Report.log(Status.FAIL,"Login Falhou", Screenshot.fullPageBase64(driver));
        }
    }

}
