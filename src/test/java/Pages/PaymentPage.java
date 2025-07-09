package Pages;

import Utils.RMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {

    RMethods utils = new RMethods();
    WebDriver driver;

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//*[@data-testid='cardNumber']")
    public WebElement cartNoButton;

    @FindBy (xpath = "//*[@data-testid='contact-email']")
    public WebElement mailButton;

    @FindBy (xpath = "//*[@data-testid='contact-phone-number']")
    public WebElement phoneButton;

    @FindBy (xpath = "//*[@data-testid='adult-first-name']")
    public WebElement nameButton;

    @FindBy (xpath = "//*[@data-testid='adult-last-name']")
    public WebElement lastnameButton;

    @FindBy (xpath = "//*[@data-testid='summary-hotel-name']")
    public WebElement hotelName;

    @FindBy (xpath = "//*[@data-testid='summary-check-in-date']")
    public WebElement checkinDate;

    @FindBy (xpath = "//*[@data-testid='summary-check-out-date']")
    public WebElement checkOutDate;







}
