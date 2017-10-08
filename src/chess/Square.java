package chess;

public class Square {
	
	private int col;
	private int row;
	
	public Square(int col, int row) {
		this.col = col;
		this.row = row;
	}
	
	public Square(Square s) {
		this(s.col, s.row);
	}
	
	public int getRow() {
		return row;
	}
	
	public int getCol() {
		return col;
	}

	public boolean isInBounds() {
		if (col < 0 || col > Position.BOARD_WIDTH-1)
			return false;
		if (row < 0 || row > Position.BOARD_HEIGHT-1)
			return false;
		
		return true;
	}
	
	@Override
	public boolean equals(Object other) {
		if (other == null)
			return false;
		if (!(other instanceof Square))
			return false;
		
		Square otherSquare = (Square) other;
		if (otherSquare.row == row && otherSquare.col == col)
			return true;
		else
			return false;
	}
	
	@Override
	public String toString() {
		return "(" + col + "," + row + ")";
	}
	
}
