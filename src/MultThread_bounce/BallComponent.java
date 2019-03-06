package MultThread_bounce;

import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.*;
import javax.swing.JPanel;

public class BallComponent extends JPanel{
	/**
	 * the component that draw the balls.
	 */
	private static final int DEFAULE_WIDTH = 450;
	private static final int DEFAULT_LENGTH = 350;
	
	private java.util.List<Ball> balls = new ArrayList<>();
	/**
	 * Add a ball to the component
	 */
	public void add(Ball b){
		balls.add(b);
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		for(Ball b : balls){
			g2.fill(b.getShape());
		}
	}
}
