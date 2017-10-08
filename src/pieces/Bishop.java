package pieces;

import java.util.ArrayList;

import chess.Color;
import chess.Move;
import chess.Piece;
import chess.Square;

public class Bishop extends Piece {

	public Bishop(Color color) {
		super(color);
		
		value = 3;
	}

	@Override
	public String symbol() {
		if (color == Color.WHITE)
			return "\u2657";
		else if (color == Color.BLACK)
			return "\u265D";
		else
			System.out.println("Invalid color for bishop: " + color);
		
		return "";	
	}

	public ArrayList<Move> pseudoLegalMoves(Piece[][] board, Square square) {
		ArrayList<Move> moves = new ArrayList<Move>();
		return moves;
	}

	@Override
	public String toString() {
		return color + " bishop";
	}
	
}
