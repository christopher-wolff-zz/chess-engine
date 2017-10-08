package chess;

import pieces.Bishop;
import pieces.Blank;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Queen;
import pieces.Rook;

public abstract class Piece {
	
	public static final Piece BLANK = new Blank(Color.NONE);
	public static final Piece WHITE_PAWN = new Pawn(Color.WHITE);
	public static final Piece WHITE_KNIGHT = new Knight(Color.WHITE);
	public static final Piece WHITE_BISHOP = new Bishop(Color.WHITE);
	public static final Piece WHITE_ROOK = new Rook(Color.WHITE);
	public static final Piece WHITE_QUEEN = new Queen(Color.WHITE);
	public static final Piece WHITE_KING = new King(Color.WHITE);
	public static final Piece BLACK_PAWN = new Pawn(Color.BLACK);
	public static final Piece BLACK_KNIGHT = new Knight(Color.BLACK);
	public static final Piece BLACK_BISHOP = new Bishop(Color.BLACK);
	public static final Piece BLACK_ROOK = new Rook(Color.BLACK);
	public static final Piece BLACK_QUEEN = new Queen(Color.BLACK);
	public static final Piece BLACK_KING = new King(Color.BLACK);
	
	protected Color color;
	protected int value;
	
	public Piece(Color color) {
		this.color = color;
	}
	
	@Override
	public abstract String toString();
	
}
