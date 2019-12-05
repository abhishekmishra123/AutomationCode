package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import Common.BaseSetup;
import Common.UtilityMethods;
import PageObjects.AddVehiclesPage;
import PageObjects.LiveTrackingPage;
import PageObjects.LoginPage;

public class GroupListTest extends BaseSetup {

	LoginPage loginpage;
	AddVehiclesPage addvehiclesPage;
	LiveTrackingPage liveTrackingPage;
	static Logger Log = Logger.getLogger(GroupListTest.class);

	@Test(priority = 0, description = "Verify the 'Group list' Sidebar functionality and URL")
	public void Verify_the_Add_Vehicle_Sidebar_functionality_and_URL() {

		try {
			Log.info("************************* TC-024*************************");
			loginpage = new LoginPage(getDriver());
			loginpage.enterEmailAddess(config.getProperty("siteAdminEmail"));
			loginpage.enterPassword(config.getProperty("siteAdminPassword"));
			loginpage.clickOnLogInButton();
			addvehiclesPage = new AddVehiclesPage(getDriver());
			addvehiclesPage.clickOnManageVehiclesSideBar();
			addvehiclesPage.clickOnGroupListSideBar();
			String currentUrl = loginpage.getCurrentWebpageURL();
			Assert.assertTrue(currentUrl.contains("Manage_Vehicles/group_list"));
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Unable to Verify the 'Group List' Sidebar functionality and URL");
		}
	}

	@Test(priority = 1, description = "Verify the Home Link Path of Group list page")
	public void Verify_the_Home_Link_Path_of_vehiclesList_page() {

		try {
			Log.info("************************* TC-025*************************");
			liveTrackingPage = new LiveTrackingPage(getDriver());
//			loginpage = new LoginPage(getDriver());
//			loginpage.enterEmailAddess(config.getProperty("siteAdminEmail"));
//			loginpage.enterPassword(config.getProperty("siteAdminPassword"));
//			loginpage.clickOnLogInButton();
			addvehiclesPage = new AddVehiclesPage(getDriver());
			addvehiclesPage.clickOnManageVehiclesSideBar();
			addvehiclesPage.clickOnGroupListSideBar();
			liveTrackingPage.clickOnHomeLinkPath();
			String currentUrl = loginpage.getCurrentWebpageURL();
			Assert.assertTrue(currentUrl.contains("dashboard"));
			Assert.assertTrue(addvehiclesPage.isDashboardPagePresent());

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Unable to Verify the Home Link Path of Group list page");
		}
	}

	// This test case is used for Group List UI
	@Test(priority = 2, description = "Verify the UI of 'Group List' page")
	public void Verify_the_UI_of_Group_List() {

		try {
			Log.info("************************* TC-026*************************");
//			loginpage = new LoginPage(getDriver());
//			loginpage.enterEmailAddess(config.getProperty("siteAdminEmail"));
//			loginpage.enterPassword(config.getProperty("siteAdminPassword"));
//			loginpage.clickOnLogInButton();
			addvehiclesPage = new AddVehiclesPage(getDriver());
			addvehiclesPage.clickOnManageVehiclesSideBar();
			addvehiclesPage.clickOnGroupListSideBar();
			Assert.assertTrue(addvehiclesPage.isHomeLinkPresent());
			Assert.assertTrue(addvehiclesPage.isManageVehiclesLinkPresent());
			Assert.assertTrue(addvehiclesPage.isGroupLinkPathPresent());
			addvehiclesPage.clickOnGroupNameDropdownButton();

			for (int i = 1; i <= 2; i++) {
				Assert.assertTrue(addvehiclesPage.isselectVehicleNameDropdownOptionsPresent(i));
			}
			Assert.assertTrue(addvehiclesPage.isPageLimitPlaceholderPresent());
			Assert.assertTrue(addvehiclesPage.isSearchPlaceholderPresent());
			Assert.assertTrue(addvehiclesPage.isAddVehicleButtonPresent());
			for (int i = 1; i < 4; i++) {
				Assert.assertTrue(addvehiclesPage.isVehicleListHeadingNamePresent(i));
			}
			Assert.assertTrue(addvehiclesPage.isActionHeadingNamePresent());
			Assert.assertTrue(addvehiclesPage.isPaginationPresent());
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Unable to Verify the UI of 'Group  List' ");
		}
	}
  
