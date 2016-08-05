package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public abstract class Page {

	protected AndroidDriver<AndroidElement> driver;
	
	

	public Page(AppiumDriver driver2) {
		this.driver = (AndroidDriver<AndroidElement>) driver2;
	}

	protected boolean isElementPresent(WebElement element) {

		try {
			WebDriverWait wait = new WebDriverWait(driver, Constants.TIME_IN_SECONDS);
			wait.until(ExpectedConditions.visibilityOf(element));

			return true;
		} catch (Exception e) {

			return false;
		}
	}

	private static void logger(String toPrint, LogAs logas) {

		System.out.println(toPrint);
		ATUReports.add(toPrint, logas, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}

	private void loggerChecksLabel(String inputValue, String expectedValue, String actualValue, LogAs logas) {

		System.out.println("Checks if elements are equal");
		ATUReports.add("Checks if elements are equal", inputValue, expectedValue, actualValue, logas,
				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}

	protected void checkElement(WebElement w, String positiveResultMessage, String negativeResultMessage) {
		if (isElementPresent(w)) {
			logger(positiveResultMessage, LogAs.PASSED);
		} else {
			logger(negativeResultMessage, LogAs.FAILED);
		}
	}

	protected void checkElementEquals(WebElement w, String labelEqualCheck, String positiveResultMessage,
			String negativeResultMessage) {
		if (w.getText().equals(labelEqualCheck)) {
			logger(positiveResultMessage, LogAs.PASSED);

		} else {
			logger(negativeResultMessage, LogAs.FAILED);
		}
	}

	protected void checkElementEqualsPrintValues(WebElement w, String labelEqualCheck, String inputValue,
			String expectedValue, String actualValue) {
		if (w.getText().equals(labelEqualCheck)) {
			loggerChecksLabel(inputValue, expectedValue, actualValue, LogAs.PASSED);

		} else {
			loggerChecksLabel(inputValue, expectedValue, actualValue, LogAs.FAILED);
		}
	}

	protected void checkElementAttributePrintValues(WebElement w, String labelEqualCheck, String inputValue,
			String expectedValue, String actualValue) {
		if (w.getAttribute("name").equals(labelEqualCheck)) {
			loggerChecksLabel(inputValue, expectedValue, actualValue, LogAs.PASSED);

		} else {
			loggerChecksLabel(inputValue, expectedValue, actualValue, LogAs.FAILED);
		}
	}

	protected void checkElementAttribute(WebElement w, String labelEqualCheck, String positiveResultMessage,
			String negativeResultMessage) {
		if (w.getAttribute("name").equals(labelEqualCheck)) {
			logger(positiveResultMessage, LogAs.PASSED);

		} else {
			logger(negativeResultMessage, LogAs.FAILED);
		}
	}

	protected void checkElementInsideEquals(WebElement w1, WebElement w2, String labelEqualCheck,
			String positiveResultMessage, String negativeResultMessage) {
		if (isElementPresent(w1)) {
			if (w2.getText().equals(labelEqualCheck)) {
				logger(positiveResultMessage, LogAs.PASSED);
			}
		} else {
			logger(negativeResultMessage, LogAs.FAILED);
		}

	}

	protected void checkElementExistElementInsideEquals(WebElement w, String labelEqualCheck, String positiveMessage,
			String negativeMessage1, String negativeMessage2) {
		boolean isElementPresent = isElementPresent(w);
		boolean elementExistsAndEquals = w != null && w.getText().equals(labelEqualCheck);

		final String message = isElementPresent ? (elementExistsAndEquals ? positiveMessage : negativeMessage1)
				: negativeMessage2;
		final LogAs logas = isElementPresent ? (elementExistsAndEquals ? LogAs.PASSED : LogAs.FAILED) : LogAs.FAILED;
		logger(message, logas);
	}

	protected void checkElementsPresent2NegativeMsg(WebElement w1, WebElement w2, String labelEqual,
			String positiveMessage, String negativeMessage1, String negativeMessage2) {
		boolean areElementsPresent = isElementPresent(w1) && isElementPresent(w2);
		boolean elementPresentAndEquals = w1 != null && w1.getText().equals(labelEqual);
		final String message = areElementsPresent ? (elementPresentAndEquals ? positiveMessage : negativeMessage1)
				: negativeMessage2;
		final LogAs logas = areElementsPresent ? (elementPresentAndEquals ? LogAs.PASSED : LogAs.FAILED) : LogAs.FAILED;
		logger(message, logas);
	}
	
	protected void testFailedPrintMessage() {
		System.out.println("Test failed check report for details");
		ATUReports.add("Test failed check previous steps for details", LogAs.FAILED,
				new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}
}