package game;

import player.Player;

public class Turn {
	
	Game game;
	Player player1; 
	Player player2;
	
	public Turn(Game game, Player player1, Player player2) {
		this.game = game;
		this.player1 = player1;
		this.player2 = player2;
	}
	
	
}