	@Test(priority = 3, description = "Verify the Add vehicle Group button tool-tip and button functionality on Group list page")
	public void Verify_the_Add_vehicle_Group_tooltip_and_button_functionality_on_Group_list_page() {
		try {
			Log.info("************************* TC-027*************************");
			liveTrackingPage = new LiveTrackingPage(getDriver());
//			loginpage = new LoginPage(getDriver());
//			loginpage.enterEmailAddess(config.getProperty("siteAdminEmail"));
//			loginpage.enterPassword(config.getProperty("siteAdminPassword"));
//			loginpage.clickOnLogInButton();
			addvehiclesPage = new AddVehiclesPage(getDriver());
			addvehiclesPage.clickOnManageVehiclesSideBar();
			addvehiclesPage.clickOnGroupListSideBar();
			addvehiclesPage.addVehicleGroupToolTip();
			addvehiclesPage.clickOnAddVehicleGroupButton();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Unable to Verify the Add vehicle Group tool-tip and button functionality on Group list page");
		}
	}
    
	@Test(priority = 4, description = "verify the UI of add vehicle group popup")
	public void verify_the_UI_of_add_vehicle_group_popup() {
		try {
			Log.info("************************* TC-028*************************");
			liveTrackingPage = new LiveTrackingPage(getDriver());
//			loginpage = new LoginPage(getDriver());
//			loginpage.enterEmailAddess(config.getProperty("siteAdminEmail"));
//			loginpage.enterPassword(config.getProperty("siteAdminPassword"));
//			loginpage.clickOnLogInButton();
			addvehiclesPage = new AddVehiclesPage(getDriver());
			addvehiclesPage.clickOnManageVehiclesSideBar();
			addvehiclesPage.clickOnGroupListSideBar();
			addvehiclesPage.clickOnAddVehicleGroupButton();
			Assert.assertTrue(addvehiclesPage.isAddVehicleGroupHeadingNamePresent());
			Assert.assertTrue(addvehiclesPage.isCrossIconPresent());
			Assert.assertTrue(addvehiclesPage.isVehicleGroupNameLabelPresent());
			Assert.assertTrue(addvehiclesPage.isVehicleGroupDescriptionLabelPresent());
			Assert.assertTrue(addvehiclesPage.isCancelButtonPresent());
			Assert.assertTrue(addvehiclesPage.isSaveButtonPresent());
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Unable to verify the UI of add vehicle group popup");
		}
	}
	
	@Test(priority = 5, description = "Verify the placeholder of add vehicle group popup")
	public void Verify_the_placeholder_of_add_vehicle_group_popup() {
		try {
			Log.info("************************* TC-029*************************");
			liveTrackingPage = new LiveTrackingPage(getDriver());
//			loginpage = new LoginPage(getDriver());
//			loginpage.enterEmailAddess(config.getProperty("siteAdminEmail"));
//			loginpage.enterPassword(config.getProperty("siteAdminPassword"));
//			loginpage.clickOnLogInButton();
			addvehiclesPage = new AddVehiclesPage(getDriver());
			addvehiclesPage.clickOnManageVehiclesSideBar();
			addvehiclesPage.clickOnGroupListSideBar();
			addvehiclesPage.clickOnAddVehicleGroupButton();
			Assert.assertEquals(addvehiclesPage.getVechicleGroupNamePlaceholder(), "Enter Vehicle Group Name");
			Assert.assertEquals(addvehiclesPage.getVehicleGroupDescriptionPlaceholder(), "Enter Vehicle Group Description");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Unable to Verify the placeholder of add vehicle group popup");
		}
	}
	
	@Test(priority = 6, description = "Verify the validation message in 'add vehicle group' popup window")
	public void Verify_the_validation_message_in_add_vehicle_group_popup_window() {
		try {
			Log.info("************************* TC-030*************************");
			liveTrackingPage = new LiveTrackingPage(getDriver());
//			loginpage = new LoginPage(getDriver());
//			loginpage.enterEmailAddess(config.getProperty("siteAdminEmail"));
//			loginpage.enterPassword(config.getProperty("siteAdminPassword"));
//			loginpage.clickOnLogInButton();
			addvehiclesPage = new AddVehiclesPage(getDriver());
			addvehiclesPage.clickOnManageVehiclesSideBar();
			addvehiclesPage.clickOnGroupListSideBar();
			addvehiclesPage.clickOnAddVehicleGroupButton();
			addvehiclesPage.clickOnSaveButton();
			Assert.assertEquals(addvehiclesPage.getTextVehicleGroupNameValidationMessage(), "Please Input Vehicle Group Name");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Unable to Verify the validation message in 'add vehicle group' popup window");
		}
	}
	
