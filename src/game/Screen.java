package game;
import java.awt.*;
import javax.swing.JFrame;

public class Screen {
	
	private GraphicsDevice vc;
	//this class sets up a starting screen. aka makes sure its actually full screen and gets your specs
	public Screen() {
		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		vc=env.getDefaultScreenDevice();
	}
	
	public void setFullScreen(DisplayMode dm, JFrame window) {
		window.setUndecorated(true);
		window.setResizable(true);
		vc.setFullScreenWindow(window);
		
		if(dm != null && vc.isDisplayChangeSupported()) {
			try {
				vc.setDisplayMode(dm);
			}catch(Exception ex){}
		}
	}
	
	public Window getFullScreenWindow() {
		return vc.getFullScreenWindow();
	}
	
	public void restoreScreen() {
		Window w = vc.getFullScreenWindow();		
		if(w!=null) {
			w.dispose();
		}		
		vc.setFullScreenWindow(null);
	}
	
}
