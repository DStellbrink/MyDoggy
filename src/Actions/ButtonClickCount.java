package Actions;

import DoggyStats.MyDoggy;
import javafx.scene.control.Button;

public class ButtonClickCount {
	
	public static void clickCount (Button button) {
		
		if (button.getText().equals("Friend")) 
			MyDoggy.setCountFriend(MyDoggy.getCountFriend()+1);
		
		else if (button.getText().equals("Play"))
			MyDoggy.setCountPlay(MyDoggy.getCountPlay()+1);
		
		else if (button.getText().equals("Feed"))
			MyDoggy.setCountFeed(MyDoggy.getCountFeed()+1);
		
		else if (button.getText().equals("Vet"))
			MyDoggy.setCountVet(MyDoggy.getCountVet()+1);
	}
}
