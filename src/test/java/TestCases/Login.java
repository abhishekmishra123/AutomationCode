package TestCases;

import PageObjects.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login {

    WebDriver driver;
    LoginPage loginPage=null;

    @BeforeMethod
    void setup()
    {
        System.out.println("This is opening browser");
        //System.setProperty("webdriver.gecko.driver", "/Users/machd/Downloads/geckodriver");
        System.setProperty("webdriver.chrome.driver", "/Users/machd/Downloads/chromedriver");
        //driver= new FirefoxDriver();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.liseinfotech.com/");
    }

    @Test(priority = 1)
    public void Verify_URL(){
        System.out.println("Hello");
        loginPage = new LoginPage();
        loginPage.clickOnContactNavbar();
    }

    @Test(priority = 2)
    public void Verify_Logo(){
        System.out.println("Hello");
        //loginPage = new LoginPage();
        loginPage.clickOnContactNavbar();
        //Assert.assertTrue(loginPage.isLiseLogoImagePresent());

    }

    @Test(priority = 3)
    public void Verify_Login_button(){
        System.out.println("Hello");

    }

    @AfterClass
    void close()
    {
        driver.close();
    }

}

