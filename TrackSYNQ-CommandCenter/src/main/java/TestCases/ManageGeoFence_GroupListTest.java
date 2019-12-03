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

public class ManageGeoFence_GroupListTest extends BaseSetup {
	LoginPage loginPage;

	ManageRolesPage manageRolesPage;
	ManageGeoFencePage manageGeoFencePage;
	ManageUsersPage manageUsersPage;
	ReportsPage reportsPage;

	static Logger log = Logger.getLogger(ManageGeoFence_GroupListTest.class);

	@Test(priority = 0, description = "TC_Manage Geo Fence_001 Verify the 'Manage Geo Fence' side bar")
	public void Verify_the_Manage_Geo_Fence_side_bar() {

		try {
			log.info("************************* TC-01*************************");
			extentTest.setDescription("TC_Manage Geo Fence_001 Verify the 'Manage Geo Fence' side bar");
			manageGeoFencePage = new ManageGeoFencePage(getDriver());
			loginPage = new LoginPage(getDriver());
			loginPage.enterEmailAddess(config.getProperty("siteAdminEmail"));
			loginPage.enterPassword(config.getProperty("siteAdminPassword"));
			loginPage.clickOnLogInButton();
			manageGeoFencePage.clickOnManageGeoFenceSidebar();
			Assert.assertTrue(manageGeoFencePage.isManageGeoFenceSubmoduleSidebarPresent("Group List"));
			Assert.assertTrue(manageGeoFencePage.isManageGeoFenceSubmoduleSidebarPresent("Geo Fence List"));
			Assert.assertTrue(manageGeoFencePage.isManageGeoFenceSubmoduleSidebarPresent("Add Geo Fence"));

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to Verify the 'Manage Geo Fence' side bar" + UtilityMethods.getStackTrace());
			Assert.fail("Unable to Verify the 'Manage Geo Fence' side bar");
		}
	}

	@Test(priority = 1, description = "TC_Manage Geo Fence_Group List_002 Verify the 'Group List' side bar link  ")
	public void Verify_the_Group_List_side_bar_link() {

		try {
			log.info("************************* TC-02*************************");
			extentTest.setDescription("TC_Manage Geo Fence_Group List_002 Verify the 'Group List' side bar link");
			manageGeoFencePage = new ManageGeoFencePage(getDriver());
			manageGeoFencePage.clickOnManageGeoFenceSidebar();
			manageGeoFencePage.clickOnManageGeoFenceGroupListSidebar("Group List");
			String pageUrl = loginPage.getCurrentWebpageURL();
			if (pageUrl.contains("manage_geo_fence/group_list")) { // URL Not match
				Assert.assertEquals(1, 1);
			} else {
				Assert.assertEquals(1, 0);
			}

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to Verify the  'Group List' side bar link" + UtilityMethods.getStackTrace());
			Assert.fail("Unable to Verify the 'Group List' side bar link");
		}
	}

	@Test(priority = 2, description = "TC_Manage Geo Fence_Group List_003 Verify the UI of 'Group List'")
	public void Verify_the_UI_of_Group_List() {

		try {
			log.info("************************* TC-03*************************");
			extentTest.setDescription("TC_Manage Geo Fence_Group List_003 Verify the UI of 'Group List'");
			manageUsersPage = new ManageUsersPage(getDriver());
			manageGeoFencePage = new ManageGeoFencePage(getDriver());
			manageRolesPage = new ManageRolesPage(getDriver());
			reportsPage = new ReportsPage(getDriver());
			manageGeoFencePage.clickOnManageGeoFenceSidebar();
			manageGeoFencePage.clickOnManageGeoFenceGroupListSidebar("Group List");
			Assert.assertTrue(reportsPage.isReportHomeLinkPresent());
			Assert.assertTrue(manageGeoFencePage.isManageGeoFenceLinkPathPresent());
			Assert.assertTrue(manageGeoFencePage.isManageGeoFenceLinkPathPresent());
			Assert.assertTrue(manageGeoFencePage.isManageGeoFenceGroupListLinkPathPresent("Group List"));
			Assert.assertEquals(reportsPage.getCssValueReportsLogsTitle(), "rgba(2, 192, 245, 1)");

			// Verify the Group list drop-down
			manageRolesPage.clickOnUserListDropDown();
			Assert.assertTrue(manageRolesPage.isManageRolesTitleOptionPresent("Group Name"));
			Assert.assertTrue(manageRolesPage.isManageRolesTitleOptionPresent("Description"));
			Assert.assertTrue(reportsPage.isSearchFieldPresent());

			// + Add Role Button
			Assert.assertTrue(reportsPage.isAddScheduleReportButtonPresent());
			for (int i = 1; i <= 6; i++) {

				Assert.assertTrue(reportsPage.isReportHeadingColumnPresent(i));
			}

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to Verify the UI of  'Group  List' " + UtilityMethods.getStackTrace());
			Assert.fail("Unable to Verify the UI of  'Group  List'");
		}
	}

