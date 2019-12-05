package TestCases;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.logging.NeedsLocalLogs;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import Common.BaseSetup;
import PageObjects.AddVehiclesPage;
import PageObjects.LiveTrackingPage;
import PageObjects.LoginPage;

public class AddVehiclesTest extends BaseSetup {

	LoginPage loginpage;
	AddVehiclesPage addvehiclesPage;
	LiveTrackingPage liveTrackingPage;
	static Logger Log = Logger.getLogger(AddVehiclesTest.class);

	@Test(priority = 0, description = "Verify the 'Manage Vehicles' Sidebar functionality")
	public void Verify_the_Manage_Vehicles_Sidebar_functionality() {

		try {
			Log.info("************************* TC-01*************************");
			loginpage = new LoginPage(getDriver());
			loginpage.enterEmailAddess(config.getProperty("siteAdminEmail"));
			loginpage.enterPassword(config.getProperty("siteAdminPassword"));
			loginpage.clickOnLogInButton();
			addvehiclesPage = new AddVehiclesPage(getDriver());
			addvehiclesPage.clickOnManageVehiclesSideBar();
			Assert.assertTrue(addvehiclesPage.isGroupListSideBarPresent());
			Assert.assertTrue(addvehiclesPage.isVehicleListSideBarPresent());
			Assert.assertTrue(addvehiclesPage.isAddVehiclesSideBarPresent());
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Unable to Verify the 'Manage Vehicles' Sidebar functionality");
		}
	}
	
	@Test(priority = 1, description = "Verify the 'Add Vehicles' Sidebar functionality and URL")
	public void Verify_the_Add_Vehicles_Sidebar_functionality_and_URL() {

		try {
			Log.info("************************* TC-02*************************");
			
//			loginpage = new LoginPage(getDriver());
//			loginpage.enterEmailAddess(config.getProperty("siteAdminEmail"));
//			loginpage.enterPassword(config.getProperty("siteAdminPassword"));
//			loginpage.clickOnLogInButton();
			addvehiclesPage = new AddVehiclesPage(getDriver());
			addvehiclesPage.clickOnManageVehiclesSideBar();
			addvehiclesPage.clickOnAddVehiclesButton();
			String currentUrl = loginpage.getCurrentWebpageURL();
			Assert.assertTrue(currentUrl.contains("Manage_Vehicle/add_vehicle"));
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Unable to Verify the 'Add Vehicles' Sidebar functionality and URL");
		}

	}
	
	@Test(priority = 2, description = "Verify the Home Link Path of add vehicles page")	
 	public void Verify_the_Home_Link_Path_of_add_vehicles_page() {
	try {
		Log.info("************************* TC-03*************************");
		liveTrackingPage = new LiveTrackingPage(getDriver());
//		loginpage = new LoginPage(getDriver());
//		loginpage.enterEmailAddess(config.getProperty("siteAdminEmail"));
//		loginpage.enterPassword(config.getProperty("siteAdminPassword"));
//		loginpage.clickOnLogInButton();
		addvehiclesPage = new AddVehiclesPage(getDriver());
		addvehiclesPage.clickOnManageVehiclesSideBar();
		addvehiclesPage.clickOnAddVehiclesButton();
		liveTrackingPage.clickOnHomeLinkPath();
		String currentUrl = loginpage.getCurrentWebpageURL();
		Assert.assertTrue(currentUrl.contains("dashboard"));
		Assert.assertTrue(addvehiclesPage.isDashboardPagePresent());

	} catch (Exception e) {
		e.printStackTrace();
		Assert.fail("Unable to Verify the Home Link Path of add vehicles page");
	}
}
	
