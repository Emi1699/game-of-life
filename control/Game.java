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

	private Thread thread;
	private Handler handler;
	public Cell[][] grid = new Cell[Game.WIDTH / Cell.size][Game.HEIGHT / Cell.size];
	private boolean running = false;

	public static void main(String[] args) {
		Handler h = new Handler();
		new Game(h);
	}

	public Game(Handler h) {
		handler = h;
		for (int i = 0; i < HEIGHT/Cell.size; i++) {
			for (int j = 0; j < WIDTH/Cell.size; j++) {
				Cell cell = new Cell(j, i, g);
//				int aliveNs = countAliveNeighbours(j, i);
//				cell.setAliveNeighbours(aliveNs);
				handler.grid[j][i] = new Cell(j, i, g);
			}
		}
		
//		for (int i = 0; i < HEIGHT/Cell.size; i++) {
//			for (int j = 0; j < WIDTH/Cell.size; j++) {
//				aliveNbrs = handler.getAliveNeighbours();
//				grid[j][i].aliveNeighbours();
//			}
//		}
		
		
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
				Thread.sleep(750);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}

			frames++;

//			if (System.currentTimeMillis() - timer > 1000) {
//				timer += 1000;
//				System.out.println("FPS: " + frames);
//				frames = 0;
//			}

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

		drawGrid(g);

		handler.render(g);

		g.dispose();
		bs.show();
	}

	private void drawGrid(Graphics g) {
		g.setColor(rgbToColor(218, 165, 32)); // golden

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

	public static double clamp(double x, double min, double max) {
		if (x <= min)
			return x = min;
		else if (x > max)
			return x = max;
		else
			return x;
	}
}
