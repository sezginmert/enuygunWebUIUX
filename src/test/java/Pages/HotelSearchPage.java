package Pages;

import Utils.RMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class HotelSearchPage {

    RMethods utils = new RMethods();
    WebDriver driver;

    public HotelSearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String checkInDatePretty;
    public String checkOutDatePretty;
    public String selectedHotelName;


    @FindBy(xpath = "(//*[@data-testid='offer-select-room-button'])[1]")
    public WebElement roomCheckButton;

    public void selectCheckInAndCheckOutDates() {
        LocalDate today = LocalDate.now();
        LocalDate checkInDate = today.plusDays(3);
        LocalDate checkOutDate = today.plusDays(6);

        DateTimeFormatter backendFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String checkInDateStr = checkInDate.format(backendFormat);
        String checkOutDateStr = checkOutDate.format(backendFormat);

        // Only store in class-level variables in user-visible format
        DateTimeFormatter prettyFormat = DateTimeFormatter.ofPattern("d MMMM yyyy", new Locale("tr", "TR"));
        checkInDatePretty = checkInDate.format(prettyFormat);    // example: 24 July 2025
        checkOutDatePretty = checkOutDate.format(prettyFormat);  // example: 27 July 2025



        utils.clickElementByDataId("hotel-datepicker-input");
        utils.waitFor(2000);

        WebElement checkInButton = driver.findElement(By.xpath("//button[@title='" + checkInDateStr + "']"));
        Assert.assertTrue(checkInButton.isDisplayed(), "Check-in date button is not visible: " + checkInDateStr);
        checkInButton.click();

        WebElement checkOutButton = driver.findElement(By.xpath("//button[@title='" + checkOutDateStr + "']"));
        Assert.assertTrue(checkOutButton.isDisplayed(), "Check-out date button is not visible: " + checkOutDateStr);
        checkOutButton.click();
    }

    public void hotelReservation() throws InterruptedException {

        // clicks the search box and types Izmir
        utils.clickAndSendKeysByDataId("endesign-hotel-autosuggestion-input", "izmir");
        utils.waitFor(1000);

        // clicks the Izmir option
        utils.clickElementByDataId("endesign-hotel-autosuggestion-option-item-0");
        utils.waitFor(1000);

        // selects the dates
        selectCheckInAndCheckOutDates();
        utils.waitFor(1000);

        // selects the number of guests
        utils.clickElementByDataId("hotel-popover-button");
        utils.waitFor(500);
        utils.clickElementByDataId("hotel-adult-counter-minus-button");
        utils.waitFor(500);
        utils.clickElementByDataId("hotel-guest-submit-button");
        utils.waitFor(500);

        // clicks the "Find Hotel" button
        RMethods.clickByExactText("Otel bul");

        // wait until the "select" button becomes visible (max 10 seconds)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@class='sc-dAlyuH jUGfXx'])[1]")));

        // Now the "select" button is visible, can continue from here
    }

    public void randomSelectHotel() {
        SoftAssert softAssert = new SoftAssert();

        // Get all hotel title elements
        List<WebElement> hotelButtons = driver.findElements(By.xpath("//*[@data-testid='result-title']"));
        Assert.assertFalse(hotelButtons.isEmpty(), "Hotel list is empty!");

        // Random selection
        Random rand = new Random();
        int randomIndex = rand.nextInt(hotelButtons.size());

        // Get the name of the selected hotel and assign it to the class-level variable
        selectedHotelName = hotelButtons.get(randomIndex).getText();

        // Click on the selected hotel
        hotelButtons.get(randomIndex).click();

        // Switch to the new tab
        utils.switchToNewTab();
        utils.waitFor(2000);

        // Get the hotel name on the new tab
        String el2 = driver.findElement(By.xpath("//*[@data-testid='hotel-title']")).getText();

        // Compare
        softAssert.assertEquals(el2, selectedHotelName, "Hotel titles do not match!");

        // Report results
        softAssert.assertAll();
    }

}