	@Test(priority = 3, description = "TC_Manage Geo Fence_Group List_004 Verify the  'Search placeholder ")
	public void Verify_the_Search_placeholder() {

		try {
			log.info("************************* TC-04*************************");
			extentTest.setDescription("TC_Manage Geo Fence_Group List_004 Verify the 'Search placeholder");
			manageRolesPage = new ManageRolesPage(getDriver());
			reportsPage = new ReportsPage(getDriver());
			manageGeoFencePage = new ManageGeoFencePage(getDriver());
			manageGeoFencePage.clickOnManageGeoFenceSidebar();
			manageGeoFencePage.clickOnManageGeoFenceGroupListSidebar("Group List");

			// Verify the Search placeholder text
			String expectedSelectObjectText = "Search";
			String actualSelectObjectText = manageRolesPage.getSearchPlaceholderText();
			Assert.assertEquals(actualSelectObjectText, expectedSelectObjectText);
		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to Verify the 'Search placeholder" + UtilityMethods.getStackTrace());
			Assert.fail("Unable to Verify the 'Search placeholder");
		}
	}

	@Test(priority = 4, description = "TC_Manage Geo Fence_Group List_005 Verify the search functionality")
	public void Verify_the_search_functionality() {

		try {
			log.info("************************* TC-005*************************");
			extentTest.setDescription("TC_Manage Geo Fence_Group List_005 To verify the search functionality ");
			manageGeoFencePage = new ManageGeoFencePage(getDriver());
			manageRolesPage = new ManageRolesPage(getDriver());
			reportsPage = new ReportsPage(getDriver());
			manageGeoFencePage.clickOnManageGeoFenceSidebar();
			manageGeoFencePage.clickOnManageGeoFenceGroupListSidebar("Group List");
			reportsPage.searchReport("Home Group");
			Assert.assertTrue(manageRolesPage.isNoDataMessagePresence());

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable To Verify  the search functionality" + UtilityMethods.getStackTrace());
			Assert.fail("Unable To Verify  the search functionality");
		}
	}

	@Test(priority = 5, description = "TC_Manage Geo Fence_Group List_006 Verify the 'Add Group' button ")
	public void Verify_the_Add_Group_button() {
		try {
			log.info("************************* TC-006*************************");
			extentTest.setDescription("TC_Manage Geo Fence_Group List_006 Verify the 'Add Group' button");
			reportsPage = new ReportsPage(getDriver());
			manageRolesPage = new ManageRolesPage(getDriver());
			manageGeoFencePage = new ManageGeoFencePage(getDriver());
			manageGeoFencePage.clickOnManageGeoFenceSidebar();
			manageGeoFencePage.clickOnManageGeoFenceGroupListSidebar("Group List");

			// used for click on Add Group Button
			reportsPage.clickOnAddScheduleReportButton();
			Assert.assertTrue(manageGeoFencePage.isAddGeoFenceGroupPopupPresent());

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable To Verify the 'Add Group' button" + UtilityMethods.getStackTrace());
			Assert.fail("Unable To Verify the 'Add Group' button");
		}
	}

