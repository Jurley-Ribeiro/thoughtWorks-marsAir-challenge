package PageObjects;

import Framework.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultsPage {

    private WebDriver driver;
    private Waits wait;

    public SearchResultsPage(WebDriver driver) {
        wait = new Waits(driver);
        this.driver = driver;
    }

    public WebElement getTitleSearchResults() {
        return wait.visibilityOfElement(By.xpath("//div[@id='content']/h2"));
    }

    public WebElement getTextFirstParagraph() {
        return wait.visibilityOfElement(By.xpath("//div[@id='content']/p[1]"));
    }

    public WebElement getTextSecondParagraph() {
        return wait.visibilityOfElement(By.xpath("//div[@id='content']/p[2]"));
    }

    public WebElement getBackLink() {
        return wait.visibilityOfElement(By.xpath("//a[contains(text(),'Back')]"));
    }
}
