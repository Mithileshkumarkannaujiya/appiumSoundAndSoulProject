package soundandSoulfulTestRunner;

import com.projectAppium.Pages.SoundAndSoulfulLinearAutomation;
import com.projectAppium.Utility.Utility;

public class RegistrationTestRunner {
	private static Utility webUtil;

	public static void main(String[] args) {
		webUtil = new Utility();
		SoundAndSoulfulLinearAutomation sound = new SoundAndSoulfulLinearAutomation(webUtil);
		sound.launchApplication();
		webUtil.staticWait(9);
		sound.Register();
		
		
		
	}

}
