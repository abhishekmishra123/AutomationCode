package TestCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import Common.BaseSetup;
import PageObjects.AddVehiclesPage;
import PageObjects.LiveTrackingPage;
import PageObjects.LoginPage;
import org.apache.log4j.Logger;

public class LiveTrackingTest extends BaseSetup {
	LoginPage loginPage;
	LiveTrackingPage liveTrackingPage;
	AddVehiclesPage  addVehiclesPage;
	static Logger log = Logger.getLogger(LiveTrackingTest.class);

	@Test(priority = 0, description = "Verify the Live Tracking url")
	public void Verify_the_Live_Tracking_url() {
		try {
			log.info("************************* TC-01*************************");
			liveTrackingPage = new LiveTrackingPage(getDriver());
			loginPage = new LoginPage(getDriver());
			loginPage.enterEmailAddess(config.getProperty("siteAdminEmail"));
			loginPage.enterPassword(config.getProperty("siteAdminPassword"));
			loginPage.clickOnLogInButton();
			liveTrackingPage.clickOnLiveTrackingSidebar();
			String currentUrl = loginPage.getCurrentWebpageURL();
			AssertJUnit.assertTrue(currentUrl.contains("tracking"));
		} catch (Exception e) {
			e.printStackTrace();
			AssertJUnit.fail("Unable to Verify the Live Tracking url");
		}
	}

	@Test(priority = 1, description = "Verify element functionality and tooltip of element on map screen ")
	public void Verify_element_functionality_and_tooltip_of_element_on_map_screen() {
		try {
			log.info("************************* TC-23*************************");
			liveTrackingPage = new LiveTrackingPage(getDriver());
			liveTrackingPage.clickOnLiveTrackingSidebar();
			Thread.sleep(2000);
			liveTrackingPage.showVehicleTooltip();
			liveTrackingPage.GeofencesTooltip();
			liveTrackingPage.poiShowingOnTooltip();
			liveTrackingPage.poiRadiusTooltip();
			liveTrackingPage.trailsTooltip();
		} catch (Exception e) {
			e.printStackTrace();
			AssertJUnit.fail("Unable to element functionality and tooltip of element on map screen ");
		}
	}

	@Test(priority = 2, description = "Verify the 'Vehicles' tab of live tracking page")
	public void Verify_the_Vehicles_tab_of_live_tracking_page() {
		try {
			log.info("************************* TC-02*************************");
			liveTrackingPage = new LiveTrackingPage(getDriver());
			liveTrackingPage.clickOnLiveTrackingSidebar();
			AssertJUnit.assertTrue(liveTrackingPage.isVehiclesPresent());
		} catch (Exception e) {
			e.printStackTrace();
			AssertJUnit.fail("Unable to Verify the 'Vehicles' tab of live tracking page");
		}
	}

	@Test(priority = 3, description = "Verify the UI for Live Tracking page")
	public void Verify_the_UI_for_Live_Tracking_page() {
		try {
			log.info("************************* TC-03*************************");
			liveTrackingPage = new LiveTrackingPage(getDriver());
			liveTrackingPage.clickOnLiveTrackingSidebar();
			AssertJUnit.assertTrue(liveTrackingPage.isLiveTrackingPathLinkPresent());
			AssertJUnit.assertTrue(liveTrackingPage.isHomePathLinkPresent());
			AssertJUnit.assertTrue(liveTrackingPage.isvehiclesTabPresent());
			AssertJUnit.assertTrue(liveTrackingPage.isAlertTabPresent());
			AssertJUnit.assertTrue(liveTrackingPage.isHistoryTabPresent());
			AssertJUnit.assertTrue(liveTrackingPage.isSearchFieldPresent());
			AssertJUnit.assertTrue(liveTrackingPage.isPlusIconPresent());
		} catch (Exception e) {
			e.printStackTrace();
			AssertJUnit.fail("Unable to verify the UI for Live Tracking page");
		}
	}

	@Test(priority = 4, enabled = false, description = "Verify the search placeholder field of Live Tracking page")
	public void Verify_the_search_placeholder_field_of_Live_Tracking_page() {
		try {
			log.info("************************* TC-04*************************");
			liveTrackingPage = new LiveTrackingPage(getDriver());
			liveTrackingPage.clickOnLiveTrackingSidebar();
			AssertJUnit.assertEquals(liveTrackingPage.getTextSerchPlaceholder(), "Search");
		} catch (Exception e) {
			e.printStackTrace();
			AssertJUnit.fail("Unable to verify the search placeholder field for Live Tracking page");
		}
	}

