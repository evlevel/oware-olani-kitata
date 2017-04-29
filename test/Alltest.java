import static org.junit.Assert.*;

import org.junit.Test;

public class Alltest {

	@Test
	public void testPlayer() {
		Player player = new Player(1);
		assertEquals("test player creator",1, player.getId());
	}


	@Test
	public void testAddSeedsToStoreHouse() {
		Player player = new Player(1);
		assertEquals("test player creator",1, player.getId());
		
		player.addSeedsToStoreHouse(10);
		assertEquals("get 10 scores", 10, player.getScore());
	}

	

}
