/* Hayden Weaver - 7/19/2023
 * Dice Game
 * Dice Game is a game that gets a desired number of 
 * rolls from the user, and adds up the totals from
 * each roll. The player with the highest number at
 * the end of the round wins.
 */

package Games;
import java.util.Scanner;  
import java.util.ArrayList;

public class Dice_Game {

	public String Play(int players) {
		
		//Declaring Variables
		int i=0;
		int rolls = 0;
		int high_score = 0;
		int score = 0;
		int leader = 0;
		String correct_name = " ";
		String name = " ";
		
		//Roll_Dice object
		Roll_Dice roll = new Roll_Dice();
		
		//Dynamic Array for names of players
		ArrayList<String> names = new ArrayList<>();
		
		//Declaring scanner object
		Scanner scn = new Scanner(System.in);
		
		
		//Beginning of the program
		System.out.println("Welcome to the dice game!");
		
		System.out.println("How many dice would everyone like to roll?");
		
		//Collect number of rolls
		rolls = scn.nextInt();
		
		//Consumes the /n
		scn.nextLine();
		
		//Loop for getting name and rolling dice for each player
		for(i=0;i<players;i++) {
			
			//Collect player i's name
			do {
				
				System.out.println("Welcome Player "+(i+1)+". It's almost your turn to roll, but first we need some information");
				
				System.out.println("What is your name?");
			
				//Stores name given by user into dynamic array
				name = scn.nextLine();
				
				System.out.println("Player "+(i+1)+"'s name is " + name + ". Is this your correct name? (y or n)");
				correct_name = scn.nextLine();
				
				
			}while(!correct_name.equals("y"));
			
			names.add(name);
			
			//Roll dice for player and collect score
			score = roll.Roll(rolls);
			
			System.out.println("Player "+(i+1)+" your score was "+score);
			
			if(score > high_score)
			{
				System.out.println("That's the knew high score!");
				high_score = score;
				leader = i;
			}
			
		}
		
		
		
		System.out.println("Player "+(leader + 1)+" is the winner with a score of "+high_score);
		
		return names.get(leader);
	}	
}
