package chess;

import java.util.ArrayList;

public abstract class Piece {
	
	protected Color color;
	protected int value;
	
	public Piece(Color color) {
		this.color = color;
	}
	
	/**
	 * Generates a list of pseudo legal moves for the piece. A move if considered pseudo legal, if
	 * it is a move the piece could make regardless of whether:
	 *     - castling is not allowed
	 *     - it leaves the king in check
	 *     - en passent is not allowed
	 * @param position    The piece configuration of the current position
	 * @param square      Square that the piece is currently on
	 * @return ArrayList of pseudo legal moves
	 */
	public abstract ArrayList<Move> pseudoLegalMoves(Piece[][] board, Square square);
	
	public abstract String symbol();
	
	@Override
	public abstract String toString();
	
	public Color getColor() {
		return color;
	}
	
}
