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
	
	private String letterOf(int column) {
		switch (column) {
		case 0:
			return "A";
		case 1:
			return "B";
		case 2:
			return "C";
		case 3:
			return "D";
		case 4:
			return "E";
		case 5:
			return "F";
		case 6:
			return "G";
		case 7:
			return "H";
		default:
			new Exception("Letter not found for column " + column).printStackTrace();
			System.exit(-1);
		}
		return "";
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
		return letterOf(col) + (row+1);
	}
	
}
