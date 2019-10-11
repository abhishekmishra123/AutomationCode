package PageObjects;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Common.ConfigManager;

import junit.framework.Assert;
import Common.ActionMethods;

public class ReportsPage extends ActionMethods {

	private String reportsSidebar = "xpath://body//li[13]";
	private String reportsSidebarTripStopDetailed = "xpath://a[contains(text(),'Trips Report')]";
	private String reportsSidebarSpeedingReport = "xpath://a[contains(text(),'Speeding Report')]";
	private String reportsSidebarEventsReport = "xpath://a[contains(text(),'Events Report')]";
	private String reportsSidebarScheduleReport = "xpath://a[contains(text(),'Schedule Report')]";
	private String reportsSidebarReportsLog = "xpath://a[contains(text(),'Report Logs')]";
	private String emailOnDemands = "xpath://div[@class='ant-card-head']//button[1]";
	private String cancelButtonEmailOnDemands = "xpath://button[@class='ant-btn ant-btn-danger']";
	private String crossButtonEmailOnDemands = "xpath://span[@class='ant-modal-close-x']";
	
	
	private String objectLabel = "css:label[for='device_id']";
	private String periodLabel = "css:label[for='period']";
	private String PDF = "xpath://div//div[@class='ant-card-head-wrapper']//div[2]//button[2]";
	private String CSV = "xpath://div//div[@class='ant-card-head-wrapper']//div[2]//button[3]";
	private String HTML = "xpath://div//div[@class='ant-card-head-wrapper']//div[2]//button[4]";
	private String reportHeadingColumn = "xpath://div[@class='ant-table-wrapper']//th";
	private String email = "css:td.alert.alert-warning";
	private String deleteEmailOnYopmail = "xpath://table[@class='barreinbox']//tbody//tr//td[2]";
	private String deleteEmptyEmailOnYopmail = "xpath://a[@class='igif lmen_all']";
	

	
	private String emailOnDemandType = "css:input#email_on_demand";
	private String emailSubmit = "css:button[type='submit']";
	private String reportHomeLink = "xpath://div[@class='ant-breadcrumb']//a[text()= 'Home']";
	private String reportsLink = "xpath://div[@class='ant-breadcrumb']//span[text()= 'Reports']";
	private String reportsLogsLink = "xpath://div[@class='ant-breadcrumb']//span[text()= 'Report Logs']";
	private String tripStopDetailedLink = "xpath://div[@class='ant-breadcrumb']//span[text()= 'Trips Report']";
	private String reportsLogsTitle = "xpath://div[@class='ant-card-head-title']";
	private String reportLogsDropdown = "xpath://div[@class='ant-select-selection-selected-value']";
	private String periodDropdownSelect = "xpath://div[contains(text(),'Select Period')]";
	private String periodDropdownDaily = "xpath://li[contains(text(),'Daily')]";
	private String periodDropdownWeekly = "xpath://li[contains(text(),'Weekly')]";
	private String periodDropdownMonthly = "xpath://li[contains(text(),'Monthly')]";
	private String periodDropdownCustom = "xpath://li[contains(text(),'Custom')]";
	private String startDate = "xpath://span[@id='start_date']//input[@placeholder='Select date']";
	private String previousMonth = "css:a[title='Previous month (PageUp)']";
	private String selectMarchFirstdate = "xpath://tr[1]//td[6]//div[@class='ant-calendar-date']";

	private String EndDate = "xpath://span[@id='end_date']//input[@placeholder='Select date']";

	// div[contains(text(),'11')]

	private String startDateValidationMessage = "xpath://div[contains(text(),'Please Select Start Date')]";
	private String endDateValidationMessage = "xpath://div[contains(text(),'Please Select End Date')]";
	private String getReportLogsValueDropdown = "xpath://ul//li[contains(text(),'Object Name')]";
	private String getReportLogsHeadingText = "xpath://ul//li[contains(text(),'Object Name')]";
	private String searchField = "css:input.ant-input.ant-select-search__field";
	private String pagination = "css:ul.ant-pagination.ant-table-pagination.mini";
	private String emailOnDemandDialogTitle = "css:div#rcDialogTitle0";
	private String emailOnDemandLabel = "xpath://label[@class='ant-form-item-required']";
	private String tripReportObject = "css:div#device_id";

