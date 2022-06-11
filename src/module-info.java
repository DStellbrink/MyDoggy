module DoggyClickerFX {
	requires java.desktop;
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.base;
	requires javafx.fxml;

	opens MyDoggyFX to javafx.controls, javafx.base, javafx.graphics, javafx.fxml;
}