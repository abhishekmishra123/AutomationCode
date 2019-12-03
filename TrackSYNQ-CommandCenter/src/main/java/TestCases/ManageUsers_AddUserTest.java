package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import Common.BaseSetup;
import Common.UtilityMethods;
import PageObjects.DashboardPage;
import PageObjects.LiveTrackingPage;
import PageObjects.LoginPage;
import PageObjects.ManageRolesPage;
import PageObjects.ManageUsersPage;
import PageObjects.ReportsPage;
import java.util.Random;
import org.apache.log4j.Logger;


public class ManageUsers_AddUserTest extends BaseSetup {
	LoginPage loginPage;
	ManageUsersPage manageUsersPage;
	ReportsPage reportsPage;
	LiveTrackingPage liveTrackingPage;
	ManageRolesPage manageRolesPage;
	DashboardPage dashboardPage;
	
	
	Random randomGenerator = new Random();
	int randomInt = randomGenerator.nextInt(1000);

	static Logger log = Logger.getLogger(ManageUsers_AddUserTest.class);

	@Test(priority = 0, description = "TC_ManageUsers_001 Verify the 'Manage Users' Side bar functionality")
	public void Verify_the_Manage_Users_sidebar_functionality() {

		try {
			log.info("************************* TC-01*************************");
			extentTest.setDescription("TC_ManageRoles_001 Verify the 'Manage Users' Side bar functionality");
			manageUsersPage = new ManageUsersPage(getDriver());
			loginPage = new LoginPage(getDriver());
			loginPage.enterEmailAddess(config.getProperty("siteAdminEmail"));
			loginPage.enterPassword(config.getProperty("siteAdminPassword"));
			loginPage.clickOnLogInButton();
			manageUsersPage.clickOnManageUsersSidebar();
			Assert.assertTrue(manageUsersPage.isManageUsers_AddUserSidebarPresent());
			Assert.assertTrue(manageUsersPage.isManageUsers_UserListSidebarPresent());
			manageUsersPage.clickOnManageUsers_AddUserSidebar();
			String pageUrl = loginPage.getCurrentWebpageURL();
			if (pageUrl.contains("add_user")) { // Error = URL is contains 'Add'
				Assert.assertEquals(1, 1);
			} else {
				Assert.assertEquals(1, 0);
			}

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to Verify the 'Manage Users' sidebar functionality " + UtilityMethods.getStackTrace());
			Assert.fail("Unable to Verify the 'Manage Users' sidebar functionality ");
		}
	}

	@Test(priority = 1, description = "TC_ManageUsers_AddUser_002 Verify the Label text on 'Add User' page ")
	public void Verify_the_Label_text_on_Add_User_page() {

		try {
			log.info("************************* TC-02*************************");
			extentTest.setDescription("TC_ManageUsers_AddUser_002 Verify the Label text on 'Add User' page ");
			manageUsersPage = new ManageUsersPage(getDriver());
			reportsPage = new ReportsPage(getDriver());
			manageUsersPage.clickOnManageUsersSidebar();
			manageUsersPage.clickOnManageUsers_AddUserSidebar();
			Assert.assertTrue(manageUsersPage.isLabelFirstName_addUserPresent("First Name"));
			Assert.assertTrue(manageUsersPage.isLabelLastName_addUserPresent("Last Name"));
			Assert.assertTrue(manageUsersPage.isLabelCountryName_addUserPresent("Country Name"));
			Assert.assertTrue(manageUsersPage.isLabelPhoneNumber_addUserPresent("Phone Number"));
			Assert.assertTrue(manageUsersPage.isLabelEmail_addUserPresent("Email"));
			Assert.assertTrue(manageUsersPage.isLabelPassword_addUserPresent("Password"));
			Assert.assertTrue(manageUsersPage.isLabelConfirmPassword_addUserPresent("Confirm Password"));
			Assert.assertTrue(manageUsersPage.isLabelRole_addUserPresent("Role"));

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to Verify the Label text on 'Add User' page" + UtilityMethods.getStackTrace());
			Assert.fail("Unable to Verify the Label text on 'Add User' page ");
		}
	}

