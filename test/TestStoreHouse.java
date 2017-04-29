import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestStoreHouse
{

	@Before
	public void setUp() throws Exception
	{
	}
	@Test
	public void testAddSeedsEric()
	{
		Storehouse house = new Storehouse();
		assertEquals("test initial seeds in storehouse",0,house.getNumSeeds());
		
		house.addCapturedSeeds(5);
		assertEquals("capture 5 seeds", 5, house.getNumSeeds());
		
	}

}
