package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import Common.BaseSetup;
import Common.UtilityMethods;
import PageObjects.LoginPage;
import PageObjects.ReportsPage;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class EventsReportTest extends BaseSetup {
	LoginPage loginPage;

	ReportsPage reportsPage;

	static Logger log = Logger.getLogger(EventsReportTest.class);

	@Test(priority = 0, description = "TC_Reports_Events Reports_047 Verify the Events Reports' Side bar link functionality")
	public void Verify_the_Events_Reports_Side_bar_link_functionality() {

		try {
			log.info("************************* TC-047*************************");
			extentTest.setDescription("TC_Reports_Events Reports_047 Verify the 'Events Report' Navigation bar link functionality ");
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
			reportsPage.clickOnReportsSidebarEventsReport();
			String pageUrl = loginPage.getCurrentWebpageURL();
			if (pageUrl.contains("events_report")) {
				Assert.assertEquals(1, 1);
			} else {
				Assert.assertEquals(1, 0);
			}

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to Verify the Events Reports' Side bar link functionality"
					+ UtilityMethods.getStackTrace());
			Assert.fail("Unable to Verify the Events Reports' Side bar link functionality");
		}

	}
	
	@Test(priority = 1, description = "TC_Reports_Events Reports_048 Verify the 'UI' of 'Events Reports' ")
	public void Verify_the_UI_of_Events_Reports() {

		try {
			log.info("************************* TC-048*************************");
			extentTest.setDescription("TC_Reports_Events Reports_048 Verify the 'UI' of 'Speeding Report' ");
			reportsPage = new ReportsPage(getDriver());
//			loginPage = new LoginPage(getDriver());
//			loginPage.enterEmailAddess(config.getProperty("superAdminEmail"));
//			loginPage.enterPassword(config.getProperty("superAdminPassword"));
//			loginPage.clickOnLogInButton();
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarEventsReport();
			Assert.assertTrue(reportsPage.isReportHomeLinkPresent());
			Assert.assertTrue(reportsPage.isReportsLinkPresent());
			Assert.assertTrue(reportsPage.isEventsReportLinkPresent());
			Assert.assertEquals(reportsPage.getCssValueReportsLogsTitle(), "rgba(2, 192, 245, 1)");
			Assert.assertTrue(reportsPage.isObjectLabelPresent());
			Assert.assertTrue(reportsPage.isAlertsTypeLabelPresent());
			Assert.assertTrue(reportsPage.isPeriodLabelPresent());
			Assert.assertTrue(reportsPage.isResetButtonPresent());
			Assert.assertTrue(reportsPage.isSearchButtonPresent());
			Assert.assertTrue(reportsPage.isEmailOnDemandsPresent());
			Assert.assertTrue(reportsPage.isPDFPresent());
			Assert.assertTrue(reportsPage.isCSVPresent());
			Assert.assertTrue(reportsPage.isHTMLPresent());

			// Select the object from drop-down
			reportsPage.selectObject();

			// verify the period from drop-down
			reportsPage.clickOnPeriodDropdown();
			Assert.assertTrue(reportsPage.isPeriodDropdownSelectPresent());
			Assert.assertTrue(reportsPage.isPeriodDropdownDailyPresent());
			Assert.assertTrue(reportsPage.isPeriodDropdownWeeklyPresent());
			Assert.assertTrue(reportsPage.isPeriodDropdownMonthlyPresent());
			Assert.assertTrue(reportsPage.isPeriodDropdownCustomPresent());

			for (int i = 1; i <= 7; i++) {
				Assert.assertTrue(reportsPage.isReportHeadingColumnPresent(i));
			}

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to Verify the 'UI' of 'Events Reports' " + UtilityMethods.getStackTrace());
			Assert.fail("Unable to Verify the 'UI' of 'Events Reports' ");
		}
	}

	@Test(priority = 2, description = "TC_Reports_Events Reports_049 Verify the 'Placeholder' in all field on 'Events Report' page")
	public void Verify_the_Placeholder_in_all_field_on_Events_Report_page() {
	

		try {
			log.info("************************* TC-049*************************");
			extentTest.setDescription(
					"TC_Reports_Events Reports_049 Verify the 'Placeholder' in all field on 'Events Report' page");
			reportsPage = new ReportsPage(getDriver());
//			loginPage = new LoginPage(getDriver());
//			loginPage.enterEmailAddess(config.getProperty("superAdminEmail"));
//			loginPage.enterPassword(config.getProperty("superAdminPassword"));
//			loginPage.clickOnLogInButton();
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarEventsReport();
			
			// Verify the Speed placeholder text
			String expectedSelectObjectText = "Select Vehicle";
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
			logError("Unable To Verify the 'Placeholder' in all field on 'Events Report' page"
					+ UtilityMethods.getStackTrace());
			Assert.fail("Unable To Verify the 'Placeholder' in all field on 'Events Report' page");
		}
	}

	@Test(priority = 3, description = "TC_Reports_Events Reports_050 Verify the validation message in all field on 'Events Report' page")
	public void Verify_the_validation_message_in_all_field_on_Speed_Report_page() {

		try {
			log.info("************************* TC-050*************************");
			extentTest.setDescription(
					"TC_Reports_Events Reports_050 Verify the validation message in all field on 'Events Report' page");
			reportsPage = new ReportsPage(getDriver());
//			loginPage = new LoginPage(getDriver());
//			loginPage.enterEmailAddess(config.getProperty("superAdminEmail"));
//			loginPage.enterPassword(config.getProperty("superAdminPassword"));
//			loginPage.clickOnLogInButton();
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarEventsReport();
			reportsPage.clickOnSearchButton();

			// Verify the object validation
			String expectedSelectObjectValidation = "Please Select Vehicle";
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
			logError("Unable To Verify the validation message in all field on 'Events Report' page"
					+ UtilityMethods.getStackTrace());
			Assert.fail("Unable To Verify the validation message in all field on 'Events Report' page");
		}
	}

	@Test(priority = 4, description = "TC_Reports_Events Reports_051 Verify the Email on Demand tooltip")
	public void Verify_the_Email_on_Demand_tooltip() {

		try {
			log.info("************************* TC-051*************************");
			extentTest.setDescription("TC_Reports_Speeding Report_051 Verify the Email on Demand tooltip");
			reportsPage = new ReportsPage(getDriver());
//			loginPage = new LoginPage(getDriver());
//			loginPage.enterEmailAddess(config.getProperty("superAdminEmail"));
//			loginPage.enterPassword(config.getProperty("superAdminPassword"));
//			loginPage.clickOnLogInButton();
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarEventsReport();

			// Verify the email on demand tooltip
			String expectedTooltip = "Email On Demand";
			WebElement emailOnDemand = driver.findElement(By.xpath("//div[@class='ant-card-head']//button[1]"));
			Actions actions = new Actions(driver);
			actions.moveToElement(emailOnDemand).perform();

			WebElement toolTipElement = driver.findElement(By.cssSelector("div[role='tooltip']"));
			Thread.sleep(2000);
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

	@Test(priority = 5, description = "TC_Reports_Events Reports_052 Verify the PDF tooltip")
	public void Verify_the_PDF_tooltip() {

		try {
			log.info("************************* TC-052*************************");
			extentTest.setDescription("TC_Reports_Events Reports_052 Verify the PDF tooltip");
			reportsPage = new ReportsPage(getDriver());
//			loginPage = new LoginPage(getDriver());
//			loginPage.enterEmailAddess(config.getProperty("superAdminEmail"));
//			loginPage.enterPassword(config.getProperty("superAdminPassword"));
//			loginPage.clickOnLogInButton();
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarEventsReport();

			// Verify the PDF tooltip
			String expectedTooltip = "Export PDF";
			WebElement PDF = driver
					.findElement(By.xpath("//div//div[@class='ant-card-head-wrapper']//div[2]//button[2]"));
			Actions actions = new Actions(driver);
			actions.moveToElement(PDF).perform();
			WebElement toolTipElement = driver.findElement(By.cssSelector("div[role='tooltip']"));
			Thread.sleep(2000);
			String actualTooltip = toolTipElement.getText();
			System.out.println("Actual Title of Tool Tip +++++++++" + actualTooltip);
			Assert.assertEquals(actualTooltip, expectedTooltip);
			Assert.assertTrue(reportsPage.isReportHomeLinkPresent());

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable To Verify the PDF tooltip" + UtilityMethods.getStackTrace());
			Assert.fail("Unable To Verify the PDF tooltip");
		}
	}

	@Test(priority = 6, description = "TC_Reports_Events Reports_053 Verify the CSV tooltip")
	public void Verify_the_CSV_tooltip() {

		try {
			log.info("************************* TC-053*************************");
			extentTest.setDescription("TC_Reports_Events Reports_053 Verify the CSV tooltip");
			reportsPage = new ReportsPage(getDriver());
//			loginPage = new LoginPage(getDriver());
//			loginPage.enterEmailAddess(config.getProperty("superAdminEmail"));
//			loginPage.enterPassword(config.getProperty("superAdminPassword"));
//			loginPage.clickOnLogInButton();
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarEventsReport();

			// Verify the CSV tooltip
			String expectedTooltip = "Export CSV";
			WebElement CSV = driver
					.findElement(By.xpath("//div//div[@class='ant-card-head-wrapper']//div[2]//button[3]"));
			Actions actions = new Actions(driver);
			actions.moveToElement(CSV).perform();
			WebElement toolTipElement = driver.findElement(By.cssSelector("div[role='tooltip']"));
			Thread.sleep(2000);
			String actualTooltip = toolTipElement.getText();
			System.out.println("Actual Title of Tool Tip +++++++++" + actualTooltip);
			Assert.assertEquals(actualTooltip, expectedTooltip);
			Assert.assertTrue(reportsPage.isReportHomeLinkPresent());

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable To Verify the CSV tooltip" + UtilityMethods.getStackTrace());
			Assert.fail("Unable To Verify the CSV tooltip");
		}
	}

	@Test(priority = 7, description = "TC_Reports_Events Reports_054 Verify the HTML tooltip")
	public void Verify_the_HTML_tooltip() {

		try {
			log.info("************************* TC-054*************************");
			extentTest.setDescription("TC_Reports_Events Reports_054 Verify the HTML tooltip");
			reportsPage = new ReportsPage(getDriver());
//			loginPage = new LoginPage(getDriver());
//			loginPage.enterEmailAddess(config.getProperty("superAdminEmail"));
//			loginPage.enterPassword(config.getProperty("superAdminPassword"));
//			loginPage.clickOnLogInButton();
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarEventsReport();

			// Verify the HTML tooltip
			String expectedTooltip = "Export HTML";
			WebElement HTML = driver
					.findElement(By.xpath("//div//div[@class='ant-card-head-wrapper']//div[2]//button[4]"));
			Actions actions = new Actions(driver);
			actions.moveToElement(HTML).perform();

			WebElement toolTipElement = driver.findElement(By.cssSelector("div[role='tooltip']"));
			Thread.sleep(2000);
			String actualTooltip = toolTipElement.getText();
			System.out.println("Actual Title of Tool Tip +++++++++" + actualTooltip);
			Assert.assertEquals(actualTooltip, expectedTooltip);
			Assert.assertTrue(reportsPage.isReportHomeLinkPresent());

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable To Verify the HTML tooltip" + UtilityMethods.getStackTrace());
			Assert.fail("Unable To Verify the HTML tooltip");
		}
	}

	@Test(priority = 8, description = "TC_Reports_Events Reports_055 Verify the without select any option and click on 'Email on demand', 'PDF','CSV', and 'HTML' button")
	public void Verify_the_without_select_any_option_and_click_on_Email_on_demand_PDF_CSV_and_HTML_button() {

		try {
			log.info("************************* TC-055*************************");
			extentTest.setDescription(
					"TC_Reports_Events Reports_055 To verify the without select any option and click on 'Email on demand', 'PDF','CSV', and 'HTML' button");
			reportsPage = new ReportsPage(getDriver());
//			loginPage = new LoginPage(getDriver());
//			loginPage.enterEmailAddess(config.getProperty("superAdminEmail"));
//			loginPage.enterPassword(config.getProperty("superAdminPassword"));
//			loginPage.clickOnLogInButton();
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarEventsReport();
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

	@Test(priority = 8, description = "TC_Reports_Events Reports_057 Verify the 'Events Report' with 'Daily'  period functionality  ")
	public void Verify_the_Events_Report_with_Daily_period_functionality() {

		try {
			log.info("************************* TC-057*************************");
			extentTest.setDescription(
					"TC_Reports_Events Reports_057 Verify the 'Events Report' with 'Daily'  period functionality ");
			reportsPage = new ReportsPage(getDriver());
//			loginPage = new LoginPage(getDriver());
//			loginPage.enterEmailAddess(config.getProperty("superAdminEmail"));
//			loginPage.enterPassword(config.getProperty("superAdminPassword"));
//			loginPage.clickOnLogInButton();
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarEventsReport();
			reportsPage.selectObject();
			reportsPage.clickOnPeriodDropdowAndPeriodDropdownDaily();
			Assert.assertTrue(reportsPage.isReportHeadinglistData());

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable To Verify the 'Events Report' with 'Daily'  period functionality "
					+ UtilityMethods.getStackTrace());
			Assert.fail("Unable To Verify the 'Events Report' with 'Daily'  period functionality ");
		}
	}

	@Test(priority = 9, description = "TC_Reports_Events Reports_058 Verify the 'Events Report' with  'Weekly'  period functionality ")
	public void Verify_the_Events_Report_With_Weekly_Period_functionality() {

		try {
			log.info("************************* TC-058*************************");
			extentTest.setDescription(
					"TC_Reports_Events Reports_058 Verify the 'Events Report' with  'Weekly'  period functionality ");
			reportsPage = new ReportsPage(getDriver());
//			loginPage = new LoginPage(getDriver());
//			loginPage.enterEmailAddess(config.getProperty("superAdminEmail"));
//			loginPage.enterPassword(config.getProperty("superAdminPassword"));
//			loginPage.clickOnLogInButton();
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarEventsReport();
			reportsPage.selectObject();
			reportsPage.clickOnPeriodDropdowAndPeriodDropdownWeekly();
			Assert.assertTrue(reportsPage.isReportHeadinglistData());

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable To Verify the 'Events Report' with  'Weekly' period functionality "
					+ UtilityMethods.getStackTrace());
			Assert.fail("Unable To Verify the 'Events Report' with 'Weekly' period functionality ");
		}
	}

	@Test(priority = 10, description = "TC_Reports_Events Reports_059 Verify the 'Events Report' with  'Monthly' period functionality  ")
	public void Verify_the_Events_Report_with_Monthly_Period_functionality() {

		try {
			log.info("************************* TC-059*************************");
			extentTest.setDescription(
					"TC_Reports_Events Reports_059 To Verify the 'Events Report' with  'Monthly' period functionality ");
			reportsPage = new ReportsPage(getDriver());
//			loginPage = new LoginPage(getDriver());
//			loginPage.enterEmailAddess(config.getProperty("superAdminEmail"));
//			loginPage.enterPassword(config.getProperty("superAdminPassword"));
//			loginPage.clickOnLogInButton();
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarEventsReport();
			reportsPage.selectObject();
			reportsPage.clickOnPeriodDropdowAndPeriodDropdownMonthly();

			Assert.assertTrue(reportsPage.isReportHeadinglistData());

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable To Verify the 'Events Report' with  'Monthly'  period functionality  "
					+ UtilityMethods.getStackTrace());
			Assert.fail("Unable To Verify the 'Events Report' with  'Monthly'  period functionality ");
		}
	}

	@Test(priority = 11, description = "TC_Reports_Events Reports_060 Verify the 'Events Report' with 'Custom' (Period) functionality check the presence of start date and end date")
	public void A_Verify_the_Events_Report_with_Custom_Period_functionality_check_the_presence_of_start_date_and_end_date() {

		try {
			log.info("************************* TC-060*************************");
			extentTest.setDescription(
					"TC_Reports_Events Reports_060 To verify the 'Events report' using 'Custom' (Period) functionality check the presence of start date and end date");
			reportsPage = new ReportsPage(getDriver());
//			loginPage = new LoginPage(getDriver());
//			loginPage.enterEmailAddess(config.getProperty("superAdminEmail"));
//			loginPage.enterPassword(config.getProperty("superAdminPassword"));
//			loginPage.clickOnLogInButton();
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarEventsReport();
			reportsPage.selectObject();
			reportsPage.clickOnPeriodDropdown();
			reportsPage.ClickOnPeriodDropdownCustom();
			Assert.assertTrue(reportsPage.isEndDatePresentOnCustom());
			Assert.assertTrue(reportsPage.isStartDatePresentOnCustom());

		} catch (Exception e) {
			e.printStackTrace();
			logError(
					"Unable To Verify the 'Events Report' With Custom Period functionality check the presence of start date and end date"
							+ UtilityMethods.getStackTrace());
			Assert.fail(
					"Unable To Verify the 'Events Report' With Custom Period functionality check the presence of start date and end date");
		}
	}

	@Test(priority = 12, description = "TC_Reports_Events Report_061 Verify the 'Events Reports' using 'Custom' period functionality ")
	public void B_Verify_the_Events_Report_using_Custom_Period_functionality() {

		try {
			log.info("************************* TC-061*************************");
			extentTest.setDescription(
					"TC_Reports_Events Report_061 To Verify the 'Events Reports' using  'Custom' period functionality ");
			reportsPage = new ReportsPage(getDriver());
//			loginPage = new LoginPage(getDriver());
//			loginPage.enterEmailAddess(config.getProperty("superAdminEmail"));
//			loginPage.enterPassword(config.getProperty("superAdminPassword"));
//			loginPage.clickOnLogInButton();
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarEventsReport();
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
			logError("Unable To Verify the 'Speeding Reports' using  'Custom' period functionality"
					+ UtilityMethods.getStackTrace());
			Assert.fail("Unable To Verify the 'Speeding Reports' using  'Custom' period functionality ");
		}
	}

	
	@Test(priority = 13, description = "TC_Reports_Events Reports_062 Verify the 'Reset' button functionality")
	public void Verify_the_Reset_button_functionality() {

		try {
			log.info("************************* TC-062*************************");
			extentTest.setDescription("TC_Reports_Events Reports_062 Verify the 'Reset' button functionality");
			reportsPage = new ReportsPage(getDriver());
//			loginPage = new LoginPage(getDriver());
//			loginPage.enterEmailAddess(config.getProperty("superAdminEmail"));
//			loginPage.enterPassword(config.getProperty("superAdminPassword"));
//			loginPage.clickOnLogInButton();
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarEventsReport();
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
			logError("Unable To Verify the 'Reset' button functionality" + UtilityMethods.getStackTrace());
			Assert.fail("Unable To Verify the 'Reset' button functionality");
		}
	}

	@Test(priority = 15, description = "TC_Reports_Events Reports_064 Verify the 'Email on demand' Popup UI")
	public void Verify_the_Email_on_demand_Popup_UI() {

		try {
			log.info("************************* TC-064*************************");
			extentTest.setDescription("TC_Reports_Events Reports_064 Verify the 'Email on demand' Popup UI");
			reportsPage = new ReportsPage(getDriver());
//			loginPage = new LoginPage(getDriver());
//			loginPage.enterEmailAddess(config.getProperty("superAdminEmail"));
//			loginPage.enterPassword(config.getProperty("superAdminPassword"));
//			loginPage.clickOnLogInButton();
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarEventsReport();
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

	@Test(priority = 16, description = "TC_Reports_Events Reports_065 Verify 'Send Report' button functionality on 'Email on Demand download' Popup if Fill-up email field")
	public void Verify_Send_Report_button_functionality_on_Email_on_Demand_download_Popup_if_entered_email() {

		try {
			log.info("************************* TC-065*************************");
			extentTest.setDescription(
					"TC_Reports_Events Reports_065 Verify 'Send Report' button functionality on 'Email on Demand download' Popup if Fill-up email field");
			reportsPage = new ReportsPage(getDriver());
			// Open Yopmail window
			((JavascriptExecutor) driver).executeScript("window.open()");
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));
			driver.get("http://www.yopmail.com/en/");
			driver.switchTo().window(tabs.get(0));
//			loginPage = new LoginPage(getDriver());
//			loginPage.enterEmailAddess(config.getProperty("superAdminEmail"));
//			loginPage.enterPassword(config.getProperty("superAdminPassword"));
//			loginPage.clickOnLogInButton();
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarEventsReport();
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
			// reportsPage.clickOnDeleteEmailOnYopmail();
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
	
	@Test(priority = 17, description = "TC_Reports_Events Reports_066 Verify the 'Cancel' functionality in email on demand popup")
	public void Verify_the_Cancel_functionality_in_email_on_demand_popup() {

		try {
			log.info("************************* TC-066*************************");
			extentTest.setDescription("TC_Reports_Events Reports_066 To Verify the 'Cancel' functionality in email on demand popup");
			reportsPage = new ReportsPage(getDriver());
//			loginPage = new LoginPage(getDriver());
//			loginPage.enterEmailAddess(config.getProperty("superAdminEmail"));
//			loginPage.enterPassword(config.getProperty("superAdminPassword"));
//			loginPage.clickOnLogInButton();
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarEventsReport();
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
	
	@Test(priority = 18, description = "TC_Reports_Events Reports_067 Verify the 'cross' (×) button functionality in_email_on_demand_popup")
	public void Verify_the_cross_X_button_functionality_in_email_on_demand_popup() {

		try {
			log.info("************************* TC-067*************************");
			extentTest.setDescription("TC_Reports_Events Reports_067 To verify the 'cross' (×) button functionality in_email_on_demand_popup");
			reportsPage = new ReportsPage(getDriver());
//			loginPage = new LoginPage(getDriver());
//			loginPage.enterEmailAddess(config.getProperty("superAdminEmail"));
//			loginPage.enterPassword(config.getProperty("superAdminPassword"));
//			loginPage.clickOnLogInButton();
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarEventsReport();
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
	
	@Test(priority = 19, description = "TC_Reports_Events Reports_068 Verify the 'PDF' functionality in 'Events Report' page")
	public void Verify_the_PDF_functionality_in_Events_Report_page() {

		try {
			log.info("************************* TC-068*************************");
			extentTest.setDescription("TC_Reports_Events Reports_068 Verify the 'PDF' functionality in 'Events Report' page");
			reportsPage = new ReportsPage(getDriver());
//            loginPage = new LoginPage(getDriver());
//			loginPage.enterEmailAddess(config.getProperty("superAdminEmail"));
//			loginPage.enterPassword(config.getProperty("superAdminPassword"));
//			loginPage.clickOnLogInButton();
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarEventsReport();
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
			logError("Unable to Verify the 'PDF' functionality in 'Events Report' page" + UtilityMethods.getStackTrace());
			Assert.fail("Unable to Verify the 'PDF' functionality in 'Events Report' page");
		}
	}

	@Test(priority = 20, description = "TC_Reports_Events Reports_069 Verify the 'CSV' functionality in 'Events Report' page")
	public void Verify_CSV_download_functionality() {

		try {
			log.info("************************* TC-069*************************");
			extentTest.setDescription("TC_Reports_Events Reports_069 Verify the 'CSV' functionality in 'Events Report' page");
			reportsPage = new ReportsPage(getDriver());
//			loginPage = new LoginPage(getDriver());
//			loginPage.enterEmailAddess(config.getProperty("superAdminEmail"));
//			loginPage.enterPassword(config.getProperty("superAdminPassword"));
//			loginPage.clickOnLogInButton();
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarEventsReport();
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
			logError("Unable To Verify the 'CSV' functionality in 'Events Report' page" + UtilityMethods.getStackTrace());
			Assert.fail("Unable To Verify the 'CSV' functionality in 'Events Report' page");
		}
	}

	@Test(priority = 21, description = "TC_Reports_Events Reports_070 Verify the 'HTML' functionality in 'Events Report' page")
	public void Verify_HTML_download_functionality() {

		try {
			log.info("************************* TC-070*************************");
			extentTest.setDescription("TC_Reports_Events Reports_070 Verify the 'HTML' functionality in 'Events Report' page");
			reportsPage = new ReportsPage(getDriver());
//			loginPage = new LoginPage(getDriver());
//			loginPage.enterEmailAddess(config.getProperty("superAdminEmail"));
//			loginPage.enterPassword(config.getProperty("superAdminPassword"));
//			loginPage.clickOnLogInButton();
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarEventsReport();
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
//			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
//			driver.switchTo().window(tabs.get(1));
//			driver.close();
			

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable To Verify the 'HTML' functionality in 'Events Report' page" + UtilityMethods.getStackTrace());
			Assert.fail("Unable To Verify the 'HTML' functionality in 'Events Report' page");
		}
	}
	
	
}
