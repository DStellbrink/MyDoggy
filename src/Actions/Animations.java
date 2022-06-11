package Actions;

import DoggyStats.DoggyBMI;
import DoggyStats.MyDoggy;
import MyDoggyFX.FXMLController;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.util.Duration;

public class Animations{
	
	static String [] doggyImgNormal = {"dstands",  "dstands_happy","dstands_food", "djump_food", "djump", "dwalk"};
	static String [] doggyImgFat = {"dstands_fat", "dstands_happyfat","dstands_food_fat", "djump_food_fat", "djump_fat", "dwalk_fat"};
	static String [] doggyImgSlim = { "dstands_slim", "dstands_happyslim", "dstands_food_slim", "djump_food_slim", "djump_slim", "dwalk_slim"};
	
	static String [] doggyImgLaught = {"dlaught1", "dlaught2"};
	static String [] doggyImgSleep = {"dsleep1", "dsleep2", "dsleep3", "dsleep4"};
	static String [] doggyfriend = {"fjump", "fstands"};
	
	
	
	static Timeline timeline;
	static int index = 0;
	static int iCount= 0;
	
	public static void doggyFeed() {
		
		iCount = 0;
		index = 0;
		timeline = new Timeline(new KeyFrame(Duration.millis(500), event ->{
			iCount++;
			if (index == 0) {
				index++;
				if(MyDoggy.getDoggyBMI()== DoggyBMI.SLIM)
					FXMLController.setImgMyDoggyStatic(doggyImgSlim[3]);
				else if (MyDoggy.getDoggyBMI()== DoggyBMI.FAT) 
					FXMLController.setImgMyDoggyStatic(doggyImgFat[3]);
				else 
					FXMLController.setImgMyDoggyStatic(doggyImgNormal[3]);
			}
			else if (index == 1) {
				index--;
				if(MyDoggy.getDoggyBMI()== DoggyBMI.SLIM)
					FXMLController.setImgMyDoggyStatic(doggyImgSlim[2]);
				else if (MyDoggy.getDoggyBMI()== DoggyBMI.FAT) 
					FXMLController.setImgMyDoggyStatic(doggyImgFat[2]);
				else 
					FXMLController.setImgMyDoggyStatic(doggyImgNormal[2]);
			}
			if (iCount == 10)
				doggyStands();
			}));
		timeline.setCycleCount(10);
		timeline.play();
	}

	public static void doggyPlay() {
			
		iCount= 0;
		index = 0;
		timeline = new Timeline(new KeyFrame(Duration.millis(500), event ->{
			iCount++;
			if (index == 0) {
				index++;
			if(MyDoggy.getDoggyBMI()== DoggyBMI.SLIM)
					FXMLController.setImgMyDoggyStatic(doggyImgSlim[0]);
				else if (MyDoggy.getDoggyBMI()== DoggyBMI.FAT) 
					FXMLController.setImgMyDoggyStatic(doggyImgFat[0]);
				else 
					FXMLController.setImgMyDoggyStatic(doggyImgNormal[0]);
			}
			else if (index == 1) {
				index--;
				if(MyDoggy.getDoggyBMI()== DoggyBMI.SLIM)
					FXMLController.setImgMyDoggyStatic(doggyImgSlim[4]);
				else if (MyDoggy.getDoggyBMI()== DoggyBMI.FAT) 
					FXMLController.setImgMyDoggyStatic(doggyImgFat[4]);
				else 
					FXMLController.setImgMyDoggyStatic(doggyImgNormal[4]);
			}
			if (iCount == 10)
				doggyStands();
		}));
		timeline.setCycleCount(10);
		timeline.play();
	}
	
	public static void doggyFriend() {
		
		iCount= 0;
		index = 0;
		timeline = new Timeline(new KeyFrame(Duration.millis(500), event ->{
			iCount++;
			if (index == 0) {
				index++;
				if(MyDoggy.getDoggyBMI()== DoggyBMI.SLIM)
					FXMLController.setImgMyDoggyStatic(doggyImgSlim[0]);
				else if (MyDoggy.getDoggyBMI()== DoggyBMI.FAT) 
					FXMLController.setImgMyDoggyStatic(doggyImgFat[0]);
				else {
					FXMLController.setImgMyDoggyStatic(doggyImgNormal[0]);
					FXMLController.setImgFriendStatic(doggyfriend[0]);
				}
			}
			else if (index == 1) {
				index--;
				if(MyDoggy.getDoggyBMI()== DoggyBMI.SLIM)
					FXMLController.setImgMyDoggyStatic(doggyImgSlim[4]);
				else if (MyDoggy.getDoggyBMI()== DoggyBMI.FAT) 
					FXMLController.setImgMyDoggyStatic(doggyImgFat[4]);
				else {
					FXMLController.setImgMyDoggyStatic(doggyImgNormal[4]);
					FXMLController.setImgFriendStatic(doggyfriend[1]);
				}
			}
			if (iCount == 10) {
				doggyStands();
				FXMLController.setImgFriendStatic(null);
			}
		}));
		timeline.setCycleCount(10);
		timeline.play();
	}
	
