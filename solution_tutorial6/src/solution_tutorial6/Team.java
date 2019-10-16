package solution_tutorial6;

import java.util.HashMap;
import java.util.Map;

public class Team implements Comparable<Team>{

	private String name;
	private int win=0;
	private int lose=0;
	private int winSet=0;
	private int loseSet=0;
	private Map<String, Integer> loseCheck = new HashMap<String, Integer>();
	
	
	public Team(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWin() {
		return win;
	}

	public void setWin() {
		this.win += 1;
	}

	public int getLose() {
		return lose;
	}

	public void setLose() {
		this.lose += 1;
	}

	public int getWinSet() {
		return winSet;
	}

	public void setWinSet(int winSet) {
		this.winSet += winSet;
	}

	public int getLoseSet() {
		return loseSet;
	}

	public void setLoseSet(int loseSet) {
		this.loseSet += loseSet;
	}

	public Map<String, Integer> getLoseCheck() {
		return loseCheck;
	}

	public void addLoseCheck(String str) {
		if (!this.getLoseCheck().containsKey(str)) {
			this.getLoseCheck().put(str, 1);
		}
		else {
			int val = this.getLoseCheck().get(str) + 1;
			this.getLoseCheck().put(str, val);
		}
	}

	public boolean chch(Team compareTeam) {
		if(this.getLoseCheck().get(compareTeam.name) == null)
			return false;
		else
			return true;
	}
	
	@Override
	public int compareTo(Team compareTeam) {
		if(this.win > compareTeam.win)
			return -1;
		else if(this.win < compareTeam.win)
			return 1;
		else if((this.winSet-this.loseSet) > (compareTeam.winSet-compareTeam.loseSet))
			return -1;
		else if((this.winSet-this.loseSet) < (compareTeam.winSet-compareTeam.loseSet))
			return 1;
		else if(chch(compareTeam))
			return -1;
		else 
			return 1;
	}
	
	public String toString() {

        return name + " " + win + " " + lose + " " + winSet+ "-" + loseSet +" "+ (winSet-loseSet);

  }
}