	@Test(priority = 3, description = "Verify the 'UI' of add vehicles page")
	public void Verify_the_UI_of_add_vehicles_page() {

		try {
			Log.info("************************* TC-04*************************");
//			loginpage = new LoginPage(getDriver());
//			loginpage.enterEmailAddess(config.getProperty("siteAdminEmail"));
//			loginpage.enterPassword(config.getProperty("siteAdminPassword"));
//			loginpage.clickOnLogInButton();
			addvehiclesPage = new AddVehiclesPage(getDriver());
			addvehiclesPage.clickOnManageVehiclesSideBar();
			addvehiclesPage.clickOnAddVehiclesButton();
			Assert.assertTrue(addvehiclesPage.isHomeLinkPresent());
			Assert.assertTrue(addvehiclesPage.isManageVehiclesLinkPresent());
			Assert.assertTrue(addvehiclesPage.isAddVehiclesLinkPresent());
			Assert.assertTrue(addvehiclesPage.isAddVehiclesHeadingPresent());
			Assert.assertTrue(addvehiclesPage.isVehicleNameLabelPresent());
			Assert.assertTrue(addvehiclesPage.isVehicleNameFieldPresent());
			Assert.assertTrue(addvehiclesPage.isDeviceTypeLabelPresent());
			Assert.assertTrue(addvehiclesPage.isDeviceTypeFieldPresent());
			Assert.assertTrue(addvehiclesPage.isDeviceIdentifierIMEINoLabelPresent());
			Assert.assertTrue(addvehiclesPage.isDeviceIdentifierIMEINoFieldPresent());
			Assert.assertTrue(addvehiclesPage.isVehicleGroupLabelPresent());
			Assert.assertTrue(addvehiclesPage.isVehiclesGroupFieldPresent());
			Assert.assertTrue(addvehiclesPage.isCountryNameLabelPresent());
			Assert.assertTrue(addvehiclesPage.isCountryNameFieldPresent());
			Assert.assertTrue(addvehiclesPage.isMobileNoLabelPresent());
			Assert.assertTrue(addvehiclesPage.isMobileNoFieldPresent());
			Assert.assertEquals(addvehiclesPage.getTextAccumulatorLabel(), "Accumulator"); // Display Accumulator spelling mistake
			Assert.assertTrue(addvehiclesPage.isAccumulatorFieldPresent());
			Assert.assertTrue(addvehiclesPage.isMarkerImageLabelPresent());
			Assert.assertTrue(addvehiclesPage.isUploadButtonPresent());
			Assert.assertTrue(addvehiclesPage.isVehicleDescriptionLabel());
			Assert.assertTrue(addvehiclesPage.isVehicleDescriptionFieldPresent());
			Assert.assertTrue(addvehiclesPage.isCancelButtonPresent());
			Assert.assertTrue(addvehiclesPage.isSaveButtonPresent());
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Unable to Verify the 'UI' of add vehicles page");
		}
	}

	@Test(priority = 4, description = "Verify the Placeholder of add vehicles page")
	public void Verify_the_Placeholder_of_add_vehicles_page() {

		try {
			Log.info("************************* TC-05*************************");
			liveTrackingPage = new LiveTrackingPage(getDriver());
//			loginpage = new LoginPage(getDriver());
//			loginpage.enterEmailAddess(config.getProperty("siteAdminEmail"));
//			loginpage.enterPassword(config.getProperty("siteAdminPassword"));
//			loginpage.clickOnLogInButton();
			addvehiclesPage = new AddVehiclesPage(getDriver());
			addvehiclesPage.clickOnManageVehiclesSideBar();
			addvehiclesPage.clickOnAddVehiclesButton();
			Assert.assertEquals(liveTrackingPage.getVechiclePlaceholder(), "Enter Vehicle Name");
			Assert.assertEquals(liveTrackingPage.getDeviceTypePlaceholder(), "Select Device Type");
			Assert.assertEquals(liveTrackingPage.getDeviceIdentifierPlaceholder(), "Enter Device IMEI Number"); // This test case is fail .... Identifier is missing
			Assert.assertEquals(liveTrackingPage.getVehicleGroupPlaceholder(), "Select Vehicle Group");
			Assert.assertEquals(liveTrackingPage.getCountryNamePlaceholder(), "Select Country Name");
			Assert.assertEquals(liveTrackingPage.getMobileNoPlaceholder(), "Enter Mobile Number");
			Assert.assertTrue(liveTrackingPage.isMarkerImage());
			Assert.assertEquals(liveTrackingPage.getAccumulatorPlaceholder(), "Enter Device Accumulator");
			Assert.assertEquals(liveTrackingPage.getVehicleDescriptionPlaceholder(), "Enter Vehicle Description");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Unable to Verify the Placeholder of add vehicles page");
		}
	}

