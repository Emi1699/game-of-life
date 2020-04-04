package control;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferStrategy;

import game.Cell;
import game.State;

public class Game extends Canvas implements Runnable {
	public static final int WIDTH = 1000, HEIGHT = 800;

	public Graphics g;
	
	private int simulationSpeed = 1000;
	private Thread thread;
	private Handler handler;
	private boolean running = false;
	private boolean gridCheck = false;

	public static void main(String[] args) {
		Handler h = new Handler();
		new Game(h);
	}

	public Game(Handler h) {
		handler = h;
		for (int i = 0; i < HEIGHT/Cell.size; i++) {
			for (int j = 0; j < WIDTH/Cell.size; j++) {
				handler.grid[i][j] = new Cell(i, j, g);
				if (handler.grid[i][j].getState() == State.ALIVE)
					System.out.print(1 + " ");
				else
					System.out.print(0 + " "); 
			}
			System.out.println();
		}
		
		new Window(WIDTH, HEIGHT, "Game of Life", this);
	}

	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}

	public synchronized void stop() {
		try {
			thread.join();
			running = false;
			System.out.println("Simulation has finished running");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// THE GAME LOOP
	@SuppressWarnings("unused")
	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 120.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick(); // update game states for every object
				delta--;
			}

			if (running)
				render(); // render every object in the game
			try {
				Thread.sleep(simulationSpeed);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			frames++;
		}
		stop();
	}

	private void tick() {
		handler.tick();
	}

	private void render() {
		BufferStrategy bs = this.getBufferStrategy();

		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		
		
		if (!gridCheck) {
			drawGrid(g);
			gridCheck = true;
		}

		handler.render(g);

		g.dispose();
		bs.show();
	}

	private void drawGrid(Graphics g) {
		g.setColor(Color.black); // golden

		for (int k = 0; k < WIDTH; k += Cell.size) {
			g.drawLine(k, 0, k, HEIGHT);
			g.drawLine(0, k, WIDTH, k);
		}

	}

	private Color rgbToColor(int r, int g, int b) {
		float[] rgbValues = new float[3];
		rgbValues = Color.RGBtoHSB(218, 165, 32, rgbValues);
		Color c = (Color.getHSBColor(rgbValues[0], rgbValues[1], rgbValues[2]));

		return c;
	}
}
