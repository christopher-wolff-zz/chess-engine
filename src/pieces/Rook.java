package pieces;

import java.util.ArrayList;

import chess.Color;
import chess.Move;
import chess.Piece;
import chess.Position;
import chess.Square;

public class Rook extends Piece {

	public Rook(int color) {
		super(color);
		value = 5;
	}
	
	public Rook(Piece other) {
		super(other);
		value = 5;
	}

	public String symbol() {
		if (color == Color.WHITE)
			return "\u2656";
		else if (color == Color.BLACK)
			return "\u265C";
		else {
			new Exception("Invalid color for rook: " + color).printStackTrace();
			System.exit(-1);
		}
		
		return "";
	}

	public ArrayList<Move> pseudoLegalMoves(Piece[][] board, Square square) {
		ArrayList<Move> moves = new ArrayList<Move>();
		
		int col = square.getCol();
		int row = square.getRow();
		
		// Forward - row increasing
		for (int targetRow = row+1; targetRow < Position.BOARD_HEIGHT; targetRow++) {
			if (board[col][targetRow] == null) {
				moves.add(new Move(this, new Square(square), new Square(col, targetRow)));
			}
			else {
				if (board[col][targetRow].getColor() != color)
					moves.add(new Move(this, new Square(square), new Square(col, targetRow)));
				break;
			}
		}
		
		// Backward - row decreasing
		for (int targetRow = row-1; targetRow >= 0; targetRow--) {
			if (board[col][targetRow] == null) {
				moves.add(new Move(this, new Square(square), new Square(col, targetRow)));
			}
			else {
				if (board[col][targetRow].getColor() != color)
					moves.add(new Move(this, new Square(square), new Square(col, targetRow)));
				break;
			}
		}
		
		// Right - column increasing
		for (int targetCol = col+1; targetCol < Position.BOARD_WIDTH; targetCol++) {
			if (board[targetCol][row] == null) {
				moves.add(new Move(this, new Square(square), new Square(targetCol, row)));
			}
			else {
				if (board[targetCol][row].getColor() != color)
					moves.add(new Move(this, new Square(square), new Square(targetCol, row)));
				break;
			}
		}
		
		// Left - column decreasing
		for (int targetCol = col-1; targetCol >= 0; targetCol--) {
			if (board[targetCol][row] == null) {
				moves.add(new Move(this, new Square(square), new Square(targetCol, row)));
			}
			else {
				if (board[targetCol][row].getColor() != color)
					moves.add(new Move(this, new Square(square), new Square(targetCol, row)));
				break;
			}
		}
		
		return moves;
	}

	@Override
	public String toString() {
		return color + " rook";
	}

}
