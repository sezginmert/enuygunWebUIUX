package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

import static Utils.LogHelper.logger;

public class HomePage {

    WebDriver driver;
    SoftAssert softAssert = new SoftAssert();
    public HomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

//    @FindBy(xpath = "//button[contains(text(),'Uçak bileti')]")
//    WebElement ticketbutton;

    @FindBy(xpath = "//*[@data-testid='search-one-way-text']")
    WebElement onewaytext;

    @FindBy(xpath = "//*[@data-testid='search-multi-destination-text']")
    WebElement multidestinationtext;

    @FindBy(xpath = "//*[@data-testid='flight-origin-label']")
    WebElement fromwhere;

    @FindBy(xpath = "//*[@data-testid='endesign-flight-origin-autosuggestion-input']")
    WebElement fromwhereinput;

    @FindBy(xpath = "//*[@data-testid='flight-destination-label']")
    WebElement towhere;

    @FindBy(xpath = "//*[@data-testid='endesign-flight-destination-autosuggestion-input']")
    WebElement towhereinput;

    @FindBy(xpath = "//*[@data-testid='enuygun-homepage-flight-departureDate-input-comp']")
    WebElement onedateinput;

//    @FindBy(xpath = "//*[@data-testid='enuygun-homepage-flight-selectPassengerAndCabin']")
//    WebElement selectcabin;

//    @FindBy(xpath = "//div[@data-testid='autosuggestion-custom-item-istanbul-sabiha-gokcen-havalimani']")
//    WebElement sabiha;

//    @FindBy(xpath = "//div[@data-testid='autosuggestion-custom-item-izmir-adnan-menderes-havalimani']")
//    WebElement izmir;

    @FindBy(xpath = "//*[@id='calendar-month-2025-08']/div[3]/div/div/button[20]")
    WebElement onedateselect;

    @FindBy(xpath = "//*[@data-testid='enuygun-homepage-flight-submitButton']")
    WebElement submitbtn;

    @FindBy(xpath = "//*[@id='onetrust-accept-btn-handler']")
    WebElement cookieButton;

    @FindBy(xpath = "//button[@class='Flight-module_addMoreBtn__h7Zr2']")
    WebElement addflight;

    //Multi Way First enteries
    @FindBy(xpath = "//*[@data-testid='flight-multi.0.origin-label']")
    WebElement fromwhere1;

    @FindBy(xpath = "//*[@data-testid='endesign-flight-multi.0.origin-autosuggestion-input']")
    WebElement fromwhereinput1;

    @FindBy(xpath = "//*[@data-testid='flight-multi.0.destination-label']")
    WebElement towhere1;

    @FindBy(xpath = "//*[@data-testid='endesign-flight-multi.0.destination-autosuggestion-input']")
    WebElement towhereinput1;

    @FindBy(xpath = "//*[@data-testid='flight-multi-date-input-0-input-comp']")
    WebElement dateinput1;

    @FindBy(xpath = "//*[@id='calendar-month-2025-07']/div[3]/div/div/button[14]")
    WebElement dateselect1;


    //Multi Way Second enteries
    @FindBy(xpath = "//*[@data-testid='flight-multi.1.origin-label']")
    WebElement fromwhere2;

    @FindBy(xpath = "//*[@data-testid='endesign-flight-multi.1.origin-autosuggestion-input']")
    WebElement fromwhereinput2;

    @FindBy(xpath = "//*[@data-testid='flight-multi.1.destination-label']")
    WebElement towhere2;

    @FindBy(xpath = "//*[@data-testid='endesign-flight-multi.1.destination-autosuggestion-input']")
    WebElement towhereinput2;

    @FindBy(xpath = "//*[@data-testid='flight-multi-date-input-1-input-comp']")
    WebElement dateinput2;

    @FindBy(xpath = "//*[@id='calendar-month-2025-07']/div[3]/div/div/button[20]")
    WebElement dateselect2;


    //Multi Way Third enteries
    @FindBy(xpath = "//*[@data-testid='flight-multi.2.origin-label']")
    WebElement fromwhere3;