	private String emailOnDemandCancelBtn = "xpath://button[@class='ant-btn ant-btn-danger']";
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
	private String objectPlaceholder = "xpath://div[text()='Select Object']";
	private String selectObjectValidation = "xpath://div[contains(text(),'Please Select Object')]";
	private String selectPeriodValidation = "xpath://div[contains(text(),'Please Select Period')]";
	private String antNotificationMessage = "css:div.ant-notification-notice-message";
	private String listData = "xpath://tbody[@class='ant-table-tbody']//tr";

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

	public void clickOnReportsSidebar() {
		mouseHover(reportsSidebar, LONGWAIT);
		// waitForElementClickable(reportsSidebar, LONGWAIT);
		safeClick(reportsSidebar, SHORTWAIT);
	}

	public void clickOnReportsSidebarReportsLog() {
		mouseHover(reportsSidebar, LONGWAIT);
		mouseHover(reportsSidebarReportsLog, MEDIUMWAIT);
		waitForElementClickable(reportsSidebarReportsLog, MEDIUMWAIT);
		safeClick(reportsSidebarReportsLog, MEDIUMWAIT);
	}

	public void clickOnReportsSidebarTripStopDetailed() {
		mouseHover(reportsSidebar, LONGWAIT);
		mouseHover(reportsSidebarTripStopDetailed, MEDIUMWAIT);
		waitForElementClickable(reportsSidebarTripStopDetailed, MEDIUMWAIT);
		safeClick(reportsSidebarTripStopDetailed, MEDIUMWAIT);
	}

	public boolean isreportsSidebarTripStopDetailedPresent() {
		mouseHover(reportsSidebarTripStopDetailed, MEDIUMWAIT);
		return isElementVisible(reportsSidebarTripStopDetailed, LONGWAIT);
	}

	public boolean isReportsSidebarReportsLogPresent() {
		mouseHover(reportsSidebar, LONGWAIT);
		mouseHover(reportsSidebarReportsLog, MEDIUMWAIT);
		return isElementVisible(reportsSidebarReportsLog, LONGWAIT);
	}

	public boolean isReportsSidebarSpeedingReportPresent() {
		mouseHover(reportsSidebar, LONGWAIT);
		mouseHover(reportsSidebarSpeedingReport, MEDIUMWAIT);
		return isElementVisible(reportsSidebarSpeedingReport, LONGWAIT);
	}

	public boolean isReportsSidebarEventsReportPresent() {
		mouseHover(reportsSidebar, LONGWAIT);
		mouseHover(reportsSidebarEventsReport, MEDIUMWAIT);
		return isElementVisible(reportsSidebarEventsReport, LONGWAIT);
	}

	public boolean isReportsSidebarScheduleReportPresent() {
		mouseHover(reportsSidebar, LONGWAIT);
		mouseHover(reportsSidebarScheduleReport, MEDIUMWAIT);
		return isElementVisible(reportsSidebarScheduleReport, LONGWAIT);
	}

	public void clickOnEmailOnDemands() {
		scrollIntoViewThroughJavaScriptExecuter(emailOnDemands);
		mouseHover(emailOnDemands, LONGWAIT);
		waitForElementClickable(emailOnDemands, LONGWAIT);
		safeJavaScriptClick(emailOnDemands);
	}
	
	public void clickOnCancelButtonEmailOnDemands() {
		waitForElementClickable(cancelButtonEmailOnDemands, LONGWAIT);
		safeJavaScriptClick(cancelButtonEmailOnDemands);
	}
	
	
	
	public void clickOnCrossButtonEmailOnDemands() {
		waitForElementClickable(crossButtonEmailOnDemands, LONGWAIT);
		safeJavaScriptClick(crossButtonEmailOnDemands);
	}
	

	public void clickOnPDF() {
		scrollIntoViewThroughJavaScriptExecuter(PDF);
		mouseHover(PDF, LONGWAIT);
		waitForElementClickable(PDF, LONGWAIT);
		safeJavaScriptClick(PDF);
		needToWait(4);
	}

	public void clickOnCSV() {
		scrollIntoViewThroughJavaScriptExecuter(PDF);
		mouseHover(CSV, LONGWAIT);
		waitForElementClickable(CSV, LONGWAIT);
		safeJavaScriptClick(CSV);
		needToWait(4);
	}

	public void clickOnHTML() {
		scrollIntoViewThroughJavaScriptExecuter(HTML);
		mouseHover(HTML, LONGWAIT);
		waitForElementClickable(HTML, LONGWAIT);
		safeJavaScriptClick(HTML);
		needToWait(5);
	}

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
	

	public void enterEmailAddessOnEmailDemands(String strEmailAdd) {
		waitForPageToLoad();
		waitForElementPresent(emailOnDemandType, SHORTWAIT);
		safeClearAndType(emailOnDemandType, strEmailAdd, SHORTWAIT);
		//safeClick(emailSubmit, LONGWAIT);
	}

