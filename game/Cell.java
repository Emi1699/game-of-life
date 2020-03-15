package game;

import java.awt.Color;
import java.awt.Graphics;
import java.util.HashMap;
import java.util.Map;

public class Cell {
	private int matX, matY; //cell's position in the matrix
	private Map<Character, Cell> neighbours = new HashMap<Character, Cell>();
	private Graphics g;
	private State currentState, nextState;
	
	public final static int size = 20;
	
	public Cell(int x, int y, Graphics g) {
		matX = x;
		matY = y;
		double rand = Math.random();
		if ( rand < 0.45 ) 
			currentState = State.ALIVE;
		else 
			currentState = State.DEAD;
		
		this.g = g;
	}
	
	public void countAliveNeighbours() {
		
	}

	public void tick() {
//		System.out.println(this.currentState);
		if (currentState == State.ALIVE)
			nextState = State.DEAD;
		else
			nextState = State.ALIVE;
	}
	
	public void render(Graphics g) {
		if (this.currentState == State.DEAD)
			g.setColor(Color.white);
		else
			g.setColor(Color.black);
		g.fillRect(matX * size, matY * size, size, size);
		currentState = nextState;
	}
	//LEFT TO DO: ADD HANDLER
}
