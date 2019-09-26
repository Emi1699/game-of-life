package game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {
	public static final int WIDTH = 800, HEIGHT = 650;

	public Graphics g;

	private Thread thread;
	private Handler handler;
	private boolean running = false;

	public Game() {
		new Window(WIDTH, HEIGHT, "Game of Life", this);
	}

	public static void main(String[] args) {
		new Game();
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
		double amountOfTicks = 60.0;
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
			frames++;

//			if (System.currentTimeMillis() - timer > 1000) {
//				timer += 1000;
//				System.out.println("FPS: " + frames);
//				frames = 0;
//			}

			// System.out.println(handler.bullets.size());
		}
		stop();
	}

	private void tick() {
		// handler.tick();
	}

	private void render() {
		BufferStrategy bs = this.getBufferStrategy();

		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}

		g = bs.getDrawGraphics();

		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);

		drawGrid(g);

		// handler.render();

		g.dispose();
		bs.show();
	}

	private void drawGrid(Graphics g) {
								// golden
		g.setColor(rgbToColor(218, 165, 32));

		for (int k = 10; k < WIDTH; k += Cell.size) {
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
