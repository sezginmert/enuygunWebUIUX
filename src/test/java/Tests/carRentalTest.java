package Tests;

import Pages.CarPage;
import Pages.HomePage;
import Utils.DriverFactory;
import Utils.RMethods;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

public class carRentalTest extends RMethods{


    CarPage carPage = new CarPage();
    HomePage homePage = new HomePage(DriverFactory.getDriver());

    @Test(priority = 1, description = "")
    @Severity(SeverityLevel.CRITICAL)
    public void carSelectionTest() {
        homePage.acceptcookie();
        carPage.locationSelect();
        carPage.selectCheckInAndCheckOutDates();
        carPage.pickUpAndDropOffTime();
        carPage.carSearch.click();
        carPage.carFiltering();
        carPage.carSelect();
        carPage.personInformationForm();
        System.out.println();
    }

}