	@Test(priority = 7, description = "Verify the Vehicle Group Name field if user enter an integer value")
	public void Verify_if_user_enter_an_integer_value_in_Vehicle_Group_Name_field() {
		try {
			Log.info("************************* TC-031*************************");
			liveTrackingPage = new LiveTrackingPage(getDriver());
//			loginpage = new LoginPage(getDriver());
//			loginpage.enterEmailAddess(config.getProperty("siteAdminEmail"));
//			loginpage.enterPassword(config.getProperty("siteAdminPassword"));
//			loginpage.clickOnLogInButton();
			addvehiclesPage = new AddVehiclesPage(getDriver());
			addvehiclesPage.clickOnManageVehiclesSideBar();
			addvehiclesPage.clickOnGroupListSideBar();
			addvehiclesPage.clickOnAddVehicleGroupButton();
			addvehiclesPage.vehicleGroupNameField("1233");
			Assert.assertEquals(addvehiclesPage.getAddVehicleGroupValidationMessage(), "Please Input Valid Group Name");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Unable to Verify if user enter an integer value in 'Vehicle Group Name' field");
		}
	}
	
	@Test(priority = 8, description = "Verify the 'Save' button functionality if user fill-up the add vehicle info ")
	public void Verify_the_Save_button_functionality_if_user_fillup_the_add_vehicle_info () {
		try {
			Log.info("************************* TC-032*************************");
			liveTrackingPage = new LiveTrackingPage(getDriver());
//			loginpage = new LoginPage(getDriver());
//			loginpage.enterEmailAddess(config.getProperty("siteAdminEmail"));
//			loginpage.enterPassword(config.getProperty("siteAdminPassword"));
//			loginpage.clickOnLogInButton();
			addvehiclesPage = new AddVehiclesPage(getDriver());
			addvehiclesPage.clickOnManageVehiclesSideBar();
			addvehiclesPage.clickOnGroupListSideBar();
			addvehiclesPage.clickOnAddVehicleGroupButton();
			addvehiclesPage.addVehicleGroupDetails("Vehicle 02", "Testing purpose");
			addvehiclesPage.clickOnSaveButton();
			Assert.assertEquals(addvehiclesPage.getTextAddVehicleGroupAddedSuccessfullyMessage(), "Vehicle group added successfully.");
			driver.navigate().refresh();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Unable to Verify the 'Save' button functionality if user fill-up the add vehicle info ");
		}
	}
	
	@Test(priority = 9, description = "Verify the data in Group list table on Group list page")
	public void Verify_the_data_in_Group_list_table_on_Group_listpage() {
		try {
			Log.info("************************* TC-033*************************");
			liveTrackingPage = new LiveTrackingPage(getDriver());
//			loginpage = new LoginPage(getDriver());
//			loginpage.enterEmailAddess(config.getProperty("siteAdminEmail"));
//			loginpage.enterPassword(config.getProperty("siteAdminPassword"));
//			loginpage.clickOnLogInButton();
			addvehiclesPage = new AddVehiclesPage(getDriver());
			addvehiclesPage.clickOnManageVehiclesSideBar();
			addvehiclesPage.clickOnGroupListSideBar();
			Assert.assertEquals(addvehiclesPage.getTextGroupListData(), "Vehicle 02");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Unable to Verify the data in Group list table on Group list page");
		}
	}
	
	
	@Test(priority = 10, description = "Verify the same data fill in vehicle group name field")
	public void Verify_the_same_data_fill_in_vehicle_group_name_field() {
		try {
			Log.info("************************* TC-034*************************");
			liveTrackingPage = new LiveTrackingPage(getDriver());
//			loginpage = new LoginPage(getDriver());
//			loginpage.enterEmailAddess(config.getProperty("siteAdminEmail"));
//			loginpage.enterPassword(config.getProperty("siteAdminPassword"));
//			loginpage.clickOnLogInButton();
			addvehiclesPage = new AddVehiclesPage(getDriver());
			addvehiclesPage.clickOnManageVehiclesSideBar();
			addvehiclesPage.clickOnGroupListSideBar();
			addvehiclesPage.clickOnAddVehicleGroupButton();
			addvehiclesPage.addVehicleGroupDetails("Vehicle 02", "Testing purpose");
			addvehiclesPage.clickOnSaveButton();
			Assert.assertEquals(addvehiclesPage.getTextVehicleGroupNamevalidationMessage(), "Vehicle group name already exists.");
			driver.navigate().refresh();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Unable to Verify the same data fill in vehicle group name field");
		}
	}
	