    @FindBy(xpath = "//*[@data-testid='endesign-flight-multi.2.origin-autosuggestion-input']")
    WebElement fromwhereinput3;

    @FindBy(xpath = "//*[@data-testid='flight-multi.2.destination-label']")
    WebElement towhere3;

    @FindBy(xpath = "//*[@data-testid='endesign-flight-multi.2.destination-autosuggestion-input']")
    WebElement towhereinput3;

    @FindBy(xpath = "//*[@data-testid='flight-multi-date-input-2-input-comp']")
    WebElement dateinput3;

    @FindBy(xpath = "//*[@id='calendar-month-2025-08']/div[3]/div/div/button[10]")
    WebElement dateselect3;

    @FindBy(xpath ="//label[.//div[contains(text(),'Yolcu Sayısı, Kabin')]]")
    WebElement selectCabin;

    @FindBy(xpath ="//*[@data-testid='flight-adult-counter-plus-button']")
    WebElement adultplus;

    @FindBy(xpath ="//*[@data-testid='flight-child-counter-plus-button']")
    WebElement childplus;

    @FindBy(xpath ="//*[@data-testid='flight-infant-counter-plus-button']")
    WebElement infantplus;

    @FindBy(xpath ="//*[@data-testid='undefined-homepage-flight-doneBtn']")
    WebElement donebutton;

    @FindBy(xpath ="//button[@type='submit']")
    WebElement seacrhticket;

    @FindBy(xpath ="//button[@data-testid='selectedFlighButton']" )
    List<WebElement> chooseflight;

//    @FindBy(xpath ="//div[@data-testid='Süper Eko']" )
//    WebElement choosecomfortable;

    @FindBy(xpath ="//button[@data-testid='selectAndNextButton']" )
    WebElement chooseAndnext;

    @FindBy(xpath ="//*[@class='D_MD_reservation_info_number']" )
    public List<WebElement> numflights;

    @FindBy(xpath ="//*[@class='D_MD_reservation_info_route']" )
    public List<WebElement> routeflights;

    @FindBy(xpath ="//*[@data-testid='departureFlightTime']" )
    public List<WebElement> howmanytimedepartures;

    @FindBy(xpath ="//*[@data-testid='arrivalFlightTime']" )
    public List<WebElement> howmanytimearrivals;

    @FindBy(xpath ="//*[@data-testid='departureTotalTime']" )
    public List<WebElement> howmanytimetotals;

    @FindBy(xpath ="//*[@id='Header']" )
    public WebElement pagetop;

    @FindBy(id = "contact_email")
    WebElement email;

    @FindBy(id = "contact_cellphone")
    WebElement phone;

    @FindBy(xpath ="//*[@class='passenger-translate']" )
    public List<WebElement> numberperson;

    @FindBy(xpath ="//*[@data-testid='reservation-passenger-name-input']" )
    public List<WebElement> names;

    @FindBy(xpath ="//*[@data-testid='reservation-passenger-surname-input']" )
    public List<WebElement> surnames;

    @FindBy(xpath ="//*[@id='birthDateDay_0']" )
    public WebElement days;

    @FindBy(xpath ="//*[@id='birthDateMonth_0']" )
    public WebElement months;

    @FindBy(xpath ="//*[@id='birthDateYear_0']" )
    public WebElement years;

    @FindBy(xpath ="//*[@data-testid='reservation-passenger-foreign-checkbox-input']" )
    public List<WebElement> citizens;

    @FindBy(xpath ="//label[@for='gender_M_0']" )
    public WebElement man;

    @FindBy(id ="continue-button" )
    public WebElement nextpay;

    @FindBy(xpath ="//*[@data-testid='payment-form-submit-button']" )
    public WebElement pay;