	public boolean isReportHomeLinkPresent() {
		return isElementVisible(reportHomeLink, LONGWAIT);
	}

	public boolean isReportsLinkPresent() {
		return isElementVisible(reportsLink, LONGWAIT);
	}

	public boolean isReportsLogsLinkPresent() {
		return isElementVisible(reportsLogsLink, LONGWAIT);
	}

	public String getCssValueReportsLogsTitle() {
		color = getCssValue(reportsLogsTitle, "color", MEDIUMWAIT);
		return color;
	}

	public boolean isEmailOnDemandsPresent() {
		return isElementVisible(emailOnDemands, LONGWAIT);
	}

	public boolean isPDFPresent() {
		return isElementVisible(PDF, LONGWAIT);
	}

	public boolean isCSVPresent() {
		return isElementVisible(CSV, LONGWAIT);
	}

	public boolean isHTMLPresent() {
		return isElementVisible(HTML, LONGWAIT);
	}

	public boolean isReportHeadingColumnPresent(int i) {
		return isElementVisible(reportHeadingColumn, LONGWAIT);

	}

	public void clickOnReportLogsDropDown() {
		// This will scroll page 400 pixel vertical
		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		scrollIntoElementView(reportLogsDropdown);
		waitForElementPresent(reportLogsDropdown, SHORTWAIT);
		safeJavaScriptClick(reportLogsDropdown);
	}
	
	

	public void clickOnPeriodDropdown() {
		// This will scroll page 400 pixel vertical
		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		scrollIntoElementView(periodDropdownSelect);
		waitForElementPresent(periodDropdownSelect, SHORTWAIT);
		safeJavaScriptClick(periodDropdownSelect);

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
		safeJavaScriptClick(periodDropdownWeekly);
		safeJavaScriptClick(searchButton);

	}

	public void clickOnPeriodDropdowAndPeriodDropdownMonthly() {
		// This will scroll page 400 pixel vertical
		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		scrollIntoElementView(periodDropdownSelect);
		waitForElementPresent(periodDropdownSelect, SHORTWAIT);
		safeJavaScriptClick(periodDropdownSelect);
		safeJavaScriptClick(periodDropdownMonthly);
		safeJavaScriptClick(searchButton);

	}

	public boolean isAntNotificationMessagePresent() {
		return isElementVisible(antNotificationMessage, LONGWAIT);

	}

	public boolean isReportHeadinglistData() {
		return isElementVisible(listData, LONGWAIT);

	}

	public String getSelectPeriodPlaceholder() {
		waitForPageToLoad();
		scrollIntoElementView(periodDropdownSelect);
		waitForElementPresent(periodDropdownSelect, LONGWAIT);
		errorMsg = safeGetText(periodDropdownSelect, LONGWAIT);
		log.info("get Select period placeholder  ");
		return errorMsg;
	}

	public String getSelectObjectPlaceholder() {
		waitForPageToLoad();
		scrollIntoElementView(objectPlaceholder);
		waitForElementPresent(objectPlaceholder, LONGWAIT);
		errorMsg = safeGetText(objectPlaceholder, LONGWAIT);
		log.info("get Select Object placeholder ");
		return errorMsg;
	}

	public String getSelectObjectValidation() {
		waitForPageToLoad();
		scrollIntoElementView(selectObjectValidation);
		waitForElementPresent(selectObjectValidation, LONGWAIT);
		errorMsg = safeGetText(selectObjectValidation, LONGWAIT);
		log.info("get Select Object validation");
		return errorMsg;
	}

	public String getSelectPeriodValidation() {
		waitForPageToLoad();
		scrollIntoElementView(selectPeriodValidation);
		waitForElementPresent(selectPeriodValidation, SHORTWAIT);
		errorMsg = safeGetText(selectPeriodValidation, SHORTWAIT);
		log.info("get Select period validation");
		return errorMsg;

	}

	public void selectObject() {
		safeClick(tripReportObject, SHORTWAIT);
		needToWait(SHORTWAIT);
		WebElement countryUL = driver.findElement(By.xpath(
				"//div//ul[@class='ant-select-dropdown-menu  ant-select-dropdown-menu-root ant-select-dropdown-menu-vertical']"));
		List<WebElement> objectList = countryUL.findElements(By.tagName("li"));
		for (WebElement li : objectList) {
			if (li.getText().equals("MB02-Teltonika")) {
				li.click();
			}
		}
	}

