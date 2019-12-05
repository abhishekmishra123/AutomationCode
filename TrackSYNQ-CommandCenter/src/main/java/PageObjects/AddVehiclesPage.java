package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.log4testng.Logger;

import Common.ActionMethods;
import Common.ConfigManager;

public class AddVehiclesPage extends ActionMethods {

	private String manageVehiclesSideBar = "xpath: //span[text()='Manage Vehicles']";   //span[text()='Cancel']   //span[text()='Update']
	private String groupListSideBar = "xpath://a[text()='Group List']";
	private String addVehiclesHeader = "xpath://div[text()='Add Vehicle']";      //div[text()='Vehicle group name already exists.']  
	
	private String vehicleName = "xpath://label[text()='Vehicle Name']";
	private String vehicleNameField = "xpath://input[@id='vehicle_name']";
	private String uploadButton = "xpath://button[@class='ant-btn uploadVehicleMarkerBtn']";
	private String vehicleDescriptionField = "xpath: //textarea[@id='vehicle_description']";
	private String dashboardPage = "xpath://div[@class='ant-card dynamic-dashboard ant-card-bordered ant-card-wider-padding ant-card-padding-transition']";   
	private String selectAddMarkerImage = "xpath://img[@id='/uploads/device_markers/1560258600223_6.png']";
	//private String deviceIMEINumberPlaceholder = "xpath://div[text()='Please Enter Device IMEI Number']";   /
	private String addMarkerOkButton = "css: .ant-modal-footer  button.ant-btn.ant-btn-primary";
	private String vehicleListData = "xpath://td[text()='Vehicle QA']"; 
	private String updateButton = "xpath://div[@class='ant-col-24']//span[text()='Update']";
//	private String updatedSuccessfullyMessage = "xpath://div[text()='Vehicle Updated successfully.']";   /    
	private String vehicleLinkPath = "xpath://div[@class='ant-card-head-title']";
	private String selectVehicleNameDropdownOptions = "css:ul[class='ant-select-dropdown-menu  ant-select-dropdown-menu-root ant-select-dropdown-menu-vertical'] li:nth-child(num)";
	private String tableListHeadingName = "xpath://th[@class='ant-table-column-has-actions ant-table-column-has-sorters'][num]";
	private String searchField = "css:input.ant-input.ant-select-search__field";
	private String listData = "xpath://tbody[@class='ant-table-tbody']//tr";
	private String addVehicleGroupButton = "xpath://button [@class='ant-btn ant-btn-primary']";
	private String addVehicleGroupHeading = "xpath://div[@id='rcDialogTitle0']";
	private String vehicleGroupDescription = "xpath: //textarea[@id='group_description']";   
	private String cancelbtn = "xpath://button[@class='ant-btn ant-btn-danger']";
	private String viewImage = "xpath://div[@class='ant-col-9 ant-col-xs-24 ant-col-sm-24 ant-col-md-9']";
	//private String editbutton = "xpath:"       //input[@id='group_name']
	//private String groupName = "xpath://td[text()='Vehicle Group QA']";
	

	static WebDriver driver;
	public Logger log = Logger.getLogger(AddVehiclesPage.class);
	ConfigManager config;

