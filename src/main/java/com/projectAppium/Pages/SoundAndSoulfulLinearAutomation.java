package com.projectAppium.Pages;


import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.projectAppium.Utility.Utility;

import io.appium.java_client.android.nativekey.AndroidKey;
import net.bytebuddy.description.type.TypeDescription.Generic.Visitor.Reifying;

public class SoundAndSoulfulLinearAutomation {
	private Utility webUtil;

	public SoundAndSoulfulLinearAutomation(Utility webUtil) {
		this.webUtil = webUtil;

	}

	public void launchApplication() {

		webUtil.launchApplication("com.allied.sns", "com.allied.sns.MainActivity");
 //             webUtil.implicitywait(10);
	}

	public void Register() {

		WebElement emailTxt = webUtil.getDriver().findElement(By.className("android.widget.EditText"));
		webUtil.tap(emailTxt);
		webUtil.sendKey(emailTxt, "mkchaudharievs@gmail.com");
		//webUtil.androidBTNS(AndroidKey.ENTER);
		webUtil.hideKeyBoard();

		WebElement verifyEmailBtn = webUtil.getDriver().findElement(By.xpath("//android.view.View[@content-desc=\"Verify Email\"]"));
		webUtil.tap(verifyEmailBtn);
		
		webUtil.staticWait(5);
		
		
		
		List<WebElement> regi = webUtil.getDriver().findElements(By.className("android.widget.EditText"));
		//webUtil.staticWait(4);
		webUtil.tap(regi.get(0));
		webUtil.sendKey(regi.get(0), "Rajesh");		
		webUtil.hideKeyBoard();

		webUtil.staticWait(1);

		
		webUtil.tap(regi.get(1));
		webUtil.sendKey(regi.get(1), "6307904972");		
		webUtil.hideKeyBoard();

		webUtil.staticWait(1);

		
		webUtil.tap(regi.get(2));
		webUtil.sendKey(regi.get(2), "Raj123@#");		
		webUtil.hideKeyBoard();

		webUtil.staticWait(1);

		
		webUtil.tap(regi.get(3));
		webUtil.sendKey(regi.get(3), "Raj123@#");		
		webUtil.hideKeyBoard();	

		webUtil.staticWait(1);

		
		webUtil.tap(regi.get(4));
		
		
	}
}
