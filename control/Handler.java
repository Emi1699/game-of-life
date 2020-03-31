package control;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import game.Cell;
import game.Neighbour;
import game.State;

public class Handler {
	public Cell [][] grid = new Cell [Game.WIDTH/Cell.size][Game.HEIGHT/Cell.size]; 

	public void tick() {
		for (int i = 0; i < Game.WIDTH/Cell.size; i++) {
			for (int j = 0; j < Game.HEIGHT/Cell.size; j++) {
				grid[i][j].tick();
			}
		}
//		System.out.println("TICK1");
	}

	public void render(Graphics g) {
		for (int i = 0; i < Game.WIDTH/Cell.size; i++) {
			for (int j = 0; j < Game.HEIGHT/Cell.size; j++) {
				grid[i][j].render(g);
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
		ArrayList<Cell> neighbours = null;
		if (x == 0) {
			if (y == 0) {
				neighbours.add(grid[x][y + 1]);
				neighbours.add(grid[x + 1][y]);
				neighbours.add(grid[x + 1][y + 1]);
			} else if (y == grid.length - 1) {
				neighbours.add(grid[x][y - 1]);
				neighbours.add(grid[x + 1][y]);
				neighbours.add(grid[x + 1][y - 1]);
			} else {
				neighbours.add(grid[x][y - 1]);
				neighbours.add(grid[x +  1][y - 1]);
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
