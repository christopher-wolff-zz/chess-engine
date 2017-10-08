package chess;

import java.util.ArrayList;
import java.util.Random;

import pieces.Pawn;

public class Game implements Cloneable {
	
	private Position position;
	private int turn;
	private int toMove;
	private Move lastMove;
	
	private boolean whiteCastlesKingside;
	private boolean whiteCastlesQueenside;
	private boolean blackCastlesKingside;
	private boolean blackCastlesQueenside;
	
	public Game() {
		position = new Position();
		turn = 1;
		toMove = Color.WHITE;
		lastMove = null;
		
		whiteCastlesKingside = true;
		whiteCastlesQueenside = true;
		blackCastlesKingside = true;
		blackCastlesQueenside = true;
	}
	
	public Game(Position position, int turn, int toMove, Move lastMove, boolean whiteCastlesKingside, boolean whiteCastlesQueenside, boolean blackCastlesKingside, boolean blackCastlesQueenside) {
		this.position = position;
		this.turn = turn;
		this.toMove = toMove;
		this.lastMove = lastMove;
		
		this.whiteCastlesKingside = whiteCastlesKingside;
		this.whiteCastlesQueenside = whiteCastlesQueenside;
		this.blackCastlesKingside = blackCastlesKingside;
		this.blackCastlesQueenside = blackCastlesQueenside;
	}
	
	public void playRandomGame() {
		while (! isOver() && turn < 100) {
			System.out.println("Turn " + turn + ": ");
			System.out.println(position);
			
			ArrayList<Move> lms = legalMoves();
			if (lms.size() == 0) {
				if (isInCheck(toMove)) {
					if (toMove == Color.WHITE) {
						System.out.println("Black wins");
						return;
					}
					else if (toMove == Color.BLACK) {
						System.out.println("White wins");
						return;
					}
				}
				else
					System.out.println("Stalemate");
				break;
			}
			Move nextMove = lms.get(new Random().nextInt(lms.size()));
			
			System.out.println("Move: " + lastMove);
			System.out.println();
			
			move(nextMove);
		}
		System.out.println("Draw");
	}
	
	public void move(Move m) {
		Piece[][] board = position.getBoard();
		
		// Remove original piece
		Piece p = board[m.getOriginSquare().getCol()][m.getOriginSquare().getRow()];
		board[m.getOriginSquare().getCol()][m.getOriginSquare().getRow()] = null;
		
		// Add piece to destination square
		if (m.getPromotion() != null)
			board[m.getDestinSquare().getCol()][m.getDestinSquare().getRow()] = m.getPromotion();
		else
			board[m.getDestinSquare().getCol()][m.getDestinSquare().getRow()] = p;
		
		// Handle en passent
		if (m.isEnPassent()) {
			if (m.getOriginSquare().getRow() == 4) // white captures black
				board[m.getDestinSquare().getCol()][m.getDestinSquare().getRow()-1] = null;
			else { // black captures white
				board[m.getDestinSquare().getCol()][m.getDestinSquare().getRow()+1] = null;
			}
		}
		
		// Handle castles
		if (m.isCastlesKingside()) {
			if (toMove == Color.WHITE) {
				// Move rook to the correct place
				Piece rook = board[7][0];
				board[7][0] = null;
				board[5][0] = rook;
			}
			else {
				// Move rook to the correct place
				Piece rook = board[7][7];
				board[7][7] = null;
				board[5][7] = rook;
			}
			whiteCastlesKingside = false;
			whiteCastlesQueenside = false;
		}
		else if (m.isCastlesQueenside()) {
			if (toMove == Color.WHITE) {
				// Move rook to the correct place
				Piece rook = board[0][0];
				board[0][0] = null;
				board[3][0] = rook;
			}
			else {
				// Move rook to the correct place
				Piece rook = board[0][7];
				board[0][7] = null;
				board[3][7] = rook;
			}
			blackCastlesKingside = false;
			blackCastlesQueenside = false;
		}
		
		// Update
		lastMove = m;
		if (toMove == Color.WHITE)
			toMove = Color.BLACK;
		else {
			toMove = Color.WHITE;
			turn++;
		}
	}
	
