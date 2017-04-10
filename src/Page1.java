
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class Page1 {
	
	JPanel container = new JPanel();
    JPanel panel = new JPanel();
    JButton startButton = new JButton("New Game");
    JPanel buttonHolder = new JPanel();
    JLabel iconHolder;
	BufferedImage gameImage;	 	 	
	
    
    public Page1(JPanel pagesContainer, CardLayout cardLayout,JFrame frame)
    {
    	
		 
		 try {
			 gameImage = ImageIO.read(new File("assets\\gameImage.png"));
			  			  
			} 
		 	catch (IOException e) {
		 				 	
			}			 
		 iconHolder = new JLabel(new ImageIcon(gameImage));		
		 
		 
    	
    	
    	
    	 container.setLayout(new GridLayout(3,1));	     
	     panel.setPreferredSize(new Dimension(600,150));
	     panel.setLayout(new FlowLayout(FlowLayout.CENTER));
	     buttonHolder.setBorder(BorderFactory.createEmptyBorder(50,  0, 0, 0));
	     buttonHolder.add(startButton);
	     panel.add(buttonHolder);

	     
	     
	     container.add(new JPanel());
	     container.add(iconHolder); 
	     
	     container.add(panel);
    	
    	
    	pagesContainer.add(container);
    	cardLayout.addLayoutComponent(container, "Page1");
    	cardLayout.show(pagesContainer, "Page1");
    	
    	
    	 startButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new Page2(pagesContainer,cardLayout,frame);
			}});
    	    		   
    }
}
