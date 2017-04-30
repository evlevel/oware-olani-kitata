import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PlayerTestSR {
	private Player player;
	
	@Before
	public void setUp() throws Exception {
		player=  new Player(1); 
		player.addSeedsToStoreHouse(1);
	}


	@Test
	public void testPlayer() { 
		assertNotNull(player); 
	}

	@Test
	public void testGetID() {
		assertEquals(1, player.getId());
	}

	
	@Test
	public void testGetSeedsToStoreHouse() { 
		assertEquals(1, player.getScore());
	}

}
