package chess;

public class Move {
	
	private Piece piece;
	private Square originSquare;
	private Square destinSquare;
	private Piece promotion;
	private boolean enPassent;
	private boolean castlesKingside;
	private boolean castlesQueenside;
	
	public Move(Piece piece, Move other) {
		this.piece = piece;
		this.originSquare = other.originSquare;
		this.destinSquare = other.destinSquare;
		this.promotion = other.promotion;
		this.enPassent = other.enPassent;
		this.castlesKingside = other.castlesKingside;
		this.castlesQueenside = other.castlesQueenside;
	}
	
	public Move(Piece piece, Square originSquare, Square destinSquare) {
		this.piece = piece;
		this.originSquare = originSquare;
		this.destinSquare = destinSquare;
	}
	
	public Move(Piece piece, Square originSquare, Square destinSquare, Piece promotion) {
		this.piece = piece;
		this.originSquare = originSquare;
		this.destinSquare = destinSquare;
		this.promotion = promotion;
	}
	
	public Move(Piece piece, Square originSquare, Square destinSquare, MoveEvent moveEvent) {
		this.piece = piece;
		this.originSquare = originSquare;
		this.destinSquare = destinSquare;
		
		if (moveEvent == MoveEvent.EN_PASSENT)
			this.enPassent = true;
		else if (moveEvent == MoveEvent.CASTLES_KINGSIDE)
			this.castlesKingside = true;
		else if (moveEvent == MoveEvent.CASTLES_QUEENSIDE)
			this.castlesQueenside = true;
	}
	
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		
		s.append(piece.symbol() + originSquare + "-" + destinSquare);
		if (promotion != null)
			s.append(" = " + promotion);
		if (enPassent)
			s.append(" en passent");
		if (castlesKingside)
			s.append(" castles kingside");
		if (castlesQueenside)
			s.append(" castles queenside");
		
		return s.toString();
	}
	
	public Piece getPiece() {
		return piece;
	}
	
	public Square getOriginSquare() {
		return originSquare;
	}
	
	public Square getDestinSquare() {
		return destinSquare;
	}
	
	public Piece getPromotion() {
		return promotion;
	}
	
	public boolean isEnPassent() {
		return enPassent;
	}
	
	public boolean isCastlesKingside() {
		return castlesKingside;
	}
	
	public boolean isCastlesQueenside() {
		return castlesQueenside;
	}
	
}
