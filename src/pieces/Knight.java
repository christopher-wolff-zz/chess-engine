package pieces;

import java.util.ArrayList;

import chess.Color;
import chess.Move;
import chess.Piece;
import chess.Square;

public class Knight extends Piece {

	public Knight(Color color) {
		super(color);
		
		value = 3;
	}

	public String symbol() {
		if (color == Color.WHITE)
			return "\u2658";
		else if (color == Color.BLACK)
			return "\u265E";
		else {
			new Exception("Invalid color for knight: " + color).printStackTrace();
			System.exit(-1);
		}
		
		return "";
	}

	public ArrayList<Move> pseudoLegalMoves(Piece[][] board, Square square) {
		ArrayList<Move> moves = new ArrayList<Move>();
		
		int col = square.getCol();
		int row = square.getRow();
		
		Square[] targetSquares = new Square[]{new Square(col+1, row+2), new Square(col+2, row+1), new Square(col+2, row-1), new Square(col+1, row-2),
											  new Square(col-1, row-2), new Square(col-2, row-1), new Square(col-2, row+1), new Square(col-1, row+2)};
		
		for (Square targetSquare : targetSquares) {
			if (! targetSquare.isInBounds())
				continue;
			
			int targetCol = targetSquare.getCol();
			int targetRow = targetSquare.getRow();
			if (board[targetCol][targetRow] == null || board[targetCol][targetRow].getColor() != color) // target is empty or occupied by opponent
				moves.add(new Move(new Square(square), new Square(targetSquare)));

		}
		
		return moves;
	}

	@Override
	public String toString() {
		return color + " knight";
	}

}
