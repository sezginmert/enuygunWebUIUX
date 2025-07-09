package Tests;

import Utils.DriverFactory;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

@Epic("DriverFactory Turn On And Turn Off")
@Feature("The Driver Be Active ")
public class BaseTest {

    protected static WebDriver driver;


    @BeforeClass(description = "DriverFactory Call It")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Wait For The Driver To Be Active")
    public void setup(){
        Allure.step("DriverFactory Call It And The Driver Fill");
        driver = DriverFactory.getDriver();
        driver.get("https://www.enuygun.com/");
    }

    @AfterClass(description = "DriverFactory Turn Off")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Wait For The Driver To Be İnactive")
    public void teardown(){
      Allure.step("DriverFactory Call It And The Driver Be Emptys");
//      DriverFactory.quitDriver();
    }
}
