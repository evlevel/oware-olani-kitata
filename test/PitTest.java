import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PitTest {
	Pit p1;
	Pit p2;
	Pit p3;
	@Before
	public void setUp() throws Exception {
		p1= new Pit(1);
		p2= new Pit(2);
		p3 = new Pit(3);
		
		p1.setNext(p2);
		p2.setNext(p3);
		p3.setNext(p1);
		p1.setPrevious(p3);
		p2.setPrevious(p2);
		p3.setPrevious(p2);
	}

	@Test
	public void aPitKnowsHowManySeedsAreInIt() {
		assertEquals(1, p1.getNumSeeds());
		assertEquals(2, p2.getNumSeeds());
		assertEquals(3, p3.getNumSeeds());
	}
	
	
	@Test
	public void aPitKnowsItsPreviousPit() {
		assertEquals(3, p1.getPrevious().getNumSeeds());
	}
	
	
	@Test
	public void aPitKnowsItsNextPit() {
		assertEquals(2, p1.getNext().getNumSeeds());
	}
	

}
