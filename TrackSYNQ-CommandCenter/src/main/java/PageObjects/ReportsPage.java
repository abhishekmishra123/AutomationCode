package PageObjects;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.sun.webkit.ContextMenu.ShowContext;

import Common.ConfigManager;
import Common.ActionMethods;

public class ReportsPage extends ActionMethods {

	private String reportsSidebar = "xpath://body//li[17]";
	private String reportsSidebarTripStopDetailed = "xpath://a[contains(text(),'Trips Report')]";
	private String emailOnDemands = "xpath://div[@class='ant-card-head']//button[1]";
	private String cancelButtonEmailOnDemands = "xpath://button[@class='ant-btn ant-btn-danger']";
	private String crossButtonEmailOnDemands = "xpath://span[@class='ant-modal-close-x']";
	private String objectLabel = "css:label[for='device_id']";
	private String alertsTypeLabel = "css:label[for='alerttype_id']";
	private String alertsTypeField = "css:div#alerttype_id";
	private String periodLabel = "css:label[for='period']";
	private String speedFilterLabel = "css:label[for='filter']";
	private String speedLabel = "css:label[for='speed']";
	private String PDF = "xpath://div//div[@class='ant-card-head-wrapper']//div[2]//button[num]";
	private String reportHeadingColumn = "xpath://div[@class='ant-table-wrapper']//th[num]";
	private String email = "css:td.alert.alert-warning";
	private String deleteEmailOnYopmail = "xpath://table[@class='barreinbox']//tbody//tr//td[2]";
	private String deleteEmptyEmailOnYopmail = "xpath://a[@class='igif lmen_all']";
	private String emailOnDemandType = "css:input#email_on_demand";
	private String emailSubmit = "css:button[type='submit']";
	private String reportHomeLink = "xpath://div[@class='ant-breadcrumb']//a[text()= 'Home']";
	private String reportsLink = "xpath://div[@class='ant-breadcrumb']//span[text()= 'Reports']";
	private String reportsLogsLink = "xpath://div[@class='ant-breadcrumb']//span[text()= 'Report Logs']";
	private String tripStopDetailedLink = "xpath://div[@class='ant-breadcrumb']//span[text()= 'Trips Report']";
	private String scheduleReportLink = "xpath://span[contains(text(),'Schedule Report')]";
	private String reportsLogsTitle = "xpath://div[@class='ant-card-head-title']";
	private String reportLogsDropdown = "xpath://div[@class='ant-select-selection-selected-value']";
	private String reportTripStopDetailedDropdownOption = "xpath://li[contains(text(),'Trip Stop Detailed')]";
	private String periodDropdownSelect = "xpath://div[contains(text(),'Select Period')]";
	private String monthDayDrpDwn = "css:#month_day";
	private String scheduleDropdownSelectOption = "xpath://ul[contains(@class,'ant-select-dropdown-menu  ant-select-dropdown-menu-root ant-select-dropdown-menu-vertical')]//li";
	private String scheduleReportDropdownSelect = "xpath://div[@class='ant-select-selection-selected-value'][contains(text(),'Schedule Name')]";
	private String addScheduleReportButton = "xpath://div[@class='extrabtn']//button[@class='ant-btn ant-btn-primary']";
	private String speedDropdownPlaceholder = "css:div[title='Select Speed']";
	private String periodDropdownDaily = "xpath://li[contains(text(),'Daily')]";
	private String startDate = "xpath://span[@id='start_date']//input[@placeholder='Select Start Date']";
	private String previousMonth = "css:a[title='Previous month (PageUp)']";
	private String selectMarchFirstdate = "xpath://tr[1]//td[6]//div[@class='ant-calendar-date']";
	private String endDate = "xpath://span[@id='end_date']//input[@placeholder='Select End Date']";

	private String startDateValidationMessage = "xpath://div[contains(text(),'Please Select Start Date')]";
	private String endDateValidationMessage = "xpath://div[contains(text(),'Please Select End Date')]";
	private String getReportLogsValueDropdown = "xpath://ul//li[contains(text(),'Vehicle Name')]";
	private String getReportLogsHeadingText = "xpath://ul//li[contains(text(),'Vehicle Name')]";
	private String searchField = "css:input.ant-input.ant-select-search__field";
	private String pagination = "css:ul.ant-pagination.ant-table-pagination.mini";
	private String emailOnDemandDialogTitle = "css:div#rcDialogTitle0";
	private String emailOnDemandLabel = "xpath://label[@class='ant-form-item-required']";
	private String tripReportObject = "css:div#device_id";
	private String vehicleName = "xpath://li[contains(text(),'Vehicle01')]";
	private String emailOnDemandCancelBtn = "xpath://button[@class='ant-btn ant-btn-danger']";
//	private String addScheduleReportSaveBtn = "xpath://button[@class='ant-btn ant-btn-primary']";
	private String addScheduleReportSaveBtn = "xpath://div[@class='ant-modal-footer']//button[@class='ant-btn ant-btn-primary']";

