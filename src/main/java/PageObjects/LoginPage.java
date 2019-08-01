package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

import static Common.TimeOut.SHORTWAIT;
//import static java.lang.Thread.sleep;

public class LoginPage  {


    WebDriver driver;

    private String contactNavbar = "xpath://a[text()='Contact us']";


    public void clickOnContactNavbar(){
        driver.findElement(By.xpath("//a[text()='Contact us']")).click();
    }


}
