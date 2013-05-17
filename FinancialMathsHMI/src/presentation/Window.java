package presentation;

import java.awt.*;
import java.util.LinkedList;

import javax.swing.*;

public class Window extends JFrame{
	//hesite pas à mettre des noms plus explicite
	
	private JPanel p=new JPanel();
	private JPanel west=new JPanel();
	private JPanel center=new JPanel();
	
	private JTextField e1=new JTextField("");
	private JTextField e2=new JTextField("");
	private JTextField e3=new JTextField("");
	
	private JButton ok=new JButton("Submit");
	private LinkedList<JLabel> result=new LinkedList<JLabel>();
	private Rectangle dimension=GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
	
	public Window() throws HeadlessException {
		super("Mais qu'est-ce que tu fais là, Quentin Noharet?");
		for(int i=0;i<12;i++){
			result.add(new JLabel("Resultat "+(i+1)));
		}
		
		Container g = this.getContentPane();
		g.add(p);
		p.setLayout(new BorderLayout());
		p.add(west,BorderLayout.WEST);
		p.add(center,BorderLayout.CENTER);
		
		JPanel westSouth=new JPanel();
		JPanel westCenter=new JPanel();
		
		west.setLayout(new BorderLayout());
		west.add(westSouth,BorderLayout.SOUTH);
		west.add(westCenter,BorderLayout.CENTER);
		
		westCenter.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridx=0;
		c.weightx=1;
		c.weighty=1;
		westCenter.add(e1,c);
		westCenter.add(e2,c);
		westCenter.add(e3,c);
		
		westSouth.setLayout(new GridBagLayout());
		westSouth.add(ok,c);
		
		center.setLayout(new GridBagLayout());
		c = new GridBagConstraints();
		c.weightx=1;
		c.gridx=0;
		c.weighty=1;
		for(JLabel res:result){
			center.add(res,c);
			if(result.indexOf(res)==result.size()/2-1){
				c.gridx=1;
			}
		}
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(dimension.width/2,dimension.height/2));
		this.pack();
		this.setVisible(true);
	}
	
}
