
// Public class Player that is the super class
public class Player {

	// declare variables for Players that are not specific to positions
	String name;
	int age = 0;
	int overall = 0;
	int speed = 0;
	int strength = 0;
	int stamina = 0;
	
	// Overloaded constructor to allow fast population of variables when creating a new player
	public Player(String pName, int pAge, int pOverall, int pSpeed, int pStrength, int pStamina) {
		name = pName;
		age = pAge;
		overall = pOverall;
		speed = pSpeed;
		strength = pStrength;
		stamina = pStamina;
	}

	// Getters and setters not yet used
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public int getOverall() {
		return overall;
	}


	public void setOverall(int overall) {
		this.overall = overall;
	}


	public int getSpeed() {
		return speed;
	}


	public void setSpeed(int speed) {
		this.speed = speed;
	}


	public int getStrength() {
		return strength;
	}


	public void setStrength(int strength) {
		this.strength = strength;
	}


	public int getStamina() {
		return stamina;
	}


	public void setStamina(int stamina) {
		this.stamina = stamina;
	}
	

}
