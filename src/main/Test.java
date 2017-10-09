package main;

import chess.Game;

public class Test {

	public static void main(String[] args) {
		Game g = new Game();
		g.minimax(2, -2, 5);
		System.out.println(g.getBestMove());
	}

}