	@Test(priority = 6, description = "TC_Manage Geo Fence_Group List_007 Verify the UI of 'Add Group' popup ")
	public void Verify_the_UI_of_Add_Group_popup() {
		try {
			log.info("************************* TC-006*************************");
			extentTest.setDescription("TC_Manage Geo Fence_Group List_007 Verify the 'Add Group' button");
			reportsPage = new ReportsPage(getDriver());
			manageRolesPage = new ManageRolesPage(getDriver());
			manageGeoFencePage = new ManageGeoFencePage(getDriver());
			manageGeoFencePage.clickOnManageGeoFenceSidebar();
			manageGeoFencePage.clickOnManageGeoFenceGroupListSidebar("Group List");

			// used for click on Add Group Button
			reportsPage.clickOnAddScheduleReportButton();
			Assert.assertTrue(manageGeoFencePage.isAddGeoFenceGroupPopupLabelsPresent("Geo Fence Group Name"));
			Assert.assertTrue(manageGeoFencePage.isAddGeoFenceGroupPopupGroupNameFieldPresent());
			Assert.assertTrue(manageGeoFencePage.isAddGeoFenceGroupPopupLabelsPresent("Geo Fence Group Description"));
			Assert.assertTrue(manageGeoFencePage.isAddGeoFenceGroupPopupGroupDescFieldPresent());
			Assert.assertTrue(manageGeoFencePage.isAddGeoFenceGroupSaveButtonPresent());
			Assert.assertTrue(manageGeoFencePage.isAddGeoFenceGroupCancelButtonPresent());

			// Verify Cross button
			Assert.assertTrue(reportsPage.isEmailOnDemandCrossBtnPresent());

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable To Verify the UI of 'Add Group' popup" + UtilityMethods.getStackTrace());
			Assert.fail("Unable To Verify the UI of 'Add Group' popup");
		}
	}

	@Test(priority = 7, description = "TC_Manage Geo Fence_Group List_008 Verify the placeholder of 'Add Group' popup")
	public void Verify_the_placeholder_of_Add_Group_popup() {

		try {
			log.info("************************* TC-08*************************");
			extentTest
					.setDescription("TC_Manage Geo Fence_Group List_008 Verify the placeholder of 'Add Group' popup ");
			manageUsersPage = new ManageUsersPage(getDriver());
			reportsPage = new ReportsPage(getDriver());
			manageGeoFencePage = new ManageGeoFencePage(getDriver());
			manageGeoFencePage.clickOnManageGeoFenceSidebar();
			manageGeoFencePage.clickOnManageGeoFenceGroupListSidebar("Group List");

			// used for click on Add Group Button
			reportsPage.clickOnAddScheduleReportButton();
			Assert.assertEquals(manageGeoFencePage.getAddGeoFenceGroupNameFieldPlaceholderText(),
					"Enter Geo Fence Group Name");
			Assert.assertEquals(manageGeoFencePage.getAddGeoFenceGroupDescFieldPlaceholderText(),
					"Enter Geo Fence Group Description");

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to Verify the placeholder of 'Add Group' popup " + UtilityMethods.getStackTrace());
			Assert.fail("Unable to Verify the placeholder of 'Add Group' popup");
		}
	}

	@Test(priority = 8, description = "TC_Manage Geo Fence_Group List_009 Verify the validation message in all field")
	public void Verify_the_validation_message_in_all_field() {

		try {
			log.info("************************* TC-009*************************");
			extentTest.setDescription("TC_Manage Geo Fence_Group List_009 Verify the validation message in all field");
			reportsPage = new ReportsPage(getDriver());
			manageGeoFencePage = new ManageGeoFencePage(getDriver());
			manageGeoFencePage.clickOnManageGeoFenceSidebar();
			manageGeoFencePage.clickOnManageGeoFenceGroupListSidebar("Group List");

			// Used for click on Add Group Button
			reportsPage.clickOnAddScheduleReportButton();

			manageGeoFencePage.clickOnSaveButton();
			Assert.assertEquals(manageGeoFencePage.getGroupNameFieldErrorMessageText(),
					"Please Input Geo Fence Group Name"); // Enter should be replace by Input

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to Verify the validation message in all field" + UtilityMethods.getStackTrace());
			Assert.fail("Unable to Verify the validation message in all field");
		}
	}

