package control;

import java.awt.Graphics;
import java.util.LinkedList;

import game.Cell;

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
	
	public static void main(String [] args) {
	}
}
