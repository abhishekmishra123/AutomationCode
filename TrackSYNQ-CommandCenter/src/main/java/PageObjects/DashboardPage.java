package PageObjects;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;


import Common.ConfigManager;
import Common.ActionMethods;

public class DashboardPage extends ActionMethods {

	private String dashboardNavBar = "css:h3 a[href='/dashboard']";
	
	private String dashboardMapSection = "css:span.lm_title";
	private String dashboardPermissionDenied = "xpath://span[text()='Permission Denied!']";
	
	
	

	
	String errorMsg;
	

	static WebDriver driver;
	public Logger log = Logger.getLogger(DashboardPage.class);
	ConfigManager config;

	public DashboardPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		config = new ConfigManager();
	}
	
		
	public boolean isDashboardNavbarPresent() {
		return isElementPresent(dashboardNavBar, SHORTWAIT);
		
	}
	
	public boolean isDashboardSectionPresent() {
		needToWait(2);
		return isElementPresent(dashboardMapSection, LONGWAIT);
		
	}
	
	public String getTextDashboardMapSection() {
		errorMsg = safeGetText(dashboardMapSection, SHORTWAIT);
		return errorMsg;
		}

	public void clickOnDashBoardNavbar() {
		waitForElementClickable(dashboardNavBar, LONGWAIT);
		safeJavaScriptClick(dashboardNavBar);
		
	}
	public boolean isDashboardPermissionDeniedPresent() {
		return isElementPresent(dashboardPermissionDenied, LONGWAIT);
		
	}
	
	
	
}
