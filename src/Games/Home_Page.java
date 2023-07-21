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
		
		boolean valid_game_number = true;
		Scanner scan = new Scanner(System.in);
		Game game = new Game();
		
		System.out.println("Welcome to the game Dashboard!");
		System.out.println();
		
		do {
			
			System.out.println("Time for Game #"+(++game_number));
			System.out.println();
			
			do {
				
				System.out.println("Type the corresponding number to the game you would like to play and click enter.");
				System.out.println();
				
				//Call game Menu - outputs the game options
				game.GameMenu();
				
				//Get the desired Game# from the user
				game_selection = scan.nextInt();
				
				//Makes sure the number is a valid game
				valid_game_number = game.ValidGameNumber(game_selection);
				
			}while(valid_game_number == false);
			
			//Skip this if user wants same # of players, but still validate # of players
			//Call SetupGame - receives #players and validates
			game.SetupGame(game_selection);
			
			
			//Call specified game - calls to specific game class
			game.CallGame(game_selection);
			
			//Call the game results method
			game.GameResults(game_number);
			
			System.out.println("Would you like to play another game? (y or n)");
			play_again = scan.nextLine();
			
			if(play_again.equals("y"))
			{
				System.out.println("Let's Play another!");
				System.out.println();
			}
			
			
		}while(play_again.equals("y"));
		
		//Calculate an overall winner with how many wins they had
		
		scan.close();
		
	}

}