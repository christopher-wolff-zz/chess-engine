package chess;

public class Game {
	
	private Position position;
	private int turn;
	private Color toMove;
	
	public Game() {
		position = new Position();
		System.out.println(position);
		turn = 0;
	}
	
}
