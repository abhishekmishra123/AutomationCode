package Common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;
import static Common.TimeOut.MEDIUMWAIT;

public class Sync implements TimeOut {
WebDriver driver;

    public WebElement findElement(String locatorString) {
        return driver.findElement(findLocator(locatorString));
    }

    public By findLocator(String locatorString) {
        String string = locatorString;
        String[] parts = string.split(":");
        String type = parts[0]; // 004
        String object = parts[1];
        if (parts.length > 2) {
            for (int i = 2; i < parts.length; i++) {
                object = object + ":" + parts[i];
            }
        }
        By by = null;
        if (type.equals("id")) {
            by = By.id(object);
        } else if (type.equals("name")) {
            by = By.name(object);
        } else if (type.equals("class")) {
            by = By.className(object);
        } else if (type.equals("link")) {
            by = By.linkText(object);
        } else if (type.equals("partiallink")) {
            by = By.partialLinkText(object);
        } else if (type.equals("css")) {
            by = By.cssSelector(object);
        } else if (type.equals("xpath")) {
            by = By.xpath(object);
        } else {
            throw new RuntimeException(
                    "Please provide correct element locating strategy");
        }
        return by;
    }



    public int getWaitTime(int[] optionalWaitArray) {
        if (optionalWaitArray.length <= 0) {
            return MEDIUMWAIT;
        } else {
            return optionalWaitArray[0];
        }
    }

    public boolean isElementVisible(String locatorString, int... optionWaitTime) {
        int waitTime = getWaitTime(optionWaitTime);
        boolean bFlag = false;
        nullifyImplicitWait();
        //log.info("Waiting until element " + locatorString + " is visible");
//        try {
//            WebDriverWait wait = new WebDriverWait(driver, waitTime);
//            wait.until(ExpectedConditions
//                    .visibilityOfElementLocated(findLocator(locatorString)));
//            setImplicitWait(IMPLICITWAIT);
//            if (findElement((locatorString)).isDisplayed()) {
//                bFlag = true;
//                log.info("Element " + locatorString + " is displayed");
//            }
//        } catch (NoSuchElementException e) {
//            log.info("Element " + locatorString + " was not displayed"
//                    + UtilityMethods.getStackTrace());
//        } catch (TimeoutException e) {
//            log.info("Element " + locatorString + " was not visible in time - "
//                    + waitTime + UtilityMethods.getStackTrace());
//        }
//
//        catch (Exception e) {
//            log.error("Element " + locatorString + " was not displayed"
//                    + UtilityMethods.getStackTrace());
//            Assert.fail("Element " + locatorString + " was not displayed."
//                    + UtilityMethods.getStackTrace());
//        }
        return bFlag;
    }


    public void nullifyImplicitWait() {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }

    public void needToWait(int waitInSec) {
        try {
            Thread.sleep(waitInSec * 1000);
        } catch (Exception e) {
        }
    }
}
