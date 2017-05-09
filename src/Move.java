
public class Move
{
	
// a comment for testing...
	
	public static Pit makeMove(Pit p){
		int startingPointPitNumber = p.getPitNumber();
		int playingNumberOfSeeds = p.getNumSeeds();
		Pit activePit = p;
		p.setNumSeeds(0);
		while(playingNumberOfSeeds>0){
			activePit= activePit.getNext();
			if(activePit.getPitNumber()!=startingPointPitNumber){		//jump seeding the pit the play started from.
				activePit.addSeed();
				playingNumberOfSeeds--;
			}
		}
		return activePit;
	}

	public static boolean canActivePitSowOpponentsPit(Pit pit){
		int pitNumber = pit.getPitNumber();
		boolean answer = false;
		if ((pitNumber<=5) && (1+pitNumber+pit.getNumSeeds()>6))
			answer = true;
		else if((pitNumber>5) && (1+pitNumber+pit.getNumSeeds()>12))
			answer = true;
		return answer;
	}
	
	public static boolean isThisPitPlayers(int playerId, int pitNumber){
		boolean answer = false;
		if((playerId==1) && (pitNumber>=0) && (pitNumber<=5))
			answer= true;
		else if ((playerId==2) && (pitNumber>=6) && (pitNumber<=11))
			answer= true;
		return answer;
	}
	
	
	
	public static int captureSeedsStartingAt(int playerId, Pit p){
		int totalSeedsCaptured =0;
		if (isThisPitPlayers(playerId, p.getPitNumber())==false){
			int numberOfPitsCaptured = 0;
			Pit activePit = p;
			while(numberOfPitsCaptured<5 && ((activePit.getNumSeeds()==2) || (activePit.getNumSeeds()==3)) && ((p.getPitNumber()/6)==(activePit.getPitNumber()/6))){
				totalSeedsCaptured += activePit.getNumSeeds();
				activePit.setNumSeeds(0);
				activePit = activePit.getPrevious();
				numberOfPitsCaptured++;
			}
		}
		
		return totalSeedsCaptured;
	}
}
