package game;
import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;


public class Top extends JFrame{

	public static void main(String[] args) {
		
		DisplayMode dm = new DisplayMode(800, 600, 16, DisplayMode.REFRESH_RATE_UNKNOWN); //get specs from computer
		Top t=new Top(); 
		t.run(dm);

	}
	
	//runs actual shit
	public void run(DisplayMode dm) {
		getContentPane().setBackground(Color.GREEN);//sets universal backgroun
		setForeground(Color.WHITE); //sets univerisal foreground
		//setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		
		Screen s= new Screen();
		try {
			s.setFullScreen(dm,this); //sets up start screen with specs dm
			
			try {
				Thread.sleep(5000);
			}catch(Exception ex){}
			
		}finally {
			s.restoreScreen();
		}
	}
	
	//puts stuff onto start screen
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
		g.drawString("A EECE 1610 Project by David Castillo, Patrick Brayden Singer, and Patrick McKeever", 440,450);
		g.drawString("You should probably press start right here", 440,500);//numbers means pixels
		
		//add a button to continue to game
		JPanel panel1;
		JButton button1;
		panel1= new JPanel();
		button1= new JButton("HERE");
		button1.addActionListener(new Listener());
		panel1.add(button1, BorderLayout.CENTER);
		
		
	}
	
	private int count;
	//these are class for listener and returns true if clicked, thus going on
	public boolean NextScene(boolean click) {
		
	}
	private class Listener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			this.count=1;
		}
	}

}
