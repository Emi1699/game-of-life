package control;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import game.Cell;
import game.Neighbour;

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
	
	private int getAliveNeighbours(Map<Neighbour, Cell> neighbours) {
		int aliveNeighbours = Collections.frequency(new ArrayList<Cell>(neighbours.values().), "Red");
		
		
		return aliveNeighbours;
	}
	
	private Cell [] getNeighbours(int x, int y) {
		ArrayList<Cell> neighbours = null;
		if (x == 0) {
			if (y == 0) {
				neighbours.add(grid[x][y + 1]);
				neighbours.add(grid[x + 1][y]);
				neighbours.add(grid[x + 1][y + 1]);
			} else if (y == grid.length - 2) {
				neighbours.add(grid[x][y -1]);
				neighbours.add(grid[x + 1][y]);
				neighbours.add(grid[x + 1][y -1]);
			} else {
				neighbours.add(grid[x][y - 1]);
				neighbours.add(grid[x +  1][y - 1]);
				neighbours.add(grid[x + 1][y]);
				neighbours.add(grid[x + 1][y + 1]);
				neighbours.add(grid[x][y + 1]);

			}
		}
		
		return null;
	}
	
	
	public static void main(String [] args) {
		Cell cell = new Cell(0, 0, null);
		cell.
	}
}
