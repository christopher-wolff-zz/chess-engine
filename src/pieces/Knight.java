package pieces;

import chess.Color;
import chess.Piece;

public class Knight extends Piece {

	public Knight(Color color) {
		super(color);
		
		value = 3;
	}

	@Override
	public String toString() {
		if (color == Color.WHITE)
			return "\u2658";
		else if (color == Color.BLACK)
			return "\u265E";
		else
			System.out.println("Invalid color for knight: " + color);
		
		return "";
	}

}
