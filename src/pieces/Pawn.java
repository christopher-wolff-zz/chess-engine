package pieces;

import chess.Color;
import chess.Piece;

public class Pawn extends Piece {

	public Pawn(Color color) {
		super(color);
		
		value = 1;
	}

	@Override
	public String toString() {
		if (color == Color.WHITE)
			return "\u2659";
		else if (color == Color.BLACK)
			return "\u265F";
		else
			System.out.println("Invalid color for pawn: " + color);
		
		return "";
	}

}
