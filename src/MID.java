// Same as GK class but specific for MID (Midfielder) position
public class MID extends Player {
	
	int dribbling;
	int passing;
	int finishing; 
	int tackling;
	

	public MID(String midName, int midAge, int midOverall, int midSpeed, int midStrength, int midStamina, 
			int midDribbling, int midPassing, int midFinishing, int midTackling) {
		
		super(midName, midAge, midOverall, midSpeed, midStrength, midStamina);
		midDribbling = dribbling;
		midPassing = passing;
		midFinishing = finishing;
		midTackling = tackling;
	}

}
