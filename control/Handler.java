package control;

import java.awt.Graphics;
import java.util.LinkedList;

import game.Cell;

public class Handler {
	public Cell [][] grid = new Cell [Game.WIDTH/Cell.size][Game.HEIGHT/Cell.size]; 

	public void tick() {
		for (Cell [] row : grid) {
			for(Cell column : row) {
				System.out.println(column);
			}
		}
	}

	public void render(Graphics g) {
		for (Cell [] row : grid) {
			for(Cell column : row) {
				System.out.println(column);
			}
		}
	}
}
