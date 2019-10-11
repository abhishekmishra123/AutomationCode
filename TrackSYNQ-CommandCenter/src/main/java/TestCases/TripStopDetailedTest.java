package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import Common.BaseSetup;
import Common.UtilityMethods;
import PageObjects.DashboardPage;
import PageObjects.LoginPage;
import PageObjects.ReportsPage;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.NeedsLocalLogs;

public class TripStopDetailedTest extends BaseSetup {
	LoginPage loginPage;
	DashboardPage dashboardPage;
	ReportsPage reportsPage;

	static Logger log = Logger.getLogger(TripStopDetailedTest.class);

	@Test(priority = 0, description = "TC_Reports_001 To verify the 'Reports' navigation bar")
	public void Verify_the_Reports_navigation_bar() {

		try {
			log.info("************************* TC-001*************************");
			extentTest.setDescription("TC_Reports_001 To verify the 'Reports' navigation bar");
			loginPage = new LoginPage(getDriver());
			dashboardPage = new DashboardPage(getDriver());
			reportsPage = new ReportsPage(getDriver());
			loginPage = new LoginPage(getDriver());
			loginPage.enterEmailAddess(config.getProperty("superAdminEmail"));
			loginPage.enterPassword(config.getProperty("superAdminPassword"));
			loginPage.clickOnLogInButton();
			reportsPage.clickOnReportsSidebar();
			Assert.assertTrue(reportsPage.isReportsSidebarReportsLogPresent());
			Assert.assertTrue(reportsPage.isreportsSidebarTripStopDetailedPresent());
			Assert.assertTrue(reportsPage.isReportsSidebarSpeedingReportPresent());
			Assert.assertTrue(reportsPage.isReportsSidebarEventsReportPresent());
			Assert.assertTrue(reportsPage.isReportsSidebarScheduleReportPresent());
			reportsPage.clickOnReportsSidebarTripStopDetailed();
			String pageUrl = loginPage.getCurrentWebpageURL();
			if (pageUrl.contains("trip_stop_detailed")) {
				Assert.assertEquals(1, 1);
			} else {
				Assert.assertEquals(1, 0);
			}

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to verify the 'Reports' navigation bar" + UtilityMethods.getStackTrace());
			Assert.fail("Unable to verify the 'Reports' navigation bar");
		}
	}

	@Test(priority = 1, description = "TC_Reports_Trip Stop Detailed_002 To verify the 'UI' of 'Trip Stop Detailed' page")
	public void Verify_the_UI_of_Trip_Stop_Detailed_page() {

		try {
			log.info("************************* TC-002*************************");
			extentTest.setDescription(
					"TC_Reports_Trip Stop Detailed_002 Stop To verify the 'UI' of 'Trip Stop Detailed' page");
			reportsPage = new ReportsPage(getDriver());
			loginPage = new LoginPage(getDriver());
			loginPage.enterEmailAddess(config.getProperty("superAdminEmail"));
			loginPage.enterPassword(config.getProperty("superAdminPassword"));
			loginPage.clickOnLogInButton();
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarTripStopDetailed();
			Assert.assertTrue(reportsPage.isReportHomeLinkPresent());
			Assert.assertTrue(reportsPage.isReportsLinkPresent());
			Assert.assertTrue(reportsPage.isTripStopDetailedLinkPresent());
			Assert.assertEquals(reportsPage.getCssValueReportsLogsTitle(), "rgba(2, 192, 245, 1)");
			Assert.assertTrue(reportsPage.isObjectLabelPresent());
			Assert.assertTrue(reportsPage.isPeriodLabelPresent());
			Assert.assertTrue(reportsPage.isEmailOnDemandsPresent());
			Assert.assertTrue(reportsPage.isPDFPresent());
			Assert.assertTrue(reportsPage.isCSVPresent());
			Assert.assertTrue(reportsPage.isHTMLPresent());
			// reportsPage.clickOnReportLogsDropDown();
			reportsPage.selectObject();
			reportsPage.clickOnPeriodDropdown();
			Assert.assertTrue(reportsPage.isPeriodDropdownSelectPresent());
			Assert.assertTrue(reportsPage.isPeriodDropdownDailyPresent());
			Assert.assertTrue(reportsPage.isPeriodDropdownWeeklyPresent());
			Assert.assertTrue(reportsPage.isPeriodDropdownMonthlyPresent());
			Assert.assertTrue(reportsPage.isPeriodDropdownCustomPresent());
			for (int i = 1; i <= 7; i++) {
				Assert.assertTrue(reportsPage.isReportHeadingColumnPresent(i));
			}
			Assert.assertTrue(reportsPage.isResetButtonPresent());
			Assert.assertTrue(reportsPage.isSearchButtonPresent());

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to verify the 'UI' of 'Trip Stop Detailed' page" + UtilityMethods.getStackTrace());
			Assert.fail("Unable to verify the 'UI' of 'Trip Stop Detailed' page");
		}
	}

