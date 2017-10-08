package pieces;

import java.util.ArrayList;

import chess.Color;
import chess.Move;
import chess.Piece;
import chess.Square;

public class Rook extends Piece {

	public Rook(Color color) {
		super(color);
		
		value = 5;
	}

	public String symbol() {
		if (color == Color.WHITE)
			return "\u2656";
		else if (color == Color.BLACK)
			return "\u265C";
		else
			System.out.println("Invalid color for rook: " + color);
		
		return "";
	}

	public ArrayList<Move> pseudoLegalMoves(Piece[][] board, Square square) {
		ArrayList<Move> moves = new ArrayList<Move>();
		
		
		
		return moves;
	}

	@Override
	public String toString() {
		return color + " rook";
	}

}
