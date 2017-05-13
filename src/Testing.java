import static org.junit.Assert.*;

import org.junit.Test;

public class Testing {

		@Test
		public void setUp()throws Exception
		{
			
		}
		@Test
		public void testWenjingManalAndAddSeeds()
		{
			 Storehouse  house = new  Storehouse ();
			 assertEquals("test initial seeds",0,house.getNumSeeds());
			 
			 house.addCapturedSeeds(5);
			 assertEquals("Capture 5 seeds", 5, house.getNumSeeds());

		}
			
		
		public void testWenjingAndManalAndAddSeeds()
		{
			 Storehouse  house = new  Storehouse ();
			 assertEquals("test initial seeds",1,house.getNumSeeds());
			 
			 house.addCapturedSeeds(5);
			 assertEquals("Capture 4 seeds", 4, house.getNumSeeds());

		}

	
}