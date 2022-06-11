package MyDoggyFX;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import Actions.Actions;
import Actions.Animations;
import Actions.ButtonClickCount;
import Actions.CheckNeeds;
import Actions.Data;
import Actions.SetProgressbar;
import Actions.UpgradeCheck;
import Actions.imageLoader;
import DoggyStats.MyDoggy;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.util.Duration;

// Doggy Pics from Pixabay
// Icons + Background;
// designed by Kiranshastry from Flaticon
// designed by Freepik from Flaticon 
// designed by Adib Sulthon from Flaticon

public class FXMLController implements Initializable{
	
	@FXML Button btnPlay;
	@FXML Button btnFeed;
	@FXML Button btnTickle;
	@FXML Button btnWalk;
	@FXML Button btnGroom;
	@FXML Button btnSleep;
	@FXML Button btnFriend;
	@FXML Button btnVet;
	
	@FXML Button btnOption;
	@FXML Button btnAchievement;
	@FXML Button btnUpgrade;
	@FXML Button btnClose;
	@FXML Button btnCloseMenu;
	@FXML Button btnMenuChoice;
	
	@FXML Button btnImgUpgrade1;
	@FXML Button btnImgUpgrade2;
	@FXML Button btnImgUpgrade3;
	@FXML Button btnImgUpgrade4;
	@FXML Button btnImgUpgrade5;
	@FXML Button btnImgUpgrade6;
	@FXML Button btnImgUpgrade7;
	@FXML Button btnImgUpgrade8;
	@FXML Button btnImgUpgrade9;
	@FXML Button btnImgUpgrade10;
	
	@FXML Button btnFood;
	
	@FXML ImageView	imgMyDoggy;
	@FXML ImageView	imgFriend;
	
	@FXML ImageView	imgUpgrade1;
	@FXML ImageView	imgUpgrade2;
	@FXML ImageView	imgUpgrade3;
	@FXML ImageView	imgUpgrade4;
	@FXML ImageView	imgUpgrade5;
	@FXML ImageView	imgUpgrade6;
	@FXML ImageView	imgUpgrade7;
	@FXML ImageView	imgUpgrade8;
	@FXML ImageView	imgUpgrade9;
	@FXML ImageView	imgUpgrade10;
	
	@FXML ImageView imgMenu;	
	@FXML ImageView imgAchievement;
	
	@FXML ImageView imgBg1;
	@FXML ImageView imgBg2;
	
	@FXML Label lblAchievement;
	
	@FXML Label lblNeed;
	@FXML Label lblName;
	@FXML Label lblStats;
	
	@FXML Label lblHungry;
	@FXML Label lblHappy;
	@FXML Label lblSick;
	@FXML Label lblTired;
	@FXML Label lblPee;
	@FXML Label lblBMI;
	@FXML Label lblLove;
	@FXML Label lblShaggy;
	
	@FXML Label lblMenuChoice;
	@FXML Label lblMenuCost;
	
	@FXML ProgressBar progressHappy;
	@FXML ProgressBar progressHungry;
	@FXML ProgressBar progressTiered;
	@FXML ProgressBar progressSick;
	@FXML ProgressBar progressPee;
	@FXML ProgressBar progressLovePoints;
	@FXML ProgressBar progressBMI;
	@FXML ProgressBar progressShaggy;
	
	@FXML TextArea menuInformation;
	
	@FXML HBox hBox;
	@FXML HBox hAchievement;
	
	@FXML GridPane gameView;
	@FXML GridPane menuView;
	@FXML GridPane gridMenu;
	
	@FXML ListView<String> menu;
	
	final static int UPGRADENR = 10;
	final static int ACHIEVMENTNR = 10;
	final static int OPTIONNR= 3;
	
	static String [] upgrades = new String[UPGRADENR];
	static String [] upgradeImg = new String [UPGRADENR];
	static String [] upgradeTxt = new String [UPGRADENR];
	static int [] upgradeCost = new int[UPGRADENR];
	static String [] upgradeStatus  = new String [UPGRADENR];
	
