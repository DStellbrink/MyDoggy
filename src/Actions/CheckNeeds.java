package Actions;

import DoggyStats.MyDoggy;

public class CheckNeeds {
	
	public static String checkNeeds() {
		
		if (MyDoggy.getHunger()> 90)
			return "I'm SO hungy!";
		if (MyDoggy.getIllnes()> 90)
			return "I'm feeling sick.";
		if (MyDoggy.getPeePee()> 90)
			return "I have to pee!";
		if (MyDoggy.getShaggyness()> 90)
			return "Can't you brush my fur?";
		if (MyDoggy.getHappiness()> 90)
			return "I'm SO happy!";
		if (MyDoggy.getHappiness() < 30)
			return "I'm sad!";
	
		return "Everything is fine.";
	}

}
