package presentation;

import java.awt.*;
import java.util.LinkedList;

import javax.swing.*;

public class Window extends JFrame{
	//hesite pas à mettre des noms plus explicite
	
	private JPanel p=new JPanel();
	private JPanel west=new JPanel();
	private JPanel center=new JPanel();
	
	private JTextField actualValue=new JTextField("");
	private JTextField timeRemaining=new JTextField("");
	private JTextField strikePrice=new JTextField("");
	private JTextField interestRate = new JTextField("");
	private JTextField volatility = new JTextField();
	
	private JButton ok=new JButton("Submit");
	
	private JLabel call = new JLabel();
	private JLabel put = new JLabel();
	private JLabel deltaCall = new JLabel();
	private JLabel deltaPut = new JLabel();
	private JLabel gammaCall = new JLabel();
	private JLabel gammaPut = new JLabel();
	private JLabel thetaCall = new JLabel();
	private JLabel thetaPut = new JLabel();
	private JLabel vegaCall = new JLabel();
	private JLabel vegaPut = new JLabel();
	private JLabel rhoCall = new JLabel();
	private JLabel rhoPut = new JLabel();
	
	private Rectangle dimension=GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
	
	public Window() throws HeadlessException {
		super("Mais qu'est-ce que tu fais là, Quentin Noharet?");
		
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
		
		westCenter.setLayout(new GridLayout(5,0));
//		GridBagConstraints c = new GridBagConstraints();
//		c.gridx=0;
//		c.weightx=1;
//		c.weighty=1;
		
		JPanel panelActualValue = new JPanel();
		JLabel labelActualValue = new JLabel("Actual value s:");
		panelActualValue.add(labelActualValue);
		panelActualValue.add(actualValue);
		Double value1 = labelActualValue.getPreferredSize().getWidth();
		int valueInt1 = value1.intValue();
		actualValue.setPreferredSize(new Dimension(250-valueInt1,20));
		westCenter.add(panelActualValue);
		
		JPanel panelTimeRemaining = new JPanel();
		JLabel labelTimeRemaining = new JLabel("Time Remaining T : ");
		panelTimeRemaining.add(labelTimeRemaining);
		panelTimeRemaining.add(timeRemaining);
		Double value2 = labelTimeRemaining.getPreferredSize().getWidth();
		int valueInt2 = value2.intValue();
		timeRemaining.setPreferredSize(new Dimension(250-valueInt2,20));
		westCenter.add(panelTimeRemaining);
		
		JPanel panelStrikePrice = new JPanel();
		JLabel labelStrikePrice = new JLabel("Strike price K : ");
		panelStrikePrice.add(labelStrikePrice);
		panelStrikePrice.add(strikePrice);
		Double value3 = labelStrikePrice.getPreferredSize().getWidth();
		int valueInt3 = value3.intValue();
		strikePrice.setPreferredSize(new Dimension(250-valueInt3,20));
		westCenter.add(panelStrikePrice);
		
		JPanel panelInterestRate = new JPanel();
		JLabel labelInterestRate = new JLabel("Interest rate r : ");
		panelInterestRate.add(labelInterestRate);
		panelInterestRate.add(interestRate);
		Double value4 = labelInterestRate.getPreferredSize().getWidth();
		int valueInt4 = value4.intValue();
		interestRate.setPreferredSize(new Dimension(250-valueInt4,20));
		westCenter.add(panelInterestRate);
		
		JPanel panelVolatility = new JPanel();
		JLabel labelVolatility = new JLabel("Volatility : "); 
		panelVolatility.add(labelVolatility);
		panelVolatility.add(volatility);
		Double value5 = labelVolatility.getPreferredSize().getWidth();
		int valueInt5 = value5.intValue();
		volatility.setPreferredSize(new Dimension(250-valueInt5,20));
		westCenter.add(panelVolatility);
		
		
		westSouth.setLayout(new GridBagLayout());
		westSouth.add(ok);
		
		center.setLayout(new GridLayout(6,2));
		JPanel panelCall = new JPanel();
		JLabel labelCall = new JLabel("Call : ");
		panelCall.add(labelCall);
		panelCall.add(call);
		center.add(panelCall);
		
		JPanel panelPut = new JPanel();
		JLabel labelPut = new JLabel("Put : ");
		panelPut.add(labelPut);
		panelPut.add(put);
		center.add(panelPut);
		
		JPanel panelDeltaCall = new JPanel();
		JLabel labelDeltaCall = new JLabel("Delta call : ");
		panelDeltaCall.add(labelDeltaCall);
		panelDeltaCall.add(deltaCall);
		center.add(panelDeltaCall);
		
		JPanel panelDeltaPut = new JPanel();
		JLabel labelDeltaPut = new JLabel("Delta Put : ");
		panelDeltaPut.add(labelDeltaPut);
		panelDeltaPut.add(deltaPut);
		center.add(panelDeltaPut);
		
		JPanel panelGammaCall = new JPanel();
		JLabel labelGammeCall = new JLabel("Gamma Call : ");
		panelGammaCall.add(labelGammeCall);
		panelGammaCall.add(gammaCall);
		center.add(panelGammaCall);
		
		JPanel panelGammaPut = new JPanel();
		JLabel labelGammaPut = new JLabel("Gamma Put : ");
		panelGammaPut.add(labelGammaPut);
		panelGammaPut.add(gammaPut);
		center.add(panelGammaPut);
		
		JPanel panelThetaCall = new JPanel();
		JLabel labelThetaCall = new JLabel("Theta Call : ");
		panelThetaCall.add(labelThetaCall);
		panelThetaCall.add(thetaCall);
		center.add(panelThetaCall);
		
		JPanel panelThetaPut = new JPanel();
		JLabel labelThetaPut = new JLabel("Theta Put : ");
		panelThetaPut.add(labelThetaPut);
		panelThetaPut.add(thetaPut);
		center.add(panelThetaPut);
		
		JPanel panelVegaCall = new JPanel();
		JLabel labelVegaCall = new JLabel("Vega Call : ");
		panelVegaCall.add(labelVegaCall);
		panelVegaCall.add(vegaCall);
		center.add(panelVegaCall);
		
		JPanel panelVegaPut = new JPanel();
		JLabel labelVegaPut = new JLabel("Vega Put : ");
		panelVegaPut.add(labelVegaPut);
		panelVegaPut.add(vegaPut);
		center.add(panelVegaPut);
		
		JPanel panelRhoCall = new JPanel();
		JLabel labelRhoCall = new JLabel("Rho Call : ");
		panelRhoCall.add(labelRhoCall);
		panelRhoCall.add(rhoCall);
		center.add(panelRhoCall);
		
		JPanel panelRhoPut = new JPanel();
		JLabel labelRhoPut = new JLabel("Rho Put : ");
		panelRhoPut.add(labelRhoPut);
		panelRhoPut.add(rhoPut);
		center.add(panelRhoPut);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(dimension.width/2,dimension.height/2));
		this.pack();
		this.setVisible(true);
	}
	
}
