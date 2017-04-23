import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MoveTest {
	Board board;
	
	@Before
	public void setUp() throws Exception {
		board = new Board();
		
	}

	@Test
	public void capturingFromPitWithContainingSeedsMoreLessThan2or3Returns0(){
		board.getPit(1).setNumSeeds(5);
		board.getPit(2).setNumSeeds(6);
		board.getPit(3).setNumSeeds(3);
		board.getPit(4).setNumSeeds(2);
		
		assertEquals(Move.captureSeedsStartingAt(2, board.getPit(1)), 0);
		assertEquals(Move.captureSeedsStartingAt(2, board.getPit(2)), 0);
		//assertEquals(Move.captureSeedsStartingAt(board.getPit(3)), 3);
		assertEquals(Move.captureSeedsStartingAt(2, board.getPit(4)), 5);
	}
	
	@Test
	public void moveIsNotAllowedOnOpponentsPit(){
		//Board.
	}
	
	@Test
	public void moveOmittesFromSowingAHouseItStartsFrom(){
		board.getPit(1).setNumSeeds(12);
		Move.makeMove(board.getPit(1));
		
		
		assertEquals(board.getPit(1).getNumSeeds(), 0);
		assertEquals(board.getPit(0).getNumSeeds(), 5);
		assertEquals(board.getPit(11).getNumSeeds(), 5);
		assertEquals(board.getPit(2).getNumSeeds(), 6);
	}
	
	@Test
	public void oneCanOnlyCaptureFromUptoFivePits(){
		board.getPit(11).setNumSeeds(3);
		board.getPit(10).setNumSeeds(2);
		board.getPit(9).setNumSeeds(2);
		board.getPit(8).setNumSeeds(2);
		board.getPit(7).setNumSeeds(3);
		board.getPit(6).setNumSeeds(3);
		board.getPit(5).setNumSeeds(2);
		
		assertEquals(12, Move.captureSeedsStartingAt(1, board.getPit(11)));
	}
	
	
	@Test
	public void oneCanOnlyCaptureFromOpponentsPits(){
		board.getPit(11).setNumSeeds(3);
		board.getPit(10).setNumSeeds(2);
		board.getPit(9).setNumSeeds(2);
		board.getPit(8).setNumSeeds(2);
		board.getPit(7).setNumSeeds(3);
		board.getPit(6).setNumSeeds(3);
		board.getPit(5).setNumSeeds(2);
		assertEquals(0, Move.captureSeedsStartingAt(2, board.getPit(9)));
		assertEquals(10, Move.captureSeedsStartingAt(1, board.getPit(9)));
		board.showBoard();
	}

}
