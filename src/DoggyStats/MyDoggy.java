package DoggyStats;

public class MyDoggy {
	
	final static int STATMAX= 100;
	final static int STATMIN = 0;
	final static double BMIMAX = 40.0;

	private static String doggyName = "Clara";
	private static double doggyWeight = 7.0;
	private static double doggyAge = 1.0;
	private static int happiness = 0;
	private static int tiredness = 0;

	private static int illnes = 0;
	private static int peePee = 0;
	private static int hunger = 0;
	private static double doggyLenght = 0.6;
	private static int lovePoints = 0;
	private static int shaggyness = 0;
	
	private static int countFriend= 0;
	private static int countPlay= 0;
	private static int countFeed= 0;
	private static int countVet= 0;

	private static DoggyBMI doggyBMI = DoggyBMI.NORMAL;
	
	public MyDoggy() {
		setMaxMin(happiness);
	}

	public static void setDoggyStats (double age, double weight, int happy, int tired,  int pee,int hungry, int ill) {
		
		doggyAge = age;
		doggyWeight = weight;
		happiness = setMaxMin(happy);
		tiredness = setMaxMin(tired);
		illnes = setMaxMin(ill);
		peePee = setMaxMin(pee);
		hunger = setMaxMin(hungry);
		
		if (happiness == 100) {
			setHappiness(0);
			lovePoints++;	
		}
		if (tiredness > 70 || illnes > 70 || peePee > 70 || hunger > 70 || shaggyness > 70) {
			happiness-= 5;
		}
		
		if (getBMI()>25 || getBMI()<18 || illnes > 50) {		
			happiness-=10;
		}
		
		happiness= setMaxMin(happiness);
	}
	
	public static void setDoggyBMI() {
		if (getBMI() > 25)
			doggyBMI = DoggyBMI.FAT;
		else if (getBMI() < 18)
			doggyBMI = DoggyBMI.SLIM;
		else
			doggyBMI = DoggyBMI.NORMAL;
	}
	
	private static int setMaxMin(int parameter) {
		if (parameter<=STATMIN) {
			return STATMIN;
		}
		else if (parameter >= STATMAX)
			return STATMAX;
		return parameter;
	}

	public static String getDoggyName() {
		return doggyName;
	}

	public static void setDoggyName(String doggyName) {
		MyDoggy.doggyName = doggyName;
	}

	public static double getDoggyWeight() {
		return doggyWeight;
	}

	public static void setDoggyWeight(double doggyWeight) {
		MyDoggy.doggyWeight = doggyWeight;
	}

	public static double getDoggyAge() {
		return doggyAge;
	}

	public static void setDoggyAge(double d) {
		MyDoggy.doggyAge = d;
	}

	public static int getTiredness() {
		return tiredness;
	}

	public static void setTiredness(int tiredness) {
		MyDoggy.tiredness = setMaxMin(tiredness);
	}

	public static int getIllnes() {
		return illnes;
	}

	public static void setIllnes(int illnes) {
		MyDoggy.illnes = setMaxMin(illnes);
	}

	public static int getLovePoints() {
		return lovePoints;
	}

	public static void setLovePoints(int lovePoints) {
		MyDoggy.lovePoints = setMaxMin(lovePoints);
	}
	
	public static double getBmimax() {
		return BMIMAX;
	}
	public static int getCountFriend() {
		return countFriend;
	}

	public static void setCountFriend(int countFriend) {
		MyDoggy.countFriend = countFriend;
	}

	public static int getCountPlay() {
		return countPlay;
	}

	public static void setCountPlay(int countPlay) {
		MyDoggy.countPlay = countPlay;
	}

	public static int getCountFeed() {
		return countFeed;
	}

	public static void setCountFeed(int countFeed) {
		MyDoggy.countFeed = countFeed;
	}

	public static int getCountVet() {
		return countVet;
	}

	public static void setCountVet(int countVet) {
		MyDoggy.countVet = countVet;
	}
	
	public static int getHappiness() {
		return happiness;
	}

	public static void setHappiness(int happiness) {
		MyDoggy.happiness = happiness;
	}

	public static int getPeePee() {
		return peePee;
	}

	public static void setPeePee(int peePee) {
		MyDoggy.peePee = peePee;
	}

	public static int getHunger() {
		return hunger;
	}

	public static void setHunger(int hunger) {
		MyDoggy.hunger = hunger;
	}

	public static int getShaggyness() {
		return shaggyness;
	}

	public static void setShaggyness(int shaggyness) {
		MyDoggy.shaggyness = shaggyness;
	}
	
	public static double getBMI() {	
		return doggyWeight/(doggyLenght*doggyLenght);
	}
	
	public static DoggyBMI getDoggyBMI() {
		return doggyBMI;
	}

}