	public static void doggyWalk(Button button) {
		
		if (button.getText().equals("Walk")|| button.getText().equals("Vet")) {
			iCount = 0;
			index = 0;
			timeline = new Timeline(new KeyFrame(Duration.millis(500), event ->{
				iCount++;
				if (index == 0) {
					index++;
					if(MyDoggy.getDoggyBMI()== DoggyBMI.SLIM)
						FXMLController.setImgMyDoggyStatic(doggyImgSlim[0]);
					else if (MyDoggy.getDoggyBMI()== DoggyBMI.FAT) 
						FXMLController.setImgMyDoggyStatic(doggyImgFat[0]);
					else 
						FXMLController.setImgMyDoggyStatic(doggyImgNormal[0]);
				}
				else if (index == 1) {
					index--;
					if(MyDoggy.getDoggyBMI()== DoggyBMI.SLIM)
						FXMLController.setImgMyDoggyStatic(doggyImgSlim[5]);
					else if (MyDoggy.getDoggyBMI()== DoggyBMI.FAT) 
						FXMLController.setImgMyDoggyStatic(doggyImgFat[5]);
					else  
						FXMLController.setImgMyDoggyStatic(doggyImgNormal[5]);
				}
				if (iCount == 10)
					doggyStands();
			}));
			timeline.setCycleCount(10);
			timeline.play();
			}
	}
	
	public static void doggyLaught() {
		
		iCount = 0;
		index = 0;
		timeline = new Timeline(new KeyFrame(Duration.millis(500), event ->{
			iCount++;
			if (index == 0) {
				index++;
				FXMLController.setImgMyDoggyStatic(doggyImgLaught[1]);				
			}
			else if (index == 1) {
				index--;
				FXMLController.setImgMyDoggyStatic(doggyImgLaught[0]);				
			}	
			if (iCount == 10) 
				doggyStands();
		}));
		timeline.setCycleCount(10);
		timeline.play();
	}
	
	public static void doggyBlinck() {
		
		iCount = 0;
		index = 0;
		timeline = new Timeline(new KeyFrame(Duration.millis(500), event ->{
			iCount++;
			if (index == 0) {
				index++;
				if(MyDoggy.getDoggyBMI()== DoggyBMI.SLIM)
					FXMLController.setImgMyDoggyStatic(doggyImgSlim[0]);
				else if (MyDoggy.getDoggyBMI()== DoggyBMI.FAT) 
					FXMLController.setImgMyDoggyStatic(doggyImgFat[0]);
				else 
					FXMLController.setImgMyDoggyStatic(doggyImgNormal[0]);
			}
			else if (index == 1) {
				index--;
				if(MyDoggy.getDoggyBMI()== DoggyBMI.SLIM)
					FXMLController.setImgMyDoggyStatic(doggyImgSlim[1]);
				else if (MyDoggy.getDoggyBMI()== DoggyBMI.FAT) 
					FXMLController.setImgMyDoggyStatic(doggyImgFat[1]);
				else 
					FXMLController.setImgMyDoggyStatic(doggyImgNormal[1]);
			}
			if (iCount == 10)
				doggyStands();
		}));
		timeline.setCycleCount(10);
		timeline.play();	
	}
	
	public static void doggySleep() {
		
		iCount = 0;
		index = 0;
		timeline = new Timeline(new KeyFrame(Duration.millis(500), event ->{
			iCount++;
			if (index == 0) {
				index++;
				FXMLController.setImgMyDoggyStatic(doggyImgSleep[0]);
			}
			else if (index == 1) {
				index++;
				FXMLController.setImgMyDoggyStatic(doggyImgSleep[1]);
			}
			else if (index == 2) {
				index++;
				FXMLController.setImgMyDoggyStatic(doggyImgSleep[2]);
			}
			else if (index == 3) {
				index=0;
				FXMLController.setImgMyDoggyStatic(doggyImgSleep[3]);
			}
			if (iCount == 12)
				doggyStands();
		}));
			timeline.setCycleCount(12);
			timeline.play();
	}
	
	public static void doggyStands() {
		if (MyDoggy.getDoggyBMI()== DoggyBMI.SLIM)
			FXMLController.setImgMyDoggyStatic(doggyImgSlim[0]);
		else if (MyDoggy.getDoggyBMI()== DoggyBMI.FAT)
			FXMLController.setImgMyDoggyStatic(doggyImgFat[0]);
		else 
			FXMLController.setImgMyDoggyStatic(doggyImgNormal[0]);
	}
}
