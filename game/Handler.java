package game;

import java.awt.Graphics;
import java.util.LinkedList;


public class Handler {
	public LinkedList<Cell> cells = new LinkedList<Cell>();

	public void tick() {
		for (int i = 0; i < objects.size(); i++) {
			objects.get(i).tick();
		}
		
		for (int i = 0; i < bullets.size(); i++) {
			bullets.get(i).tick();
		}
	}

	public void render(Graphics g) {
		for (int i = 0; i < objects.size(); i++) {
			objects.get(i).render(g);
		}
		
		for (int i = 0; i < bullets.size(); i++) {
			bullets.get(i).render(g);
		}
	}
}
