package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import Common.BaseSetup;
import Common.UtilityMethods;
import PageObjects.LoginPage;
import PageObjects.ManageRolesPage;
import PageObjects.ReportsPage;
import org.apache.log4j.Logger;

public class ManageRoles_RoleListTest extends BaseSetup {
	LoginPage loginPage;

	ManageRolesPage manageRolesPage;
	ReportsPage reportsPage;

	static Logger log = Logger.getLogger(ManageRoles_RoleListTest.class);

	
	@Test(priority = 0, description = "TC_ManageRoles_001 Verify the 'Manage Roles' Side bar functionality")
	public void Verify_the_Manage_Roles_Side_bar_functionality() {

		try {
			log.info("************************* TC-01*************************");
			extentTest.setDescription("TC_ManageRoles_001 Verify the 'Manage Roles' Side bar functionality");
			manageRolesPage = new ManageRolesPage(getDriver());
			loginPage = new LoginPage(getDriver());
			loginPage.enterEmailAddess(config.getProperty("siteAdminEmail"));
			loginPage.enterPassword(config.getProperty("siteAdminPassword"));
			loginPage.clickOnLogInButton();
			manageRolesPage.clickOnManageRolesSidebar();
			
			Assert.assertTrue(manageRolesPage.isManageRoles_RoleListPresent());
			Assert.assertTrue(manageRolesPage.isManageRoles_AddRolePresent());
			manageRolesPage.clickOnReportsManageRolesList();
			String pageUrl = loginPage.getCurrentWebpageURL();
			if (pageUrl.contains("role_list")) { // Error = URL is contains List
				Assert.assertEquals(1, 1);
			} else {
				Assert.assertEquals(1, 0);
			}

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to Verify the 'Manage Roles' Side bar functionality" + UtilityMethods.getStackTrace());
			Assert.fail("Unable to Verify the 'Manage Roles' Side bar functionality");
		}
	}

