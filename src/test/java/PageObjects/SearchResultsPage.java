package PageObjects;

import Framework.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultsPage {

    private WebDriver driver;
    private Waits wait;

    public SearchResultsPage(WebDriver driver) {
        wait = new Waits(driver);
        this.driver = driver;
    }

    public WebElement getSearchResultsText() {
        return wait.visibilityOfElement(By.xpath("//div[@id='content']/p[1]"));
    }

    public WebElement getSearchResultsText2() {
        return wait.visibilityOfElement(By.id("content"));
    }

    public WebElement getSearchResultsText3() {
        return wait.visibilityOfElement(By.xpath("//div[@id='content']//p//node()"));
    }

    public WebElement getBackLink() {
        return wait.visibilityOfElement(By.xpath("//div[@id='content']/p/a"));
    }
}
