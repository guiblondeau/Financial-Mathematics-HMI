package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import abstraction.Arguments;

public class ControllerVolatility implements ActionListener,Observer{
	private Arguments arg;
	private JTextField volatility;
	public ControllerVolatility(Arguments arg, JTextField volatility) {
		super();
		this.arg = arg;
		this.volatility = volatility;
		arg.addObserver(this);
		volatility.addActionListener(this);
	}


	@Override
	public void update(Observable o, Object argu) {
		volatility.setText(arg.getVolatility()+"");
		if(volatility.getText()!=null){
			ControllerSubmit.volatilityCompleted=true;
			ControllerSubmit.change();
		}
		else{
			ControllerSubmit.volatilityCompleted=true;
			ControllerSubmit.change();
		}
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		try{
			arg.setVolatility(Double.parseDouble(this.volatility.getText()));
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "Entrez une valeur réelle!", "Mauvais argument d'entrée", JOptionPane.ERROR_MESSAGE);
			volatility.setText("");
			ControllerSubmit.volatilityCompleted=false;
			ControllerSubmit.change();
		}
	}
}