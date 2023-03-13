package soundandSoulfulTestRunner;

import com.AppiumProject.FogotPassword.ForgotPasswordPage;
import com.projectAppium.Utility.Utility;

public class ForgotPasswordTestRunner {
private static Utility webUtil;
	
	public static void main(String[] args) {
	  webUtil=new Utility();
	  
	ForgotPasswordPage fPass = new ForgotPasswordPage(webUtil);
	fPass.launchApplication();
	fPass.forgotPassword();
	
	
}
}
