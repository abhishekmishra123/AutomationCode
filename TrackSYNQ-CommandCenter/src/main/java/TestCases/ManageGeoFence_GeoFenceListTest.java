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


public class ManageGeoFence_GeoFenceListTest extends BaseSetup {
	LoginPage loginPage;
	ManageRolesPage manageRolesPage;
	ManageGeoFencePage manageGeoFencePage;
	ManageUsersPage manageUsersPage;
	ReportsPage reportsPage;

	static Logger log = Logger.getLogger(ManageGeoFence_GeoFenceListTest.class);

	
	@Test(priority = 0, description = "TC_Manage Geo Fence_Geo FenceList_021 Verify the 'Geo Fence List' side bar link ")
	public void Verify_the_Group_List_side_bar_link() {

		try {
			log.info("************************* TC-021*************************");
			extentTest.setDescription("TC_Manage Geo Fence_Geo FenceList_021 Verify the 'Geo Fence List' side bar link ");
			manageGeoFencePage = new ManageGeoFencePage(getDriver());
			loginPage = new LoginPage(getDriver());
			loginPage.enterEmailAddess(config.getProperty("siteAdminEmail"));
			loginPage.enterPassword(config.getProperty("siteAdminPassword"));
			loginPage.clickOnLogInButton();
			manageGeoFencePage.clickOnManageGeoFenceSidebar();
			manageGeoFencePage.clickOnManageGeoFenceGroupListSidebar("Geo Fence List");
			String pageUrl = loginPage.getCurrentWebpageURL();
			if (pageUrl.contains("manage_geo_fence/geo_fence_list")) { // URL Not match
				Assert.assertEquals(1, 1);
			} else {
				Assert.assertEquals(1, 0);
			}

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to Verify the 'Geo Fence List' side bar link " + UtilityMethods.getStackTrace());
			Assert.fail("Unable to Verify the 'Geo Fence List' side bar link ");
		}
	}

	@Test(priority = 1, description = "TC_Manage Geo Fence_Geo FenceList_022 Verify the UI of 'Geo Fence List' '")
	public void Verify_the_UI_of_Group_List() {

		try {
			log.info("************************* TC-022*************************");
			extentTest.setDescription("TC_Manage Geo Fence_Geo FenceList_022 Verify the UI of 'Group List'");
			manageUsersPage = new ManageUsersPage(getDriver());
			manageGeoFencePage = new ManageGeoFencePage(getDriver());
			manageRolesPage = new ManageRolesPage(getDriver());
			reportsPage = new ReportsPage(getDriver());
			manageGeoFencePage.clickOnManageGeoFenceSidebar();
			manageGeoFencePage.clickOnManageGeoFenceGroupListSidebar("Geo Fence List");
			Assert.assertTrue(reportsPage.isReportHomeLinkPresent());
			Assert.assertTrue(manageGeoFencePage.isManageGeoFenceLinkPathPresent());
			Assert.assertTrue(manageGeoFencePage.isManageGeoFenceLinkPathPresent());
			Assert.assertTrue(manageGeoFencePage.isManageGeoFenceGroupListLinkPathPresent("Geo Fence List"));
			Assert.assertEquals(reportsPage.getCssValueReportsLogsTitle(), "rgba(2, 192, 245, 1)");

			// Verify the Geo Fence list drop-down
			manageRolesPage.clickOnUserListDropDown();
			Assert.assertTrue(manageRolesPage.isManageRolesTitleOptionPresent("Geo Fence Name"));
			Assert.assertTrue(manageRolesPage.isManageRolesTitleOptionPresent("Geo Fence Group"));
			Assert.assertTrue(manageRolesPage.isManageRolesTitleOptionPresent("Geo Fence Shape"));
			Assert.assertTrue(reportsPage.isSearchFieldPresent());

			// + Add Geo Fence Button
			Assert.assertTrue(reportsPage.isAddScheduleReportButtonPresent());
			
			//Verify the Geo Fence List header 
			for (int i = 1; i <= 6; i++) {

				if(i==3) {
					continue;
				}
				Assert.assertTrue(reportsPage.isReportHeadingColumnPresent(i));
			}

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to Verify the UI of 'Group List'" + UtilityMethods.getStackTrace());
			Assert.fail("Unable to Verify the UI of 'Group List'");
		}
	}