	@Test(priority = 5, description = "Verify the search functionality of Live Tracking page")
	public void Verify_the_search_functionality_of_Live_Tracking_page() {
		try {
			log.info("************************* TC-05*************************");
			liveTrackingPage = new LiveTrackingPage(getDriver());
			liveTrackingPage.clickOnLiveTrackingSidebar();
			liveTrackingPage.searchFunctionality("MB01-GV20");
			AssertJUnit.assertTrue(liveTrackingPage.isSearchDataNotPresent());
		} catch (Exception e) {
			e.printStackTrace();
			AssertJUnit.fail("Unable to verify the search functionality for Live Tracking page");
		}
	}

	@Test(priority = 6, description = "Verify the (+) add vehicles popup of Live Tracking page")
	public void Verify_the_add_vehicles_popup_of_Live_Tracking_page() {
		try {
			log.info("************************* TC-06*************************");
			liveTrackingPage = new LiveTrackingPage(getDriver());
			liveTrackingPage.clickOnLiveTrackingSidebar();
			liveTrackingPage.clickOnPlusIcon();
			AssertJUnit.assertTrue(liveTrackingPage.isAddVehiclePopup());
		} catch (Exception e) {
			e.printStackTrace();
			AssertJUnit.fail("Unable to Verify the (+) add vehicles popup of Live Tracking page");
		}
	}

	@Test(priority = 7, description = "Verify  the (+) add vehicle tooltip of Live Tracking page")
	public void Verify_the_add_vehicle_tooltip_of_Live_Tracking_page() {
		try {
			log.info("************************* TC-07*************************");
			liveTrackingPage = new LiveTrackingPage(getDriver());
			liveTrackingPage.clickOnLiveTrackingSidebar();
			liveTrackingPage.addVehicleTooltip();
//			String expectedTooltip = "Add Vehicle";
//			WebElement download = driver.findElement(By.xpath("//button[@class='ant-btn']"));
//			Actions builder = new Actions(driver);
//			builder.clickAndHold().moveToElement(download);
//			builder.moveToElement(download).build().perform();
//			Thread.sleep(2000);
//			WebElement toolTipElement = driver.findElement(By.cssSelector("div.ant-tooltip-inner"));
//			String actualTooltip = toolTipElement.getText();
//			Assert.assertEquals(actualTooltip, expectedTooltip);

		} catch (Exception e) {
			e.printStackTrace();
			AssertJUnit.fail("Unable to verify the add vehicle tooltip for Live Tracking page");
		}
	}

	@Test(priority = 8, description = "Verify the Placeholder in all fields of add vehicle page")
	public void Verify_the_Placeholder_in_all_fields_of_add_vehicle_page() {
		try {
			log.info("************************* TC-08*************************");

			liveTrackingPage = new LiveTrackingPage(getDriver());
			liveTrackingPage.clickOnLiveTrackingSidebar();
			liveTrackingPage.clickOnPlusIcon();
			AssertJUnit.assertEquals(liveTrackingPage.getVechiclePlaceholder(), "Enter Vehicle Name");
			AssertJUnit.assertEquals(liveTrackingPage.getDeviceTypePlaceholder(), "Select Device Type");
			AssertJUnit.assertEquals(liveTrackingPage.getDeviceIdentifierPlaceholder(),
					"Enter Device Identifier or IMEI Number");
			AssertJUnit.assertEquals(liveTrackingPage.getVehicleGroupPlaceholder(), "Select Vehicle Group");
			AssertJUnit.assertEquals(liveTrackingPage.getCountryNamePlaceholder(), "Select Country Name");
			AssertJUnit.assertEquals(liveTrackingPage.getMobileNoPlaceholder(), "Enter Mobile Number");
			AssertJUnit.assertTrue(liveTrackingPage.isMarkerImage());
			AssertJUnit.assertEquals(liveTrackingPage.getAccumulatorPlaceholder(), "Enter Device Accumulator");
			AssertJUnit.assertEquals(liveTrackingPage.getVehicleDescriptionPlaceholder(), "Enter Vehicle Description");
		} catch (Exception e) {
			e.printStackTrace();
			AssertJUnit.fail("Unable to Verify the Placeholder in all fields of add vehicle page");
		}
	}

