import java.util.Scanner;

public class OwareGame {

	private final Player player1 = new Player(1);
	private final Player player2 = new Player(2);
	private Player activePlayer;
	private final Board board = new Board();
	private Pit activePit;
	
	public OwareGame() {
		//default active player to player1;
		this.activePlayer=player1;
	}
	
	public Player getActivePlayer(){
		return activePlayer;
	}
	
	public Board getBoard(){
		return this.board;
	}
	
	public Pit askPlayerPitChoiceForMove(Player activePlayer, Scanner scan){
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
				e.printStackTrace();
			System.out.println("You have entered a value that is not numeric please try again.");
			System.out.println("Your valid entries are from " + validPitNumbersForCurrentPlayer);
			scan.nextLine();
			}
		}
		return playersChoice;
	}
	
	public String validPitNumbers(Player activePlayer){
		String validPits = new String();
		if(activePlayer.getId()==1)
			validPits="0 to 5";
		else
			validPits="6 to 11";
		return validPits;
	}

	public boolean isGameOver(){
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

	public Player switchPlayer(){
		if(activePlayer.getId()==1)
			activePlayer = player2;
		else if (activePlayer.getId()==2)
			activePlayer = player1;
		
		return activePlayer;
	}

	public void displayCurrentScores(){
		System.out.println("Player 1: " + player1.getScore());
		System.out.println("Player 2: " + player2.getScore() + "\n");
	}
	public void displayFinalScores(){
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
	
	public void displayMoveWasInvalid(int pitNumber, String validPitNumbersForCurrentPlayer){
		System.out.println("P" + pitNumber +" is not a valid move because \n"
				+ "a) Either you attempted a move on opponents pit OR \n"
				+ "b) your move CANNOT reach (sow) opponents pit\n"
				+ "Please try again with pit opther than " + pitNumber +".\n"
				+"Your Pits are from pit "+ validPitNumbersForCurrentPlayer);
	}
}
