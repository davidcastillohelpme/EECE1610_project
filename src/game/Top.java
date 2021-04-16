package game;
import java.awt.*;
import javax.swing.JFrame;


public class Top extends JFrame{

	public static void main(String[] args) {
		
		DisplayMode dm = new DisplayMode(800, 600, 16, DisplayMode.REFRESH_RATE_UNKNOWN);
		Top t=new Top(); 
		t.run(dm);

	}
	
	public void run(DisplayMode dm) {
		getContentPane().setBackground(Color.GREEN);
		setForeground(Color.WHITE);
		//setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		
		Screen s= new Screen();
		try {
			s.setFullScreen(dm,this);
			
			try {
				Thread.sleep(5000);
			}catch(Exception ex){}
			
		}finally {
			s.restoreScreen();
		}
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		if(g instanceof Graphics2D) {
			Graphics2D g2 = (Graphics2D)g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		}
		Font cs0 = new Font("Comic Sans MS", Font.PLAIN, 30);
		g.setFont(cs0);
		g.drawString("Welcome to THE GAME",640,400);
		Font cs1 = new Font("Comic Sans MS", Font.PLAIN, 18);
		g.setFont(cs1);
		g.drawString("A EECE 1610 Project by \n David Castillo\n Patrick Brayden Singer\n and Patrick McKeever", 440,450);
		g.drawString("You should probably press start right here", 440,450);
	}

}