	@Test(priority = 2, description = "TC_ManageUsers_AddUser_003 Verify the 'UI' (Fields) of 'Add User' ")
	public void Verify_the_UI_Fields_of_Add_User() {

		try {
			log.info("************************* TC-03*************************");
			extentTest.setDescription("TC_ManageUsers_AddUser_003 Verify the 'UI' (Fields) of 'Add User' ");
			manageUsersPage = new ManageUsersPage(getDriver());
			reportsPage = new ReportsPage(getDriver());
			manageUsersPage.clickOnManageUsersSidebar();
			manageUsersPage.clickOnManageUsers_AddUserSidebar();
			Assert.assertTrue(reportsPage.isReportHomeLinkPresent());
			Assert.assertTrue(manageUsersPage.isManageUserPathLinkPresent());
			Assert.assertTrue(manageUsersPage.isAddUserPathLinkPresent());
			Assert.assertEquals(reportsPage.getCssValueReportsLogsTitle(), "rgba(2, 192, 245, 1)");
			Assert.assertTrue(manageUsersPage.isFirstNameField_addUserPresent());
			Assert.assertTrue(manageUsersPage.isLastNameField_addUserPresent());
			Assert.assertTrue(manageUsersPage.isCountryNamefields_addUserPresent());
			Assert.assertTrue(manageUsersPage.isPhoneNumberField_addUserPresent());
			Assert.assertTrue(manageUsersPage.isEmailField_addUserPresent());
			Assert.assertTrue(manageUsersPage.isPasswordField_addUserPresent());
			Assert.assertTrue(manageUsersPage.isConfirmPasswordField_addUserPresent());
			Assert.assertTrue(manageUsersPage.isRolefield_addUserField_addUserPresent());

			// Verify the save/Cancel button
			Assert.assertTrue(reportsPage.isCancelButtonPresent());
			Assert.assertTrue(reportsPage.isAddScheduleReportSaveBtnPresent());

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to Verify the 'UI' (Fields) of 'Add User' " + UtilityMethods.getStackTrace());
			Assert.fail("Unable to Verify the 'UI' (Fields) of 'Add User' ");
		}
	}

