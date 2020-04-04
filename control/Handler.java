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
		
		
		return neighbours;
	}
	
	
//	public static void main(String [] args) {
//		Cell cell = new Cell(0, 0, null);
//		cell.
//	}
}
