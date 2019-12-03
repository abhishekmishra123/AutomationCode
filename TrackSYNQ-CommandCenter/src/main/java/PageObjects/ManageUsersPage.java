package PageObjects;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import Common.ActionMethods;
import Common.ConfigManager;

public class ManageUsersPage extends ActionMethods {

	private String manageUsersSidebar = "xpath://body//li[4]";
	private String manageUsers_AddUserSidebar = "xpath://a[contains(text(),'Add User')]";
	private String labelName_addUser = "xpath://label[contains(text(),'txt')]";
	private String manageUserPathLink = "xpath://a[contains(text(),'Manage Users')]";
	private String addUserPathLink = "xpath://span[contains(text(),'Add User')]";
	private String fieldsName_addUser = "css:input#first_name";
	private String countryNamefield_addUser = "xpath://div[@class='ant-select-selection-selected-value']";
	private String rolefield_addUser = "xpath://div[contains(text(),'Select Role')]";
	private String ErrorMessage = "xpath://div[contains(text(),'txt')]";
	private String selectRole = "xpath://li[(text()='QA_Testing1')]";
	private String getEmail = "xpath://td[contains(text(),'johsonking')]";
	private String sidebarMenu = "xpath://ul[@class='ant-menu isoDashboardMenu ant-menu-dark ant-menu-root ant-menu-inline']//li[num]";
	private String userDeleteBtn = "xpath://button[@class='ant-btn ant-btn-danger ant-btn-circle']";
	private String deleteYesButton = "xpath://div[@class='ant-confirm-btns']//button[@class='ant-btn ant-btn-primary']";
	private String userDeletedMessage = "xpath://div[text()='User deleted successfully.']";

	static WebDriver driver;

	public Logger log = Logger.getLogger(ManageRolesPage.class);
	ConfigManager config;

