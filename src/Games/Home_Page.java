/* Hayden Weaver - 7/19/2023
 * Main
 * The purpose of main is to introduce the user to the program and give them an
 * overall game menu which acts as a home page. Main will also act as an overall 
 * game wins score keeper and find an overall winner. It is easy to update
 * when games go out of order or new games become available.
 */

package Games;
import java.util.Scanner;  

public class Home_Page{
	
	public static void main(String[] args) {
		
		String play_again = "n";
		int game_number = 0;
		int game_selection = 0;
		int players = 0;
		String game_winner = "";
		
		boolean invalid_choice = false;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Welcome to the game Dashboard!");
		System.out.println("How many players will be playing today?");
		
		//Collect # of players
		players = scan.nextInt();
		
		do {
			
			if(play_again.equals("y"))
			{
				System.out.println("Let's Play another!");
				System.out.println();
			}
			
			System.out.println("Time for Game #"+(++game_number));
			System.out.println();
			
			do {
				
				System.out.println("Type the corresponding number to the game you would like to play and click enter.");
				System.out.println();
				
				//Give Menu options for multiple Games
				System.out.println("1. Dice Game");
				System.out.println("2. Card Game");
				//Add Games over time
				
				//Get the desired Game# from the user
				game_selection = scan.nextInt();
				
				// Game Choice Switch Statement
				switch(game_selection)
				{
				   //Available
				   case 1 :
					   Dice_Game dice_game = new Dice_Game();
					   game_winner = dice_game.Play(players);
					   invalid_choice = false;
				      break;
				   //Unavailable
				   case 2 :
					   System.out.println("the card game is out of order. Please try another game.");
					   System.out.println();
					   invalid_choice = true;
				      break;
				   //Invalid Game #
				   default : 
				      System.out.println("The number entered does not correspond to any of the options. Please Try again.");
				      System.out.println();
				      invalid_choice = true;
				      break;
				}
				
			}while(invalid_choice == true);
			
			
			System.out.println("Congrats to "+game_winner+" for winning game "+game_number);
			System.out.println();
			
			System.out.println("Would you like to play another game? (y or n)");
			play_again = scan.nextLine();
			
			
		}while(play_again.equals("y"));
		
		//Calculate an overall winner with how many wins they had
		
		scan.close();
		
	}

}