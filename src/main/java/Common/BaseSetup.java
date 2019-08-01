package Common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import sun.security.provider.ConfigFile;

import java.io.*;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseSetup {

  static  WebDriver driver;
  static Properties prop;
  static FileInputStream fs;


   public BaseSetup() throws IOException{

       fs= new FileInputStream(System.getProperty("user.dir")+"Config/Sys.properties");
       prop = new Properties();
       prop.load(fs);
    }

public  static void initialization(){
       String browserName = prop.getProperty("browser");
       if(browserName.equals("chrome"))
       {
           System.setProperty("webdriver.chrome.driver", "/Users/machd/Downloads/chromedriver");
           driver = new ChromeDriver();
       }

     else if(browserName.equals("FF"))
    {
        System.setProperty("webdriver.gecko.driver", "/Users/machd/Downloads/geckodriver");
        driver = new FirefoxDriver();
    }
     driver.manage().window().maximize();
     driver.manage().deleteAllCookies();
     driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
     driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

     driver.get(prop.getProperty("url"));
   }


}