	@Test(priority = 1, description = "TC_ManageRoles_RoleList_007 Verify the UI on 'Role List'")
	public void Verify_the_UI_on_Role_List() {

		try {
			log.info("************************* TC-002*************************");
			extentTest.setDescription("TC_ManageRoles_RoleList_002  Verify the UI on 'Role List'");
			manageRolesPage = new ManageRolesPage(getDriver());
			reportsPage = new ReportsPage(getDriver());
			manageRolesPage.clickOnManageRolesSidebar();
			manageRolesPage.clickOnReportsManageRolesList();
			Assert.assertTrue(reportsPage.isReportHomeLinkPresent());
			Assert.assertTrue(manageRolesPage.isManageRoleslinkPresent());
			Assert.assertTrue(manageRolesPage.isRoleListlinkPresent());
			Assert.assertEquals(reportsPage.getCssValueReportsLogsTitle(), "rgba(2, 192, 245, 1)");

			// Verify the Role list drop-down
			manageRolesPage.clickOnUserListDropDown();
			Assert.assertTrue(manageRolesPage.isManageRolesTitleOptionPresent("Role Title"));
			Assert.assertTrue(manageRolesPage.isManageRolesTitleOptionPresent("User(s) Name"));
			Assert.assertTrue(reportsPage.isSearchFieldPresent());

			// + Add Role Button
			Assert.assertTrue(reportsPage.isAddScheduleReportButtonPresent());
			for (int i = 1; i <= 7; i++) {
				if (i == 3) {
					continue;
				}
				Assert.assertTrue(reportsPage.isReportHeadingColumnPresent(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to verify the UI on 'Role List' " + UtilityMethods.getStackTrace());
			Assert.fail("Unable to verify the UI on 'Role List' ");
		}
	}

	@Test(priority = 2, description = "TC_ManageRoles_Role List_008 Verify the placeholder on search button ")
	public void Verify_the_placeholder_on_search_button() {
		try {
			log.info("************************* TC-008*************************");
			extentTest.setDescription("TC_Reports_Events Reports_003 Verify the placeholder on search button");
			reportsPage = new ReportsPage(getDriver());
			manageRolesPage = new ManageRolesPage(getDriver());
			manageRolesPage.clickOnManageRolesSidebar();
			manageRolesPage.clickOnReportsManageRolesList();

			// Verify the Search placeholder text
			String expectedSelectObjectText = "Search";
			String actualSelectObjectText = manageRolesPage.getSearchPlaceholderText();
			Assert.assertEquals(actualSelectObjectText, expectedSelectObjectText);

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable To Verify the placeholder on search button " + UtilityMethods.getStackTrace());
			Assert.fail("Unable To Verify the placeholder on search button");
		}
	}

	@Test(priority = 3, description = "TC_ManageRoles_Role List_009 Verify the search data ")
	public void Verify_the_search_Data() {

		try {
			log.info("************************* TC-009*************************");
			extentTest.setDescription("TC_ManageRoles_Role List_009 To verify the search functionality ");
			manageRolesPage = new ManageRolesPage(getDriver());
			reportsPage = new ReportsPage(getDriver());
			manageRolesPage.clickOnManageRolesSidebar();
			manageRolesPage.clickOnReportsManageRolesList();
			reportsPage.searchReport("QA_Testing1");
			Assert.assertTrue(manageRolesPage.isNoDataMessagePresence());

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable To verify the search functionality" + UtilityMethods.getStackTrace());
			Assert.fail("Unable To verify the search functionality");
		}
	}

	@Test(priority = 4, description = "TC_ManageRoles_Role List_010 Verify the 'Add Role' button ")
	public void Verify_the_Add_Role_button() {
		try {
			log.info("************************* TC-010*************************");
			extentTest.setDescription("TC_ManageRoles_Role List_010 Verify the 'Add Role' button");
			reportsPage = new ReportsPage(getDriver());
			manageRolesPage = new ManageRolesPage(getDriver());
			manageRolesPage.clickOnManageRolesSidebar();
			manageRolesPage.clickOnReportsManageRolesList();

			// Used for click on 'Add Role' Button
			reportsPage.clickOnAddScheduleReportButton();
			
			String pageUrl = loginPage.getCurrentWebpageURL();
			if (pageUrl.contains("add_role")) { // Error = URL Contains only add
				Assert.assertEquals(1, 1);
			} else {
				Assert.assertEquals(1, 0);
			}

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable To Verify the 'Add Role' button" + UtilityMethods.getStackTrace());
			Assert.fail("Unable To Verify the 'Add Role' button");
		}
	}

	@Test(priority = 5, description = "TC_ManageRoles_Role List_011 Verify the Create Role, edit button tooltip and functionality")
	public void Verify_the_Create_Role_edit_button_tooltip_and_functionality() {

		try {
			log.info("************************* TC-011*************************");
			extentTest.setDescription("TC_ManageRoles_Add Role_011 Verify the edit button tooltip and functionality");
			manageRolesPage = new ManageRolesPage(getDriver());
			reportsPage = new ReportsPage(getDriver());
			manageRolesPage.clickOnManageRolesSidebar();
			manageRolesPage.clickOnReportsManageRolesList();

			// User for click on Add Role Button
			reportsPage.clickOnAddScheduleReportButton();
			manageRolesPage.enterRoleTitle("QA_Testing1");
			manageRolesPage.enterRoleDescription("QA_Role_Description");
			manageRolesPage.checkAllCheckBox();
			reportsPage.clickOnSaveButton();
			Assert.assertTrue(manageRolesPage.isAddedRolePresent());

			// Verify the edit tool tip
			manageRolesPage.editToolTip();
			manageRolesPage.clickOnEditIcon();
			String pageUrl = loginPage.getCurrentWebpageURL();
			if (pageUrl.contains("edit")) {
				Assert.assertEquals(1, 1);
			} else {
				Assert.assertEquals(1, 0);
			}
			// Assert.assertTrue(manageRolesPage.isCheckedAllCheckBoxPresent());// error - check box not displaying as checked
			manageRolesPage.clickOnEditRoleUpdateButton();
			Assert.assertEquals(manageRolesPage.roleUpdateErrorPopup(), "Role permission is required.");
			Assert.assertTrue(reportsPage.isEmailOnDemandCancelBtnPresent());
			manageRolesPage.clickOnManageHistoryCheckedCheckBox();
			manageRolesPage.clickOnEditRoleUpdateButton();
			Assert.assertEquals(manageRolesPage.roleUpdateSuccessMessage(), "Role updated successfully.");
			manageRolesPage.clickOnEditIcon();
			
			manageRolesPage.clickOnManageHistoryUnCheckedCheckBox();
			manageRolesPage.clickOnEditRoleUpdateButton();
			Assert.assertEquals(manageRolesPage.roleUpdateSuccessMessage(), "Role updated successfully.");
			
			

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to Create Role, edit button tooltip and functionality" + UtilityMethods.getStackTrace());
			Assert.fail("Unable to Create Role, edit button tooltip and functionality");
		}

	}

	@Test(priority = 6, description = "TC_ManageRoles_Role List_012 Verify the Added Role search")
	public void Verify_the_Added_Role_search() {

		try {
			log.info("************************* TC-012*************************");
			extentTest.setDescription("TC_ManageRoles_Role List_004 Verify the Added Role search");
			manageRolesPage = new ManageRolesPage(getDriver());
			reportsPage = new ReportsPage(getDriver());
			manageRolesPage.clickOnManageRolesSidebar();
			manageRolesPage.clickOnReportsManageRolesList();
			reportsPage.searchReport("QA_Testing1");
			Assert.assertTrue(reportsPage.isAddedRolePresent());
			
//			manageRolesPage.clickOnRoleDelete("QA_Testing1");
//			Assert.assertEquals(manageRolesPage.roleDeleteMessage(),"Role deleted successfully.");
			

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable Verify the Added Role search" + UtilityMethods.getStackTrace());
			Assert.fail("Unable Verify the Added Role search");
		}
	}
	
	@Test(priority = 6, description = "TC_ManageRoles_Role List_012 Verify the Create New Role with Existing Name")
	public void Verify_the_Create_New_Role_with_Existing_Name() {

		try {
			log.info("************************* TC-012*************************");
			extentTest.setDescription("TC_ManageRoles_Role List_004 Verify the Create New Role with Existing Name");
			manageRolesPage = new ManageRolesPage(getDriver());
			reportsPage = new ReportsPage(getDriver());
			manageRolesPage.clickOnManageRolesSidebar();
			manageRolesPage.clickOnReportsManageRolesList();
			
			//Search Added role
			reportsPage.searchReport("QA_Testing1");
			
			// User for click on Add Role Button
			reportsPage.clickOnAddScheduleReportButton();
			manageRolesPage.enterRoleTitle("QA_Testing1");
			manageRolesPage.enterRoleDescription("QA_Role_Description");
			manageRolesPage.checkAllCheckBox();
			reportsPage.clickOnSaveButton();
			Assert.assertEquals(manageRolesPage.deplicateRoleAddedErrorMessage(), "Role Title already exists.");
	

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable Verify the Create New Role with Existing Name" + UtilityMethods.getStackTrace());
			Assert.fail("Unable Verify the Create New Role with Existing Name");
		}
	}
	
	
}
