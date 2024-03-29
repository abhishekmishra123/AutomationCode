package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
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

public class ReportLogsTest extends BaseSetup {
	LoginPage loginPage;
	DashboardPage dashboardPage;
	ReportsPage reportsPage;

	static Logger log = Logger.getLogger(ReportLogsTest.class);

	@Test(priority = 0, description = "TC_ReportLogs_092 verify the 'Report Logs' Side bar link functionality")
	public void Verify_the_Report_Logs_Side_bar_link_functionality() {

		try {
			log.info("************************* TC-095*************************");
			extentTest
					.setDescription("TC_ReportLogs_095 verify the 'Report Logs' Side bar link functionality");
			loginPage = new LoginPage(getDriver());
			dashboardPage = new DashboardPage(getDriver());
			reportsPage = new ReportsPage(getDriver());
			loginPage.enterEmailAddess(config.getProperty("siteAdminEmailData"));
			loginPage.enterPassword(config.getProperty("siteAdminPasswordData"));
			loginPage.clickOnLogInButton();
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarReportsLog();
			String pageUrl = loginPage.getCurrentWebpageURL();
			if (pageUrl.contains("report_logs")) {
				Assert.assertEquals(1, 1);
			} else {
				Assert.assertEquals(1, 0);
			}

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to verify the  'Report Logs' Side bar link  functionality "
					+ UtilityMethods.getStackTrace());
			Assert.fail("Unable to verify the  'Report Logs' Side bar link  functionality ");
		}
	}

	@Test(priority = 1, description = "TC_ReportLogs_093 verify the UI of 'Report Logs")
	public void Verify_the_UI_of_Report_Logs() {

		try {
			log.info("************************* TC-093*************************");
			extentTest.setDescription("To verify the UI of  'Report Logs' ");
			reportsPage = new ReportsPage(getDriver());
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarReportsLog();
			Assert.assertTrue(reportsPage.isReportHomeLinkPresent());
			Assert.assertTrue(reportsPage.isReportsLinkPresent());
			Assert.assertTrue(reportsPage.isReportsLogsLinkPresent());
			Assert.assertEquals(reportsPage.getCssValueReportsLogsTitle(), "rgba(2, 192, 245, 1)");
			Assert.assertTrue(reportsPage.isEmailOnDemandsPresent());
			Assert.assertTrue(reportsPage.isPDFPresent(2));
			Assert.assertTrue(reportsPage.isPDFPresent(3));
			Assert.assertTrue(reportsPage.isPDFPresent(4));

			for (int i = 1; i <= 8; i++) {
				if(i==4) {
					continue;
				}
				Assert.assertTrue(reportsPage.isReportHeadingColumnPresent(i));
			}
			reportsPage.clickOnReportLogsDropDown();
			String str = reportsPage.getReportLogsValueDropdown();
			String objectNameHeading = reportsPage.getReportLogsHeadingText();
			Assert.assertEquals(str, objectNameHeading);
			Assert.assertTrue(reportsPage.isSearchFieldPresent());
			Assert.assertTrue(reportsPage.isPaginationPresent());
		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to verify the UI of 'Report Logs'" + UtilityMethods.getStackTrace());
			Assert.fail("Unable to verify the UI of 'Report Logs'");
		}
	}

	@Test(priority = 2, description = "TC_ReportLogs_094 To verify 'Email On demands download' UI")
	public void Verify_Email_On_demands_download_UI() {

		try {
			log.info("************************* TC-094*************************");
			extentTest.setDescription("TC_ReportLogs_094 To verify 'Email On demands download' UI");
			dashboardPage = new DashboardPage(getDriver());
			reportsPage = new ReportsPage(getDriver());
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarReportsLog();
			Assert.assertTrue(reportsPage.isEmailOnDemandsPresent());
			reportsPage.clickOnEmailOnDemands();
			Assert.assertTrue(reportsPage.isEmailOnDemandDialogTitlePresent());
			Assert.assertTrue(reportsPage.isEmailOnDemandLabelPresent());
			Assert.assertTrue(reportsPage.isEmailOnDemandEmailFieldPresent());
			Assert.assertTrue(reportsPage.isEmailOnDemandEmailFieldPlaceholderPresent());
			Assert.assertTrue(reportsPage.isEmailOnDemandCancelBtnPresent());
			Assert.assertTrue(reportsPage.isEmailOnDemandSendRequestBtnPresent());
			Assert.assertTrue(reportsPage.isEmailOnDemandCrossBtnPresent());

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to verify 'Email On demands download' UI " + UtilityMethods.getStackTrace());
			Assert.fail("Unable to verify 'Email On demands download' UI ");
		}
	}

	@Test(priority = 3, description = "TC_ReportLogs_095 To verify 'Send Report' button functionality on 'Email On Demand download'  Popup if left empty email field")
	public void Verify_Send_Report_button_functionality_on_Email_On_Demand_download_Popup_if_left_empty_email_field() {

		try {
			log.info("************************* TC-095*************************");
			extentTest.setDescription(
					"TC_ReportLogs_095 To verify 'Send Report' button functionality on 'Email On Demand download'  Popup if left empty email field");
			dashboardPage = new DashboardPage(getDriver());
			reportsPage = new ReportsPage(getDriver());
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarReportsLog();
			Assert.assertTrue(reportsPage.isEmailOnDemandsPresent());
			reportsPage.clickOnEmailOnDemands();
			reportsPage.clickOnEmailOnDemandSendRequestBtn();
			String ErrorMesg = reportsPage.getTextEmailOnDemandEmailFieldErrorMessageg();
			Assert.assertEquals(ErrorMesg, "Please Enter Email ID");

		} catch (Exception e) {
			e.printStackTrace();
			logError(
					"Unable To verify 'Send Report' button functionality on 'Email On Demand download'  Popup if left empty email field"
							+ UtilityMethods.getStackTrace());
			Assert.fail(
					"Unable To verify 'Send Report' button functionality on 'Email On Demand download'  Popup if left empty email field");
		}
	}

	@Test(priority = 10, description = "TC_ReportLogs_096 To verify 'Send Report' button functionality on 'Email on Demand download' Popup if Fill-up email field ")
	public void Verify_Send_Report_button_functionality_on_Email_on_Demand_download_Popup_if_Fill_up_email_field() {

		try {
			log.info("************************* TC-096*************************");
			extentTest.setDescription(
					"TC_ReportLogs_096 To verify 'Send Report' button functionality on 'Email on Demand download' Popup if Fill-up email field");
			
			dashboardPage = new DashboardPage(getDriver());
			reportsPage = new ReportsPage(getDriver());

			// Open Yopmail window
			((JavascriptExecutor) driver).executeScript("window.open()");
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));
			driver.get("http://www.yopmail.com/en/");
			driver.switchTo().window(tabs.get(0));
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarReportsLog();
			reportsPage.clickOnEmailOnDemands();
			Thread.sleep(3000);
			reportsPage.enterEmailAddessOnEmailDemands("trackSynq@yopmail.com");

			// Verify email from yopmail
			driver.switchTo().window(tabs.get(1));
			yopmail();
			Assert.assertTrue(reportsPage.isEmailPresent());
			//reportsPage.clickOnDeleteEmailOnYopmail();
			driver.manage().deleteAllCookies();
			driver.close();
			driver.switchTo().window(tabs.get(0));

		} catch (Exception e) {
			e.printStackTrace();
			logError(
					"Unable to verify 'Send Report' button functionality on 'Email on Demand download'  Popup if Fill-up email field"
							+ UtilityMethods.getStackTrace());
			Assert.fail(
					"Unable to verify 'Send Report' button functionality on 'Email on Demand download'  Popup if Fill-up email field");
		}
	}

	public void yopmail() {
		driver.findElement(By.cssSelector("input.scpt")).sendKeys("trackSy@yopmail.com");
		driver.findElement(By.cssSelector("input.scpt")).sendKeys(Keys.ENTER);
		driver.switchTo().frame("ifmail");
	}

	@Test(priority = 5, description = "TC_ReportLogs_97 To verify_PDF_download")
	public void Verify_PDF_download() {

		try {
			log.info("************************* TC-97*************************");
			extentTest.setDescription("TC_ReportLogs_97 To verify_PDF_download");
			dashboardPage = new DashboardPage(getDriver());
			reportsPage = new ReportsPage(getDriver());
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarReportsLog();
			reportsPage.clickOnPDF(2);
		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to verify_PDF_download" + UtilityMethods.getStackTrace());
			Assert.fail("Unable to verify_PDF_download");
		}
	}

	@Test(priority = 6, description = "TC_ReportLogs_98 To Verify 'CSV'  download functionality ")
	public void Verify_CSV_download_functionality() {

		try {
			log.info("************************* TC-98*************************");
			extentTest.setDescription("TC_ReportLogs_98 To verify 'CSV' download functionality ");
			dashboardPage = new DashboardPage(getDriver());
			reportsPage = new ReportsPage(getDriver());
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarReportsLog();
			reportsPage.clickOnPDF(3);

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable To verify 'CSV'  download functionality " + UtilityMethods.getStackTrace());
			Assert.fail("Unable To verify 'CSV'  download functionality ");
		}
	}

	@Test(priority = 7, description = "TC_ReportLogs_99 To verify 'HTML download' functionality")
	public void Verify_HTML_download_functionality() {

		try {
			log.info("************************* TC-99*************************");
			extentTest.setDescription("TC_ReportLogs_99 To verify 'HTML download' functionality");
			dashboardPage = new DashboardPage(getDriver());
			reportsPage = new ReportsPage(getDriver());
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarReportsLog();
			reportsPage.clickOnPDF(4);
//			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
//			driver.switchTo().window(tabs.get(1));
//			driver.close();

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable To verify 'HTML download' functionality" + UtilityMethods.getStackTrace());
			Assert.fail("Unable To verify 'HTML download' functionality");
		}
	}

	@Test(priority = 8, description = "TC_ReportLogs_100 To verify the search functionality ")
	public void Verify_the_search_functionality() {

		try {
			log.info("************************* TC-100*************************");
			extentTest.setDescription("TC_ReportLogs_100 To verify the search functionality ");
			dashboardPage = new DashboardPage(getDriver());
			reportsPage = new ReportsPage(getDriver());
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarReportsLog();
			reportsPage.searchReport("MB02-Teltonika");
			Assert.assertTrue(reportsPage.isReportLogsPresent());

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable To verify the search functionality" + UtilityMethods.getStackTrace());
			Assert.fail("Unable To verify the search functionality");
		}
	}

	@Test(priority = 9, description = "TC_ReportLogs_101 To verify the pagination functionality")
	public void Verify_the_pagination_functionality() {

		try {
			log.info("************************* TC-101************************");
			extentTest.setDescription("TC_ReportLogs_101 To Verify the pagination functionality");
			dashboardPage = new DashboardPage(getDriver());
			reportsPage = new ReportsPage(getDriver());
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarReportsLog();
			reportsPage.checkPagination();

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable To Verify the pagination functionality" + UtilityMethods.getStackTrace());
			Assert.fail("Unable To verify the pagination functionality");
		}
	}

	@Test(priority = 9, enabled = false, description = "TC_ReportLogs_102 Verify the sorting functionality")
	public void Verify_the_sorting_functionality() {

		try {
			log.info("************************* TC-102*************************");
			extentTest.setDescription("TC_ReportLogs_102 Verify the sorting functionality ");
			dashboardPage = new DashboardPage(getDriver());
			reportsPage = new ReportsPage(getDriver());
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarReportsLog();
			String beforeReportTypefirstValue = reportsPage.getTextReportTypeValue();
			reportsPage.clickOnReportTypeHeading();
			String afterReportTypefirstValue = reportsPage.getTextReportTypeValue();
			Assert.assertNotEquals(beforeReportTypefirstValue, afterReportTypefirstValue);

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable To verify the sorting functionality " + UtilityMethods.getStackTrace());
			Assert.fail("Unable To Verify the sorting functionality ");
		}
	}

}