	@Test(priority = 3, description = "TC_ManageUsers_AddUser_004 Verify the 'Placeholder' of all fields on 'Add User' page  ")
	public void Verify_the_Placeholder_of_all_fields_on_Add_User_page() {

		try {
			log.info("************************* TC-04*************************");
			extentTest.setDescription(
					"TC_ManageUsers_AddUser_004 Verify the 'Placeholder' of all fields on 'create new user' page ");
			manageUsersPage = new ManageUsersPage(getDriver());
			reportsPage = new ReportsPage(getDriver());
			manageUsersPage.clickOnManageUsersSidebar();
			manageUsersPage.clickOnManageUsers_AddUserSidebar();
			String firstNamePlaceholder = manageUsersPage.isFirstNameFieldPlaceholderPresent();
			Assert.assertEquals(firstNamePlaceholder, "Enter First Name");
			String lastNamePlaceholder = manageUsersPage.isLastNameFieldPlaceholderPresent();
			Assert.assertEquals(lastNamePlaceholder, "Enter Last Name");
			String countryNamePlaceholder = manageUsersPage.isCountryNameFieldPlaceholderPresent();
			Assert.assertEquals(countryNamePlaceholder, "Select Country Name");
			String phoneNumberPlaceholder = manageUsersPage.isPhoneNumberFieldPlaceholderPresent();
			Assert.assertEquals(phoneNumberPlaceholder, "Enter Phone Number");
			String emailPlaceholder = manageUsersPage.isEmailFieldPlaceholderPresent();
			Assert.assertEquals(emailPlaceholder, "Enter Email ID");
			String passwordPlaceholder = manageUsersPage.isPasswordFieldPlaceholderPresent();
			Assert.assertEquals(passwordPlaceholder, "Enter User Password");
			String confirmPasswordPlaceholder = manageUsersPage.isConfirmPasswordFieldPlaceholderPresent();
			Assert.assertEquals(confirmPasswordPlaceholder, "Enter User Confirm Password");
			String rolePlaceholder = manageUsersPage.isRoleFieldPlaceholderPresent();
			Assert.assertEquals(rolePlaceholder, "Select Role");

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to Verify the 'Placeholder' of all fields on 'Add User' page "
					+ UtilityMethods.getStackTrace());
			Assert.fail("Unable to Verify the 'Placeholder' of all fields on 'Add User' page ");
		}
	}

	@Test(priority = 4, description = "TC_ManageUsers_AddUser_005 Verify the validation message on 'Add User' page")
	public void Verify_the_validation_message_on_Add_User_page() {

		try {
			log.info("************************* TC-005*************************");
			extentTest.setDescription("TC_ManageUsers_AddUser_005 Verify the validation message on 'Add User' page");
			manageUsersPage = new ManageUsersPage(getDriver());
			reportsPage = new ReportsPage(getDriver());
			manageUsersPage.clickOnManageUsersSidebar();
			manageUsersPage.clickOnManageUsers_AddUserSidebar();
			reportsPage.clickOnSaveButton();
			Assert.assertEquals(manageUsersPage.isFirstNameErrorMessagePresent(), 
					"Please Input First Name"); // Enter should be replace by Input
			Assert.assertEquals(manageUsersPage.isLastNameErrorMessagePresent(), 
					"Please Input Last Name"); // Enter should be replace by 'Input'
			Assert.assertEquals(manageUsersPage.isCountryNameErrorMessagePresent(), 
					"Please Select Country Name");
			Assert.assertEquals(manageUsersPage.isPhoneNumberErrorMessagePresent(),
					"Please Input Correct Phone Number"); // Enter should be replace by 'Input'
			Assert.assertEquals(manageUsersPage.isEmailAddressErrorMessagePresent(), "Please Input Email ID");
			Assert.assertEquals(manageUsersPage.isPasswordErrorMessagePresent(), "Please Input User Password");
			Assert.assertEquals(manageUsersPage.isConfirmPasswordErrorMessagePresent(),
					"Please Input User Confirm Password");
			Assert.assertEquals(manageUsersPage.isRoleErrorMessagePresent(), "Please Select Role");

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to Verify the validation message on 'Add User' page" + UtilityMethods.getStackTrace());
			Assert.fail("Unable to Verify the validation message on 'Add User' page");
		}
	}

	@Test(priority = 5, description = "TC_ManageUsers_AddUser_006 Verify the 'Home' path link on 'Add User' page")
	public void Verify_the_Home_path_link_on_Add_User_page() {

		try {
			log.info("************************* TC-006*************************");
			extentTest.setDescription("TC_ManageUsers_AddUser_006 Verify the 'Home' path link on 'Add User' page");
			manageUsersPage = new ManageUsersPage(getDriver());
			liveTrackingPage = new LiveTrackingPage(getDriver());
			reportsPage = new ReportsPage(getDriver());
			manageUsersPage.clickOnManageUsersSidebar();
			manageUsersPage.clickOnManageUsers_AddUserSidebar();
			liveTrackingPage.clickOnHomeLinkPath();
			String pageUrl = loginPage.getCurrentWebpageURL();
			if (pageUrl.contains("dashboard")) {
				Assert.assertEquals(1, 1);
			} else {
				Assert.assertEquals(1, 0);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to Verify the 'Home' path link on 'Add User' page" + UtilityMethods.getStackTrace());
			Assert.fail("Unable to Verify the 'Home' path link on 'Add User' page");
		}
	}

	@Test(priority = 6, description = "TC_ManageUsers_AddUser_007 Verify the 'Manage' path link on 'Add User' page")
	public void Verify_the_manage_path_link_on_Add_User_page() {

		try {
			log.info("************************* TC-007*************************");
			extentTest.setDescription("TC_ManageUsers_AddUser_007 Verify the 'Manage' path link on 'Add User' page");
			manageUsersPage = new ManageUsersPage(getDriver());
			liveTrackingPage = new LiveTrackingPage(getDriver());
			reportsPage = new ReportsPage(getDriver());
			manageUsersPage.clickOnManageUsersSidebar();
			manageUsersPage.clickOnManageUsers_AddUserSidebar();
			manageUsersPage.clickOnManageUserPathLink();
			String pageUrl = loginPage.getCurrentWebpageURL();
			if (pageUrl.contains("user_list")) { // Error = URL is contains 'manage_users/user_list'
				Assert.assertEquals(1, 1);
			} else {
				Assert.assertEquals(1, 0);
			}

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to Verify the 'Manage' path link on 'Add User' page" + UtilityMethods.getStackTrace());
			Assert.fail("Unable to Verify the 'Manage' path link on 'Add User' page");
		}
	}

	@Test(priority = 6, description = "TC_ManageUsers_AddUser_008 Verify the first name and last name fields if User enter number")
	public void Verify_the_first_name_and_last_name_fields_if_User_enter_number() {

		try {
			log.info("************************* TC-008*************************");
			extentTest.setDescription(
					"TC_ManageUsers_AddUser_008 Verify the first name and last name fields if User enter number");
			manageUsersPage = new ManageUsersPage(getDriver());
			liveTrackingPage = new LiveTrackingPage(getDriver());
			reportsPage = new ReportsPage(getDriver());
			manageUsersPage.clickOnManageUsersSidebar();
			manageUsersPage.clickOnManageUsers_AddUserSidebar();
			manageUsersPage.enterUserDetails("78686723423", "78236782234", manageUsersPage.generateRandomNumber(10),
					"JohsonKing" + randomInt + "@gmail.com", "123456", "123456");
			Assert.assertEquals(manageUsersPage.enterNumbersFirstNameErrorMessagePresent(), "Please Input Valid Name"); // enter// replace// by Input and first letter should be capital in error message
			Assert.assertEquals(manageUsersPage.enterNumberLastNameErrorMessagePresent(), "Please Input Valid Name"); // enter replace by Input and first letter should be capital in error message

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to Verify the first name and last name fields if User enter number"
					+ UtilityMethods.getStackTrace());
			Assert.fail("Unable to Verify the first name and last name fields if User enter number");
		}
	}
	
	@Test(priority = 6, description = "TC_ManageUsers_AddUser_008 Verify passowrd and confirm password are different")
	public void Verify_passowrd_and_confirm_password_are_different() {

		try {
			log.info("************************* TC-008*************************");
			extentTest.setDescription(
					"TC_ManageUsers_AddUser_008 Verify the first name and last name fields if User enter number");
			manageUsersPage = new ManageUsersPage(getDriver());
			liveTrackingPage = new LiveTrackingPage(getDriver());
			reportsPage = new ReportsPage(getDriver());
			manageUsersPage.clickOnManageUsersSidebar();
			manageUsersPage.clickOnManageUsers_AddUserSidebar();
			manageUsersPage.enterUserDetails("78686723423", "78236782234", manageUsersPage.generateRandomNumber(10),
					"JohsonKing" + randomInt + "@gmail.com", "123456", "12345678");
			Assert.assertEquals(manageUsersPage.enterPasswordAndConfirmErrorMessagePresent(), "Confirm password mismatch"); // Password and confirm password error message should be change

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to Verify the first name and last name fields if User enter number"
					+ UtilityMethods.getStackTrace());
			Assert.fail("Unable to Verify the first name and last name fields if User enter number");
		}
	}
	
	
	@Test(priority = 6, description = "TC_ManageUsers_AddUser_009 Verify the phone number should not accept less than 10 and more than 10 ")
	public void Verify_the_phone_number_should_not_accept_less_than_10_and_more_than_10() {

		try {
			log.info("************************* TC-009*************************");
			extentTest.setDescription(
					"TC_ManageUsers_AddUser_009 Verify the phone number should not accept less than 10 and more than 10 ");
			manageUsersPage = new ManageUsersPage(getDriver());
			liveTrackingPage = new LiveTrackingPage(getDriver());
			reportsPage = new ReportsPage(getDriver());
			manageUsersPage.clickOnManageUsersSidebar();
			manageUsersPage.clickOnManageUsers_AddUserSidebar();
			manageUsersPage.enterUserDetails("John", "King", manageUsersPage.generateRandomNumber(3),
					"JohsonKing" + randomInt + "@gmail.com", "123456", "123456");
			Assert.assertEquals(manageUsersPage.enterLessThan10NumberErrorMessagePresent(),
					"Please Input A Valid 10-Digit Number."); // enter replace by Input and first letter should be
			
		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to Verify the phone number should not accept less than 10 and more than 10 "
					+ UtilityMethods.getStackTrace());
			Assert.fail("Unable to Verify the phone number should not accept less than 10 and more than 10 ");
		}
	}

	@Test(priority = 6, description = "TTC_ManageUsers_AddUser_010 Verify the email field if enter invalid email ")
	public void Verify_the_email_field_if_enter_invalid_email() {

		try {
			log.info("************************* TC-010*************************");
			extentTest.setDescription("TC_ManageUsers_AddUser_010 Verify the email field if enter invalid email");
			manageUsersPage = new ManageUsersPage(getDriver());
			liveTrackingPage = new LiveTrackingPage(getDriver());
			reportsPage = new ReportsPage(getDriver());
			manageUsersPage.clickOnManageUsersSidebar();
			manageUsersPage.clickOnManageUsers_AddUserSidebar();
			manageUsersPage.enterUserDetails("John", "King", manageUsersPage.generateRandomNumber(3),
					"JohsonKing" + randomInt + "@gmail.commmmmmm", "123456", "123456");
			Assert.assertEquals(manageUsersPage.enterWrongEmailAddressErrorMessagePresent(),
					"This is not a valid email ID"); // enter replace by Input and first letter should be capital in
														// error message

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to Verify the email field if enter invalid email " + UtilityMethods.getStackTrace());
			Assert.fail("Unable to Verify the email field if enter invalid email");
		}
	}

	@Test(priority = 6, description = "TC_ManageUsers_AddUser_011 Verify the cancel button functionality ")
	public void Verify_the_cancel_button_functionality() {

		try {
			log.info("************************* TC-011*************************");
			extentTest.setDescription("TC_ManageUsers_AddUser_011 Verify the email field if enter invalid email");
			manageUsersPage = new ManageUsersPage(getDriver());
			liveTrackingPage = new LiveTrackingPage(getDriver());
			reportsPage = new ReportsPage(getDriver());
			manageUsersPage.clickOnManageUsersSidebar();
			manageUsersPage.clickOnManageUsers_AddUserSidebar();
			reportsPage.clickOnCancelButtonEmailOnDemands();
			String pageUrl = loginPage.getCurrentWebpageURL();
			Assert.assertTrue(pageUrl.contains("user_list")); //list should be replace by user list in URL

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to Verify the cancel button functionality " + UtilityMethods.getStackTrace());
			Assert.fail("Unable to Verify the cancel button functionality");
		}
	}

	@Test(priority = 7, description = " TC_ManageUsers_AddUser_012 Verify the save button functionality If user enter valid data ")
	public void Verify_the_save_button_functionality_if_user_enter_valid_data() {

		try {
			log.info("************************* TC-006*************************");
			extentTest.setDescription("TC_ManageRoles_AddUser_006 Verify the save button functionality If user enter valid data ");
			manageUsersPage = new ManageUsersPage(getDriver());
			manageRolesPage = new ManageRolesPage(getDriver());
			dashboardPage = new DashboardPage(getDriver());
			reportsPage = new ReportsPage(getDriver());
			manageUsersPage.clickOnManageUsersSidebar();
			manageUsersPage.clickOnManageUsers_AddUserSidebar();
			manageUsersPage.enterUserDetails("Johson", "King", manageUsersPage.generateRandomNumber(10),
					"JohsonKing" + randomInt + "@gmail.com", "123456", "123456");
			manageUsersPage.select_Country();
			manageUsersPage.select_Role();
			reportsPage.clickOnSaveButton();
			Assert.assertEquals(manageRolesPage.userAddedSuccessMessage(), "User created successfully.");
			String emailText = manageUsersPage.getEmailText();
			loginPage.clickOnUserProfile();
			loginPage.clickOnLogOutButton();
			loginPage.enterEmailAddess(emailText);
			loginPage.enterPassword("123456");
			loginPage.clickOnLogInButton();
			for (int i = 1; i <= 17; i++) {
				if (i == 11) {
					continue;
				}
				Thread.sleep(2000);
				Assert.assertTrue(manageUsersPage.isSidebarMenuPresent(i));
			}
			loginPage.clickOnUserProfile();
			loginPage.clickOnLogOutButton();
			loginPage.enterEmailAddess(config.getProperty("siteAdminEmail"));
			loginPage.enterPassword(config.getProperty("siteAdminPassword"));
			loginPage.clickOnLogInButton();
			manageRolesPage.clickOnManageRolesSidebar();
			manageRolesPage.clickOnReportsManageRolesList();
			manageRolesPage.clickOnRoleEdit("QA_Testing1");
			manageRolesPage.clicOnDashboardCheckedCheckBox();
			for(int i=3;i<=36;i++) {
				manageRolesPage.clickOnManageSitesViewRights(i);
			}
			reportsPage.clickOnSaveButton();
			loginPage.clickOnUserProfile();
			loginPage.clickOnLogOutButton();
			loginPage.enterEmailAddess(emailText);
			loginPage.enterPassword("123456");
			loginPage.clickOnLogInButton();
			for (int i = 1; i <= 17; i++) {
				if (i == 11) {
					continue;
				}
				else if (i == 15) {
					continue;
				}
				Assert.assertFalse(manageUsersPage.isSidebarMenuPresent(i));
			}
			Assert.assertTrue(dashboardPage.isDashboardPermissionDeniedPresent());
			loginPage.clickOnUserProfile();
			loginPage.clickOnLogOutButton();
			loginPage.enterEmailAddess(config.getProperty("siteAdminEmail"));
			loginPage.enterPassword(config.getProperty("siteAdminPassword"));
			loginPage.clickOnLogInButton();
			manageRolesPage.clickOnManageRolesSidebar();
			manageRolesPage.clickOnReportsManageRolesList();
			manageRolesPage.clickOnRoleEdit("QA_Testing1");
			manageRolesPage.checkAllCheckBox();
			reportsPage.clickOnSaveButton();
			
			//Verify the added user should be deleted 
			manageUsersPage.clickOnManageUsersSidebar();
			manageUsersPage.clickOnManageUsers_UserListSidebar();
			manageUsersPage.clickOnUserDeleteBtn();
			Assert.assertEquals(manageUsersPage.userDeleteMessage(), "User deleted successfully.");
			
			//Verify the created role should be deleted 
			manageRolesPage.clickOnManageRolesSidebar();
			manageRolesPage.clickOnReportsManageRolesList();
			reportsPage.searchReport("QA_Testing1");
			Assert.assertTrue(reportsPage.isAddedRolePresent());
			manageRolesPage.clickOnRoleDelete("QA_Testing1");
			Assert.assertEquals(manageRolesPage.roleDeleteMessage(),"Role deleted successfully.");

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to Verify the save button functionality If user enter valid data " + UtilityMethods.getStackTrace());
			Assert.fail("Unable to Verify the save button functionality If user enter valid data ");
		}
	}

}
