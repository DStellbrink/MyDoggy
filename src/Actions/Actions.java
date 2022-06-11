package Actions;


import DoggyStats.MyDoggy;
import MyDoggyFX.FXMLController;
import javafx.application.Platform;

public class Actions  { 
	FXMLController controller= new FXMLController();
	
	public void setController (FXMLController controller) {
		this.controller = controller;
	}
	
	public static void doggyFeed(){
		
		MyDoggy.setDoggyStats((MyDoggy.getDoggyAge()+0.01),
				(MyDoggy.getDoggyWeight()+0.5), 
				(MyDoggy.getHappiness()+2), 
				(MyDoggy.getTiredness()+2), 
				(MyDoggy.getPeePee()+5), 
				(MyDoggy.getHunger()-20), 
				(MyDoggy.getIllnes()+5));
		MyDoggy.setDoggyBMI();
		
		if (UpgradeCheck.upgradeCheck(0) == true) {
			MyDoggy.setHappiness(MyDoggy.getHappiness()+2);
		}
		if (UpgradeCheck.upgradeCheck(7) == true) {
			MyDoggy.setIllnes(MyDoggy.getIllnes()-1);
			MyDoggy.setDoggyWeight(MyDoggy.getDoggyWeight()-0.1);
		}
	}
	
	public static void doggyWalk(){
		MyDoggy.setDoggyStats((MyDoggy.getDoggyAge()+0.01),
				(MyDoggy.getDoggyWeight()-0.5), 
				(MyDoggy.getHappiness()+5), 
				(MyDoggy.getTiredness()+10), 
				0, 
				(MyDoggy.getHunger()+5), 
				(MyDoggy.getIllnes()+1));
		MyDoggy.setDoggyBMI();
		
		if (UpgradeCheck.upgradeCheck(2) == true) {
			MyDoggy.setTiredness(MyDoggy.getTiredness()-2);
		}
	}
	
	public static void doggyPlay(){
		MyDoggy.setDoggyStats((MyDoggy.getDoggyAge()+0.01),
				(MyDoggy.getDoggyWeight()-0.1), 
				(MyDoggy.getHappiness()+5), 
				(MyDoggy.getTiredness()+5), 
				(MyDoggy.getPeePee()+5), 
				(MyDoggy.getHunger()+5), 
				(MyDoggy.getIllnes()+1));
		MyDoggy.setDoggyBMI();	
		
		if (UpgradeCheck.upgradeCheck(3) == true) {
			MyDoggy.setHappiness(MyDoggy.getHappiness()+2);
		}
	}

	public static void doggyVet(){
		MyDoggy.setDoggyStats((MyDoggy.getDoggyAge()+0.01),
				(MyDoggy.getDoggyWeight()), 
				(MyDoggy.getHappiness()-10), 
				(MyDoggy.getTiredness()+2), 
				0, 
				(MyDoggy.getHunger()+5), 
				0);
		MyDoggy.setDoggyBMI();
		
		if (UpgradeCheck.upgradeCheck(4) == true) {
			MyDoggy.setHappiness(MyDoggy.getHappiness()+2);
		}
		if (UpgradeCheck.upgradeCheck(8) == true) {
			MyDoggy.setHappiness(MyDoggy.getHappiness()+2);
		}
	}
	
	public static void doggySleep(){
		MyDoggy.setDoggyStats((MyDoggy.getDoggyAge()+0.01),
				(MyDoggy.getDoggyWeight()), 
				(MyDoggy.getHappiness()+5), 
				0, 
				(MyDoggy.getPeePee()+5),
				(MyDoggy.getHunger()+5), 
				(MyDoggy.getIllnes()+1));
		MyDoggy.setDoggyBMI();
		
		if (UpgradeCheck.upgradeCheck(9) == true) {
			MyDoggy.setHappiness(MyDoggy.getHappiness()+3);
		}
	}
	
	public static void doggyFriend(){
		MyDoggy.setDoggyStats((MyDoggy.getDoggyAge()+0.01),
				(MyDoggy.getDoggyWeight()), 
				(MyDoggy.getHappiness()+5), 
				(MyDoggy.getTiredness()+10), 
				(MyDoggy.getPeePee()+5), 
				(MyDoggy.getHunger()+5), 
				(MyDoggy.getIllnes()+1));
		MyDoggy.setDoggyBMI();
	}
	
	public static void doggyGrooming(){
		MyDoggy.setDoggyStats((MyDoggy.getDoggyAge()+0.01),
				(MyDoggy.getDoggyWeight()-0.2), 
				(MyDoggy.getHappiness()+2), 
				(MyDoggy.getTiredness()+5),
				(MyDoggy.getPeePee()-2), 
				(MyDoggy.getHunger()+5), 
				(MyDoggy.getIllnes()+1));
		MyDoggy.setDoggyBMI();
		
		if (UpgradeCheck.upgradeCheck(5) == true) {
			MyDoggy.setHappiness(MyDoggy.getHappiness()+2);
		}
	}
	
	public static void doggyTickle(){
		MyDoggy.setDoggyStats((MyDoggy.getDoggyAge()+0.01),
				(MyDoggy.getDoggyWeight()-0.2), 
				(MyDoggy.getHappiness()+5), 
				(MyDoggy.getTiredness()+5), 
				(MyDoggy.getPeePee()+5),
				(MyDoggy.getHunger()+2), 
				(MyDoggy.getIllnes()+1));
		MyDoggy.setDoggyBMI();
		
		if (UpgradeCheck.upgradeCheck(6) == true) {
			MyDoggy.setHappiness(MyDoggy.getHappiness()+2);
		}
	}
	
	public static void doggyClose(){
		Platform.exit();
	}
	
	// opacity change of the icons
	public static double changeOpacity(String [] updates, int index) {
		
		if (updates[index].endsWith(" - Bought") == true) {
			return 1.0;					
	}
	return 0.0;
	}	
}
