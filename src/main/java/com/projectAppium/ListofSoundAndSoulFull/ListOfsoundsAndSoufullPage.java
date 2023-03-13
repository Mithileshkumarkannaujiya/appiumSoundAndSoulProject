package com.projectAppium.ListofSoundAndSoulFull;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.projectAppium.Utility.Utility;

public class ListOfsoundsAndSoufullPage {
	private Utility webUtil;

	public ListOfsoundsAndSoufullPage(Utility webUtil) {
		this.webUtil = webUtil;
	}

	public void launchApplication() {

		webUtil.launchApplication("com.allied.sns", "com.allied.sns.MainActivity");
		webUtil.implicitywait(10);
	}

	public void validLogin() {
		WebElement emailTxt = webUtil.getDriver().findElement(By.className("android.widget.EditText"));
		webUtil.tap(emailTxt);
		webUtil.sendKey(emailTxt, "mithileshkumar2831999@gmail.com");
		webUtil.hideKeyBoard();

		WebElement verifyEmailBtn = webUtil.getDriver()
				.findElement(By.xpath("//android.view.View[@content-desc=\"Verify Email\"]"));
		webUtil.tap(verifyEmailBtn);

		webUtil.staticWait(4);

		WebElement password = webUtil.getDriver().findElement(By.className("android.widget.EditText"));
		webUtil.tap(password);
		webUtil.sendKey(password, "Mith");
		webUtil.hideKeyBoard();

		WebElement loginBtn = webUtil.getDriver().findElement(By.xpath("//android.view.View[@content-desc=\"Login\"]"));
		webUtil.tap(loginBtn);

		webUtil.staticWait(4);

// Swiping Process		
		for (int i = 1; i < 5; i++) {
			webUtil.staticWait(4);
			webUtil.swipe(879, 1297, 197, 1297);
		}

		webUtil.staticWait(4);

		WebElement doneBtn = webUtil.getDriver()
				.findElement(By.xpath("//android.widget.Button[@content-desc=\"DONE\"]"));
		webUtil.tap(doneBtn);

		System.out.println("____ checkig all links working properly_______________");

		List<WebElement> subliminals = webUtil.getDriver().findElements(By.className("android.widget.ImageView"));

		for (int i = 0; i < subliminals.size(); i++) {
			webUtil.staticWait(1);
			WebElement subliminal = subliminals.get(i);
			System.out
					.println("Subliminal Name-----------------------------" + subliminal.getAttribute("content-desc"));

			webUtil.click(subliminal);
			List<WebElement> categoryWeb = webUtil.getDriver().findElements(By.className("android.widget.ImageView"));
			webUtil.staticWait(7);

			for (int j = 0; j < categoryWeb.size(); j++) {
				categoryWeb = webUtil.getDriver().findElements(By.className("android.widget.ImageView"));
				WebElement cat = categoryWeb.get(j);
				System.out.println("Category Name-----------------------------" + cat.getAttribute("content-desc"));
				webUtil.click(cat);
				webUtil.staticWait(7);
				System.out.println("______List of Sounds and soulful________ ");

				List<WebElement> songsname = webUtil.getDriver().findElements(By.className("android.widget.ImageView"));
				for (int k = 0; k < songsname.size(); k++) {
					songsname = webUtil.getDriver().findElements(By.className("android.widget.ImageView"));
					WebElement song = songsname.get(k);
					System.out.println(song.getAttribute("content-desc"));

				}

				webUtil.navigateBack();

			}

			webUtil.staticWait(7);
			webUtil.navigateBack();

		}

	}

}
