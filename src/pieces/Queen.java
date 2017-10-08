package pieces;

import java.util.ArrayList;

import chess.Color;
import chess.Move;
import chess.Piece;
import chess.Position;
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
		else {
			new Exception("Invalid color for queen: " + color).printStackTrace();
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
				moves.add(new Move(new Square(square), new Square(col, targetRow)));
			}
			else {
				if (board[col][targetRow].getColor() != color)
					moves.add(new Move(new Square(square), new Square(col, targetRow)));
				break;
			}
		}
		
		// Backward - row decreasing
		for (int targetRow = row-1; targetRow >= 0; targetRow--) {
			if (board[col][targetRow] == null) {
				moves.add(new Move(new Square(square), new Square(col, targetRow)));
			}
			else {
				if (board[col][targetRow].getColor() != color)
					moves.add(new Move(new Square(square), new Square(col, targetRow)));
				break;
			}
		}
		
		// Right - column increasing
		for (int targetCol = col+1; targetCol < Position.BOARD_WIDTH; targetCol++) {
			if (board[targetCol][row] == null) {
				moves.add(new Move(new Square(square), new Square(targetCol, row)));
			}
			else {
				if (board[targetCol][row].getColor() != color)
					moves.add(new Move(new Square(square), new Square(targetCol, row)));
				break;
			}
		}
		
		// Left - column decreasing
		for (int targetCol = col-1; targetCol >= 0; targetCol--) {
			if (board[targetCol][row] == null) {
				moves.add(new Move(new Square(square), new Square(targetCol, row)));
			}
			else {
				if (board[targetCol][row].getColor() != color)
					moves.add(new Move(new Square(square), new Square(targetCol, row)));
				break;
			}
		}
		
		// Right and up diagonal - column increasing and row increasing
		for (int targetCol = col+1, targetRow = row+1; targetCol < Position.BOARD_WIDTH && targetRow < Position.BOARD_HEIGHT; targetCol++, targetRow++) {
			if (board[targetCol][targetRow] == null) {
				moves.add(new Move(new Square(square), new Square(targetCol, targetRow)));
			}
			else {
				if (board[targetCol][targetRow].getColor() != color)
					moves.add(new Move(new Square(square), new Square(targetCol, targetRow)));
				break;
			}
		}
			
		// Right and down diagonal - column increasing and row decreasing
		for (int targetCol = col+1, targetRow = row-1; targetCol < Position.BOARD_WIDTH && targetRow >= 0; targetCol++, targetRow--) {
			if (board[targetCol][targetRow] == null) {
				moves.add(new Move(new Square(square), new Square(targetCol, targetRow)));
			}
			else {
				if (board[targetCol][targetRow].getColor() != color)
					moves.add(new Move(new Square(square), new Square(targetCol, targetRow)));
				break;
			}
		}
		
		// Left and up diagonal - column decreasing and row increasing
		for (int targetCol = col-1, targetRow = row+1; targetCol >= 0 && targetRow < Position.BOARD_HEIGHT; targetCol--, targetRow++) {
			if (board[targetCol][targetRow] == null) {
				moves.add(new Move(new Square(square), new Square(targetCol, targetRow)));
			}
			else {
				if (board[targetCol][targetRow].getColor() != color)
					moves.add(new Move(new Square(square), new Square(targetCol, targetRow)));
				break;
			}
		}
		
		// Left and down diagonal - column decreasing and row decreasing
		for (int targetCol = col-1, targetRow = row-1; targetCol >= 0 && targetRow >= 0; targetCol--, targetRow--) {
			if (board[targetCol][targetRow] == null) {
				moves.add(new Move(new Square(square), new Square(targetCol, targetRow)));
			}
			else {
				if (board[targetCol][targetRow].getColor() != color)
					moves.add(new Move(new Square(square), new Square(targetCol, targetRow)));
				break;
			}
		}
		
		return moves;
	}

	@Override
	public String toString() {
		return color + " queen on";
	}

}
