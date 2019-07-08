// Same as GK class but specific for ST (Striker) position
public class ST extends Player {

	int dribbling;
	int passing;
	int finishing; 
	int heading;
	
	public ST(String stName, int stAge, int stOverall, int stSpeed, int stStrength, int stStamina, 
			int stDribbling, int stPassing, int stFinishing, int stHeading) {
		
		super(stName, stAge, stOverall, stSpeed, stStrength, stStamina);
		stDribbling = dribbling;
		stPassing = passing;
		stFinishing = finishing;
		stHeading = heading;
		
	}

}
