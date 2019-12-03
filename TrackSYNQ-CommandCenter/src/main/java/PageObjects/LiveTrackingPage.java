package PageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import Common.ConfigManager;
import Common.ActionMethods;

public class LiveTrackingPage extends ActionMethods {

	private String liveTrackingSideBar = "css:a[href='/tracking']";
	private String homeLinkPath = "xpath://a[text()='Home']";
	private String liveTrackingPathLink = "xpath://span[text()='Live Tracking'][@class='ant-breadcrumb-link']";
	private String homePathLink = "xpath: //a[text()='Home']";
	private String addVehiclePopup = "xpath://div[@class='ant-modal-content']";
	private String vehiclesTab = "xpath: //div[text()='Vehicles']";
	private String alertTab = "xpath: //div[text()='Alerts']";
	private String plusIconPresent = "xpath: //button[@type='button']//i[@class='fa fa-plus']";
	private String vitsplDefaultGroupdropdown = "xpath: //div[@class='ant-collapse-header']";
	private String checkAllText = "xpath: //span[text()='Check All']";
	private String checkBox = "css: label.ant-checkbox-wrapper span.ant-checkbox span:nth-child(2)";
	private String redCircle = "xpath: //li[1]//div[1]//span[1]//i";
	private String eyeIcon = "xpath: //i[@class='fa fa-eye' and @id='5db99750e2fa9131341d7649']";
	private String searchPlaceholder = "xpath: //div[text()='search']";
	private String searchFunctionality = "xpath: //input[@class='ant-input ant-select-search__field']";
	private String searchNotFound = "xpath: //p[text()='Vehicles not added.']";
	private String plusIcon = "css: div.ant-col-xl-2 button.ant-btn";
	private String vehiclePlaceholder = "xpath://input[@placeholder='Enter Vehicle Name']";
	private String deviceTypePlaceholder = "xpath://div[text() = 'Select Device Type']";
	private String countryNamePlaceholder = "xpath://div[@title = 'Select Country Name']";
	private String markerImage = "xpath://button[@class='ant-btn uploadVehicleMarkerBtn']";
	private String vehicleDescriptionPlaceholder = "xpath://textarea[@placeholder='Enter Vehicle Description']";
	private String saveButton = "xpath://button[@class= 'ant-btn ant-btn-primary']";
	private String vehicleNameValidation = "xpath://div[text() = 'Please Enter Vehicle Name']";
	private String vehicleNameLabel = "xpath://label[@for='vehicle_name']";
	private String markerImageLabel = "xpath://label[text()='Marker Image']";
	private String VehicleName = "xpath://input[@id='vehicle_name']";
	private String SelectDeviceTypeDropdown = "xpath://div[@id='device_type']";
	private String deviceTypeDropdownOption = "xpath://li[@class='ant-select-dropdown-menu-item ant-select-dropdown-menu-item-active']";
	private String vehicleGroupDropdown = "xpath://div[@id='group' and @class='ant-select ant-select-enabled' ]";
	private String selectDeviceGroup = "xpath://li[text()='Default Group']";
	private String countryName = "xpath://div[@id='country_detail']";
	private String mobileNo = "xpath://input[@id='sim_no']";
	private String addMarkerImage = "xpath://div[@class='ant-modal-title'][text()='Add Marker Image']";
	private String selectMarkerImage = "xpath://img[@src='http://prod1.intellitransitsolutions.net:9080/uploads/device_markers/1557937412188_5.png']";

	private String alertSearchField = "xpath://div[@class='ant-select-lg global-search ant-select-show-search ant-select-auto-complete ant-select ant-select-combobox ant-select-enabled ant-select-allow-clear']";
	private String alertSearchNoDataFound = "xpath: //div[text()='No data']";

	private String historyTableHeader = "css:div.ant-table-scroll-position-left th:nth-child(num)";
	private String fromTimePlaceholder = "xpath://input[@placeholder='Select time' and @id='fromtime']";
	private String toTimePlaceholder = "xpath://input[@placeholder='Select time' and @id='totime']";

