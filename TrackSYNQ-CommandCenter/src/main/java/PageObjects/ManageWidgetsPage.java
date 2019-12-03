package PageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import Common.ConfigManager;
import Common.ActionMethods;

public class ManageWidgetsPage extends ActionMethods {

	private String manageWidgetNavbar = "xpath:.//span[text()='Manage Widgets']";
	private String subManageWidgetNavbar = "css:a[href='javascript:void(0);']";
	private String subManageWidgetNavbarCheckBox = "css:.ant-checkbox.ant-checkbox-checked";
	private String subManageWidgetNavbarUnCheckBox = "css:input.ant-checkbox-input";
	private String manageWidgetUpdateButton = "xpath://span[text()='Update']";
	private String updateSuccessfullMessage = "css:div.ant-notification-notice-message";

	static WebDriver driver;
	public String errorMsg;

	public Logger log = Logger.getLogger(ManageWidgetsPage.class);
	ConfigManager config;

	public ManageWidgetsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		config = new ConfigManager();
	}

	public void clickOnManageWidgetNavbar() {
		waitForElementClickable(manageWidgetNavbar, LONGWAIT);
		safeClick(manageWidgetNavbar, LONGWAIT);
	}

	public void clickOnSubManageWidgetNavbar() {
		waitForElementClickable(subManageWidgetNavbar, MEDIUMWAIT);
		safeClick(subManageWidgetNavbar, MEDIUMWAIT);

	}

	public void clickOnAllManageWidgetUnCheckBox() {

		waitForElementClickable(subManageWidgetNavbarCheckBox, SHORTWAIT);
		safeClick(subManageWidgetNavbarCheckBox, LONGWAIT);

	}

	public void clickOnAllSubManageWidgetNavbarCheckBox() {

		waitForElementClickable(subManageWidgetNavbarUnCheckBox, SHORTWAIT);
		safeClick(subManageWidgetNavbarUnCheckBox, LONGWAIT);

	}

//	public void clickOnManageWidgetUpdateButton() {
//		waitForElementClickable(manageWidgetUpdateButton, LONGWAIT);
//		safeJavaScriptClick(manageWidgetUpdateButton);
//	}	

	public void clickOnManageWidgetUpdateButton() {
		needToWait(3);
		waitForElementClickable(manageWidgetUpdateButton, SHORTWAIT);
		waitForElementVisible(manageWidgetUpdateButton, SHORTWAIT);
		String browserName = config.getProperty("Browser.Name");
		needToWait(2);
		if (browserName.equalsIgnoreCase("ie")) {
			WebElement element = driver.findElement(findLocator(manageWidgetUpdateButton));
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
		} else {
			safeJavaScriptClick(manageWidgetUpdateButton);
		}
		needToWait(3);
		log.info("click On Manage Widget Update Button");
	}

	public String isUpdateSuccessfullMessagePresent() {
		errorMsg = safeGetText(updateSuccessfullMessage, SHORTWAIT);
		return errorMsg;
	}

}
