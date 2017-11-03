package main;

import java.util.ArrayList;
import java.util.Random;

import chess.Color;
import chess.Game;
import chess.Move;
import engine.ChessEngine;

public class Test {

	public static void main(String[] args) {
		Game g = new Game();
		ChessEngine ce = new ChessEngine();
		
		int depth = 5;
		
		while (true) {
			// Check if game is over
			ArrayList<Move> legalMoves = g.legalMoves();
			if (legalMoves.size() == 0) {
				if (g.isInCheck(g.getToMove()))
					System.out.println(Color.colorToString(-g.getToMove()) + " wins!");
				else
					System.out.println("Stalemate!");
				break;
			}
			
			// Print turn info
			System.out.println("Turn " + g.getTurn() + " - " + Color.colorToString(g.getToMove()) + " to move");
			System.out.println("Eval: " + g.eval());
			System.out.println(g.getPosition());
			
			// White makes smart moves
			if (g.getToMove() == Color.WHITE) {
				long startTime = System.currentTimeMillis();
				ce.minimax(g, -Integer.MAX_VALUE, Integer.MAX_VALUE, depth);
				long deltaTime = System.currentTimeMillis() - startTime;
				System.out.println("Best move: " + g.getBestMove());
				System.out.println("n = " + ce.getN());
				System.out.println("t = " + deltaTime/1000 + "s");
				g.move(g.getBestMove());
			}
			// Black makes random moves
			else if (g.getToMove() == Color.BLACK) {
				int randomNum = new Random().nextInt(legalMoves.size());
				Move randomMove = legalMoves.get(randomNum);
				System.out.println("Random move: " + randomMove);
				g.move(randomMove);
			}
			System.out.println("====================");
			
			// Reset counters
			ce.setN(0);
			g.setDepth(1);
		}
	}

}
