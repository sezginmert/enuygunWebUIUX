package Tests;

import Pages.GuestInfoPage;
import Pages.HomePage;
import Pages.HotelSearchPage;
import Pages.PaymentPage;
import Utils.LogHelper;
import Utils.RMethods;
import io.qameta.allure.Allure;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static Utils.LogHelper.logger;
import static Utils.RMethods.clickElementByDataId;
import static Utils.RMethods.scrollTo;

public class HotelReservationTest extends BaseTest {

    @Test
    @Story("HotelBookingHappyPathTest")
    public void hotelBookingHappyPathTest() throws InterruptedException {

        // Initializing page and helper classes
        RMethods utils = new RMethods();
        HotelSearchPage hotelSearchPage = new HotelSearchPage(driver);
        GuestInfoPage guestInfoPage = new GuestInfoPage(driver);
        PaymentPage paymentPage = new PaymentPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        HomePage homePage = new HomePage(driver);

        // Cookie accept
        Allure.step("Cookie accept");
        homePage.acceptcookie();
        logger.info("Cookie accept");


        // Visitor clicks on the "Hotel" button
        Allure.step("Visitor clicks on the Hotel button");
        clickElementByDataId("endesign-[unnamed]-tab-button-1");
        logger.info("Visitor clicks on the Hotel button");

        // Visitor enters city, date, and guest number, then clicks on "Find Hotel"
        Allure.step("Visitor enters city, date, and guest number, then clicks on Find Hotel button");
        hotelSearchPage.hotelReservation();
        logger.info("Visitor enters city, date, and guest number, then clicks on Find Hotel button");

        // Visitor sorts prices in descending order
        Allure.step("Visitor sorts prices in descending order");
        clickElementByDataId("sort-fiyat-azalan-button");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@data-testid='hotel-select-button'])[1]")));
        logger.info("Visitor sorts prices in descending order");

        // Visitor selects a random hotel from the list
        Allure.step("Visitor selects a random hotel from the list");
        hotelSearchPage.randomSelectHotel();
        logger.info("Visitor selects a random hotel from the list");

        // Visitor sees and clicks on the "Reserve Room" button for the best room
        Allure.step("Visitor sees and clicks on the Reserve Room button for the best room");
        By roomCheckButtonLocator = By.xpath("(//*[@data-testid='offer-select-room-button'])[1]");
        wait.until(ExpectedConditions.elementToBeClickable(roomCheckButtonLocator));
        WebElement roomCheckButton = driver.findElement(roomCheckButtonLocator);
        logger.info("Visitor sees and clicks on the Reserve Room button for the best room");

        scrollTo(hotelSearchPage.roomCheckButton);
        Assert.assertTrue(hotelSearchPage.roomCheckButton.isDisplayed(), "Room selection button is not visible!");
        hotelSearchPage.roomCheckButton.click();

        // Visitor is redirected to the guest information page and fills out the form
        Allure.step("Visitor is redirected to the guest information page and fills out the form");
        Assert.assertTrue(driver.findElement(By.xpath("//*[@data-testid='contact-email']")).isDisplayed());
        guestInfoPage.inputGuestDetails();
        logger.info("Visitor is redirected to the guest information page and fills out the form");

        // Visitor clicks on the "Proceed to Payment" button
        Allure.step("Visitor clicks on the Proceed to Payment button");
        clickElementByDataId("reservation-form-submit-button");
        wait.until(ExpectedConditions.visibilityOf(paymentPage.cartNoButton));
        logger.info("Visitor clicks on the Proceed to Payment button");

        // 🧾 Visitor verifies guest information
        Allure.step("Visitor verifies guest information");
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(
                guestInfoPage.getMail(),
                paymentPage.mailButton.getAttribute("value"),
                "Email address does not match!"
        );

        clickElementByDataId("toggle-content");   // Clicks on guest 1 info section

        softAssert.assertEquals(
                guestInfoPage.getName(),
                paymentPage.nameButton.getAttribute("value"),
                "First name does not match!"
        );

        softAssert.assertEquals(
                guestInfoPage.getLastname(),
                paymentPage.lastnameButton.getAttribute("value"),
                "Last name does not match!"
        );
        logger.info("Visitor verifies guest information");

        // Visitor verifies the selected hotel name on the payment page
        Allure.step("Visitor verifies the selected hotel name on the payment page");
        String actualHotelName = paymentPage.hotelName.getText();
        System.out.println("Selected hotel name       : " + hotelSearchPage.selectedHotelName);
        System.out.println("Hotel name on payment page: " + actualHotelName);

        softAssert.assertEquals(
                actualHotelName,
                hotelSearchPage.selectedHotelName,
                "Hotel name does not match!"
        );
        logger.info("Visitor verifies the selected hotel name on the payment page");

        // Visitor verifies check-in and check-out dates on the payment page
        Allure.step("Visitor verifies check-in and check-out dates on the payment page");
        String actualCheckInDate = paymentPage.checkinDate.getText();
        String actualCheckOutDate = paymentPage.checkOutDate.getText();

        System.out.println("Selected Check-in Date       : " + hotelSearchPage.checkInDatePretty);
        System.out.println("Check-in Date on Payment Page: " + actualCheckInDate);
        System.out.println("Selected Check-out Date      : " + hotelSearchPage.checkOutDatePretty);
        System.out.println("Check-out Date on Payment Page: " + actualCheckOutDate);

        Assert.assertEquals(
                actualCheckInDate,
                hotelSearchPage.checkInDatePretty,
                "Check-in date does not match!"
        );
        Assert.assertEquals(
                actualCheckOutDate,
                hotelSearchPage.checkOutDatePretty,
                "Check-out date does not match!"
        );
        logger.info("Visitor verifies check-in and check-out dates on the payment page");

        softAssert.assertAll();

        // Notify that the test has been successfully completed
        System.out.println("Hotel reservation test completed successfully..");

    }
}