	@Test(priority = 9, description = "TC_Manage Geo Fence_Group List_010 Verify if user enter an integer data in 'Group Name' field")
	public void Verify_if_user_enter_an_integer_data_in_Group_Name_field() {

		try {
			log.info("************************* TC-010*************************");
			extentTest.setDescription("TC_Manage Geo Fence_Group List_010 Verify the validation message in all field");
			manageUsersPage = new ManageUsersPage(getDriver());
			reportsPage = new ReportsPage(getDriver());
			manageGeoFencePage = new ManageGeoFencePage(getDriver());
			manageGeoFencePage.clickOnManageGeoFenceSidebar();
			manageGeoFencePage.clickOnManageGeoFenceGroupListSidebar("Group List");

			// Used for click on Add Group Button
			reportsPage.clickOnAddScheduleReportButton();
			manageGeoFencePage.enterAddGeoFenceDetails("123456", "");
			Assert.assertTrue(manageGeoFencePage.isGroupNameErrorMessageInvalidData()); // Enter should be replace by
																						// Input

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to Verify if user enter an integer data in 'Group Name' field"
					+ UtilityMethods.getStackTrace());
			Assert.fail("Unable to Verify if user enter an integer value in 'Group Name' field");
		}
	}

	@Test(priority = 10, description = "TC_Manage Geo Fence_Group List_011 Verify the 'Cross' (×) button functionality")
	public void Verify_the_Cross_button_functionality() {

		try {
			log.info("************************* TC-011*************************");
			extentTest.setDescription("TC_Manage Geo Fence_Group List_011 Verify the validation message in all field");
			manageUsersPage = new ManageUsersPage(getDriver());
			reportsPage = new ReportsPage(getDriver());
			manageGeoFencePage = new ManageGeoFencePage(getDriver());
			manageGeoFencePage.clickOnManageGeoFenceSidebar();
			manageGeoFencePage.clickOnManageGeoFenceGroupListSidebar("Group List");

			// Used for click on Add Group Button
			reportsPage.clickOnAddScheduleReportButton();

			// Verify the cross button
			reportsPage.clickOnCrossButtonEmailOnDemands();
			Assert.assertFalse(manageGeoFencePage.isAddGeoFenceGroupPopUp());
		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to Verify the 'Cross' (×) button functionality" + UtilityMethods.getStackTrace());
			Assert.fail("Unable to Verify the 'Cross' (×) button functionality");
		}
	}

	@Test(priority = 11, description = "TC_Manage Geo Fence_Group List_012 Verify the Cancel button functionality")
	public void Verify_the_Cancel_button_functionality() {

		try {
			log.info("************************* TC-012*************************");
			extentTest.setDescription("TC_Manage Geo Fence_Group List_012 Verify the Cancel button functionality");
			manageUsersPage = new ManageUsersPage(getDriver());
			reportsPage = new ReportsPage(getDriver());
			manageGeoFencePage = new ManageGeoFencePage(getDriver());
			manageGeoFencePage.clickOnManageGeoFenceSidebar();
			manageGeoFencePage.clickOnManageGeoFenceGroupListSidebar("Group List");

			// Used for click on Add Group Button
			reportsPage.clickOnAddScheduleReportButton();

			// Verify the cancel button
			reportsPage.clickOnCancelButtonEmailOnDemands();
			Assert.assertFalse(manageGeoFencePage.isAddGeoFenceGroupPopUp());

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to Verify the Cancel button functionality" + UtilityMethods.getStackTrace());
			Assert.fail("Unable to Verify the Cancel button functionality");
		}
	}

	@Test(priority = 12, description = "TC_Manage Geo Fence_Group List_013 Verify If user click on out side of 'Add Group' popup")
	public void Verify_If_user_click_on_out_side_of_Add_Group_popup() {

		try {
			log.info("************************* TC-013*************************");
			extentTest.setDescription("TC_Manage Geo Fence_Group List_013 Verify the Cancel button functionality");
			manageUsersPage = new ManageUsersPage(getDriver());
			reportsPage = new ReportsPage(getDriver());
			manageGeoFencePage = new ManageGeoFencePage(getDriver());
			manageGeoFencePage.clickOnManageGeoFenceSidebar();
			manageGeoFencePage.clickOnManageGeoFenceGroupListSidebar("Group List");

			// Used for click on Add Group Button
			reportsPage.clickOnAddScheduleReportButton();

			// Verify If user click on out side of 'Add Group' pop-up
			manageGeoFencePage.clickOutSidePopup();

		} catch (Exception e) {
			e.printStackTrace();
			logError(
					"Unable to Verify If user click on out side of 'Add Group' popup" + UtilityMethods.getStackTrace());
			Assert.fail("Unable to Verify If user click on out side of 'Add Group' popup");
		}
	}

	@Test(priority = 13, description = "TC_Manage Geo Fence_Group List_014 Verify the 'Save' button functionality if user enter valid data")
	public void Verify_the_Save_button_functionality_if_user_enter_valid_data() {

		try {
			log.info("************************* TC-014*************************");
			extentTest.setDescription(
					"TC_Manage Geo Fence_Group List_014 Verify the 'Save' button functionality if user enter valid data  ");
			manageUsersPage = new ManageUsersPage(getDriver());
			reportsPage = new ReportsPage(getDriver());
			manageGeoFencePage = new ManageGeoFencePage(getDriver());
			manageGeoFencePage.clickOnManageGeoFenceSidebar();
			manageGeoFencePage.clickOnManageGeoFenceGroupListSidebar("Group List");

			// Used for click on Add Group Button
			reportsPage.clickOnAddScheduleReportButton();
			manageGeoFencePage.enterAddGeoFenceDetails("My Office",
					"Functionally this is used to quickly select a group of geofences from a large list of individual geo-fences.");
			manageGeoFencePage.clickOnSaveButton();
			Assert.assertEquals(manageGeoFencePage.getGroupNameFieldText(), "My Office");

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to Verify the 'Save' button functionality if user enter valid data  "
					+ UtilityMethods.getStackTrace());
			Assert.fail("Unable to Verify the 'Save' button functionality if user enter valid data  ");
		}
	}

	
	@Test(priority = 14, description = "TC_Manage Geo Fence_Group List_015 Verify the edit button tooltip and functionality")
	public void Verify_the_edit_button_tooltip_and_functionality() {

		try {
			log.info("************************* TC-011*************************");
			extentTest.setDescription("TC_ManageRoles_Add Role_015 Verify the edit button tooltip and functionality");
			manageRolesPage = new ManageRolesPage(getDriver());
			reportsPage = new ReportsPage(getDriver());
			manageGeoFencePage = new ManageGeoFencePage(getDriver());
			manageGeoFencePage.clickOnManageGeoFenceSidebar();
			manageGeoFencePage.clickOnManageGeoFenceGroupListSidebar("Group List");
		    String beforeGroupNametext	= manageGeoFencePage.getGroupNameText();
		    
			// Verify the edit tool tip
			manageGeoFencePage.editToolTip(); //tool tip is not display 
			
			//verify the edit functionality 
			manageGeoFencePage.clickOnEditIcon();
			manageGeoFencePage.enterAddGeoFenceDetails("My Team",
					"A geo-fence is a virtual perimeter for a real-world geographic area.");
			manageRolesPage.clickOnEditRoleUpdateButton();
			Assert.assertNotEquals(beforeGroupNametext, "My Team");

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to Verify the edit button tooltip and functionality" + UtilityMethods.getStackTrace());
			Assert.fail("Unable to Verify the edit button tooltip and functionality");
		}
	}
		
		@Test(priority =15, description = "TC_Manage Geo Fence_Group List_016 Verify the tooltip of delete button and functionality")
		public void Verify_the_tooltip_of_delete_button_and_functionality() {

			try {
				log.info("************************* TC-016*************************");
				extentTest.setDescription("TC_Manage Geo Fence_Group List_016 Verify the tooltip of delete button and functionality");
				manageRolesPage = new ManageRolesPage(getDriver());
				reportsPage = new ReportsPage(getDriver());
				manageGeoFencePage = new ManageGeoFencePage(getDriver());
				manageGeoFencePage.clickOnManageGeoFenceSidebar();
				manageGeoFencePage.clickOnManageGeoFenceGroupListSidebar("Group List");
			    
				// Verify the tool tip
				manageGeoFencePage.deleteIconToolTip(); 
				manageGeoFencePage.clickOnDeleteIcon();
				Assert.assertEquals(manageGeoFencePage.getDeleteGroupErrorMessageText(), "Geo fence group deleted successfully."); 

			} catch (Exception e) {
				e.printStackTrace();
				logError("Unable to Verify the tooltip of delete button and functionality" + UtilityMethods.getStackTrace());
				Assert.fail("Unable to Verify the tooltip of delete button and functionality");
			}
		}
			
			@Test(priority = 16, description = "TC_Manage Geo Fence_Group List_017  Verify the pagination functionality")
			public void Verify_the_pagination_functionality() {

				try {
					log.info("************************* TC-017************************");
					extentTest.setDescription("TC_Manage Geo Fence_Group List_016 To Verify the pagination functionality");
					reportsPage = new ReportsPage(getDriver());
					manageGeoFencePage = new ManageGeoFencePage(getDriver());
					manageGeoFencePage.clickOnManageGeoFenceSidebar();
					manageGeoFencePage.clickOnManageGeoFenceGroupListSidebar("Group List");
					reportsPage.checkPagination();

				} catch (Exception e) {
					e.printStackTrace();
					logError("Unable To Verify the pagination functionality" + UtilityMethods.getStackTrace());
					Assert.fail("Unable To verify the pagination functionality");
				}
			}
}