	static String [] achievements = new String [ACHIEVMENTNR];
	static String [] achievementsImg = new String [ACHIEVMENTNR];
	static String [] achievementsTxt = new String [ACHIEVMENTNR];
	static String [] achievementsStatus = new String [ACHIEVMENTNR];

	String [] options = {"Save", "Load", "New"};
	String [] optionsImg = {"save", "file(1)","new"};
	String [] optionsTxt = {"Save your doggy", "Load your doggy", "Create a new doggy"};

	DecimalFormat dFormat = new DecimalFormat("##.00");
	String [] doggyImg = {"dstands", "dstands_fat", "dstands_slim", "dstands_happy", "dstands_happyfat", "stands_happyslim"};
	String [] doggyImgFood = {"dstands_food", "djump_food", "dstands_food_fat", "djump_food_fat","dstands_food_slim", "djump_food_slim"};
	String [] doggyImgMove = {"djump", "dwalk", "dlaught1", "dlaught2"};
	String [] doggyImgSleep = {"dsleep1", "dsleep2", "dsleep3", "dsleep4"};
	
	String [] friendImg = {"friendLaugth"};
	
	static String folderDogs = "image/";
	String folderIcons= "icons/";
	
	InnerShadow shadow = new InnerShadow();
	
	Timeline timer;
	
	int count  = 0;
	
	static ImageView imgMyDoggyStatic;
	static ImageView imgFriendStatic;

