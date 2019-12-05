package TestCases;


import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import Common.BaseSetup;
import Common.UtilityMethods;
import PageObjects.AddVehiclesPage;
import PageObjects.LiveTrackingPage;
import PageObjects.LoginPage;

public class VehicleListTest extends BaseSetup {

	LoginPage loginpage;
	AddVehiclesPage addvehiclesPage;
	LiveTrackingPage liveTrackingPage;
	static Logger Log = Logger.getLogger(VehicleListTest.class);

	@Test(priority = 0, description = "Verify the 'Vehicle list' Sidebar functionality and URL")
	public void Verify_the_Add_Vehicle_Sidebar_functionality_and_URL() {

		try {
			Log.info("************************* TC-011*************************");
			loginpage = new LoginPage(getDriver());
			loginpage.enterEmailAddess(config.getProperty("siteAdminEmail"));
			loginpage.enterPassword(config.getProperty("siteAdminPassword"));
			loginpage.clickOnLogInButton();
			addvehiclesPage = new AddVehiclesPage(getDriver());
			addvehiclesPage.clickOnManageVehiclesSideBar();
			addvehiclesPage.clickOnVehicleListSideBar();
			String currentUrl = loginpage.getCurrentWebpageURL();
			Assert.assertTrue(currentUrl.contains("Manage_Vehicles/Vehicles_List"));
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Unable to Verify the 'Add Vehicle' Sidebar functionality and URL");
		}
	}
	
	@Test(priority = 1, description = "Verify the Home Link Path of vehicles list page")
	public void Verify_the_Home_Link_Path_of_vehiclesList_page() {

		try {
			Log.info("************************* TC-012*************************");
			liveTrackingPage = new LiveTrackingPage(getDriver());
//			loginpage = new LoginPage(getDriver());
//			loginpage.enterEmailAddess(config.getProperty("siteAdminEmail"));
//			loginpage.enterPassword(config.getProperty("siteAdminPassword"));
//			loginpage.clickOnLogInButton();
			addvehiclesPage = new AddVehiclesPage(getDriver());
			addvehiclesPage.clickOnManageVehiclesSideBar();
			addvehiclesPage.clickOnVehicleListSideBar();
			liveTrackingPage.clickOnHomeLinkPath();
			String currentUrl = loginpage.getCurrentWebpageURL();
			Assert.assertTrue(currentUrl.contains("dashboard"));
			Assert.assertTrue(addvehiclesPage.isDashboardPagePresent());

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Unable to Verify the Home Link Path of vehicles list page");
		}
	}

	@Test(priority = 2, description = "Verify the 'UI' of vehicles list page")
	public void Verify_the_UI_of_vehicles_list_page() {

		try {
			Log.info("************************* TC-013*************************");
//			loginpage = new LoginPage(getDriver());
//			loginpage.enterEmailAddess(config.getProperty("siteAdminEmail"));
//			loginpage.enterPassword(config.getProperty("siteAdminPassword"));
//			loginpage.clickOnLogInButton();
			addvehiclesPage = new AddVehiclesPage(getDriver());
			addvehiclesPage.clickOnManageVehiclesSideBar();
			addvehiclesPage.clickOnVehicleListSideBar();
			Assert.assertTrue(addvehiclesPage.isHomeLinkPresent());
			Assert.assertTrue(addvehiclesPage.isManageVehiclesLinkPresent());
			Assert.assertTrue(addvehiclesPage.isVehicleListSideBarPresent());
			Assert.assertTrue(addvehiclesPage.isVehiclesListLinkPathPresent());
			addvehiclesPage.clickOnVehicleNameDropdownButton();

			for (int i = 1; i <= 4; i++) {
				Assert.assertTrue(addvehiclesPage.isselectVehicleNameDropdownOptionsPresent(i));
			}
			Assert.assertTrue(addvehiclesPage.isPageLimitPlaceholderPresent());
			Assert.assertTrue(addvehiclesPage.isSearchPlaceholderPresent());
			Assert.assertTrue(addvehiclesPage.isAddVehicleButtonPresent());
			for (int i = 1; i < 7; i++) {
				Assert.assertTrue(addvehiclesPage.isVehicleListHeadingNamePresent(i));
			}
			Assert.assertTrue(addvehiclesPage.isCommandHeadingNamePresent());
			Assert.assertTrue(addvehiclesPage.isGeoFenceNameHeadingNamePresent());
			Assert.assertTrue(addvehiclesPage.isActionHeadingNamePresent());
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Unable to Verify the 'UI' of vehicles list page");
		}
	}

