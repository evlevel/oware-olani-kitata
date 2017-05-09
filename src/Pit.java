
public class Pit
{
	private int pitNumber;
	private int ownerPlayerID;
	private int numSeeds;
	private Pit next;
	private Pit previous;
	

	public Pit(){
		numSeeds = 4;
		previous = null; 
		next = null;
	}
	
	public Pit(int numSeeds){
		previous = null; 
		next = null;
		this.numSeeds = numSeeds;
	}
	public int getNumSeeds()
	{
		return this.numSeeds;
	}

	public void setNumSeeds(int num)
	{
		this.numSeeds = num;
	}

	public void setPrevious(Pit p){
		previous = p;
	}
	
	public void setNext(Pit p){
		next = p;
	}
	
	public Pit getPrevious(){
		return previous;
	}
	
	public Pit getNext(){
		return  next;
	}
	
	public void setPitNumber(int rn){
		pitNumber = rn;
	}
	
	public void addSeed(){
		numSeeds++;
	}
	
	public int getPitNumber(){
		return pitNumber;
	}

	

}
