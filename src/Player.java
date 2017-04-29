
public class Player
{
	private int id;
	private Storehouse playersStorehouse;
	
	Player(int id){
		this.id = id;
		this.playersStorehouse = new Storehouse();
	}
	
	public int getId(){
		return this.id;
	}
	
	public void addSeedsToStoreHouse(int numSeeds){
		playersStorehouse.addCapturedSeeds(numSeeds);
	}
	public int getScore(){
		return playersStorehouse.getNumSeeds();
	}

}
