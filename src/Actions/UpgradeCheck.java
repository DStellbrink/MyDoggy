package Actions;

import MyDoggyFX.FXMLController;

public class UpgradeCheck {

	public static boolean upgradeCheck(int position) {
		
		String [] tempUpgrade = FXMLController.getUpgradeStatus();
		
		if (tempUpgrade[position].equals("true"))
			return true;
		
		return false;
	}
}
