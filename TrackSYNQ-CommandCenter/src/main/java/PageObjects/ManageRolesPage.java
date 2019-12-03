package PageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import Common.ConfigManager;
import Common.ActionMethods;

public class ManageRolesPage extends ActionMethods {

	private String manageRolesSidebar = "xpath://body//li[5]";
	private String manageRolesRoleListSidebar = "xpath://a[contains(text(),'Role List')]";
	private String manageRoleslink = "xpath://div[@class='ant-breadcrumb']//span[text()= 'Manage Roles']";
	private String userListDropDown = "xpath://div[@class='ant-select-selection-selected-value']";
	private String manageRolesTitleOption = "xpath://li[text()='txt']";
	private String searchFieldPlaceholder = "xpath://div[text()='Search']";
	private String addRolePermissionHeader = "css:table.mainTable tr th:nth-child(num)";
	private String roleTitlefield = "xpath://input[@id='group_name']";
	private String roleTitleLabel = "css:label[title=\"Role Title\"]";
	private String roleDescriptionfield = "xpath://textarea[@id='group_description']";
	private String checkAllCheckBox = "xpath://label[@class='mainTable ant-checkbox-wrapper']//span[@class='ant-checkbox']";
	private String roleTitlePlaceholder = "css:input[placeholder='Enter Role Title']";
	private String roleDescriptionPlaceholder = "css:textarea[placeholder='Enter Role Description']";
	private String roleTitleErrorMsg = "xpath://div[contains(text(),'Please Enter Role Title')] ";
	private String roleListTitle = "xpath://td[contains(text(),'QA_Testing')]";
	private String roleDelete = "xpath://td[text()='txt']/following-sibling::td[6]//span[1]//button[@class='ant-btn ant-btn-danger ant-btn-circle']";
	private String deleteYesButton = "xpath://div[@class='ant-confirm-btns']//button[@class='ant-btn ant-btn-primary']";
	private String editIconTooltip = "xpath://td[text()='QA_Testing1']/following-sibling::td[6]//span[1]//a[1]//button";
	private String editRoleUpdateButton = "xpath://span[text()='Update']";
	private String roleUpdateErrorMessage = "xpath://div[text()='Role permission is required.']";
	private String manageHistoryCheckedCheckBox = "xpath://tr[3]//td[5]//label[1]//span[@class='ant-checkbox ant-checkbox-checked']";
	private String noDataMessage = "css:div.ant-table-placeholder";
	private String manageDashboardPermission = "xpath://span[contains(text(),'Manage Dashboard')]";
	private String manageDashboardViewcheckbox = "xpath://span[@class='ant-checkbox ant-checkbox-checked']";
	private String manageHistoryExportCheckbox = "xpath://tr[3]//td[num]//label[1]//span[@class='ant-checkbox']";
	private String manageHistoryPermission = "xpath://td[contains(text(),'Manage History')]";
	private String manageUsersAddCheckbox = "xpath://tr[4]//td[num]//label[1]//span[@class='ant-checkbox']";
	private String manageRolesPermission = "xpath://td[@class='withoutSubData']//span[contains(text(),'Manage Roles')]";
	private String manageRolesCheckbox = "xpath://tr[5]//td[num]//label[1]//span[@class='ant-checkbox']";
	private String globalSettingPermission = "xpath://td[@class='roleHeading']//span[contains(text(),'Global Settings')]";
	private String manageEmailSettingsCheckbox = "xpath://tr[6]//td[num]//label[1]//span[@class='ant-checkbox']";
	private String dashboardCheckedCheckBox = "xpath://tr[2]//td[6]//span[@class='ant-checkbox ant-checkbox-checked']";
	private String dashboardUncheckCheckBox = "xpath://tr[2]//td[6]//span[@class='ant-checkbox']";
	private String liveTrackingViewRights = "xpath://tr[num]//td[6]//label[1]//span[@class='ant-checkbox ant-checkbox-checked']";

	
	
	
	
	
	
	static WebDriver driver;
	public String errorMsg;
	public String backgroundColor, color, fontFamily;