	private String emailOnDemandSendRequestBtn = "xpath://div[@class='ant-modal-body']//button[@class='ant-btn ant-btn-primary']";
	private String emailOnDemandCrossBtn = "css:span.ant-modal-close-x";
	private String emailOnDemandEmailField = "css:input#email_on_demand";
	private String emailOnDemandEmailFieldPlaceholder = "css:input[placeholder='Enter Email ID']";
	private String emailOnDemandEmailFieldErrorMessage = "xpath://div[text()='Please Enter Email ID']";
	private String reportLogsPresent = "xpath://td[text()='MB02-Teltonika']";
	private String firstPage = "css:li[title='1']";
	private String firstPageCount = "xpath://tbody[@class='ant-table-tbody']//tr";
	private String reportTypeValue = "css:td.ant-table-column-has-actions.ant-table-column-has-sorters:nth-child(3)";
	private String reportTypeHeading = "xpath://div[contains(text(),'Report Type')]";
	private String resetButton = "css:button.ant-btn-danger";
	private String searchButton = "css:button[type='submit']";
	private String speedFilterDrpdwn = "xpath://div[@id='filter']";
	private String vehiclePlaceholder = "xpath://div[text()='Select Vehicle']";
	private String scheduleName = "css:input[placeholder='Enter Schedule Name']";
	private String periodField = "xpath://div[@class='ant-select-selection-selected-value'][contains(text(),'Select Period')]";
	private String selectObjectValidation = "xpath://div[contains(text(),'Please Select Vehicle')]";
	private String selectReportPeriodValidation = "xpath://div[contains(text(),'Please Select Report Period')]";
	private String selectPeriodValidation = "xpath://div[contains(text(),'Please Select Period')]";
	private String antNotificationMessage = "xpath://div[@class='ant-notification-notice-message']";
	private String speedFilterDrpdwnOptionEqualsTo = "xpath://li[text()='Equals To']";
	private String speedFilterDrpdwnOptionLessThan = "xpath://li[text()='Less Than']";
	private String speedFilterDrpdwnOptionGreaterThen = "xpath://li[text()='Greater Than']";
	private String speedFilterDrpdwnOptionLessThanEquals = "xpath://li[text()='Less Than Equals']";
	private String speedFilterDrpdwnOptionGreaterThanEquals = "xpath://li[text()='Greater Than Equals']";
	private String listData = "xpath://tbody[@class='ant-table-tbody']//tr";
	private String scheduleNameValidation = "xpath://div[text()='Please Enter Schedule Name']";
	private String addScheduleReportPopup = "css:div.ant-modal";
	private String startTime = "css:#startTime";
	private String endTime = "css:#startTime";
	private String drawHistoryPointsPopupHeading = "css:#rcDialogTitle0";
	private String playButton = "xpath://button[@name='Play']";
	
	private String trackSpeed = "xpath://div/div[@class='ant-select ant-select-enabled']/div[1]";
	
	
	
	
	
	
	
	
	

	static WebDriver driver;
	public String errorMsg;
	public String backgroundColor, color, fontFamily;

	public Logger log = Logger.getLogger(ReportsPage.class);
	ConfigManager config;

