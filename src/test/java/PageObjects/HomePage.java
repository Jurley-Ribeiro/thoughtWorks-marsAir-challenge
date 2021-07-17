package PageObjects;

import Framework.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private WebDriver driver;
    private Waits wait;

    public HomePage(WebDriver driver) {
        wait = new Waits(driver);
        this.driver = driver;
    }

    public WebElement getPageTitleLogo() {
        return wait.visibilityOfElement(By.xpath("//h1/a"));
    }

}