	public AddVehiclesPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		config = new ConfigManager();
	}

	// This function is used for Live Tracking side bar
	public String clickOnManageVehiclesSideBar() {
		mouseHover(manageVehiclesSideBar, SHORTWAIT);
		waitForElementClickable(manageVehiclesSideBar, SHORTWAIT);
		waitForElementVisible(manageVehiclesSideBar, SHORTWAIT);
		safeClick(manageVehiclesSideBar, SHORTWAIT);
		return manageVehiclesSideBar;
	}

	// This function is used for Edit button too tip on vehicle list page
	public void editToolTip() {
		String expectedTooltip = "Edit";
		WebElement editTooltip = driver.findElement(By.cssSelector(".ant-btn.ant-btn-primary.ant-btn-circle"));
		Actions actions = new Actions(driver);
		actions.moveToElement(editTooltip).perform();
		WebElement toolTipElement = driver.findElement(By.cssSelector("div[role='tooltip']"));
		needToWait(2);
		String actualTooltip = toolTipElement.getText();
		System.out.println("Actual Title of Tool Tip +++++++++" + actualTooltip);
		Assert.assertEquals(actualTooltip, expectedTooltip);
	}

	// This function is used for Delete button too tip on vehicle list page
	public void deleteToolTip() {
		String expectedTooltip = "Delete";
		WebElement editTooltip = driver.findElement(By.cssSelector(".ant-btn.ant-btn-danger.ant-btn-circle"));
		Actions actions = new Actions(driver);
		actions.moveToElement(editTooltip).perform();
		WebElement toolTipElement = driver.findElement(By.cssSelector("div[role='tooltip']"));
		needToWait(2);
		String actualTooltip = toolTipElement.getText();
		System.out.println("Actual Title of Tool Tip +++++++++" + actualTooltip);
		Assert.assertEquals(actualTooltip, expectedTooltip);
	}

	// This function is used for add vehicle button too tip on vehicle list page
	public void addVehicleToolTip() {
		String expectedTooltip = "Add Vehicle";
		WebElement editTooltip = driver.findElement(By.cssSelector(".ant-btn.ant-btn-primary"));
		Actions actions = new Actions(driver);
		actions.moveToElement(editTooltip).perform();
		WebElement toolTipElement = driver.findElement(By.cssSelector("div[role='tooltip']"));
		needToWait(2);
		String actualTooltip = toolTipElement.getText();
		System.out.println("Actual Title of Tool Tip +++++++++" + actualTooltip);
		Assert.assertEquals(actualTooltip, expectedTooltip);
	}

	// This function is used for add vehicle group button too tip on vehicle list
	// page
	public void addVehicleGroupToolTip() {
		String expectedTooltip = "Add Vehicle Group";
		WebElement editTooltip = driver.findElement(By.cssSelector(".ant-btn.ant-btn-primary"));
		Actions actions = new Actions(driver);
		actions.moveToElement(editTooltip).perform();
		WebElement toolTipElement = driver.findElement(By.cssSelector("div[role='tooltip']"));
		needToWait(2);
		String actualTooltip = toolTipElement.getText();
		System.out.println("Actual Title of Tool Tip +++++++++" + actualTooltip);
		Assert.assertEquals(actualTooltip, expectedTooltip);
	}

	// This function is used for group-list side bar present
	public boolean isGroupListSideBarPresent() {
		return isElementPresent(groupListSideBar, SHORTWAIT);
	}

	// This function is used for dash-board page is present
	public boolean isDashboardPagePresent() {
		return isElementPresent(dashboardPage, SHORTWAIT);
	}

	// This function is used for vehicles-list side bar present
	public boolean isVehicleListSideBarPresent() {
		return isElementPresent(groupListSideBar.replace("Group List", "Vehicle List"), SHORTWAIT);
	}

	// This function is used for Add Vehicles side bar present
	public boolean isAddVehiclesSideBarPresent() {
		return isElementPresent(groupListSideBar.replace("Group List", "Add Vehicle"), SHORTWAIT);
	}

	// This function is used for click on add vehicles button
	public void clickOnAddVehiclesButton() {
		safeClick(groupListSideBar.replace("Group List", "Add Vehicle"), SHORTWAIT);
	}

	// This function is used for homeLinkPath is present on add vehicles page
	public boolean isHomeLinkPresent() {
		return isElementPresent(groupListSideBar.replace("Group List", "Home"), SHORTWAIT);
	}

	// This function is used for manageVehiclesLink is present on add vehicles page
	public boolean isManageVehiclesLinkPresent() {
		return isElementPresent(manageVehiclesSideBar, SHORTWAIT);
	}

	// This function is used for AddVehicleLink is present on add vehicles page
	public boolean isAddVehiclesLinkPresent() {
		return isElementPresent(manageVehiclesSideBar.replace("Manage Vehicles", "Add Vehicle"), SHORTWAIT);
	}

	// This function is used for add vehicles heading on add vehicles page
	public boolean isAddVehiclesHeadingPresent() {
		return isElementPresent(addVehiclesHeader, SHORTWAIT);
	}

	// This function is used for vehicle name Label on add vehicles page
	public boolean isVehicleNameLabelPresent() {
		return isElementPresent(vehicleName, SHORTWAIT);
	}

	// This function is used for device Type Label on add vehicles page
	public boolean isDeviceTypeLabelPresent() {
		return isElementPresent(vehicleName.replace("Vehicle Name", "Device Type"), SHORTWAIT);
	}

	// This function is used for Device Identifier / IMEI No. Label on add vehicles
	// page
	public boolean isDeviceIdentifierIMEINoLabelPresent() {
		return isElementPresent(vehicleName.replace("Vehicle Name", "Device Identifier / IMEI No."), SHORTWAIT);
	}

	// This function is used for Vehicle Group Label on add vehicles page
	public boolean isVehicleGroupLabelPresent() {
		return isElementPresent(vehicleName.replace("Vehicle Name", "Vehicle Group"), SHORTWAIT);
	}

	// This function is used for Country Name Label on add vehicles page
	public boolean isCountryNameLabelPresent() {
		return isElementPresent(vehicleName.replace("Vehicle Name", "Country Name"), SHORTWAIT);
	}

	// This function is used for Mobile No. Label on add vehicles page
	public boolean isMobileNoLabelPresent() {
		return isElementPresent(vehicleName.replace("Vehicle Name", "Mobile No."), SHORTWAIT);
	}

	// This function is used for Accumulator Label on add vehicles page
	public String getTextAccumulatorLabel() {
		String str = safeGetText(vehicleName.replace("Vehicle Name", "Accumulater"), SHORTWAIT);
		return str;
	}

	// This function is used for Marker Image Label on add vehicles page
	public boolean isMarkerImageLabelPresent() {
		return isElementPresent(vehicleName.replace("Vehicle Name", "Marker Image"), SHORTWAIT);
	}

	// This function is used for Vehicle Description Label on add vehicles page
	public boolean isVehicleDescriptionLabel() {
		return isElementPresent(vehicleName.replace("Vehicle Name", "Vehicle Description"), SHORTWAIT);
	}

	// This function is used for vehicle name field on add vehicles page
	public boolean isVehicleNameFieldPresent() {
		return isElementPresent(vehicleNameField, SHORTWAIT);
	}

	// This function is used for device type field on add vehicles page
	public boolean isDeviceTypeFieldPresent() {
		return isElementPresent(addVehiclesHeader.replace("Add Vehicle", "Select Device Type"), SHORTWAIT);
	}

	// This function is used for Device Identifier / IMEI No. field on add vehicles
	// page
	public boolean isDeviceIdentifierIMEINoFieldPresent() {
		return isElementPresent(vehicleNameField.replace("vehicle_name", "imei"), SHORTWAIT);
	}

	// This function is used for vehicles group field on add vehicles page
	public boolean isVehiclesGroupFieldPresent() {
		return isElementPresent(addVehiclesHeader.replace("Add Vehicle", "Select Vehicle Group"), SHORTWAIT);
	}

	// This function is used for country name field on add vehicles page
	public boolean isCountryNameFieldPresent() {
		return isElementPresent(addVehiclesHeader.replace("Add Vehicle", "Select Country Name"), SHORTWAIT);
	}

	// This function is used for mobile no field on add vehicles page
	public boolean isMobileNoFieldPresent() {
		return isElementPresent(vehicleNameField.replace("vehicle_name", "sim_no"), SHORTWAIT);
	}

	// This function is used for accumulator field on add vehicles page
	public boolean isAccumulatorFieldPresent() {
		return isElementPresent(vehicleNameField.replace("vehicle_name", "accumulator"), SHORTWAIT);
	}

	// This function is used for upload button on add vehicles page
	public boolean isUploadButtonPresent() {
		return isElementPresent(uploadButton, SHORTWAIT);
	}

	// This function is used for vehicles description field on add vehicles page
	public boolean isVehicleDescriptionFieldPresent() {
		return isElementPresent(vehicleDescriptionField, SHORTWAIT);
	}

	// This function is used for cancel button on add vehicles page
	public boolean isCancelButtonPresent() {
		return isElementPresent(manageVehiclesSideBar.replace("Manage Vehicles", "Cancel"), SHORTWAIT);
	}

	// This function is used for Save button on add vehicles page
	public boolean isSaveButtonPresent() {
		return isElementPresent(manageVehiclesSideBar.replace("Manage Vehicles", "Save"), SHORTWAIT);
	}

	// This function is used for select marker image on add vehicle page
	public void selectMarkerImage() {
		safeClick(selectAddMarkerImage, MEDIUMWAIT);
	}

	// This function is used for marker image Ok button on add vehicle page
	public void addMarkerOkButton() {
		safeClick(addMarkerOkButton, SHORTWAIT);
		waitForElementVisible(viewImage, SHORTWAIT);
	}

	// This function is used for Device IMEI Number placeholder on add vehicle page
	public String getTextDeviceIdentifier() {
		String DeviceIdentifier = safeGetText(addVehiclesHeader.replace("Add Vehicle", "Please Enter Device IMEI Number"), SHORTWAIT);
		return DeviceIdentifier;
	}

	// This function is used for add vehicle save button on add vehicle page
	public void addVehicleSaveButton() {
		safeJavaScriptClick(addMarkerOkButton.replace(".ant-modal-footer  button.ant-btn.ant-btn-primary",
				".ant-col-24 button.ant-btn.ant-btn-primary"));
	}

	// This function is used for get vehicle added successfully
	public String getTextVehicleAddedSuccessfullyMessage() {
		String successMessage = safeGetText(addVehiclesHeader.replace("Add Vehicle", "Vehicle Added successfully."),
				MEDIUMWAIT);
		return successMessage;
	}

	// This function is used for device limit exceed error message on add vehicle
	// page
	public boolean isDeviceLimitExceedErrorMessagePresent() {
		return isElementPresent(addVehiclesHeader.replace("Add Vehicle", "Your Site Devices limit exceed."), SHORTWAIT);
	}

	// This function is used for IMEI, mobile number and device type is not match
	// error message on add vehicle page
	public boolean isIMEINoMobileNoDeviceTypeErrorMessagePresent() {
		return isElementPresent(addVehiclesHeader.replace("Add Vehicle","This device IMEI no., Mobile no. and Device Type did not match with approved IMEI no., Mobile no. and Device Type."),
				SHORTWAIT);
	}

	// This function is used for click on add vehicle side-bar button
	public void clickonAddVehicleSideBar() {
		safeClick(groupListSideBar.replace("Group List", "Vehicle List"), SHORTWAIT);
	}

	// This function is used for get vehicle list data on vehicle list table
	public String getTextVehicleListData() {
		String VehicleListData = safeGetText(vehicleListData, SHORTWAIT);
		return VehicleListData;
	}

	// This function is used for edit button on vehicle list page
	public void clickOnEditButton() {
		safeClick(addMarkerOkButton.replace(".ant-modal-footer  button.ant-btn.ant-btn-primary",
				".ant-btn.ant-btn-primary.ant-btn-circle"), SHORTWAIT);
	}

	// This function is used for update button on Update Vehicle page
	public void clickOnUpdateButton() {
		safeJavaScriptClick(updateButton);
	}

	// This function is used for updated successfully message
	public String getUpdatedSuccessfullyMessagePresent() {
		String updateSuccessMessage = safeGetText(addVehiclesHeader.replace("Add Vehicle", "Vehicle Updated successfully."), SHORTWAIT);
		return updateSuccessMessage;
	}

	// This function is used for click on vehicle list side bar
	public void clickOnVehicleListSideBar() {
		safeClick(groupListSideBar.replace("Group List", "Vehicle List"), SHORTWAIT);

	}

	// This method is used for cancel button on vehicle list page
	public void clickOnCancelButton() {
		safeJavaScriptClick(manageVehiclesSideBar.replace("Manage Vehicles", "Cancel"));
	}

	// This method is used for delete button functionality on vehicle list page
	public void clickOnDeleteButton() {
		safeClick(addMarkerOkButton.replace(".ant-modal-footer  button.ant-btn.ant-btn-primary",
				".ant-btn.ant-btn-danger.ant-btn-circle"), MEDIUMWAIT);
	}

	// This function is used for click on yes button
	public void clickOnYesButton() {
		safeJavaScriptClick(manageVehiclesSideBar.replace("Manage Vehicles", "Yes"));
	}

	// This function is used for get vehicle deleted successfully
	public String getTextVehicleDeletedSuccessfullyMessage() {
		String successMessage = safeGetText(
				addVehiclesHeader.replace("Add Vehicle", "Vehicle deleted successfully."),MEDIUMWAIT);
		return successMessage;
	}
    

	// This function is used for get vehicle group deleted successfully
	public String getTextVehicleGroupDeletedSuccessfullyMessage() {
		String successMessage = safeGetText(
				addVehiclesHeader.replace("Add Vehicle", "Vehicle group deleted successfully."),MEDIUMWAIT);
		return successMessage;
	}

	
	// This function is used for click on yes button on pop-up
	public void clickOnNOButton() {
		safeJavaScriptClick(manageVehiclesSideBar.replace("Manage Vehicles", "No"));
	}

	// This function is used for Vehicles List link path
	public boolean isVehiclesListLinkPathPresent() {
		return isElementPresent(vehicleLinkPath, SHORTWAIT);
	}

	// This function is used for vehicle name drop-down
	public void clickOnVehicleNameDropdownButton() {
		safeClick(vehicleLinkPath.replace("ant-card-head-title", "ant-select ant-select-enabled"), MEDIUMWAIT);
	}

	// This function is used for selected VehicleName Drop-down Options on vehicle
	// list page
	public boolean isselectVehicleNameDropdownOptionsPresent(int num) {
		return isElementVisible(selectVehicleNameDropdownOptions.replace("num", num + ""), SHORTWAIT);
	}

	// This function is used for page limit placeholder on vehicle list page
	public boolean isPageLimitPlaceholderPresent() {
		return isElementPresent(addVehiclesHeader.replace("Add Vehicle", "Page Limit"), SHORTWAIT);
	}

	// This function is used for search placeholder on vehicle list page
	public boolean isSearchPlaceholderPresent() {
		return isElementVisible(addVehiclesHeader.replace("Add Vehicle", "Search"), SHORTWAIT);
	}

	// This function is used for add vehicle button on vehicle list page
	public boolean isAddVehicleButtonPresent() {
		return isElementVisible(uploadButton.replace("ant-btn uploadVehicleMarkerBtn", "ant-btn ant-btn-primary"),
				SHORTWAIT);
	}

	// This function is used for heading list name on vehicle list page
	public boolean isVehicleListHeadingNamePresent(int num) {
		return isElementVisible(tableListHeadingName.replace("num", num + ""), SHORTWAIT);
	}

	// This function is used for Command heading name present on vehicle list page
	public boolean isCommandHeadingNamePresent() {
		return isElementPresent(addVehiclesHeader.replace("Add Vehicle", "Command"), SHORTWAIT);
	}

	// This function is used for Geo Fence Name present on vehicle list page
	public boolean isGeoFenceNameHeadingNamePresent() {
		return isElementPresent(addVehiclesHeader.replace("Add Vehicle", "Geo Fence Name"), SHORTWAIT);
	}

	// This function is used for Action Name present on vehicle list page
	public boolean isActionHeadingNamePresent() {
		return isElementPresent(addVehiclesHeader.replace("Add Vehicle", "Action"), SHORTWAIT);
	}

	// This function is used for edit button is present on vehicle list page
	public boolean isEditButtonPresent() {
		return isElementVisible(
				uploadButton.replace("ant-btn uploadVehicleMarkerBtn", "ant-btn ant-btn-primary ant-btn-circle"),
				SHORTWAIT);
	}

	// This function is used for delete button is present on vehicle list page
	public boolean isDeleteButtonPresent() {
		return isElementVisible(
				uploadButton.replace("ant-btn uploadVehicleMarkerBtn", "ant-btn ant-btn-danger ant-btn-circle"),
				SHORTWAIT);
	}

	// This function is used for pagination on vehicle list page
	public boolean isPaginationPresent() {
		return isElementVisible(addMarkerOkButton.replace(".ant-modal-footer  button.ant-btn.ant-btn-primary",
				".ant-pagination.ant-table-pagination.mini"), SHORTWAIT);
	}

	// This function is used for click on right side add vehicle button on vehicle
	// list page
	public void clickOnAddVehicleButton() {
		safeClick(addMarkerOkButton.replace(".ant-modal-footer  button.ant-btn.ant-btn-primary",
				".ant-btn.ant-btn-primary"), SHORTWAIT);
	}

	// This function is used for get no data on vehicle list page
	public boolean isNoDatamessagePresent() {
		return isElementVisible(addVehiclesHeader.replace("Add Vehicle", "No data"), SHORTWAIT);
	}

	// This function is used for enter data in search field on vehicle list page
	public void searchField(String name) {
		safeType(addVehiclesHeader.replace("Add Vehicle", "Search"), name);
		;
	}

	// This function is used for search vehicle name data on vehicle list page
	public void searchVehicle(String searchVeh) {
		waitForPageToLoad();
		waitForElementPresent(searchField, SHORTWAIT);
		safeClearAndType(searchField, searchVeh, SHORTWAIT);
		log.info("search Vehicle");
	}

	// This function is used for selected VehicleName Drop-down Options on vehicle
	// list page
	public boolean selectVehicleNameDropdownOption(int num) {
		safeClick(selectVehicleNameDropdownOptions.replace("num", num + ""), SHORTWAIT);
		return false;
	}

	// This function is used for click on table heading in vehicle list page
	public void clickOnTableHeading() {
		safeClick(addMarkerOkButton.replace(".ant-modal-footer  button.ant-btn.ant-btn-primary",
				".ant-table-column-has-actions.ant-table-column-has-sorters.ant-table-column-sort"), SHORTWAIT);
	}

	// This function is used for heading list data in vehicle list page
	public boolean isVehicleHeadingListData() {
		return isElementVisible(listData, LONGWAIT);
	}

	// This function is used for click on group-list side bar
	public void clickOnGroupListSideBar() {
		safeClick(groupListSideBar, SHORTWAIT);
	}

	// This function is used for group list link path present
	public boolean isGroupLinkPathPresent() {
		return isElementPresent(manageVehiclesSideBar.replace("Manage Vehicles", "Group List"), SHORTWAIT);
	}

	// This function is used for vehicle name drop-down
	public void clickOnGroupNameDropdownButton() {
		safeClick(vehicleLinkPath.replace("ant-card-head-title", "ant-select ant-select-enabled"), MEDIUMWAIT);
	}

	// This function is used for click on add vehicle group button
	public void clickOnAddVehicleGroupButton() {
		safeClick(addVehicleGroupButton, SHORTWAIT); // span[text()=' Add Vehicle Group']
	}

	// This function is used for add vehicle group heading present on pop-up
	public boolean isAddVehicleGroupHeadingNamePresent() {
		return isElementPresent(addVehicleGroupHeading, SHORTWAIT);
	}

	// This function is used for vehicle group name Label present on pop-up
	public boolean isVehicleGroupNameLabelPresent() {
		return isElementPresent(vehicleName.replace("Vehicle Name", "Vehicle Group Name"), SHORTWAIT);
	}

	// This function is used for Vehicle Group Description Label present on pop-up
	public boolean isVehicleGroupDescriptionLabelPresent() {
		return isElementPresent(vehicleName.replace("Vehicle Name", "Vehicle Group Description"), SHORTWAIT);
	}

	// This function is used for cross icon is present on pop-up
	public boolean isCrossIconPresent() {
		return isElementPresent(addMarkerOkButton.replace(".ant-modal-footer  button.ant-btn.ant-btn-primary",".anticon.anticon-close.ant-modal-close-icon"), SHORTWAIT);
	}

	// This function is used for vehicle group name placeholder is present on add
	// vehicle group pop-up vehicleGroupDescription
	public String getVechicleGroupNamePlaceholder() {
		String VechicleGroupNamePlaceholderText = safeGetAttribute(vehicleNameField.replace("vehicle_name", "group_name"), "placeholder", SHORTWAIT);
		log.info("get Vechicle Group Name placeholder ");
		return VechicleGroupNamePlaceholderText;
	}

	// This function is used for vehicle group description placeholder is present on
	// add vehicle group pop-up
	public String getVehicleGroupDescriptionPlaceholder() {
		String VechicleGroupDescriptionPlaceholderText = safeGetAttribute(vehicleGroupDescription, "placeholder",
				SHORTWAIT);
		log.info("get Vechicle Group description placeholder ");
		return VechicleGroupDescriptionPlaceholderText;
	}

	// This function is used for click on save button on add vehicle group pop-up
	// window
	public void clickOnSaveButton() {
		safeJavaScriptClick(manageVehiclesSideBar.replace("Manage Vehicles", "Save"));
	}

	// This function is used for get vehicle group name validation message on add vehicle group pop-up
	public String getTextVehicleGroupNameValidationMessage() {
		String str = safeGetText(addVehiclesHeader.replace("Add Vehicle", "Please Input Vehicle Group Name"), SHORTWAIT);
		return str;
	}
   
	// This function is used for enter data in vehicle group name field on pop-up window
	public void addVehicleGroupDetails(String VehicleGroupName, String VehicleGroupDescription) {
		safeType(vehicleNameField.replace("vehicle_name", "group_name"), VehicleGroupName);
		safeType(vehicleGroupDescription, VehicleGroupDescription);
	}

   // This function is used for get validation message when user enter invalid data in add vehicle group field on pop-up window
	public String getAddVehicleGroupValidationMessage() {
           String str = safeGetText(addVehiclesHeader.replace("Add Vehicle", "Please Input Valid Group Name"), SHORTWAIT);
		   return str;
	}

	public void vehicleGroupNameField(String VehicleGroupName) {
		safeType(vehicleNameField.replace("vehicle_name", "group_name"), VehicleGroupName);
	}
	
	// This function is used for get vehicle added successfully
		public String getTextAddVehicleGroupAddedSuccessfullyMessage() {
			String successMessage = safeGetText(addVehiclesHeader.replace("Add Vehicle", "Vehicle group added successfully."),MEDIUMWAIT);
			return successMessage;
	}
	
		// This function is used for get vehicle list data on vehicle list table
		public String getTextGroupListData() {
			String VehicleListData = safeGetText(vehicleListData.replace("Vehicle QA", "Vehicle 02"), SHORTWAIT);
			return VehicleListData;
		}	
		
		// This function is used for enter same data in vehicle group name field on add vehicle group popup
		public String getTextVehicleGroupNamevalidationMessage() {
			String str = safeGetText(addVehiclesHeader.replace("Add Vehicle", "Vehicle group name already exists."), MEDIUMWAIT);
			return str;
		}
		
	   // This function is used for edit button on group list page
		public void groupListEdit(String vehicleGroupName) {
			safeClearAndType(vehicleNameField.replace("vehicle_name", "group_name"), vehicleGroupName, SHORTWAIT);
		}
       
		// This function is used for updated successfully message
		public boolean isGroupListUpdatedSuccessfullyMessagePresent() {
			return isElementPresent(addVehiclesHeader.replace("Add Vehicle", "Group updated successfully."), MEDIUMWAIT);
		}
	
		// This function is used for group list update button 
		public void clickOnUpdateBtnGroupList() {
			safeJavaScriptClick(manageVehiclesSideBar.replace("Manage Vehicles", "Update"));
		}
		
		// This function is used for wait for visible image
		public void isImagePresent() {
			
		}
}
