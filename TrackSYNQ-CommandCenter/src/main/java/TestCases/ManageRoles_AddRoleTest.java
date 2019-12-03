package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import Common.BaseSetup;
import Common.UtilityMethods;
import PageObjects.LoginPage;
import PageObjects.ManageRolesPage;
import PageObjects.ReportsPage;
import static org.testng.Assert.assertEquals;
import org.apache.log4j.Logger;


public class ManageRoles_AddRoleTest extends BaseSetup {
	LoginPage loginPage;

	ManageRolesPage manageRolesPage;
	ReportsPage reportsPage;

	static Logger log = Logger.getLogger(ManageRoles_AddRoleTest.class);
	


	@Test(priority = 1, description = "TC_ManageRoles_AddRole_002 Verify the 'Add Role' Side bar")
	public void Verify_the_Add_Role_Side_bar() {

		try {
			log.info("************************* TC-02*************************");
			extentTest.setDescription("TC_ManageRoles_001 Verify the 'Manage Roles' Side bar functionality");
			manageRolesPage = new ManageRolesPage(getDriver());
			loginPage = new LoginPage(getDriver());
			loginPage.enterEmailAddess(config.getProperty("siteAdminEmailData"));
			loginPage.enterPassword(config.getProperty("siteAdminPasswordData"));
			loginPage.clickOnLogInButton();
			manageRolesPage.clickOnManageRolesSidebar();
			Assert.assertTrue(manageRolesPage.isManageRoles_RoleListPresent());
			Assert.assertTrue(manageRolesPage.isManageRoles_AddRolePresent());
			manageRolesPage.clickOnAddRoleSideBar();
			String pageUrl = loginPage.getCurrentWebpageURL();
			if (pageUrl.contains("add_role")) {  //URL Not match
				Assert.assertEquals(1, 1);
			} else {
				Assert.assertEquals(1, 0);
			}

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to verify the 'Add Role' Side bar"
					+ UtilityMethods.getStackTrace());
			Assert.fail("Unable to verify the 'Add Role' Side bar");
		}
	}

	@Test(priority = 2, description = "TC_ManageRoles_Add Role_03 Verify the UI of 'Add Role' page")
	public void Verify_the_UI_of_Add_Role_page() {

		try {
			log.info("************************* TC-03*************************");
			extentTest.setDescription("TC_ManageRoles_Add Role_03 Verify the UI of 'Add Role' page");
			manageRolesPage = new ManageRolesPage(getDriver());
			reportsPage = new ReportsPage(getDriver());
			manageRolesPage.clickOnManageRolesSidebar();
			manageRolesPage.clickOnAddRoleSideBar();
			Assert.assertTrue(manageRolesPage.isRoleTitleLabelPresent());
			Assert.assertTrue(manageRolesPage.isRoleTitlefieldPresent());
			Assert.assertTrue(manageRolesPage.isRoleDescriptionLabelPresent());
			Assert.assertTrue(manageRolesPage.isRoleDescriptionfieldPresent());
			Assert.assertTrue(manageRolesPage.isCheckAllCheckBoxPresent());
			Assert.assertTrue(manageRolesPage.isCheckAllTextPresent());
			for (int i = 1; i <= 6; i++) {
				manageRolesPage.isAddRolePermissionHeaderPresent(i);
			}
			
			//Verify the dash board default permission 
			Assert.assertTrue(manageRolesPage.isManageDashboardPresence());
			Assert.assertTrue(manageRolesPage.isManageDashboardViewPresence());
			
			//verify the manage Live Tracking permission right 
			Assert.assertTrue(manageRolesPage.isManageLiveTrackingPresence());
			
			//verify the manage history permission right 
			Assert.assertTrue(manageRolesPage.isManageHistoryPresence());
			Assert.assertTrue(manageRolesPage.isManageHistoryExportCheckboxPresence(5));
			Assert.assertTrue(manageRolesPage.isManageHistoryViewCheckboxPresence(6));
			
			
			//verify the manage history permission right 
			Assert.assertTrue(manageRolesPage.isManageHistoryPresence());
			Assert.assertTrue(manageRolesPage.isManageHistoryExportCheckboxPresence(5));
			Assert.assertTrue(manageRolesPage.isManageHistoryViewCheckboxPresence(6));
			
			//verify the manage users permission right
			Assert.assertTrue(manageRolesPage.isManageUsersPresence());
			Assert.assertTrue(manageRolesPage.isManageUsersAddCheckboxPresence(2));
			Assert.assertTrue(manageRolesPage.isManageUsersUpdateCheckboxPresence(3));
			Assert.assertTrue(manageRolesPage.isManageUsersDeleteCheckboxPresence(4));
			Assert.assertTrue(manageRolesPage.isManageUsersViewCheckboxPresence(6));
			
			//verify the manage roles permission right
			Assert.assertTrue(manageRolesPage.isManageRolesPermissionPresence());
			Assert.assertTrue(manageRolesPage.isManageRolesCheckboxPresence(2));
			Assert.assertTrue(manageRolesPage.isManageRolesUpdateCheckboxPresence(3));
			Assert.assertTrue(manageRolesPage.isManageRolesDeleteCheckboxPresence(4));
			Assert.assertTrue(manageRolesPage.isManageRolesViewCheckboxPresence(6));
			
			//verify the manage global setting permission right
			Assert.assertTrue(manageRolesPage.isGlobalSettingPermissionPresence());
			
			//verify the manage email setting permission right
			Assert.assertTrue(manageRolesPage.isManageEmailSettingsboxPresence());
			Assert.assertTrue(manageRolesPage.isManageEmailSettingsUpdateCheckboxPresence(3));
			Assert.assertTrue(manageRolesPage.isManageEmailSettingsViewCheckboxPresence(6));
			Assert.assertTrue(reportsPage.isAddScheduleReportSaveBtnPresent());
			reportsPage.clickOnCancelButtonEmailOnDemands();

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to Verify the UI of 'Add Role' page" + UtilityMethods.getStackTrace());
			Assert.fail("Unable to Verify the UI of 'Add Role' page");
		}
	}

	@Test(priority = 3, description = "TC_ManageRoles_Add Role_004 Verify the Placeholder ")
	public void Verify_the_Placeholder() {

		try {
			log.info("************************* TC-04*************************");
			extentTest.setDescription("TC_ManageRoles_Add Role_004 Verify the Placeholder");
			manageRolesPage = new ManageRolesPage(getDriver());
			reportsPage = new ReportsPage(getDriver());
			manageRolesPage.clickOnManageRolesSidebar();
			manageRolesPage.clickOnAddRoleSideBar();
			Assert.assertTrue(manageRolesPage.isRoleTitlePlaceholderPresent());
			Assert.assertTrue(manageRolesPage.isRoleDescriptionPlaceholderPresent());
		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to Verify the Placeholder" + UtilityMethods.getStackTrace());
			Assert.fail("Unable to Verify the Placeholder ");
		}
	}

	@Test(priority = 2, description = "TC_ManageRoles_Add Role_005 Verify the validation message on mandatory fields  ")
	public void Verify_the_validation_message_on_mandatory_fields() {

		try {
			log.info("************************* TC-005*************************");
			extentTest.setDescription("TC_ManageRoles_Add Role_05 Verify the validation message on mandatory fields");
			manageRolesPage = new ManageRolesPage(getDriver());
			reportsPage = new ReportsPage(getDriver());
			manageRolesPage.clickOnManageRolesSidebar();
			manageRolesPage.clickOnAddRoleSideBar();
			reportsPage.clickOnSaveButton();
			assertEquals(manageRolesPage.getRoleTitleErrorMessage(), "Please Input Role Title"); //Error message is wrong display

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to Verify the validation message on mandatory fields" + UtilityMethods.getStackTrace());
			Assert.fail("Unable to Verify the validation message on mandatory fields");
		}
	}

	@Test(priority = 3, description = " TC_ManageRoles_AddRole_006 Verify the 'Add Role' functionality")
	public void Verify_the_Add_Role_functionality() {

		try {
			log.info("************************* TC-006*************************");
			extentTest.setDescription("TC_ManageRoles_Add Role_006 Verify the 'Add Role' functionality");
			manageRolesPage = new ManageRolesPage(getDriver());
			reportsPage = new ReportsPage(getDriver());
			manageRolesPage.clickOnManageRolesSidebar();
			manageRolesPage.clickOnAddRoleSideBar();
			manageRolesPage.enterRoleTitle("QA_Testing");
			manageRolesPage.enterRoleDescription("QA_Role_Description");
			manageRolesPage.checkAllCheckBox();
			reportsPage.clickOnSaveButton();
			Assert.assertEquals(manageRolesPage.roleAddedSuccessMessage(), "User role added successfully.");
			Assert.assertTrue(manageRolesPage.isAddedRolePresent());
			manageRolesPage.clickOnRoleDelete("QA_Testing");
			Assert.assertEquals(manageRolesPage.roleDeleteMessage(),"Role deleted successfully.");
			
		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to Verify the 'Add Role' functionality" + UtilityMethods.getStackTrace());
			Assert.fail("Unable to Verify the 'Add Role' functionality");
		}
	}

}