	@Test(priority = 3, description = "Verify the search functionality when vehicle list empty")
	public void Verify_the_search_functionality_when_vehicle_list_empty() {
		try {
			Log.info("************************* TC-014*************************");
			liveTrackingPage = new LiveTrackingPage(getDriver());
//			loginpage = new LoginPage(getDriver());
//			loginpage.enterEmailAddess(config.getProperty("siteAdminEmail"));
//			loginpage.enterPassword(config.getProperty("siteAdminPassword"));
//			loginpage.clickOnLogInButton();
			addvehiclesPage = new AddVehiclesPage(getDriver());
			addvehiclesPage.clickOnManageVehiclesSideBar();
			addvehiclesPage.clickOnVehicleListSideBar();
			Assert.assertTrue(addvehiclesPage.isNoDatamessagePresent());
			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Unable to Verify the search functionality when vehicle list empty");
		}
	}

	@Test(priority = 4, description = "Verify the 'Add Vehicle' button functionality with valid data on add vehicle page")
	public void Verify_the_Save_button_functionality_on_Add_Vehicle_page() {
		try {
			Log.info("************************* TC-015*************************");
			liveTrackingPage = new LiveTrackingPage(getDriver());
//			loginpage = new LoginPage(getDriver());
//			loginpage.enterEmailAddess(config.getProperty("siteAdminEmail"));
//			loginpage.enterPassword(config.getProperty("siteAdminPassword"));
//			loginpage.clickOnLogInButton();
			addvehiclesPage = new AddVehiclesPage(getDriver());
			addvehiclesPage.clickOnManageVehiclesSideBar();
			addvehiclesPage.clickOnVehicleListSideBar();
			addvehiclesPage.addVehicleToolTip();
			addvehiclesPage.clickOnAddVehicleButton();
			liveTrackingPage.addVehiclesDetails("Vehicle QA", "12345", "1234567891", "Testing", "QA_Test");
			addvehiclesPage.selectMarkerImage();
			addvehiclesPage.addMarkerOkButton();
			String beforetext = "Vehicle Added successfully.";
			addvehiclesPage.addVehicleSaveButton();
			String aftertext = addvehiclesPage.getTextVehicleAddedSuccessfullyMessage();
			Assert.assertEquals(beforetext, aftertext);
			addvehiclesPage.clickOnAddVehicleButton();
			liveTrackingPage.addVehiclesDetails("Vehicle 01", "4567", "1234567823", "Testing", "QA_Test");
			addvehiclesPage.selectMarkerImage();
			addvehiclesPage.addMarkerOkButton();
			addvehiclesPage.addVehicleSaveButton();
			Assert.assertTrue(addvehiclesPage.isPaginationPresent());
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Unable to Verify the'Save' button functionality with valid data on add vehicle page");
		}
	}

	@Test(priority = 5, description = "Verify the data in vehicle list table on vehicle list page")
	public void Verify_the_data_in_vehicle_list_table_on_vehicle_list_page() {
		try {
			Log.info("************************* TC-016*************************");
			liveTrackingPage = new LiveTrackingPage(getDriver());
//			loginpage = new LoginPage(getDriver());
//			loginpage.enterEmailAddess(config.getProperty("siteAdminEmail"));
//			loginpage.enterPassword(config.getProperty("siteAdminPassword"));
//			loginpage.clickOnLogInButton();
			addvehiclesPage = new AddVehiclesPage(getDriver());
			addvehiclesPage.clickOnManageVehiclesSideBar();
			addvehiclesPage.clickOnVehicleListSideBar();
			Assert.assertEquals(addvehiclesPage.getTextVehicleListData(), "Vehicle QA");

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Unable to Verify the data in vehicle list table on vehicle list page");
		}
	}