	@Test(priority = 5, description = "Verify the validation message of add vehicles page")
	public void Verify_the_validation_message_of_add_vehicles_page() {

		try {
			Log.info("************************* TC-06*************************");
			liveTrackingPage = new LiveTrackingPage(getDriver());
//			loginpage = new LoginPage(getDriver());
//			loginpage.enterEmailAddess(config.getProperty("siteAdminEmail"));
//			loginpage.enterPassword(config.getProperty("siteAdminPassword"));
//			loginpage.clickOnLogInButton();
			addvehiclesPage = new AddVehiclesPage(getDriver());
			addvehiclesPage.clickOnManageVehiclesSideBar();
			addvehiclesPage.clickOnAddVehiclesButton();
			liveTrackingPage.clickOnSaveButton();
			Assert.assertEquals(liveTrackingPage.getTextVehicleName(), "Please Input Vehicle Name");
			Assert.assertEquals(liveTrackingPage.getTextDeviceType(), "Please Select Device Type");
			Assert.assertEquals(addvehiclesPage.getTextDeviceIdentifier(), "Please Input Correct Identifier or IMEI");
			Assert.assertEquals(liveTrackingPage.getTextVehicleGroup(), "Please Select Vehicle Group");
			Assert.assertEquals(liveTrackingPage.getTextCountryName(), "Please Select Country Name");
			Assert.assertEquals(liveTrackingPage.getTextMobileNo(), "Please Input Mobile Number");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Unable to Verify the validation message of add vehicles page");
		}
	}
	
	@Test(priority = 6, description = "Verify the 'Save' button functionality with valid data on add vehicle page")
	public void Verify_the_Save_button_functionality_on_Add_Vehicle_page() {
		try {
			Log.info("************************* TC-07*************************");
			liveTrackingPage = new LiveTrackingPage(getDriver());
//			loginpage = new LoginPage(getDriver());
//			loginpage.enterEmailAddess(config.getProperty("siteAdminEmail"));
//			loginpage.enterPassword(config.getProperty("siteAdminPassword"));
//			loginpage.clickOnLogInButton();
			addvehiclesPage = new AddVehiclesPage(getDriver());
			addvehiclesPage.clickOnManageVehiclesSideBar();
			addvehiclesPage.clickOnAddVehiclesButton();
			liveTrackingPage.addVehiclesDetails("Vehicle QA", "12345", "1234567891", "Testing", "QA_Test");
			addvehiclesPage.selectMarkerImage();
			addvehiclesPage.addMarkerOkButton();
			addvehiclesPage.addVehicleSaveButton();
			
			String beforetext = "Vehicle Added successfully.";
			String aftertext = addvehiclesPage.getTextVehicleAddedSuccessfullyMessage();
			Assert.assertEquals(beforetext,aftertext);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Unable to Verify the'Save' button functionality with valid data on add vehicle page");
		}
}
	@Test(priority = 7, description = "Verify the device type, IMEI No.and mobile number not match error message of add vehicles page")
	public void Verify_the_device_type_IMEI_No_and_mobile_number_not_match_error_message_of_add_vehicles_page() {
		try {
			Log.info("************************* TC-08*************************");
			liveTrackingPage = new LiveTrackingPage(getDriver());
//			loginpage = new LoginPage(getDriver());
//			loginpage.enterEmailAddess(config.getProperty("siteAdminEmail"));
//			loginpage.enterPassword(config.getProperty("siteAdminPassword"));
//			loginpage.clickOnLogInButton();
			addvehiclesPage = new AddVehiclesPage(getDriver());
			addvehiclesPage.clickOnManageVehiclesSideBar();
			addvehiclesPage.clickOnAddVehiclesButton();
			liveTrackingPage.addVehiclesDetails("Vehicle 02", "123456", "1234567890", "Testing", "QA_Test");
			addvehiclesPage.selectMarkerImage();
			addvehiclesPage.addMarkerOkButton();
			addvehiclesPage.addVehicleSaveButton();
			Assert.assertTrue(addvehiclesPage.isIMEINoMobileNoDeviceTypeErrorMessagePresent());
		
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Unable to Verify the device type, IMEI No.and mobile number not match error message of add vehicles page");
		}
	}		
	@Test(priority = 8, description = "Verify the 'device limit error message' of add vehicles page")
	public void Verify_the_device_limit_error_message_of_add_vehicles_page() {
		try {
			Log.info("************************* TC-09*************************");
			liveTrackingPage = new LiveTrackingPage(getDriver());
//			loginpage = new LoginPage(getDriver());
//			loginpage.enterEmailAddess(config.getProperty("siteAdminEmail"));
//			loginpage.enterPassword(config.getProperty("siteAdminPassword"));
//			loginpage.clickOnLogInButton();
			addvehiclesPage = new AddVehiclesPage(getDriver());
			addvehiclesPage.clickOnManageVehiclesSideBar();
			addvehiclesPage.clickOnAddVehiclesButton();
			liveTrackingPage.addVehiclesDetails("Vehicle test", "123", "1234567893", "Testing", "QA_Test");
			addvehiclesPage.selectMarkerImage();
			addvehiclesPage.addMarkerOkButton();
			addvehiclesPage.addVehicleSaveButton();
		    Assert.assertTrue(addvehiclesPage.isDeviceLimitExceedErrorMessagePresent());
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Unable to Verify the 'device limit error message' of add vehicles page");
		}
	}		

