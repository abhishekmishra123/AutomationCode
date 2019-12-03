package PageObjects;

import java.util.function.Function;

import org.apache.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import Common.ConfigManager;
import Common.ActionMethods;


public class ManageGeoFencePage extends ActionMethods {

	private String manageGeoFenceSidebar = "xpath://body//li[9]";
	private String manageGeoFenceSubmoduleSidebar = "xpath://a[contains(text(),'txt')]";
	private String manageGeoFenceLinkPath = "xpath://span[@class='ant-breadcrumb-link'][contains(text(),'Manage Geo Fence')]";
	private String addGeoFenceGroupPopup = "xpath://div[@class='ant-modal-content']//div[@class='ant-modal-body']";
	private String addGeoFenceGroupPopupLabels = "xpath://label[contains(text(),'txt')]";
	private String addGeoFenceGroupPopupGroupNameField = "css:input#group_name";
	private String addGeoFenceGroupPopupGroupDescField = "css:textarea#group_description";
	private String addGeoFenceGroupSaveButton = "xpath://button//span[contains(text(),'Save')]";
	private String addGeoFenceGroupCancelButton = "xpath://button//span[contains(text(),'Cancel')]";
	private String addGeoFenceGroupNameFieldPlaceholder = "css:#group_name";
	private String fieldErrorMessage = "xpath://div[text()='txt']";
	private String groupName = "xpath://td[contains(text(),'My Office')]";
	private String outSidePopup = "css:div.ant-modal-wrap ";
	private String addGeoFenceGroup = "xpath://div[@class='ant-modal-mask']";
	private String editIconTooltip = "xpath:/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[6]/span[1]/button[1]";
	private String deleteIconTooltip = "xpath://tr[1]//td[6]//span[1]//button[2]";
	private String deleteYesButton = "xpath://div[@class='ant-confirm-btns']//button[@class='ant-btn ant-btn-primary']";
	private String deleteGroupErrorMessage = "xpath://div[text()='Geo fence group deleted successfully.']";
	private String googleMap = "xpath://div[@class='leaflet-container leaflet-touch leaflet-fade-anim leaflet-grab leaflet-touch-drag leaflet-touch-zoom']";
	private String drawAShapeErrorMessage = "xpath://span[text()='Please Draw Valid Shape!']";
	private String enterLocation = "xpath://input[@class='glass ']";
	private String selectLocation ="xpath://div[text()='Indore, Madhya Pradesh, 452001, India']";
	private String drawCircle ="xpath://a[@class=\"leaflet-draw-draw-circle\"]";
	private String drawpolygon ="xpath://a[@class='leaflet-draw-draw-polygon']";
	
	
	
	

	static WebDriver driver;
	public Logger log = Logger.getLogger(ManageGeoFencePage.class);
	ConfigManager config;

	public ManageGeoFencePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		config = new ConfigManager();
	}

	// This function is used for click on manage Geo fence side bar
	public void clickOnManageGeoFenceSidebar() {
		safeClick(manageGeoFenceSidebar, SHORTWAIT);

	}

	// This function is used for check the presence of sub module of manage geo
	// fence
	public boolean isManageGeoFenceSubmoduleSidebarPresent(String txt) {
		return isElementVisible(manageGeoFenceSubmoduleSidebar.replace("txt", txt + ""), SHORTWAIT);
	}

	// This function is used for click on group list bar
	public void clickOnManageGeoFenceGroupListSidebar(String txt) {
		safeClick(manageGeoFenceSubmoduleSidebar.replace("txt", txt + ""), SHORTWAIT);

	}

	// This function is used for check the presence of the geo fence link path
	public boolean isManageGeoFenceLinkPathPresent() {
		return isElementVisible(manageGeoFenceLinkPath, SHORTWAIT);
	}

	// This function is used for check the presence of Fence Group List Link Path
	public boolean isManageGeoFenceGroupListLinkPathPresent(String txt) {
		return isElementVisible(manageGeoFenceSubmoduleSidebar.replace("txt", txt + ""), SHORTWAIT);

	}

	// This function is used for the add geo fence pop-up present
	public boolean isAddGeoFenceGroupPopupPresent() {
		return isElementVisible(addGeoFenceGroupPopup, SHORTWAIT);
	}

	// This function is used for the verify the label on add geo fence popup
	public boolean isAddGeoFenceGroupPopupLabelsPresent(String txt) {
		return isElementVisible(addGeoFenceGroupPopupLabels.replace("txt", txt + ""), SHORTWAIT);
	}

	// This function is used for the verify the group name field on add geo fence
	// popup
	public boolean isAddGeoFenceGroupPopupGroupNameFieldPresent() {
		return isElementVisible(addGeoFenceGroupPopupGroupNameField, SHORTWAIT);
	}

	// This function is used for the verify the group description field on add geo
	// fence popup
	public boolean isAddGeoFenceGroupPopupGroupDescFieldPresent() {
		return isElementVisible(addGeoFenceGroupPopupGroupDescField, SHORTWAIT);
	}

	// This function is used for the save button present
	public boolean isAddGeoFenceGroupSaveButtonPresent() {
		return isElementVisible(addGeoFenceGroupSaveButton, SHORTWAIT);
	}