	@Test(priority = 11, description = "Verify the Cancel button functionality")
	public void Verify_the_Cancel_button_functionality() {
		try {
			Log.info("************************* TC-035*************************");
			liveTrackingPage = new LiveTrackingPage(getDriver());
//			loginpage = new LoginPage(getDriver());
//			loginpage.enterEmailAddess(config.getProperty("siteAdminEmail"));
//			loginpage.enterPassword(config.getProperty("siteAdminPassword"));
//			loginpage.clickOnLogInButton();
			addvehiclesPage = new AddVehiclesPage(getDriver());
			addvehiclesPage.clickOnManageVehiclesSideBar();
			addvehiclesPage.clickOnGroupListSideBar();
			addvehiclesPage.clickOnAddVehicleGroupButton();
			addvehiclesPage.clickOnCancelButton();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Unable to Verify the Cancel button functionality");
		}
	} 
	
	@Test(priority = 12, description = "Verify the 'cross' (×) button functionality")
	public void Verify_the_cross_button_functionality() {
		try {
			Log.info("************************* TC-036*************************");
			liveTrackingPage = new LiveTrackingPage(getDriver());
//			loginpage = new LoginPage(getDriver());
//			loginpage.enterEmailAddess(config.getProperty("siteAdminEmail"));
//			loginpage.enterPassword(config.getProperty("siteAdminPassword"));
//			loginpage.clickOnLogInButton();
			addvehiclesPage = new AddVehiclesPage(getDriver());
			addvehiclesPage.clickOnManageVehiclesSideBar();
			addvehiclesPage.clickOnGroupListSideBar();
			addvehiclesPage.clickOnAddVehicleGroupButton();
			// use for group list module
			liveTrackingPage.clickOnCrossIcon();
		
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Unable to Verify the 'cross' (×) button functionality");
		}
	} 
	
	@Test(priority = 13, description = "Verify the click on outside of popup")
	public void Verify_the_click_on_outside_of_popup() {
		try {
			Log.info("************************* TC-037*************************");
			liveTrackingPage = new LiveTrackingPage(getDriver());
//			loginpage = new LoginPage(getDriver());
//			loginpage.enterEmailAddess(config.getProperty("siteAdminEmail"));
//			loginpage.enterPassword(config.getProperty("siteAdminPassword"));
//			loginpage.clickOnLogInButton();
			addvehiclesPage = new AddVehiclesPage(getDriver());
			addvehiclesPage.clickOnManageVehiclesSideBar();
			addvehiclesPage.clickOnGroupListSideBar();
			addvehiclesPage.clickOnAddVehicleGroupButton();
			liveTrackingPage.clickOnOutSideDialogBox();
		
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Unable to Verify the click on outside of popup");
		}
	} 

	@Test(priority = 14, description = "Verify tooltip of edit button and functionality of 'Group List' page ")
	public void Verify_tooltip_of_edit_button_and_functionality_of_Group_List_page () {
		try {
			Log.info("************************* TC-038*************************");
//			liveTrackingPage = new LiveTrackingPage(getDriver());
//			loginpage = new LoginPage(getDriver());
//			loginpage.enterEmailAddess(config.getProperty("siteAdminEmail"));
//			loginpage.enterPassword(config.getProperty("siteAdminPassword"));
//			loginpage.clickOnLogInButton();
			addvehiclesPage = new AddVehiclesPage(getDriver());
			addvehiclesPage.clickOnManageVehiclesSideBar();
			addvehiclesPage.clickOnGroupListSideBar();
			//addvehiclesPage.editToolTip();
			addvehiclesPage.clickOnEditButton();
			addvehiclesPage.groupListEdit("Vehicle QA");
			addvehiclesPage.clickOnUpdateBtnGroupList();
			Assert.assertTrue(addvehiclesPage.isGroupListUpdatedSuccessfullyMessagePresent());
			driver.navigate().refresh();

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Unable to Verify tooltip of edit button and functionality of 'Group List' page ");
		}
	}
	

