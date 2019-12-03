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

public class HistoryPointsTest extends BaseSetup {
	LoginPage loginPage;
	ReportsPage reportsPage;

	static Logger log = Logger.getLogger(HistoryPointsTest.class);

	@Test(priority = 0, description = "TC_HistoryPoints_105 Verify the 'History Points' Side bar link")
	public void Verify_the_History_Points_Side_bar_link_functionality() {

		try {
			log.info("************************* TC-105*************************");
			extentTest.setDescription("TC_HistoryPoints_105 Verify the 'History Points' Navigation bar link");
			reportsPage = new ReportsPage(getDriver());
			loginPage = new LoginPage(getDriver());
			loginPage.enterEmailAddess(config.getProperty("siteAdminEmailData"));
			loginPage.enterPassword(config.getProperty("siteAdminPasswordData"));
			loginPage.clickOnLogInButton();
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarHistoryPoints();
			String pageUrl = loginPage.getCurrentWebpageURL();
			if (pageUrl.contains("history_point")) {
				Assert.assertEquals(1, 1);
			} else {
				Assert.assertEquals(1, 0);
			}

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to Verify the 'History Points' Side bar link " + UtilityMethods.getStackTrace());
			Assert.fail("Unable to Verify the 'History Points' Side bar link");
		}

	}

	@Test(priority = 1, description = "TC_Reports_HistoryPoints_106 Verify the 'UI' of 'History Points' page")
	public void Verify_the_UI_of_History_Points_page() {

		try {
			log.info("************************* TC-106*************************");
			extentTest.setDescription("TC_Reports_HistoryPoints_106 Verify the 'UI' of 'Events Report' ");
			reportsPage = new ReportsPage(getDriver());
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarHistoryPoints();
			Assert.assertTrue(reportsPage.isReportHomeLinkPresent());
			Assert.assertTrue(reportsPage.isReportsLinkPresent());
			Assert.assertTrue(reportsPage.isHistoryPointsLinkPresent());
			Assert.assertEquals(reportsPage.getCssValueReportsLogsTitle(), "rgba(2, 192, 245, 1)");

			// This is used for Vehicle label presence.
			Assert.assertTrue(reportsPage.isObjectLabelPresent());
			Assert.assertTrue(reportsPage.isStartDatePresentOnCustom());
			Assert.assertTrue(reportsPage.isStartTimePresent());
			Assert.assertTrue(reportsPage.isEndDatePresentOnCustom());
			Assert.assertTrue(reportsPage.isEndTimePresent());
			Assert.assertTrue(reportsPage.isResetButtonPresent());
			Assert.assertTrue(reportsPage.isSearchButtonPresent());
			Assert.assertTrue(reportsPage.isEmailOnDemandsPresent());
			Assert.assertTrue(reportsPage.isPDFPresent(2));
			Assert.assertTrue(reportsPage.isPDFPresent(3));
			Assert.assertTrue(reportsPage.isPDFPresent(4));

			for (int i = 1; i <= 7; i++) {
				Assert.assertTrue(reportsPage.isReportHeadingColumnPresent(i));
			}

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to Verify the 'UI' of 'History Point page'" + UtilityMethods.getStackTrace());
			Assert.fail("Unable to Verify the 'UI' of 'History Point' page");
		}
	}

