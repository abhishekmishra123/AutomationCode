package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import Common.BaseSetup;
import Common.UtilityMethods;
import PageObjects.LoginPage;
import PageObjects.ReportsPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ScheduleReportTest extends BaseSetup {
	LoginPage loginPage;

	ReportsPage reportsPage;

	static Logger log = Logger.getLogger(ScheduleReportTest.class);

	@Test(priority = 0, description = "TC_ScheduleReport_068 Verify the 'Schedule Reports' Side bar link functionality")
	public void Verify_the_Schedule_Reports_Side_bar_link_functionality() {

		try {
			log.info("************************* TC-068*************************");
			extentTest.setDescription(
					"TC_ScheduleReport_068 Verify the 'Schedule Report' side bar link functionality ");
			reportsPage = new ReportsPage(getDriver());
			loginPage = new LoginPage(getDriver());
			loginPage.enterEmailAddess(config.getProperty("siteAdminEmailData"));
			loginPage.enterPassword(config.getProperty("siteAdminPasswordData"));
			loginPage.clickOnLogInButton();
			reportsPage.clickOnReportsSidebar();
			Assert.assertTrue(reportsPage.isReportsSidebarReportsLogPresent());
			Assert.assertTrue(reportsPage.isreportsSidebarTripStopDetailedPresent());
			Assert.assertTrue(reportsPage.isReportsSidebarSpeedingReportPresent());
			Assert.assertTrue(reportsPage.isReportsSidebarEventsReportPresent());
			Assert.assertTrue(reportsPage.isReportsSidebarScheduleReportPresent());
			reportsPage.clickOnReportsSidebarScheduleReport();
			String pageUrl = loginPage.getCurrentWebpageURL();
			if (pageUrl.contains("schedule_report")) {
				Assert.assertEquals(1, 1);
			} else {
				Assert.assertEquals(1, 0);
			}

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to Verify the Schedule Reports' Side bar link functionality"
					+ UtilityMethods.getStackTrace());
			Assert.fail("Unable to Verify the Schedule Reports' Side bar link functionality");
		}

	}

	@Test(priority = 1, description = "TC_ScheduleReport_069 Verify the 'UI' of 'Schedule Reports' ")
	public void Verify_the_UI_of_Schedule_Reports() {

		try {
			log.info("************************* TC-069*************************");
			extentTest.setDescription("TC_ScheduleReport_069 Verify the 'UI' of 'Schedule Report' ");
			reportsPage = new ReportsPage(getDriver());
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarScheduleReport();
			Assert.assertTrue(reportsPage.isReportHomeLinkPresent());
			Assert.assertTrue(reportsPage.isReportsLinkPresent());
			Assert.assertTrue(reportsPage.isScheduleReportLinkPresent());
			Assert.assertEquals(reportsPage.getCssValueReportsLogsTitle(), "rgba(2, 192, 245, 1)");

			// Verify the Schedule Report drop-down
			reportsPage.clickOnScheduleReportDropdown();
			for (int i = 1; i <= 5; i++) {
				Assert.assertTrue(reportsPage.isScheduleDropdownSelectOptionPresent(i));

			}
			Assert.assertTrue(reportsPage.isAddScheduleReportButtonPresent());
			Assert.assertTrue(reportsPage.isSearchFieldPresent());
			for (int i = 1; i <= 9; i++) {
				Assert.assertTrue(reportsPage.isReportHeadingColumnPresent(i));
			}

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to Verify the 'UI' of 'Schedule Reports' " + UtilityMethods.getStackTrace());
			Assert.fail("Unable to Verify the 'UI' of 'Schedule Reports' ");
		}
	}

	@Test(priority = 2, description = "TC_Reports_SpeedingReport_070 Verify the tool tip of 'Add Schedule Report'")
	public void Verify_the_tooltip_of_Add_Schedule_Report() {

		try {
			log.info("************************* TC-070*************************");
			extentTest.setDescription("TC_Reports_SpeedingReport_070 Verify the tool tip of  'Add Schedule Report'");
			reportsPage = new ReportsPage(getDriver());
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarScheduleReport();

			// Verify the email on demand tooltip
			String expectedTooltip = "Add Schedule Report";
			WebElement emailOnDemand = driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary']"));
			Actions actions = new Actions(driver);
			actions.moveToElement(emailOnDemand).perform();

			WebElement toolTipElement = driver.findElement(By.cssSelector("div[role='tooltip']"));
			Thread.sleep(2000);
			String actualTooltip = toolTipElement.getText();
			System.out.println("Actual Title of Tool Tip +++++++++" + actualTooltip);
			Assert.assertEquals(actualTooltip, expectedTooltip);

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to Verify the tool tip of  'Add Schedule Report'" + UtilityMethods.getStackTrace());
			Assert.fail("Unable to Verify the tool tip of  'Add Schedule Report'");
		}
	}

	@Test(priority = 3, description = "TC_Reports_SpeedingReport_071 Verify the 'Add Schedule Report' button functionality")
	public void Verify_the_Add_Schedule_Report_button_functionality() {

		try {
			log.info("************************* TC-071*************************");
			extentTest.setDescription(
					"TC_Reports_SpeedingReport_072 Verify the 'Add Schedule Report' button functionality");
			reportsPage = new ReportsPage(getDriver());
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarScheduleReport();
			Assert.assertTrue(reportsPage.isAddScheduleReportButtonPresent());
			reportsPage.clickOnAddScheduleReportButton();

		} catch (Exception e) {
			e.printStackTrace();
			logError(
					"Unable to Verify the 'Add Schedule Report' button functionality" + UtilityMethods.getStackTrace());
			Assert.fail("Unable to Verify the 'Add Schedule Report' button functionality");
		}
	}

	@Test(priority = 4, description = "TC_Reports_SpeedingReport_072 Verify the 'Add Schedule Report' Popup UI ")
	public void Verify_the_Add_Schedule_Report_Popup_UI() {

		try {
			log.info("************************* TC-072*************************");
			extentTest.setDescription("TC_Reports_Speeding Report_072 Verify the 'Add Schedule Report' Popup UI '");
			reportsPage = new ReportsPage(getDriver());
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarScheduleReport();
			Assert.assertTrue(reportsPage.isAddScheduleReportButtonPresent());
			reportsPage.clickOnAddScheduleReportButton();
			Assert.assertTrue(reportsPage.isEmailOnDemandDialogTitlePresent());
			Assert.assertTrue(reportsPage.isReportFieldPresent());
			Assert.assertTrue(reportsPage.isVehicleFieldPresent());
			Assert.assertTrue(reportsPage.isPeriodFieldPresent());
			Assert.assertTrue(reportsPage.isScheduleNamePresent());
			Assert.assertTrue(reportsPage.isEmailOnDemandCancelBtnPresent());
			Assert.assertTrue(reportsPage.isAddScheduleReportSaveBtnPresent());
			Assert.assertTrue(reportsPage.isEmailOnDemandCrossBtnPresent());

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to Verify the 'Add Schedule Report' Popup UI " + UtilityMethods.getStackTrace());
			Assert.fail("Unable to Verify the 'Add Schedule Report' Popup UI");
		}
	}

	@Test(priority = 5, description = "TC_Reports_SpeedingReport_073 Verify the 'Placeholder' in all field on 'Add Schedule Report' Popup")
	public void Verify_the_Placeholder_in_all_field_on_Add_Schedule_Report_page() {

		try {
			log.info("************************* TC-073*************************");
			extentTest.setDescription(
					"TC_Reports_SpeedingReport_073 Verify the 'Placeholder' in all field on 'Add Schedule Report' Popup");
			reportsPage = new ReportsPage(getDriver());
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarScheduleReport();
			reportsPage.clickOnAddScheduleReportButton();

			// Verify the Schedule Name placeholder text
			String expectedScheduleNameText = "Enter Schedule Name";
			String actualScheduleNameText = reportsPage.getScheduleNamePlaceholder();
			Assert.assertEquals(actualScheduleNameText, expectedScheduleNameText);

			// Verify the Vehicle placeholder text
			String expectedSelectVehicleText = "Select Vehicle";
			String actualSelectObjectText = reportsPage.getSelectObjectPlaceholder();
			Assert.assertEquals(actualSelectObjectText, expectedSelectVehicleText);

			// Verify the Report placeholder text
			String expectedSelectPeriodText = "Select Report";
			String actualSelectPeriodText = reportsPage.getSelectReportPlaceholder();
			Assert.assertEquals(actualSelectPeriodText, expectedSelectPeriodText);

			// Verify the Period placeholder text
			String expectedStartDateText = "Select Period";
			String actualStartDateText = reportsPage.getPeriodReportPlaceholder();
			Assert.assertEquals(actualStartDateText, expectedStartDateText);

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable To Verify the 'Placeholder' in all field on 'Add Schedule Report' Popup"
					+ UtilityMethods.getStackTrace());
			Assert.fail("Unable To Verify the 'Placeholder' in all field on 'Add Schedule Report' Popup");
		}
	}

	@Test(priority = 6, description = "TC_ScheduleReport_074 Verify the Save button functionality of 'Add Schedule Report' Popup if left all fields ")
	public void Verify_the_Save_button_functionality_of_Add_Schedule_Report_Popup_if_left_all_fields() {

		try {
			log.info("************************* TC-074*************************");
			extentTest.setDescription(
					"TC_ScheduleReport_074 Verify the Save button functionality of 'Add Schedule Report' Popup if left all fields ");
			reportsPage = new ReportsPage(getDriver());
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarScheduleReport();
			reportsPage.clickOnAddScheduleReportButton();
			reportsPage.clickOnSaveButton();

			// Verify the object validation
			String expectedScheduleNameValidation = "Please Enter Schedule Name";
			String actualScheduleNameValidation = reportsPage.getScheduleNameValidation();
			Assert.assertEquals(actualScheduleNameValidation, expectedScheduleNameValidation);

			// Verify the report validation
			String expectedReportValidation = "Please Select Report";
			String ActualdReportValidation = reportsPage.getReportValidation();
			Assert.assertEquals(ActualdReportValidation, expectedReportValidation);

			// Verify the vehicle validation
			String expectedSelectVehicleValidation = "Please Select Vehicle";
			String actualSelectObjectValidation = reportsPage.getSelectObjectValidation();
			Assert.assertEquals(actualSelectObjectValidation, expectedSelectVehicleValidation);

			// Verify the report period validation
			String expectedReportPeriodValidation = "Please Select Report Period";
			String actualSelectPeriodTextValidation = reportsPage.getSelectReportPeriodValidation();
			Assert.assertEquals(actualSelectPeriodTextValidation, expectedReportPeriodValidation);

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable To Verify the Save button functionality of 'Add Schedule Report' Popup if left all fields "
					+ UtilityMethods.getStackTrace());
			Assert.fail(
					"Unable To Verify the Save button functionality of 'Add Schedule Report' Popup if left all fields ");
		}
	}
	
	
	@Test(priority = 7, description = "TC_ScheduleReport_075 a) Verify the Save button functionality of 'Add Schedule Report' Popup if fill-up all fields with Trip Stop Detailed and daily period ")
	public void Verify_the_Save_button_functionality_of_Add_Schedule_Report_Popup_if_fill_up_all_fields_with_Trip_Stop_Detailed_and_daily_period() {

		try {
			log.info("************************* TC-075*************************");
			extentTest.setDescription(
					"TC_ScheduleReport_075 Verify the Save button functionality of 'Add Schedule Report' Popup if fill-up all fields with Trip Stop Detailed and daily period ");
			reportsPage = new ReportsPage(getDriver());
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarScheduleReport();
			reportsPage.clickOnAddScheduleReportButton();
			reportsPage.enterScheduleName("Testing Schedule daily");
			reportsPage.clickOnReportTripStopDetailedDropdownOption();
			reportsPage.selectAddScheduleReportVehicle();
			reportsPage.selectAddScheduleReportDailyPeriod();
			reportsPage.clickOnSaveButton();
			Assert.assertTrue(reportsPage.isAntNotificationMessagePresent());
			
		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable To Verify the Save button functionality of 'Add Schedule Report' Popup if fill-up all fields with Trip Stop Detailed and daily period "
					+ UtilityMethods.getStackTrace());
			Assert.fail(
					"Unable To Verify the Save button functionality of 'Add Schedule Report' Popup if fill-up all fields with Trip Stop Detailed and daily period");
		}
	}
	
	@Test(priority = 8, description = "TC_ScheduleReport_076 b) Verify the Save button functionality of 'Add Schedule Report' Popup if fill-up all fields with Trip Stop Detailed, Weekly period ")
	public void Verify_the_Save_button_functionality_of_Add_Schedule_Report_Popup_if_fill_up_all_fields_with_Trip_Stop_Detailed_Weekly_period() {

		try {
			log.info("************************* TC-076*************************");
			extentTest.setDescription(
					"TC_ScheduleReport_076 Verify the Save button functionality of 'Add Schedule Report' Popup if fill-up all fields with Trip Stop Detailed, Weekly period ");
			reportsPage = new ReportsPage(getDriver());
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarScheduleReport();
			reportsPage.clickOnAddScheduleReportButton();
			reportsPage.enterScheduleName("Testing Schedule Weekly");
			reportsPage.clickOnReportTripStopDetailedDropdownOption();
			reportsPage.selectAddScheduleReportVehicle();
			reportsPage.selectAddScheduleReportWeeklyPeriod();
			reportsPage.clickOnSaveButton();
			Assert.assertTrue(reportsPage.isAntNotificationMessagePresent());
			
		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable To Verify the Save button functionality of 'Add Schedule Report' Popup if fill-up all fields with Trip Stop Detailed, Weekly period "
					+ UtilityMethods.getStackTrace());
			Assert.fail(
					"Unable To Verify the Save button functionality of 'Add Schedule Report' Popup if fill-up all fields with Trip Stop Detailed, Weekly period");
		}
	}
	
	@Test(priority = 9, description = "TC_ScheduleReport_077 c) Verify the Save button functionality of 'Add Schedule Report' Popup if fill-up all fields with Trip Stop Detailed, monthly period")
	public void Verify_the_Save_button_functionality_of_Add_Schedule_Report_Popup_if_fill_up_all_fields_with_Trip_Stop_Detailed_Monthly_period() {

		try {
			log.info("************************* TC-077*************************");
			extentTest.setDescription(
					"TC_ScheduleReport_077 Verify the Save button functionality of 'Add Schedule Report' Popup if fill-up all fields with Trip Stop Detailed, monthly period");
			reportsPage = new ReportsPage(getDriver());
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarScheduleReport();
			reportsPage.clickOnAddScheduleReportButton();
			reportsPage.enterScheduleName("Testing Schedule Monthly");
			reportsPage.clickOnReportTripStopDetailedDropdownOption();
			reportsPage.selectAddScheduleReportVehicle();
			reportsPage.selectAddScheduleReportMonthlyPeriod();
			reportsPage.clickOnSaveButton();
			Assert.assertTrue(reportsPage.isAntNotificationMessagePresent());
			
		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable To Verify the Save button functionality of 'Add Schedule Report' Popup if fill-up all fields with Trip Stop Detailed, Weekly period "
					+ UtilityMethods.getStackTrace());
			Assert.fail(
					"Unable To Verify the Save button functionality of 'Add Schedule Report' Popup if fill-up all fields with Trip Stop Detailed, Weekly period");
		}
	}
	
	@Test(priority = 10, description = "TC_ScheduleReport_078 d) Verify the Save button functionality of 'Add Schedule Report' Popup if fill-up all fields  with Speeding Report, Daily period")
	public void Verify_the_Save_button_functionality_of_Add_Schedule_Report_Popup_if_fill_up_all_fields_with_Speeding_Report_Daily_period() {

		try {
			log.info("************************* TC-078*************************");
			extentTest.setDescription(
					"TC_ScheduleReport_078 Verify the Save button functionality of 'Add Schedule Report' Popup if fill-up all fields  with Speeding Report, Daily period");
			reportsPage = new ReportsPage(getDriver());
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarScheduleReport();
			reportsPage.clickOnAddScheduleReportButton();
			reportsPage.enterScheduleName("Testing Schedule Daily");
			reportsPage.clickOnReportSpeedingReportDropdownOption();
			reportsPage.selectAddScheduleReportVehicle();
			reportsPage.clickOnSpeedFilterDrpdwn();
			reportsPage.clickOnSpeedFilterDrpdwnOptionEqualsTo();
			reportsPage.selectAddScheduleReportDailyPeriod();
			reportsPage.clickOnSaveButton();
			Assert.assertTrue(reportsPage.isAntNotificationMessagePresent());
			
		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable To Verify the Save button functionality of 'Add Schedule Report' Popup if fill-up all fields  with Speeding Report, Daily period"
					+ UtilityMethods.getStackTrace());
			Assert.fail(
					"Unable To Verify the Save button functionality of 'Add Schedule Report' Popup if fill-up all fields  with Speeding Report, Daily period");
		}
	}
	
	@Test(priority = 11, description = "TC_ScheduleReport_079 Verify the Save button functionality of 'Add Schedule Report' Popup if fill-up all fields  with Speeding Report, Weekly period")
	public void Verify_the_Save_button_functionality_of_Add_Schedule_Report_Popup_if_fill_up_all_fields_with_Speeding_Report_Weekly_period() {

		try {
			log.info("************************* TC-079*************************");
			extentTest.setDescription(
					"TC_ScheduleReport_079 Verify the Save button functionality of 'Add Schedule Report' Popup if fill-up all fields  with Speeding Report, Weekly period");
			reportsPage = new ReportsPage(getDriver());
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarScheduleReport();
			reportsPage.clickOnAddScheduleReportButton();
			reportsPage.enterScheduleName("Testing Schedule Weekly");
			reportsPage.clickOnReportSpeedingReportDropdownOption();
			reportsPage.selectAddScheduleReportVehicle();
			reportsPage.clickOnSpeedFilterDrpdwn();
			reportsPage.clickOnSpeedDrpdwnOption10();
			reportsPage.selectAddScheduleReportWeeklyPeriod();
			reportsPage.clickOnSaveButton();
			Assert.assertTrue(reportsPage.isAntNotificationMessagePresent());
			
		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable To Verify the Save button functionality of 'Add Schedule Report' Popup if fill-up all fields  with Speeding Report, Weekly period"
					+ UtilityMethods.getStackTrace());
			Assert.fail(
					"Unable To Verify the Save button functionality of 'Add Schedule Report' Popup if fill-up all fields  with Speeding Report, Weekly period");
		}
	}
	
	@Test(priority = 12, description = "TC_ScheduleReport_080 f) Verify the Save button functionality of 'Add Schedule Report' Popup if fill-up all fields with Speeding Report, Monthly period")
	public void Verify_the_Save_button_functionality_of_Add_Schedule_Report_Popup_if_fill_up_all_fields_with_Speeding_Report_Monthly_period() {

		try {
			log.info("************************* TC-080*************************");
			extentTest.setDescription(
					"TC_ScheduleReport_078 Verify the Save button functionality of 'Add Schedule Report' Popup if fill-up all fields  with Speeding Report, Monthly period");
			reportsPage = new ReportsPage(getDriver());
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarScheduleReport();
			reportsPage.clickOnAddScheduleReportButton();
			reportsPage.enterScheduleName("Testing Schedule Monthly");
			reportsPage.clickOnReportSpeedingReportDropdownOption();
			reportsPage.selectAddScheduleReportVehicle();
			reportsPage.clickOnSpeedFilterDrpdwn();
			reportsPage.clickOnSpeedDrpdwnOption30();
			reportsPage.selectAddScheduleReportMonthlyPeriod();
			reportsPage.clickOnSaveButton();
			Assert.assertTrue(reportsPage.isAntNotificationMessagePresent());
			
		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable To Verify the Save button functionality of 'Add Schedule Report' Popup if fill-up all fields  with Speeding Report, Monthly period"
					+ UtilityMethods.getStackTrace());
			Assert.fail(
					"Unable To Verify the Save button functionality of 'Add Schedule Report' Popup if fill-up all fields  with Speeding Report, Monthly period");
		}
	}
	
	@Test(priority = 13, description = "TC_ScheduleReport_081 g) Verify the Save button functionality of 'Add Schedule Report' Popup if fill-up all fields with Events Report, Daily period")
	public void Verify_the_Save_button_functionality_of_Add_Schedule_Report_Popup_if_fill_up_all_fields_with_Events_Report_Daily_period() {

		try {
			log.info("************************* TC-081*************************");
			extentTest.setDescription(
					"TC_ScheduleReport_080 Verify the Save button functionality of 'Add Schedule Report' Popup if fill-up all fields with Events Report, Daily period");
			reportsPage = new ReportsPage(getDriver());
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarScheduleReport();
			reportsPage.clickOnAddScheduleReportButton();
			reportsPage.enterScheduleName("Testing Schedule Daily");
			reportsPage.clickOnReportEventsReportDropdownOption();
			reportsPage.selectAddScheduleReportVehicle();
			reportsPage.clickOnAlertTypeOption();
			reportsPage.selectAddScheduleReportDailyPeriod();
			reportsPage.clickOnSaveButton();
			Assert.assertTrue(reportsPage.isAntNotificationMessagePresent());
			
		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable To Verify the Save button functionality of 'Add Schedule Report' Popup if fill-up all fields with Events Report, Daily period"
					+ UtilityMethods.getStackTrace());
			Assert.fail(
					"Unable To Verify the Save button functionality of 'Add Schedule Report' Popup if fill-up all fields with Events Report, Daily period");
		}
	}
	
	@Test(priority = 14, description = "TC_ScheduleReport_082 h) Verify the Save button functionality of 'Add Schedule Report' Popup if fill-up all fields with Events Report, Weekly period")
	public void Verify_the_Save_button_functionality_of_Add_Schedule_Report_Popup_if_fill_up_all_fields_with_Events_Report_Weekly_period() {

		try {
			log.info("************************* TC-082*************************");
			extentTest.setDescription(
					"TC_ScheduleReport_078 Verify the Save button functionality of 'Add Schedule Report' Popup if fill-up all fields with Events Report, Weekly period");
			reportsPage = new ReportsPage(getDriver());
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarScheduleReport();
			reportsPage.clickOnAddScheduleReportButton();
			reportsPage.enterScheduleName("Testing Schedule Weekly");
			reportsPage.clickOnReportEventsReportDropdownOption();
			reportsPage.selectAddScheduleReportVehicle();
			reportsPage.clickOnAlertTypeOption();
			reportsPage.selectAddScheduleReportWeeklyPeriod();
			reportsPage.clickOnSaveButton();
			Assert.assertTrue(reportsPage.isAntNotificationMessagePresent());
			
		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable To Verify the Save button functionality of 'Add Schedule Report' Popup if fill-up all fields with Events Report, Weekly period"
					+ UtilityMethods.getStackTrace());
			Assert.fail(
					"Unable To Verify the Save button functionality of 'Add Schedule Report' Popup if fill-up all fields with Events Report, Weekly period");
		}
	}
	
	@Test(priority = 15, description = "TC_ScheduleReport_083 i) Verify the Save button functionality of 'Add Schedule Report' Popup if fill-up all fields with Events Report, Monthly period")
	public void Verify_the_Save_button_functionality_of_Add_Schedule_Report_Popup_if_fill_up_all_fields_with_Events_Report_Monthly_period() {

		try {
			log.info("************************* TC-083*************************");
			extentTest.setDescription(
					"TC_ScheduleReport_078 Verify the Save button functionality of 'Add Schedule Report' Popup if fill-up all fields with Events Report, Monthly period");
			reportsPage = new ReportsPage(getDriver());
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarScheduleReport();
			reportsPage.clickOnAddScheduleReportButton();
			reportsPage.enterScheduleName("Testing Schedule Monthly");
			reportsPage.clickOnReportEventsReportDropdownOption();
			reportsPage.selectAddScheduleReportVehicle();
			reportsPage.clickOnAlertTypeOption();
			reportsPage.selectAddScheduleReportMonthlyPeriod();
			Assert.assertTrue(reportsPage.isMonthDayDrpDwnPresent());
			reportsPage.clickOnSaveButton();
			Assert.assertTrue(reportsPage.isAntNotificationMessagePresent());
			
		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable To Verify the Save button functionality of 'Add Schedule Report' Popup if fill-up all fields with Events Report, Monthly period"
					+ UtilityMethods.getStackTrace());
			Assert.fail(
					"Unable To Verify the Save button functionality of 'Add Schedule Report' Popup if fill-up all fields with Events Report, Monthly period");
		}
	}
	
	@Test(priority = 16, description = "TC_ScheduleReport_084 Verify the 'Cancel' functionality on 'Add Schedule Report'")
	public void Verify_the_Cancel_functionality_on_Add_Schedule_Report() {

		try {
			log.info("************************* TC-084*************************");
			extentTest.setDescription("TC_Reports_Events Reports_084 Verify the 'Cancel' functionality on 'Add Schedule Report'");
			reportsPage = new ReportsPage(getDriver());
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarScheduleReport();
			reportsPage.clickOnAddScheduleReportButton();
			Assert.assertTrue(reportsPage.isAddScheduleReportPopupPresent());
			
			//Click on Add Schedule Report cancel button
			reportsPage.clickOnCancelButtonEmailOnDemands();					

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable To verify the 'Cancel' functionality in email on demand popup" + UtilityMethods.getStackTrace());
			Assert.fail("Unable To verify the 'Cancel' functionality in email on demand popup");
		}
	}
	
	@Test(priority = 17, description = "TC_Reports_Speeding Report_085 Verify the 'cross' (×) button functionality on 'Add Schedule Report'")
	public void Verify_the_cross_button_functionality_on_Add_Schedule_Report() {

		try {
			log.info("************************* TC-085*************************");
			extentTest.setDescription("TC_Reports_Speeding Report_085 Verify the 'cross' (×) button functionality on 'Add Schedule Report'");
			reportsPage = new ReportsPage(getDriver());
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarScheduleReport();
			reportsPage.clickOnAddScheduleReportButton();
			Assert.assertTrue(reportsPage.isAddScheduleReportPopupPresent());
			
			//click on Add Schedule Report 'X' Cross button 
			reportsPage.clickOnCrossButtonEmailOnDemands();		

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable To Verify the 'cross' (×) button functionality on 'Add Schedule Report'" + UtilityMethods.getStackTrace());
			Assert.fail("Unable To Verify the 'cross' (×) button functionality on 'Add Schedule Report'");
		}
	}
	
	@Test(priority = 18,  description = "TC_ScheduleReport_086 Verify the search functionality ")
	public void Verify_the_search_functionality() {

		try {
			log.info("************************* TC-86*************************");
			extentTest.setDescription("TC_ScheduleReport_086 To verify the search functionality ");
			reportsPage = new ReportsPage(getDriver());
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarScheduleReport();
			reportsPage.searchReport("MB02-Teltonika");
			Assert.assertFalse(reportsPage.isReportLogsPresent());

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable To verify the search functionality" + UtilityMethods.getStackTrace());
			Assert.fail("Unable To verify the search functionality");
		}
	}

	@Test(priority = 19, enabled = false, description = "TC_ScheduleReport_087 To verify the pagination functionality")
	public void Verify_the_pagination_functionality() {

		try {
			log.info("************************* TC-87************************");
			extentTest.setDescription("TC_ScheduleReport_086 To Verify the pagination functionality");
			reportsPage = new ReportsPage(getDriver());
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarScheduleReport();
			reportsPage.checkPagination();

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable To Verify the pagination functionality" + UtilityMethods.getStackTrace());
			Assert.fail("Unable To verify the pagination functionality");
		}
	}

}
