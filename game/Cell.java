package game;

import java.awt.Graphics;
import java.util.HashMap;
import java.util.Map;

public class Cell {
	private int x, y;
	private Map<Character, Cell> neighbours = new HashMap<Character, Cell>();
	private Graphics g;
	private State currentState, nextState;
	
	public final static int size = 20;
	
	public Cell(int x, int y, State state, Graphics g) {
		this.x = x;
		this.y = y;
		this.currentState = state;
		this.g = g;
	}
	
	public void countAliveNeighbours() {
		
	}

	public void tick() {
		
	}
	
	public void render(Graphics g) {
		g.drawRect(x, y, size, size);
	}
	
	//LEFT TO DO: ADD HANDLER
}
