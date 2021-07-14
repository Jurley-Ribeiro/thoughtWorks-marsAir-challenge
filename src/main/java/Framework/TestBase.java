package Framework;

import Utils.FileOperations;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class TestBase extends DriverManager{

    private static WebDriver driver;
    private static FileOperations fileOperations = new FileOperations();

    private String URL = "https://marsair.thoughtworks-labs.net/jurley.ribeiro";

    public static WebDriver getDriver(){

        driver = getDriver(TypeDriver.CHROME);
        return driver;
    }

    @BeforeEach
    public void setUp() throws IOException {
        //String index = fileOperations.getProperties("url").getProperty("url.index");
        //configReportExtent();
        getDriver().get(URL);
        //getDriver().get(index);
    }

    @AfterEach
    public void tearDown(){

//        Report.close();
        quitDriver();

    }

}
