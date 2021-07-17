package PageObjects;

import Framework.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SearchFormPage {

    private WebDriver driver;
    private Waits wait;

    public SearchFormPage(WebDriver driver) {
        wait = new Waits(driver);
        this.driver = driver;
    }

    public WebElement getSearchFormPageTitleLabel() {
        return wait.visibilityOfElement(By.xpath("//div[@id='content']/h2"));
    }

    public WebElement getSearchFormPageSubTitleLabel() {
        return wait.visibilityOfElement(By.xpath("//div[@id='content']/form/h3"));
    }

    public WebElement getDepartingField() {
        return wait.visibilityOfElement(By.id("departing"));
    }

    public Select getDepartingDropdown() {
        Select monthsDeparture = new Select(driver.findElement(By.id("departing")));
        return monthsDeparture;
    }

    public List<WebElement> getAllOptionsDepartureElements(){

        return driver.findElements(By.xpath("//select[@id='departing']/option"));

    }

    public List<WebElement> getAllOptionsReturnElements(){

        return driver.findElements(By.xpath("//select[@id='departing']/option"));

    }

    public WebElement getReturningField() {
        return wait.visibilityOfElement(By.id("returning"));
    }

    public Select getReturningDropdown() {
        Select monthsReturn = new Select(driver.findElement(By.id("returning")));
        return monthsReturn;
    }

    public WebElement getPromotionCodeField() {
        return wait.visibilityOfElement(By.id("promotional_code"));
    }

    public WebElement getSearchButton() {
        return wait.visibilityOfElement(By.xpath("//input[@value='Search']"));
    }

}
