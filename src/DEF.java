// Same as GK class but specific for DEF (Defender) position
public class DEF extends Player {
		
	int heading;
	int marking; 
	int tackling; 
	int passing;
		
		
	public DEF(String defName, int defAge, int defOverall, int defSpeed, int defStrength, 
			int defStamina, int defHeading, int defMarking, int defTackling, int defPassing) {
			
		super(defName, defAge, defOverall, defSpeed, defStrength, defStamina);
		defHeading = heading;
		defMarking = marking;
		defTackling = tackling;
		defPassing = passing;
			
			
	}
}
