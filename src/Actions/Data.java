package Actions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

import javax.swing.JOptionPane;

import DoggyStats.MyDoggy;
import MyDoggyFX.FXMLController;
import javafx.stage.FileChooser;

public class Data {

	File folder = new File("save");
	static File file=new File("save/"+MyDoggy.getDoggyName()+"save.txt");
	StringBuilder stringB = new StringBuilder();
	
	public static void safeData() {
		Data data = new Data();
		// new folder
		if(!data.folder.exists()) {
			data.folder.mkdirs();
		}
		// new file
		if (!Data.file.exists()) {
			try {
				Data.file.createNewFile();
			}catch(IOException e) {
				e.printStackTrace();
			}	
		}
		else {
			for (int i = 1; i<=10;i++) {
				file = new File("save/"+MyDoggy.getDoggyName()+i+"save.txt");
				if(!Data.file.exists()) {
					try {
						Data.file.createNewFile();
						break;
					}catch(IOException e) {
						e.printStackTrace();
					}
				}else if(Data.file.exists() && i==10) {
					System.out.println("Too many save-games.");
				}
			}	
		}
		// stats
		data.stringB.append(MyDoggy.getDoggyName()+"\n");
		data.stringB.append(MyDoggy.getDoggyAge()+"\n");
		data.stringB.append(MyDoggy.getDoggyWeight()+"\n");
		data.stringB.append(MyDoggy.getHappiness()+"\n");
		data.stringB.append(MyDoggy.getLovePoints()+"\n");
		data.stringB.append(MyDoggy.getHunger()+"\n");
		data.stringB.append(MyDoggy.getIllnes()+"\n");
		data.stringB.append(MyDoggy.getPeePee()+"\n");
		data.stringB.append(MyDoggy.getTiredness()+"\n");
		data.stringB.append(MyDoggy.getCountFeed()+"\n");
		data.stringB.append(MyDoggy.getCountFriend()+"\n");
		data.stringB.append(MyDoggy.getCountPlay()+"\n");
		data.stringB.append(MyDoggy.getCountVet()+"\n");
		
		// upgrade status
		for (String s : FXMLController.getUpgradeStatus())
			data.stringB.append(s +"\n");
		
		// achievement status
		for(String s : FXMLController.getAchievementsStatus()) 
			data.stringB.append(s +"\n");			
		
		try {
			OutputStream stream = new FileOutputStream(Data.file);
			String s = data.stringB.toString();
			stream.write(s.getBytes());
			stream.close();
			
			System.out.println("Data saved.");
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

	public static boolean savegameCheck() {
		Data data = new Data();
		
		if(data.folder.exists() && data.folder.list().length >0) {
			
			if (JOptionPane.showConfirmDialog(null, "There are saved games. Do you like to load a game?", "Load a save-game?", 
					JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {
				loadData();
				return true;
			}
			else
				return false;
		}
		return false;
		
	}
	
	public static void loadData() {
		File tempFile;
		String [] tempStatusUpgrade = new String[FXMLController.getUpgradeNr()];
		String [] tempStatusAchievement = new String[FXMLController.getAchievementNr()];
		
		if (JOptionPane.showConfirmDialog(null, "Are you sure you want to load a game? \nUnsaved progress from the current game will be lost! ", 
				"Start a new game", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			
			FileChooser chooser = new FileChooser();
			
			// set chooser
			chooser.setTitle("Open file");
			chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter(".TXT", "*.txt"));
			chooser.setInitialDirectory(new File(System.getProperty("user.home")));

			tempFile = chooser.showOpenDialog(null);
			
			//load save-game
			if (tempFile != null && tempFile.getAbsolutePath().endsWith("save.txt") ) {
				try (Scanner scanner = new Scanner(tempFile)){
						
					// stats
					MyDoggy.setDoggyName(scanner.nextLine());
					MyDoggy.setDoggyAge(Double.parseDouble(scanner.nextLine()));
					MyDoggy.setDoggyWeight(Double.parseDouble(scanner.nextLine()));
					MyDoggy.setHappiness(Integer.parseInt(scanner.nextLine()));
					MyDoggy.setLovePoints(Integer.parseInt(scanner.nextLine()));
					MyDoggy.setHunger(Integer.parseInt(scanner.nextLine()));
					MyDoggy.setIllnes(Integer.parseInt(scanner.nextLine()));
					MyDoggy.setPeePee(Integer.parseInt(scanner.nextLine()));
					MyDoggy.setTiredness(Integer.parseInt(scanner.nextLine()));
					MyDoggy.setCountFeed(Integer.parseInt(scanner.nextLine()));
					MyDoggy.setCountFriend(Integer.parseInt(scanner.nextLine()));
					MyDoggy.setCountPlay(Integer.parseInt(scanner.nextLine()));
					MyDoggy.setCountVet(Integer.parseInt(scanner.nextLine()));
						
					// upgrade
					for(int i = 0; i<FXMLController.getUpgradeNr(); i++) {
						tempStatusUpgrade[i] = scanner.nextLine();			
					}			
					FXMLController.setUpgradeStatus(tempStatusUpgrade);
						
					// achievements
					for(int i = 0; i<FXMLController.getAchievementNr(); i++) {	
						tempStatusAchievement[i] = scanner.nextLine();			
					}			
					FXMLController.setAchievementsStatus(tempStatusAchievement);
								
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}
			}else {
				System.out.println("Error reading.");
			}
	}
	
	public static void newDoggy() {

		String [] tempStatusUpgrade = new String[FXMLController.getUpgradeNr()];
		String [] tempStatusAchievement = new String[FXMLController.getAchievementNr()];
		
		if (JOptionPane.showConfirmDialog(null, "Are you sure you want to start a new game? \nUnsaved progress from the current game will be lost! ", 
				"Start a new game", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
		
			MyDoggy.setDoggyName(JOptionPane.showInputDialog(null, "Whats your dogs name?", "Clara"));
			
			// stats
			MyDoggy.setDoggyAge(1);
			MyDoggy.setDoggyWeight(7);
			MyDoggy.setHappiness(0);
			MyDoggy.setLovePoints(0);
			MyDoggy.setHunger(0);
			MyDoggy.setIllnes(0);
			MyDoggy.setPeePee(0);
			MyDoggy.setTiredness(0);
			MyDoggy.setCountFeed(0);
			MyDoggy.setCountFriend(0);
			MyDoggy.setCountPlay(0);
			MyDoggy.setCountVet(0);
				
			// upgrade
			for(int i = 0; i<FXMLController.getUpgradeNr(); i++) {
				tempStatusUpgrade[i] = "false";			
			}			
			FXMLController.setUpgradeStatus(tempStatusUpgrade);
				
			// achievements
			for(int i = 0; i<FXMLController.getAchievementNr(); i++) {	
				tempStatusAchievement[i] = "false";			
			}			
			FXMLController.setAchievementsStatus(tempStatusAchievement);
		}
	}
	
	public static void setAchievments() {
		String [] tempName = new String [FXMLController.getAchievementNr()];
		String [] tempImg = new String [FXMLController.getAchievementNr()];
		String [] tempTxt = new String [FXMLController.getAchievementNr()];
		String [] tempStatus = new String [FXMLController.getAchievementNr()];
		
		File achievementName = new File ("data/achievements.txt");
		
		if (achievementName!=null) {
			try(Scanner scanner = new Scanner(achievementName)) {
				for (int i = 0; i<(FXMLController.getAchievements().length); i++) {
					// read lines
					tempName[i] = scanner.nextLine();
					tempImg[i] = scanner.nextLine();
					tempTxt[i] = scanner.nextLine();
					tempStatus[i] = scanner.nextLine();
				}
				
				// set achievements
				FXMLController.setAchievements(tempName);
				FXMLController.setAchievementsImg(tempImg);
				FXMLController.setAchievementsTxt(tempTxt);
				FXMLController.setAchievementsStatus(tempStatus);
				
			} catch (FileNotFoundException e) {
				System.out.println("Achievements could not be loaded.");
				e.printStackTrace();
			}
		}
	}

	public static void setUpgrades() {
		String [] tempName = new String [FXMLController.getUpgradeNr()];
		String [] tempImg = new String [FXMLController.getUpgradeNr()];
		String [] tempTxt = new String [FXMLController.getUpgradeNr()];
		int [] tempCost = new int [FXMLController.getUpgradeNr()];
		String [] tempStatus = new String [FXMLController.getUpgradeNr()];
		
		File upgradeName = new File ("data/upgrades.txt");
		if (upgradeName!=null) {
			try(Scanner scanner = new Scanner(upgradeName)) {
				for (int i = 0; i<(FXMLController.getUpgrades().length); i++) {
					// read upgrades
					tempName[i] = scanner.nextLine();
					tempImg[i] = scanner.nextLine();
					tempTxt[i] = scanner.nextLine();
					tempCost[i]= Integer.parseInt( scanner.nextLine());
					tempStatus[i] = scanner.nextLine();				
				}
				
				// set upgrades
				FXMLController.setUpgrades(tempName);
				FXMLController.setUpgradeImg(tempImg);
				FXMLController.setUpgradeTxt(tempTxt);
				FXMLController.setUpgradeCost(tempCost);
				FXMLController.setUpgradeStatus(tempStatus);
				
		} catch (FileNotFoundException e) {
				System.out.println("Upgrades could not be loaded.");
				e.printStackTrace();
			}
		}
	}

}
