import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PlayerTest {
	Player player1;
	Player player2;
	@Before
	public void setUp() throws Exception {
		player1 = new Player(1000);
		player2 = new Player(2000);
		
		player1.addSeedsToStoreHouse(10);
		player1.addSeedsToStoreHouse(20);
		
		player2.addSeedsToStoreHouse(456);
		
	}

	@Test
	public void playerKnowsItsID() {
		assertEquals(1000, player1.getId());
	}

	@Test
	public void playerKnowsItsScore() {
		assertEquals(30, player1.getScore());
		assertEquals(456, player2.getScore());
	}
}
