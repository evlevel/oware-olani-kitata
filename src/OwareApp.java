import java.util.Scanner;

public class OwareApp {

	private static Player player1 = new Player(1);
	private static Player player2 = new Player(2);
	private static Player activePlayer;
	private static Board board = new Board();
	private static Pit activePit;
	private static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args){
		System.out.println("Welcome to Oware!");
		System.out.println("There are 6 Pits for each player.\n"
							+"Pits P0 to P5 belongs to Player 1, while P6 to P11 belong to Player 2.\n"
							+"The numbers of seeds in each pit is displayed above or below each pit.\n"
							+"\n\nBelow is the current State of the Board.\n");
		
		
		
		activePlayer = player1;
		while(!isGameOver()){
			board.showBoard();
			System.out.println("\nActive player: Player " +activePlayer.getId()
								+". Available pits to choose from are pit " + validPitNumbers(activePlayer));
			
			activePit=askPlayerPitChoiceForMove(activePlayer);
			System.out.println("\nYou have successfully chosen pit P"+activePit.getPitNumber());
			activePit=Move.makeMove(activePit);
			int capturedSeeds = Move.captureSeedsStartingAt(activePlayer.getId(), activePit);
			activePlayer.addSeedsToStoreHouse(capturedSeeds);
			System.out.println("Seeds captured from last move: " + capturedSeeds);
			System.out.println("Current Scores");
			displayCurrentScores();
			
			switchPlayer();
		}
		
		System.out.println("***************************"
							+ "\nGAME OVER!");
		System.out.println();
		displayFinalScores();
		
		scan.close();
	}
	
	
	
	private static Pit askPlayerPitChoiceForMove(Player activePlayer){
		boolean validChoiceMade=false;
		String validPitNumbersForCurrentPlayer = validPitNumbers(activePlayer);
		System.out.println("Please choose your pit");
		int pitNumber=-1;
		Pit playersChoice=null;
		while(validChoiceMade==false){
			try {
				pitNumber=scan.nextInt();
				Pit pitSelected = board.getPit(pitNumber);
				if ((Move.isThisPitPlayers(activePlayer.getId(), pitNumber))&&(Move.canActivePitSowOpponentsPit(pitSelected))){
					validChoiceMade=true;
					playersChoice=board.getPit(pitNumber);
				}else{
					displayMoveWasInvalid(pitNumber, validPitNumbersForCurrentPlayer);
				}
			} catch (Exception e) {
			System.out.println("You have entered a value that is not numeric please try again.");
			System.out.println("Your valid entries are from " + validPitNumbersForCurrentPlayer);
			scan.nextLine();
			}
		}
		return playersChoice;
	}
	
	private static String validPitNumbers(Player activePlayer){
		String validPits = new String();
		if(activePlayer.getId()==1)
			validPits="0 to 5";
		else
			validPits="6 to 11";
		return validPits;
	}
	
	
	private static boolean isGameOver(){
		boolean answer;
		if((player1.getScore()>24)||(player2.getScore()>24))
			answer = true;
		else if ((player1.getScore()==24)||(player2.getScore()==24))
			answer = true;
		else if(!board.isPlayerAbleToMakeMove(activePlayer.getId()))
			answer = true;
		else
			answer = false;
		return answer;
	}
	

	private static void switchPlayer(){
		if(activePlayer.getId()==1)
			activePlayer = player2;
		else if (activePlayer.getId()==2)
			activePlayer = player1;
	}

	private static void displayCurrentScores(){
		System.out.println("Player 1: " + player1.getScore());
		System.out.println("Player 2: " + player2.getScore() + "\n");
	}
	private static void displayFinalScores(){
		int player1FinalScore = player1.getScore();
		int player2FinalScore = player2.getScore();
		for (int i=0; i<=5; i++)
			player1FinalScore += board.getPit(i).getNumSeeds();
		for (int i=6; i<=11; i++)
			player2FinalScore += board.getPit(i).getNumSeeds();
		if(player1FinalScore>player2FinalScore)
			System.out.println("The Winnner is Player 1");
		else
			System.out.println("The Winnner is Player 2");
		
		System.out.println("Scores...");
		System.out.println("Player 1: " + player1FinalScore);
		System.out.println("Player 2: " + player2FinalScore);
	}
	
	private static void displayMoveWasInvalid(int pitNumber, String validPitNumbersForCurrentPlayer){
		System.out.println("P" + pitNumber +" is not a valid move because \n"
				+ "a) Either you attempted a move on opponents pit OR \n"
				+ "b) your move CANNOT reach (sow) opponents pit\n"
				+ "Please try again with pit opther than " + pitNumber +".\n"
				+"Your Pits are from pit "+ validPitNumbersForCurrentPlayer);
	}
}
