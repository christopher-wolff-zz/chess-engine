package pieces;

import chess.Color;
import chess.Piece;

public class Rook extends Piece {

	public Rook(Color color) {
		super(color);
		
		value = 5;
	}

	@Override
	public String toString() {
		if (color == Color.WHITE)
			return "\u2656";
		else if (color == Color.BLACK)
			return "\u265C";
		else
			System.out.println("Invalid color for rook: " + color);
		
		return "";
	}

}