	public ManageUsersPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		config = new ConfigManager();
	}

	public String generateRandomNumber(int length) {
		return RandomStringUtils.randomNumeric(length);
	}

	// This function is used for click on Report manage Role side bar side bar
	public void clickOnManageUsersSidebar() {
		mouseHover(manageUsersSidebar, LONGWAIT);
		safeClick(manageUsersSidebar, SHORTWAIT);
	}

	// This function is used for click on Report manager
	public boolean isManageUsers_AddUserSidebarPresent() {
		mouseHover(manageUsersSidebar, LONGWAIT);
		mouseHover(manageUsers_AddUserSidebar, MEDIUMWAIT);
		return isElementVisible(manageUsers_AddUserSidebar, LONGWAIT);
	}

	// This function is used for user list side bar present
	public boolean isManageUsers_UserListSidebarPresent() {
		mouseHover(manageUsersSidebar, LONGWAIT);
		return isElementVisible(manageUsers_AddUserSidebar.replace("Add User", "User List"), LONGWAIT);
	}

	// This function is used for click on Add User side bar
	public void clickOnManageUsers_AddUserSidebar() {
		mouseHover(manageUsersSidebar, LONGWAIT);
		safeClick(manageUsers_AddUserSidebar, SHORTWAIT);
	}

	// This function is used for click on User list side bar
	public void clickOnManageUsers_UserListSidebar() {
		mouseHover(manageUsersSidebar, LONGWAIT);
		safeClick(manageUsers_AddUserSidebar.replace("Add User", "User List"), SHORTWAIT);
	}

	// This function is used for present the first name label present
	public boolean isLabelFirstName_addUserPresent(String txt) {
		return isElementPresent(labelName_addUser.replace("txt", txt + ""), SHORTWAIT);
	}

	// This function is used for Last name label present
	public boolean isLabelLastName_addUserPresent(String txt) {
		return isElementPresent(labelName_addUser.replace("txt", txt + ""), SHORTWAIT);
	}

	// This function is used for Country Name Label present
	public boolean isLabelCountryName_addUserPresent(String txt) {
		return isElementPresent(labelName_addUser.replace("txt", txt + ""), SHORTWAIT);
	}

	// This function is used for Phone number label present
	public boolean isLabelPhoneNumber_addUserPresent(String txt) {
		return isElementPresent(labelName_addUser.replace("txt", txt + ""), SHORTWAIT);
	}

	// This function is used for email label present
	public boolean isLabelEmail_addUserPresent(String txt) {
		return isElementPresent(labelName_addUser.replace("txt", txt + ""), SHORTWAIT);
	}

	// This function is used for password label present
	public boolean isLabelPassword_addUserPresent(String txt) {
		return isElementPresent(labelName_addUser.replace("txt", txt + ""), SHORTWAIT);
	}

	// This function is used for confirm password label present
	public boolean isLabelConfirmPassword_addUserPresent(String txt) {
		return isElementPresent(labelName_addUser.replace("txt", txt + ""), SHORTWAIT);
	}

	// This function is used for Role label present
	public boolean isLabelRole_addUserPresent(String txt) {
		return isElementPresent(labelName_addUser.replace("txt", txt + ""), SHORTWAIT);
	}

	// This function is used for Manage path link present
	public boolean isManageUserPathLinkPresent() {
		return isElementPresent(manageUserPathLink, SHORTWAIT);
	}

	// Thois function is used for add user path link present
	public boolean isAddUserPathLinkPresent() {
		return isElementPresent(addUserPathLink, SHORTWAIT);
	}

	// This Function is used for first name field present
	public boolean isFirstNameField_addUserPresent() {
		return isElementPresent(fieldsName_addUser, SHORTWAIT);
	}

	// This Function is used for Last Name field present
	public boolean isLastNameField_addUserPresent() {
		return isElementPresent(fieldsName_addUser.replace("first_name", "last_name"), SHORTWAIT);
	}

	// This Function is used for Country Name field present
	public boolean isCountryNamefields_addUserPresent() {
		return isElementPresent(countryNamefield_addUser, SHORTWAIT);
	}

	// This function is used for Phone Number field present
	public boolean isPhoneNumberField_addUserPresent() {
		return isElementPresent(fieldsName_addUser.replace("first_name", "phoneno"), SHORTWAIT);
	}

	// This function is used for Email field present
	public boolean isEmailField_addUserPresent() {
		return isElementPresent(fieldsName_addUser.replace("first_name", "email"), SHORTWAIT);
	}

	// This function is used for Password field present
	public boolean isPasswordField_addUserPresent() {
		return isElementPresent(fieldsName_addUser.replace("first_name", "password"), SHORTWAIT);
	}

	// This function is used for confirm Password field present
	public boolean isConfirmPasswordField_addUserPresent() {
		return isElementPresent(fieldsName_addUser.replace("first_name", "confirm_password"), SHORTWAIT);
	}

	// This function is used for role field present
	public boolean isRolefield_addUserField_addUserPresent() {
		return isElementPresent(rolefield_addUser, SHORTWAIT);
	}

	// This function is used for First Name Field Placeholder
	public String isFirstNameFieldPlaceholderPresent() {
		String firstNamePlaceholder = safeGetAttribute(fieldsName_addUser, "Placeholder", SHORTWAIT);
		return firstNamePlaceholder;
	}

	// This function is used for Last Name Field Placeholder
	public String isLastNameFieldPlaceholderPresent() {
		String lastNamePlaceholder = safeGetAttribute(fieldsName_addUser.replace("first_name", "last_name"),
				"Placeholder", SHORTWAIT);
		return lastNamePlaceholder;
	}

	// This function is used for 'Country Name' Field Placeholder
	public String isCountryNameFieldPlaceholderPresent() {
		String countryNamePlaceholder = safeGetAttribute(countryNamefield_addUser, "title", SHORTWAIT);
		return countryNamePlaceholder;
	}

	// This function is used for Phone number Field Placeholder
	public String isPhoneNumberFieldPlaceholderPresent() {
		String phoneNumberPlaceholder = safeGetAttribute(fieldsName_addUser.replace("first_name", "phoneno"),
				"Placeholder", SHORTWAIT);
		return phoneNumberPlaceholder;
	}

	// This function is used for Email Field Placeholder
	public String isEmailFieldPlaceholderPresent() {
		String emailPlaceholder = safeGetAttribute(fieldsName_addUser.replace("first_name", "email"), "Placeholder",
				SHORTWAIT);
		return emailPlaceholder;
	}

	// This function is used for Password Field Placeholder
	public String isPasswordFieldPlaceholderPresent() {
		String passwordPlaceholder = safeGetAttribute(fieldsName_addUser.replace("first_name", "password"),
				"Placeholder", SHORTWAIT);
		return passwordPlaceholder;
	}

	// This function is used for Confirm Password Field Placeholder
	public String isConfirmPasswordFieldPlaceholderPresent() {
		String confirmPasswordPlaceholder = safeGetAttribute(
				fieldsName_addUser.replace("first_name", "confirm_password"), "Placeholder", SHORTWAIT);
		return confirmPasswordPlaceholder;
	}

	// This function is used for role Field Placeholder
	public String isRoleFieldPlaceholderPresent() {
		String rolePlaceholder = safeGetText(rolefield_addUser, SHORTWAIT);
		return rolePlaceholder;
	}

	// This function is used for first name field error message
	public String isFirstNameErrorMessagePresent() {
		String firstNameErrorMessage = safeGetText(ErrorMessage.replace("txt", "Please Enter First Name"), SHORTWAIT);
		return firstNameErrorMessage;
	}

	// This function is used for first name field error message
	public String isLastNameErrorMessagePresent() {
		String firstNameErrorMessage = safeGetText(ErrorMessage.replace("txt", "Please Enter Last Name"), SHORTWAIT);
		return firstNameErrorMessage;
	}

	// This function is used for if enter number on first name field error message
	public String enterNumbersFirstNameErrorMessagePresent() {
		String firstNameErrorMessage = safeGetText(ErrorMessage.replace("txt", "Please enter valid name"), SHORTWAIT);
		return firstNameErrorMessage;
	}

	  //This function is used for if enter number password and password error message
		public String enterPasswordAndConfirmErrorMessagePresent() {
			String firstNameErrorMessage = safeGetText(ErrorMessage.replace("txt", "Confirm password mismatch"), SHORTWAIT);
			return firstNameErrorMessage;
		}
	
	
	// This function is used for if enter number on last name field error message
	public String enterNumberLastNameErrorMessagePresent() {
		String firstNameErrorMessage = safeGetText(ErrorMessage.replace("txt", "Please enter valid name"), SHORTWAIT);
		return firstNameErrorMessage;
	}

	// This function is used for Country name field error message
	public String isCountryNameErrorMessagePresent() {
		String firstNameErrorMessage = safeGetText(ErrorMessage.replace("txt", "Please Select Country Name"),
				SHORTWAIT);
		return firstNameErrorMessage;
	}

	// This function is used for phone number field error message
	public String isPhoneNumberErrorMessagePresent() {
		String firstNameErrorMessage = safeGetText(ErrorMessage.replace("txt", "Please Enter Correct Phone Number"),
				SHORTWAIT);
		return firstNameErrorMessage;
	}

	// This function is used for if user enter phone number less than 10 digit
	public String enterLessThan10NumberErrorMessagePresent() {
		String lessThanErrorMessage = safeGetText(
				ErrorMessage.replace("txt", "Please Enter Exactly 10 Digits Phone Number"), SHORTWAIT);
		return lessThanErrorMessage;
	}

	// This function is used for email field error message
	public String isEmailAddressErrorMessagePresent() {
		String firstNameErrorMessage = safeGetText(ErrorMessage.replace("txt", "Please Input Email ID"), SHORTWAIT);
		return firstNameErrorMessage;
	}

	// This function is used for is enter wrong email address
	public String enterWrongEmailAddressErrorMessagePresent() {
		String firstNameErrorMessage = safeGetText(ErrorMessage.replace("txt", "This is not a valid email ID"),
				SHORTWAIT);
		return firstNameErrorMessage;
	}

	// This function is used for password field error message
	public String isPasswordErrorMessagePresent() {
		String firstNameErrorMessage = safeGetText(ErrorMessage.replace("txt", "Please Input User Password"),
				SHORTWAIT);
		return firstNameErrorMessage;
	}

	// This function is used for confirm password field error message
	public String isConfirmPasswordErrorMessagePresent() {
		String firstNameErrorMessage = safeGetText(ErrorMessage.replace("txt", "Please Input User Confirm Password"),
				SHORTWAIT);
		return firstNameErrorMessage;
	}

	// This function is used for Role field error message
	public String isRoleErrorMessagePresent() {
		String firstNameErrorMessage = safeGetText(ErrorMessage.replace("txt", "Please Select Role"), SHORTWAIT);
		return firstNameErrorMessage;
	}

	// This function is used for enter details for 'Add User'
	public void enterUserDetails(String firstname, String lastname, String phone, String email, String password, String confirmpassword) {
		safeClearAndType(fieldsName_addUser, firstname, SHORTWAIT);
		safeClearAndType(fieldsName_addUser.replace("first_name", "last_name"), lastname, SHORTWAIT);
		safeClearAndType(fieldsName_addUser.replace("first_name", "phoneno"), phone, SHORTWAIT);
		safeClearAndType(fieldsName_addUser.replace("first_name", "email"), email, SHORTWAIT);
		safeClearAndType(fieldsName_addUser.replace("first_name", "password"), password, SHORTWAIT);
		safeClearAndType(fieldsName_addUser.replace("first_name", "confirm_password"), confirmpassword, SHORTWAIT);
	}

	// This function used for select country
	public void select_Country() {
		safeClick(countryNamefield_addUser, SHORTWAIT);
		needToWait(SHORTWAIT);
		WebElement Objects = driver.findElement(By.xpath(
				"//div//ul[@class='ant-select-dropdown-menu  ant-select-dropdown-menu-root ant-select-dropdown-menu-vertical']"));
		List<WebElement> objectList = Objects.findElements(By.tagName("li"));
		for (WebElement li : objectList) {
			if (li.getText().equals("United States")) {
				li.click();
			}
		}
	}

	// This function is used for select role
	public void select_Role() {
		safeClick(rolefield_addUser, SHORTWAIT);
		safeClick(selectRole, SHORTWAIT);
	}

	public String getEmailText() {
		String SuccessMessage = safeGetText(getEmail, SHORTWAIT);
		return SuccessMessage;
	}

  // This function is used for list side bar present
	public boolean isSidebarMenuPresent(int num) {
		return isElementVisible(sidebarMenu.replace("num", num + ""), SHORTWAIT);
	}

	// This function is used for user deletion
	public void clickOnUserDeleteBtn() {
		safeClick(userDeleteBtn, SHORTWAIT);
		safeClick(deleteYesButton, SHORTWAIT);
	}

	// This function is used for user delete message
	public String userDeleteMessage() {
		String SuccessMessage = safeGetText(userDeletedMessage, SHORTWAIT);
		return SuccessMessage;
	}

	// This function is used for click on manage user path link
	public void clickOnManageUserPathLink() {
		safeClick(manageUserPathLink, SHORTWAIT);
	}

}
