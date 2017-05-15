import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OwareGameTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testOwareGame() {
		OwareGame theGame = new OwareGame();
		assertNotNull(theGame);
		assertEquals(1, theGame.getActivePlayer().getId());
	}

	@Test
	public void testGetActivePlayer() {
		OwareGame theGame = new OwareGame(); 
		assertEquals(1, theGame.getActivePlayer().getId());
	}

	@Test
	public void testAskPlayerPitChoiceForMove() {
		OwareGame theGame = new OwareGame();  
		String pitChoice = "3";
	  Scanner scanner = new Scanner(new ByteArrayInputStream(pitChoice.getBytes())); 
		theGame.askPlayerPitChoiceForMove(theGame.getActivePlayer(), scanner);
		theGame.getBoard().showBoard();
	}


	@Test
	public void testIsGameOver() {
		OwareGame theGame = new OwareGame(); 
		assertEquals(false, theGame.isGameOver());
	}
	
	@Test
	public void testIsGameOver_GameIsOverWhenTied() {
		OwareGame theGame = new OwareGame(); 
		
		Player player1 = theGame.getActivePlayer();
		player1.addSeedsToStoreHouse(24);
		theGame.switchPlayer();
		Player player2 = theGame.getActivePlayer();
		player2.addSeedsToStoreHouse(24);
		theGame.displayFinalScores();
		assertEquals(true, theGame.isGameOver());
	}
	
	@Test
	public void testIsGameOver_TrueWhenPlayer1HasMoreThan24() {
		OwareGame theGame = new OwareGame(); 
		
		Player player1 = theGame.getActivePlayer();
		player1.addSeedsToStoreHouse(25);
		theGame.switchPlayer();
		Player player2 = theGame.getActivePlayer();
		player2.addSeedsToStoreHouse(23);
		theGame.displayFinalScores();
		assertEquals(true, theGame.isGameOver());
	}
	
	@Test
	public void testIsGameOver_TrueWhenPlayer2HasMoreThan24() {
		OwareGame theGame = new OwareGame(); 
		
		Player player1 = theGame.getActivePlayer();
		player1.addSeedsToStoreHouse(23);
		theGame.switchPlayer();
		Player player2 = theGame.getActivePlayer();
		player2.addSeedsToStoreHouse(25);
		theGame.displayFinalScores();
		assertEquals(true, theGame.isGameOver());
	}
	@Test
	public void testSwitchPlayer() {
		OwareGame theGame = new OwareGame(); 
		theGame.switchPlayer();
		Player newPlayer= theGame.getActivePlayer();
		assertEquals(2, theGame.getActivePlayer().getId());
		assertEquals(newPlayer, theGame.getActivePlayer());
		
		theGame.switchPlayer();
		Player newPlayer1= theGame.getActivePlayer();
		assertEquals(1, theGame.getActivePlayer().getId());
		assertEquals(newPlayer1, theGame.getActivePlayer());
		
	}
	
	@Test
	public void testValidPitNumbers() {
		OwareGame theGame = new OwareGame();  
		assertEquals("0 to 5", theGame.validPitNumbers(theGame.getActivePlayer()));
		theGame.switchPlayer();
		assertEquals("6 to 11", theGame.validPitNumbers(theGame.getActivePlayer()));
	}

	
	@Test
	public void testDisplayCurrentScores() {
		OwareGame theGame = new OwareGame(); 
		theGame.displayCurrentScores(); 
	}

	@Test
	public void testDisplayFinalScores() {
		OwareGame theGame = new OwareGame(); 
		theGame.displayFinalScores();
	}

	@Test
	public void testDisplayMoveWasInvalid() {
		OwareGame theGame = new OwareGame(); 
		theGame.displayMoveWasInvalid(0, "0 to 5");
	}

}
