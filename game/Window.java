package game;

import java.awt.Dimension;
import javax.swing.JFrame;

public class Window {

	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;

	public Window(int width, int height, String title, Game game) {
		JFrame frame = new JFrame(title);
		
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		//frame.setUndecorated(true);  //only the game is displayed, no 'exit', 'minimise' buttons at the top
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(game);
		frame.setVisible(true);
		game.start();
	}
}