	public boolean isEmailOnDemandCancelBtnPresent() {
		return isElementVisible(emailOnDemandCancelBtn, LONGWAIT);
	}

	public String getReportLogsValueDropdown() {
		waitForPageToLoad();
		scrollIntoElementView(getReportLogsValueDropdown);
		waitForElementPresent(getReportLogsValueDropdown, SHORTWAIT);
		errorMsg = safeGetText(getReportLogsValueDropdown, SHORTWAIT);
		log.info("get ReportLogs ValueDropdown ");
		return errorMsg;
	}

	public String getReportLogsHeadingText() {
		waitForPageToLoad();
		scrollIntoElementView(getReportLogsHeadingText);
		waitForElementPresent(getReportLogsHeadingText, SHORTWAIT);
		errorMsg = safeGetText(getReportLogsHeadingText, SHORTWAIT);
		log.info("Get error message of 'Email address' field");
		return errorMsg;
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

	public boolean isPeriodDropdownDailyPresent() {
		return isElementVisible(periodDropdownDaily, LONGWAIT);
	}

	public boolean isPeriodDropdownWeeklyPresent() {
		return isElementVisible(periodDropdownWeekly, LONGWAIT);
	}

	public boolean isPeriodDropdownMonthlyPresent() {
		return isElementVisible(periodDropdownMonthly, LONGWAIT);
	}

	public boolean isPeriodDropdownCustomPresent() {
		return isElementVisible(periodDropdownCustom, LONGWAIT);
	}

	public void ClickOnPeriodDropdownCustom() {
		waitForElementPresent(periodDropdownCustom, SHORTWAIT);
		safeClick(periodDropdownCustom, MEDIUMWAIT);
	}

	public void ClickOnStartDateCustom() {
		waitForElementPresent(startDate, SHORTWAIT);
		safeClick(startDate, MEDIUMWAIT);
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
		return isElementVisible(EndDate, LONGWAIT);
	}

	public void ClickOnEndDateCustom() {
		waitForElementPresent(EndDate, SHORTWAIT);
		safeClick(EndDate, MEDIUMWAIT);

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

	public String getStartDatePlaceholder() {
		String startDateText = driver
				.findElement(
						By.xpath("//div[@class='ant-form-item-control-wrapper']//input[@placeholder='Select date']"))
				.getAttribute("placeholder");
		return startDateText;
	}

	public String getStartDateValidationMessage() {
		waitForPageToLoad();
		errorMsg = safeGetText(startDateValidationMessage, SHORTWAIT);
		log.info("Get start Date Validation Message");
		return errorMsg;
	}

	public String getEndDateValidationMessage() {
		waitForPageToLoad();
		errorMsg = safeGetText(endDateValidationMessage, SHORTWAIT);
		log.info("Get end Date Validation Message");
		return errorMsg;
	}

	public String getEndDatePlaceholder() {
		String endDateText = driver
				.findElement(
						By.xpath("//div[@class='ant-calendar-date-input-wrap']//input[@placeholder='Select date']"))
				.getAttribute("placeholder");
		return endDateText;
	}

	public boolean isEmailOnDemandSendRequestBtnPresent() {
		return isElementVisible(emailOnDemandSendRequestBtn, LONGWAIT);
	}

	public boolean isEmailOnDemandCrossBtnPresent() {
		return isElementVisible(emailOnDemandCrossBtn, LONGWAIT);
	}

	public void clickOnEmailOnDemandSendRequestBtn() {

		waitForElementPresent(emailOnDemandSendRequestBtn, SHORTWAIT);
		safeClick(emailOnDemandSendRequestBtn, LONGWAIT);
	}

	public String getTextEmailOnDemandEmailFieldErrorMessageg() {
		waitForPageToLoad();
		errorMsg = safeGetText(emailOnDemandEmailFieldErrorMessage, SHORTWAIT);
		log.info("Get error message of 'Email address' field");
		return errorMsg;
	}

	public boolean isReportLogsPresent() {
		return isElementVisible(reportLogsPresent, LONGWAIT);
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
			driver.findElement(By.cssSelector("li[title='Next Page']")).click();
			needToWait(4);
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
        assertEquals(displayedCount, String.valueOf(totalnames));

	}

	public String getTextReportTypeValue() {
		waitForPageToLoad();
		errorMsg = safeGetText(reportTypeValue, SHORTWAIT);
		return errorMsg;
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

	public boolean isPeriodLabelPresent() {
		return isElementVisible(periodLabel, SHORTWAIT);
	}

}
