package com.projectAppium.Utility;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.HidesKeyboard;
import io.appium.java_client.MobileBy.ByAndroidUIAutomator;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
/// Aisa Utility method banana hai jisme window andorid and webBased application teeno automate ho shuru me keval webbased and mobile base ke liye banaye bad me window ke liye bhi include kar de

public class Utility {
	private AndroidDriver driver;
	private Properties prop;
	private URL url;

// Driver ke liye Getter and setter bana lena

	public Utility() {

	}

	public WebDriver getDriver() {
		return driver;
	}

	public void launchApplication(String appPackage, String appActivity) {
		DesiredCapabilities ds = new DesiredCapabilities();
		ds.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
		ds.setCapability(MobileCapabilityType.NO_RESET, true);
		ds.setCapability("appPackage", appPackage);
		ds.setCapability("appActivity", appActivity);
		try {
			url = new URL("http://127.0.0.1:4723/wd/hub");
			driver = new AndroidDriver(url, ds);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void staticWait(int timeinSecond) {
		timeinSecond = timeinSecond * 1000;
		try {
			Thread.sleep(timeinSecond);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void launchApplication(String ThePathOfApps) {
		DesiredCapabilities ds = new DesiredCapabilities();
		ds.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
		ds.setCapability(MobileCapabilityType.NO_RESET, true);
		ds.setCapability(MobileCapabilityType.APP, ThePathOfApps);

		try {
			url = new URL("http://127.0.0.1:4723/wd/hub");
			driver = new AndroidDriver(url, ds);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void launchBrowser() {
		DesiredCapabilities ds = new DesiredCapabilities();
		ds.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
		ds.setCapability(MobileCapabilityType.NO_RESET, true);
		ds.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		ds.setCapability("chromedriverExecutable", "D:\\new projects\\appiumclient\\driver\\chromedriver.exe");

		try {
			url = new URL("http://127.0.0.1:4723/wd/hub");
			driver = new AndroidDriver(url, ds);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void implicitywait(int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	public void hideKeyBoard() {
		androidBTNS(AndroidKey.ENTER);
		staticWait(1);
		((HidesKeyboard) driver).hideKeyboard();

	}

	public void click(WebElement we) {
		we.click();
	}

	public void inputValue(AndroidElement we, String inputvalueTxt) {
		we.sendKeys(inputvalueTxt);
	}

	public void javaScriptSendKeys(String value, WebElement webElement) {
		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		jse.executeScript("arguments[0].value=arguments[1]", webElement, value);

	}

	public void sendKey(WebElement we, String value) {
		if (we.isDisplayed() && we.isEnabled()) {
			try {
				we.clear();
				we.sendKeys(value);
			} catch (NoSuchElementException e) {
				Actions act = new Actions(driver);
				we.clear();
				act.moveToElement(we).sendKeys(value).build().perform();
				e.printStackTrace();
			} catch (Exception e) {
				we.clear();
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].value='" + value + "';", we);

			}

		}
	}

	
	public void navigateBack() {
		driver.navigate().back();
		
		
	}
	///////////////// Gestures //////////////////////////

	public void tap(WebElement we) {
		TouchAction tp = new TouchAction((PerformsTouchActions) driver);
		tp.tap(ElementOption.element(we)).perform();

// agar tap ki jagah press likhate to press karata rahega		
		/*
		 * upar keval wwebdriver likha hai isiliye new
		 * TouchAction((PerformsTouchActions) driver); ye likha hai agar AdroidDriver
		 * likha hota to new TouchAction(driver); isase kaam chal jata
		 */
	}

	// appium inspector me ek teer rahata hai upar arrow jaisa - left side me upar
	// cursor rakhege to swipeBycordinates par click karake exact coOrdinate dekh
	// sakate hai thoda dhyan dege to ho jayega

	public void javaScriptCLick(WebElement we) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", we);

	}
	
	
	public void tap(int xAxis, int yAxis) {
		PointOption coOrdinateForPress = new PointOption().point(xAxis, yAxis);
		TouchAction tc = new TouchAction((PerformsTouchActions) driver);
		tc.tap(coOrdinateForPress).perform();
// new Actions(driver).moveByOffset(0, 0).click();  Is tarike se click kara sakate hai yah tap by co-Ordinate ka jaagh le sakata hai
//new Actions(driver).moveByOffset(0, 0).clickAndHold().build().perform();-- long press ki jagah le sakaat hai

	}

	public void scrollAndClick() {

	}

	public void swipe(int yaxisStartPointPercent, int yaxisEndPointPercet) {
		Dimension windowSize = driver.manage().window().getSize();
		int screenHeight = windowSize.getHeight();
		int screenWidth = windowSize.getWidth();

		// init start point and end point to touch and release
		int xStartPoint = 50 * screenWidth / 100;
		int xEndPoint = xStartPoint;
		int yStartPoint = yaxisStartPointPercent * screenHeight / 100;
		int yEndPoint = yaxisEndPointPercet * screenHeight / 100;
		// perfoms touch actions
		PointOption startPoint = new PointOption().withCoordinates(xStartPoint, yStartPoint);
		PointOption endPoint = new PointOption().withCoordinates(xEndPoint, yEndPoint);
		// scroll up -- swipe from bottom to top
		TouchAction touchAction = new TouchAction((PerformsTouchActions) driver);
		touchAction.press(startPoint).waitAction(new WaitOptions().withDuration(Duration.ofSeconds(2))).moveTo(endPoint)
				.release().perform();

	}

	public void swipe(int xStartPoint, int yStartPoint, int xEndPoint, int yEndPoint) {
		// perfoms touch actions
		PointOption startPoint = new PointOption().withCoordinates(xStartPoint, yStartPoint);
		PointOption endPoint = new PointOption().withCoordinates(xEndPoint, yEndPoint);
		TouchAction touchAction = new TouchAction((PerformsTouchActions) driver);
		touchAction.press(startPoint).waitAction(new WaitOptions().withDuration(Duration.ofSeconds(2))).moveTo(endPoint)
				.release().perform();
	}

	public void swipeUntilVisibilityOfTheElement() {

	}

	public void longPress(WebElement we, int timeInSecond) {
		TouchAction touch = new TouchAction((PerformsTouchActions) driver);
		touch.longPress(ElementOption.element(we))
				.waitAction(new WaitOptions().withDuration(Duration.ofSeconds(timeInSecond))).perform();

		// agar tap ki jagah press likhate to press karata rahega
		/*
		 * upar keval wwebdriver likha hai isiliye new
		 * TouchAction((PerformsTouchActions) driver); ye likha hai agar AdroidDriver
		 * likha hota to new TouchAction(driver); isase kaam chal jata
		 */

	}

	public void longPress(int xAxis, int yAxis, int timeInSecond) {
		PointOption coOrdinatefortouch = new PointOption().point(xAxis, yAxis);
		TouchAction touch = new TouchAction((PerformsTouchActions) driver);
		touch.longPress(coOrdinatefortouch).waitAction(new WaitOptions().withDuration(Duration.ofSeconds(timeInSecond)))
				.perform();

// appium inspector me ek teer rahata hai upar arrow jaisa - left side me upar 
// cursor rakhege to swipeBycordinates par click karake exact coOrdinate dekh sakate hai thoda dhyan dege to ho jayega		

	}

	public void dragAndDrop(WebElement sourceWebElement, int x, int y) {
		TouchAction touch = new TouchAction((PerformsTouchActions) driver);
		touch.press(ElementOption.element(sourceWebElement))
				.waitAction(new WaitOptions().withDuration(Duration.ofSeconds(2))).moveTo(new PointOption().point(x, y))
				.release().perform();
	}

	public void dragAndDrop(WebElement source, WebElement targetWebElement) {
		TouchAction touch = new TouchAction((PerformsTouchActions) driver);
		touch.press(ElementOption.element(source)).waitAction(new WaitOptions().withDuration(Duration.ofSeconds(2)))
				.moveTo(ElementOption.element(targetWebElement)).release().perform();
	}

	public void zoomIn(int xAxis, int yAxis) {
		MultiTouchAction multiTouchAction = new MultiTouchAction((PerformsTouchActions) driver);
		PointOption startPointzoomout = new PointOption().withCoordinates(xAxis, yAxis - 10);
		PointOption endpointzoomout = new PointOption().withCoordinates(xAxis, yAxis - 200);
		TouchAction zoomOut = new TouchAction((PerformsTouchActions) driver);
		zoomOut.press(startPointzoomout).moveTo(endpointzoomout).release();
		PointOption startPointzoomIn = new PointOption().withCoordinates(xAxis, yAxis + 10);
		PointOption endPointzoomOut = new PointOption().withCoordinates(xAxis, yAxis + 200);
		TouchAction zoomIn = new TouchAction((PerformsTouchActions) driver);
		zoomIn.press(startPointzoomIn).moveTo(endPointzoomOut).release();
		multiTouchAction.add(zoomOut).add(zoomIn).perform();

	}

//	public void zoomOut(int xAxis, int yAxis) {
//		// ise coOrdinate ke base par karana hai
//
//		MultiTouchAction multiTouchAction = new MultiTouchAction((PerformsTouchActions) driver);
//		PointOption startPointzoomout = new PointOption().withCoordinates(xAxis, yAxis - 10);
//		PointOption endpointzoomout = new PointOption().withCoordinates(xAxis, yAxis - 200);
//        TouchAction zoomOut = new TouchAction((PerformsTouchActions) driver);
//		zoomOut.press(startPointzoomout).moveTo(endpointzoomout).release();
//        PointOption startPointzoomIn = new PointOption().withCoordinates(xAxis, yAxis + 10);
//		PointOption endPointzoomOut = new PointOption().withCoordinates(xAxis, yAxis + 200);
//        TouchAction zoomIn = new TouchAction((PerformsTouchActions) driver);
//		zoomIn.press(startPointzoomIn).moveTo(endPointzoomOut).release();
//        multiTouchAction.add(zoomOut).add(zoomIn).perform();
//
//		
//	}

	public void zoomInByElement() {

	}

	public void zoomTwoFinger(TouchAction finger1, TouchAction finger2) {
		MultiTouchAction multiTouch = new MultiTouchAction((PerformsTouchActions) driver);
		multiTouch.add(finger1).add(finger2).perform();

	}

	public void zoomThreeFinger(TouchAction finger1, TouchAction finger2, TouchAction finger3) {
		MultiTouchAction multiToch = new MultiTouchAction((PerformsTouchActions) driver);
		multiToch.add(finger1).add(finger2).add(finger3).perform();

	}

	//////////// BUTTONS--- LIKE HOME BTN, POWER BTN./////////////////
	public void homeBtn() {
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.HOME));
	}

	public void volumeBtn(String btn) {
		if (btn.equalsIgnoreCase("up")) {
			((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.VOLUME_UP));
		} else if (btn.equalsIgnoreCase("down")) {
			((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.VOLUME_DOWN));
		} else if (btn.equalsIgnoreCase("mute")) {
			((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.VOLUME_MUTE));
		} else {
			System.out.println("You have Entered wrong BTN ");
		}
	}

	public void androidBTNS(AndroidKey button) {
		((AndroidDriver) driver).pressKey(new KeyEvent(button));

		// parameter seedha(androidkey.btnkanaam likhe )
	}

	//// checking of methods after executingn in the main method ///////
//	public static void main(String[] args) {
//
//		Utility util = new Utility();
//		util.launchApplication("D:\\new projects\\AppiumFrameworkWithCucumberTwoTypesFramework\\APPS\\ApiDemos-debug.apk");
//		WebElement view = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]"));
//driver.findElement(ByAndroidUIAutomator.AccessibilityId(""));
////util.click(view);
//		util.androidBTNS(AndroidKey.APP_SWITCH);
//		util.androidBTNS(AndroidKey.POWER);
//		util.androidBTNS(AndroidKey.APP_SWITCH);
//		
//		util.tap(view);
//
//	}

}