	public ReportsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		config = new ConfigManager();
	}

	// This function is used for click on Reports Side bar
	public void clickOnReportsSidebar() {
		mouseHover(reportsSidebar, LONGWAIT);
		safeClick(reportsSidebar, SHORTWAIT);
	}

	// This function is used for click on report logs side bar
	public void clickOnReportsSidebarReportsLog() {
		mouseHover(reportsSidebar, LONGWAIT);
		mouseHover(reportsSidebarTripStopDetailed.replace("Trips Report", "Report Logs"), MEDIUMWAIT);
		safeClick(reportsSidebarTripStopDetailed.replace("Trips Report", "Report Logs"), MEDIUMWAIT);
	}

	// This function is used for click on Trips Report side bar
	public void clickOnReportsSidebarTripStopDetailed() {
		mouseHover(reportsSidebar, LONGWAIT);
		mouseHover(reportsSidebarTripStopDetailed, MEDIUMWAIT);
		waitForElementClickable(reportsSidebarTripStopDetailed, MEDIUMWAIT);
		safeClick(reportsSidebarTripStopDetailed, MEDIUMWAIT);
	}

	// This function is used for click on Speeding Report side bar
	public void clickOnReportsSidebarSpeedingReport() {
		mouseHover(reportsSidebar, LONGWAIT);
		mouseHover(reportsSidebarTripStopDetailed.replace("Trips Report", "Speeding Report"), MEDIUMWAIT);
		safeJavaScriptClick(reportsSidebarTripStopDetailed.replace("Trips Report", "Speeding Report"));
	}

	// This function is used for click on Events Report side bar
	public void clickOnReportsSidebarEventsReport() {
		mouseHover(reportsSidebar, LONGWAIT);
		mouseHover(reportsSidebarTripStopDetailed.replace("Trips Report", "Events Report"), MEDIUMWAIT);
		safeClick(reportsSidebarTripStopDetailed.replace("Trips Report", "Events Report"), MEDIUMWAIT);
	}

	// This function is used for click on Schedule Report side bar
	public void clickOnReportsSidebarScheduleReport() {
		mouseHover(reportsSidebar, LONGWAIT);
		mouseHover(reportsSidebarTripStopDetailed.replace("Trips Report", "Schedule Report"), MEDIUMWAIT);
		safeClick(reportsSidebarTripStopDetailed.replace("Trips Report", "Schedule Report"), MEDIUMWAIT);
	}

	// This function is used for click on History Points side bar
	public void clickOnReportsSidebarHistoryPoints() {
		mouseHover(reportsSidebar, LONGWAIT);
		mouseHover(reportsSidebarTripStopDetailed.replace("Trips Report", "History Points"), MEDIUMWAIT);
		safeClick(reportsSidebarTripStopDetailed.replace("Trips Report", "History Points"), MEDIUMWAIT);
	}

	// This function is used for check the presence of Trips Report
	public boolean isreportsSidebarTripStopDetailedPresent() {
		mouseHover(reportsSidebarTripStopDetailed, MEDIUMWAIT);
		return isElementVisible(reportsSidebarTripStopDetailed, LONGWAIT);
	}

	// This function is used for check the presence of Reports Log
	public boolean isReportsSidebarReportsLogPresent() {
		mouseHover(reportsSidebar, LONGWAIT);
		mouseHover(reportsSidebarTripStopDetailed.replace("Trips Report", "Report Logs"), MEDIUMWAIT);
		return isElementVisible(reportsSidebarTripStopDetailed.replace("Trips Report", "Report Logs"), LONGWAIT);
	}

	// This function is used for check the presence of Speeding Report
	public boolean isReportsSidebarSpeedingReportPresent() {
		mouseHover(reportsSidebar, LONGWAIT);
		mouseHover(reportsSidebarTripStopDetailed.replace("Trips Report", "Speeding Report"), MEDIUMWAIT);
		return isElementVisible(reportsSidebarTripStopDetailed.replace("Trips Report", "Speeding Report"), LONGWAIT);
	}

	// This function is used for check the presence of Events Report
	public boolean isReportsSidebarEventsReportPresent() {
		mouseHover(reportsSidebar, LONGWAIT);
		mouseHover(reportsSidebarTripStopDetailed.replace("Trips Report", "Events Report"), MEDIUMWAIT);
		return isElementVisible(reportsSidebarTripStopDetailed.replace("Trips Report", "Events Report"), LONGWAIT);
	}

	// This function is used for check the presence of Schedule Report
	public boolean isReportsSidebarScheduleReportPresent() {
		mouseHover(reportsSidebar, LONGWAIT);
		mouseHover(reportsSidebarTripStopDetailed.replace("Trips Report", "Schedule Report"), MEDIUMWAIT);
		return isElementVisible(reportsSidebarTripStopDetailed.replace("Trips Report", "Schedule Report"), LONGWAIT);
	}

	// This function is used for click on Email on Demands Button
	public void clickOnEmailOnDemands() {
		needToWait(SHORTWAIT);
		mouseHover(emailOnDemands, SHORTWAIT);
		waitForElementClickable(emailOnDemands, SHORTWAIT);
		safeJavaScriptClick(emailOnDemands);
	}

	// This function is used for click on cancel button in email on demands button
	public void clickOnCancelButtonEmailOnDemands() {
		waitForElementClickable(cancelButtonEmailOnDemands, LONGWAIT);
		safeJavaScriptClick(cancelButtonEmailOnDemands);
	}

	// This function is used for click on cancel button in email on demands button
	public boolean isCancelButtonPresent() {

		return isElementVisible(cancelButtonEmailOnDemands, SHORTWAIT);
	}

	// This function is used for click on cross icon in email on demands button
	public void clickOnCrossButtonEmailOnDemands() {
		waitForElementClickable(crossButtonEmailOnDemands, LONGWAIT);
		safeJavaScriptClick(crossButtonEmailOnDemands);
	}

	// This function is used for click on PDF Download button
	public void clickOnPDF(int num) {
		scrollIntoViewThroughJavaScriptExecuter(PDF.replace("num", num + ""));
		mouseHover(PDF.replace("num", num + ""), LONGWAIT);
		waitForElementClickable(PDF.replace("num", num + ""), LONGWAIT);
		safeJavaScriptClick(PDF.replace("num", num + ""));
		needToWait(MEDIUMWAIT);
	}

	// This function is used for check the presence of Email
	public boolean isEmailPresent() {
		return isElementVisible(email, LONGWAIT);
	}

