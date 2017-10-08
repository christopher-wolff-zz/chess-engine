package pieces;

import chess.Color;
import chess.Piece;

public class King extends Piece {

	public King(Color color) {
		super(color);
		
		value = 1000;
	}

	@Override
	public String toString() {
		if (color == Color.WHITE)
			return "\u2654";
		else if (color == Color.BLACK)
			return "\u265A";
		else
			System.out.println("Invalid color for king: " + color);
		
		return "";
		
	}

}
