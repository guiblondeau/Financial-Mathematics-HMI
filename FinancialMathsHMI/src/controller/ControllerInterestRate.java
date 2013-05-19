package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import abstraction.Arguments;

public class ControllerInterestRate implements ActionListener,Observer {
	private Arguments arg;
	private JTextField interestRate;


	public ControllerInterestRate(Arguments arg, JTextField interestRate) {
		super();
		this.arg = arg;
		this.interestRate = interestRate;
		arg.addObserver(this);
		interestRate.addActionListener(this);
	}


	@Override
	public void update(Observable o, Object argu) {
		interestRate.setText(arg.getInterestRate()+"");
		if(interestRate.getText()!=null){
			ControllerSubmit.interestRateCompleted=true;
			ControllerSubmit.change();
		}
		else{
			ControllerSubmit.interestRateCompleted=true;
			ControllerSubmit.change();
		}
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		try{
			arg.setInterestRate(Double.parseDouble(this.interestRate.getText()));
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "Entrez une valeur réelle!", "Mauvais argument d'entrée", JOptionPane.ERROR_MESSAGE);
			interestRate.setText("");
			ControllerSubmit.interestRateCompleted=false;
			ControllerSubmit.change();
		}
	}
}
