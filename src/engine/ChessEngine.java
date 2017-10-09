package engine;

import java.util.ArrayList;

import chess.Color;
import chess.Game;

public class ChessEngine {
	
	private int n;
	
	public ChessEngine() {
		
	}
	
	public int minimax(Game g, int alpha, int beta, int maxDepth) {
		n++;
		
		// Check if depth limit is reached
		if (g.getDepth() > maxDepth)
			return g.eval();
		
		// Check if leaf node is reached
		ArrayList<Game> children = g.children();
		if (children == null) {
			if (g.isInCheck(g.getToMove())) // Checkmate
				return -10000*g.getToMove();
			else // Stalemate
				return 0;
		}
		
		// Initialize best move for root
		if (g.getDepth() == 1)
			g.setBestMove(children.get(0).getLastMove());
		
		// Maximizer
		if (g.getToMove() == Color.WHITE) {
			for (Game child : children) {
				int result = minimax(child, alpha, beta, maxDepth);
				if (result > alpha) {
					alpha = result;
					if (g.getDepth() == 1) {
						g.setBestMove(child.getLastMove());
					}
				}
				if (alpha >= beta) {
					
					return alpha;
				}
			}
			return alpha;
		}
		
		// Minimizer
		if (g.getToMove() == Color.BLACK) {
			for (Game child : children) {
				int result = minimax(child, alpha, beta, maxDepth);
				if (result < beta) {
					beta = result;
					if (g.getDepth() == 1) {
						g.setBestMove(child.getLastMove());
					}
				}
				if (beta <= alpha)
					return beta;
			}
			return beta;
		}
		
		System.out.println("Minimax returned 0 unexpectedly at depth " + g.getDepth());
		return 0;
	}
	
	public int getN() {
		return n;
	}
	
	public void setN(int n) {
		this.n = n;
	}
	
}
