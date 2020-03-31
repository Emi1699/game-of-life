package control;

import java.awt.Graphics;
import java.util.ArrayList;

import game.Cell;
import game.Neighbour;
import game.State;

public class Handler {
	public Cell [][] grid = new Cell [Game.WIDTH/Cell.size][Game.HEIGHT/Cell.size]; 

	public void tick() {
		for (int i = 0; i < Game.HEIGHT/Cell.size; i++) {
			for (int j = 0; j < Game.WIDTH/Cell.size; j++) {
				int aliveNeighbours = getAliveNeighbours(getNeighbours(j, i));
				grid[j][i].tick(aliveNeighbours);
			}
		}
//		System.out.println("TICK1");
	}

	public void render(Graphics g) {
		for (int i = 0; i < Game.HEIGHT/Cell.size; i++) {
			for (int j = 0; j < Game.WIDTH/Cell.size; j++) {
				grid[j][i].render(g);
			}
		}
	}
	
	public Cell[][] getGrid() {
		return grid;
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
	
	private ArrayList<Cell> getNeighbours(int x, int y) {
		ArrayList<Cell> neighbours = new ArrayList<Cell>();
		if (x == 0) {
			if (y == 0) {
				System.out.println(grid[x][y + 1]);
				neighbours.add(grid[x][y + 1]);
				neighbours.add(grid[x + 1][y]);
				neighbours.add(grid[x + 1][y + 1]);
			} else if (y == grid.length - 1) {
				neighbours.add(grid[x][y - 1]);
				neighbours.add(grid[x + 1][y]);
				neighbours.add(grid[x + 1][y - 1]);
			} else {
				neighbours.add(grid[x][y - 1]);
				neighbours.add(grid[x + 1][y - 1]);
				neighbours.add(grid[x + 1][y]);
				neighbours.add(grid[x + 1][y + 1]);
				neighbours.add(grid[x][y + 1]);
			}
		} else if (x == grid[0].length - 1) {
			if (y == 0) {
				neighbours.add(grid[x - 1][y]);
				neighbours.add(grid[x - 1][y + 1]);
				neighbours.add(grid[x][y + 1]);
			} else if (y == grid.length - 1) {
				neighbours.add(grid[x - 1][y - 1]);
				neighbours.add(grid[x - 1][y]);
				neighbours.add(grid[x][y - 1]);
			} else {
				neighbours.add(grid[x][y - 1]);
				neighbours.add(grid[x - 1][y - 1]);
				neighbours.add(grid[x - 1][y]);
				neighbours.add(grid[x - 1][y + 1]);
				neighbours.add(grid[x][y + 1]);
			}
		} else if (y == 0) {
			neighbours.add(grid[x - 1][y + 1]);
			neighbours.add(grid[x][y + 1]);
			neighbours.add(grid[x - 1][y]);
			neighbours.add(grid[x + 1][y]);
			neighbours.add(grid[x + 1][y + 1]);
		} else if (y == grid.length - 1) {
			neighbours.add(grid[x - 1][y]);
			neighbours.add(grid[x - 1][y - 1]);
			neighbours.add(grid[x][y - 1]);
			neighbours.add(grid[x + 1][y - 1]);
			neighbours.add(grid[x + 1][y]);
		} else {
			neighbours.add(grid[x - 1][y - 1]);
			neighbours.add(grid[x - 1][y]);
			neighbours.add(grid[x - 1][y + 1]);
			neighbours.add(grid[x][y - 1]);
			neighbours.add(grid[x][y + 1]);
			neighbours.add(grid[x + 1][y - 1]);
			neighbours.add(grid[x + 1][y]);
			neighbours.add(grid[x + 1][y + 1]);
		}
		
		return neighbours;
	}
	
	
//	public static void main(String [] args) {
//		Cell cell = new Cell(0, 0, null);
//		cell.
//	}
}
