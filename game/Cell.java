package game;

import java.awt.Color;
import java.awt.Graphics;
import java.util.HashMap;
import java.util.Map;

public class Cell {
	private int matX, matY; //cell's position in the grid
	private int aliveNeighbours;
	private Graphics g;
	private State currentState, nextState;
	
	public static final int size = 20;
	
	public Cell(int x, int y, Graphics g) {
		matX = x;
		matY = y;
		double rand = Math.random();
		if ( rand < 0.43 ) 
			currentState = State.ALIVE;
		else 
			currentState = State.DEAD;
		
		this.g = g;
	}
	
	public void aliveNeighbours (int aN) {
		aliveNeighbours = aN;
	}
	
	public State getState() {
		return this.currentState;
	}
	

	public void tick(int aliveNeighbours) {
		
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
		g.fillRect(matX * size + 1, matY * size - 1, size - 1, size - 1);
		currentState = nextState;
	}
	//LEFT TO DO: ADD HANDLER
}