	@Test(priority = 6, description = "Verify the edit tooltip and functionality on vehicle list page")
	public void Verify_the_edit_tooltip_and_functionality_on_vehicle_list_page() {
		try {
			Log.info("************************* TC-017*************************");
			liveTrackingPage = new LiveTrackingPage(getDriver());
//			loginpage = new LoginPage(getDriver());
//			loginpage.enterEmailAddess(config.getProperty("siteAdminEmail"));
//			loginpage.enterPassword(config.getProperty("siteAdminPassword"));
//			loginpage.clickOnLogInButton();
			addvehiclesPage = new AddVehiclesPage(getDriver());
			addvehiclesPage.clickOnManageVehiclesSideBar();
			addvehiclesPage.clickOnVehicleListSideBar();
			addvehiclesPage.editToolTip();
			addvehiclesPage.clickOnEditButton();
			liveTrackingPage.addVehiclesEdit("Vehicle 03");
			addvehiclesPage.clickOnUpdateButton();
			addvehiclesPage.getUpdatedSuccessfullyMessagePresent();
            Assert.assertEquals(addvehiclesPage.getUpdatedSuccessfullyMessagePresent(), "Vehicle Updated successfully.");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Unable to Verify the edit tooltip and functionality on vehicle list page");
		}
	}

	@Test(priority = 7, description = "Verify the cancel button functionality on vehicle list page")
	public void Verify_the_cancel_button_functionality_on_vehicle_list_page() {
		try {
			Log.info("************************* TC-018*************************");
			liveTrackingPage = new LiveTrackingPage(getDriver());
//			loginpage = new LoginPage(getDriver());
//			loginpage.enterEmailAddess(config.getProperty("siteAdminEmail"));
//			loginpage.enterPassword(config.getProperty("siteAdminPassword"));
//			loginpage.clickOnLogInButton();
			addvehiclesPage = new AddVehiclesPage(getDriver());
			addvehiclesPage.clickOnManageVehiclesSideBar();
			addvehiclesPage.clickOnVehicleListSideBar();
			addvehiclesPage.clickOnEditButton();
			addvehiclesPage.clickOnCancelButton();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Unable to Verify the cancel button functionality on vehicle list page");
		}
	}

	@Test(priority = 8, description = "Verify the search functionality with valid data")
	public void Verify_the_search_functionality() {
		try {
			Log.info("************************* TC-019*************************");
			liveTrackingPage = new LiveTrackingPage(getDriver());
//			loginpage = new LoginPage(getDriver());
//			loginpage.enterEmailAddess(config.getProperty("siteAdminEmail"));
//			loginpage.enterPassword(config.getProperty("siteAdminPassword"));
//			loginpage.clickOnLogInButton();
			addvehiclesPage = new AddVehiclesPage(getDriver());
			addvehiclesPage.clickOnManageVehiclesSideBar();
			addvehiclesPage.clickOnVehicleListSideBar();
			addvehiclesPage.searchVehicle("Vehicle 03");
			addvehiclesPage.clickOnVehicleNameDropdownButton();
			addvehiclesPage.selectVehicleNameDropdownOption(2);
			addvehiclesPage.searchVehicle("Default Group");
			addvehiclesPage.clickOnVehicleNameDropdownButton();
			addvehiclesPage.selectVehicleNameDropdownOption(3);
			addvehiclesPage.searchVehicle("Qa_devicetype");
			addvehiclesPage.clickOnVehicleNameDropdownButton();
			addvehiclesPage.selectVehicleNameDropdownOption(4);
			addvehiclesPage.searchVehicle("4567");
		} catch (Exception e) {
			e.printStackTrace();
			Log.error("Unable To Verify  the search functionality" + UtilityMethods.getStackTrace());
			Assert.fail("Unable To Verify  the search functionality");
		}
	}

