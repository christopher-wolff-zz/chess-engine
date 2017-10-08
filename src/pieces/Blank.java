package pieces;

import chess.Color;
import chess.Piece;

public class Blank extends Piece {

	public Blank(Color color) {
		super(color);
		
		value = 0;
	}

	@Override
	public String toString() {
		return "\u3000"; // Full-width space character
	}

}