	@Test(priority = 2, description = "TC_Reports_Trip_Stop_Detailed_003 To verify the 'Placeholder' in all field on 'Trip Stop Detailed' page")
	public void Verify_the_Placeholder_in_all_field_on_Trip_Stop_Detailed_page() {

		try {
			log.info("************************* TC-003*************************");
			extentTest.setDescription(
					"TC_Reports_Trip_Stop_Detailed_003 To verify the 'Placeholder' in all field on 'Trip Stop Detailed' page");
			reportsPage = new ReportsPage(getDriver());
			loginPage = new LoginPage(getDriver());
			loginPage.enterEmailAddess(config.getProperty("superAdminEmail"));
			loginPage.enterPassword(config.getProperty("superAdminPassword"));
			loginPage.clickOnLogInButton();
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarTripStopDetailed();

			// Verify the object placeholder text
			String expectedSelectObjectText = "Select Object";
			String actualSelectObjectText = reportsPage.getSelectObjectPlaceholder();
			Assert.assertEquals(actualSelectObjectText, expectedSelectObjectText);

			// Verify the period placeholder text
			String expectedSelectPeriodText = "Select Period";
			String actualSelectPeriodText = reportsPage.getSelectPeriodPlaceholder();
			Assert.assertEquals(actualSelectPeriodText, expectedSelectPeriodText);

			// Verify the Start & End date placeholder text
			reportsPage.clickOnPeriodDropdown();
			reportsPage.ClickOnPeriodDropdownCustom();
			reportsPage.ClickOnStartDateCustom();
			String expectedStartDateText = "Select date";
			String actualStartDateText = reportsPage.getStartDatePlaceholder();
			Assert.assertEquals(actualStartDateText, expectedStartDateText);
			String expectedEndDateText = "Select date";
			String actualEndDateText = reportsPage.getEndDatePlaceholder();
			Assert.assertEquals(actualEndDateText, expectedEndDateText);

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable To verify the 'Placeholder' in all field on 'Trip Stop Detailed' page"
					+ UtilityMethods.getStackTrace());
			Assert.fail("Unable To verify the 'Placeholder' in all field on 'Trip Stop Detailed' page");
		}
	}

	@Test(priority = 3, description = "TC_Reports_TripStopDetailed_004 To verify the validation message in all field on 'Trip Stop Detailed' page")
	public void Verify_the_validation_message_in_all_field_on_Trip_Stop_Detailed_page() {

		try {
			log.info("************************* TC-004*************************");
			extentTest.setDescription(
					"TC_Reports_TripStopDetailed_004 To verify the validation message in all field on 'Trip Stop Detailed' page");
			reportsPage = new ReportsPage(getDriver());
			loginPage = new LoginPage(getDriver());
			loginPage.enterEmailAddess(config.getProperty("superAdminEmail"));
			loginPage.enterPassword(config.getProperty("superAdminPassword"));
			loginPage.clickOnLogInButton();
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarTripStopDetailed();
			reportsPage.clickOnSearchButton();

			// Verify the object validation
			String expectedSelectObjectValidation = "Please Select Object";
			String actualSelectObjectValidation = reportsPage.getSelectObjectValidation();
			Assert.assertEquals(actualSelectObjectValidation, expectedSelectObjectValidation);

			// Verify the period validation
			String expectedSelectPeriodValidation = "Please Select Period";
			String actualSelectPeriodTextValidation = reportsPage.getSelectPeriodValidation();
			Assert.assertEquals(actualSelectPeriodTextValidation, expectedSelectPeriodValidation);

			// Verify the Start & End date validation
			reportsPage.clickOnPeriodDropdown();
			reportsPage.ClickOnPeriodDropdownCustom();
			reportsPage.clickOnSearchButton();
			String expectedStartDateValidation = "Please Select Start Date";
			String actualStartDateValidation = reportsPage.getStartDateValidationMessage();
			Assert.assertEquals(actualStartDateValidation, expectedStartDateValidation);
			String expectedEndDateValidation = "Please Select End Date";
			String actualEndDateValidation = reportsPage.getEndDateValidationMessage();
			Assert.assertEquals(actualEndDateValidation, expectedEndDateValidation);

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable To verify the validation message in all field on 'Trip Stop Detailed' page"
					+ UtilityMethods.getStackTrace());
			Assert.fail("Unable To verify the validation message in all field on 'Trip Stop Detailed' page");
		}
	}

	@Test(priority = 4, description = "TC_Reports_TripStopDetailed_005 To verify_the_Email_on_Demand_tooltip")
	public void Verify_the_Email_on_Demand_tooltip() {

		try {
			log.info("************************* TC-005*************************");
			extentTest.setDescription("TC_Reports_TripStopDetailed_005 To verify_the_Email_on_Demand_tooltip");
			reportsPage = new ReportsPage(getDriver());
			loginPage = new LoginPage(getDriver());
			loginPage.enterEmailAddess(config.getProperty("superAdminEmail"));
			loginPage.enterPassword(config.getProperty("superAdminPassword"));
			loginPage.clickOnLogInButton();
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarTripStopDetailed();

			// Verify the email on demand tooltip
			String expectedTooltip = "Email On Demand";
			WebElement emailOnDemand = driver.findElement(By.xpath("//div[@class='ant-card-head']//button[1]"));
			Actions actions = new Actions(driver);
			actions.moveToElement(emailOnDemand).perform();

			WebElement toolTipElement = driver.findElement(By.cssSelector("div[role='tooltip']"));
			String actualTooltip = toolTipElement.getText();
			System.out.println("Actual Title of Tool Tip +++++++++" + actualTooltip);
			Assert.assertEquals(actualTooltip, expectedTooltip);
			Assert.assertTrue(reportsPage.isReportHomeLinkPresent());

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to verify_the_Email_on_Demand_tooltip" + UtilityMethods.getStackTrace());
			Assert.fail("Unable to verify_the_Email_on_Demand_tooltip");
		}
	}

	@Test(priority = 5, description = "TC_Reports_Trip Stop Detailed_006 To verify_the_PDF_tooltip")
	public void Verify_the_PDF_tooltip() {

		try {
			log.info("************************* TC-006*************************");
			extentTest.setDescription("TC_Reports_Trip Stop Detailed_006 To verify_the_PDF_tooltip");
			reportsPage = new ReportsPage(getDriver());
			loginPage = new LoginPage(getDriver());
			loginPage.enterEmailAddess(config.getProperty("superAdminEmail"));
			loginPage.enterPassword(config.getProperty("superAdminPassword"));
			loginPage.clickOnLogInButton();
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarTripStopDetailed();

			// Verify the PDF tooltip
			String expectedTooltip = "Export PDF";
			WebElement PDF = driver
					.findElement(By.xpath("//div//div[@class='ant-card-head-wrapper']//div[2]//button[2]"));
			Actions actions = new Actions(driver);
			actions.moveToElement(PDF).perform();
			WebElement toolTipElement = driver.findElement(By.cssSelector("div[role='tooltip']"));
			String actualTooltip = toolTipElement.getText();
			System.out.println("Actual Title of Tool Tip +++++++++" + actualTooltip);
			Assert.assertEquals(actualTooltip, expectedTooltip);
			Assert.assertTrue(reportsPage.isReportHomeLinkPresent());

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable To verify_the_PDF_tooltip" + UtilityMethods.getStackTrace());
			Assert.fail("Unable To verify_the_PDF_tooltip");
		}
	}

	@Test(priority = 6, description = "TC_Reports_Trip Stop Detailed_007 To verify_the_CSV_tooltip")
	public void Verify_the_CSV_tooltip() {

		try {
			log.info("************************* TC-007*************************");
			extentTest.setDescription("TC_Reports_Trip Stop Detailed_007 To verify_the_CSV_tooltip");
			reportsPage = new ReportsPage(getDriver());
			loginPage = new LoginPage(getDriver());
			loginPage.enterEmailAddess(config.getProperty("superAdminEmail"));
			loginPage.enterPassword(config.getProperty("superAdminPassword"));
			loginPage.clickOnLogInButton();
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarTripStopDetailed();

			// Verify the CSV tooltip
			String expectedTooltip = "Export CSV";
			WebElement CSV = driver
					.findElement(By.xpath("//div//div[@class='ant-card-head-wrapper']//div[2]//button[3]"));
			Actions actions = new Actions(driver);
			actions.moveToElement(CSV).perform();
			WebElement toolTipElement = driver.findElement(By.cssSelector("div[role='tooltip']"));
			String actualTooltip = toolTipElement.getText();
			System.out.println("Actual Title of Tool Tip +++++++++" + actualTooltip);
			Assert.assertEquals(actualTooltip, expectedTooltip);
			Assert.assertTrue(reportsPage.isReportHomeLinkPresent());

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable To verify_the_PDF_tooltip" + UtilityMethods.getStackTrace());
			Assert.fail("Unable To verify_the_CSV_tooltip");
		}
	}

	@Test(priority = 7, description = "TC_Reports_Trip Stop Detailed_008 To verify_the_HTML_tooltip")
	public void Verify_the_HTML_tooltip() {

		try {
			log.info("************************* TC-008*************************");
			extentTest.setDescription("TC_Reports_Trip Stop Detailed_008 To verify_the_HTML_tooltip");
			reportsPage = new ReportsPage(getDriver());
			loginPage = new LoginPage(getDriver());
			loginPage.enterEmailAddess(config.getProperty("superAdminEmail"));
			loginPage.enterPassword(config.getProperty("superAdminPassword"));
			loginPage.clickOnLogInButton();
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarTripStopDetailed();

			// Verify the HTML tooltip
			String expectedTooltip = "Export HTML";
			WebElement HTML = driver
					.findElement(By.xpath("//div//div[@class='ant-card-head-wrapper']//div[2]//button[4]"));
			Actions actions = new Actions(driver);
			actions.moveToElement(HTML).perform();

			WebElement toolTipElement = driver.findElement(By.cssSelector("div[role='tooltip']"));
			String actualTooltip = toolTipElement.getText();
			System.out.println("Actual Title of Tool Tip +++++++++" + actualTooltip);
			Assert.assertEquals(actualTooltip, expectedTooltip);
			Assert.assertTrue(reportsPage.isReportHomeLinkPresent());

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable To verify_the_HTML_tooltip" + UtilityMethods.getStackTrace());
			Assert.fail("Unable To verify_the_HTML_tooltip");
		}
	}

	@Test(priority = 8, description = "TC_Reports_Trip Stop Detailed_009 To verify the 'Trip Stop Detailed' using 'Daily (Period) functionality ")
	public void Verify_the_Trip_Stop_Detailed_using_DailyPeriod_functionality() {

		try {
			log.info("************************* TC-009*************************");
			extentTest.setDescription(
					"TC_Reports_Trip Stop Detailed_009 To verify the 'Trip Stop Detailed' using 'Daily (Period) functionality");
			reportsPage = new ReportsPage(getDriver());
			loginPage = new LoginPage(getDriver());
			loginPage.enterEmailAddess(config.getProperty("superAdminEmail"));
			loginPage.enterPassword(config.getProperty("superAdminPassword"));
			loginPage.clickOnLogInButton();
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarTripStopDetailed();
			reportsPage.selectObject();
			reportsPage.clickOnPeriodDropdowAndPeriodDropdownDaily();
			Assert.assertTrue(reportsPage.isAntNotificationMessagePresent());

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable To verify the 'Trip Stop Detailed' using 'Daily (Period) functionality "
					+ UtilityMethods.getStackTrace());
			Assert.fail("Unable To verify the 'Trip Stop Detailed' using 'Daily (Period) functionality ");
		}
	}

	@Test(priority = 9, description = "TC_Reports_Trip Stop Detailed_010 To verify the 'Trip Stop Detailed' using 'Weekly' (Period) functionality")
	public void Verify_the_Trip_Stop_Detailed_using_WeeklyPeriod_functionality() {

		try {
			log.info("************************* TC-010*************************");
			extentTest.setDescription(
					"TC_Reports_Trip Stop Detailed_010 To verify the 'Trip Stop Detailed' using 'Weekly' (Period) functionality");
			reportsPage = new ReportsPage(getDriver());
			loginPage = new LoginPage(getDriver());
			loginPage.enterEmailAddess(config.getProperty("superAdminEmail"));
			loginPage.enterPassword(config.getProperty("superAdminPassword"));
			loginPage.clickOnLogInButton();
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarTripStopDetailed();
			reportsPage.selectObject();
			reportsPage.clickOnPeriodDropdowAndPeriodDropdownWeekly();
			Assert.assertTrue(reportsPage.isReportHeadinglistData());

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable To verify the 'Trip Stop Detailed' using 'Weekly' (Period) functionality "
					+ UtilityMethods.getStackTrace());
			Assert.fail("Unable To verify the 'Trip Stop Detailed' using 'Weekly' (Period) functionality  ");
		}
	}

	@Test(priority = 10, description = "TC_Reports_Trip Stop Detailed_011 To Verify the 'Trip Stop Detailed' using 'Monthly' (Period) functionality ")
	public void Verify_the_Trip_Stop_Detailed_using_Monthly_Period_functionality() {

		try {
			log.info("************************* TC-010*************************");
			extentTest.setDescription(
					"TC_Reports_Trip Stop Detailed_011 To verify the 'Trip Stop Detailed' using 'Monthly' (Period) functionality ");
			reportsPage = new ReportsPage(getDriver());
			loginPage = new LoginPage(getDriver());
			loginPage.enterEmailAddess(config.getProperty("superAdminEmail"));
			loginPage.enterPassword(config.getProperty("superAdminPassword"));
			loginPage.clickOnLogInButton();
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarTripStopDetailed();
			reportsPage.selectObject();
			reportsPage.clickOnPeriodDropdowAndPeriodDropdownMonthly();

			Assert.assertTrue(reportsPage.isReportHeadinglistData());

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable To verify the 'Trip Stop Detailed' using 'Monthly' (Period) functionality "
					+ UtilityMethods.getStackTrace());
			Assert.fail("Unable To verify the 'Trip Stop Detailed' using 'Monthly' (Period) functionality ");
		}
	}

	@Test(priority = 11, description = "TC_Reports_Trip Stop Detailed_012 Verify the 'Trip Stop Detailed' using 'Custom' (Period) functionality check the presence of start date and end date")
	public void A_Verify_the_Trip_Stop_Detailed_using_Custom_Period_functionality_check_the_presence_of_start_date_and_end_date() {

		try {
			log.info("************************* TC-011*************************");
			extentTest.setDescription(
					"TC_Reports_Trip Stop Detailed_011 To verify the 'Trip Stop Detailed' using 'Custom' (Period) functionality check the presence of start date and end date");
			reportsPage = new ReportsPage(getDriver());
			loginPage = new LoginPage(getDriver());
			loginPage.enterEmailAddess(config.getProperty("superAdminEmail"));
			loginPage.enterPassword(config.getProperty("superAdminPassword"));
			loginPage.clickOnLogInButton();
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarTripStopDetailed();
			reportsPage.selectObject();
			reportsPage.clickOnPeriodDropdown();
			reportsPage.ClickOnPeriodDropdownCustom();
			Assert.assertTrue(reportsPage.isEndDatePresentOnCustom());
			Assert.assertTrue(reportsPage.isStartDatePresentOnCustom());

		} catch (Exception e) {
			e.printStackTrace();
			logError(
					"Unable To terify the 'Trip Stop Detailed' using 'Custom' (Period) functionality check the presence of start date and end date"
							+ UtilityMethods.getStackTrace());
			Assert.fail(
					"Unable To verify the 'Trip Stop Detailed' using 'Custom' (Period) functionality check the presence of start date and end date");
		}
	}

	@Test(priority = 12, description = "TC_Reports_Trip Stop Detailed_013 Verify the 'Trip Stop Detailed' using 'Custom' (Period) functionality check the list data")
	public void B_Verify_the_Trip_Stop_Detailed_using_Custom_Period_functionality() {

		try {
			log.info("************************* TC-013*************************");
			extentTest.setDescription(
					"TC_Reports_Trip Stop Detailed_011 To Verify the 'Trip Stop Detailed' using 'Custom' (Period) functionality check the list data");
			reportsPage = new ReportsPage(getDriver());
			loginPage = new LoginPage(getDriver());
			loginPage.enterEmailAddess(config.getProperty("superAdminEmail"));
			loginPage.enterPassword(config.getProperty("superAdminPassword"));
			loginPage.clickOnLogInButton();
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarTripStopDetailed();
			reportsPage.selectObject();
			reportsPage.clickOnPeriodDropdown();
			reportsPage.ClickOnPeriodDropdownCustom();
			reportsPage.ClickOnStartDateCustom();
			for (int i = 1; i <= 7; i++) {
				reportsPage.ClickOnPreviousMonthOnStartDateCustom();
			}

			reportsPage.selectMarchFirstdate();
			reportsPage.ClickOnEndDateCustom();
			reportsPage.getCurrentDay1();
			reportsPage.clickOnSearchButton();
			Assert.assertTrue(reportsPage.isReportHeadinglistData());

		} catch (Exception e) {
			e.printStackTrace();
			logError(
					"Unable To verify the 'Trip Stop Detailed' using 'Custom' (Period) functionality check the list data"
							+ UtilityMethods.getStackTrace());
			Assert.fail(
					"Unable To verify the 'Trip Stop Detailed' using 'Custom' (Period) functionality check the list data");
		}
	}

	@Test(priority = 13, description = "TC_Reports_Trip Stop Detailed_014 Verify the 'Reset' button functionality")
	public void Verify_the_Reset_button_functionality() {

		try {
			log.info("************************* TC-014*************************");
			extentTest.setDescription("TC_Reports_Trip Stop Detailed_013 To verify the 'Reset' button functionality");
			reportsPage = new ReportsPage(getDriver());
			loginPage = new LoginPage(getDriver());
			loginPage.enterEmailAddess(config.getProperty("superAdminEmail"));
			loginPage.enterPassword(config.getProperty("superAdminPassword"));
			loginPage.clickOnLogInButton();
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarTripStopDetailed();
			reportsPage.selectObject();
			reportsPage.clickOnPeriodDropdown();
			reportsPage.ClickOnPeriodDropdownCustom();
			reportsPage.ClickOnStartDateCustom();
			for (int i = 1; i <= 7; i++) {
				reportsPage.ClickOnPreviousMonthOnStartDateCustom();
			}

			reportsPage.selectMarchFirstdate();
			reportsPage.ClickOnEndDateCustom();
			reportsPage.getCurrentDay1();
			reportsPage.clickOnSearchButton();
			Assert.assertTrue(reportsPage.isReportHeadinglistData());
			reportsPage.clickOnResetButton();
			Assert.assertFalse(reportsPage.isReportHeadinglistData());

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable To verify the 'Reset' button functionality" + UtilityMethods.getStackTrace());
			Assert.fail("Unable To verify the 'Reset' button functionality");
		}
	}

	@Test(priority = 14, enabled=false, description = "TC_Reports_TripStopDetailed_015 Verify the without select any option and click on 'Email on demand', 'PDF','CSV', and 'HTML' button")
	public void Verify_the_without_select_any_option_and_click_on_Email_on_demand_PDF_CSV_and_HTML_button() {

		try {
			log.info("************************* TC-015*************************");
			extentTest.setDescription(
					"TC_Reports_TripStopDetailed_015 To verify the without select any option and click on 'Email on demand', 'PDF','CSV', and 'HTML' button");
			reportsPage = new ReportsPage(getDriver());
			loginPage = new LoginPage(getDriver());
			loginPage.enterEmailAddess(config.getProperty("superAdminEmail"));
			loginPage.enterPassword(config.getProperty("superAdminPassword"));
			loginPage.clickOnLogInButton();
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarTripStopDetailed();
			reportsPage.clickOnSearchButton();

			// Verify the object validation
			reportsPage.clickOnEmailOnDemands();
			Assert.assertTrue(reportsPage.isAntNotificationMessagePresent());
			reportsPage.clickOnPDF();
			Assert.assertTrue(reportsPage.isAntNotificationMessagePresent());
			reportsPage.clickOnCSV();
			Assert.assertTrue(reportsPage.isAntNotificationMessagePresent());
			reportsPage.clickOnHTML();
			Assert.assertTrue(reportsPage.isAntNotificationMessagePresent());

		} catch (Exception e) {
			e.printStackTrace();
			logError(
					"Unable To verify the without select any option and click on 'Email on demand', 'PDF','CSV', and 'HTML' button"
							+ UtilityMethods.getStackTrace());
			Assert.fail(
					"Unable To verify the without select any option and click on 'Email on demand', 'PDF','CSV', and 'HTML' button");
		}
	}

	@Test(priority = 15, description = "TC_Reports_TripStopDetailed_016 To verify the 'Email on demand' Popup UI")
	public void Verify_the_Email_on_demand_Popup_UI() {

		try {
			log.info("************************* TC-016*************************");
			extentTest.setDescription("TC_Reports_TripStopDetailed_016 Verify the 'Email on demand' Popup UI");
			reportsPage = new ReportsPage(getDriver());
			loginPage = new LoginPage(getDriver());
			loginPage.enterEmailAddess(config.getProperty("superAdminEmail"));
			loginPage.enterPassword(config.getProperty("superAdminPassword"));
			loginPage.clickOnLogInButton();
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarTripStopDetailed();
			reportsPage.selectObject();
			reportsPage.clickOnPeriodDropdown();
			reportsPage.ClickOnPeriodDropdownCustom();
			reportsPage.ClickOnStartDateCustom();
			for (int i = 1; i <= 7; i++) {
				reportsPage.ClickOnPreviousMonthOnStartDateCustom();
			}

			reportsPage.selectMarchFirstdate();
			reportsPage.ClickOnEndDateCustom();
			reportsPage.getCurrentDay1();
			reportsPage.clickOnSearchButton();
			Assert.assertTrue(reportsPage.isReportHeadinglistData());

			// Verify the object validation
			reportsPage.clickOnEmailOnDemands();
			Assert.assertTrue(reportsPage.isEmailOnDemandDialogTitlePresent());
			Assert.assertTrue(reportsPage.isEmailOnDemandLabelPresent());
			Assert.assertTrue(reportsPage.isEmailOnDemandEmailFieldPresent());
			Assert.assertTrue(reportsPage.isEmailOnDemandEmailFieldPlaceholderPresent());
			Assert.assertTrue(reportsPage.isEmailOnDemandCancelBtnPresent());
			Assert.assertTrue(reportsPage.isEmailOnDemandSendRequestBtnPresent());
			Assert.assertTrue(reportsPage.isEmailOnDemandCrossBtnPresent());
			reportsPage.clickOnEmailOnDemandSendRequestBtn();
			String ErrorMesg = reportsPage.getTextEmailOnDemandEmailFieldErrorMessageg();
			Assert.assertEquals(ErrorMesg, "Please Enter Email ID");

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable To verify the 'Email on demand' Popup UI" + UtilityMethods.getStackTrace());
			Assert.fail("Unable To verify the 'Email on demand' Popup UI");
		}
	}
	
	@Test(priority = 16, description = "TC_Reports_TripStopDetailed_017 Verify 'Send Report' button functionality on 'Email on Demand download' Popup if Fill-up email field")
	public void Verify_Send_Report_button_functionality_on_Email_on_Demand_download_Popup_if_Fill_up_email_field() {

		try {
			log.info("************************* TC-016*************************");
			extentTest.setDescription("TC_Reports_TripStopDetailed_017 To verify 'Send Report' button functionality on 'Email on Demand download' Popup if Fill-up email field");
			reportsPage = new ReportsPage(getDriver());
			loginPage = new LoginPage(getDriver());
			// Open Yopmail window
			((JavascriptExecutor) driver).executeScript("window.open()");
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));
			driver.get("http://www.yopmail.com/en/");
			driver.switchTo().window(tabs.get(0));
			loginPage.enterEmailAddess(config.getProperty("superAdminEmail"));
			loginPage.enterPassword(config.getProperty("superAdminPassword"));
			loginPage.clickOnLogInButton();
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarTripStopDetailed();
			reportsPage.selectObject();
			reportsPage.clickOnPeriodDropdown();
			reportsPage.ClickOnPeriodDropdownCustom();
			reportsPage.ClickOnStartDateCustom();
			for (int i = 1; i <= 7; i++) {
				reportsPage.ClickOnPreviousMonthOnStartDateCustom();
			}

			reportsPage.selectMarchFirstdate();
			reportsPage.ClickOnEndDateCustom();
			reportsPage.getCurrentDay1();
			reportsPage.clickOnSearchButton();
			Assert.assertTrue(reportsPage.isReportHeadinglistData());
			
			reportsPage.clickOnEmailOnDemands();
			Thread.sleep(3000);
			reportsPage.enterEmailAddessOnEmailDemands("trackSy@yopmail.com");
			Thread.sleep(3000);
			reportsPage.clickOnEmailOnDemandSendRequestBtn();

			// Verify email from yopmail
			driver.switchTo().window(tabs.get(1));
			yopmail();
			Assert.assertTrue(reportsPage.isEmailPresent());
		   //reportsPage.clickOnDeleteEmailOnYopmail();
			driver.manage().deleteAllCookies();

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable To verify the 'Email on demand' Popup UI" + UtilityMethods.getStackTrace());
			Assert.fail("Unable To verify the 'Email on demand' Popup UI");
		}
	}
	
	public void yopmail() {
		driver.findElement(By.cssSelector("input.scpt")).sendKeys("trackSy@yopmail.com");
		driver.findElement(By.cssSelector("input.scpt")).sendKeys(Keys.ENTER);
		driver.switchTo().frame("ifmail");
	}
	
	@Test(priority = 17, description = "TC_Reports_TripStopDetailed_018 Verify the 'Cancel' functionality in email on demand popup")
	public void Verify_the_Cancel_functionality_in_email_on_demand_popup() {

		try {
			log.info("************************* TC-018*************************");
			extentTest.setDescription("TC_Reports_TripStopDetailed_018 To Verify the 'Cancel' functionality in email on demand popup");
			reportsPage = new ReportsPage(getDriver());
			loginPage = new LoginPage(getDriver());
			loginPage.enterEmailAddess(config.getProperty("superAdminEmail"));
			loginPage.enterPassword(config.getProperty("superAdminPassword"));
			loginPage.clickOnLogInButton();
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarTripStopDetailed();
			reportsPage.selectObject();
			reportsPage.clickOnPeriodDropdown();
			reportsPage.ClickOnPeriodDropdownCustom();
			reportsPage.ClickOnStartDateCustom();
			for (int i = 1; i <= 7; i++) {
				reportsPage.ClickOnPreviousMonthOnStartDateCustom();
			}

			reportsPage.selectMarchFirstdate();
			reportsPage.ClickOnEndDateCustom();
			reportsPage.getCurrentDay1();
			reportsPage.clickOnSearchButton();
			Assert.assertTrue(reportsPage.isReportHeadinglistData());
			reportsPage.clickOnEmailOnDemands();
			Assert.assertTrue(reportsPage.isEmailOnDemandDialogTitlePresent());
			reportsPage.clickOnCancelButtonEmailOnDemands();		

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable To verify the 'Cancel' functionality in email on demand popup" + UtilityMethods.getStackTrace());
			Assert.fail("Unable To verify the 'Cancel' functionality in email on demand popup");
		}
	}
	
	@Test(priority = 18, description = "TC_Reports_TripStopDetailed_019 Verify the 'cross' (×) button functionality in_email_on_demand_popup")
	public void Verify_the_cross_X_button_functionality_in_email_on_demand_popup() {

		try {
			log.info("************************* TC-019*************************");
			extentTest.setDescription("TC_Reports_TripStopDetailed_019 To verify the 'cross' (×) button functionality in_email_on_demand_popup");
			reportsPage = new ReportsPage(getDriver());
			loginPage = new LoginPage(getDriver());
			loginPage.enterEmailAddess(config.getProperty("superAdminEmail"));
			loginPage.enterPassword(config.getProperty("superAdminPassword"));
			loginPage.clickOnLogInButton();
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarTripStopDetailed();
			reportsPage.selectObject();
			reportsPage.clickOnPeriodDropdown();
			reportsPage.ClickOnPeriodDropdownCustom();
			reportsPage.ClickOnStartDateCustom();
			for (int i = 1; i <= 7; i++) {
				reportsPage.ClickOnPreviousMonthOnStartDateCustom();
			}
			reportsPage.selectMarchFirstdate();
			reportsPage.ClickOnEndDateCustom();
			reportsPage.getCurrentDay1();
			reportsPage.clickOnSearchButton();
			Assert.assertTrue(reportsPage.isReportHeadinglistData());
			reportsPage.clickOnEmailOnDemands();
			reportsPage.clickOnCrossButtonEmailOnDemands();		

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable To verify the 'cross' (×) button functionality in_email_on_demand_popup" + UtilityMethods.getStackTrace());
			Assert.fail("Unable To verify the 'cross' (×) button functionality in_email_on_demand_popup");
		}
	}
	
	
	@Test(priority = 19, description = "TC_Reports_TripStopDetailed_020 Verify_PDF_download")
	public void Verify_PDF_download() {

		try {
			log.info("************************* TC-020*************************");
			extentTest.setDescription("TC_Reports_TripStopDetailed_018 Verify_PDF_download");
			loginPage = new LoginPage(getDriver());
			dashboardPage = new DashboardPage(getDriver());
			reportsPage = new ReportsPage(getDriver());
			loginPage.enterEmailAddess(config.getProperty("superAdminEmail"));
			loginPage.enterPassword(config.getProperty("superAdminPassword"));
			loginPage.clickOnLogInButton();
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarTripStopDetailed();
			reportsPage.selectObject();
			reportsPage.clickOnPeriodDropdown();
			reportsPage.ClickOnPeriodDropdownCustom();
			reportsPage.ClickOnStartDateCustom();
			for (int i = 1; i <= 7; i++) {
				reportsPage.ClickOnPreviousMonthOnStartDateCustom();
			}
			reportsPage.selectMarchFirstdate();
			reportsPage.ClickOnEndDateCustom();
			reportsPage.getCurrentDay1();
			reportsPage.clickOnSearchButton();
			reportsPage.clickOnPDF();
		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to verify_PDF_download" + UtilityMethods.getStackTrace());
			Assert.fail("Unable to verify_PDF_download");
		}
	}

	@Test(priority = 20, description = "TC_ReportLogs_021 Verify 'CSV'  download functionality ")
	public void Verify_CSV_download_functionality() {

		try {
			log.info("************************* TC-021*************************");
			extentTest.setDescription("TC_ReportLogs_021 To verify 'CSV'  download functionality ");
			loginPage = new LoginPage(getDriver());
			dashboardPage = new DashboardPage(getDriver());
			reportsPage = new ReportsPage(getDriver());
			loginPage.enterEmailAddess(config.getProperty("superAdminEmail"));
			loginPage.enterPassword(config.getProperty("superAdminPassword"));
			loginPage.clickOnLogInButton();
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarTripStopDetailed();
			reportsPage.selectObject();
			reportsPage.clickOnPeriodDropdown();
			reportsPage.ClickOnPeriodDropdownCustom();
			reportsPage.ClickOnStartDateCustom();
			for (int i = 1; i <= 7; i++) {
				reportsPage.ClickOnPreviousMonthOnStartDateCustom();
			}
			reportsPage.selectMarchFirstdate();
			reportsPage.ClickOnEndDateCustom();
			reportsPage.getCurrentDay1();
			reportsPage.clickOnSearchButton();
			reportsPage.clickOnCSV();

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable To verify 'CSV'  download functionality " + UtilityMethods.getStackTrace());
			Assert.fail("Unable To verify 'CSV'  download functionality ");
		}
	}

	@Test(priority = 21, description = "TC_ReportLogs_022 Verify 'HTML download' functionality")
	public void Verify_HTML_download_functionality() {

		try {
			log.info("************************* TC-008*************************");
			extentTest.setDescription("TC_ReportLogs_022 To verify 'HTML download' functionality");
			loginPage = new LoginPage(getDriver());
			dashboardPage = new DashboardPage(getDriver());
			reportsPage = new ReportsPage(getDriver());
			loginPage.enterEmailAddess(config.getProperty("superAdminEmail"));
			loginPage.enterPassword(config.getProperty("superAdminPassword"));
			loginPage.clickOnLogInButton();
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarTripStopDetailed();
			reportsPage.selectObject();
			reportsPage.clickOnPeriodDropdown();
			reportsPage.ClickOnPeriodDropdownCustom();
			reportsPage.ClickOnStartDateCustom();
			for (int i = 1; i <= 7; i++) {
				reportsPage.ClickOnPreviousMonthOnStartDateCustom();
			}
			reportsPage.selectMarchFirstdate();
			reportsPage.ClickOnEndDateCustom();
			reportsPage.getCurrentDay1();
			reportsPage.clickOnSearchButton();
			reportsPage.clickOnHTML();

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable To verify 'HTML download' functionality" + UtilityMethods.getStackTrace());
			Assert.fail("Unable To verify 'HTML download' functionality");
		}
	}

	

}