	@Test(priority = 9, description = "Verify the label in 'add vehicle' popup window")
	public void Verify_the_label_in_add_vehicle_popup_window() {
		try {
			log.info("************************* TC-09*************************");
			liveTrackingPage = new LiveTrackingPage(getDriver());
			liveTrackingPage.clickOnLiveTrackingSidebar();
			liveTrackingPage.clickOnPlusIcon();
			liveTrackingPage.clickOnSaveButton();
			AssertJUnit.assertTrue(liveTrackingPage.isVehicleNameLabel());
			AssertJUnit.assertTrue(liveTrackingPage.isDeviceTypeLabel());
			AssertJUnit.assertTrue(liveTrackingPage.isDeviceIdentifierLabel());
			AssertJUnit.assertTrue(liveTrackingPage.isVehicleGroupLabel());
			AssertJUnit.assertTrue(liveTrackingPage.isCountryNameLabel());
			AssertJUnit.assertTrue(liveTrackingPage.isMobileNoLabel());
			AssertJUnit.assertTrue(liveTrackingPage.isMarkerImageLabel());
			AssertJUnit.assertEquals(liveTrackingPage.getTextAccumulatorLabel(), "accumulator");// Accumulator Spelling
																							// Mistake
			AssertJUnit.assertTrue(liveTrackingPage.isVehicleDescriptionLabel());
		} catch (Exception e) {
			e.printStackTrace();
			AssertJUnit.fail("Unable to Verify the label in 'add vehicle' popup window");
		}
	}

	@Test(priority = 10, description = "Verify the validation message in 'add vehicle' popup window")
	public void Verify_the_validation_message_in_add_vehicle_popup_window() {
		try {
			log.info("************************* TC-10*************************");
			liveTrackingPage = new LiveTrackingPage(getDriver());
			liveTrackingPage.clickOnLiveTrackingSidebar();
			liveTrackingPage.clickOnPlusIcon();
			liveTrackingPage.clickOnSaveButton();
			AssertJUnit.assertEquals(liveTrackingPage.getTextVehicleName(), "Please Input Vehicle Name");
			AssertJUnit.assertEquals(liveTrackingPage.getTextDeviceType(), "Please Select Device Type");
			AssertJUnit.assertEquals(liveTrackingPage.getTextDeviceIdentifier(), "Please Input Correct Identifier or IMEI");
			AssertJUnit.assertEquals(liveTrackingPage.getTextVehicleGroup(), "Please Select Vehicle Group");
			AssertJUnit.assertEquals(liveTrackingPage.getTextCountryName(), "Please Select Country Name");
			AssertJUnit.assertEquals(liveTrackingPage.getTextMobileNo(), "Please Input Mobile Number");
		} catch (Exception e) {
			e.printStackTrace();
			AssertJUnit.fail("Unable to Verify the validation message in 'add vehicle' popup window");
		}
	}

	@Test(priority = 10, description = " Verify  the 'Save' button functionality on Add Vehicle page")
	public void Verify_the_Save_button_functionality_on_Add_Vehicle_page() {
		try {
			log.info("************************* TC-11*************************");
			liveTrackingPage = new LiveTrackingPage(getDriver());
			addVehiclesPage = new AddVehiclesPage(getDriver());
			liveTrackingPage.clickOnLiveTrackingSidebar();
			liveTrackingPage.clickOnPlusIcon();
			liveTrackingPage.addVehiclesDetails("Vehicle 02", "789", "7894561230", "Testing", "QA_Test");

//          Assert.assertTrue(liveTrackingPage.isVitsplDefaultGroupdropdownPresent());
//		    liveTrackingPage.ClickOnVitsplDefaultGroupDropdown();
//		    Assert.assertTrue(liveTrackingPage.isCheckAllTextPresent());
//		    Assert.assertTrue(liveTrackingPage.isCheckBoxPresent());
//		    Assert.assertTrue(liveTrackingPage.isRedCirclePresent());
//		    Assert.assertTrue(liveTrackingPage.isEyeIconPresent());

			liveTrackingPage.clickOnSaveButton();

		} catch (Exception e) {
			e.printStackTrace();
			AssertJUnit.fail("Unable to  Verify  the 'Save' button functionality on Add Vehicle page");
		}
	}

	@Test(priority = 12, description = "Verify the 'Alerts' tab functionality on live tracking page")
	public void Verify_the_Alerts_tab_functionality_on_live_tracking_page() {
		try {
			log.info("************************* TC-12*************************");
			liveTrackingPage = new LiveTrackingPage(getDriver());
			liveTrackingPage.clickOnLiveTrackingSidebar();
			AssertJUnit.assertTrue(liveTrackingPage.isAlertTabPresent());
		} catch (Exception e) {
			e.printStackTrace();
			AssertJUnit.fail("Unable to Verify the 'Alerts' tab functionality on live tracking page");
		}

	}

