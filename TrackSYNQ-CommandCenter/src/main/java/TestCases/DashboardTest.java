package TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Common.BaseSetup;
import Common.UtilityMethods;
import PageObjects.DashboardPage;
import PageObjects.LoginPage;
import PageObjects.ManageWidgetsPage;



import org.apache.log4j.Logger;


public class DashboardTest extends BaseSetup {
	LoginPage loginPage;
	DashboardPage dashboardPage;
	ManageWidgetsPage manageWidgetsPage;

	static Logger log = Logger.getLogger(DashboardTest.class);

	@BeforeMethod
	public void Login_Set_Up() {
		loginPage = new LoginPage(getDriver());
		loginPage.enterEmailAddess(config.getProperty("superAdminEmail"));
		loginPage.enterPassword(config.getProperty("superAdminPassword"));
		loginPage.clickOnLogInButton();
	}

	@Test(priority = 0, description = "TC_Dashboard_001 To verify dashboard navigation bar link ")
	public void Verify_the_dashboard_navigation_bar_link() {

		try {
			log.info("************************* TC-001*************************");
			extentTest.setDescription("TC_Dashboard_001 To verify dashboard navigation bar link ");
			loginPage = new LoginPage(getDriver());
			dashboardPage = new DashboardPage(getDriver());
			loginPage = new LoginPage(getDriver());
			loginPage.enterEmailAddess(config.getProperty("superAdminEmail"));
			loginPage.enterPassword(config.getProperty("superAdminPassword"));
			loginPage.clickOnLogInButton();

			Assert.assertTrue(dashboardPage.isDashboardNavbarPresent());
			String pageUrl = loginPage.getCurrentWebpageURL();
			if (pageUrl.contains("dashboard")) {
				Assert.assertEquals(1, 1);
			} else {
				Assert.assertEquals(1, 0);
			}

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to verify dashboard navigation bar link" + UtilityMethods.getStackTrace());
			Assert.fail("Unable to verify dashboard navigation bar link");
		}
	}

	@Test(priority = 1, description = "TC_Dashboard_002 To Verify dashboard page UI if Uncheck all checkboxes from 'Manage Widgets' nav bar")
	public void Verify_the_dashboard_page_UI_if_Uncheck_all_checkboxes_from_Manage_Widgets_nav_bar() {
		try {
			log.info("************************* TC-002*************************");
			extentTest.setDescription(
					"TC_Dashboard_002 To Verify dashboard page UI if Uncheck all checkboxes from 'Manage Widgets' nav bar");
			dashboardPage = new DashboardPage(getDriver());
			manageWidgetsPage = new ManageWidgetsPage(getDriver());
			Assert.assertTrue(dashboardPage.isDashboardNavbarPresent());
			String mapText = dashboardPage.getTextDashboardMapSection();
			manageWidgetsPage.clickOnManageWidgetNavbar();
			manageWidgetsPage.clickOnSubManageWidgetNavbar();

			for (int i = 1; i <= 8; i++) {
				manageWidgetsPage.clickOnAllManageWidgetUnCheckBox();
			}
			manageWidgetsPage.clickOnManageWidgetUpdateButton();
			String updateMsg = manageWidgetsPage.isUpdateSuccessfullMessagePresent();
			Assert.assertEquals(updateMsg, "Setting updated successfully.");
			Assert.assertNotEquals(mapText, "dash");

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to Verify dashboard page UI if Uncheck all checkboxes from 'Manage Widgets' nav bar"
					+ UtilityMethods.getStackTrace());
			Assert.fail("Unable to Verify dashboard page UI if Uncheck all checkboxes from 'Manage Widgets' nav bar");
		}
	}

//	@Test(priority = 2, description = "TC_Dashboard_002 To Verify dashboard page UI if Uncheck all checkboxes from 'Manage Widgets' nav bar")
//	public void Verify_the_dashboard_page_UI_if_checked_all_checkboxes_from_Manage_Widgets_nav_bar() {
//
//		try {
//			log.info("************************* TC-003*************************");
//			extentTest.setDescription("TC_Dashboard_002 To Verify dashboard page UI if Uncheck all checkboxes from 'Manage Widgets' nav bar");
//			loginPage = new LoginPage(getDriver());
//			manageWidgetsPage= new ManageWidgetsPage(getDriver());
//			
//			manageWidgetsPage.clickOnManageWidgetNavbar();
//			manageWidgetsPage.clickOnSubManageWidgetNavbar();
//			
//			for(int i=1;i<=8;i++) {
// 			manageWidgetsPage.clickOnAllSubManageWidgetNavbarCheckBox();
//			}
//			manageWidgetsPage.clickOnManageWidgetUpdateButton();
//			String updateMsg = manageWidgetsPage.isUpdateSuccessfullMessagePresent();
//
//			Assert.assertEquals(updateMsg, "Setting updated successfully.");
//			Assert.assertTrue(dashboardPage.isDashboardSectionPresent());
//	 
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			logError("Unable to Verify dashboard page UI if Uncheck all checkboxes from 'Manage Widgets' nav bar" + UtilityMethods.getStackTrace());
//			Assert.fail("Unable to Verify dashboard page UI if Uncheck all checkboxes from 'Manage Widgets' nav bar");
//		}
//	}
	
	
}