//	public void clickOnDeleteEmailOnYopmail() {
//		mouseHover(deleteEmailOnYopmail, SHORTWAIT);
//		waitForElementClickable(deleteEmailOnYopmail, LONGWAIT);
//		safeClick(deleteEmailOnYopmail, SHORTWAIT);
//		safeClick(deleteEmptyEmailOnYopmail, SHORTWAIT);
//		
//		
//	}

	// This function is used for enter the email address on email on demands pop-up
	public void enterEmailAddessOnEmailDemands(String strEmailAdd) {
		waitForPageToLoad();
		waitForElementPresent(emailOnDemandType, SHORTWAIT);
		safeClearAndType(emailOnDemandType, strEmailAdd, SHORTWAIT);
	}

	public boolean isReportHomeLinkPresent() {
		return isElementVisible(reportHomeLink, SHORTWAIT);
	}

	public boolean isReportsLinkPresent() {
		return isElementVisible(reportsLink, SHORTWAIT);
	}

	public boolean isReportsLogsLinkPresent() {
		return isElementVisible(reportsLogsLink, SHORTWAIT);
	}

	public String getCssValueReportsLogsTitle() {
		color = getCssValue(reportsLogsTitle, "color", SHORTWAIT);
		return color;
	}

	public boolean isEmailOnDemandsPresent() {
		return isElementVisible(emailOnDemands, SHORTWAIT);

	}

	public boolean isPDFPresent(int num) {
		return isElementVisible(PDF.replace("num", num + ""), SHORTWAIT);
	}

	public boolean isReportHeadingColumnPresent(int num) {
		return isElementVisible(reportHeadingColumn.replace("num", num + ""), SHORTWAIT);
	}

	public void clickOnReportLogsDropDown() {
		// This will scroll page 400 pixel vertical
		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		scrollIntoElementView(reportLogsDropdown);
		waitForElementPresent(reportLogsDropdown, SHORTWAIT);
		safeJavaScriptClick(reportLogsDropdown);
	}

	public void clickOnReportTripStopDetailedDropdownOption() {
		safeJavaScriptClick(periodField.replace("Select Period", "Select Report"));
		safeJavaScriptClick(reportTripStopDetailedDropdownOption);
	}

	public void clickOnReportSpeedingReportDropdownOption() {
		safeJavaScriptClick(periodField.replace("Select Period", "Select Report"));
		safeJavaScriptClick(reportTripStopDetailedDropdownOption.replace("Trip Stop Detailed", "Speeding Report"));
	}

	public void clickOnReportEventsReportDropdownOption() {
		safeJavaScriptClick(periodField.replace("Select Period", "Select Report"));
		safeJavaScriptClick(reportTripStopDetailedDropdownOption.replace("Trip Stop Detailed", "Events Report"));
	}

	public void selectAddScheduleReportVehicle() {
		safeClick(tripReportObject, SHORTWAIT);
		safeClick(vehicleName, SHORTWAIT);
	}

	public void selectAddScheduleReportDailyPeriod() {
		safeJavaScriptClick(periodDropdownSelect);
		safeClick(vehicleName.replace("Vehicle01", "Daily"), SHORTWAIT);
	}

	public void selectAddScheduleReportWeeklyPeriod() {
		safeJavaScriptClick(periodDropdownSelect);
		safeClick(vehicleName.replace("Vehicle01", "Weekly"), SHORTWAIT);
	}

	public void selectAddScheduleReportMonthlyPeriod() {
		safeJavaScriptClick(periodDropdownSelect);
		safeClick(vehicleName.replace("Vehicle01", "Monthly"), SHORTWAIT);
	}

	public boolean isMonthDayDrpDwnPresent() {
		return isElementVisible(monthDayDrpDwn, SHORTWAIT);

	}

	public void clickOnPeriodDropdown() {
		// This will scroll page 400 pixel vertical
		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		scrollIntoElementView(periodDropdownSelect);
		waitForElementPresent(periodDropdownSelect, SHORTWAIT);
		safeJavaScriptClick(periodDropdownSelect);

	}

	public void clickOnScheduleReportDropdown() {
		safeJavaScriptClick(scheduleReportDropdownSelect);
	}

	public boolean isAddScheduleReportButtonPresent() {
		return isElementVisible(addScheduleReportButton, SHORTWAIT);

	}

	public void clickOnAddScheduleReportButton() {
		safeJavaScriptClick(addScheduleReportButton);
	}

	public void enterScheduleName(String schedule) {
		waitForElementPresent(scheduleName, SHORTWAIT);
		safeClearAndType(scheduleName, schedule, SHORTWAIT);
	}

	public void clickOnPeriodDropdowAndPeriodDropdownDaily() {
		// This will scroll page 400 pixel vertical
		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		scrollIntoElementView(periodDropdownSelect);
		waitForElementPresent(periodDropdownSelect, SHORTWAIT);
		safeJavaScriptClick(periodDropdownSelect);
		safeJavaScriptClick(periodDropdownDaily);
		safeJavaScriptClick(searchButton);
	}

	public void clickOnPeriodDropdowAndPeriodDropdownWeekly() {
		// This will scroll page 400 pixel vertical
		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		scrollIntoElementView(periodDropdownSelect);
		waitForElementPresent(periodDropdownSelect, SHORTWAIT);
		safeJavaScriptClick(periodDropdownSelect);
		safeJavaScriptClick(periodDropdownDaily.replace("Daily", "Weekly"));
		safeJavaScriptClick(searchButton);

	}

	public void clickOnPeriodDropdowAndPeriodDropdownMonthly() {
		// This will scroll page 400 pixel vertical
		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		scrollIntoElementView(periodDropdownSelect);
		waitForElementPresent(periodDropdownSelect, SHORTWAIT);
		safeJavaScriptClick(periodDropdownSelect);
		safeJavaScriptClick(periodDropdownDaily.replace("Daily", "Monthly"));
		safeJavaScriptClick(searchButton);

	}

	public void clickOnSpeedFilterDrpdwn() {
		waitForElementPresent(speedFilterDrpdwn, SHORTWAIT);
		safeJavaScriptClick(speedFilterDrpdwn);
	}

	public void clickOnAlertTypeOption() {
		safeJavaScriptClick(alertsTypeField);
		safeJavaScriptClick(speedFilterDrpdwnOptionEqualsTo.replaceAll("Equals To", "POI Out"));
	}

	public void clickOnSpeedFilterDrpdwnOptionEqualsTo() {
		safeJavaScriptClick(speedFilterDrpdwnOptionEqualsTo);
	}

	public void clickOnSpeedDrpdwnOption10() {
		safeJavaScriptClick(speedFilterDrpdwnOptionEqualsTo.replaceAll("Equals To", "10"));
	}

	public void clickOnSpeedDrpdwnOption30() {
		safeJavaScriptClick(speedFilterDrpdwnOptionEqualsTo.replaceAll("Equals To", "30"));
	}

	public boolean isAntNotificationMessagePresent() {
		return isElementPresent(antNotificationMessage, SHORTWAIT);

	}

	public boolean isSpeedFilterDrpdwnOptionEqualsToPresent() {
		return isElementVisible(speedFilterDrpdwnOptionEqualsTo, LONGWAIT);

	}

	public boolean isSpeedFilterDrpdwnOptionLessThanPresent() {
		return isElementVisible(speedFilterDrpdwnOptionLessThan, LONGWAIT);

	}

	public boolean isSpeedFilterDrpdwnOptionGreaterThenPresent() {
		return isElementVisible(speedFilterDrpdwnOptionGreaterThen, LONGWAIT);

	}

	public boolean isSpeedFilterDrpdwnOptionLessThanEqualsPresent() {
		return isElementVisible(speedFilterDrpdwnOptionLessThanEquals, LONGWAIT);

	}

	public boolean isSpeedFilterDrpdwnOptionGreaterThanEqualsPresent() {
		return isElementVisible(speedFilterDrpdwnOptionGreaterThanEquals, LONGWAIT);

	}

	public boolean isReportHeadinglistData() {
		return isElementVisible(listData, MEDIUMWAIT);

	}

	public String getSelectPeriodPlaceholder() {
		errorMsg = safeGetText(periodDropdownSelect, LONGWAIT);
		log.info("get Select period placeholder  ");
		return errorMsg;
	}

	public String getSelectReportPlaceholder() {
		String SelectReportplaceholder = safeGetText(periodField.replace("Select Period", "Select Report"), LONGWAIT);
		log.info("get Select Report placeholder  ");
		return SelectReportplaceholder;
	}

	public String getPeriodReportPlaceholder() {
		String SelectPeriodPlaceholder = safeGetText(periodField, LONGWAIT);
		log.info("get Select Report placeholder  ");
		return SelectPeriodPlaceholder;
	}

	public String getSpeedDropdownPlaceholder() {
		waitForElementPresent(speedDropdownPlaceholder, LONGWAIT);
		String speedplaceholder = safeGetText(speedDropdownPlaceholder, LONGWAIT);
		log.info("get Select Speed placeholder  ");
		return speedplaceholder;
	}

	public String getSelectObjectPlaceholder() {
		String objectText = safeGetText(vehiclePlaceholder, LONGWAIT);
		log.info("get Select Object placeholder ");
		return objectText;
	}

	public String getScheduleNamePlaceholder() {
		String scheduleNameText = safeGetAttribute(scheduleName, "placeholder", SHORTWAIT);
		log.info("get Schedule Name placeholder ");
		return scheduleNameText;
	}

	public String getSelectObjectValidation() {
		waitForPageToLoad();
		scrollIntoElementView(selectObjectValidation);
		waitForElementPresent(selectObjectValidation, LONGWAIT);
		String objectValidationText = safeGetText(selectObjectValidation, LONGWAIT);
		log.info("get Select Object validation");
		return objectValidationText;
	}

	public String getSelectReportPeriodValidation() {
		waitForElementPresent(selectReportPeriodValidation, LONGWAIT);
		String reportPeriodValidationText = safeGetText(selectReportPeriodValidation, LONGWAIT);
		log.info("get Report Period validation");
		return reportPeriodValidationText;
	}

	public String getReportValidation() {
		waitForPageToLoad();
		scrollIntoElementView(selectReportPeriodValidation);
		waitForElementPresent(selectReportPeriodValidation, LONGWAIT);
		String reportValidationText = safeGetText(selectReportPeriodValidation, LONGWAIT)
				.replace("Please Select Report Period", "Please Select Report");
		log.info("get Reportvalidation");
		return reportValidationText;
	}

	public String getScheduleNameValidation() {
		waitForElementPresent(scheduleNameValidation, LONGWAIT);
		String objectValidationText = safeGetText(scheduleNameValidation, LONGWAIT);
		log.info("get Schedule Name validation");
		return objectValidationText;
	}

	public String getSelectPeriodValidation() {
		waitForPageToLoad();
		scrollIntoElementView(selectPeriodValidation);
		waitForElementPresent(selectPeriodValidation, SHORTWAIT);
		String periodValidationText = safeGetText(selectPeriodValidation, SHORTWAIT);
		log.info("get Select period validation");
		return periodValidationText;

	}

	public void selectObject() {
		safeClick(tripReportObject, SHORTWAIT);
		needToWait(SHORTWAIT);
		WebElement Objects = driver.findElement(By.xpath(
				"//div//ul[@class='ant-select-dropdown-menu  ant-select-dropdown-menu-root ant-select-dropdown-menu-vertical']"));
		List<WebElement> objectList = Objects.findElements(By.tagName("li"));
		for (WebElement li : objectList) {
			if (li.getText().equals("MB02-Teltonika")) {
				li.click();
			}
		}
	}

	public boolean isEmailOnDemandCancelBtnPresent() {
		return isElementVisible(emailOnDemandCancelBtn, LONGWAIT);
	}

	public boolean isAddScheduleReportSaveBtnPresent() {
		return isElementVisible(addScheduleReportSaveBtn, LONGWAIT);
	}

	public String getReportLogsValueDropdown() {
		waitForPageToLoad();
		scrollIntoElementView(getReportLogsValueDropdown);
		waitForElementPresent(getReportLogsValueDropdown, SHORTWAIT);
		String reportLogsValueDropdownText = safeGetText(getReportLogsValueDropdown, SHORTWAIT);
		log.info("get Repor tLogs Value Dropdown ");
		return reportLogsValueDropdownText;
	}

	public String getReportLogsHeadingText() {
		waitForPageToLoad();
		scrollIntoElementView(getReportLogsHeadingText);
		waitForElementPresent(getReportLogsHeadingText, SHORTWAIT);
		String reportLogsHeadingText = safeGetText(getReportLogsHeadingText, SHORTWAIT);
		log.info("Get error message of 'Email address' field");
		return reportLogsHeadingText;
	}

	public boolean isSearchFieldPresent() {
		return isElementVisible(searchField, LONGWAIT);
	}

	public boolean isPaginationPresent() {
		return isElementVisible(pagination, LONGWAIT);
	}

	public boolean isEmailOnDemandDialogTitlePresent() {
		return isElementVisible(emailOnDemandDialogTitle, LONGWAIT);
	}

	public boolean isAddScheduleReportPopupPresent() {
		return isElementVisible(addScheduleReportPopup, LONGWAIT);
	}

	public boolean isReportFieldPresent() {
		return isElementVisible(periodField.replace("Select Period", "Select Report"), LONGWAIT);
	}

	public boolean isVehicleFieldPresent() {
		return isElementVisible(vehiclePlaceholder, LONGWAIT);
	}

	public boolean isPeriodFieldPresent() {
		return isElementVisible(periodField, LONGWAIT);
	}

	public boolean isScheduleNamePresent() {
		return isElementVisible(scheduleName, LONGWAIT);
	}

	public boolean isEmailOnDemandLabelPresent() {
		return isElementVisible(emailOnDemandLabel, LONGWAIT);
	}

	public boolean isEmailOnDemandEmailFieldPresent() {
		return isElementVisible(emailOnDemandEmailField, LONGWAIT);
	}

	public boolean isEmailOnDemandEmailFieldPlaceholderPresent() {
		return isElementVisible(emailOnDemandEmailFieldPlaceholder, LONGWAIT);
	}

	public boolean isPeriodDropdownSelectPresent() {
		return isElementVisible(periodDropdownSelect, LONGWAIT);
	}

	public boolean isScheduleDropdownSelectOptionPresent(int i) {
		return isElementVisible(scheduleDropdownSelectOption, LONGWAIT);
	}

	public boolean isPeriodDropdownDailyPresent() {
		return isElementVisible(periodDropdownDaily, LONGWAIT);
	}

	public boolean isPeriodDropdownWeeklyPresent() {
		return isElementVisible(periodDropdownDaily.replace("Daily", "Weekly"), LONGWAIT);
	}

	public boolean isPeriodDropdownMonthlyPresent() {
		return isElementVisible(periodDropdownDaily.replace("Daily", "Monthly"), LONGWAIT);
	}

	public boolean isPeriodDropdownCustomPresent() {
		return isElementVisible(periodDropdownDaily.replace("Daily", "Custom"), LONGWAIT);
	}

	public void ClickOnPeriodDropdownCustom() {
		waitForElementPresent(periodDropdownDaily.replace("Daily", " Custom"), SHORTWAIT);
		safeClick(periodDropdownDaily.replace("Daily", " Custom"), MEDIUMWAIT);
	}

	public void ClickOnStartDateCustom() {
		waitForElementPresent(startDate, MEDIUMWAIT);
		safeJavaScriptClick(startDate);
	}

	public void ClickOnPreviousMonthOnStartDateCustom() {
		waitForElementPresent(previousMonth, SHORTWAIT);
		safeClick(previousMonth, MEDIUMWAIT);
	}

	public void selectMarchFirstdate() {
		waitForElementPresent(selectMarchFirstdate, SHORTWAIT);
		safeClick(selectMarchFirstdate, MEDIUMWAIT);
	}

	public boolean isStartDatePresentOnCustom() {
		return isElementVisible(startDate, LONGWAIT);
	}

	public boolean isEndDatePresentOnCustom() {
		return isElementVisible(endDate, LONGWAIT);
	}

	public void ClickOnEndDateCustom() {
		waitForElementPresent(endDate, SHORTWAIT);
		safeClick(endDate, MEDIUMWAIT);

	}

	// Get The Current Day
	public String getCurrentDay() {
		// Create a Calendar Object
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());

		// Get Current Day as a number
		int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
		System.out.println("Today Int: " + todayInt + "\n");

		// Integer to String Conversion
		String todayStr = Integer.toString(todayInt);
		System.out.println("Today Str: " + todayStr + "\n");
		return todayStr;
	}

	// Get The Current Day
	public void getCurrentDay1() {

		// Get Today's number
		String today = getCurrentDay();

		// This is from date picker table
		WebElement dateWidgetFrom = driver
				.findElement(By.xpath("//div[@class='ant-calendar-panel']/div[2]/div[2]/table/tbody"));

		// This are the rows of the from date picker table
		// List<WebElement> rows = dateWidgetFrom.findElements(By.tagName("tr"));

		// This are the columns of the from date picker table
		List<WebElement> columns = dateWidgetFrom.findElements(By.tagName("td"));

		// DatePicker is a table. Thus we can navigate to each cell
		// and if a cell matches with the current date then we will click it.
		for (WebElement cell : columns) {
			/*
			 * //If you want to click 18th Date if (cell.getText().equals("18")) {
			 */
			// Select Today's Date
			if (cell.getText().equals(today)) {
				cell.click();
				break;
			}
		}

	}

	// This function is used for Start Date Field Placeholder
	public String getStartDatePlaceholder() {
		String startDateText = safeGetAttribute(startDate, "Placeholder", SHORTWAIT);
		return startDateText;
	}

	public String getStartDateValidationMessage() {
		waitForPageToLoad();
		String startDatevalidationMessageText = safeGetText(startDateValidationMessage, SHORTWAIT);
		log.info("Get start Date Validation Message");
		return startDatevalidationMessageText;
	}

	public String getEndDateValidationMessage() {
		waitForPageToLoad();
		String endDateValidationMessageText = safeGetText(endDateValidationMessage, SHORTWAIT);
		log.info("Get end Date Validation Message");
		return endDateValidationMessageText;
	}

	// This function is used for End Date Field Placeholder
	public String getEndDatePlaceholder() {
		String startDateText = safeGetAttribute(endDate, "Placeholder", SHORTWAIT);
		return startDateText;
	}

	// This function is used for Start Time Field Placeholder
	public String getStarTimePlaceholder() {
		String startTimeText = safeGetAttribute(startTime, "Placeholder", SHORTWAIT);
		return startTimeText;
	}

	// This function is used for End Time Field Placeholder
	public String getEndTimePlaceholder() {
		String endTimeText = safeGetAttribute(endTime, "Placeholder", SHORTWAIT);
		return endTimeText;
	}

	public boolean isEmailOnDemandSendRequestBtnPresent() {
		return isElementVisible(emailOnDemandSendRequestBtn, LONGWAIT);
	}

	public boolean isEmailOnDemandCrossBtnPresent() {
		return isElementVisible(emailOnDemandCrossBtn, LONGWAIT);
	}

	public void clickOnEmailOnDemandSendRequestBtn() {

		waitForElementPresent(emailOnDemandSendRequestBtn, SHORTWAIT);
		safeJavaScriptClick(emailOnDemandSendRequestBtn);
	}

	public String getTextEmailOnDemandEmailFieldErrorMessageg() {
		waitForPageToLoad();
		String emailOnDemandEmailFieldErrorMessageText = safeGetText(emailOnDemandEmailFieldErrorMessage, SHORTWAIT);
		log.info("Get error message of 'Email address' field");
		return emailOnDemandEmailFieldErrorMessageText;
	}

	public boolean isReportLogsPresent() {
		return isElementVisible(reportLogsPresent, LONGWAIT);
	}

	public boolean isAddedRolePresent() {
		return isElementVisible(reportLogsPresent.replace("MB02-Teltonika", "QA_Testing1"), LONGWAIT);
	}

	public void searchReport(String searchRepo) {
		waitForPageToLoad();
		waitForElementPresent(searchField, SHORTWAIT);
		safeClearAndType(searchField, searchRepo, SHORTWAIT);
		log.info("search report logs");
	}

	public void clickOnfirstCountPage() {
		waitForElementPresent(firstPage, SHORTWAIT);
		safeClick(firstPage, LONGWAIT);
	}

	public boolean isfirstPageCountPresent() {
		return isElementVisible(firstPageCount, LONGWAIT);
	}

	public void checkPagination() {

		List<WebElement> namesElements = driver.findElements(By.xpath("//tbody[@class='ant-table-tbody']//tr"));
		List<String> names = new ArrayList<String>();

		for (WebElement namesElement : namesElements) {
			names.add(namesElement.getText());
		}

		String previousButtonClassName = driver
				.findElement(By.cssSelector(".ant-pagination-disabled.ant-pagination-prev")).getAttribute("class");
		String nextButtonClassName = driver.findElement(By.cssSelector("li[title='Next Page']")).getAttribute("class");

		while (!previousButtonClassName.contains("disabled")) {
			driver.findElement(By.cssSelector("li[title='Next Page']")).click();
		}

		while (!nextButtonClassName.contains("disabled")) {
			needToWait(5);
			driver.findElement(By.cssSelector("li[title='Next Page']")).click();
			needToWait(3);
			namesElements = driver.findElements(By.xpath("//tbody[@class='ant-table-tbody']//tr"));

			for (WebElement namesElement : namesElements) {
				names.add(namesElement.getText());

			}

			nextButtonClassName = driver.findElement(By.cssSelector("li[title='Next Page']")).getAttribute("class");
		}

		for (String name : names) {
			System.out.println(name);
		}

		int totalnames = names.size();
		// System.out.println("Total number of Names:" + totalnames);

		String displayedCount = driver.findElement(By.cssSelector("li.ant-pagination-total-text")).getText()
				.split(" ")[1];
		// assertEquals(displayedCount, String.valueOf(totalnames));

	}

	public String getTextReportTypeValue() {
		waitForPageToLoad();
		String reportTypeValueText = safeGetText(reportTypeValue, SHORTWAIT);
		return reportTypeValueText;
	}

	public void clickOnReportTypeHeading() {
		waitForElementPresent(reportTypeHeading, MEDIUMWAIT);
		waitForElementClickable(reportTypeHeading, MEDIUMWAIT);
		safeJavaScriptClick(reportTypeHeading);
		needToWait(4);
	}

	public boolean isTripStopDetailedLinkPresent() {
		return isElementVisible(tripStopDetailedLink, SHORTWAIT);
	}

	public boolean isSpeedingReportLinkPresent() {
		return isElementVisible(tripStopDetailedLink.replace("Trips Report", "Speeding Report"), SHORTWAIT);
	}

	public boolean isEventsReportLinkPresent() {
		return isElementVisible(tripStopDetailedLink.replace("Trips Report", "Events Report"), SHORTWAIT);
	}

	public boolean isHistoryPointsLinkPresent() {
		return isElementVisible(tripStopDetailedLink.replace("Trips Report", "History Points"), SHORTWAIT);
	}

	public boolean isScheduleReportLinkPresent() {
		return isElementVisible(scheduleReportLink, SHORTWAIT);
	}

	public boolean isResetButtonPresent() {
		return isElementVisible(resetButton, SHORTWAIT);
	}

	public boolean isSearchButtonPresent() {
		return isElementVisible(searchButton, SHORTWAIT);
	}

	public void clickOnSearchButton() {
		waitForElementClickable(searchButton, SHORTWAIT);
		safeClick(searchButton, LONGWAIT);
	}

	public void clickOnResetButton() {
		waitForElementClickable(resetButton, SHORTWAIT);
		safeClick(resetButton, LONGWAIT);
	}

	public boolean isObjectLabelPresent() {
		return isElementVisible(objectLabel, SHORTWAIT);
	}

	public boolean isAlertsTypeLabelPresent() {
		return isElementVisible(alertsTypeLabel, SHORTWAIT);
	}

	public boolean isSpeedFilterPresent() {
		return isElementVisible(speedFilterLabel, SHORTWAIT);
	}

	public boolean isSpeedLabelPresent() {
		return isElementVisible(speedLabel, SHORTWAIT);
	}

	public boolean isPeriodLabelPresent() {
		return isElementVisible(periodLabel, SHORTWAIT);
	}

	public void clickOnSaveButton() {
		safeClick(addScheduleReportSaveBtn, SHORTWAIT);
	}

	public boolean isStartTimePresent() {
		return isElementVisible(startTime, SHORTWAIT);
	}

	public boolean isEndTimePresent() {
		return isElementVisible(endTime, SHORTWAIT);
	}

	public void emailOnDemandsTooltip() {
		// Verify the email on demand tooltip
		String expectedTooltip = "Email On Demand";
		WebElement emailOnDemand = driver.findElement(By.xpath("//div[@class='ant-card-head']//button[1]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(emailOnDemand).perform();

		WebElement toolTipElement = driver.findElement(By.cssSelector("div[role='tooltip']"));
		needToWait(SHORTWAIT);
		String actualTooltip = toolTipElement.getText();
		System.out.println("Actual Title of Tool Tip +++++++++" + actualTooltip);
		Assert.assertEquals(actualTooltip, expectedTooltip);

	}

	public void PDFTooltip() {
		// Verify the PDF tooltip
		String expectedTooltip = "Export PDF";
		WebElement PDF = driver.findElement(By.xpath("//div//div[@class='ant-card-head-wrapper']//div[2]//button[2]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(PDF).perform();
		WebElement toolTipElement = driver.findElement(By.cssSelector("div[role='tooltip']"));
		needToWait(SHORTWAIT);
		String actualTooltip = toolTipElement.getText();
		System.out.println("Actual Title of Tool Tip +++++++++" + actualTooltip);
		Assert.assertEquals(actualTooltip, expectedTooltip);
	}

	public void CSVTooltip() {
		// Verify the CSV tooltip
		String expectedTooltip = "Export CSV";
		WebElement CSV = driver.findElement(By.xpath("//div//div[@class='ant-card-head-wrapper']//div[2]//button[3]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(CSV).perform();
		WebElement toolTipElement = driver.findElement(By.cssSelector("div[role='tooltip']"));
		needToWait(SHORTWAIT);
		String actualTooltip = toolTipElement.getText();
		System.out.println("Actual Title of Tool Tip +++++++++" + actualTooltip);
		Assert.assertEquals(actualTooltip, expectedTooltip);
	}

	public void HTMLToolTip() {
		// Verify the HTML tooltip
		String expectedTooltip = "Export HTML";
		WebElement HTML = driver.findElement(By.xpath("//div//div[@class='ant-card-head-wrapper']//div[2]//button[4]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(HTML).perform();

		WebElement toolTipElement = driver.findElement(By.cssSelector("div[role='tooltip']"));
		needToWait(SHORTWAIT);
		String actualTooltip = toolTipElement.getText();
		System.out.println("Actual Title of Tool Tip +++++++++" + actualTooltip);
		Assert.assertEquals(actualTooltip, expectedTooltip);
	}
	
	
	public void drawHistoryTooltipToolTip() {
		
		// Verify the PDF tooltip
		String expectedTooltip = "Draw History Points";
		WebElement DrawHistoryPoints = driver.findElement(By.xpath("//span //button[@class='ant-btn ant-btn-primary']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(DrawHistoryPoints).perform();
		WebElement toolTipElement = driver.findElement(By.cssSelector("div[role='tooltip']"));
		needToWait(SHORTWAIT);
		String actualTooltip = toolTipElement.getText();
		System.out.println("Actual Title of Tool Tip +++++++++" + actualTooltip);
		Assert.assertEquals(actualTooltip, expectedTooltip);
	}

	public boolean isDrawHistoryPointsPopupHeadingPresent() {
		return isElementPresent(drawHistoryPointsPopupHeading,SHORTWAIT);
	}
	
	public void clickOnPlayButton() {
		safeClick(playButton, SHORTWAIT);
	}
	
	public void clickOnTrackSpeed() {
		safeClick(trackSpeed, SHORTWAIT);
	}
	
	
}
