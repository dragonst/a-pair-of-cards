import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Card extends JPanel{
	
	
	public JLabel iconHolder;
	public BufferedImage cardIcon;	 	 	
	String imageUrl;
	 
	 public Card(String iconFilePath) 
	 {
				 
		 try {
			    cardIcon = ImageIO.read(new File(iconFilePath));
			    imageUrl = iconFilePath;
			  
			} 
		 	catch (IOException e) {
		 				 	
			}			 
		 iconHolder = new JLabel(new ImageIcon(cardIcon.getScaledInstance(50, 50, Image.SCALE_DEFAULT)));		
		 
		 add(iconHolder);	 
		 setPreferredSize(new Dimension(60,80));	    
		 setBorder(BorderFactory.createLineBorder(Color.black, 3));	
	 }
	 
	
}