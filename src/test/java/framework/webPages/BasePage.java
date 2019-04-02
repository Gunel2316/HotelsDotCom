package framework.webPages;

import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import stepdefinition.SharedSD;
import sun.security.provider.SHA;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by mohammadmuntakim
 */

public class BasePage {

	// This is the most common wait function used in selenium
	public static WebElement webAction(final By locator) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(SharedSD.getDriver())
				.withTimeout(Duration.ofSeconds(15))
				.pollingEvery(Duration.ofSeconds(1))
				.ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class)
				.ignoring(ElementClickInterceptedException.class)
				.withMessage(
						"Webdriver waited for 15 seconds but still could not find the element therefore Timeout Exception has been thrown");

		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(locator);
			}
		});

		return element;
	}



	public void autoComplete(By locator, By locator2, String keyText, String containingWord) {
		SharedSD.getDriver().findElement(locator).sendKeys(keyText);
		List<WebElement> list = SharedSD.getDriver().findElements(locator2);
		for (WebElement ele : list) {
			if (ele.getText().contains(containingWord)) {
				ele.click();
				break;
			}
		}
	}

	public List<WebElement> getWebElements(By locator) {
		return SharedSD.getDriver().findElements(locator);}


	public void arrayList(By locator, By locator2, String keyText, String containingWord) {
		SharedSD.getDriver().findElement(locator).sendKeys(keyText);
		List<WebElement> list = SharedSD.getDriver().findElements(locator2);
		for (WebElement ele : list) {
			if (ele.getText().contains(containingWord)) {
				ele.click();
				break;
			}
		}
	}
	public String getAttributeValue(By locator, String attribute) {
		WebElement element = SharedSD.getDriver().findElement(locator);
		return element.getAttribute(attribute);}


	public void closeCurrentWindowAndSWitchToRootWindow(int index) {

		List<String> listOfWindowss1 = new ArrayList<String>(SharedSD.getDriver().getWindowHandles());
		for (int i = 1; i < listOfWindowss1.size(); i++) {
			SharedSD.getDriver().switchTo().window(listOfWindowss1.get(i));
			SharedSD.getDriver().close();
		}
		SharedSD.getDriver().switchTo().window(listOfWindowss1.get(index));
	}


	public void clickOn(By locator) {
		webAction(locator).click();
	}

	public void setValue(By locator, String value) {
		webAction(locator).sendKeys(value);
	}


	public String getTextFromElement(By locator) {
		return webAction(locator).getText();
	}

	public boolean isElementDisplayed(By locator) {
		return webAction(locator).isDisplayed();
	}

	public boolean isElementSelected(By locator) {
		return webAction(locator).isSelected();
	}

	public void selectFromDropdown(By locator, String dropdownText) {
		WebElement month = webAction(locator);
		Select selectMonth = new Select(month);
		//select element by visible text
		selectMonth.selectByVisibleText(dropdownText);
	}

	public void selectFromDropdown(By locator, int index) {
		WebElement month = webAction(locator);
		Select selectMonth = new Select(month);
		//select element by index
		selectMonth.selectByIndex(index);
	}


}
