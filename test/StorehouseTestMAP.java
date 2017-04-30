import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StorehouseTestMAP {

	@Test
	public void testAddCapturedSeeds() {
		Storehouse store = new Storehouse();
		store.addCapturedSeeds(5);
		assertEquals(5, store.getNumSeeds());
		store.addCapturedSeeds(2);
		assertEquals(7, store.getNumSeeds());
	}

	@Test
	public void testGetNumSeeds() {
		Storehouse store = new Storehouse();
		assertEquals(0, store.getNumSeeds());
	}

}