	@Test(priority = 13, description = "Verify the UI of Alerts tab on live tracking page ")
	public void Verify_the_UI_of_Alerts_tab_on_live_tracking_page() {
		try {
			log.info("************************* TC-13*************************");
			liveTrackingPage = new LiveTrackingPage(getDriver());
			liveTrackingPage.clickOnLiveTrackingSidebar();
			liveTrackingPage.clickOnAlertsTab();
			// Check for alert tab UI
			AssertJUnit.assertTrue(liveTrackingPage.isSearchFieldPresent());
			AssertJUnit.assertTrue(liveTrackingPage.isAlertsTabVehicleNameHeaderPresent());
			AssertJUnit.assertTrue(liveTrackingPage.isAlertsTabEventHeaderPresent());
			AssertJUnit.assertTrue(liveTrackingPage.isAlertsTabAlertsDateTimeHeaderHeaderPresent());

		} catch (Exception e) {
			e.printStackTrace();
			AssertJUnit.fail("Unable to Verify the UI of Alerts tab on live tracking page");
		}
	}

	@Test(priority = 14, description = "Verify the search placeholder on Alerts tab")
	public void Verify_the_search_placeholder_on_Alerts_tab() {
		try {
			log.info("************************* TC-14*************************");
			liveTrackingPage = new LiveTrackingPage(getDriver());
			liveTrackingPage.clickOnLiveTrackingSidebar();
			liveTrackingPage.clickOnAlertsTab();
			String str1 = liveTrackingPage.getTextAlertsTabSerchPlaceholder();
			AssertJUnit.assertEquals(str1, "Search");
		} catch (Exception e) {
			e.printStackTrace();
			AssertJUnit.fail("Unable to Verify the search placeholder on Alerts tab");
		}
	}

	@Test(priority = 15, description = "Verify the search functionality on alert tab ")
	public void To_Verify_the_search_functionality_on_alert_tab() {
		try {
			log.info("************************* TC-15*************************");
			liveTrackingPage = new LiveTrackingPage(getDriver());
			liveTrackingPage.clickOnLiveTrackingSidebar();
			liveTrackingPage.clickOnAlertsTab();
			liveTrackingPage.searchFunctionality("MB01-GV20");
			AssertJUnit.assertTrue(liveTrackingPage.isAlertsTabSearchDataNotPresent());
		} catch (Exception e) {
			e.printStackTrace();
			AssertJUnit.fail("Unable to Verify the search functionality on alert tab");
		}
	}