	public Logger log = Logger.getLogger(ManageRolesPage.class);
	ConfigManager config;

	public ManageRolesPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		config = new ConfigManager();
	}

	// This function is used for click on Report manage Role side bar side bar
	public void clickOnManageRolesSidebar() {
		mouseHover(manageRolesSidebar, LONGWAIT);
		safeClick(manageRolesSidebar, SHORTWAIT);
	}

	// This function is used for click on Report manager
	public boolean isManageRoles_RoleListPresent() {
		mouseHover(manageRolesSidebar, LONGWAIT);
		mouseHover(manageRolesRoleListSidebar, MEDIUMWAIT);
		return isElementVisible(manageRolesRoleListSidebar, LONGWAIT);
	}

	public boolean isManageRoles_AddRolePresent() {
		mouseHover(manageRolesSidebar, LONGWAIT);
		mouseHover(manageRolesRoleListSidebar, MEDIUMWAIT);
		return isElementVisible(manageRolesRoleListSidebar.replace("Role List", "Add Role"), LONGWAIT);
	}

	public void clickOnReportsManageRolesList() {
		mouseHover(manageRolesSidebar, LONGWAIT);
		mouseHover(manageRolesRoleListSidebar, MEDIUMWAIT);
		safeClick(manageRolesRoleListSidebar, MEDIUMWAIT);
	}

	public boolean isManageRoleslinkPresent() {
		return isElementVisible(manageRoleslink, LONGWAIT);
	}

	public boolean isRoleListlinkPresent() {
		return isElementVisible(manageRoleslink.replace("Manage Roles", "Role List"), LONGWAIT);
	}

	public void clickOnUserListDropDown() {
		safeClick(userListDropDown,SHORTWAIT);

	}

	public boolean isManageRolesTitleOptionPresent(String txt) {

		return isElementVisible(manageRolesTitleOption.replace("txt", txt+""), LONGWAIT);
	}

