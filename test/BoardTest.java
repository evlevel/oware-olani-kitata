import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BoardTest {
	Board board;
	@Before
	public void setUp() throws Exception {
		board= new Board();
	}

	@Test
	public void test() {
		for(int i=0; i<11; i++){
			board.getPit(i).setNumSeeds(0);
		}
		assertEquals(false, board.isPlayerAbleToMakeMove(1));
		assertEquals(true, board.isPlayerAbleToMakeMove(2));
	}

}
