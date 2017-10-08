package pieces;

import chess.Color;
import chess.Piece;

public class Bishop extends Piece {

	public Bishop(Color color) {
		super(color);
		
		value = 3;
	}

	@Override
	public String toString() {
		if (color == Color.WHITE)
			return "\u2657";
		else if (color == Color.BLACK)
			return "\u265D";
		else
			System.out.println("Invalid color for bishop: " + color);
		
		return "";	
	}
	
}
