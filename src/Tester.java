
// Tester class that contains main method
public class Tester {
	

	// Main Method
	public static void main(String[] args) {
		
		// Create a Player array of size 11 i.e. a starting lineup for team
		Player manUtd[] = new Player[11];
		
		// Create new players and populate variables depending on positions
		GK player1 = new GK("David De Gea", 28, 78, 13, 14, 12, 18, 16, 20, 16);
		DEF player2 = new DEF("Aaron Wan Bissaka", 21, 52, 15, 12, 12, 8, 12, 16, 10);
		DEF player3 = new DEF("Victor Lindelof", 24, 69, 15, 13, 15, 11, 15, 14, 14);
		DEF player4 = new DEF("Chris Smalling", 29, 74, 15, 17, 16, 17, 15, 16, 7);
		DEF player5 = new DEF("Luke Shaw", 23, 71, 16, 15, 15, 12, 14, 14, 13);
		MID player6 = new MID("Paul Pogba", 26, 79, 16, 17, 17, 17, 18, 14, 12);
		MID player7 = new MID("Scott McTominay", 22, 58, 13, 14, 18, 7, 13, 8, 14);
		MID player8 = new MID("Anthony Martial", 23, 66, 17, 12, 14, 19, 13, 15, 3);
		MID player9 = new MID("Jesse Lingard", 26, 63, 15, 9, 17, 14, 13, 14, 6);
		ST player10 = new ST("Marcus Rashford", 21, 66, 17, 11, 14, 16, 12, 14, 8);
		ST player11 = new ST("Romelu Lukaku", 26, 74, 17, 19, 13, 12, 11, 15, 17);
		
		// add players to manUtd array
		manUtd[0] = player1;
		manUtd[1] = player2;
		manUtd[2] = player3;
		manUtd[3] = player4;
		manUtd[4] = player5;
		manUtd[5] = player6;
		manUtd[6] = player7;
		manUtd[7] = player8;
		manUtd[8] = player9;
		manUtd[9] = player10;
		manUtd[10] = player11;
		
		// Do the same for a second team (chelsea) 
		Player chelsea[] = new Player[11];
		
		// Notice the variables are the same for testing purposes, only names are different
		GK chelsea1 = new GK("Kepa", 28, 78, 13, 14, 12, 18, 16, 20, 16);
		DEF chelsea2 = new DEF("Azpilicueta", 21, 52, 15, 12, 12, 8, 12, 16, 10);
		DEF chelsea3 = new DEF("Rudiger", 24, 69, 15, 13, 15, 11, 15, 14, 14);
		DEF chelsea4 = new DEF("Luiz", 29, 74, 15, 17, 16, 17, 15, 16, 7);
		DEF chelsea5 = new DEF("Emerson", 23, 71, 16, 15, 15, 12, 14, 14, 13);
		MID chelsea6 = new MID("Jorginho", 26, 79, 16, 17, 17, 17, 18, 14, 12);
		MID chelsea7 = new MID("Kante", 22, 58, 13, 14, 18, 7, 13, 8, 14);
		MID chelsea8 = new MID("Hazard", 23, 66, 17, 12, 14, 19, 13, 15, 3);
		MID chelsea9 = new MID("Pulisic", 26, 63, 15, 9, 17, 14, 13, 14, 6);
		ST chelsea10 = new ST("Higuain", 21, 66, 17, 11, 14, 16, 12, 14, 8);
		ST chelsea11 = new ST("Giroud", 26, 74, 17, 19, 13, 12, 11, 15, 17);
		
		chelsea[0] = chelsea1;
		chelsea[1] = chelsea2;
		chelsea[2] = chelsea3;
		chelsea[3] = chelsea4;
		chelsea[4] = chelsea5;
		chelsea[5] = chelsea6;
		chelsea[6] = chelsea7;
		chelsea[7] = chelsea8;
		chelsea[8] = chelsea9;
		chelsea[9] = chelsea10;
		chelsea[10] = chelsea11;
		
		
		// Create a new Match object called match1 and pass two teams (arrays) to instance of Match class
		Match match1 = new Match(manUtd, chelsea);


	}// End of Main Method
}
