import java.awt.BorderLayout;
import java.awt.CardLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.BorderFactory;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Page3 {

	public JPanel container = new JPanel(new BorderLayout());
	JPanel buttonHolder = new JPanel();
	JButton button = new JButton("New Game");
	
	
	public Page3(JPanel pagesContainer, CardLayout cardLayout,int score_int,JFrame frame)
	{
	
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				new Page2(pagesContainer,cardLayout,frame);
				
				
			}});
		
		JLabel jl = new JLabel("SCORE: "+score_int);
		
		jl.setFont(jl.getFont().deriveFont(64f));
		
		jl.setHorizontalAlignment(SwingConstants.CENTER);
		
		container.add(jl,BorderLayout.CENTER);
		
		buttonHolder.setBorder(BorderFactory.createEmptyBorder(0,  0, 50, 0));
		
		buttonHolder.add(button);
		
		container.add(buttonHolder,BorderLayout.SOUTH);
		
		 pagesContainer.add(container);
	     cardLayout.addLayoutComponent(container, "Page3");
	     cardLayout.show(pagesContainer, "Page3");
	}
}
