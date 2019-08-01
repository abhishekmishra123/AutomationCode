package Common;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.util.List;


public class ActionMethod extends Sync {

    /**
     *
     * This method is used to return list of WebElements matched String
     * locatorString
     *
     * @param locatorString
     * @return
     */
    public List<WebElement> locatorStringWebElements(String locatorString) {
        List<WebElement> list = null;
        try {
            list = driver.findElements(findLocator(locatorString));
        } catch (Exception e) {
           // log.error("Some exception occured while retriving web elements of a locatorString, exception message: "
                   // + e.getMessage());
            Assert.fail("Some exception occured while retriving web elements of a locatorString, exception message: "
                    + e.getMessage());
        }
        return list;
    }




}
