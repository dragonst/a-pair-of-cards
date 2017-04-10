
import java.awt.CardLayout;


import javax.swing.*;



public class Game {
		
	JFrame frame = new JFrame();
    JPanel pagesContainer = new JPanel();
    CardLayout cardLayout = new CardLayout();	 
    
	public Game() {
	        		 	     		   
		pagesContainer.setLayout(cardLayout);
					      
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    new Page1(pagesContainer,cardLayout,frame);
	    frame.add(pagesContainer);	       
	    frame.pack();
	    
	    frame.setVisible(true);
	    	    
	    }
	
	 public static void main(String[] args) {
	        
		 new Game();
		
	    }	 	
}
