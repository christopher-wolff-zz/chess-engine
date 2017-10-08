package chess;

public class Position {
	
	public static final int BOARD_WIDTH = 8;
	public static final int BOARD_HEIGHT = 8;
	
	private Piece[][] board;
	
	public Position(Piece[][] board) {
		this.board = board;
	}
	
	public Position() {
		this.board = defaultPieceConfiguration();
	}
	
	private Piece[][] defaultPieceConfiguration() {
		Piece[][] p = {{Piece.WHITE_ROOK, Piece.WHITE_KNIGHT, Piece.WHITE_BISHOP, Piece.WHITE_QUEEN, Piece.WHITE_KING, Piece.WHITE_BISHOP, Piece.WHITE_KNIGHT, Piece.WHITE_ROOK},
					   {Piece.WHITE_PAWN, Piece.WHITE_PAWN,   Piece.WHITE_PAWN,   Piece.WHITE_PAWN,  Piece.WHITE_PAWN, Piece.WHITE_PAWN,   Piece.WHITE_PAWN,   Piece.WHITE_PAWN},
					   {Piece.BLANK,      Piece.BLANK,        Piece.BLANK,        Piece.BLANK,       Piece.BLANK,      Piece.BLANK,        Piece.BLANK,        Piece.BLANK     },
					   {Piece.BLANK,      Piece.BLANK,        Piece.BLANK,        Piece.BLANK,       Piece.BLANK,      Piece.BLANK,        Piece.BLANK,        Piece.BLANK     },
					   {Piece.BLANK,      Piece.BLANK,        Piece.BLANK,        Piece.BLANK,       Piece.BLANK,      Piece.BLANK,        Piece.BLANK,        Piece.BLANK     },
					   {Piece.BLANK,      Piece.BLANK,        Piece.BLANK,        Piece.BLANK,       Piece.BLANK,      Piece.BLANK,        Piece.BLANK,        Piece.BLANK     },
					   {Piece.BLACK_PAWN, Piece.BLACK_PAWN,   Piece.BLACK_PAWN,   Piece.BLACK_PAWN,  Piece.BLACK_PAWN, Piece.BLACK_PAWN,   Piece.BLACK_PAWN,   Piece.BLACK_PAWN},
					   {Piece.BLACK_ROOK, Piece.BLACK_KNIGHT, Piece.BLACK_BISHOP, Piece.BLACK_QUEEN, Piece.BLACK_KING, Piece.BLACK_BISHOP, Piece.BLACK_KNIGHT, Piece.BLACK_ROOK},};
		return p;
	}
	
	@Override
	public String toString() {
		StringBuilder posStr = new StringBuilder();
		for (int i = BOARD_HEIGHT-1; i >= 0; i--) {
			for (int j = 0; j < BOARD_WIDTH; j++) {
				posStr.append(board[i][j].toString()); // Full-width chess piece characters
				if (j != BOARD_WIDTH-1)
					posStr.append("|"); // Half-width separator
				else
					posStr.append("\n");
			}
			if (i != 0) {
				for (int j = 0; j < BOARD_WIDTH; j++) {
					posStr.append("\uFF0D"); // Full-width separator
					if (j != BOARD_WIDTH-1)
						posStr.append("-"); // Half-width separator
					else
						posStr.append("\n");
				}
			}
		}
		return posStr.toString();
	}
	
}