	public FXMLController() {		
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		// setonAction for buttons
		btnPlay.setOnAction(event -> {
			Actions.doggyPlay();
			Animations.doggyPlay();
			ButtonClickCount.clickCount(btnPlay);
			updateStats();
		});
		btnPlay.setOnMouseEntered(event -> hasShadow(true, btnPlay));
		btnPlay.setOnMouseExited(event -> hasShadow(false, btnPlay));
		
		btnFeed.setOnAction(event -> {
			Actions.doggyFeed();
			Animations.doggyFeed();
			ButtonClickCount.clickCount(btnFeed);
			updateStats();
		});
		btnFeed.setOnMouseEntered(event -> hasShadow(true, btnFeed));
		btnFeed.setOnMouseExited(event -> hasShadow(false, btnFeed));
		
		btnFriend.setDisable(true);
		btnFriend.setOnAction(event -> {
			Actions.doggyFriend();
			Animations.doggyFriend();
			ButtonClickCount.clickCount(btnFriend);
			updateStats();
		});
		btnFriend.setOnMouseEntered(event -> hasShadow(true, btnFriend));
		btnFriend.setOnMouseExited(event -> hasShadow(false, btnFriend));
		
		btnGroom.setOnAction(event ->{ 
			Actions.doggyGrooming();
			Animations.doggyBlinck();
			updateStats();
		});
		btnGroom.setOnMouseEntered(event -> hasShadow(true, btnGroom));
		btnGroom.setOnMouseExited(event -> hasShadow(false, btnGroom));
		
		btnSleep.setOnAction(event -> {
			Actions.doggySleep();
			Animations.doggySleep();
			updateStats();
		});
		btnSleep.setOnMouseEntered(event -> hasShadow(true, btnSleep));
		btnSleep.setOnMouseExited(event -> hasShadow(false, btnSleep));
		
		btnWalk.setOnAction(event -> {
			Actions.doggyWalk();
			Animations.doggyWalk(btnWalk);
			updateStats();
		});
		btnWalk.setOnMouseEntered(event -> hasShadow(true, btnWalk));
		btnWalk.setOnMouseExited(event -> hasShadow(false, btnWalk));
		
		btnTickle.setOnAction(event -> {
			Actions.doggyTickle();
			Animations.doggyLaught();
			updateStats();
		});
		btnTickle.setOnMouseEntered(event -> hasShadow(true, btnTickle));
		btnTickle.setOnMouseExited(event -> hasShadow(false, btnTickle));
		
		btnVet.setOnAction(event -> {
			Actions.doggyVet();
			Animations.doggyWalk(btnVet);
			ButtonClickCount.clickCount(btnVet);
			updateStats();
		});
		btnVet.setOnMouseEntered(event -> hasShadow(true, btnVet));
		btnVet.setOnMouseExited(event -> hasShadow(false, btnVet));
		
		btnCloseMenu.setOnAction(event -> {
			closeMenu();
			updateStats();
		});
		
		btnOption.setOnAction(event -> showMenu(btnOption));
		btnOption.setOnMouseEntered(event -> btnOption.setUnderline(true));
		btnOption.setOnMouseExited(event -> btnOption.setUnderline(false));
		btnAchievement.setOnAction(event -> showMenu(btnAchievement));
		btnAchievement.setOnMouseEntered(event -> btnAchievement.setUnderline(true));
		btnAchievement.setOnMouseExited(event -> btnAchievement.setUnderline(false));
		btnUpgrade.setOnAction(event -> showMenu(btnUpgrade));
		btnUpgrade.setOnMouseEntered(event -> btnUpgrade.setUnderline(true));
		btnUpgrade.setOnMouseExited(event -> btnUpgrade.setUnderline(false));
		
		btnClose.setOnAction(event -> Actions.doggyClose());
		btnClose.setOnMouseEntered(event -> hasShadow(true, btnClose));
		btnClose.setOnMouseExited(event -> hasShadow(false, btnClose));
		
		imgBg1.setImage(imageLoader.loadImage(folderDogs+ "bg1"));
		
		try {
			imgBg2.setImage(new Image(new FileInputStream(folderDogs + "4127069.jpg")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		if (Data.savegameCheck()== false)
			MyDoggy.setDoggyName(JOptionPane.showInputDialog("Wanna change the dogs name:", MyDoggy.getDoggyName()));
		
		// set stats
		if (MyDoggy.getDoggyName() == null || MyDoggy.getDoggyName().length()<=0)
			MyDoggy.setDoggyName("Carla");
		
		Data.setUpgrades();
		Data.setAchievments();

		hAchievement.setVisible(false);
		gridMenu.setBackground(null);
		imgMyDoggy.setImage(imageLoader.loadImage(folderDogs+"dstands"));
		updateStats();	
	}

	public void updateStats() {		
		
		imgMyDoggyStatic = imgMyDoggy;
		imgFriendStatic = imgFriend;
		
		// set labels
		lblName.setText(MyDoggy.getDoggyName());
		lblStats.setText("Age: "+ dFormat.format(MyDoggy.getDoggyAge())+ " years, Weight: " +  dFormat.format(MyDoggy.getDoggyWeight())+ " kg");
		
		lblNeed.setText(CheckNeeds.checkNeeds());
		lblHappy.setText(Integer.toString(MyDoggy.getHappiness()));
		lblHungry.setText(Integer.toString(MyDoggy.getHunger()));
		lblPee.setText(Integer.toString(MyDoggy.getPeePee()));
		lblTired.setText(Integer.toString(MyDoggy.getTiredness()));
		lblSick.setText(Integer.toString(MyDoggy.getIllnes()));
		lblBMI.setText((dFormat.format(MyDoggy.getBMI())));
		lblLove.setText(Integer.toString(MyDoggy.getLovePoints()));
		lblShaggy.setText(Integer.toString(MyDoggy.getShaggyness()));
		
		// set progressbars
		progressHappy.setProgress((double)MyDoggy.getHappiness()/100);			
		progressHappy.setStyle(SetProgressbar.progressHappy());
		progressBMI.setProgress((MyDoggy.getBMI()*100/MyDoggy.getBmimax())/100);
		progressBMI.setStyle(SetProgressbar.progressBMI());		
		progressPee.setProgress((double)MyDoggy.getPeePee()/100);
		progressPee.setStyle(SetProgressbar.progressNeeds(MyDoggy.getPeePee()));		
		progressHungry.setProgress((double)MyDoggy.getHunger()/100);
		progressHungry.setStyle(SetProgressbar.progressNeeds(MyDoggy.getHunger()));		
		progressSick.setProgress((double)MyDoggy.getIllnes()/100);
		progressSick.setStyle(SetProgressbar.progressNeeds(MyDoggy.getIllnes()));	
		progressTiered.setProgress((double)MyDoggy.getTiredness()/100);
		progressTiered.setStyle(SetProgressbar.progressNeeds(MyDoggy.getTiredness()));		
		progressLovePoints.setProgress((double)MyDoggy.getLovePoints()/100);
		progressLovePoints.setStyle(SetProgressbar.progressNeeds(MyDoggy.getLovePoints()));		
		progressShaggy.setProgress((double)MyDoggy.getShaggyness()/100);
		progressShaggy.setStyle(SetProgressbar.progressNeeds(MyDoggy.getShaggyness()));
		
		// set images		
		imgUpgrade1.setImage(imageLoader.loadImage(folderIcons+upgradeImg[0]));
		imgUpgrade2.setImage(imageLoader.loadImage(folderIcons+upgradeImg[1]));	
		imgUpgrade3.setImage(imageLoader.loadImage(folderIcons+upgradeImg[2]));
		imgUpgrade4.setImage(imageLoader.loadImage(folderIcons+upgradeImg[3]));
		imgUpgrade5.setImage(imageLoader.loadImage(folderIcons+upgradeImg[4]));
		imgUpgrade6.setImage(imageLoader.loadImage(folderIcons+upgradeImg[5]));
		imgUpgrade7.setImage(imageLoader.loadImage(folderIcons+upgradeImg[6]));
		imgUpgrade8.setImage(imageLoader.loadImage(folderIcons+upgradeImg[7]));
		imgUpgrade9.setImage(imageLoader.loadImage(folderIcons+upgradeImg[8]));
		imgUpgrade10.setImage(imageLoader.loadImage(folderIcons+upgradeImg[9]));
		
		btnImgUpgrade1.setTooltip(new Tooltip("Upgrade: "+ upgrades[0]));
		btnImgUpgrade2.setTooltip(new Tooltip("Upgrade: "+ upgrades[1]));
		btnImgUpgrade3.setTooltip(new Tooltip("Upgrade: "+ upgrades[2]));
		btnImgUpgrade4.setTooltip(new Tooltip("Upgrade: "+ upgrades[3]));
		btnImgUpgrade5.setTooltip(new Tooltip("Upgrade: "+ upgrades[4]));
		btnImgUpgrade6.setTooltip(new Tooltip("Upgrade: "+ upgrades[5]));
		btnImgUpgrade7.setTooltip(new Tooltip("Upgrade: "+ upgrades[6]));
		btnImgUpgrade8.setTooltip(new Tooltip("Upgrade: "+ upgrades[7]));
		btnImgUpgrade9.setTooltip(new Tooltip("Upgrade: "+ upgrades[8]));
		btnImgUpgrade10.setTooltip(new Tooltip("Upgrade: "+ upgrades[9]));
		
		// check if friend upgrade is unlocked
		if (UpgradeCheck.upgradeCheck(1)== true){
			btnFriend.setDisable(false);
		}
		
		MyDoggy.setDoggyBMI();
		achievementCheck();
		changeOpacity();
	}
	
	// close achievement/ upgrade/option menu
	private void closeMenu() {
		menuView.setVisible(false);
		gameView.setVisible(true);
		imgBg2.setVisible(true);
		btnUpgrade.setUnderline(false);
		btnAchievement.setUnderline(false);
		btnOption.setUnderline(false);
		hBox.setVisible(true);
		changeOpacity();	
	}
	
	// set menu achievement/ upgrade/option
	private void showMenu (Button button) {
		menu.getItems().clear();
		lblMenuChoice.setText("Make your choice");
		imgMenu.setImage(imageLoader.loadImage(folderIcons+ "pawprint(3)"));
		imgBg2.setVisible(false);
		lblMenuCost.setVisible(false);
		lblMenuCost.setText("");
		btnMenuChoice.setVisible(true);
		menuInformation.setText("");
		btnMenuChoice.setDisable(false);	
		menuView.setVisible(true);
		hBox.setVisible(false);
		gameView.setVisible(false);
		imgMenu.setOpacity(1);
		
		if (button == btnUpgrade) {
			lblMenuCost.setVisible(true);
			menu.getItems().addAll(upgrades);
			btnUpgrade.setUnderline(true);
			
		}else if (button == btnAchievement) {
			btnAchievement.setUnderline(true);
			btnMenuChoice.setVisible(false);
			menu.getItems().addAll(achievements);
			
		}else if (button == btnOption) {	
			btnOption.setUnderline(true);
			menu.getItems().addAll(options);
		}
		
		menu.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {			
				lblMenuChoice.setText(menu.getSelectionModel().getSelectedItem());
				
				if (button == btnAchievement) {
					btnAchievement.setUnderline(true);
					btnOption.setUnderline(false);
					btnUpgrade.setUnderline(false);
					for(int i = 0; i<ACHIEVMENTNR; i++) {
						if (lblMenuChoice.getText() == achievements[i] ){
							imgMenu.setImage(imageLoader.loadImage(folderIcons+achievementsImg[i]));
							imgMenu.setOpacity(0.2);
							menuInformation.setText(achievementsTxt[i]);
							if (achievementsStatus[i].equals("true")) {
								imgMenu.setOpacity(1);
							}
						}						
					}
				}
				else if (button == btnUpgrade) {
					btnUpgrade.setUnderline(true);
					btnOption.setUnderline(false);
					btnAchievement.setUnderline(false);
					for(int i = 0; i<UPGRADENR; i++) {
						
						if (lblMenuChoice.getText() == upgrades[i] ){
							
							if (upgradeCost[i]> MyDoggy.getLovePoints()|| menu.getItems().get(i).endsWith(" - Bought")) {
								btnMenuChoice.setDisable(true);
							}
							else
								btnMenuChoice.setDisable(false);
							
							if (achievementsStatus [i] == "true")
								imgMenu.setOpacity(1);
							
							imgMenu.setImage(imageLoader.loadImage(folderIcons+upgradeImg[i]));
							menuInformation.setText(upgradeTxt[i]);
							lblMenuCost.setText("Cost: "+ upgradeCost[i]);	;
							int pos = i;
							btnMenuChoice.setOnAction(event -> buyItem(pos));	
						}									
					}	
				}
				else if (button == btnOption) {
					btnOption.setUnderline(true);
					btnAchievement.setUnderline(false);
					btnUpgrade.setUnderline(false);
					btnMenuChoice.setOnAction(null);
					for(int i = 0; i< OPTIONNR; i++) {
						if (lblMenuChoice.getText() == options[i] ){
							imgMenu.setImage(imageLoader.loadImage(folderIcons+optionsImg[i]));
							menuInformation.setText(optionsTxt[i]);
							
							if (i== 0) {
								btnMenuChoice.setOnAction(event -> Data.safeData());
							}
							else if (i== 1) {
								btnMenuChoice.setOnAction(event -> Data.loadData());
							}
							else {
								btnMenuChoice.setOnAction(event -> Data.newDoggy());
							}
						}										
					}
				}	
				achievementCheck();
			}		
		});	
	}
	
	// check if achievements have been achieved
	private void achievementCheck() {
		int check = Achievements.achievementCheck();
		if(check>-1) {
			count = 0;
			achievements[check]+= " - Achieved";
			timer = new Timeline(new KeyFrame(Duration.millis(500), event ->{
				count++;
				hAchievement.setVisible(true);
				imgAchievement.setImage(imageLoader.loadImage(folderIcons + achievementsImg[check]));
				lblAchievement.setText(achievements[check]);
				if (count == 10)
					hAchievement.setVisible(false);	 
			}));
			timer.setCycleCount(10);
			timer.play();
		}
	}
	
	// change the properties after purchasing an upgrade
	private void buyItem(int index) {
		
		String s = lblMenuCost.getText();
		int cost = Integer.parseInt((String) s.subSequence(6, s.length()));
		MyDoggy.setLovePoints(MyDoggy.getLovePoints()-cost);
		upgrades[index] += " - Bought";
		upgradeStatus[index] = "true";
		btnMenuChoice.setOnMouseClicked(event ->menu.getItems().set(index, upgrades[index]));
		
		updateStats();
	}
	
	// set image opacity (for upgrade items)
	private void changeOpacity() {
		imgUpgrade1.setOpacity(Actions.changeOpacity(upgrades, 0));
		imgUpgrade2.setOpacity(Actions.changeOpacity(upgrades, 1));
		imgUpgrade3.setOpacity(Actions.changeOpacity(upgrades, 2));
		imgUpgrade4.setOpacity(Actions.changeOpacity(upgrades, 3));
		imgUpgrade5.setOpacity(Actions.changeOpacity(upgrades, 4));
		imgUpgrade6.setOpacity(Actions.changeOpacity(upgrades, 5));
		imgUpgrade7.setOpacity(Actions.changeOpacity(upgrades, 6));
		imgUpgrade8.setOpacity(Actions.changeOpacity(upgrades, 7));
		imgUpgrade9.setOpacity(Actions.changeOpacity(upgrades, 8));
		imgUpgrade10.setOpacity(Actions.changeOpacity(upgrades, 9));
	}

	private void hasShadow (Boolean hasShadow , Button button) {
		
		if (hasShadow == true) {
			button.setEffect(shadow);
		}
		else {
			button.setEffect(null);
		}
		
	}
	public static int getUpgradeNr() {
		return UPGRADENR;
	}

	public static int getAchievementNr() {
		return ACHIEVMENTNR;
	}

	public static String[] getUpgrades() {
		return upgrades;
	}

	public static void setUpgrades(String[] upgrades) {
		FXMLController.upgrades = upgrades;
	}

	public static String[] getUpgradeImg() {
		return upgradeImg;
	}

	public static void setUpgradeImg(String[] upgradeImg) {
		FXMLController.upgradeImg = upgradeImg;
	}

	public static String[] getUpgradeTxt() {
		return upgradeTxt;
	}

	public static void setUpgradeTxt(String[] upgradeTxt) {
		FXMLController.upgradeTxt = upgradeTxt;
	}

	public static String[] getAchievementsImg() {
		return achievementsImg;
	}

	public static void setAchievementsImg(String[] achievementsImg) {
		FXMLController.achievementsImg = achievementsImg;
	}

	public static String[] getAchievementsTxt() {
		return achievementsTxt;
	}

	public static void setAchievementsTxt(String[] achievementsTxt) {
		FXMLController.achievementsTxt = achievementsTxt;
	}

	public static String[] getAchievements() {
		return achievements;
	}

	public static void setAchievements(String[] achievements) {
		FXMLController.achievements = achievements;
	}

	public static int[] getUpgradeCost() {
		return upgradeCost;
	}

	public static void setUpgradeCost(int[] upgradeCost) {
		FXMLController.upgradeCost = upgradeCost;
	}

	public static String[] getUpgradeStatus() {
		return upgradeStatus;
	}

	public static void setUpgradeStatus(String[] upgradeStatus) {
		FXMLController.upgradeStatus = upgradeStatus;
	}
	
	public static String[] getAchievementsStatus() {
		return achievementsStatus;
	}

	public static void setAchievementsStatus(String[] achievementsStatus) {
		FXMLController.achievementsStatus = achievementsStatus;
	}

	public static ImageView getImgMyDoggyStatic() {
		return imgMyDoggyStatic;
	}

	public static void setImgMyDoggyStatic(String imgMyDoggyStatic) {
		
		FXMLController.imgMyDoggyStatic.setImage(imageLoader.loadImage(folderDogs +  imgMyDoggyStatic));
	}

	public static ImageView getImgFriendStatic() {
		return imgFriendStatic;
	}

	public static void setImgFriendStatic(String imgFriendStatic) {
		if (imgFriendStatic == null)
			FXMLController.imgFriendStatic.setImage(null);
		else
			FXMLController.imgFriendStatic.setImage(imageLoader.loadImage(folderDogs +  imgFriendStatic));
	}
	
}
