package pieces;

import chess.Color;
import chess.Piece;

public class Queen extends Piece {

	public Queen(Color color) {
		super(color);
		
		value = 9;
	}

	@Override
	public String toString() {
		if (color == Color.WHITE)
			return "\u2655";
		else if (color == Color.BLACK)
			return "\u265B";
		else
			System.out.println("Invalid color for queen: " + color);
		
		return "";
	}

}