//	public boolean isManageAddRolesOPtionPresent(String txt) {
//		return isElementVisible(manageRolesTitleOption.replace("txt", txt+""), LONGWAIT);
//	}

	public String getSearchPlaceholderText() {
		String searchPlaceholder = safeGetText(searchFieldPlaceholder, SHORTWAIT);
		return searchPlaceholder;
	}

	public void clickOnAddRoleSideBar() {
		safeClick(manageRolesRoleListSidebar.replace("Role List", "Add Role"), MEDIUMWAIT);

	}

	public boolean isAddRolePermissionHeaderPresent(int num) {
		return isElementPresent(addRolePermissionHeader.replace("num", num + ""), SHORTWAIT);

	}

	public boolean isRoleTitlefieldPresent() {
		return isElementPresent(roleTitlefield, SHORTWAIT);

	}

	public boolean isRoleTitleLabelPresent() {
		return isElementPresent(roleTitleLabel, SHORTWAIT);

	}

	public boolean isRoleDescriptionfieldPresent() {
		return isElementPresent(roleDescriptionfield, SHORTWAIT);

	}

	public boolean isRoleDescriptionLabelPresent() {
		return isElementPresent(roleTitleLabel.replace("Role Title", "Role Description"), SHORTWAIT);

	}

	public boolean isCheckAllCheckBoxPresent() {
		return isElementPresent(checkAllCheckBox, SHORTWAIT);

	}

	public boolean isCheckAllTextPresent() {
		return isElementPresent(checkAllCheckBox, SHORTWAIT);

	}

	public boolean isRoleTitlePlaceholderPresent() {
		return isElementPresent(roleTitlePlaceholder, SHORTWAIT);

	}

	public boolean isRoleDescriptionPlaceholderPresent() {
		return isElementPresent(roleDescriptionPlaceholder, SHORTWAIT);

	}

	public String getRoleTitleErrorMessage() {
		String RoleTitleErrorMessage = safeGetText(roleTitleErrorMsg, LONGWAIT);
		return RoleTitleErrorMessage;

	}

	public void checkAllCheckBox() {
		safeJavaScriptClick(checkAllCheckBox);
	}

	public void enterRoleTitle(String RoleTitel) {
		safeClearAndType(roleTitlefield, RoleTitel, SHORTWAIT);
	}

	public void enterRoleDescription(String RoleDescription) {
		safeClearAndType(roleDescriptionfield, RoleDescription, SHORTWAIT);
	}

	public boolean isAddedRolePresent() {
		return isElementPresent(roleListTitle, LONGWAIT);

	}

	public void editToolTip() {
		String expectedTooltip = "Edit";
		WebElement editTolltip = driver
				.findElement(By.xpath("//td[text()='QA_Testing1']/following-sibling::td[6]//span[1]//a[1]//button"));
		Actions actions = new Actions(driver);
		actions.moveToElement(editTolltip).perform();
		WebElement toolTipElement = driver.findElement(By.cssSelector("div[role='tooltip']"));
		needToWait(2);
		String actualTooltip = toolTipElement.getText();
		System.out.println("Actual Title of Tool Tip +++++++++" + actualTooltip);
		Assert.assertEquals(actualTooltip, expectedTooltip);

	}

	public void clickOnRoleDelete(String txt) {
		safeClick(roleDelete.replace("txt", txt + ""), SHORTWAIT);
		safeClick(deleteYesButton, SHORTWAIT);
	}

	public void clickOnRoleEdit(String txt) {
		safeClick(roleDelete.replace("txt", txt + "").replace("ant-btn ant-btn-danger ant-btn-circle",
				"ant-btn ant-btn-primary ant-btn-circle"), SHORTWAIT);

	}

	public void clickOnEditIcon() {
		safeClick(editIconTooltip, SHORTWAIT);

	}

	public boolean isCheckedAllCheckBoxPresent() {
		return isElementPresent(checkAllCheckBox.replace("ant-checkbox", "ant-checkbox ant-checkbox-checked"),
				LONGWAIT);
	}

	public void clickOnEditRoleUpdateButton() {
		safeJavaScriptClick(editRoleUpdateButton);
	}

	public String roleUpdateErrorPopup() {
		String roleUpdateError = safeGetText(roleUpdateErrorMessage, SHORTWAIT);
		return roleUpdateError;
	}

	public void clickOnManageHistoryCheckedCheckBox() {
		
		safeJavaScriptClick(manageHistoryCheckedCheckBox);
	}

	public void clickOnManageHistoryUnCheckedCheckBox() {
		waitForElementClickable(manageHistoryCheckedCheckBox.replace("ant-checkbox ant-checkbox-checked", "ant-checkbox"), SHORTWAIT);
		safeJavaScriptClick(manageHistoryCheckedCheckBox.replace("ant-checkbox ant-checkbox-checked", "ant-checkbox"));
	}
	
	
	
	public String roleAddedSuccessMessage() {
		String SuccessMessage = safeGetText(
				roleUpdateErrorMessage.replace("Role permission is required.", "User role added successfully."),
				SHORTWAIT);
		return SuccessMessage;
	}
	
	public String deplicateRoleAddedErrorMessage() {
		String SuccessMessage = safeGetText(
				roleUpdateErrorMessage.replace("Role permission is required.", "Role Title already exists."),
				SHORTWAIT);
		return SuccessMessage;
	}

	public String roleUpdateSuccessMessage() {
		String SuccessMessage = safeGetText(
				roleUpdateErrorMessage.replace("Role permission is required.", "Role updated successfully."),
				SHORTWAIT);
		return SuccessMessage;
	}

	public String roleDeleteMessage() {
		String SuccessMessage = safeGetText(
				roleUpdateErrorMessage.replace("Role permission is required.", "Role deleted successfully."),
				SHORTWAIT);
		return SuccessMessage;
	}

	public boolean isNoDataMessagePresence() {
		return isElementVisible(noDataMessage, MEDIUMWAIT);
	}

	public boolean isManageDashboardPresence() {
		return isElementVisible(manageDashboardPermission, SHORTWAIT);
	}

	public boolean isManageDashboardViewPresence() {
		return isElementVisible(manageDashboardViewcheckbox, SHORTWAIT);
	}

	public boolean isManageLiveTrackingPresence() {
		return isElementVisible(manageDashboardPermission.replace("Manage Dashboard", "Manage Tracking"), SHORTWAIT);
	}

	public boolean isManageHistoryPresence() {
		return isElementVisible(manageHistoryPermission, SHORTWAIT);
	}

	public boolean isManageHistoryExportCheckboxPresence(int num) {
		return isElementVisible(manageHistoryExportCheckbox.replace("num", num + ""), SHORTWAIT);
	}

	public boolean isManageHistoryViewCheckboxPresence(int num) {
		return isElementVisible(manageHistoryExportCheckbox.replace("num", num + ""), SHORTWAIT);
	}

	public boolean isManageUsersPresence() {
		return isElementVisible(manageDashboardPermission.replace("Manage Dashboard", "Manage Users"), SHORTWAIT);
	}

	public boolean isManageUsersAddCheckboxPresence(int num) {
		return isElementVisible(manageUsersAddCheckbox.replace("num", num + ""), SHORTWAIT);
	}

	public boolean isManageUsersUpdateCheckboxPresence(int num) {
		return isElementVisible(manageUsersAddCheckbox.replace("num", num + ""), SHORTWAIT);
	}

	public boolean isManageUsersDeleteCheckboxPresence(int num) {
		return isElementVisible(manageUsersAddCheckbox.replace("num", num + ""), SHORTWAIT);
	}

	public boolean isManageUsersViewCheckboxPresence(int num) {
		return isElementVisible(manageUsersAddCheckbox.replace("num", num + ""), SHORTWAIT);
	}

	public boolean isManageRolesPermissionPresence() {
		return isElementVisible(manageRolesPermission, SHORTWAIT);
	}

	public boolean isManageRolesCheckboxPresence(int num) {
		return isElementVisible(manageRolesCheckbox.replace("num", num + ""), SHORTWAIT);
	}

	public boolean isManageRolesUpdateCheckboxPresence(int num) {
		return isElementVisible(manageRolesCheckbox.replace("num", num + ""), SHORTWAIT);
	}

	public boolean isManageRolesDeleteCheckboxPresence(int num) {
		return isElementVisible(manageRolesCheckbox.replace("num", num + ""), SHORTWAIT);
	}

	public boolean isManageRolesViewCheckboxPresence(int num) {
		return isElementVisible(manageRolesCheckbox.replace("num", num + ""), SHORTWAIT);
	}

	public boolean isGlobalSettingPermissionPresence() {
		return isElementVisible(globalSettingPermission, SHORTWAIT);
	}

	public boolean isManageEmailSettingsboxPresence() {
		return isElementVisible(manageHistoryPermission.replace("Manage History", "Manage Email Settings"), SHORTWAIT);
	}

	public boolean isManageEmailSettingsUpdateCheckboxPresence(int num) {
		return isElementVisible(manageEmailSettingsCheckbox.replace("num", num + ""), SHORTWAIT);
	}

	public boolean isManageEmailSettingsViewCheckboxPresence(int num) {
		return isElementVisible(manageEmailSettingsCheckbox.replace("num", num + ""), SHORTWAIT);
	}

	public String userAddedSuccessMessage() {
		String SuccessMessage = safeGetText(
				roleUpdateErrorMessage.replace("Role permission is required.", "User created successfully."),
				SHORTWAIT);
		return SuccessMessage;
	}

	public void clicOnDashboardCheckedCheckBox() {
		scrollIntoViewThroughJavaScriptExecuter(dashboardCheckedCheckBox);
		waitForElementVisible(dashboardCheckedCheckBox, SHORTWAIT);
		safeJavaScriptClick(dashboardCheckedCheckBox);
	}

	public void clicOnDashboardUncheckCheckBox() {
		scrollIntoViewThroughJavaScriptExecuter(dashboardUncheckCheckBox);
		waitForElementVisible(dashboardUncheckCheckBox, SHORTWAIT);
		safeJavaScriptClick(dashboardUncheckCheckBox);
	}

	public void clickOnManageSitesViewRights(int num) {
		safeJavaScriptClick(liveTrackingViewRights.replace("num", num + ""));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