		@Test(priority = 9, description = "Verify the 'Vehicle list' Sidebar functionality and URL")
		public void Verify_the_Add_Vehicle_Sidebar_functionality_and_URL() {

			try {
				Log.info("************************* TC-010*************************");
//				loginpage = new LoginPage(getDriver());
//				loginpage.enterEmailAddess(config.getProperty("siteAdminEmail"));
//				loginpage.enterPassword(config.getProperty("siteAdminPassword"));
//				loginpage.clickOnLogInButton();
				addvehiclesPage = new AddVehiclesPage(getDriver());
				addvehiclesPage.clickOnManageVehiclesSideBar();
				addvehiclesPage.clickOnVehicleListSideBar();
				String currentUrl = loginpage.getCurrentWebpageURL();
				Assert.assertTrue(currentUrl.contains("Manage_Vehicles/Vehicles_List"));//Mismatch URL
			} catch (Exception e) {
				e.printStackTrace();
				Assert.fail("Unable to Verify the 'Add Vehicle' Sidebar functionality and URL");
			}
		}

		@Test(priority = 10, description = "Verify the 'UI' of vehicles list page")
		public void Verify_the_UI_of_vehicles_list_page() {

			try {
				Log.info("************************* TC-011*************************");
				loginpage = new LoginPage(getDriver());
//				loginpage.enterEmailAddess(config.getProperty("siteAdminEmail"));
//				loginpage.enterPassword(config.getProperty("siteAdminPassword"));
//				loginpage.clickOnLogInButton();
				addvehiclesPage = new AddVehiclesPage(getDriver());
				addvehiclesPage.clickOnManageVehiclesSideBar();
				addvehiclesPage.clickOnVehicleListSideBar();
				Assert.assertTrue(addvehiclesPage.isHomeLinkPresent());
				Assert.assertTrue(addvehiclesPage.isManageVehiclesLinkPresent());
				Assert.assertTrue(addvehiclesPage.isVehicleListSideBarPresent());
				Assert.assertTrue(addvehiclesPage.isVehiclesListLinkPathPresent());
				addvehiclesPage.clickOnVehicleNameDropdownButton();
				
				for (int i= 1; i<=4; i++) {
				Assert.assertTrue(addvehiclesPage.isselectVehicleNameDropdownOptionsPresent(i));
				}
				Assert.assertTrue(addvehiclesPage.isPageLimitPlaceholderPresent());
				Assert.assertTrue(addvehiclesPage.isSearchPlaceholderPresent());
				Assert.assertTrue(addvehiclesPage.isAddVehicleButtonPresent());
				for(int i=1; i<7; i++) {
				Assert.assertTrue(addvehiclesPage.isVehicleListHeadingNamePresent(i));
				}
     			Assert.assertTrue(addvehiclesPage.isCommandHeadingNamePresent());
            	Assert.assertTrue(addvehiclesPage.isGeoFenceNameHeadingNamePresent());
				Assert.assertTrue(addvehiclesPage.isActionHeadingNamePresent());
				Assert.assertTrue(addvehiclesPage.isEditButtonPresent());
				Assert.assertTrue(addvehiclesPage.isDeleteButtonPresent());
				Assert.assertTrue(addvehiclesPage.isPaginationPresent());
		    } catch (Exception e) {
				e.printStackTrace();
				Assert.fail("Unable to Verify the 'UI' of vehicles list page");
			}
		}
		@Test(priority = 11, description = "Verify the data in vehicle list table on vehicle page")
		public void Verify_the_data_in_vehicle_list_table_on_vehicle_page() {
			try {
				Log.info("************************* TC-012*************************");
				liveTrackingPage = new LiveTrackingPage(getDriver());
//				loginpage = new LoginPage(getDriver());
//				loginpage.enterEmailAddess(config.getProperty("siteAdminEmail"));
//				loginpage.enterPassword(config.getProperty("siteAdminPassword"));
//				loginpage.clickOnLogInButton();
				addvehiclesPage = new AddVehiclesPage(getDriver());
				addvehiclesPage.clickOnManageVehiclesSideBar();
				addvehiclesPage.clickonAddVehicleSideBar();
				Assert.assertEquals(addvehiclesPage.getTextVehicleListData(), "Vehicle QA");
				
			} catch (Exception e) {
				e.printStackTrace();
				Assert.fail("Unable to Verify the data in vehicle list table on vehicle page");
			}
		}		
		