	@Test(priority = 16, description = "Verify the UI of History tab")
	public void Verify_the_UI_of_History_tab() {
		try {
			log.info("************************* TC-16*************************");
			liveTrackingPage = new LiveTrackingPage(getDriver());
			liveTrackingPage.clickOnLiveTrackingSidebar();
			liveTrackingPage.clickOnHistoryTab();
			AssertJUnit.assertTrue(liveTrackingPage.isDeviceTextPresent());
			AssertJUnit.assertTrue(liveTrackingPage.isFromDateTextPresent());
			AssertJUnit.assertTrue(liveTrackingPage.isFromTimeTextPresent());
			AssertJUnit.assertTrue(liveTrackingPage.isToDateTextPresent());
			AssertJUnit.assertTrue(liveTrackingPage.isToTimeTextPresent());
			AssertJUnit.assertTrue(liveTrackingPage.isShowHistoryButtonPresent());
			AssertJUnit.assertTrue(liveTrackingPage.isDownloadButtonPresent());
			AssertJUnit.assertTrue(liveTrackingPage.isCrossButtonPresent());
			AssertJUnit.assertTrue(liveTrackingPage.isDateTextPresent());
			AssertJUnit.assertTrue(liveTrackingPage.isDrawTrackButtonPresent());
			AssertJUnit.assertEquals(liveTrackingPage.getTextAverageSpeedHeaderPresent(5), "Average Speed");

			for (int i = 1; i < 5; i++) {

				AssertJUnit.assertTrue(liveTrackingPage.isHistoryTableHeaderPresent(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
			AssertJUnit.fail("Unable to Verify the UI of History tab");
		}
	}

	@Test(priority = 17, description = "Verify the Placeholder in all field of History Page")
	public void Verify_the_Placeholder_in_all_field_of_History_Page() {
		try {
			log.info("************************* TC-17*************************");
			liveTrackingPage = new LiveTrackingPage(getDriver());
			liveTrackingPage.clickOnLiveTrackingSidebar();
			liveTrackingPage.clickOnHistoryTab();
			AssertJUnit.assertEquals(liveTrackingPage.getDeviceHistoryPlaceholder(), "Select Device");
			AssertJUnit.assertEquals(liveTrackingPage.getFromTimePlaceholder(), "Select time");
			AssertJUnit.assertEquals(liveTrackingPage.getToTimePlaceholder(), "Select time");

		} catch (Exception e) {
			e.printStackTrace();
			AssertJUnit.fail("Unable to Verify the Placeholder in all field of History Page");
		}
	}

	@Test(priority = 18, description = "Verify the Label in all field of History Tab")
	public void Verify_the_Label_in_all_field_of_History_Tab() {
		try {
			log.info("************************* TC-18*************************");
			liveTrackingPage = new LiveTrackingPage(getDriver());
			liveTrackingPage.clickOnLiveTrackingSidebar();
			liveTrackingPage.clickOnHistoryTab();
			AssertJUnit.assertTrue(liveTrackingPage.isDeviceLabel());
			AssertJUnit.assertTrue(liveTrackingPage.isFromDateLabel());
			AssertJUnit.assertTrue(liveTrackingPage.isFromTImeLabel());
			AssertJUnit.assertTrue(liveTrackingPage.isToDateLabel());
			AssertJUnit.assertTrue(liveTrackingPage.isToTimeLabel());
		} catch (Exception e) {
			e.printStackTrace();
			AssertJUnit.fail("Unable to Verify the Label in all field of History Tab");
		}
	}

	@Test(priority = 19, description = "Verify the Validation message on history tab")
	public void Verify_the_Validation_message_on_history_tab() {
		try {
			log.info("************************* TC-19*************************");
			liveTrackingPage = new LiveTrackingPage(getDriver());
			liveTrackingPage.clickOnLiveTrackingSidebar();
			liveTrackingPage.clickOnHistoryTab();
			liveTrackingPage.clickOnShowHistoryButton();
			String str5 = liveTrackingPage.getTextDevice();
			AssertJUnit.assertEquals(str5, "Please Select Device");

		} catch (Exception e) {
			e.printStackTrace();
			AssertJUnit.fail("Unable to Verify the Validation message on history tab");
		}
	}

	@Test(priority = 20, description = "Verify the Home Link Path of add vehicles page")
	public void Verify_the_Home_Link_Path_of_add_vehicles_page() {

		try {
			log.info("************************* TC-20*************************");
			liveTrackingPage = new LiveTrackingPage(getDriver());
			liveTrackingPage.clickOnLiveTrackingSidebar();
			liveTrackingPage.clickOnHomeLinkPath();
			String currentUrl = loginPage.getCurrentWebpageURL();
			AssertJUnit.assertTrue(currentUrl.contains("dashboard"));
			AssertJUnit.assertTrue(liveTrackingPage.isDashboardPagePresent());

		} catch (Exception e) {
			e.printStackTrace();
			AssertJUnit.fail("Unable to Verify the Home Link Path of add vehicles page");
		}
	}

	@Test(priority = 21, description = "Verify Show History button functionality if select valid data in all fields ")
	public void Verify_Show_History_button_functionality_if_select_valid_data_in_all_fields() {
		try {
			log.info("************************* TC-21*************************");
			liveTrackingPage = new LiveTrackingPage(getDriver());
			liveTrackingPage.clickOnLiveTrackingSidebar();
			liveTrackingPage.clickOnHistoryTab();
			liveTrackingPage.clickOnDevice();
			liveTrackingPage.clickOnFromDate(6);
			liveTrackingPage.clickOnFromTime();
			liveTrackingPage.clickOnToDate(4);
			liveTrackingPage.clickOnTOTime();
			liveTrackingPage.clickOnShowHistoryButton();
		} catch (Exception e) {
			e.printStackTrace();
			AssertJUnit.fail("Unable to Verify Show History button functionality if select valid data in all fields");
		}
	}

//	@Test(priority = 22, description = "Verify the 'Cross'(x) and Download icon on history tab")
//	public void Verify_the_Cross_and_Download_icon_on_history_tab() {
//		try {
//			log.info("************************* TC-22*************************");
//			liveTrackingPage = new LiveTrackingPage(getDriver());
//			loginPage = new LoginPage(getDriver());
//			loginPage.enterEmailAddess(config.getProperty("siteAdminEmail"));
//			loginPage.enterPassword(config.getProperty("siteAdminPassword"));
//			loginPage.clickOnLogInButton();
//			liveTrackingPage.clickOnLiveTrackingSidebar();
//			liveTrackingPage.clickOnHistoryTab();
//			liveTrackingPage.downloadButtonTooltip();
//			//liveTrackingPage.clearButtonTooltip();
//		} catch (Exception e) {
//			e.printStackTrace();
//			Assert.fail("Unable to Verify the 'Cross'(x) and Download icon on history tab");
//		}
//	}

}