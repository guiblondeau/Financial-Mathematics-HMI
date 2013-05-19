package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import abstraction.Arguments;

public class ControllerActualValue implements Observer, ActionListener{

	private Arguments arg;
	private JTextField actualValue;

	public ControllerActualValue(Arguments arg, JTextField actualValue) {
		super();
		this.arg = arg;
		arg.addObserver(this);
		this.actualValue = actualValue;
		actualValue.addActionListener(this);
	}


	@Override
	public void update(Observable o, Object argu) {
		actualValue.setText(arg.getActualValue()+"");
		if(actualValue.getText()!=null){
			ControllerSubmit.actualValueCompleted=true;
			ControllerSubmit.change();
		}
		else{
			ControllerSubmit.actualValueCompleted=true;
			ControllerSubmit.change();
		}
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		try{
			arg.setActualValue(Double.parseDouble(this.actualValue.getText()));
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "Entrez une valeur réelle!", "Mauvais argument d'entrée", JOptionPane.ERROR_MESSAGE);
			actualValue.setText("");
			ControllerSubmit.actualValueCompleted=false;
			ControllerSubmit.change();

		}
	}
}