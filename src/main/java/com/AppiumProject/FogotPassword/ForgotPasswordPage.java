package com.AppiumProject.FogotPassword;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.projectAppium.Utility.Utility;

public class ForgotPasswordPage {
	private Utility webUtil;

	public ForgotPasswordPage(Utility webUtil) {
		this.webUtil = webUtil;
	}

	public void launchApplication() {

		webUtil.launchApplication("com.allied.sns", "com.allied.sns.MainActivity");
		webUtil.implicitywait(10);
	}

	public void forgotPassword() {
		WebElement emailTxt = webUtil.getDriver().findElement(By.className("android.widget.EditText"));
		webUtil.tap(emailTxt);
		webUtil.sendKey(emailTxt, "mithileshkumar2831999@gmail.com");
		webUtil.hideKeyBoard();

		WebElement verifyEmailBtn = webUtil.getDriver()
				.findElement(By.xpath("//android.view.View[@content-desc=\"Verify Email\"]"));
		        webUtil.tap(verifyEmailBtn);

		          webUtil.staticWait(7);

		WebElement forgotPasswordBtn = webUtil.getDriver()
				.findElement(By.xpath("//android.view.View[@content-desc=\"Forgot Password?\"]"));
		webUtil.tap(forgotPasswordBtn);

		webUtil.staticWait(4);

		System.out.println("hi");
//
//		WebElement emailTxtforgot = webUtil.getDriver().findElement(By.className("android.widget.EditText"));
//		webUtil.tap(emailTxtforgot);
//		webUtil.sendKey(emailTxtforgot, "mithileshkumar2831999@gmail.com");
//		webUtil.hideKeyBoard();

		WebElement reset = webUtil.getDriver().findElement(By.xpath("//android.view.View[@content-desc=\"Reset\"]"));
		webUtil.tap(reset);

	}

}
