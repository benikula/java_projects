package test;


import color.Color;
import player.ChessPlayer;
import player.Player;
import game.ChessGame;
import game.Game;

public class Main {

	public static void main(String[] args) {
		
		Player w = new ChessPlayer("w", Color.WHITE);
		Player b = new ChessPlayer("b", Color.BLACK);
		Game chessGame = new ChessGame();
		chessGame.addPlayer(w);
		chessGame.addPlayer(b);
		chessGame.initGame();
		chessGame.startPlaying();
	}

}
