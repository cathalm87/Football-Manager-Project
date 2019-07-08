// GK (Goalkeeper) position that extends the Player superclass
// and inherits the Player attributes/variables. i.e. a GK has specific attributes 
//for their position but also must have the basic physical attributes that a Player has
public class GK extends Player{
	
	// Declare variables that are specific to position
	int handling;
	int oneOnOnes;
	int reflexes;
	int kickouts;

	// Overloaded constructor 
	public GK(String gkName, int gkAge, int gkOverall, int gkSpeed, int gkStrength, 
			int gkStamina, int gkHandling, int gkOneOnOnes, int gkReflexes, int gkKickouts) {
		
		super(gkName, gkAge, gkOverall, gkSpeed, gkStrength, gkStamina);
		gkHandling = handling;
		gkOneOnOnes = oneOnOnes;
		gkReflexes = reflexes;
		gkKickouts = kickouts;
	}
	
	

}
