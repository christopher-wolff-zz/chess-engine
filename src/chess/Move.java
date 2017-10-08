package chess;

public class Move {
	
	private Square originSquare;
	private Square destinSquare;
	private Piece promotion;
	private boolean enPassent;
	private boolean castles;
	
	public Move(Square originSquare, Square destinSquare) {
		this.originSquare = originSquare;
		this.destinSquare = destinSquare;
	}
	
	public Move(Square originSquare, Square destinSquare, Piece promotion) {
		this.originSquare = originSquare;
		this.destinSquare = destinSquare;
		this.promotion = promotion;
	}
	
	public Move(Square originSquare, Square destinSquare, MoveEvent moveEvent) {
		this.originSquare = originSquare;
		this.destinSquare = destinSquare;
		
		if (moveEvent == MoveEvent.EN_PASSENT)
			this.enPassent = true;
		else if (moveEvent == MoveEvent.CASTLES)
			this.castles = true;
	}
	
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		
		s.append(originSquare + "-" + destinSquare);
		if (promotion != null)
			s.append(" = " + promotion);
		if (enPassent)
			s.append(" en passent");
		if (castles)
			s.append(" castles");
		
		return s.toString();
	}
	
}
