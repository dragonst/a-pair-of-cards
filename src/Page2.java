import java.awt.CardLayout;
import java.awt.Color;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Page2 {

	
    protected  JPanel container = new JPanel();
    public  JPanel container1 = new JPanel();
    public  JPanel container2 = new JPanel();
    protected  JLabel lifes = new JLabel("Lifes: 3");
    protected JLabel score = new JLabel("Score: 0");
    protected int lifes_int = 3;
    protected  int score_int = 0;
    protected boolean userCanClick = false;
    GridLayout innerGrid;
    public JButton button = new JButton("Memorized");
	JPanel buttonHolder = new JPanel();
	JPanel buttonHolder1 = new JPanel(new GridLayout(3,1));
	JFrame fr;
	Card card1;
	Card card2;
    Level currentLevel;
 
    JPanel pagesContainer_;
    CardLayout cardLayout_;
	List<Level> Levels = new LinkedList<Level>(Arrays.asList(new Level1(), new Level2()));
    
    public Page2(JPanel pagesContainer, CardLayout cardLayout,JFrame frame)
    {
    	pagesContainer_ = pagesContainer;
    	cardLayout_ = cardLayout;
    	fr = frame;
    	
    	 currentLevel = getRandomLevel(Levels);	
    	 
    	 innerGrid = new GridLayout(3,4);
	     innerGrid.setHgap(10);
	     innerGrid.setVgap(10);
	     container2.setLayout(innerGrid);
	     button.addActionListener(new AL());
	    
	   
	   	
	    for(int i = 0; i < currentLevel.Cards.length; i++)
	    {
	    	currentLevel.Cards[i].addMouseListener(new ML());
	    	container2.add(currentLevel.Cards[i]);	
	    	currentLevel.Cards[i].iconHolder.setVisible(true);
	    }
	    
	 	   	    
	   
	   container1.add(container2);
	   
	    container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
	   
	   buttonHolder1.add(button);
	   buttonHolder1.add(score);
	   buttonHolder1.add(lifes);
	   buttonHolder.add(buttonHolder1);
	   
	   
		
	    container.setBorder(BorderFactory.createEmptyBorder(50,  0, 0, 0));
	    container.add(container1);
	    container.add(buttonHolder);
	     
	    
	    pagesContainer.add(container);
    	cardLayout.addLayoutComponent(container, "Page2");
    	cardLayout.show(pagesContainer, "Page2");
	    
    }
    
    class AL implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
					
			userCanClick = true;
			button.setVisible(false);
			
			 for(int i = 0; i < currentLevel.Cards.length; i++)			    
			 {
				 currentLevel.Cards[i].iconHolder.setVisible(false);				
			 }				
		}		
	}
    
    class ML implements MouseListener, Runnable
	{
    	Thread t;
		@Override
		public void mouseClicked(MouseEvent arg0) {
			
			// TODO Auto-generated method stub
			if(userCanClick)
			{
			
				Card card =	(Card)arg0.getSource();
				
		        card.iconHolder.setVisible(true);
		    	
		    	if (card1 == null) 
		    		{
		    			
		    			card1 = card;
		    			card1.setBorder(BorderFactory.createLineBorder(Color.GREEN, 3));	
		    			
		    		}
			    else
			    	{			    	
			    		ML myRunnable = new ML();
			    		t = new Thread(myRunnable);		
			    	 	card2 = card;
			    	 	if (card1 == card2) return;
			    	 	if (card1.imageUrl != card2.imageUrl) card2.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
			    	 	else card2.setBorder(BorderFactory.createLineBorder(Color.GREEN, 3));
				    					    		 		   
				 		 t.start();		
				 		
			    	}	      	
			}
			
		    																			
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
		
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
				
				
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				
				e.printStackTrace();
			}
			
			
			if (card1.imageUrl == card2.imageUrl)
			{
				boolean cardsLeft = false;
				score_int += 100;
				score.setText("Score: " + score_int);
				for(int i = 0; i< container2.getComponentCount(); i++)
				  {
					if (container2.getComponent(i) == card1 )
					{	  						  						  					
						 container2.remove(card1);
			    		 
						 container2.add(new JPanel(), i);
						
					}	  				
					if (container2.getComponent(i) == card2)
					{
						container2.remove(card2);
			    		 
						container2.add(new JPanel(), i);
						
					}
								 		 
				 }		
				fr.setVisible(true);
				for(int j = 0; j< container2.getComponentCount(); j++)
				{
					if (container2.getComponent(j) instanceof Card)
					{
						
						//System.out.println(container2.getComponent(i));
						cardsLeft = true;													
					}					
				}
				if (cardsLeft == false)
				{
					
					Levels.remove(currentLevel);
					if(Levels.size() == 0)
					{
						
						new Page3(pagesContainer_,cardLayout_,score_int,fr);
						
					}
					else 
					{
						userCanClick = false;
						button.setVisible(true);
						currentLevel = getRandomLevel(Levels);
						
						container2.removeAll();
						 for(int k = 0; k < currentLevel.Cards.length; k++)
						    {
						    	currentLevel.Cards[k].addMouseListener(new ML());
						    	container2.add(currentLevel.Cards[k]);	
						    	currentLevel.Cards[k].iconHolder.setVisible(true);
						    }
						fr.setVisible(true);
					}
					
					
				}				
			}
			else 
			{			
				lifes_int -= 1;
				lifes.setText("Lifes: " + lifes_int);
				if (lifes_int == 0) 
				{
					userCanClick = false;
					//fr.remove(container);
					new Page3(pagesContainer_,cardLayout_, score_int,fr);
				}
				card1.iconHolder.setVisible(false);
	    		card2.iconHolder.setVisible(false);
	    		
	    	}
						
			fr.setVisible(true);
			card1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));	
    		card2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));	
    		card1 = null;
			card2 = null;
			
		}		
	}  
    
    Level getRandomLevel(List<Level> Level)
    {
    	int rnd = new Random().nextInt(Level.size());
        return Level.get(rnd);
    }
}