		@Test(priority = 12, description = "Verify the edit tooltip and functionality on vehicle list page")
		public void Verify_the_edit_tooltip_and_functionality_on_vehicle_list_page() {
			try {
				Log.info("************************* TC-013*************************");
				liveTrackingPage = new LiveTrackingPage(getDriver());
//				loginpage = new LoginPage(getDriver());
//				loginpage.enterEmailAddess(config.getProperty("siteAdminEmail"));
//				loginpage.enterPassword(config.getProperty("siteAdminPassword"));
//				loginpage.clickOnLogInButton();
				addvehiclesPage = new AddVehiclesPage(getDriver());
				addvehiclesPage.clickOnManageVehiclesSideBar();
				addvehiclesPage.clickOnVehicleListSideBar();
				addvehiclesPage.editToolTip();
				addvehiclesPage.clickOnEditButton();
				liveTrackingPage.addVehiclesEdit("Vehicle 03");
			//	liveTrackingPage.vehicleName("Vehicle 03");
				Thread.sleep(SHORTWAIT);
				addvehiclesPage.clickOnUpdateButton();
				Thread.sleep(SHORTWAIT);
				Assert.assertEquals(addvehiclesPage.getUpdatedSuccessfullyMessagePresent(), "Vehicle Updated successfully.");
				
			} catch (Exception e) {
				e.printStackTrace();
				Assert.fail("Unable to Verify the edit tooltip and functionality on vehicle list page");
			}
		}		
	
		@Test(priority = 13, description = "Verify the cancel button functionality on vehicle list")
		public void Verify_the_cancel_button_functionality_on_vehicle_list_page() {
			try {
				Log.info("************************* TC-014*************************");
				liveTrackingPage = new LiveTrackingPage(getDriver());
//				loginpage = new LoginPage(getDriver());
//				loginpage.enterEmailAddess(config.getProperty("siteAdminEmail"));
//				loginpage.enterPassword(config.getProperty("siteAdminPassword"));
//				loginpage.clickOnLogInButton();
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
		@Test(priority = 14, description = "Verify the delete tooltip and functionality on vehicle list page")
		public void Verify_the_delete_tooltip_and_functionality_on_vehicle_list_page() {
			try {
				Log.info("************************* TC-015*************************");
				liveTrackingPage = new LiveTrackingPage(getDriver());
//				loginpage = new LoginPage(getDriver());
//				loginpage.enterEmailAddess(config.getProperty("siteAdminEmail"));
//				loginpage.enterPassword(config.getProperty("siteAdminPassword"));
//				loginpage.clickOnLogInButton();
				addvehiclesPage = new AddVehiclesPage(getDriver());
				addvehiclesPage.clickOnManageVehiclesSideBar();
				addvehiclesPage.clickOnVehicleListSideBar();
				addvehiclesPage.deleteToolTip();
				addvehiclesPage.clickOnDeleteButton();
				addvehiclesPage.clickOnYesButton();
				String beforetext = "Vehicle deleted successfully.";
				String aftertext = addvehiclesPage.getTextVehicleDeletedSuccessfullyMessage();
				Assert.assertEquals(beforetext,aftertext);
			} catch (Exception e) {
				e.printStackTrace();
				Assert.fail("Unable to Verify the delete tooltip and functionality on vehicle list page");
			}
		}		
		
		@Test(priority = 15, description = "Verify the 'NO' button functionality in popup on vehicle list")
		public void Verify_the_NO_button_functionality_in_popup_on_vehicle_list() {
			try {
				Log.info("************************* TC-016*************************");
				liveTrackingPage = new LiveTrackingPage(getDriver());
//				loginpage = new LoginPage(getDriver());
//				loginpage.enterEmailAddess(config.getProperty("siteAdminEmail"));
//				loginpage.enterPassword(config.getProperty("siteAdminPassword"));
//				loginpage.clickOnLogInButton();
				addvehiclesPage = new AddVehiclesPage(getDriver());
				addvehiclesPage.clickOnManageVehiclesSideBar();
				addvehiclesPage.clickOnVehicleListSideBar();
				addvehiclesPage.clickOnDeleteButton();
				addvehiclesPage.clickOnNOButton();
			} catch (Exception e) {
				e.printStackTrace();
				Assert.fail("Unable to Verify the 'NO' button functionality in popup on vehicle list");
			}
		}

}
