package player;

import java.util.Scanner;

import color.Color;

public class ChessPlayer extends Player {

	public ChessPlayer(String name, Color color) {
		super(name, color);
	}

	@Override
	public String makeMove() {
		System.out.println(color + " player, please enter step: ");
		@SuppressWarnings("resource")
		Scanner reader = new Scanner(System.in);
		String s = reader.next();
//		reader.close();
		return s;
	}

}
