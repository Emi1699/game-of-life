package game;

import control.Game;

public class Pattern {
	public Cell [][] grid = new Cell [Game.HEIGHT/Cell.size][Game.WIDTH/Cell.size]; 
	
	public Pattern(String patternName) {
		for (int i = 0; i < Game.HEIGHT/Cell.size; i++) {
			for (int j = 0; j < Game.WIDTH/Cell.size; j++) {
				grid[i][j] = new Cell(i, j);
			}
		}
		
		if (patternName.equals("gosperglider")) {
			int initialY = grid.length / 4;
			int initialX = grid[0].length / 4;
			
			grid[initialY][initialX].setState(State.ALIVE);
			grid[initialY][initialX + 1].setState(State.ALIVE);
			grid[initialY + 1][initialX].setState(State.ALIVE);
			grid[initialY + 1][initialX + 1].setState(State.ALIVE);
			
			grid[initialY][initialX + 10].setState(State.ALIVE);
			grid[initialY + 1][initialX + 10].setState(State.ALIVE);
			grid[initialY + 2][initialX + 10].setState(State.ALIVE);
			
//			grid[initialY - 1][initialX + 11].setState(State.ALIVE);
//			grid[initialY + 3][initialX + 11].setState(State.ALIVE);
//			
			grid[initialY - 2][initialX + 12].setState(State.ALIVE);
			grid[initialY + 4][initialX + 12].setState(State.ALIVE);
//			
//			grid[initialY - 2][initialX + 13].setState(State.ALIVE);
//			grid[initialY + 4][initialX + 13].setState(State.ALIVE);
//			
//			grid[initialY + 1][initialX + 14].setState(State.ALIVE);
//			
//			grid[initialY - 1][initialX + 15].setState(State.ALIVE);
//			grid[initialY + 3][initialX + 15].setState(State.ALIVE);
//			
//			grid[initialY][initialX + 16].setState(State.ALIVE);
//			grid[initialY + 1][initialX + 16].setState(State.ALIVE);
//			grid[initialY + 2][initialX + 16].setState(State.ALIVE);
//			
//			grid[initialY + 1][initialX + 17].setState(State.ALIVE);
//			
//			grid[initialY][initialX + 20].setState(State.ALIVE);
//			grid[initialY - 1][initialX + 20].setState(State.ALIVE);
//			grid[initialY - 2][initialX + 20].setState(State.ALIVE);
//			
//			grid[initialY][initialX + 21].setState(State.ALIVE);
//			grid[initialY - 1][initialX + 21].setState(State.ALIVE);
//			grid[initialY - 2][initialX + 21].setState(State.ALIVE);
//			
//			grid[initialY - 3][initialX + 22].setState(State.ALIVE);
//			grid[initialY + 1][initialX + 22].setState(State.ALIVE);
//			
//			grid[initialY - 3][initialX + 24].setState(State.ALIVE);
//			grid[initialY - 4][initialX + 24].setState(State.ALIVE);
//			grid[initialY + 1][initialX + 24].setState(State.ALIVE);
//			grid[initialY + 2][initialX + 24].setState(State.ALIVE);
//			
//			grid[initialY - 1][initialX + 34].setState(State.ALIVE);
//			grid[initialY - 2][initialX + 34].setState(State.ALIVE);
//			
//			grid[initialY - 1][initialX + 35].setState(State.ALIVE);
//			grid[initialY - 2][initialX + 35].setState(State.ALIVE);
		}
	}
	
	public Cell[][] getPattern() {
		return this.grid;
	}
	
}
