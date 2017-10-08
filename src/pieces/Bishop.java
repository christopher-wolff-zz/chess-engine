package pieces;

import java.util.ArrayList;

import chess.Color;
import chess.Move;
import chess.Piece;
import chess.Position;
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
		else {
			new Exception("Invalid color for bishop: " + color).printStackTrace();
			System.exit(-1);
		}
		
		return "";	
	}

	public ArrayList<Move> pseudoLegalMoves(Piece[][] board, Square square) {
		ArrayList<Move> moves = new ArrayList<Move>();
		
		int col = square.getCol();
		int row = square.getRow();
		
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
		return color + " bishop";
	}
	
}
