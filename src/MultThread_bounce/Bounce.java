package MultThread_bounce;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Bounce {
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable(){

			@Override
			public void run() {
				JFrame frame = new BounceFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
			
		});
	}
}

/**
 * the frame with ball component and buttons.
 * @author sj
 *
 */
class BounceFrame extends JFrame{
	private BallComponent comp;
	private static final int STEPS = 1000;
	private static final int DELAY = 3;
	/**
	 * Constructs the frame with the component for showing the bouncing ball and Start and Close
	 */
	public BounceFrame(){
		setTitle("Bounce");
		
		comp = new BallComponent();
		add(comp, BorderLayout.CENTER);
		JPanel buttonPanel = new JPanel();
		addButton(buttonPanel,"Start", new ActionListener(){
			public void actionPerformed(ActionEvent event){
				addBall();
			}
		});
		
		addButton(buttonPanel, "Close", new ActionListener(){
			public void actionPerformed(ActionEvent event){
				System.exit(0);
			}
		});
		add(buttonPanel, BorderLayout.SOUTH);
	}
	//ActionListener: A listener interface for receiving action event;
	//Container :A generic Abstract Window Toolkit(AWT) container object is a component* that can contain other AWT components.
	public void addButton(Container c, String title, ActionListener listener){
		JButton button = new JButton(title);
		c.add(button);
		button.addActionListener(listener);
	}
	public void addBall(){
		Ball ball = new Ball();
		comp.add(ball);
		
		for(int i=1; i<=STEPS; i++){
			ball.move(comp.getBounds());
			comp.paint(comp.getGraphics());
			try {
				Thread.sleep(DELAY);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}