
// import java packages for exception handling and logging
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class Match {

	// Create array to store the score of the Match
	int[] score = new int[] {0, 0};
	
	// On average each soccer game has 100 'duels', using duels variable as a counter to have 100 duels each game
	int duels = 100;
	
	// Declare skill variables for each position to store total skill of players in this position for team1
	int team1GkSkill = 0;
	int team1DefSkill = 0;
	int team1MidSkill = 0;
	int team1OffSkill = 0;
	// team1 starts with possession from kickoff in midfield
	boolean team1Possession = true;
	
	// Same for team2
	int team2GkSkill = 0;
	int team2DefSkill = 0;
	int team2MidSkill = 0;
	int team2OffSkill = 0;
	boolean team2Possession = false;
	
	// Create an instance of Logger object called logger
	Logger logger = Logger.getLogger("MyLog");
	FileHandler fh;
	
	int t1PossessionStat = 0;
	int t2PossessionStat = 0;

	int t1ShotStat = 0;
	int t2ShotStat = 0;
	
	// Match method that takes two arrays of Players
	public Match(Player team1[], Player team2[]) {

		// Calculate totals of player overalls for each position on team1: GK, DEF, MID, ST and add to relevent variables declared above
		for (Player p : team1) {
			if (p instanceof GK) {
				team1GkSkill += p.overall;
			}
			if (p instanceof DEF) {
				team1DefSkill += p.overall;
			}
			if (p instanceof MID) {
				team1MidSkill += p.overall;
			}
			if (p instanceof ST) {
				team1OffSkill += p.overall;
			}
		}

		// Calculate totals of player overalls for each position on team2: GK, DEF, MID, ST and add to relevent variables declared above
		for (Player p : team2) {
			if (p instanceof GK) {
				team2GkSkill += p.overall;
			}
			if (p instanceof DEF) {
				team2DefSkill += p.overall;
			}
			if (p instanceof MID) {
				team2MidSkill += p.overall;
			}
			if (p instanceof ST) {
				team2OffSkill += p.overall;
			}
		}
		
		
		//Exception handler for logger
	    try {  

	        // This block configures the logger with handler and formatter  
	        fh = new FileHandler("C:/temp/test/FM_Match.log");  
	        logger.addHandler(fh);
	        SimpleFormatter formatter = new SimpleFormatter();  
	        fh.setFormatter(formatter);   

	    } catch (SecurityException e) {  
	        e.printStackTrace();  
	    } catch (IOException e) {  
	        e.printStackTrace();  
	    }  
	    
	    logger.setUseParentHandlers(false);
		
	    // Create an instance of the Pitch Object called oldTrafford
	    Pitch oldTrafford = new Pitch();
	    
	    // While loop to control the length of the match limiting to 100 'duels'
		while (duels >= 0) {
			
			// While team1 has the possession continue
			while (team1Possession == true){
				
				// Everytime the while loop is entered, get the current ball position 
				String ballPosition = oldTrafford.getBallPosition();
				
				/* If statement activated depending on ball position above, passes two skills depending on 
				 * positions to the randomGenerator and creates a local int array called teams to capture the result. 
				 * After result is captured it passes this teams array to the Duel method to see which team has won this duel. 
				*/
				if (ballPosition == "DEF") {
					int[] teams = randomGenerator(team1DefSkill, team2DefSkill);
					Duel(teams);
					// if/else statement analyzes the outcome of Duel to see who has possession
					if (team1Possession == true) {	
						// if team1 keeps possession they move into the next pitch position
						oldTrafford.setBallPosition("MID");
						// Result written to FM_Match.log
						logger.info("ManUTD still has possession and moved into MID");
						// duels counter reduced by 1
						duels--;
					}else {
						// team2 has won possession and have moved into the ATT pitch position 
						oldTrafford.setBallPosition("ATT");
						// Result written to FM_Match.log
						logger.info("Chelsea wins back possession in ATT");
						// duels counter reduced by 1
						duels--;
					}
					
				}
				
				// The above is repeated for each pitch position when team1 has possession 
				if (ballPosition == "MID") {
					int[] teams = randomGenerator(team1MidSkill, team2MidSkill);
					Duel(teams);
					if (team1Possession == true) {						
						oldTrafford.setBallPosition("ATT");
						logger.info("ManUTD still has possession and moved into ATT");
						duels--;
					}else {
						oldTrafford.setBallPosition("MID");
						logger.info("Chelsea wins back possession in MID");
						duels--;
					}
				}
				
				if (ballPosition == "ATT") {
					int[] teams = randomGenerator(team1OffSkill, team2DefSkill);
					Duel(teams);
					if (team1Possession == true) {						
						oldTrafford.setBallPosition("GOAL CHANCE");
						logger.info("ManUTD still has possession and moved through on GOAL!!");
						duels--;
					}else {
						oldTrafford.setBallPosition("DEF");
						logger.info("Chelsea wins back possession in DEF");
						duels--;
					}
				}
				
				if (ballPosition == "GOAL CHANCE") {
					int[] teams = randomGenerator(team1OffSkill, team2DefSkill);
					Duel(teams);
					t1ShotStat++;
					if (team1Possession == true) {						
						oldTrafford.setBallPosition("MID");
						logger.info("ManUTD still has possession and has scored a GOAL!!!");
						score[0] += 1;
						team1Possession = false;
						team2Possession = true;
						logger.info("Chelsea restart from Kick-Off");
						duels--;
					}else {
						oldTrafford.setBallPosition("DEF");
						logger.info("Chelsea GK saves the shot!!");
						logger.info("Chelsea GK passes the ball to his DEF");
						duels--;
					}
				}
			}

			// Same as above for when team2 has possession 
			while (team2Possession == true){
				
				String ballPosition = oldTrafford.getBallPosition();
				
				if (ballPosition == "DEF") {
					int[] teams = randomGenerator(team1OffSkill, team2DefSkill);
					Duel(teams);
					if (team2Possession == true) {						
						oldTrafford.setBallPosition("MID");
						logger.info("Chelsea still has possession and moved into MID");
						duels--;
					}else {
						oldTrafford.setBallPosition("ATT");
						logger.info("ManUTD wins back possession in ATT");
						duels--;
					}
					
				}
				
				if (ballPosition == "MID") {
					int[] teams = randomGenerator(team1MidSkill, team2MidSkill);
					Duel(teams);
					if (team2Possession == true) {						
						oldTrafford.setBallPosition("ATT");
						logger.info("Chelsea still has possession and moved into ATT");
						duels--;
					}else {
						oldTrafford.setBallPosition("MID");
						logger.info("ManUTD wins back possession in MID");
						duels--;
					}
				}
				
				if (ballPosition == "ATT") {
					int[] teams = randomGenerator(team1DefSkill, team2OffSkill);
					Duel(teams);
					if (team2Possession == true) {						
						oldTrafford.setBallPosition("GOAL CHANCE");
						logger.info("Chelsea still has possession and moved through on GOAL!!");
						duels--;
					}else {
						oldTrafford.setBallPosition("DEF");
						logger.info("ManUTD wins back possession in DEF");
						duels--;
					}
				}
				
				if (ballPosition == "GOAL CHANCE") {
					int[] teams = randomGenerator(team1GkSkill, team2OffSkill);
					Duel(teams);
					t2ShotStat++;
					if (team2Possession == true) {						
						oldTrafford.setBallPosition("MID");
						logger.info("Chelsea still has possession and have scored a GOAL!!!");
						score[1] += 1;
						team2Possession = false;
						team1Possession = true;
						logger.info("ManUTD restart from Kick-Off");
						duels--;
					}else {
						oldTrafford.setBallPosition("DEF");
						logger.info("ManUTD GK saves the shot!!");
						logger.info("ManUTD GK passes the ball to his DEF");
						duels--;
					}
				}
			}

			
		}
		
		
		// Print the team skill overalls for each position on team1 and team2
		//System.out.println("ManUTD Team: GK = " + team1GkSkill + " DEF = " + team1DefSkill + " MID = " + team1MidSkill + " ATT " + team1OffSkill);
		//System.out.println("Chelsea Team: GK = " + team2GkSkill + " DEF = " + team2DefSkill + " MID = " + team2MidSkill + " ATT " + team2OffSkill);
		
		
		//System.out.println(t1PossessionStat);
		//System.out.println(t2PossessionStat);
		float[] totalPossession = possession(t1PossessionStat, t2PossessionStat);
		
		System.out.println("\nPossession Stats \nManUTD " + Math.round(totalPossession[0]) + "\t" + Math.round(totalPossession[1]) + " Chelsea");
		System.out.println("\nShot Stats \nManUTD " + t1ShotStat + "\t" + t2ShotStat + " Chelsea");
		
		// Print the final score of Match
		System.out.println("\nFINAL SCORE\nManUTD " + score[0] + "\t" + score[1] + " Chelsea");
		
	}
	
	
	// randomGenerator method that takes two int values and returns an array of int values
	public int[] randomGenerator(int team1skill, int team2skill) {
		// Create a new int array to store values
		int randomNums[] = new int[2];
		/* Declare two int values and get random int between 1 and the skill value that was passed into method
		 * This ensures that if a team has a higher skill level in one position to another team they will have a higher probability of getting a higher number
		 * Example: 
		 * Team1 Defense has a total overall of 60
		 * Team2 Attack has a total overall of 90 
		 * Team2 has a higher probability of getting a higher number than team1
		 * This ensures that teams that have better skills than others have a better chance of winning 
		 * but can also lose in some cases as in the real world
		 */
		int rand1 = (int)(Math.random() * team1skill + 1);
		int rand2 = (int)(Math.random() * team2skill + 1);
		
		// Populate the randomNums array with the random numbers generated above
		randomNums[0] = rand1;
		randomNums[1] = rand2;
		
		// Write results of each duel to the FM_Match.log
		logger.info("ManUtd Skill in Duel: " + rand1);
		logger.info("Chelsea Skill in Duel: " + rand2);
		
		// Return array of 2 random numbers
		return randomNums;
	}// end of randomGenerator method
	
	
	// Duel method that does not return any value and gets passed an array of int values
	public void Duel(int dTeams[]) {
		// If team1 has a higher value than team2, team1 wins possession
		if (dTeams[0] > dTeams[1]) {
			team1Possession = true;
			team2Possession = false;
			t1PossessionStat++;
		}
		// If team2 has a higher value than team1, team2 wins possession
		else {
			team2Possession = true;
			team1Possession = false;
			t2PossessionStat++;
		}
	}// end of Duel method
	
	public float[] possession (int t1Pos, int t2Pos) {

		float[] matchPossession = new float[2];
		
		double total = t1Pos + t2Pos;
		float t1Total = (float)((t1Pos*100)/total);
		float t2Total = (float)((t2Pos*100)/total);
		
		matchPossession[0] = t1Total;
		matchPossession[1] = t2Total;
		
		return matchPossession;
	}
	

}// End of Match class
