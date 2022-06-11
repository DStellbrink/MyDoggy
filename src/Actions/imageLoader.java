package Actions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;

public interface imageLoader {
	
	public static Image loadImage(String name) {
		try {
			return new Image (new FileInputStream(name +".png"));
		} catch (FileNotFoundException e) {	
			e.printStackTrace();
			return null;
		}
	}
}
