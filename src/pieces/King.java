package pieces;

import java.util.ArrayList;

import chess.Color;
import chess.Move;
import chess.MoveEvent;
import chess.Piece;
import chess.Square;

public class King extends Piece {

	public King(Color color) {
		super(color);
		
		value = 10000;
	}

	@Override
	public String symbol() {
		if (color == Color.WHITE)
			return "\u2654";
		else if (color == Color.BLACK)
			return "\u265A";
		else {
			new Exception("Invalid color for king: " + color).printStackTrace();
			System.exit(-1);
		}
		
		return "";
		
	}
	
	@Override
	public ArrayList<Move> pseudoLegalMoves(Piece[][] board, Square square) {
		ArrayList<Move> moves = new ArrayList<Move>();
		
		int col = square.getCol();
		int row = square.getRow();
		
		Square[] targetSquares = new Square[]{new Square(col, row+1), new Square(col+1, row+1), new Square(col+1, row), new Square(col+1, row-1),
											  new Square(col, row-1), new Square(col-1, row-1), new Square(col-1, row), new Square(col-1, row+1)};
		
		for (Square targetSquare : targetSquares) {
			if (! targetSquare.isInBounds())
				continue;
			
			int targetCol = targetSquare.getCol();
			int targetRow = targetSquare.getRow();
			if (board[targetCol][targetRow] == null || board[targetCol][targetRow].getColor() != color) // target is empty or occupied by opponent
				moves.add(new Move(new Square(square), new Square(targetSquare)));

		}
		
		/*----- Castling -----*/
		// Kingside
		if (color == Color.WHITE) {
			if ((col == 4 && row == 0) && (board[5][0] == null) && (board[6][0] == null) && (board[7][0] instanceof Rook) && (board[7][0].getColor() == Color.WHITE)) {
				moves.add(new Move(new Square(square), new Square(6, 0), MoveEvent.CASTLES));
			}
		}
		else if (color == Color.BLACK) {
			if ((col == 4 && row == 7) && (board[5][7] == null) && (board[6][7] == null) && (board[7][7] instanceof Rook) && (board[7][7].getColor() == Color.BLACK)) {
				moves.add(new Move(new Square(square), new Square(6, 7), MoveEvent.CASTLES));
			}
		}
		// Queenside
		if (color == Color.WHITE) {
			if ((col == 4 && row == 0) && (board[3][0] == null) && (board[2][0] == null) && (board[1][0] == null) && (board[0][0] instanceof Rook) && (board[0][0].getColor() == Color.WHITE)) {
				moves.add(new Move(new Square(square), new Square(2, 0), MoveEvent.CASTLES));
			}
		}
		else if (color == Color.BLACK) {
			if ((col == 4 && row == 7) && (board[3][7] == null) && (board[2][7] == null) && (board[1][7] == null) && (board[0][7] instanceof Rook) && (board[0][7].getColor() == Color.BLACK)) {
				moves.add(new Move(new Square(square), new Square(2, 7), MoveEvent.CASTLES));
			}
		}
		
		
		return moves;
	}

	@Override
	public String toString() {
		return color + " king";
	}

}
