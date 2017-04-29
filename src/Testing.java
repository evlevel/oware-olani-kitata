import static org.junit.Assert.*;

import org.junit.Test;

public class Testing {

	public class AllTests {
		@Test
		public void setUp()throws Exception
		{
			
		}
		@Test
		public void testManalAndWenjingAddSeeds()
		{
			 Storehouse  house = new  Storehouse ();
			 assertEquals("test initial seeds",0,house.getNumSeeds());
			 
			 house.addCapturedSeeds(5);
			 assertEquals("Capture 5 seeds", 5, house.getNumSeeds());

		}
			
		}
}
