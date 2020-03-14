package control;

import java.awt.Graphics;
import java.util.LinkedList;

import game.Cell;

public class Handler {
	public Cell [][] grid = new Cell [Game.WIDTH/Cell.size][Game.HEIGHT/Cell.size]; 

	public void tick() {
		for (Cell [] row : grid) {
			for(Cell column : row) {
				column.tick();
			}
		}
	}

	public void render(Graphics g) {
		for (Cell [] row : grid) {
			for(Cell column : row) {
				column.render(g);
			}
		}
	}
	
	public Cell[][] getGrid() {
		return grid;
	}
	
	public static void main(String [] args) {
		Handler h = new Handler();
		System.out.println(h.grid[0].length);
	}
}
