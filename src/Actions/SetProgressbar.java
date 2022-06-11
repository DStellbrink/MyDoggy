package Actions;

import DoggyStats.MyDoggy;

public class SetProgressbar {
	
	public static String progressHappy() {
		if (MyDoggy.getHappiness()<30){
			return "-fx-accent: red;";
		}
		else if (MyDoggy.getHappiness()>70){
			return "-fx-accent: green;";
		}
		return "-fx-accent: orange;";		
	}
	
	public static String progressNeeds (int need) {
	
		if(need <30) {
			return "-fx-accent: green;";	
		}
		else if (need > 70) {
			return "-fx-accent: red;";
		}
		return "-fx-accent: orange;";
	}
	
	public static String progressBMI () {
		if (MyDoggy.getBMI()<18 || MyDoggy.getBMI()>25){
			return "-fx-accent: red;";
		}
		
		return "-fx-accent: green;";	
	}
}
