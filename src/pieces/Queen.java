package pieces;

import java.util.ArrayList;

import chess.Color;
import chess.Move;
import chess.Piece;
import chess.Square;

public class Queen extends Piece {

	public Queen(Color color) {
		super(color);
		
		value = 9;
	}

	@Override
	public String symbol() {
		if (color == Color.WHITE)
			return "\u2655";
		else if (color == Color.BLACK)
			return "\u265B";
		else
			System.out.println("Invalid color for queen: " + color);
		
		return "";
	}

	public ArrayList<Move> pseudoLegalMoves(Piece[][] board, Square square) {
		ArrayList<Move> moves = new ArrayList<Move>();
		return moves;
	}

	@Override
	public String toString() {
		return color + " queen on";
	}

}
