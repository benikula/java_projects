package player;

import color.Color;

public abstract class Player {
	String name;
	Color color;
	
	public Color getColor() {
		return color;
	}

	public Player(String name, Color color) {
		this.name = name;
		this.color = color;
	}

	public abstract String makeMove();
	
}
