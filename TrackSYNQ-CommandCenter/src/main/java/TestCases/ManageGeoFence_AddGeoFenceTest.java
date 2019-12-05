package TestCases;

import org.testng.Assert;

import org.testng.annotations.Test;
import Common.BaseSetup;
import Common.UtilityMethods;
import PageObjects.LoginPage;
import PageObjects.ManageGeoFencePage;
import PageObjects.ManageRolesPage;
import PageObjects.ManageUsersPage;
import PageObjects.ReportsPage;
import org.apache.log4j.Logger;


public class ManageGeoFence_AddGeoFenceTest extends BaseSetup {
		
	LoginPage loginPage;

	ManageRolesPage manageRolesPage;
	ManageGeoFencePage manageGeoFencePage;
	ManageUsersPage manageUsersPage;
	ReportsPage reportsPage;

	static Logger log = Logger.getLogger(ManageGeoFence_AddGeoFenceTest.class);


	@Test(priority = 0, description = "TC_Manage Geo Fence_Add Geo Fence _018 Verify the 'Add Geo Fence ' Side bar link")
	public void Verify_the_Add_Geo_Fence_Side_bar_link_side_bar_link() {

		try {
			log.info("************************* TC-018*************************");
			extentTest.setDescription("TC_Manage Geo Fence_Add Geo Fence _018 Verify the 'Add Geo Fence ' Side bar link");
			manageGeoFencePage = new ManageGeoFencePage(getDriver());
			loginPage = new LoginPage(getDriver());
			loginPage.enterEmailAddess(config.getProperty("siteAdminEmail"));
			loginPage.enterPassword(config.getProperty("siteAdminPassword"));
			loginPage.clickOnLogInButton();
			manageGeoFencePage.clickOnManageGeoFenceSidebar();
			manageGeoFencePage.clickOnManageGeoFenceGroupListSidebar("Add Geo Fence");
			String pageUrl = loginPage.getCurrentWebpageURL();
			
			if (pageUrl.contains("manage_geo_fence/add_geo_fence")) { // URL Not match
				Assert.assertEquals(1, 1);
			} else {
				Assert.assertEquals(1, 0);
			}

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to Verify the 'Add Geo Fence ' Side bar link" + UtilityMethods.getStackTrace());
			Assert.fail("Unable to Verify the 'Add Geo Fence ' Side bar link ");
		}
	}

	@Test(priority = 1, description = "TC_Manage Geo Fence_Add Geo Fence _019 Verify the UI of 'Add Geo Fence' page")
	public void Verify_the_UI_of_Add_Geo_Fence_page() {

		try {
			log.info("************************* TC-03*************************");
			extentTest.setDescription("TC_Manage Geo Fence_Add Geo Fence _019 Verify the UI of 'Add Geo Fence'");
			manageUsersPage = new ManageUsersPage(getDriver());
			manageGeoFencePage = new ManageGeoFencePage(getDriver());
			manageRolesPage = new ManageRolesPage(getDriver());
			reportsPage = new ReportsPage(getDriver());
			manageGeoFencePage.clickOnManageGeoFenceSidebar();
			manageGeoFencePage.clickOnManageGeoFenceGroupListSidebar("Add Geo Fence");
			Assert.assertTrue(reportsPage.isReportHomeLinkPresent());
			Assert.assertTrue(manageGeoFencePage.isManageGeoFenceSubmoduleSidebarPresent("Manage Geo Fence"));
			Assert.assertTrue(manageGeoFencePage.isAddGeoFenceLinkPathPresent());
			Assert.assertEquals(reportsPage.getCssValueReportsLogsTitle(), "rgba(2, 192, 245, 1)");
			
			// + Add GeoFence Button
			Assert.assertTrue(reportsPage.isAddScheduleReportButtonPresent());
			Assert.assertTrue(reportsPage.isEmailOnDemandCancelBtnPresent());
			Assert.assertTrue(manageGeoFencePage.isGoogleMapPresent());
			
		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to Verify the UI of 'Add Geo Fence' page " + UtilityMethods.getStackTrace());
			Assert.fail("Unable to Verify the UI of 'Add Geo Fence' page");
		}
	}

	
	@Test(priority = 2, description = "TC_Manage Geo Fence_Add Geo Fence _020 Verify the click on 'Add Geo Fence' button without draw a shape")
	public void Verify_the_click_on_Add_Geo_Fence_button_without_draw_a_shape() {

		try {
			log.info("************************* TC-03*************************");
			extentTest.setDescription("TC_Manage Geo Fence_Add Geo Fence _020 Verify the click on 'Add Geo Fence' button without draw a shape");
			manageUsersPage = new ManageUsersPage(getDriver());
			manageGeoFencePage = new ManageGeoFencePage(getDriver());
			manageRolesPage = new ManageRolesPage(getDriver());
			reportsPage = new ReportsPage(getDriver());
			manageGeoFencePage.clickOnManageGeoFenceSidebar();
			manageGeoFencePage.clickOnManageGeoFenceGroupListSidebar("Add Geo Fence");
			
			//click on + Add GeoFence Button
			reportsPage.clickOnAddScheduleReportButton();
			Assert.assertTrue(manageGeoFencePage.isDrawAShapErrorMessagePresent());
			
		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to Verify the click on 'Add Geo Fence' button without draw a shape" + UtilityMethods.getStackTrace());
			Assert.fail("Unable to Verify the click on 'Add Geo Fence' button without draw a shape");
		}
	}

	@Test(priority = 2, description = "TC_Manage Geo Fence_Add Geo Fence _021 Verify the click on 'Add Geo Fence' button with draw a shape")
	public void Verify_the_click_on_Add_Geo_Fence_button_with_draw_a_shape() {

		try {
			log.info("************************* TC-04*************************");
			extentTest.setDescription("TC_Manage Geo Fence_Add Geo Fence _019 Verify the UI of 'Add Geo Fence'");
			manageUsersPage = new ManageUsersPage(getDriver());
			manageGeoFencePage = new ManageGeoFencePage(getDriver());
			manageRolesPage = new ManageRolesPage(getDriver());
			reportsPage = new ReportsPage(getDriver());
			loginPage = new LoginPage(getDriver());
			loginPage.enterEmailAddess(config.getProperty("siteAdminEmail"));
			loginPage.enterPassword(config.getProperty("siteAdminPassword"));
			loginPage.clickOnLogInButton();
			manageGeoFencePage.clickOnManageGeoFenceSidebar();
			manageGeoFencePage.clickOnManageGeoFenceGroupListSidebar("Add Geo Fence");
			manageGeoFencePage.enterLocation("indore");
			manageGeoFencePage.clickOnDrawpolygonButton();
	    	manageGeoFencePage.drawPolygon(); 
	    	reportsPage.clickOnAddScheduleReportButton();
							
		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to Verify the click on 'Add Geo Fence'  button with draw a shape" + UtilityMethods.getStackTrace());
			Assert.fail("Unable to Verify the click on 'Add Geo Fence'  button with draw a shape");
		}
	}

}
