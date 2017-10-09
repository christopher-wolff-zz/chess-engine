package chess;

public final class Color {
	
	public static final int WHITE = 1;
	public static final int BLACK = -1;
	public static final int NONE = 0;
	
	public static String colorToString(int color) {
		if (color == WHITE)
			return "White";
		else if (color == BLACK)
			return "Black";
		else
			return "None";
	}
	
}
