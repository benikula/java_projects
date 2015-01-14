package game;

import java.util.ArrayList;
import java.util.List;

import player.Player;

public abstract class  Game {
	
	protected List<Player> players = null;
	protected int numOfPlayers;
	protected boolean isRunning = true;
	protected Player playingNow = null;
	
	public Game(int numOfPlayers) {
		players = new ArrayList<Player>(numOfPlayers);
		this.numOfPlayers = numOfPlayers;
	}
	
	public boolean addPlayer(Player p) {
		if(players.size() == numOfPlayers) {
			return false;
		}
		players.add(p);
		return true;
	}
	
	public boolean removePlayer(Player p) {
		isRunning = false;
		return players.remove(p);
	}
	
	//public abstract boolean move(String step);
	public abstract void initGame();
	public abstract void startPlaying();
	public abstract boolean isRnning();
}
