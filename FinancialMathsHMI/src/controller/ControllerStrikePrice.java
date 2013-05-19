package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import abstraction.Arguments;

public class ControllerStrikePrice implements ActionListener,Observer{
	private Arguments arg;
	private JTextField strikePrice;

	public ControllerStrikePrice(Arguments arg, JTextField strikePrice) {
		super();
		this.arg = arg;
		this.strikePrice = strikePrice;
		arg.addObserver(this);
		strikePrice.addActionListener(this);
	}


	@Override
	public void update(Observable o, Object argu) {
		strikePrice.setText(arg.getStrikePrice()+"");
		if(strikePrice.getText()!=null){
			ControllerSubmit.strikePriceCompleted=true;
			ControllerSubmit.change();
		}
		else{
			ControllerSubmit.strikePriceCompleted=true;
			ControllerSubmit.change();
		}
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		try{
			arg.setStrikePrice(Double.parseDouble(this.strikePrice.getText()));
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "Entrez une valeur réelle!", "Mauvais argument d'entrée", JOptionPane.ERROR_MESSAGE);
			strikePrice.setText("");
			ControllerSubmit.strikePriceCompleted=false;
			ControllerSubmit.change();
		}
	}
}