	@Test(priority = 9, description = "Verify the search functionality when user enter data first in search field")
	public void Verify_the_search_functionality_when_user_enter_data_first_in_search_field() {
		try {
			Log.info("************************* TC-020*************************");
			liveTrackingPage = new LiveTrackingPage(getDriver());
//			loginpage = new LoginPage(getDriver());
//			loginpage.enterEmailAddess(config.getProperty("siteAdminEmail"));
//			loginpage.enterPassword(config.getProperty("siteAdminPassword"));
//			loginpage.clickOnLogInButton();
			addvehiclesPage = new AddVehiclesPage(getDriver());
			addvehiclesPage.clickOnManageVehiclesSideBar();
			addvehiclesPage.clickOnVehicleListSideBar();
			addvehiclesPage.searchVehicle("Vehicle 03");
			addvehiclesPage.clickOnVehicleNameDropdownButton();
			addvehiclesPage.selectVehicleNameDropdownOption(2);
			addvehiclesPage.searchVehicle("Default Group");
			addvehiclesPage.clickOnVehicleNameDropdownButton();
			addvehiclesPage.selectVehicleNameDropdownOption(2);
			addvehiclesPage.searchVehicle("Qa_devicetype");
			addvehiclesPage.clickOnVehicleNameDropdownButton();
			addvehiclesPage.selectVehicleNameDropdownOption(3);
			addvehiclesPage.searchVehicle("4567");
			addvehiclesPage.clickOnVehicleNameDropdownButton();
			addvehiclesPage.selectVehicleNameDropdownOption(4);

		} catch (Exception e) {
			e.printStackTrace();
			Log.error("Unable To Verify the search functionality when user enter data first in search field"
					+ UtilityMethods.getStackTrace());
			Assert.fail("Unable To Verify the search functionality when user enter data first in search field");
		}
	}

	@Test(priority = 10, description = "Verify the search functionality when user enter special character in search field")
	public void Verify_the_search_functionality_when_user_enter_special_character_in_search_field() {
		try {
			Log.info("************************* TC-021*************************");
			liveTrackingPage = new LiveTrackingPage(getDriver());
//			loginpage = new LoginPage(getDriver());
//			loginpage.enterEmailAddess(config.getProperty("siteAdminEmail"));
//			loginpage.enterPassword(config.getProperty("siteAdminPassword"));
//			loginpage.clickOnLogInButton();
			addvehiclesPage = new AddVehiclesPage(getDriver());
			addvehiclesPage.clickOnManageVehiclesSideBar();
			addvehiclesPage.clickOnVehicleListSideBar();
			addvehiclesPage.searchVehicle("%&&**");
			addvehiclesPage.clickOnTableHeading();
			Assert.assertFalse(addvehiclesPage.isVehicleHeadingListData());
		} catch (Exception e) {
			e.printStackTrace();
			Log.error("Unable To Verify the search functionality when user enter special character in search field"
					+ UtilityMethods.getStackTrace());
			Assert.fail("Unable To Verify the search functionality when user enter special character in search field");
		}
	}

	@Test(priority = 11, description = "Verify the 'No' button functionality in popup on vehicle list")
	public void Verify_the_NO_button_functionality_in_popup_on_vehicle_list() {
		try {
			Log.info("************************* TC-022*************************");
			liveTrackingPage = new LiveTrackingPage(getDriver());
//			loginpage = new LoginPage(getDriver());
//			loginpage.enterEmailAddess(config.getProperty("siteAdminEmail"));
//			loginpage.enterPassword(config.getProperty("siteAdminPassword"));
//			loginpage.clickOnLogInButton();
			addvehiclesPage = new AddVehiclesPage(getDriver());
			addvehiclesPage.clickOnManageVehiclesSideBar();
			addvehiclesPage.clickOnVehicleListSideBar();
			addvehiclesPage.clickOnDeleteButton();
			addvehiclesPage.clickOnNOButton();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Unable to Verify the 'No' button functionality in popup on vehicle list");
		}
	}

	@Test(priority = 12, description = "Verify the delete tool-tip and functionality on vehicle list page")
	public void Verify_the_delete_tooltip_and_functionality_on_vehicle_list_page() {
		try {
			Log.info("************************* TC-023*************************");
			liveTrackingPage = new LiveTrackingPage(getDriver());
////		loginpage = new LoginPage(getDriver());
////		loginpage.enterEmailAddess(config.getProperty("siteAdminEmail"));
////		loginpage.enterPassword(config.getProperty("siteAdminPassword"));
////		loginpage.clickOnLogInButton();
			addvehiclesPage = new AddVehiclesPage(getDriver());
			addvehiclesPage.clickOnManageVehiclesSideBar();
			addvehiclesPage.clickOnVehicleListSideBar();
			addvehiclesPage.deleteToolTip();
			addvehiclesPage.clickOnDeleteButton();
			addvehiclesPage.clickOnYesButton();
			String beforetext = "Vehicle deleted successfully.";
			String aftertext = addvehiclesPage.getTextVehicleDeletedSuccessfullyMessage();
			Assert.assertEquals(beforetext, aftertext);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Unable to Verify the delete tooltip and functionality on vehicle list page");
		}
	}

}
