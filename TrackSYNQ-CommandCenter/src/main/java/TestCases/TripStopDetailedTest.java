package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import Common.BaseSetup;
import Common.UtilityMethods;
import PageObjects.DashboardPage;
import PageObjects.LoginPage;
import PageObjects.ReportsPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
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

	@Test(priority = 1, description = "TC_Reports_Trip Stop Detailed_002 Stop Detailed_002 To verify the 'UI' of 'Trip Stop Detailed' page")
	public void Verify_the_UI_of_Trip_Stop_Detailed_page() {

		try {
			log.info("************************* TC-002*************************");
			extentTest.setDescription("TC_Reports_Trip Stop Detailed_002 Stop Detailed_002 Verify the 'UI' of 'Trip Stop Detailed' page");
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
			reportsPage.clickOnReportLogsDropDown();
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
			Thread.sleep(SHORTWAIT);
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
			Thread.sleep(SHORTWAIT);
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
			Thread.sleep(SHORTWAIT);
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
			extentTest.setDescription("TC_Reports_Trip Stop Detailed_009 To verify the 'Trip Stop Detailed' using 'Daily (Period) functionality");
			reportsPage = new ReportsPage(getDriver());
			loginPage = new LoginPage(getDriver());
			loginPage.enterEmailAddess(config.getProperty("superAdminEmail"));
			loginPage.enterPassword(config.getProperty("superAdminPassword"));
			loginPage.clickOnLogInButton();
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarTripStopDetailed();
			reportsPage.clickOnReportLogsDropDown();
			reportsPage.selectObject();
			reportsPage.clickOnPeriodDropdowAndPeriodDropdownDaily();
			Assert.assertTrue(reportsPage.isAntNotificationMessagePresent());

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable To verify the 'Trip Stop Detailed' using 'Daily (Period) functionality " + UtilityMethods.getStackTrace());
			Assert.fail("Unable To verify the 'Trip Stop Detailed' using 'Daily (Period) functionality ");
		}
	}
	
	@Test(priority = 9, description = "TC_Reports_Trip Stop Detailed_010 To verify the 'Trip Stop Detailed' using 'Weekly' (Period) functionality")
	public void Verify_the_Trip_Stop_Detailed_using_WeeklyPeriod_functionality() {

		try {
			log.info("************************* TC-010*************************");
			extentTest.setDescription("TC_Reports_Trip Stop Detailed_010 To verify the 'Trip Stop Detailed' using 'Weekly' (Period) functionality");
			reportsPage = new ReportsPage(getDriver());
			loginPage = new LoginPage(getDriver());
			loginPage.enterEmailAddess(config.getProperty("superAdminEmail"));
			loginPage.enterPassword(config.getProperty("superAdminPassword"));
			loginPage.clickOnLogInButton();
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarTripStopDetailed();
			reportsPage.clickOnReportLogsDropDown();
			reportsPage.selectObject();
			reportsPage.clickOnPeriodDropdowAndPeriodDropdownWeekly();
			Assert.assertTrue(reportsPage.isReportHeadinglistData());

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable To verify the 'Trip Stop Detailed' using 'Weekly' (Period) functionality " + UtilityMethods.getStackTrace());
			Assert.fail("Unable To verify the 'Trip Stop Detailed' using 'Weekly' (Period) functionality  ");
		}
	}
	
	@Test(priority =10, description = "TC_Reports_Trip Stop Detailed_011 To Verify the 'Trip Stop Detailed' using 'Monthly' (Period) functionality ")
	public void Verify_the_Trip_Stop_Detailed_using_Monthly_Period_functionality () {

		try {
			log.info("************************* TC-010*************************");
			extentTest.setDescription("TC_Reports_Trip Stop Detailed_011 To verify the 'Trip Stop Detailed' using 'Monthly' (Period) functionality ");
			reportsPage = new ReportsPage(getDriver());
			loginPage = new LoginPage(getDriver());
			loginPage.enterEmailAddess(config.getProperty("superAdminEmail"));
			loginPage.enterPassword(config.getProperty("superAdminPassword"));
			loginPage.clickOnLogInButton();
			reportsPage.clickOnReportsSidebar();
			reportsPage.clickOnReportsSidebarTripStopDetailed();
			reportsPage.clickOnReportLogsDropDown();
			reportsPage.selectObject();
			reportsPage.clickOnPeriodDropdowAndPeriodDropdownMonthly();
			Assert.assertTrue(reportsPage.isReportHeadinglistData());

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable To verify the 'Trip Stop Detailed' using 'Monthly' (Period) functionality " + UtilityMethods.getStackTrace());
			Assert.fail("Unable To verify the 'Trip Stop Detailed' using 'Monthly' (Period) functionality ");
		}
	}

}
