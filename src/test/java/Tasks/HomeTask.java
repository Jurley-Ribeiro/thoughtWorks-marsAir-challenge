package Tasks;

import PageObjects.HomePage;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomeTask {

    private static WebDriver driver;
    private static HomePage home;

    public HomeTask(WebDriver driver) {

        this.driver = driver;
        home = new HomePage(this.driver);
    }

    public void loadPage(){

        validateLoadingHomePage();
    }


    public void clickOnTheLogo() {

        home.getPageTitleLogo().click();
        validateLoadingHomePage();

    }

    private void validateLoadingHomePage() {
        try{
            String label = home.getPageTitleLogo().getText();
            assertEquals(label, "MarsAir");
//                Report.log(Status.PASS, "Login Realizado : " + label , Screenshot.fullPageBase64(driver));
        }catch (Exception e){
            e.getMessage();
//                Report.log(Status.FAIL,"Login Falhou", Screenshot.fullPageBase64(driver));
        }
    }


}
