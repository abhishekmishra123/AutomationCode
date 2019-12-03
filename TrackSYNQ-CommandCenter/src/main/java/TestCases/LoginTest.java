package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import Common.BaseSetup;
import Common.UtilityMethods;
import PageObjects.LiveTrackingPage;
import PageObjects.LoginPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class LoginTest extends BaseSetup {
	LoginPage loginPage;
	LiveTrackingPage liveTrackingPage;

	static Logger log = Logger.getLogger(LoginTest.class);

	@Test(priority = 0, description = "TC_Login_001 To verify login page title")
	public void Verify_login_page_title() {

		try {
			log.info("************************* TC-001*************************");
			extentTest.setDescription("TC_Login_001 To verify login page title");
			loginPage = new LoginPage(getDriver());
			String pageTitle = loginPage.getPageTitle();
			Assert.assertEquals(pageTitle, "Login");

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to verify login page title " + UtilityMethods.getStackTrace());
			Assert.fail("Unable to verify login page title");
		}
	}

	@Test(priority = 1, description = "TC_Login_002 To verify login page url")
	public void Verify_the_login_page_URL() {

		try {
			log.info("************************* TC-002*************************");
			extentTest.setDescription("TC_Login_002 To verify login page url");
			loginPage = new LoginPage(getDriver());

			String pageUrl = loginPage.getCurrentWebpageURL();
			if (pageUrl.contains("login")) {
				Assert.assertEquals(1, 1);
			} else {
				Assert.assertEquals(1, 0);
			}

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to verify login page URL " + UtilityMethods.getStackTrace());
			Assert.fail("Unable to verify login page URL");
		}
	}

	@Test(priority = 2, description = "TC_Login_003 To verify login page UI fields")
	public void Verify_login_page_UI_fields() {

		try {
			log.info("************************* TC-003*************************");
			extentTest.setDescription("TC_Login_003 To verify login page UI fields");
			loginPage = new LoginPage(getDriver());
			Assert.assertTrue(loginPage.isTrackSYNQLogoImagePresent());
			Assert.assertTrue(loginPage.isEmailfieldPresent());
			Assert.assertTrue(loginPage.isPasswordFieldPresent());
			Assert.assertTrue(loginPage.isSignInButtonPresent());
			Assert.assertTrue(loginPage.isForgotPasswordLinkPresent());

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to verify login page UI fields " + UtilityMethods.getStackTrace());
			Assert.fail("Unable to verify login page UI fields");
		}
	}

	@Test(priority = 3, description = " TC_Login_004  To verify validation message with valid 'email address' and empty 'password' field")
	public void Verify_validation_message_with_valid_emailAddress_and_empty_password_field() {

		try {
			log.info("************************* TC-004*************************");
			extentTest.setDescription(
					"TC_Login_004 To To verify validation message with valid 'email address' and empty 'password' field");
			loginPage = new LoginPage(getDriver());
			loginPage.enterEmailAddess(config.getProperty("siteAdminEmailData"));
			loginPage.clickOnLogInButton();
			String errorMsg = loginPage.getPasswordErrorMessage();
			Assert.assertEquals(errorMsg, "Please Input Your Password");

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to verify validation message with valid 'email address' and empty 'password' field "
					+ UtilityMethods.getStackTrace());
			Assert.fail("Unable to verify validation message with valid 'email address' and empty 'password' field");
		}
	}

	@Test(priority = 4, description = "TC_Login_005 To verify validation message with valid 'Password' and empty 'email address' field")
	public void Verify_validation_message_with_valid_password_and_empty_emailAddress_field() {

		try {
			log.info("************************* TC-005*************************");
			extentTest.setDescription(
					"TC_Login_005 To verify validation message with valid 'password' and empty 'email address' field");
			loginPage = new LoginPage(getDriver());
			loginPage.enterPassword(config.getProperty("siteAdminPasswordData"));
			loginPage.clickOnLogInButton();
			String errorMsg = loginPage.getEmailAddressErrorMessage();
			Assert.assertEquals(errorMsg, "Please Input Email ID");
		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to verify validation message with valid 'password' and empty 'email address' field "
					+ UtilityMethods.getStackTrace());
			Assert.fail("Unable to verify validation message with valid 'password' and empty 'email address' field");
		}
	}

	@Test(priority = 5, description = "TC_Login_006 To verify validation message with empty 'email address' and empty 'password' field")
	public void Verify_validation_message_with_empty_email_address_and_empty_password_field() {

		try {
			log.info("************************* TC-006*************************");
			extentTest.setDescription(
					"TC_Login_006 To verify validation message with empty 'email address' and empty 'password' field");
			loginPage = new LoginPage(getDriver());
			loginPage.enterEmailAddess("");
			loginPage.enterPassword("");
			loginPage.clickOnLogInButton();
			String emailAddressFieldErrorMsg = loginPage.getEmailAddressErrorMessage();
			String passwordFieldErrorMsg = loginPage.getPasswordErrorMessage();
			Assert.assertEquals(emailAddressFieldErrorMsg, "Please Input Email ID");
			Assert.assertEquals(passwordFieldErrorMsg, "Please Input Your Password");
		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to verify validation message with empty 'email address' and empty 'password' field "
					+ UtilityMethods.getStackTrace());
			Assert.fail("Unable to verify validation message with empty 'email address' and empty 'password' field");
		}
	}

	@Test(priority = 6, description = "TC_Login_007 To verify validation message with invalid 'Email address' and invalid 'password'")
	public void Verify_validation_message_with_invalid_email_address_and_invalid_password_field() {

		try {
			log.info("************************* TC-007*************************");
			extentTest.setDescription(
					"TC_Login_007 To verify validation message with invalid 'Email address' and invalid 'password' field");
			loginPage = new LoginPage(getDriver());
			loginPage.enterEmailAddess(config.getProperty("InvalidUsername"));
			loginPage.enterPassword(config.getProperty("InvalidPassword"));
			//loginPage.clickOnLogInButton();
			String errorMsg = loginPage.getInvalidCredentialsErrorMessage();
			System.out.println("errorMsg ->" + errorMsg);
			Assert.assertEquals(errorMsg, "This is not a valid email ID");

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to verify validation message with invalid 'email address' and invalid 'password' field "
					+ UtilityMethods.getStackTrace());
			Assert.fail(
					"Unable to verify validation message with invalid 'email address' and invalid 'password' field");
		}
	}

