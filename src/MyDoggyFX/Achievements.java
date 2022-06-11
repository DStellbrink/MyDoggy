package MyDoggyFX;

import DoggyStats.MyDoggy;

public class Achievements {
	  
	
	public static int achievementCheck() {
		String [] achievementStatus = new String[FXMLController.getAchievementNr()];
		achievementStatus = FXMLController.getAchievementsStatus();
		String [] upgradeStatus = FXMLController.getUpgradeStatus();
		
		// 1. Achievement
		if (upgradeStatus[1] == "true" && achievementStatus [0].equals("false")) {	
			achievementStatus[0] = "true";
			return 0;
		}
				
		// 2. Achievement
		if (MyDoggy.getHunger()== 100  && achievementStatus [1].equals("false")) {
			achievementStatus[1] = "true";
			return 1;
		}
		// 3. Achievement
		if (MyDoggy.getCountVet() == 200  && achievementStatus [2].equals("false")) {
			achievementStatus[2] = "true";
			return 2;
		}
		
		// 4. Achievement
		if (MyDoggy.getCountFriend() == 200  && achievementStatus [3].equals("false")) {
			achievementStatus[3] = "true";
			return 3;
		}
		
		// 5. Achievement
		if (achievementStatus [4].equals("false")) {
			int count = 0;
			for (String s : upgradeStatus)
				if (s.equals("true"))
					count++;
			
			if (count == FXMLController.getUpgradeNr()) {
				achievementStatus[4] = "true";
				return 4;
			}
		}
		
		// 6. Achievement
		if (MyDoggy.getCountFeed() == 200  && achievementStatus [5].equals("false")) {
			achievementStatus[5] = "true";
			return 5;
		}
		
		// 7. Achievement
		if (MyDoggy.getCountPlay() == 200  && achievementStatus [6].equals("false")) {
			achievementStatus[6] = "true";
			return 6;
		}
		
		// 8. Achievement
		if (MyDoggy.getCountPlay() == 1000  && achievementStatus [7].equals("false")) {
			achievementStatus[7] = "true";
			return 7;
		}
		
		// 9. Achievement

		if (MyDoggy.getLovePoints() == 200  && achievementStatus [8].equals("false")) {
			achievementStatus[8] = "true";
			return 8;
		}
		
		// 10. Achievement
		
		if (achievementStatus [9].equals("false")) {
			for (int i = 0; i<achievementStatus.length-1;i++) {
				if (achievementStatus[i] == "true" && i == achievementStatus.length-2) {
					achievementStatus[9] = "true";	
					return 9;
				}
				else if (achievementStatus[i] != "true") {
					break;
				}
			}
		}
		
		FXMLController.setAchievementsStatus(achievementStatus);
		return -1;
	}
}
