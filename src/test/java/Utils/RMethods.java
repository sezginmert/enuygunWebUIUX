package Utils;


import Tests.BaseTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.sql.DriverManager;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;

public class RMethods extends BaseTest {

  // Hotel

    public static void clickElementByDataId(String elementId) {

        // Create XPath from id parameter

        String xpath = "//*[@data-testid='" + elementId + "']";

        // Find the element
        WebElement element = driver.findElement(By.xpath(xpath));

        // Visibility check (optional)
        Assert.assertTrue(element.isDisplayed(), "Element is not visible: " + elementId);

        // Click
        element.click();
    }

    public static void clickAndSendKeysByDataId(String elementId, String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String xpath = "//*[@data-testid='" + elementId + "']";

        // Wait for the element to exist and be visible
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));

        // If the element is input or textarea, no need to click, otherwise click
        String tagName = element.getTagName();
        if (!tagName.equalsIgnoreCase("input") && !tagName.equalsIgnoreCase("textarea")) {
            element.click();
        }

        // Send text
        element.sendKeys(text);
    }

    public static void clickByExactText(String text) {
        WebElement element = driver.findElement(By.xpath("//*[text()='" + text + "']"));
        element.click();
    }

    public static void waitFor(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            // If the thread is unexpectedly interrupted, re-signal the interrupt status
            Thread.currentThread().interrupt();
            System.out.println("Wait interrupted: " + e.getMessage());
        }
    }

    public void switchToNewTab() {
        // Get all window/tab handles
        Set<String> windowHandles = driver.getWindowHandles();
        String currentHandle = driver.getWindowHandle();

        // To find the handle of the newly opened tab
        for (String handle : windowHandles) {
            if (!handle.equals(currentHandle)) {
                // Switch to the new tab
                driver.switchTo().window(handle);
                break;
            }
        }
    }

    public static void scrollTo(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'})", element);
    }



    //Flight
    public static void ListWait(WebDriver driver, String ElementID) {

        // Bekleme süresi
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ElementID)));

    }

    public static void choosecomfortable(WebDriver driver, String ElementID) {

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement Clickelement = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ElementID)));
        Clickelement.click();
    }

    public static void Controlticketinfo(WebDriver driver, List<WebElement> numflight, List<WebElement> citytocity,
                                         List<WebElement> departura, List<WebElement> arrival,
                                         List<WebElement> totaltravel) {
        SoftAssert softAssert = new SoftAssert();

        for (int i = 0; i < numflight.size(); i++) {

            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", numflight.get(i));

            String numflighttext = numflight.get(i).getText();
            String citytocitext = citytocity.get(i).getText();

            softAssert.assertEquals(numflight.get(i).getText(), numflighttext, i + "Same flight");
            softAssert.assertEquals(citytocity.get(i).getText(), citytocitext, i + "Same route");

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            LocalTime departura1 = LocalTime.parse(departura.get(i).getText(), formatter);
            LocalTime arrival1 = LocalTime.parse(arrival.get(i).getText(), formatter);

            // Gece yarısı geçiş kontrolü
            if (arrival1.isBefore(departura1)) {
                arrival1 = arrival1.plusHours(24);
            }

            Duration difference = Duration.between(departura1, arrival1).abs();
            long diffHours = difference.toHours();
            long diffMinutes = difference.toMinutes() % 60;

            String HM = diffHours + "sa " + diffMinutes + "dk";
            softAssert.assertEquals(HM, totaltravel.get(i).getText(), "Same Time");
        }
        softAssert.assertAll();
    }

    public static void ScrollWithElement(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void Entryinfor(WebDriver driver, List<WebElement> numperson, List<WebElement> name, List<WebElement> surname,
                                  WebElement day, WebElement month, WebElement year,
                                  List<WebElement> citizen, WebElement gender) {
        SoftAssert softAssert = new SoftAssert();

        for (int i = 0; i < numperson.size(); i++) {

            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", numperson.get(i));

            if (numperson.get(i).getText().contains("1. Yetişkin")) {

                name.get(i).sendKeys("Mert");
                surname.get(i).sendKeys("Mert");

                //day
                String idValue = day.getAttribute("id");
                String newValue = idValue.replace("0", String.valueOf(i));
                WebElement element = driver.findElement(By.xpath("//*[@id='" + newValue + "']"));
                Select select = new Select(element);
                select.selectByValue("15");

                //month
                String idValue1 = month.getAttribute("id");
                String newValue1 = idValue1.replace("0", String.valueOf(i));
                WebElement element1 = driver.findElement(By.xpath("//*[@id='" + newValue1 + "']"));
                Select select1 = new Select(element1);
                select1.selectByValue("07");

                //year
                String idValue2 = year.getAttribute("id");
                String newValue2 = idValue2.replace("0", String.valueOf(i));
                WebElement element2 = driver.findElement(By.xpath("//*[@id='" + newValue2 + "']"));
                Select select2 = new Select(element2);
                select2.selectByValue("1994");

                citizen.get(i).click();
                gender.click();
            }

            if (numperson.get(i).getText().contains("2. Yetişkin")) {

                name.get(i).sendKeys("Oguzhan");
                surname.get(i).sendKeys("Mert");

                //day
                String idValue3 = day.getAttribute("id");
                String newValue3 = idValue3.replace("0", String.valueOf(i));
                WebElement element3 = driver.findElement(By.xpath("//*[@id='" + newValue3 + "']"));
                Select select3 = new Select(element3);
                select3.selectByValue("15");

                //month
                String idValue4 = month.getAttribute("id");
                String newValue4 = idValue4.replace("0", String.valueOf(i));
                WebElement element4 = driver.findElement(By.xpath("//*[@id='" + newValue4 + "']"));
                Select select4 = new Select(element4);
                select4.selectByValue("07");

                //year
                String idValue5 = year.getAttribute("id");
                String newValue5 = idValue5.replace("0", String.valueOf(i));
                WebElement element5 = driver.findElement(By.xpath("//*[@id='" + newValue5 + "']"));
                Select select5 = new Select(element5);
                select5.selectByValue("1980");

                citizen.get(i).click();
                gender.click();
            }

            if (numperson.get(i).getText().contains("Çocuk")) {

                name.get(i).sendKeys("Sezgin");
                surname.get(i).sendKeys("Mert");

                //day
                String idValue6 = day.getAttribute("id");
                String newValue6 = idValue6.replace("0", String.valueOf(i));
                WebElement element6 = driver.findElement(By.xpath("//*[@id='" + newValue6 + "']"));
                Select select6 = new Select(element6);
                select6.selectByValue("15");

                //month
                String idValue7 = month.getAttribute("id");
                String newValue7 = idValue7.replace("0", String.valueOf(i));
                WebElement element7 = driver.findElement(By.xpath("//*[@id='" + newValue7 + "']"));
                Select select7 = new Select(element7);
                select7.selectByValue("07");

                //year
                String idValue8 = year.getAttribute("id");
                String newValue8 = idValue8.replace("0", String.valueOf(i));
                WebElement element8 = driver.findElement(By.xpath("//*[@id='" + newValue8 + "']"));
                Select select8 = new Select(element8);
                select8.selectByValue("2015");

                citizen.get(i).click();
                gender.click();


            }

            if (numperson.get(i).getText().contains("Bebek")) {

                name.get(i).sendKeys("Parla");
                surname.get(i).sendKeys("Mert");

                //day
                String idValue9 = day.getAttribute("id");
                String newValue9 = idValue9.replace("0", String.valueOf(i));
                WebElement element9 = driver.findElement(By.xpath("//*[@id='" + newValue9 + "']"));
                Select select9 = new Select(element9);
                select9.selectByValue("15");

                //month
                String idValue10 = month.getAttribute("id");
                String newValue10 = idValue10.replace("0", String.valueOf(i));
                WebElement element10 = driver.findElement(By.xpath("//*[@id='" + newValue10 + "']"));
                Select select10 = new Select(element10);
                select10.selectByValue("07");

                //year
                String idValue11 = year.getAttribute("id");
                String newValue11 = idValue11.replace("0", String.valueOf(i));
                WebElement element11 = driver.findElement(By.xpath("//*[@id='" + newValue11 + "']"));
                Select select11 = new Select(element11);
                select11.selectByValue("2024");

                citizen.get(i).click();
                gender.click();
            }

            softAssert.assertAll();
        }


    }


}