    //cookie
    public void acceptcookie(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement cookie = wait.until(ExpectedConditions.elementToBeClickable(cookieButton));
            cookie.click();
            logger.info("Çerez bildirimi kabul edildi.");
        } catch (TimeoutException e) {
            logger.warn("Çerez bildirimi bulunamadı veya zaten kapalı.");
        } catch (Exception e) {
            logger.error("Çerez bildirimi kapatılamadı: " + e.getMessage());
        }

    }

    public void controlflightticket(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement ticketbutton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button//span[contains(.,'Uçak bileti')]")));
        ticketbutton.click();

        String w1 = ticketbutton.getText();
        softAssert.assertEquals(w1,"Uçak bileti");
    }

    public void selectoneway(){
        onewaytext.click();
    }

    public void entryfromwhere(){
        // click sabiha
        fromwhere.click();
        fromwhereinput.sendKeys("sabiha");
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement sabiha = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-testid='autosuggestion-custom-item-istanbul-sabiha-gokcen-havalimani']")));
        sabiha.click();
    }

    public void entrytowhere(){
        // click izmir
        towhere.click();
        towhereinput.sendKeys("izmir");
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement izmir = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-testid='autosuggestion-custom-item-izmir-adnan-menderes-havalimani']")));
        izmir.click();
    }

    public void selectonewayDate(){
        // select onedate
        onedateinput.click();
        onedateselect.click();
    }

    public void findticket(){
        submitbtn.click();
    }

    public void comeback(){
        driver.navigate().back();
    }

    public void selectmultiway(){
        multidestinationtext.click();
    }

    public void addaflight(){
        addflight.click();
    }

    public void entryfromwhere1(){
        // click sabiha
        fromwhere1.click();
        fromwhereinput1.sendKeys("sabiha");
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement sabiha = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-testid='autosuggestion-custom-item-istanbul-sabiha-gokcen-havalimani']")));
        sabiha.click();
    }

    public void entrytowhere1(){
        // click izmir
        towhere1.click();
        towhereinput1.sendKeys("izmir");
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement izmir = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-testid='autosuggestion-custom-item-izmir-adnan-menderes-havalimani']")));
        izmir.click();
    }

    public void multiDate1(){
        // select onedate
        dateinput1.click();
        dateselect1.click();
    }

    public void entryfromwhere2(){
        // click izmir
        fromwhere2.click();
        fromwhereinput2.sendKeys("izmir");
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement sabiha = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-testid='autosuggestion-custom-item-izmir-adnan-menderes-havalimani']")));
        sabiha.click();
    }

    public void entrytowhere2(){
        // click izmir
        towhere2.click();
        towhereinput2.sendKeys("antalya");
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement izmir = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-testid='autosuggestion-custom-item-antalya-havalimani']")));
        izmir.click();
    }

    public void multiDate2(){
        // select onedate
        dateinput2.click();
        dateselect2.click();
    }

    public void entryfromwhere3(){
        // click antalya
        fromwhere3.click();
        fromwhereinput3.sendKeys("antalya");
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement sabiha = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-testid='autosuggestion-custom-item-antalya-havalimani']")));
        sabiha.click();
    }

    public void entrytowhere3(){
        // click antalya
        towhere3.click();
        towhereinput3.sendKeys("sabiha");
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement izmir = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-testid='autosuggestion-custom-item-istanbul-sabiha-gokcen-havalimani']")));
        izmir.click();
    }

    public void multiDate3(){
        // select Third date
        dateinput3.click();
        dateselect3.click();
    }

    public void Mselectcabin(){
        selectCabin.click();
    }

    public void MadultPLus(){
        adultplus.click();
    }
    public void MchildPLus(){
        childplus.click();
    }
    public void MinfantPLus(){
        infantplus.click();
    }
    public void MDoneseacrh(){
        donebutton.click();
    }
    public void MFindticket(){
        seacrhticket.click();
    }

    public void chooseFlight(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-testid='selectedFlighButton']")));

        chooseflight.get(0).click();

        WebDriverWait wait1= new WebDriverWait(driver, Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-testid='selectAndNextButton']")));

    }

//    public void chooseComfort(){
//        choosecomfortable.click();
//    }
    public void chooseAndNEXT(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-testid='selectedFlighButton']")));

        chooseAndnext.click();

    }

    public void contactinfo(){
        email.click();
        email.sendKeys("mert@guler.com");
        phone.click();
        phone.sendKeys("365676573");
    }


}
