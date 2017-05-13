import java.util.Scanner;

public class OwareApp {

	private static Player activePlayer; 
	private static Pit activePit;
	private static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args){
		System.out.println("Welcome to Oware!");
		System.out.println("There are 6 Pits for each player.\n"
					+"Pits P0 to P5 belongs to Player 1, while P6 to P11 belong to Player 2.\n"
					+"The numbers of seeds in each pit is displayed above or below each pit.\n"
					+"\n\nBelow is the current State of the Board.\n");

		OwareGame theGame = new OwareGame();
		activePlayer =theGame.getActivePlayer();

		while(!theGame.isGameOver()){
			//game summary
			theGame.getBoard().showBoard();
			System.out.println("\nActive player: Player " +theGame.getActivePlayer.getId()
						+". Available pits to choose from are pit " + theGame.validPitNumbers(activePlayer));
			
			//prompt move
			theGame.askPlayerPitChoiceForMove(theGame.getActivePlayer(),scan);
			System.out.println("\nYou have successfully chosen pit P"+theGame.getActivePit.getPitNumber());
			
			//make & score move
			theGame.setActivePit(Move.makeMove(theGame.getActivePit()));
			int capturedSeeds = Move.captureSeedsStartingAt(activePlayer.getId(), theGame.getActivePit());
			theGame.getActivePlayer().addSeedsToStoreHouse(capturedSeeds);
			
			// move summary
			System.out.println("Seeds captured from last move: " + capturedSeeds);
			System.out.println("Current Scores");
			theGame.displayCurrentScores();
			
			//switch player
			activePlayer = theGame.switchPlayer();
		}
		
		System.out.println("***************************"
							+ "\nGAME OVER!");
		System.out.println();
		theGame.displayFinalScores();
		
		scan.close();
	}
	

}
