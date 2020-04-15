package control;

import java.awt.Graphics;
import java.util.ArrayList;

import game.Cell;
import game.Neighbour;
import game.State;

public class Handler {
	public Cell [][] grid = new Cell [Game.HEIGHT/Cell.size][Game.WIDTH/Cell.size]; 

	public void tick() {
		for (int i = 0; i < Game.HEIGHT/Cell.size; i++) {
			for (int j = 0; j < Game.WIDTH/Cell.size; j++) {
				int aliveNeighbours = getAliveNeighbours(getNeighbours(i, j));
				grid[i][j].tick(aliveNeighbours);
			}
		}
//		System.out.println("TICK1");
	}

	public void render(Graphics g) {
		for (int i = 0; i < Game.HEIGHT/Cell.size; i++) {
			for (int j = 0; j < Game.WIDTH/Cell.size; j++) {
				grid[i][j].render(g);
			}
		}
	}
	
	public Cell[][] getGrid() {
		return grid;
	}
	
	public void setGrid(Cell[][] grid) {
		this.grid = grid;
	}
	
	private int getAliveNeighbours(ArrayList<Cell> neighbours) {
		int aliveN = 0;
		for (Cell neighbour : neighbours) {
			if (neighbour.getState() == State.ALIVE) {
				aliveN += 1;
			}
		}
		
		return aliveN;
	}
	
	private ArrayList<Cell> getNeighbours(int i, int j) {
		ArrayList<Cell> neighbours = new ArrayList<Cell>();
		
		if (i == 0 && j == 0) { //upper left
			neighbours.add(grid[i][j + 1]);
			neighbours.add(grid[i + 1][j + 1]);
			neighbours.add(grid[i + 1][j]);
		} else if (i == 0 && j == grid[0].length - 1) { //upper right
			neighbours.add(grid[i][j - 1]);
			neighbours.add(grid[i + 1][j - 1]);
			neighbours.add(grid[i + 1][j]);
		} else if (i == grid.length -  1 && j == 0) { //lower left 
			neighbours.add(grid[i - 1][j]);
			neighbours.add(grid[i - 1][j + 1]);
			neighbours.add(grid[i][j+1]);
		} else if (i == grid.length - 1 && j == grid[0].length - 1) { //lower right
			neighbours.add(grid[i - 1][j - 1]);
			neighbours.add(grid[i - 1][j]);
			neighbours.add(grid[i][j - 1]);
		} else if (j == 0) { //right margin
			neighbours.add(grid[i - 1][j]);
			neighbours.add(grid[i - 1][j + 1]);
			neighbours.add(grid[i][j + 1]);
			neighbours.add(grid[i + 1][j + 1]);
			neighbours.add(grid[i + 1][j]);
		} else if (j == grid[0].length - 1) { //left margin
			neighbours.add(grid[i - 1][j]);
			neighbours.add(grid[i - 1][j - 1]);
			neighbours.add(grid[i][j - 1]);
			neighbours.add(grid[i + 1][j - 1]);
			neighbours.add(grid[i - 1][j]);
		} else if (i == 0) { //top margin
			neighbours.add(grid[i][j - 1]);
			neighbours.add(grid[i][j + 1]);
			neighbours.add(grid[i + 1][j - 1]);
			neighbours.add(grid[i + 1][j]);
			neighbours.add(grid[i + 1][j + 1]);
		} else if (i == grid.length - 1) { //bottom margin
			neighbours.add(grid[i][j - 1]);
			neighbours.add(grid[i][j + 1]);
			neighbours.add(grid[i - 1][j - 1]);
			neighbours.add(grid[i - 1][j]);
			neighbours.add(grid[i - 1][j + 1]);
		} else { //cell has neighbours all around it
			neighbours.add(grid[i - 1][j - 1]);
			neighbours.add(grid[i - 1][j]);
			neighbours.add(grid[i - 1][j + 1]);
			neighbours.add(grid[i][j - 1]);
			neighbours.add(grid[i][j + 1]);
			neighbours.add(grid[i + 1][j - 1]);
			neighbours.add(grid[i + 1][j]);
			neighbours.add(grid[i + 1][j + 1]);
		}
				
		return neighbours;
	}
	
	
//	public static void main(String [] args) {
//		Cell cell = new Cell(0, 0, null);
//		cell.
//	}
}
