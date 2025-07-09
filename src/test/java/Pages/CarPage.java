package Pages;

import Tests.BaseTest;
import Utils.DriverFactory;
import Utils.RMethods;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class CarPage extends BaseTest {

    public CarPage(){
        PageFactory.initElements(DriverFactory.getDriver(),this);
    }

    Actions actions = new Actions(DriverFactory.getDriver());
    Faker faker = new Faker();
    String email = faker.internet().emailAddress();
    String name = faker.name().firstName();
    String lastName = faker.name().lastName();
    HomePage homePage = new HomePage(DriverFactory.getDriver());

    @FindBy(id = "headlessui-tabs-tab-:R29ks556:")
    public WebElement homepageCarRentalBtn;

    @FindBy(id = "car-search-button")
    public WebElement carSearch;

    @FindBy(xpath = "(//*[@class='sc-lbJcrp brikYS'])[2]")
    public WebElement dateBtnClick;

    @FindBy(xpath = "//*[@class='sc-dcJsrY dpPEbA']")
    public WebElement allSee;

    @FindBy(xpath = "//div[@data-testid='car-rental-filter-luxury-text']")
    public WebElement luksCarChoose;

    @FindBy(xpath = "(//div[@class='styled_Box-sc-1boodb3-0 styled_CardWrapper-sc-rrjrtn-2 gTLMNh iehfdU'])[3]")
    public WebElement additionalServices;

    @FindBy(xpath = "//*[@class='sc-eZkCL frdiLJ detail__ButtonStyled-sc-rj9cun-4 bDwvF']")
    public WebElement continuee;

    @FindBy(xpath = "(//*[@class='sc-czkgLR sDGsj'])[2]")
    public WebElement formScroll;


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

        // Sadece kullanıcıya görünen formatta class-level değişkenlere yaz
        DateTimeFormatter prettyFormat = DateTimeFormatter.ofPattern("d MMMM yyyy", new Locale("tr", "TR"));
        checkInDatePretty = checkInDate.format(prettyFormat);    // örnek: 24 Temmuz 2025
        checkOutDatePretty = checkOutDate.format(prettyFormat);  // örnek: 27 Temmuz 2025



        dateBtnClick.click();
        RMethods.waitFor(3000);

        WebElement checkInButton = driver.findElement(By.xpath("//button[@title='" + checkInDateStr + "']"));
        Assert.assertTrue(checkInButton.isDisplayed(), "Giriş tarihi butonu görünmüyor: " + checkInDateStr);
        checkInButton.click();

        WebElement checkOutButton = driver.findElement(By.xpath("//button[@title='" + checkOutDateStr + "']"));
        Assert.assertTrue(checkOutButton.isDisplayed(), "Çıkış tarihi butonu görünmüyor: " + checkOutDateStr);
        checkOutButton.click();
    }

    public void personInformationForm(){

        RMethods.clickAndSendKeysByDataId("driverEmail-input-comp",email);
        RMethods.waitFor(1000);
        actions.sendKeys(Keys.TAB).sendKeys("5345678767")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).sendKeys(name)
                .sendKeys(Keys.TAB).sendKeys(lastName).perform();
        RMethods.clickElementByDataId("datepicker-car-rental-birthday-day-input-box");
        RMethods.waitFor(1000);
        RMethods.clickElementByDataId("datepicker-car-rental-birthday-day-option-0");
        RMethods.waitFor(1000);
        RMethods.clickElementByDataId("datepicker-car-rental-birthday-month-input-box");
        RMethods.waitFor(1000);
        RMethods.clickElementByDataId("datepicker-car-rental-birthday-month-option-2");
        RMethods.waitFor(1000);
        RMethods.clickElementByDataId("datepicker-car-rental-birthday-year-input-box");
        RMethods.waitFor(1000);
        RMethods.clickElementByDataId("datepicker-car-rental-birthday-year-option-3");
        RMethods.waitFor(2000);
        RMethods.clickAndSendKeysByDataId("driverCitizenNumber-label","58098767844");
        RMethods.waitFor(1000);
        RMethods.clickElementByDataId("weg-arrow-forward");

    }



    public void locationSelect(){
        RMethods.waitFor(2000);
        homepageCarRentalBtn.click();
        RMethods.waitFor(5000);
        RMethods.ScrollWithElement(DriverFactory.getDriver(),allSee);
        RMethods.waitFor(1000);
        RMethods.clickAndSendKeysByDataId("car-rental-pickUpLocation-input-comp","Ankara");
        RMethods.waitFor(2000);
        RMethods.clickElementByDataId("endesign-car-rental-pickUpLocation-autosuggestion-option-item-0");
        RMethods.waitFor(3000);
    }

    public void pickUpAndDropOffTime(){
        RMethods.clickElementByDataId("car-rental-pickUpTime-timePicker-input-input-comp");
        RMethods.clickElementByDataId("car-rental-pickUpTime-timePicker-option-16");
        RMethods.clickElementByDataId("car-rental-dropOffTime-timePicker-input-input-comp");
        RMethods.waitFor(1000);
        RMethods.clickElementByDataId("car-rental-dropOffTime-timePicker-option-16");
    }



    public void carFiltering(){
        RMethods.waitFor(8000);
        RMethods.clickElementByDataId("car-rental-filter-automatic-text");
        RMethods.waitFor(4000);
        RMethods.scrollTo(luksCarChoose);
        RMethods.waitFor(1000);
        luksCarChoose.click();
        RMethods.waitFor(4000);
        RMethods.clickElementByDataId("filter-car-rental-title-yakit");
        RMethods.waitFor(1000);
        RMethods.clickElementByDataId("car-rental-filter-gas-text");
        RMethods.waitFor(4000);
    }

    public void carSelect(){
        RMethods.clickElementByDataId("rentNow_button-0");
        RMethods.waitFor(9000);
        RMethods.scrollTo(additionalServices);
        RMethods.waitFor(1000);
        additionalServices.click();
        RMethods.waitFor(2000);

        actions.sendKeys(Keys.PAGE_DOWN).perform();

        RMethods.waitFor(3000);
        RMethods.clickElementByDataId("weg-arrow-forward");
        RMethods.waitFor(9000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        RMethods.waitFor(2000);
    }

    public void pricingSuggestion(){
        RMethods.clickElementByDataId("sort-select-input-box");
        RMethods.waitFor(1000);
        RMethods.clickElementByDataId("sort-select-option-2");
        RMethods.waitFor(1000);
    }

    public void scrolls(){
        RMethods.waitFor(3000);
        RMethods.clickElementByDataId("weg-arrow-forward");
        RMethods.waitFor(9000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        RMethods.waitFor(2000);
        personInformationForm();
    }
}