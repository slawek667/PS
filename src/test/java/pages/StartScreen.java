package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;


public class StartScreen extends Page {



	public StartScreen(AppiumDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}


	// Variables
	@FindBy(id = "com.polidea.polideastore:id/polidea")
	private WebElement polideaLogo;

	@FindBy(id = "com.polidea.polideastore:id/login_email_edit_text")
	private WebElement emailTxtField;

	@FindBy(id = "com.polidea.polideastore:id/login_email_button")
	private WebElement authorizeBtn;

	@FindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]")
	private WebElement polideaCodeScreenLbl;

	@FindBy(id = "com.polidea.polideastore:id/enter_code_edit_text")
	private WebElement codeTxtField;

	@FindBy(id = "com.polidea.polideastore:id/confirm_button")
	private WebElement confirmBtn;

	@FindBy(id = "com.polidea.polideastore:id/list_app_icon")
	private WebElement polideaListIcon;

	@FindBy(id = "com.polidea.polideastore:id/list_app_name")
	private WebElement polideaStoreListAppNameLbl;

	public void checkStartScreen() {
		try {
			checkElement(polideaLogo, "Polidea Logo does exist on the start screen", "Could not find Polidea Logo");
			checkElement(emailTxtField, "Email text field is properly displayed on the start screen",
					"Could not find email text field");
			checkElement(authorizeBtn, "Authorize button is displayed at start screen",
					"Could not find authorize button");

		} catch (Exception e) {
			testFailedPrintMessage();
		}
	}

	public void checkCodeScreen() {
		try {
			checkElement(polideaLogo, "Polidea Logo does exist on the start screen", "Could not find Polidea Logo");
			checkElement(polideaCodeScreenLbl, "Code screen label is properly displayed on the start screen",
					"Could not find code screen label");
			checkElement(codeTxtField, "Code text field is displayed at start screen",
					"Could not find code text field");
			checkElement(confirmBtn, "Confirm button is properly displayed", "Could not check confirm button");

		} catch (Exception e) {
			testFailedPrintMessage();
		}
	}

	public void checkLoggedScreen() {
		try {
			checkElement(polideaListIcon, "Polidea icon does exist on the start screen", "Could not find Polidea icon");
			checkElement(polideaStoreListAppNameLbl, "Label of the first application on the list is displayed",
					"Could not check label of the first application on the list");

		} catch (Exception e) {
			testFailedPrintMessage();
		}
	}

	public void provideTestEmail() {
		try {
			emailTxtField.sendKeys("polideastoreautomationtest@gmail.com");
			driver.sendKeyEvent(4);

		} catch (Exception e) {
			testFailedPrintMessage();

		}

	}

	public void provideCode() {
		try {
			codeTxtField.sendKeys("12345");
			driver.sendKeyEvent(4);
			driver.sendKeyEvent(4);

		} catch (Exception e) {
			testFailedPrintMessage();

		}

	}

	public void tapAuthorizeBtn() {
		try {
			authorizeBtn.click();

		} catch (Exception e) {
			testFailedPrintMessage();
		}
	}

	public void tapConfirmBtn() {
		try {
			confirmBtn.click();

		} catch (Exception e) {
			testFailedPrintMessage();
		}
	}

}
