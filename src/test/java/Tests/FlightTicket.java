package Tests;

import Pages.HomePage;
import Utils.RMethods;
import io.qameta.allure.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static Utils.DriverFactory.getDriver;
import static Utils.LogHelper.logger;

@Epic("The Pay Screen Go")
@Feature("Flight Flow")
public class FlightTicket extends BaseTest {
    private static final Logger log = LoggerFactory.getLogger(FlightTicket.class);
    SoftAssert softAssert = new SoftAssert();
    HomePage homePage = new HomePage(getDriver());


    @Test(priority = 1 , description = "The One Way Take A Flight Ticket")
    @Severity(SeverityLevel.CRITICAL)
    @Story("The One Way is List Ticket")
    public void OneWayTest(){

    //İstanbul → İzmir için tek yön uçuş araması yapılması ve sonuçların listelenmesi
        Allure.step("Cookie Accept");
        homePage.acceptcookie();
        logger.info("cookie accept");

        Allure.step("Control Flight Ticket");
        homePage.controlflightticket();
        logger.info("Control Flight Ticket");

        Allure.step("Select One Way");
        homePage.selectoneway();
        logger.info("Select One Way");

        Allure.step("Entry From Where");
        homePage.entryfromwhere();
        logger.info("Entry From Where");

        Allure.step("Entry To Where");
        homePage.entrytowhere();
        logger.info("Entry To Where");

        Allure.step("Select One Way Date");
        homePage.selectonewayDate();
        logger.info("Select One Way Date");

        Allure.step("Find Ticket Click Button");
        homePage.findticket();
        logger.info("Find Ticket Click Button");

        Allure.step("Wait For List");
        RMethods.ListWait(getDriver(),"//*[@data-testid='flight-favorite-button']");
        logger.info("Wait For List");
    }


    @Test(priority = 2 ,description = "The Multi Way Take A Flight Ticket")
    @Severity(SeverityLevel.CRITICAL)
    @Story("The Multi Way is List Ticket")
    public void MultiWayTest(){
//  İstanbul → İzmir → Antalya çoklu uçuş araması ve sonuçların listelenmesi
//  2 yetişkin, 1 çocuk, 1 bebek yolcuyla bilet alınması


        Allure.step("page go to back");
        homePage.comeback();
        logger.info("page go to back");

        Allure.step("Control Flight Ticket");
        homePage.controlflightticket();
        logger.info("Control Flight Ticket");

        Allure.step("Select Multi Way");
        homePage.selectmultiway();
        logger.info("Select Multi Way");

        Allure.step("add to flight");
        homePage.addaflight();
        logger.info("add to flight");

        Allure.step("Entry From Where1");
        homePage.entryfromwhere1();
        logger.info("Entry From Where1");

        Allure.step("Entry To Where1");
        homePage.entrytowhere1();
        logger.info("Entry To Where1");

        Allure.step("Select First Flight Date");
        homePage.multiDate1();
        logger.info("Select First Flight Date");

        Allure.step("Entry From Where2");
        homePage.entryfromwhere2();
        logger.info("Entry From Where2");

        Allure.step("Entry To Where2");
        homePage.entrytowhere2();
        logger.info("Entry To Where2");

        Allure.step("Select Second Flight Date");
        homePage.multiDate2();
        logger.info("Select Second Flight Date");

        Allure.step("Entry From Where3");
        homePage.entryfromwhere3();
        logger.info("Entry From Where3");

        Allure.step("Entry To Where3");
        homePage.entrytowhere3();
        logger.info("Entry To Where3");

        Allure.step("Select Third Flight Date");
        homePage.multiDate3();
        logger.info("Select Third Flight Date");

        Allure.step("Select Cabin count");
        homePage.Mselectcabin();
        logger.info("Select Cabin count");

        Allure.step("Plus One adult");
        homePage.MadultPLus();
        logger.info("Plus One adult");

        Allure.step("Plus One child");
        homePage.MchildPLus();
        logger.info("Plus One child");

        Allure.step("Plus One inFant");
        homePage.MinfantPLus();
        logger.info("Plus One inFant");

        Allure.step("Click Done Button");
        homePage.MDoneseacrh();
        logger.info("Click Done Button");

        Allure.step("Click Search Button");
        homePage.MFindticket();
        logger.info("Click Search Button");

        Allure.step("Wait For List");
        RMethods.ListWait(getDriver(),"//span[normalize-space()='Sırala:']");
        logger.info("Wait For List");
    }


    @Test(priority = 3 ,description = "Choose Suitable Flight")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Choose Suitable Flight")
    public void choosesuitableflightTest(){

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Allure.step("Select First Flight");
        //1.Flight
        homePage.chooseFlight();
        RMethods.choosecomfortable(getDriver(),"//div[@data-testid='BASIC']");
        homePage.chooseAndNEXT();
        logger.info("Select First Flight");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Allure.step("Select Second Flight");
        //2.Flight
        homePage.chooseFlight();
        RMethods.choosecomfortable(getDriver(),"//div[@data-testid='SUNVALUE']");
        homePage.chooseAndNEXT();
       logger.info("Select Second Flight");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Allure.step("Select third Flight");
        //3.Flight
        homePage.chooseFlight();
        RMethods.choosecomfortable(getDriver(),"//div[@data-testid='Comfort Flex']");
        homePage.chooseAndNEXT();
        logger.info("Select third Flight");

        Allure.step("Wait For Form");
        RMethods.ListWait(getDriver(),"//*[@id='emailValidationContainer']");
        logger.info("Wait For Form");
    }


    @Test(priority = 4 ,description = "Control Flight Assertions")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Control Flight Assertions")
    public void ControlFlightt(){

        Allure.step("control flight cards");
        RMethods.Controlticketinfo(getDriver(),homePage.numflights,homePage.routeflights,
                homePage.howmanytimedepartures,homePage.howmanytimearrivals,
                homePage.howmanytimetotals);
       logger.info("control flight cards");
    }


    @Test(priority = 5 ,description = "Fill Form İnformation")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Fill Form İnformation")
    public void FillForm(){
        Allure.step("Page go to Top");
        RMethods.ScrollWithElement(getDriver(), homePage.pagetop);
        logger.info("Page go to Top");

        Allure.step("The entry is contact İnfo");
        homePage.contactinfo();
        logger.info("The entry is contact İnfo");

        Allure.step("The Entry is Person info");
        RMethods.Entryinfor(getDriver(),homePage.numberperson,homePage.names,homePage.surnames,
            homePage.days, homePage.months, homePage.years,
            homePage.citizens,homePage.man);
        logger.info("The Entry is Person info");


        RMethods.ScrollWithElement(getDriver(), homePage.nextpay);
        homePage.nextpay.click();
    }

}