	@Test(priority = 2, description = "TC_Reports_HistoryPoints_107 Verify the 'Placeholder' in all field on 'History Points' page")
	public void Verify_the_Placeholder_in_all_field_on_History_Report_page() {

		try {
			log.info("************************* TC-107*************************");
			extentTest.setDescription(
					"TC_Reports_HistoryPoints_107 Verify the 'Placeholder' in all field on 'History Points' page");
			reportsPage = new ReportsPage(getDriver());
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarHistoryPoints();

			// Verify the placeholder text
			Assert.assertEquals(reportsPage.getSelectObjectPlaceholder(), "Select Vehicle");
			Assert.assertEquals(reportsPage.getStartDatePlaceholder(), "Select date");
			Assert.assertEquals(reportsPage.getStarTimePlaceholder(), "Select time");
			Assert.assertEquals(reportsPage.getEndDatePlaceholder(), "Select date");
			Assert.assertEquals(reportsPage.getEndTimePlaceholder(), "Select time");

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable To Verify the 'Placeholder' in all field on 'History Points' page"
					+ UtilityMethods.getStackTrace());
			Assert.fail("Unable To Verify the 'Placeholder' in all field on 'History Points' page");
		}
	}

	@Test(priority = 3, description = "TC_Reports_HistoryPoints_108 Verify the validation message in all field on 'History Points' page")
	public void Verify_the_validation_message_in_all_field_on_History_Points_page() {

		try {
			log.info("************************* TC-108*************************");
			extentTest.setDescription(
					"TC_Reports_HistoryPoints_108 Verify the validation message in all field on 'History Points' page");
			reportsPage = new ReportsPage(getDriver());
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarHistoryPoints();
			reportsPage.clickOnSearchButton();

			// Verify the Vehicle validation
			Assert.assertEquals(reportsPage.getSelectObjectValidation(), "Please Select Vehicle");
			Assert.assertEquals(reportsPage.getStartDateValidationMessage(), "Please Select Start Date");
			Assert.assertEquals(reportsPage.getEndDateValidationMessage(), "Please Select End Date");

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable To Verify the validation message in all field on 'History Points' page"
					+ UtilityMethods.getStackTrace());
			Assert.fail("Unable To Verify the validation message in all field on 'History Points' page");
		}
	}

	@Test(priority = 4, description = "TC_Reports_HistoryPoints_109 Verify the Email on Demand tooltip")
	public void Verify_the_Email_on_Demand_tooltip() {

		try {
			log.info("************************* TC-109*************************");
			extentTest.setDescription("TC_Reports_HistoryPoints_109 Verify the Email on Demand tooltip");
			reportsPage = new ReportsPage(getDriver());
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarHistoryPoints();
			reportsPage.emailOnDemandsTooltip();
			Assert.assertTrue(reportsPage.isReportHomeLinkPresent());

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to verify_the_Email_on_Demand_tooltip" + UtilityMethods.getStackTrace());
			Assert.fail("Unable to verify_the_Email_on_Demand_tooltip");
		}
	}

	@Test(priority = 5, description = "TC_Reports_HistoryPoints_110 Verify the PDF tooltip")
	public void Verify_the_PDF_tooltip() {

		try {
			log.info("************************* TC-110*************************");
			extentTest.setDescription("TC_Reports_HistoryPoints_110 Verify the PDF tooltip");
			reportsPage = new ReportsPage(getDriver());
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarHistoryPoints();

			reportsPage.PDFTooltip();
			Assert.assertTrue(reportsPage.isReportHomeLinkPresent());

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable To Verify the PDF tooltip" + UtilityMethods.getStackTrace());
			Assert.fail("Unable To Verify the PDF tooltip");
		}
	}

	@Test(priority = 6, description = "TC_Reports_HistoryPoints_111 Verify the CSV tooltip")
	public void Verify_the_CSV_tooltip() {

		try {
			log.info("************************* TC-111*************************");
			extentTest.setDescription("TC_Reports_Events Reports_053 Verify the CSV tooltip");
			reportsPage = new ReportsPage(getDriver());
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarHistoryPoints();

			reportsPage.CSVTooltip();
			
			Assert.assertTrue(reportsPage.isReportHomeLinkPresent());

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable To Verify the CSV tooltip" + UtilityMethods.getStackTrace());
			Assert.fail("Unable To Verify the CSV tooltip");
		}
	}

	@Test(priority = 7, description = "TC_Reports_HistoryPoints_112 Verify the HTML tooltip")
	public void Verify_the_HTML_tooltip() {

		try {
			log.info("************************* TC-112*************************");
			extentTest.setDescription("TC_Reports_Events Reports_054 Verify the HTML tooltip");
			reportsPage = new ReportsPage(getDriver());
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarHistoryPoints();
			reportsPage.HTMLToolTip();
			Assert.assertTrue(reportsPage.isReportHomeLinkPresent());

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable To Verify the HTML tooltip" + UtilityMethods.getStackTrace());
			Assert.fail("Unable To Verify the HTML tooltip");
		}
	}

	@Test(priority = 8, description = "TC_Reports_HistoryPoints_113 Verify the without select any option and click on 'Email on demand', 'PDF','CSV', and 'HTML' button")
	public void Verify_the_without_select_any_option_and_click_on_Email_on_demand_PDF_CSV_and_HTML_button() {

		try {
			log.info("************************* TC-113*************************");
			extentTest.setDescription(
					"TC_Reports_HistoryPoints_113 To verify the without select any option and click on 'Email on demand', 'PDF','CSV', and 'HTML' button");
			reportsPage = new ReportsPage(getDriver());
			loginPage = new LoginPage(getDriver());
			loginPage.enterEmailAddess(config.getProperty("siteAdminEmailData"));
			loginPage.enterPassword(config.getProperty("siteAdminPasswordData"));
			loginPage.clickOnLogInButton();
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarHistoryPoints();
			reportsPage.clickOnSearchButton();

			// Verify the object validation
			reportsPage.clickOnEmailOnDemands();
			Assert.assertTrue(reportsPage.isAntNotificationMessagePresent());
			reportsPage.clickOnPDF(2);
			Assert.assertTrue(reportsPage.isAntNotificationMessagePresent());
			reportsPage.clickOnPDF(3);
			Assert.assertTrue(reportsPage.isAntNotificationMessagePresent());
			reportsPage.clickOnPDF(4);
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
	
	
	@Test(priority = 9, description = "TC_Reports_HistoryPoints_114 Verify the search button functionality and result data should be fetch")
	public void  Verify_the_search_button_functionality_and_result_data_should_be_fetch  () {

		try {
			log.info("************************* TC-114*************************");
			extentTest.setDescription(
					"TC_Reports_HistoryPoints_114 Verify the search button functionality and result data should be fetch ");
			reportsPage = new ReportsPage(getDriver());
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarHistoryPoints();
			reportsPage.selectObject();
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
			logError("Unable To Verify the search button functionality and result data should be fetch"
					+ UtilityMethods.getStackTrace());
			Assert.fail("Unable To Verify the search button functionality and result data should be fetch");
		}
	}
	
	@Test(priority = 10, description = "TC_Reports_HistoryPoints_115 Verify the 'Reset' button functionality")
	public void Verify_the_Reset_button_functionality() {

		try {
			log.info("************************* TC-115*************************");
			extentTest.setDescription("TC_Reports_HistoryPoints_115 Verify the 'Reset' button functionality");
			reportsPage = new ReportsPage(getDriver());
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarHistoryPoints();
			reportsPage.selectObject();
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

	
	@Test(priority = 11, description = "TC_Reports_HistoryPoints_116 Verify the 'Email on demand' Popup UI")
	public void Verify_the_Email_on_demand_Popup_UI() {

		try {
			log.info("************************* TC-116*************************");
			extentTest.setDescription("TC_Reports_HistoryPoints_116 Verify the 'Email on demand' Popup UI");
			reportsPage = new ReportsPage(getDriver());
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarHistoryPoints();
			reportsPage.selectObject();
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
			Assert.assertTrue(reportsPage.isEmailOnDemandEmailFieldPlaceholderPresent());
			String ErrorMesg = reportsPage.getTextEmailOnDemandEmailFieldErrorMessageg();
			Assert.assertEquals(ErrorMesg, "Please Enter Email ID");

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable To verify the 'Email on demand' Popup UI" + UtilityMethods.getStackTrace());
			Assert.fail("Unable To verify the 'Email on demand' Popup UI");
		}
	}

	@Test(priority = 12, description = "TC_Reports_HistoryPoints_117 Verify 'Send Report' button functionality on 'Email on Demand download' Popup if Fill-up email field")
	public void Verify_Send_Report_button_functionality_on_Email_on_Demand_download_Popup_if_entered_email() {

		try {
			log.info("************************* TC-117*************************");
			extentTest.setDescription(
					"TC_Reports_HistoryPoints_117 Verify 'Send Report' button functionality on 'Email on Demand download' Popup if Fill-up email field");
			reportsPage = new ReportsPage(getDriver());
			
			// Open Yopmail window
			((JavascriptExecutor) driver).executeScript("window.open()");
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));
			driver.get("http://www.yopmail.com/en/");
			driver.switchTo().window(tabs.get(0));
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarHistoryPoints();
			reportsPage.selectObject();
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
	
	
	@Test(priority = 17, description = "TC_Reports_HistoryPoints_118 Verify the 'Cancel' functionality in email on demand popup")
	public void Verify_the_Cancel_functionality_in_email_on_demand_popup() {

		try {
			log.info("************************* TC-118*************************");
			extentTest.setDescription("TC_Reports_HistoryPoints_118 To Verify the 'Cancel' functionality in email on demand popup");
			reportsPage = new ReportsPage(getDriver());
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarHistoryPoints();
			reportsPage.selectObject();
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
	
	@Test(priority = 18, description = "TC_Reports_HistoryPoints_119 Verify the 'cross' (×) button functionality in email on demand popup")
	public void Verify_the_cross_X_button_functionality_in_email_on_demand_popup() {

		try {
			log.info("************************* TC-119*************************");
			extentTest.setDescription("TC_Reports_HistoryPoints_119 To verify the 'cross' (×) button functionality in email on demand popup");
			reportsPage = new ReportsPage(getDriver());
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarHistoryPoints();
			reportsPage.selectObject();
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
			logError("Unable To verify the 'cross' (×) button functionality in email on demand popup" + UtilityMethods.getStackTrace());
			Assert.fail("Unable To verify the 'cross' (×) button functionality in email on demand popup");
		}
	}
	
	@Test(priority = 19, description = "TC_Reports_HistoryPoints_120 Verify the 'PDF' functionality in 'History Points' page")
	public void Verify_the_PDF_functionality_in_Events_Report_page() {

		try {
			log.info("************************* TC-120*************************");
			extentTest.setDescription("TC_Reports_HistoryPoints_120 Verify the 'PDF' functionality in 'History Points' page");
			reportsPage = new ReportsPage(getDriver());
			
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarHistoryPoints();
			reportsPage.selectObject();
			
			reportsPage.ClickOnStartDateCustom();
			for (int i = 1; i <= 7; i++) {
				reportsPage.ClickOnPreviousMonthOnStartDateCustom();
			}
			reportsPage.selectMarchFirstdate();
			reportsPage.ClickOnEndDateCustom();
			reportsPage.getCurrentDay1();
			reportsPage.clickOnSearchButton();
			reportsPage.clickOnPDF(2);
		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to Verify the 'PDF' functionality in 'History Points' page" + UtilityMethods.getStackTrace());
			Assert.fail("Unable to Verify the 'PDF' functionality in 'History Points' page");
		}
	}

	@Test(priority = 20, description = "TC_Reports_HistoryPoints_121 Verify the 'CSV' functionality in 'History Points' page")
	public void Verify_CSV_download_functionality() {

		try {
			log.info("************************* TC-121*************************");
			extentTest.setDescription("TC_Reports_HistoryPoints_121 Verify the 'CSV' functionality in 'History Points' page");
			reportsPage = new ReportsPage(getDriver());
			
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarHistoryPoints();
			reportsPage.selectObject();
			reportsPage.ClickOnStartDateCustom();
			for (int i = 1; i <= 7; i++) {
				reportsPage.ClickOnPreviousMonthOnStartDateCustom();
			}
			reportsPage.selectMarchFirstdate();
			reportsPage.ClickOnEndDateCustom();
			reportsPage.getCurrentDay1();
			reportsPage.clickOnSearchButton();
			reportsPage.clickOnPDF(3);

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable To Verify the 'CSV' functionality in 'History Points' page" + UtilityMethods.getStackTrace());
			Assert.fail("Unable To Verify the 'CSV' functionality in 'history points' page");
		}
	}

	@Test(priority = 21, description = "TC_Reports_HistoryPoints_122 Verify the 'HTML' functionality in 'History Points' page")
	public void Verify_HTML_download_functionality() {

		try {
			log.info("************************* TC-122*************************");
			extentTest.setDescription("TC_Reports_HistoryPoints_122 Verify the 'HTML' functionality in 'History Points' page");
			reportsPage = new ReportsPage(getDriver());
			
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarHistoryPoints();
			reportsPage.selectObject();
			reportsPage.ClickOnStartDateCustom();
			for (int i = 1; i <= 7; i++) {
				reportsPage.ClickOnPreviousMonthOnStartDateCustom();
			}
			reportsPage.selectMarchFirstdate();
			reportsPage.ClickOnEndDateCustom();
			reportsPage.getCurrentDay1();
			reportsPage.clickOnSearchButton();
			reportsPage.clickOnPDF(4);
//			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
//			driver.switchTo().window(tabs.get(1));
//			driver.close();
			

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable To Verify the 'HTML' functionality in 'History Points' page" + UtilityMethods.getStackTrace());
			Assert.fail("Unable To Verify the 'HTML' functionality in 'History Points' page");
		}
	}
	

}
