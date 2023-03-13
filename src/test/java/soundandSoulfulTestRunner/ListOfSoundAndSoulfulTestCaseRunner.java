package soundandSoulfulTestRunner;

import com.projectAppium.ListofSoundAndSoulFull.ListOfsoundsAndSoufullPage;
import com.projectAppium.Utility.Utility;

public class ListOfSoundAndSoulfulTestCaseRunner {
private static Utility  webUtil;
	public static void main(String[] args) {
	webUtil=new Utility();
	ListOfsoundsAndSoufullPage login = new ListOfsoundsAndSoufullPage(webUtil);
	login.launchApplication();
	webUtil.staticWait(4);
	login.validLogin();

	
	
}
}
