/* 
 * This class will complete all of the functions that every game must complete
 */

package Games;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	
	boolean valid_players;
	int players = 0;
	Scanner scan = new Scanner(System.in);
	ArrayList<String> names = new ArrayList<>();
	String winner;
	Game game = new Game();
	int min_players;
	int max_players;
	boolean valid_game_number;
	
	
	public void SetupGame(int game_selection) {
		
		do {
			System.out.println("How many players will be playing today?");
			
			//Collect # of players
			players = scan.nextInt();
			
			game.PlayersValidator(game_selection);
		}while(valid_players = false);
		
	}
	
	//Validates # of players for each game
	public boolean PlayersValidator(int game_selection) {
		
		switch(game_selection) {
		//Dice game can have 2-10 players
		case 1: 
			min_players = 2;
			max_players = 10;
			if(players>=min_players && players <=max_players) {
				System.out.println("Awesome! "+players+" players is a great amount for this game.");
				valid_players = true;
			}
			else if(players<min_players) {
				System.out.println("I'm sorry, but you have to have more than"+min_players+" player to play this game.");
				valid_players = false;
			}
			else if(players>max_players) {
				System.out.println("I'm sorry, but"+max_players+" players is the maximum allowed for this game.");
				valid_players = false;
			}
			
		//Card Game can have 2-4 players
		case 2: 
			min_players = 2;
			max_players = 4;
			if(players>=min_players && players <=max_players) {
				System.out.println("Awesome! "+players+" players is a great amount for this game.");
				valid_players = true;
			}
			else if(players<min_players) {
				System.out.println("I'm sorry, but you have to have more than"+min_players+" player to play this game.");
				valid_players = false;
			}
			else if(players>max_players) {
				System.out.println("I'm sorry, but"+max_players+" players is the maximum allowed for this game.");
				valid_players = false;
			}
			//Insert validations for other games
			default:
				System.out.println("I'm sorry, but this not a game option.");
				valid_players = false;
		}
				
			
		return valid_players;
	}
		
	
	public boolean ValidGameNumber(int game_selection) {
		
		// Game Choice Switch Statement
		switch(game_selection)
		{
		   //Available
		   case 1 :
			   valid_game_number = true;
		      break;
		   //Unavailable
		   case 2 :
			   System.out.println("the card game is out of order. Please try another game.");
			   System.out.println();
			   valid_game_number = false;
		      break;
		   //Invalid Game #
		   default : 
		      System.out.println("The number entered does not correspond to any of the options. Please Try again.");
		      System.out.println();
		      valid_game_number = false;
		      break;
		}
		
		return valid_game_number;
	}
	
	public void GameMenu() {
		
		System.out.println("1. Dice Game");
		System.out.println("2. Card Game");
		//Add Games over time
	}
	
	public String CallGame(int game_selection) {
			
			switch(game_selection) {
			case 1:
				Dice_Game dice_game = new Dice_Game();
				winner = dice_game.Play(players);
			case 2:
				Card_Game card_game = new Card_Game();
				winner = card_game.Play(players);
			default:
				winner = "NA";
			}
		
		return winner;
	}
	
	public void GameResults(int game_number) {
		
		System.out.println("Congrats to "+winner+" for winning game "+game_number);
		System.out.println();
		
	}
	
}
