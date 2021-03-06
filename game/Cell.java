package game;

import java.awt.Color;
import java.awt.Graphics;
import java.util.HashMap;
import java.util.Map;

public class Cell {
	private int matJ, matI; //cell's position in the grid
	private int aliveNeighbours;
	private Graphics g;
	private State currentState, nextState;
	
	public static final int size = 5;
	private static final double aliveRatio = 0.3;
	
	public Cell(int y, int x, Graphics g) {
		matI = y;
		matJ = x;
		double rand = Math.random();
		if ( rand < aliveRatio ) 
			currentState = State.ALIVE;
		else 
			currentState = State.DEAD;
		
		this.g = g;
	}
	
	public Cell(int y, int x) {
		matI = y;
		matJ = x;
	}

	public State getState() {
		return this.currentState;
	}
	
	public void setState(State state) {
		this.currentState = state;
	}
	

	public void tick(int aliveNeighbours) {
		
//		System.out.println(this.currentState);
		if (currentState == State.ALIVE && (aliveNeighbours == 2 || aliveNeighbours == 3)) {
			nextState = State.ALIVE;
		}
		else if (currentState == State.DEAD && aliveNeighbours == 3) {
			nextState = State.ALIVE;
		} else {
			nextState = State.DEAD;
		}
	}
	
	//RULES!!!!
//	Any live cell with two or three neighbors survives.
//	Any dead cell with three live neighbors becomes a live cell.
//	All other live cells die in the next generation. Similarly, all other dead cells stay dead.
	
	public void render(Graphics g) {
		if (this.currentState == State.DEAD)
			g.setColor(Color.black);
		else
			g.setColor(Color.orange);
		
		if (g.getColor() == Color.white) {
			g.fillRect(matJ * size, matI * size, size, size);
		} else {
			g.fillRect(matJ * size, matI * size, size, size);
		}
		currentState = nextState;
	}
	//LEFT TO DO: ADD HANDLER
}
