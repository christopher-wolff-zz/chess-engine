package chess;

import pieces.Bishop;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Queen;
import pieces.Rook;

public class Position {
	
	public static final int BOARD_WIDTH = 8;
	public static final int BOARD_HEIGHT = 8;
	
	private Piece[][] board;
	
	public Position(Piece[][] board) {
		this.board = board;
	}
	
	public Position() {
		this.board = defaultBoard();
	}
	
	private Piece[][] defaultBoard() {
		Piece[][] board = new Piece[Position.BOARD_HEIGHT][Position.BOARD_WIDTH];
		
		board[0][0] = new Rook(Color.WHITE);
		board[1][0] = new Knight(Color.WHITE);
		board[2][0] = new Bishop(Color.WHITE);
		board[3][0] = new Queen(Color.WHITE);
		board[4][0] = new King(Color.WHITE);
		board[5][0] = new Bishop(Color.WHITE);
		board[6][0] = new Knight(Color.WHITE);
		board[7][0] = new Rook(Color.WHITE);
		
		board[0][1] = new Pawn(Color.WHITE);
		board[1][1] = new Pawn(Color.WHITE);
		board[2][1] = new Pawn(Color.WHITE);
		board[3][1] = new Pawn(Color.WHITE);
		board[4][1] = new Pawn(Color.WHITE);
		board[5][1] = new Pawn(Color.WHITE);
		board[6][1] = new Pawn(Color.WHITE);
		board[7][1] = new Pawn(Color.WHITE);
		
		board[0][6] = new Pawn(Color.BLACK);
		board[1][6] = new Pawn(Color.BLACK);
		board[2][6] = new Pawn(Color.BLACK);
		board[3][6] = new Pawn(Color.BLACK);
		board[4][6] = new Pawn(Color.BLACK);
		board[5][6] = new Pawn(Color.BLACK);
		board[6][6] = new Pawn(Color.BLACK);
		board[7][6] = new Pawn(Color.BLACK);
		
		board[0][7] = new Rook(Color.BLACK);
		board[1][7] = new Knight(Color.BLACK);
		board[2][7] = new Bishop(Color.BLACK);
		board[3][7] = new Queen(Color.BLACK);
		board[4][7] = new King(Color.BLACK);
		board[5][7] = new Bishop(Color.BLACK);
		board[6][7] = new Knight(Color.BLACK);
		board[7][7] = new Rook(Color.BLACK);
		
		return board;
	}
	
	public Piece[][] getBoard() {
		return board;
	}
	
	public void setBoard(Piece[][] board) {
		this.board = board;
	}
	
	@Override
	public String toString() {
		StringBuilder posStr = new StringBuilder();
		for (int i = BOARD_HEIGHT-1; i >= 0; i--) {
			for (int j = 0; j < BOARD_WIDTH; j++) {
				Piece p = board[j][i];
				if (p != null)
					posStr.append(p.symbol());
				else
					posStr.append("\u3000"); // Full-width space character
				
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
