package chess;

import java.util.ArrayList;

import pieces.Bishop;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Queen;
import pieces.Rook;

public class Game {
	
	private Position position;
	private int turn;
	private Color toMove;
	private boolean whiteCastleKingside;
	private boolean whiteCastleQueenside;
	private boolean blackCastleKingside;
	private boolean blackCastleQueenside;
	
	public Game() {
		position = new Position();
		turn = 0;
		toMove = Color.WHITE;
		whiteCastleKingside = true;
		whiteCastleQueenside = true;
		blackCastleKingside = true;
		blackCastleQueenside = true;
		
		Piece[][] board = new Piece[8][8];
		
		board[0][0] = new Rook(Color.WHITE);
		board[1][0] = new Knight(Color.WHITE);
		board[2][0] = new Bishop(Color.WHITE);
		board[3][0] = new Queen(Color.WHITE);
		board[4][0] = new King(Color.WHITE);
		board[7][0] = new Rook(Color.WHITE);

		board[5][1] = new Pawn(Color.WHITE);
		board[6][1] = new Pawn(Color.WHITE);
		board[7][1] = new Pawn(Color.WHITE);
		
		board[0][6] = new Pawn(Color.BLACK);
		board[1][6] = new Pawn(Color.BLACK);
		board[2][6] = new Pawn(Color.BLACK);
		board[3][6] = new Pawn(Color.BLACK);
		board[4][6] = new Pawn(Color.BLACK);
		
		board[0][7] = new Rook(Color.BLACK);
		board[4][7] = new King(Color.BLACK);
		board[5][7] = new Bishop(Color.BLACK);
		board[6][7] = new Knight(Color.BLACK);
		board[7][7] = new Rook(Color.BLACK);
		
		position.setBoard(board);
		
		System.out.println(position);
		for (Move m : pseudoLegalMoves()) {
			System.out.println(m);
		}
	}
	
	public boolean move(Move m) {
		if (! legalMoves().contains(m))
			return false;
		
		return true;
	}
	
	private ArrayList<Move> legalMoves() {
		ArrayList<Move> moves = new ArrayList<Move>();
		
		return moves;
	}

	private ArrayList<Move> pseudoLegalMoves() {
		ArrayList<Move> moves = new ArrayList<Move>();
		
		Piece[][] board = position.getBoard();
		for (int i = 0; i < Position.BOARD_WIDTH; i++) {
			for (int j = 0; j < Position.BOARD_HEIGHT; j++) {
				if (board[i][j] != null && board[i][j].getColor() == toMove)
					moves.addAll(board[i][j].pseudoLegalMoves(board, new Square(i, j)));
			}
		}
		
		return moves;
	}
	
	
}