	private ArrayList<Move> legalMoves() {
		ArrayList<Move> moves = new ArrayList<Move>();
		
		outer:
		for (Move m : semiLegalMoves()) {
			// Handle castling through check - TODO: clean up
			if (m.isCastlesKingside()) {
				Move testMove;
				if (toMove == Color.WHITE) {
					testMove = new Move(new Square(4, 0), new Square(5, 0)); // king moves one square to the right
				}
				else {
					testMove = new Move(new Square(4, 7), new Square(5, 7)); // king moves one square to the right
				}
				try {
					Game continuation = (Game) this.clone();
					continuation.move(testMove);
					if (continuation.isInCheck(toMove))
						continue outer;
				}
				catch (CloneNotSupportedException e) {
					e.printStackTrace();
				}
			}
			else if (m.isCastlesQueenside()) {
				Move[] testMoves = new Move[2];
				if (toMove == Color.WHITE) {
					testMoves[0] = new Move(new Square(4, 0), new Square(3, 0)); // king moves one square to the left
					testMoves[1] = new Move(new Square(4, 0), new Square(2, 0)); // king moves two squares to the left
				}
				else {
					testMoves[0] = new Move(new Square(4, 7), new Square(3, 7)); // king moves one square to the left
					testMoves[1]= new Move(new Square(4, 7), new Square(2, 7)); // king moves two squares to the left
				}
				try {
					for (Move m1 : testMoves) {
						Game continuation = (Game) this.clone();
						continuation.move(m1);
						for (Move m2 : continuation.semiLegalMoves()) {
							Game possibleGame = (Game) continuation.clone();
							possibleGame.move(m2);
							if (continuation.isInCheck(toMove))
								continue outer;
						}
					}
				}
				catch (CloneNotSupportedException e) {
					e.printStackTrace();
				}
			}
			
			// Handle checks
			try {
				Game continuation = (Game) this.clone();
				continuation.move(m);
				for (Move m2 : continuation.semiLegalMoves()) {
					Game possibleGame = (Game) continuation.clone();
					possibleGame.move(m2);
					if (toMove == -possibleGame.winner()) 
						continue outer;
				}
			}
			catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
			
			moves.add(m);
			
		}
		
		return moves;
	}
	
	private ArrayList<Move> semiLegalMoves() {
		ArrayList<Move> moves = new ArrayList<Move>();
		
		Piece[][] board = position.getBoard();
		
		for (Move m : pseudoLegalMoves()) {
			// Handle illegal castling and castling through check
			if (m.isCastlesKingside()) {
				if ((toMove == Color.WHITE && whiteCastlesKingside == false) || (toMove == Color.BLACK && blackCastlesKingside == false))
					continue;
			}
			else if (m.isCastlesQueenside()) {
				if ((toMove == Color.WHITE && whiteCastlesQueenside == false) || (toMove == Color.BLACK && blackCastlesQueenside == false))
					continue;
			}
			
			// Handle illegal en passent
			if (m.isEnPassent()) {
				if (toMove == Color.WHITE) {
					if (!(lastMove.getDestinSquare().getCol() == m.getDestinSquare().getCol()
						  && lastMove.getDestinSquare().getRow() == m.getDestinSquare().getRow()-1
						  && board[lastMove.getDestinSquare().getCol()][lastMove.getDestinSquare().getRow()] instanceof Pawn))
						continue;
				}
				else if (toMove == Color.BLACK) {
					if (!(lastMove.getDestinSquare().getCol() == m.getDestinSquare().getCol()
						  && lastMove.getDestinSquare().getRow() == m.getDestinSquare().getRow()+1
						  && board[lastMove.getDestinSquare().getCol()][lastMove.getDestinSquare().getRow()] instanceof Pawn))
						continue;
				}
			}
			
			moves.add(m);
			
		}
		
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
	
	public int winner() {
		if (position.value() > 1000)
			return Color.WHITE;
		if (position.value() < -1000)
			return Color.BLACK;
		return Color.NONE;
	}
	
	public boolean isInCheck(int c) {
		try {
			Game continuation = (Game) this.clone();
			continuation.setToMove(-c);
			for (Move m2 : continuation.semiLegalMoves()) {
				Game possibleGame = (Game) continuation.clone();
				possibleGame.move(m2);
				if (toMove == -possibleGame.winner()) 
					return true;
			}
		}
		catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean isOver() {
		if (winner() == 0)
			return false;
		else
			return true;
	}
	
	public Position getPosition() {
		return position;
	}

	public int getTurn() {
		return turn;
	}

	public int getToMove() {
		return toMove;
	}

	public Move getLastMove() {
		return lastMove;
	}

	public boolean isWhiteCastlesKingside() {
		return whiteCastlesKingside;
	}

	public boolean isWhiteCastlesQueenside() {
		return whiteCastlesQueenside;
	}

	public boolean isBlackCastlesKingside() {
		return blackCastlesKingside;
	}

	public boolean isBlackCastlesQueenside() {
		return blackCastlesQueenside;
	}
	
	public void setToMove(int c) {
		toMove = c;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		if (this.getLastMove() != null)
			return new Game(new Position(this.getPosition()), this.getTurn(), this.getToMove(), this.getLastMove(),
					        this.isWhiteCastlesKingside(), this.isWhiteCastlesQueenside(), this.isBlackCastlesKingside(), this.isBlackCastlesQueenside());
		else
			return new Game(new Position(this.getPosition()), this.getTurn(), this.getToMove(), null,
			        this.isWhiteCastlesKingside(), this.isWhiteCastlesQueenside(), this.isBlackCastlesKingside(), this.isBlackCastlesQueenside());

	}
	
}