	@Test(priority = 2, description = "TC_Manage Geo Fence_Geo FenceList_023 Verify the  'Search placeholder")
	public void Verify_the_Search_placeholder() {

		try {
			log.info("************************* TC-023*************************");
			extentTest.setDescription("TC_Manage Geo Fence_Geo FenceList_023 Verify the 'Search placeholder");
			manageRolesPage = new ManageRolesPage(getDriver());
			reportsPage = new ReportsPage(getDriver());
			manageGeoFencePage = new ManageGeoFencePage(getDriver());
			manageGeoFencePage.clickOnManageGeoFenceSidebar();
			manageGeoFencePage.clickOnManageGeoFenceGroupListSidebar("Geo Fence List");

			// Verify the Search placeholder text
			String expectedSelectObjectText = "Search";
			
			//verify the search placeholder 
			String actualSelectObjectText = manageRolesPage.getSearchPlaceholderText();
			Assert.assertEquals(actualSelectObjectText, expectedSelectObjectText);
			
		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to Verify the 'Search placeholder" + UtilityMethods.getStackTrace());
			Assert.fail("Unable to Verify the 'Search placeholder");
		}
	}

	@Test(priority = 3, description = "TC_Manage Geo Fence_Geo FenceList_024 Verify the search functionality")
	public void Verify_the_search_functionality() {

		try {
			log.info("************************* TC-024*************************");
			extentTest.setDescription("TC_Manage Geo Fence_Geo FenceList_024 To verify the search functionality ");
			manageGeoFencePage = new ManageGeoFencePage(getDriver());
			manageRolesPage = new ManageRolesPage(getDriver());
			reportsPage = new ReportsPage(getDriver());
			manageGeoFencePage.clickOnManageGeoFenceSidebar();
			manageGeoFencePage.clickOnManageGeoFenceGroupListSidebar("Geo Fence List");
			reportsPage.searchReport("Home Group");
			Assert.assertTrue(manageRolesPage.isNoDataMessagePresence());

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable To Verify  the search functionality" + UtilityMethods.getStackTrace());
			Assert.fail("Unable To Verify  the search functionality");
		}
	}
	
	@Test(priority = 2, description = "TC_Manage Geo Fence_Geo FenceList_025 Verify the tooltip of 'Add Geo Fence' button ")
	public void Verify_the_tooltip_of_Add_Geo_Fence_button () {

		try {
			log.info("************************* TC-025*************************");
			extentTest.setDescription("TC_Manage Geo Fence_Geo FenceList_025 Verify the tooltip of 'Add Geo Fence' button ");
			reportsPage = new ReportsPage(getDriver());
			manageGeoFencePage = new ManageGeoFencePage(getDriver());
			manageGeoFencePage.clickOnManageGeoFenceSidebar();
			manageGeoFencePage.clickOnManageGeoFenceGroupListSidebar("Geo Fence List");
			manageGeoFencePage.addGeoFenceButtonTooltip();

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to Verify the tooltip of 'Add Geo Fence' button " + UtilityMethods.getStackTrace());
			Assert.fail("Unable to Verify the tooltip of 'Add Geo Fence' button ");
		}
	}
	
	@Test(priority = 5, description = "TC_Manage Geo Fence_Geo FenceList26 Verify the 'Add Geo Fence' button on Geo Fence List ")
	public void Verify_the_Add_Geo_Fence_button_on_Geo_Fence_List() {
		try {
			log.info("************************* TC-026*************************");
			extentTest.setDescription("TC_Manage Geo Fence_Group List_006 Verify the 'Add Geo Fence' button on Geo Fence List");
			reportsPage = new ReportsPage(getDriver());
			manageRolesPage = new ManageRolesPage(getDriver());
			manageGeoFencePage = new ManageGeoFencePage(getDriver());
			manageGeoFencePage.clickOnManageGeoFenceSidebar();
			manageGeoFencePage.clickOnManageGeoFenceGroupListSidebar("Geo Fence List");

			// used for click on Add GeoFence Group Button
			reportsPage.clickOnAddScheduleReportButton();
			String pageUrl = loginPage.getCurrentWebpageURL();
			if (pageUrl.contains("manage_geo_fence/add_geo_fence")) { //URL Not match
				Assert.assertEquals(1, 1);
			} else {
				Assert.assertEquals(1, 0);
			}

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable To Verify the 'Add Geo Fence' button on Geo Fence List" + UtilityMethods.getStackTrace());
			Assert.fail("Unable To Verify the 'Add Geo Fence' button on Geo Fence List");
		}
	}


}