//	@Test(priority = 7, description = "TC_Login_08 To verify css value of login page fields")
//	public void Verify_css_value_of_login_page_fields() {
//
//		try {
//			log.info("************************* TC-08*************************");
//			extentTest.setDescription("TC_Login_08 To verify css value of login page fields");
//			loginPage = new LoginPage(getDriver());
//			String browserName = config.getProperty("Browser.Name");
//			if (browserName.equalsIgnoreCase("chrome") || browserName.equalsIgnoreCase("ie")) {
	// Assert.assertEquals(loginPage.getlogInButtonBackgroundColor(), "rgba(54, 108,
	// 185, 1)");
//				 Assert.assertEquals(loginPage.getlogInButtonTextColor(), "rgba(255, 255, 255, 1)");
//				 loginPage.clickOnLogInButton();
//				 Assert.assertEquals(loginPage.getEmailAddressErrorMessage(), "The email is required");
//				 Assert.assertEquals(loginPage.getPasswordErrorMessage(), "The password is required");
//				 Assert.assertEquals(loginPage.getEmailAddresssErrorMsgTextColor(), "rgba(255, 92, 108, 1)");
//				 Assert.assertEquals(loginPage.getPasswordErrorMsgTextColor(), "rgba(255, 92, 108, 1)");
//			} else {
//				 Assert.assertEquals(loginPage.getlogInButtonBackgroundColor(), "rgb(54, 108, 185, 1)");
//				 Assert.assertEquals(loginPage.getlogInButtonTextColor(), "rgb(255, 255,255, 1)");		   
//				 loginPage.clickOnLogInButton();
//				 Assert.assertEquals(loginPage.getEmailAddressErrorMessage(), "The email is required");
//				 Assert.assertEquals(loginPage.getPasswordErrorMessage(), "The password is required");
//				 Assert.assertEquals(loginPage.getEmailAddresssErrorMsgTextColor(), "rgb(255, 92, 108, 1)");
//				 Assert.assertEquals(loginPage.getPasswordErrorMsgTextColor(), "rgb(255, 92, 108, 1)");
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			logError("Unable to verify css value of login page fields " + UtilityMethods.getStackTrace());
//			Assert.fail("Unable to verify css value of login page fields");
//		}
//	}

	@Test(priority = 8, description = "TC_Login_09 To verify forgot password link ")
	public void Verify_forgot_password_link() {

		try {
			log.info("************************* TC-009*************************");
			extentTest.setDescription("TC_Login_002 To verify login page url");
			loginPage = new LoginPage(getDriver());
			loginPage.clickOnForgotPasswordLink();
			String pageUrl = loginPage.getCurrentWebpageURL();
			if (pageUrl.contains("forgotpassword")) {
				Assert.assertEquals(1, 1);
			} else {
				Assert.assertEquals(1, 0);
			}
			Assert.assertTrue(loginPage.isForgotPasswordHeadingPresent());

			loginPage.clickOnLogInButton();
			Assert.assertEquals(loginPage.isResetPasswordMessagePresent(), "Please Input Your Email ID");

		} catch (Exception e) {
			e.printStackTrace();
			logError("Unable to verify forgot-password page URL " + UtilityMethods.getStackTrace());
			Assert.fail("Unable to verify forgot-password page URL");
		}
	}

	@Test(priority = 10, description = "TC_Login_11 To verify login functionality with valid credentials of super admin ")
	public void Verify_login_functionality_with_valid_credentials_of_superAdmin() {
		try {
			log.info("************************* TC-011*************************");
			extentTest.setDescription(
					"TC_Login_014 To verify login functionality with valid credentials of administrator");
			loginPage = new LoginPage(getDriver());
			Actions actions = new Actions(driver);
			liveTrackingPage = new LiveTrackingPage(getDriver());
			loginPage.enterEmailAddess(config.getProperty("siteAdminEmailData"));
			loginPage.enterPassword(config.getProperty("siteAdminPasswordData"));
			loginPage.clickOnLogInButton();
			Assert.assertEquals(loginPage.LogInButtonAlertText(), "You have logged in successfully");
			String currentUrl = loginPage.getCurrentWebpageURL();
			Assert.assertTrue(currentUrl.contains("dashboard"));
			liveTrackingPage.clickOnLiveTrackingSidebar();
			
			// Verify the + icon tooltip
			String expectedTooltip = "Add Vehicle";
			WebElement download = driver.findElement(By.cssSelector("div.ant-col-xl-2 button.ant-btn"));
			Actions builder = new Actions(driver);
			builder.clickAndHold().moveToElement(download);
			builder.moveToElement(download).build().perform();
			Thread.sleep(3000);
			WebElement toolTipElement = driver.findElement(By.cssSelector("div.ant-tooltip-inner"));
			String actualTooltip = toolTipElement.getText();

			System.out.println("Actual Title of Tool Tip +++++++++" + actualTooltip);
			Assert.assertEquals(actualTooltip, expectedTooltip);
			Assert.assertTrue(loginPage.isHamBurgerIconPresent());
			loginPage.clickOnHamBurgerIcon();

//			// Now Select 'Rock' from sub menu which has got displayed on mouse hover of
//			// 'Music'
//			String livetrackTrackTooltip = "Live Tracking";
//			WebElement subMenuOption = driver.findElement(By.xpath(".//span[contains(text(),'Live Tracking')]"));
//			actions.moveToElement(subMenuOption).perform();
//			WebElement livetrackToolTipElement = driver.findElement(By.xpath("//span[text()='Live Tracking']"));
//			String livetrackTooltip = livetrackToolTipElement.getText();
//			Assert.assertEquals(livetrackTooltip, livetrackTrackTooltip);
		//	System.out.println("++++++++++++++++" + subMenuOption);
			Assert.assertFalse(loginPage.isHamBurgerIconPresent());
			
			loginPage.clickOnUserProfile();
			loginPage.clickOnLogOutButton();

		} catch (Exception e) {

			e.printStackTrace();
			logError("Unable to verify login functionality with valid credentials of super admin "
					+ UtilityMethods.getStackTrace());
			Assert.fail("Unable to verify login functionality with valid credentials of super admin");
		}
	}

}
