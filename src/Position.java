
import java.lang.StringBuilder;

import Piece;

public class Position {

  private static final Piece WHITE_PAWN, WHITE_KNIGHT, WHITE_BISHOP, WHITE_ROOK, WHITE_QUEEN, WHITE_KING,
                             BLACK_PAWN, BLACK_KNIGHT, BLACK_BISHOP, BLACK_ROOK, BLACK_QUEEN, BLACK_KING, NONE;
  private static final int BOARD_WIDTH = 8;
  private static final int BOARD_HEIGHT = 8;

  private Piece[][] pieces; // Indices: Letter, then number

  public Position(Piece[][] pieces) {
    initPieces();
    this.pieces = pieces;
  }

  public Position() {
    initPieces();
    this.pieces = defaultPieceConfiguration();
  }

  private void initPieces() {
    WHITE_PAWN = new Piece(PAWN, WHITE);
    WHITE_KNIGHT = new Piece(KNIGHT, WHITE);
    WHITE_BISHOP = new Piece(BISHOP, WHITE);
    WHITE_ROOK = new Piece(ROOK, WHITE);
    WHITE_QUEEN = new Piece(QUEEN, WHITE);
    WHITE_KING = new Piece(KING, WHITE);
    BLACK_PAWN = new Piece(PAWN, BLACK);
    BLACK_KNIGHT = new Piece(KNIGHT, BLACK);
    BLACK_BISHOP = new Piece(BISHOP, BLACK);
    BLACK_ROOK = new Piece(ROOK, BLACK);
    BLACK_QUEEN = new Piece(QUEEN, BLACK);
    BLACK_KING = new Piece(KING, BLACK);
    NONE = new Piece(NO_TYPE, NO_COLOR);
  }

  private Piece[][] defaultPieceConfiguration() {
    return {{WHITE_ROOK, WHITE_KNIGHT, WHITE_BISHOP, WHITE_QUEEN, WHITE_KING, WHITE_BISHOP, WHITE_KNIGHT, WHITE_ROOK},
            {WHITE_PAWN, WHITE_PAWN,   WHITE_PAWN,   WHITE_PAWN,  WHITE_PAWN, WHITE_PAWN,   WHITE_PAWN,   WHITE_PAWN},
            {NONE,       NONE,         NONE,         NONE,        NONE,       NONE,         NONE,         NONE},
            {NONE,       NONE,         NONE,         NONE,        NONE,       NONE,         NONE,         NONE},
            {NONE,       NONE,         NONE,         NONE,        NONE,       NONE,         NONE,         NONE},
            {NONE,       NONE,         NONE,         NONE,        NONE,       NONE,         NONE,         NONE},
            {BLACK_PAWN, BLACK_PAWN,   BLACK_PAWN,   BLACK_PAWN,  BLACK_PAWN, BLACK_PAWN,   BLACK_PAWN,   BLACK_PAWN},
            {BLACK_ROOK, BLACK_KNIGHT, BLACK_BISHOP, BLACK_QUEEN, BLACK_KING, BLACK_BISHOP, BLACK_KNIGHT, BLACK_ROOK}};
  }

  @Override
  public String toString() {
    StringBuilder posStr = new StringBuilder("");
    for(int i = 0; i < BOARD_HEIGHT; i++) {
      for(int j = 0; j < BOARD_WIDTH; j++) {
        posStr.append(pieces[i][j].toString());
        if(j != BOARD_WIDTH-1)
          posStr.append("|");
        else
          posStr.append("\n");
      }
      if(i != BOARD_HEIGHT-1)
        posStr.append("---------------\n");
    }
    return posStr.toString();
  }

}