//This function used for the cancel button present 
	public boolean isAddGeoFenceGroupCancelButtonPresent() {
		return isElementVisible(addGeoFenceGroupCancelButton, SHORTWAIT);
	}

	// This function is used for the verify the presence of Group name placeholder
	public String getAddGeoFenceGroupNameFieldPlaceholderText() {

		String GroupNamePlaceholder = safeGetAttribute(addGeoFenceGroupNameFieldPlaceholder, "Placeholder", SHORTWAIT);
		return GroupNamePlaceholder;
	}

	// This function is used for the verify the presence of description placeholder
	public String getAddGeoFenceGroupDescFieldPlaceholderText() {
		String GroupDescPlaceholder = safeGetAttribute(
				addGeoFenceGroupNameFieldPlaceholder.replace("group_name", "group_description"), "Placeholder",
				SHORTWAIT);
		return GroupDescPlaceholder;
	}

	// This function is used for click on save button
	public void clickOnSaveButton() {
		safeJavaScriptClick(addGeoFenceGroupSaveButton);

	}

	// This function is used for first name field error message
	public String getGroupNameFieldErrorMessageText() {

		String groupNameErrorMessage = safeGetText(
				fieldErrorMessage.replace("txt", "Please Input Geo Fence Group Name"), SHORTWAIT);
		return groupNameErrorMessage;
	}

	// This function is used for enter details for Add Geo Fence Name
	public void enterAddGeoFenceDetails(String geoFenceName, String geoFenceDesc) {
		safeClearAndType(addGeoFenceGroupNameFieldPlaceholder, geoFenceName, SHORTWAIT);
		safeClearAndType(addGeoFenceGroupNameFieldPlaceholder.replace("group_name", "group_description"), geoFenceDesc,
				SHORTWAIT);
	}

	// This function is used for enter invalid data
	public boolean isGroupNameErrorMessageInvalidData() {
		return isElementVisible(fieldErrorMessage.replace("txt", "Please enter valid group name"), SHORTWAIT);
	}

	// This function is used for first name field text
	public String getGroupNameFieldText() {

		String groupNameText = safeGetText(groupName, LONGWAIT);
		return groupNameText;
	}

	// This function is used for the click on screen
	public void clickOutSidePopup() {
		safeClick(outSidePopup, SHORTWAIT);
	}

	// This function is used for verify the presence add geo fence popup
	public boolean isAddGeoFenceGroupPopUp() {
		return isElementVisible(addGeoFenceGroup, LONGWAIT);
	}

	public void editToolTip() {
		String expectedTooltip = "Edit";

		WebElement editTolltip = driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[6]/span[1]/button[1]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(editTolltip).perform();
		WebElement toolTipElement = driver.findElement(By.cssSelector("div[role='tooltip']"));
		needToWait(2);
		String actualTooltip = toolTipElement.getText();
		System.out.println("Actual Title of Tool Tip +++++++++" + actualTooltip);
		Assert.assertEquals(actualTooltip, expectedTooltip);
	}

	public void clickOnEditIcon() {
		safeClick(editIconTooltip, SHORTWAIT);

	}

	public void clickOnDeleteIcon() {
		safeClick(deleteIconTooltip, SHORTWAIT);
		safeClick(deleteYesButton, SHORTWAIT);

	}

	// This function is used for get text of Group name
	public String getGroupNameText() {

		String groupNameText = safeGetText(groupName, SHORTWAIT);
		return groupNameText;
	}

	public void deleteIconToolTip() {
		String expectedTooltip = "Delete";

		WebElement editTolltip = driver.findElement(By.xpath("//tr[1]//td[6]//span[1]//button[2]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(editTolltip).perform();
		WebElement toolTipElement = driver.findElement(By.cssSelector("div[role='tooltip']"));
		needToWait(2);
		String actualTooltip = toolTipElement.getText();
		System.out.println("Actual Title of Tool Tip +++++++++" + actualTooltip);
		Assert.assertEquals(actualTooltip, expectedTooltip);

	}

	// This function is used for get text of delete Group Error Message Text
	public String getDeleteGroupErrorMessageText() {

		String deleteGroupErrorMessageText = safeGetText(deleteGroupErrorMessage, SHORTWAIT);
		return deleteGroupErrorMessageText;
	}

	public void addGeoFenceButtonTooltip() {
		// Verify the tool tip of 'Add Geo Fence' Button
		String expectedTooltip = "Add Geo Fence";
		WebElement emailOnDemand = driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(emailOnDemand).perform();

		WebElement toolTipElement = driver.findElement(By.cssSelector("div[role='tooltip']"));
		needToWait(SHORTWAIT);
		String actualTooltip = toolTipElement.getText();
		System.out.println("Actual Title of Tool Tip +++++++++" + actualTooltip);
		Assert.assertEquals(actualTooltip, expectedTooltip);
	}

	// This function is used for check the presence of the Add geo Fence link path
	public boolean isAddGeoFenceLinkPathPresent() {
		return isElementVisible(manageGeoFenceLinkPath.replace("Manage Geo Fence", "Add Geo Fence"), SHORTWAIT);
	}

	// This function is used for check the presence of the Google Map
	public boolean isGoogleMapPresent() {
		return isElementVisible(googleMap, SHORTWAIT);
	}

	// This function is used for check the presence of the draw A Shape ErrorMessage
	public boolean isDrawAShapErrorMessagePresent() {
		return isElementVisible(drawAShapeErrorMessage, SHORTWAIT);
	}
	
	public void enterLocation(String location) {
		safeClearAndType(enterLocation,location);
		safeClick(selectLocation, SHORTWAIT);
	//	safeClick(drawCircle, SHORTWAIT);
	}
	
	public void clickOnDrawpolygonButton() {
		safeClick(drawpolygon, SHORTWAIT);
	}
	
	public void drawPolygon() {
		
		try {
            Thread.sleep(1000);
		
		WebElement canvasElement = driver.findElement(By.xpath("//div[@class='leaflet-container leaflet-touch leaflet-fade-anim leaflet-grab leaflet-touch-drag leaflet-touch-zoom']"));
	    Actions builder = new Actions(driver);
	    builder.clickAndHold(canvasElement).moveByOffset(10, 50).
	    moveByOffset(50,10).
	    moveByOffset(-10,-50).
	    moveByOffset(-50,-10).release().contextClick().build().perform();
	    
	    builder.clickAndHold(canvasElement).moveByOffset(10, 50).
	    moveByOffset(50,10).
	    moveByOffset(-10,-50).
	    moveByOffset(-50,-10).release().contextClick().build().perform();
	    Thread.sleep(1000);
	    builder.clickAndHold(canvasElement).moveByOffset(40, 50).
	    moveByOffset(50,40).
	    moveByOffset(-10,-40).
	    moveByOffset(-50,-50).release().contextClick().build().perform();
	    Thread.sleep(1000);
        builder.clickAndHold(canvasElement).moveByOffset(-40, -50).
	    moveByOffset(-50,-40).
	    moveByOffset(10,40).
	    moveByOffset(50,50).release().contextClick().build().perform();
        Thread.sleep(1000);
	    builder.clickAndHold(canvasElement).moveByOffset(-40, -50).
	    moveByOffset(50,50).release().contextClick().build().perform();
	    Thread.sleep(1000);  
	    builder.clickAndHold(canvasElement).moveByOffset(90, -80).
	    moveByOffset(50,50).release().contextClick().moveByOffset(45, 50).click().build().perform();
	    Thread.sleep(1000);
	   	    
		 } 
		catch (InterruptedException e) 
		{
	           System.out.println("Hello Test");
	        }
	    
	}
	 
}
