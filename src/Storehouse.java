
public class Storehouse
{
	private int numSeeds=0;

	public void addCapturedSeeds(int n){
		numSeeds += n;
	}
	
	public int getNumSeeds(){
		return this.numSeeds;
	}

}
