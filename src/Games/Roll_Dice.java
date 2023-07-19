/* Hayden Weaver - 7/19/2023
 * Roll Dice
 * Roll Dice - not to be confused with Dice Game - is used
 * by multiple games to roll a dice a number of times.
 * Dice Game uses the Roll_Dice class to roll as many
 * dice as the user chooses, but this number could 
 * easily be hard-coded for a game that requires a set
 * amount of dice to be rolled every time.
 */

package Games;
import java.util.Random;

public class Roll_Dice {
	
	public int dice_number;

	int Roll(int rolls) {
		int score = 0;
		int i = 0;
		Random rand = new Random();
		int upperbound = 6;
		int current_roll = 0;
		
		for(i=0;i<rolls;i++) {
			
			current_roll = (rand.nextInt(upperbound) + 1);
			score = score + current_roll;
		}
		
		return score;
	}
	
}
