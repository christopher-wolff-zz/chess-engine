
public class Piece {

  private static final int NO_TYPE = 0;
  private static final int PAWN = 1;
  private static final int KNIGHT = 2;
  private static final int BISHOP = 3;
  private static final int ROOK = 4;
  private static final int QUEEN = 5;
  private static final int KING = 6;

  private static final String NO_SYMBOL = " ";
  private static final String WHITE_PAWN_SYMBOL = "\u2659";
  private static final String WHITE_KNIGHT_SYMBOL = "\u2658";
  private static final String WHITE_BISHOP_SYMBOL = "\u2657";
  private static final String WHITE_ROOK_SYMBOL = "\u2656";
  private static final String WHITE_QUEEN_SYMBOL = "\u2655";
  private static final String WHITE_KING_SYMBOL = "\u2654";
  private static final String BLACK_PAWN_SYMBOL = "\u265F";
  private static final String BLACK_KNIGHT_SYMBOL = "\u265E";
  private static final String BLACK_BISHOP_SYMBOL = "\u265D";
  private static final String BLACK_ROOK_SYMBOL = "\u265C";
  private static final String BLACK_QUEEN_SYMBOL = "\u265B";
  private static final String BLACK_KING_SYMBOL = "\u265A";

  private static final int NO_TYPE_VALUE = 0;
  private static final int PAWN_VALUE = 1;
  private static final int KNIGHT_VALUE = 3;
  private static final int BISHOP_VALUE = 3;
  private static final int ROOK_VALUE = 5;
  private static final int QUEEN_VALUE = 9;
  private static final int KING_VALUE = 1000;

  private static final int BLACK = -1;
  private static final int NO_COLOR = 0;
  private static final int WHITE = 1;

  private int type;
  private int color;
  private String symbol;

  public Piece(int type, int color) {
    this.type = type;
    this.color = color;

    generateSymbol();
  }

  public Piece() {
    type = NO_TYPE;
    color = NO_COLOR;

    generateSymbol();
  }

  /**
  * Generates the unicode symbol representation of the piece.
  */
  public void generateSymbol() {
    if(color == NO_COLOR)
      symbol = NO_SYMBOL;
    else if(color == WHITE && type == PAWN)
      symbol = WHITE_PAWN_SYMBOL;
    else if(color == WHITE && type == KNIGHT)
      symbol = WHITE_KNIGHT_SYMBOL;
    else if(color == WHITE && type == BISHOP)
      symbol = WHITE_BISHOP_SYMBOL;
    else if(color == WHITE && type == ROOK)
      symbol = WHITE_ROOK_SYMBOL;
    else if(color == WHITE && type == QUEEN)
      symbol = WHITE_QUEEN_SYMBOL;
    else if(color == WHITE && type == KING)
      symbol = WHITE_KING_SYMBOL;
    else if(color == BLACK && type == PAWN)
      symbol = BLACK_PAWN_SYMBOL;
    else if(color == BLACK && type == KNIGHT)
      symbol = BLACK_KNIGHT_SYMBOL;
    else if(color == BLACK && type == BISHOP)
      symbol = BLACK_BISHOP_SYMBOL;
    else if(color == BLACK && type == ROOK)
      symbol = BLACK_ROOK_SYMBOL;
    else if(color == BLACK && type == QUEEN)
      symbol = BLACK_QUEEN_SYMBOL;
    else if(color == BLACK && type == KING)
      symbol = BLACK_KING_SYMBOL;
  }

  /**
  * Returns the numeric value of the piece.
  */
  public int value() {
    switch(type) {
      case NO_TYPE:
        return NO_TYPE_VALUE;
      case PAWN:
        return PAWN_VALUE;
      case KNIGHT:
        return KNIGHT_VALUE;
      case BISHOP:
        return BISHOP_VALUE;
      case ROOK:
        return ROOK_VALUE;
      case QUEEN:
        return QUEEN_VALUE;
      case KING:
        return KING_VALUE;
      default:
        System.out.println("Invalid piece type " + type);
        return 0;
    }
  }

  public int getType() {
    return type;
  }

  public int getColor() {
    return color;
  }

  public String getSymbol() {
    return symbol;
  }

  @Override
  public String toString() {
    return symbol;
  }

}
