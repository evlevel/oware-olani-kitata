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
			theGame.getBoard().showBoard();
			System.out.println("\nActive player: Player " +activePlayer.getId()
								+". Available pits to choose from are pit " + theGame.validPitNumbers(activePlayer));
			
			activePit=theGame.askPlayerPitChoiceForMove(activePlayer,scan);
			System.out.println("\nYou have successfully chosen pit P"+activePit.getPitNumber());
			activePit=Move.makeMove(activePit);
			int capturedSeeds = Move.captureSeedsStartingAt(activePlayer.getId(), activePit);
			activePlayer.addSeedsToStoreHouse(capturedSeeds);
			System.out.println("Seeds captured from last move: " + capturedSeeds);
			System.out.println("Current Scores");
			theGame.displayCurrentScores();
			
			activePlayer = theGame.switchPlayer();
		}
		
		System.out.println("***************************"
							+ "\nGAME OVER!");
		System.out.println();
		theGame.displayFinalScores();
		
		scan.close();
	}
	

}