	@Test(priority = 15, description = "Verify the search functionality with valid data")
	public void Verify_the_search_functionality_with_valid_data() {
		try {
			Log.info("************************* TC-039*************************");
			liveTrackingPage = new LiveTrackingPage(getDriver());
//			loginpage = new LoginPage(getDriver());
//			loginpage.enterEmailAddess(config.getProperty("siteAdminEmail"));
//			loginpage.enterPassword(config.getProperty("siteAdminPassword"));
//			loginpage.clickOnLogInButton();
			addvehiclesPage = new AddVehiclesPage(getDriver());
			addvehiclesPage.clickOnManageVehiclesSideBar();
			addvehiclesPage.clickOnGroupListSideBar();
			addvehiclesPage.searchVehicle("Vehicle QA");
			addvehiclesPage.clickOnVehicleNameDropdownButton();
			addvehiclesPage.selectVehicleNameDropdownOption(2);
			addvehiclesPage.searchVehicle("Checking");
		} catch (Exception e) {
			e.printStackTrace();
			Log.error("Unable To Verify  the search functionalitywith valid data" + UtilityMethods.getStackTrace());
			Assert.fail("Unable To Verify  the search functionalitywith valid data");
		}
	}
	
	@Test(priority = 16, description = "Verify the search functionality when user enter data first in search field")
	public void Verify_the_search_functionality_when_user_enter_data_first_in_search_field() {
		try {
			Log.info("************************* TC-040*************************");
			liveTrackingPage = new LiveTrackingPage(getDriver());
//			loginpage = new LoginPage(getDriver());
//			loginpage.enterEmailAddess(config.getProperty("siteAdminEmail"));
//			loginpage.enterPassword(config.getProperty("siteAdminPassword"));
//			loginpage.clickOnLogInButton();
			addvehiclesPage = new AddVehiclesPage(getDriver());
			addvehiclesPage.clickOnManageVehiclesSideBar();
			addvehiclesPage.clickOnGroupListSideBar();
			addvehiclesPage.searchVehicle("Vehicle QA");
			addvehiclesPage.clickOnVehicleNameDropdownButton();
			addvehiclesPage.selectVehicleNameDropdownOption(2);
			addvehiclesPage.searchVehicle("Testing purpose");
			addvehiclesPage.clickOnVehicleNameDropdownButton();
			addvehiclesPage.selectVehicleNameDropdownOption(2);
		} catch (Exception e) {
			e.printStackTrace();
			Log.error("Unable To Verify the search functionality when user enter data first in search field"
					+ UtilityMethods.getStackTrace());
			Assert.fail("Unable To Verify the search functionality when user enter data first in search field");
		}
	}
	
	@Test(priority = 17, description = "Verify the 'No' button functionality in delete popup on Group list")
	public void Verify_the_No_button_functionality_in_delete_popup_on_Group_list() {
		try {
			Log.info("************************* TC-041*************************");
			liveTrackingPage = new LiveTrackingPage(getDriver());
//			loginpage = new LoginPage(getDriver());
//			loginpage.enterEmailAddess(config.getProperty("siteAdminEmail"));
//			loginpage.enterPassword(config.getProperty("siteAdminPassword"));
//			loginpage.clickOnLogInButton();
			addvehiclesPage = new AddVehiclesPage(getDriver());
			addvehiclesPage.clickOnManageVehiclesSideBar();
			addvehiclesPage.clickOnGroupListSideBar();
			addvehiclesPage.clickOnDeleteButton();
			addvehiclesPage.clickOnNOButton();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Unable to Verify the 'No' button functionality in delete popup on Group list");
		}
	}

	@Test(priority = 18, description = "Verify the delete tool-tip and functionality on Group list page")
	public void Verify_the_delete_tooltip_and_functionality_on_Group_list_page() {
		try {
			Log.info("************************* TC-042*************************");
			liveTrackingPage = new LiveTrackingPage(getDriver());
//	    	loginpage = new LoginPage(getDriver());
//	    	loginpage.enterEmailAddess(config.getProperty("siteAdminEmail"));
//	    	loginpage.enterPassword(config.getProperty("siteAdminPassword"));
//		    loginpage.clickOnLogInButton();
			addvehiclesPage = new AddVehiclesPage(getDriver());
			addvehiclesPage.clickOnManageVehiclesSideBar();
			addvehiclesPage.clickOnGroupListSideBar();
			addvehiclesPage.deleteToolTip();
			addvehiclesPage.clickOnDeleteButton();
			addvehiclesPage.clickOnYesButton();
			String beforetext = "Vehicle group deleted successfully.";
			String aftertext = addvehiclesPage.getTextVehicleGroupDeletedSuccessfullyMessage();
			Assert.assertEquals(beforetext, aftertext);
			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Unable to Verify the delete tooltip and functionality on Group list page");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
