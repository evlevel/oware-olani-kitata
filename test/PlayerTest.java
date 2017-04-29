import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PlayerTest {

	Player p;
	
	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testPlayer() {
		this.p = new Player(1);
		assertNotNull("player must not be null",this.p);
	}

	@Test
	public final void testGetId() {
		assertEquals("player ID should be 0",new Player(0).getId(),0);
	}

	@Test
	public final void testGetScore() {
		assertEquals("score should be 0",new Player(0).getScore(),0);
	}

	@Test
	public final void testAddSeedsToStoreHouse() {
		Player ptest = new Player(0);
		ptest.addSeedsToStoreHouse(1);
		assertEquals("score should be 1",ptest.getScore(),1);
	}


}