	private String downloadButton = "xpath://span[@class='downloadHistory']";
	private String crossButton = "xpath://i[@class='fa fa-close']";

	private String deviceOnHistory = "css: #deviceid";
	private String selectFromDateOption = "xpath://tr[@class='ant-calendar-active-week']//td[num]";
	private String fromTime = "xpath://input[@id='fromtime']";
	private String selectFromTimeOption = "xpath://div[@class='ant-time-picker-panel-inner']//div[1]//ul[1]//li[7]";
	private String todatedropdown = "xpath://span[@id='todate']";
	private String selectTODateOption = "xpath://tbody[@class='ant-calendar-tbody']//tr[2]//td[num]";
	private String toTime = "xpath://input[@id='totime']";
	private String selectToTImeOption = "xpath://div[contains(@class,'ant-time-picker-panel-select')]//ul[1]//li[contains(text(),'02')]";
	private String dashboardPage = "xpath://div[@class='ant-card dynamic-dashboard ant-card-bordered ant-card-wider-padding ant-card-padding-transition']";

	static WebDriver driver;
	public Logger log = Logger.getLogger(LiveTrackingPage.class);
	ConfigManager config;

	public LiveTrackingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		config = new ConfigManager();
	}

	// This function is used for plus icon on vehicles tab
	public void clickOnPlusIcon() {
		safeClick(plusIcon, SHORTWAIT);
	}

	// This function is used for Vehicle Tab is present
	public boolean isVehiclesPresent() {
		return isElementPresent(vehiclesTab, SHORTWAIT);
	}

	// This function is used for live tracking Side bar
	public void addVehicle() {
		WebElement download = driver.findElement(By.cssSelector("a[href='/tracking']"));
		Actions builder = new Actions(driver);
		builder.clickAndHold().moveToElement(download);
		builder.moveToElement(download).build().perform();
		driver.findElement(By.cssSelector("a[href='/tracking']")).click();
	}

	// Use for Add Vehicle button tool tip
		public void addVehicleTooltip() {
			// Verify the + icon tooltip
			String expectedTooltip = "Add Vehicle";
			WebElement download = driver.findElement(By.cssSelector("div.ant-col-xl-2 button.ant-btn"));
			Actions builder = new Actions(driver);
			builder.clickAndHold().moveToElement(download);
			builder.moveToElement(download).build().perform();
			needToWait(SHORTWAIT);
			WebElement toolTipElement = driver.findElement(By.cssSelector("div.ant-tooltip-inner"));
			String actualTooltip = toolTipElement.getText();
			Assert.assertEquals(actualTooltip, expectedTooltip);

		}
			
	// This function is used for Home link path
	public void clickOnHomeLinkPath() {
		safeClick(homeLinkPath, SHORTWAIT);
	}

	// This function is used for dash-board page is present
	public boolean isDashboardPagePresent() {
		return isElementPresent(dashboardPage, SHORTWAIT);
	}

	// This function is used for live tracking link is present
	public boolean isLiveTrackingPathLinkPresent() {
		return isElementPresent(liveTrackingPathLink, SHORTWAIT);
	}

	// This function is used for home path link is present
	public boolean isHomePathLinkPresent() {
		return isElementPresent(homePathLink, SHORTWAIT);

	}

	// This function is used for vehicles tab is present
	public boolean isvehiclesTabPresent() {
		return isElementPresent(vehiclesTab, SHORTWAIT);
	}

	// This function is used for AlertTab is present
	public boolean isAlertTabPresent() {
		return isElementPresent(vehiclesTab.replace("Vehicles", "Alerts"), SHORTWAIT);
	}

	// This function is used for HistoryTab is present
	public boolean isHistoryTabPresent() {
		return isElementPresent(vehiclesTab.replace("Vehicles", "History"), SHORTWAIT);
	}

	// This function is used for Add Vehicles pop-up
	public boolean isAddVehiclePopup() {
		return isElementPresent(addVehiclePopup, SHORTWAIT);
	}

	// This function is used for search field is present
	public boolean isSearchFieldPresent() {
		return isElementPresent(addVehiclePopup.replace("ant-modal-content", "searchObject"), SHORTWAIT);
	}

	// This function is used for plus icon is present
	public boolean isPlusIconPresent() {
		return isElementPresent(plusIconPresent, SHORTWAIT);
	}

	// This function is used for VitsplDefault Group Drop-down Present
	public boolean isVitsplDefaultGroupdropdownPresent() {
		return isElementPresent(vitsplDefaultGroupdropdown, SHORTWAIT);
	}

	// This function is used for click on VitsplDefault Group Drop-down
	public void ClickOnVitsplDefaultGroupDropdown() {
		safeClick(vitsplDefaultGroupdropdown, SHORTWAIT);
	}

	// This function is used for check all text present
	public boolean isCheckAllTextPresent() {
		return isElementPresent(checkAllText, SHORTWAIT);
	}

	// This function is used for check box is present
	public boolean isCheckBoxPresent() {
		return isElementPresent(checkBox, SHORTWAIT);
	}

	// This function is used for red circle is present
	public boolean isRedCirclePresent() {
		return isElementPresent(redCircle, SHORTWAIT);
	}

	// This function is used for eye icon is present
	public boolean isEyeIconPresent() {
		return isElementPresent(eyeIcon, SHORTWAIT);
	}

	// This function is used for search placeholder
	public String getTextSerchPlaceholder() {
		String str = safeGetText(searchPlaceholder, SHORTWAIT);
		return str;
	}

	// This function is used for search placeholder on alerts tab
	public String getTextAlertsTabSerchPlaceholder() {
		String str = safeGetText(searchPlaceholder.replace("search", "Search"), SHORTWAIT);
		return str;
	}

	// This function is used for search functionality
	public void searchFunctionality(String name) {
		safeType(searchFunctionality, name);
	}

	// This function is used for get search data on vehicles tab
	public boolean isSearchDataNotPresent() {
		return isElementPresent(searchNotFound, SHORTWAIT);
	}

	// This function is used for Vehicle placeholder on add vehicle pop-up
	public String getVechiclePlaceholder() {
		String VechiclePlaceholderText = safeGetAttribute(vehiclePlaceholder, "placeholder", SHORTWAIT);
		log.info("get Vechicle Name placeholder ");
		return VechiclePlaceholderText;
	}

	// This function is used for DeviceType placeholder on add vehicle pop-up
	public String getDeviceTypePlaceholder() {
		String DeviceTypePlaceholderText = safeGetText(deviceTypePlaceholder, SHORTWAIT);
		log.info("get DeviceType Name placeholder ");
		return DeviceTypePlaceholderText;
	}

	// This function is used for DeviceIdentifier placeholder on add vehicle pop-up
	public String getDeviceIdentifierPlaceholder() {
		String DeviceIdentifierPlaceholderText = safeGetAttribute(
		vehiclePlaceholder.replace("Enter Vehicle Name", "Enter Device Identifier or IMEI Number"),"placeholder", SHORTWAIT);
		log.info("get DeviceIdentifier Name placeholder ");
		return DeviceIdentifierPlaceholderText;
	}

	// This function is used for VehicleGroup placeholder on add vehicle pop-up
	public String getVehicleGroupPlaceholder() {
		String VehicleGroupPlaceholderText = safeGetText(
		deviceTypePlaceholder.replace("Select Device Type", "Select Vehicle Group"), SHORTWAIT);
		log.info("get VehicleGroup Name placeholder ");
		return VehicleGroupPlaceholderText;
	}

	// This function is used for CountryName placeholder on add vehicle pop-up
	public String getCountryNamePlaceholder() {
		String CountryNamePlaceholderText = safeGetText(countryNamePlaceholder, SHORTWAIT);
		log.info("get CountryName placeholder ");
		return CountryNamePlaceholderText;
	}

	// This function is used for MobileNo placeholder on add vehicle pop-up
	public String getMobileNoPlaceholder() {
		String MobileNoPlaceholderText = safeGetAttribute(
		vehiclePlaceholder.replace("Enter Vehicle Name", "Enter Mobile Number"), "placeholder", SHORTWAIT);
		log.info("get MobileNo Name placeholder ");
		return MobileNoPlaceholderText;
	}

	// This function is used for Use for marker image is present
	public boolean isMarkerImage() {
		return isElementPresent(markerImage, SHORTWAIT);
	}

	// This function is used for Accumulator placeholder on add vehicle pop-up
	public String getAccumulatorPlaceholder() {
		String AccumulatorPlaceholderText = safeGetAttribute(
		vehiclePlaceholder.replace("Enter Vehicle Name", "Enter Device Accumulator"), "placeholder", SHORTWAIT);
		log.info("get Accumulator Name placeholder ");
		return AccumulatorPlaceholderText;
	}

	// This function is used for VehicleDescription placeholder on add vehicle
	// pop-up
	public String getVehicleDescriptionPlaceholder() {
		String VehicleDescriptionPlaceholderText = safeGetAttribute(vehicleDescriptionPlaceholder, "placeholder",SHORTWAIT);
		log.info("get VehicleDescription Name placeholder ");
		return VehicleDescriptionPlaceholderText;
	}

	// This function is used for save button
	public void clickOnSaveButton1() {
		safeClick(saveButton, SHORTWAIT);
	}

	// This function is used for get vehicle name validation message on add vehicle 
	public String getTextVehicleName() {
		String str = safeGetText(vehicleNameValidation, SHORTWAIT);
		return str;
	}

	// This function is used for get Device Type validation message on add vehicle 
	public String getTextDeviceType() {
		String str = safeGetText(
		vehicleNameValidation.replace("Please Enter Vehicle Name", "Please Select Device Type"), SHORTWAIT);
		return str;
	}

	// This function is used for get Device Identifier validation message on add vehicle 
	public String getTextDeviceIdentifier() {
		String str = safeGetText(
		vehicleNameValidation.replace("Please Enter Vehicle Name", "Please Input Correct Identifier or IMEI"),SHORTWAIT);
		return str;
	}

	// This function is used for VehicleGroup validation message on add vehicle 
	public String getTextVehicleGroup() {
		String str = safeGetText(
		vehicleNameValidation.replace("Please Enter Vehicle Name", "Please Select Vehicle Group"), SHORTWAIT);
		return str;
	}

	// This function is used for Country Name validation message on add vehicle 
	public String getTextCountryName() {
		String str = safeGetText(
		vehicleNameValidation.replace("Please Enter Vehicle Name", "Please Select Country Name"), SHORTWAIT);
		return str;
	}

	// This function is used for MobileNo validation message on add vehicle 
	public String getTextMobileNo() {
		String str = safeGetText(
		vehicleNameValidation.replace("Please Enter Vehicle Name", "Please Input Mobile Number"), SHORTWAIT);
		return str;
	}

	// This function is used for Vehicle Name Label validation message
	public boolean isVehicleNameLabel() {
		return isElementPresent(vehicleNameLabel, SHORTWAIT);
	}

	// This function is used for Device Type Label on Add vehicle pop-up
	public boolean isDeviceTypeLabel() {
		return isElementPresent(vehicleNameLabel.replace("vehicle_name", "device_type"), SHORTWAIT);
	}

	// This function is used for Device Identifier / IMEI No Label on Add vehicle
	// pop-up
	public boolean isDeviceIdentifierLabel() {
		return isElementPresent(vehicleNameLabel.replace("vehicle_name", "imei"), SHORTWAIT);
	}

	// This function is used for Vehicle Group Label on Add vehicle Pop-up
	public boolean isVehicleGroupLabel() {
		return isElementPresent(vehicleNameLabel.replace("vehicle_name", "group"), SHORTWAIT);
	}

	// This function is used for Country Name Label on Add vehicle popup
	public boolean isCountryNameLabel() {
		return isElementPresent(vehicleNameLabel.replace("vehicle_name", "country_detail"), SHORTWAIT);
	}

	// This function is used for Mobile No. Label on Add vehicle pop-up
	public boolean isMobileNoLabel() {
		return isElementPresent(vehicleNameLabel.replace("vehicle_name", "sim_no"), SHORTWAIT);
	}

	// This function is used for MarkerImage Label on Add vehicle pop-up
	public boolean isMarkerImageLabel() {
		return isElementPresent(markerImageLabel, SHORTWAIT);
	}

	// This function is used for Accumulator Label on Add vehicle pop-up
	public String getTextAccumulatorLabel() {
		String str = safeGetText(vehicleNameLabel.replace("vehicle_name", "accumulator"), SHORTWAIT);
		return str;
	}

	// This function is used for VehicleDescription Label on Add vehicle pop-up
	public boolean isVehicleDescriptionLabel() {
		return isElementPresent(vehicleNameLabel.replace("vehicle_name", "vehicle_description"), SHORTWAIT);
	}

	// This function is used for Enter vehicle name on vehicle pop-up
	public void vehicleName(String name) {
		safeType(VehicleName, name);
	}

	// This function is used for select device type
	public void clickOnSelectDeviceType() {
		safeClick(SelectDeviceTypeDropdown, SHORTWAIT);
		safeClick(deviceTypeDropdownOption, SHORTWAIT);
	}

	// This function is used for device identifier IMEI no
	public void deviceIdentifierImeiNoOption(String name) {
		safeType(searchFunctionality.replace("ant-input ant-select-search__field", "ant-input-number-input"), name);
	}

	// This function is used for select device group
	public void clickOnSelectDeviceGroup() {
		safeClick(vehicleGroupDropdown, SHORTWAIT);
		safeClick(selectDeviceGroup, SHORTWAIT);
	}

	// This function is used for select country name
	public void clickOnCountryName() {
		safeClick(countryName, SHORTWAIT);
		safeClick(selectDeviceGroup.replace("Default Group", "United States"), SHORTWAIT);
	}

	// This function is used for mobile no
	public void mobileNO(String name) {
		safeType(mobileNo, name);
	}

	// This function is used for save button
	public void clickOnSaveButton() {
		safeClick(saveButton, SHORTWAIT);
	}

	// This function is used for marker image
	public void clickOnMarkerImage() {
		safeClick(markerImage, SHORTWAIT);
	}

	// This function is used for add marker image text
	public boolean isAddMarkerImageTextPresent() {
		return isElementPresent(addMarkerImage, SHORTWAIT);
	}

	// This function is used for select marker image
	public void selectMarkerImage() {
		safeClick(selectMarkerImage, SHORTWAIT);
	}

	// This function is used for click on alerts tab
	public void clickOnAlertsTab() {
		safeClick(alertTab, SHORTWAIT);
	}

	// This function is used for alert search functionality
	public void alertsearchFunctionality(String name) {
		safeType(alertSearchField, name);
	}

	// This function is used for get search data
	public boolean isAlertsTabSearchDataNotPresent() {
		return isElementPresent(alertSearchNoDataFound, SHORTWAIT);
	}

	// This function is used for header name is present (vehicle name)
	public boolean isAlertsTabVehicleNameHeaderPresent() {
		return isElementPresent(alertSearchNoDataFound.replace("No data", "Vehicle Name"), SHORTWAIT);
	}

	// This function is used for header name is present (Event name)
	public boolean isAlertsTabEventHeaderPresent() {
		return isElementPresent(alertSearchNoDataFound.replace("No data", "Event"), SHORTWAIT);
	}

	// This function is used for header name is present (Date Time)
	public boolean isAlertsTabAlertsDateTimeHeaderHeaderPresent() {
		return isElementPresent(alertSearchNoDataFound.replace("No data", "Alerts Date Time"), SHORTWAIT);
	}

	// This function is used for click on history tab
	public void clickOnHistoryTab() {
		safeClick(alertTab.replace("Alerts", "History"), SHORTWAIT);
	}

	// This function is used for Device text is present on history tab
	public boolean isDeviceTextPresent() {
		return isElementPresent(vehicleNameLabel.replace("vehicle_name", "deviceid"), SHORTWAIT);
	}

	// This function is used for From date text is present on history tab
	public boolean isFromDateTextPresent() {
		return isElementPresent(vehicleNameLabel.replace("vehicle_name", "fromdate"), SHORTWAIT);
	}

	// This function is used for From Time text is present on history tab
	public boolean isFromTimeTextPresent() {
		return isElementPresent(vehicleNameLabel.replace("vehicle_name", "fromtime"), SHORTWAIT);
	}

	// This function is used for To Date text is present on history tab
	public boolean isToDateTextPresent() {
		return isElementPresent(vehicleNameLabel.replace("vehicle_name", "todate"), SHORTWAIT);
	}

	// This function is used for To Time text is present on history tab
	public boolean isToTimeTextPresent() {
		return isElementPresent(vehicleNameLabel.replace("vehicle_name", "totime"), SHORTWAIT);
	}

	// This function is used for Show History Button is present
	public boolean isShowHistoryButtonPresent() {
		return isElementPresent(checkAllText.replace("Check All", "Show History"), SHORTWAIT);
	}

	// This function is used for Download Button is present
	public boolean isDownloadButtonPresent() {
		return isElementPresent(downloadButton, SHORTWAIT);
	}

	// This function is used for Cross Button is present
	public boolean isCrossButtonPresent() {
		return isElementPresent(crossButton, SHORTWAIT);
	}

	// This function is used for Date text is present
	public boolean isDateTextPresent() {
		return isElementPresent(vehiclesTab.replace("Vehicles", "Date"), SHORTWAIT);
	}

	// This function is used for history Table Header is present
	public boolean isHistoryTableHeaderPresent(int num) {
		return isElementVisible(historyTableHeader.replace("num", num + ""), LONGWAIT);
	}

	// This function is used for Average Speed header
	public String getTextAverageSpeedHeaderPresent(int num) {
		String str = safeGetText(historyTableHeader.replace("num", num + ""), LONGWAIT);
		return str;
	}

	// This function is used for Draw Track button is present
	public boolean isDrawTrackButtonPresent() {
		return isElementPresent(checkAllText.replace("Check All", "Draw Track"), SHORTWAIT);
	}

	// This function is used for Device placeholder on history page
	public String getDeviceHistoryPlaceholder() {
		String DevicePlaceholderText = safeGetText(deviceTypePlaceholder.replace("Select Device Type", "Select Device"),
				SHORTWAIT);
		log.info("get Device Name placeholder ");
		return DevicePlaceholderText;
	}

	// This function is used for From Time placeholder on add vehicle pop-up
	public String getFromTimePlaceholder() {
		String FromTimePlaceholderText = safeGetAttribute(fromTimePlaceholder, "Placeholder", SHORTWAIT);
		log.info("get DeviceType Name placeholder ");
		return FromTimePlaceholderText;
	}

	// This function is used for To Time placeholder on add vehicle pop-up
	public String getToTimePlaceholder() {
		String ToTimePlaceholderText = safeGetAttribute(toTimePlaceholder, "Placeholder", SHORTWAIT);
		log.info("get DeviceType Name placeholder ");
		return ToTimePlaceholderText;
	}

	// This function is used for Device Label on History Tab
	public boolean isDeviceLabel() {
		return isElementPresent(vehicleNameLabel.replace("vehicle_name", "deviceid"), SHORTWAIT);
	}

	// This function is used for From Date Label on History Tab
	public boolean isFromDateLabel() {
		return isElementPresent(vehicleNameLabel.replace("vehicle_name", "fromdate"), SHORTWAIT);
	}

	// This function is used for From Time on History Tab
	public boolean isFromTImeLabel() {
		return isElementPresent(vehicleNameLabel.replace("vehicle_name", "fromtime"), SHORTWAIT);
	}

	// This function is used for To Date on History Tab
	public boolean isToDateLabel() {
		return isElementPresent(vehicleNameLabel.replace("vehicle_name", "fromdate"), SHORTWAIT);
	}

	// This function is used for To Time on History Tab
	public boolean isToTimeLabel() {
		return isElementPresent(vehicleNameLabel.replace("vehicle_name", "totime"), SHORTWAIT);
	}

	// This function is used for Click on Show History button
	public void clickOnShowHistoryButton() {
		safeJavaScriptClick(checkAllText.replace("Check All", "Show History"));
	}

	// This function is used for Device validation message for history tab
	public String getTextDevice() {
		String str = safeGetText(vehicleNameValidation.replace("Please Enter Vehicle Name", "Please Select Device"),
				SHORTWAIT);
		return str;
	}

	// This function is used for Click Device drop-down button on history tab
	public void clickOnDevice() {
		safeClick(deviceOnHistory, SHORTWAIT);
		safeClick(selectDeviceGroup.replace("Default Group", "Vehicle 01"), SHORTWAIT);
	}

	// This function is used for Click on From Date drop-down button
	public void clickOnFromDate(int num) {
		safeClick(deviceOnHistory.replace("#deviceid", "#fromdate"), SHORTWAIT);
		safeClick(selectFromDateOption.replace("num", num + ""), SHORTWAIT);
	}

	// This function is used for Click on From Time drop-down button
	public void clickOnFromTime() {
		safeClick(fromTime, SHORTWAIT);
		safeClick(selectFromTimeOption, SHORTWAIT);
	}

	// This function is used for Click on TO Date drop-down button
	public void clickOnToDate(int num) {
		safeClick(todatedropdown, SHORTWAIT);
		safeClick(selectTODateOption.replace("num", num + ""), SHORTWAIT);
	}

	// This function is used for Click on TO Time drop-down button
	public void clickOnTOTime() {
		safeClick(toTime, SHORTWAIT);
		safeClick(selectToTImeOption, SHORTWAIT);
	}

	// This function is used for Download button tool tip
	public void downloadButtonTooltip() {
		String expectedTooltip = "Download";
		WebElement download1 = driver.findElement(By.xpath("//span[contains(@class,'downloadHistory')]"));
		Actions builder = new Actions(driver);
		builder.clickAndHold().moveToElement(download1);
		builder.moveToElement(download1).build().perform();
		WebElement toolTipElement = driver.findElement(By.xpath("//div[contains(text(),'Download')]"));
		String actualTooltip = toolTipElement.getText();
		System.out.println("Actual Title of Tool Tip +++++++++" + actualTooltip);
		Assert.assertEquals(actualTooltip, expectedTooltip);
	}

	
	// This function is used for Clear button tool tip
	public void clearButtonTooltip() {
		String expectedTooltip = "Clear";
		WebElement download1 = driver.findElement(By.xpath("//i[@class='fa fa-close']"));
		Actions builder = new Actions(driver);
		builder.clickAndHold().moveToElement(download1);
		builder.moveToElement(download1).build().perform();
		WebElement toolTipElement = driver.findElement(By.xpath("//div[text()='Clear']"));
		needToWait(4);
		String actualTooltip = toolTipElement.getText();
		System.out.println("Actual Title of Tool Tip +++++++++" + actualTooltip);
		Assert.assertEquals(actualTooltip, expectedTooltip);
	}

	// This function is used for Show Vehicle tool tip
	public void showVehicleTooltip() {
		// Verify the + icon tooltip
		String expectedTooltip = "Vehicles Showing ON";
		WebElement download = driver.findElement(By.xpath("//button[contains(@name,'object')]"));
		Actions builder = new Actions(driver);
		builder.clickAndHold().moveToElement(download);
		builder.moveToElement(download).build().perform();
		needToWait(SHORTWAIT);
		WebElement toolTipElement = driver.findElement(By.xpath("//div[contains(text(),'Vehicles Showing ON')]"));
		String actualTooltip = toolTipElement.getText();
		System.out.println("Actual Title of Tool Tip +++++++++" + actualTooltip);
		Assert.assertEquals(actualTooltip, expectedTooltip);
	}

	// This function is used for GEO fences Tool tip
	public void GeofencesTooltip() {
		String expectedTooltip = "Geofences Showing ON";
		WebElement download1 = driver.findElement(By.xpath("//button[contains(@name,'geofences')]"));
		Actions builder = new Actions(driver);
		builder.clickAndHold().moveToElement(download1);
		builder.moveToElement(download1).build().perform();
		needToWait(SHORTWAIT);
		WebElement toolTipElement = driver.findElement(By.xpath("//div[contains(text(),'Geofences Showing ON')]")); 
		String actualTooltip = toolTipElement.getText();
		System.out.println("Actual Title of Tool Tip +++++++++" + actualTooltip);
		Assert.assertEquals(actualTooltip, expectedTooltip);
	}

	// This function is used for POI Showing On Tool tip
	public void poiShowingOnTooltip() {
		String expectedTooltip = "POI Showing ON";
		WebElement download1 = driver.findElement(By.xpath("//body//div[2]//div[2]//div[1]//div[1]//button[3]"));
		Actions builder = new Actions(driver);
		builder.clickAndHold().moveToElement(download1);
		builder.moveToElement(download1).build().perform();
		needToWait(SHORTWAIT);
		WebElement toolTipElement = driver.findElement(By.xpath("//div[contains(text(),'POI Showing ON')]"));
		String actualTooltip = toolTipElement.getText();
		System.out.println("Actual Title of Tool Tip +++++++++" + actualTooltip);
		Assert.assertEquals(actualTooltip, expectedTooltip);
	}

	// This function is used for POI Radius On Tool tip
	public void poiRadiusTooltip() {
		String expectedTooltip = "POI Radius Showing ON";
		WebElement download1 = driver.findElement(By.xpath("//button[contains(@name,'poiradius')]"));
		Actions builder = new Actions(driver);
		builder.clickAndHold().moveToElement(download1);
		builder.moveToElement(download1).build().perform();
		needToWait(SHORTWAIT);
		WebElement toolTipElement = driver.findElement(By.xpath("//div[contains(text(),'POI Radius Showing ON')]"));
		String actualTooltip = toolTipElement.getText();  
		System.out.println("Actual Title of Tool Tip +++++++++" + actualTooltip);
		Assert.assertEquals(actualTooltip, expectedTooltip);
	}

	// This function is used for Trails On Tool tip
	public void trailsTooltip() {
		String expectedTooltip = "Trails Showing ON";
		WebElement download1 = driver.findElement(By.xpath("//button[contains(@name,'showtrails')]"));
		Actions builder = new Actions(driver);
		builder.clickAndHold().moveToElement(download1);
		builder.moveToElement(download1).build().perform();
		needToWait(SHORTWAIT);
		WebElement toolTipElement = driver.findElement(By.xpath("//div[contains(text(),'Trails Showing ON')]"));
		String actualTooltip = toolTipElement.getText(); 
		System.out.println("Actual Title of Tool Tip +++++++++" + actualTooltip);
		Assert.assertEquals(actualTooltip, expectedTooltip);
	}
	
	public void clickOnLiveTrackingSidebar() {
		waitForElementClickable(liveTrackingSideBar, SHORTWAIT);
		waitForElementVisible(liveTrackingSideBar, SHORTWAIT);
		String browserName = config.getProperty("Browser.Name");
		needToWait(2);
		if (browserName.equalsIgnoreCase("ie")) {
			// WebElement element = driver.findElement(By.xpath("//button[text()='Sign
			// In']"));
			WebElement element = driver.findElement(findLocator(liveTrackingSideBar));
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
		} else {
			safeJavaScriptClick(liveTrackingSideBar);
		}
		log.info("Click on Live Tracking Sidebar successfully");
	}

}
